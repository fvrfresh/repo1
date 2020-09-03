package com.athome.utils;

import com.athome.domain.Article;
import com.athome.integration.service.FileService;
import com.athome.web.AdminController;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.commonmark.Extension;
import org.commonmark.ext.gfm.strikethrough.StrikethroughExtension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableHead;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.node.Image;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @ClassName ArticleUtil
 * @Description TODO
 * @Author zhang
 * @Date 2020/8/15 16:52
 * @Version 1.0
 */
@Component
public class ArticleUtil implements EnvironmentAware {

    public static final String BASE_DIR = "/articles/";
    private static Environment env;


    @Override
    @Autowired
    public void setEnvironment(Environment environment) {
        ArticleUtil.env = environment;
    }


    public static String getUserHome() {
        return env.getProperty("user.home");

    }

    public static Article buildArticle(Article article) {

        String articleFileContent = getArticleFileContent(article);
        article.setContent(articleFileContent);
        return article;
    }
    public static Article buildArticleHtml(Article article) {
        String articleFileContent = article.getContent();
        if (article.getHtmlString() == null) {
            article.setHtmlString(markdownToHTML(articleFileContent));
        }
        return article;
    }

    public static String getArticleFileContent(Article article) {
        InputStream articleResource = null;
        BufferedReader reader = null;
        try {

            articleResource = new FileInputStream(new File(getUserHome() + BASE_DIR + article.getCategory() + File.separator + article.getContent()));
            reader = new BufferedReader(new InputStreamReader(articleResource));
            String articleContent = reader.lines().collect(Collectors.joining("\n"));
            return articleContent;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (articleResource != null) {
                try {
                    articleResource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 将markdown字符串转换为html字符串
     *
     * @param markdown content in markdown format
     * @return
     */
    public static String markdownToHTML(String markdown) {
        List<Extension> extensions = Arrays.asList(TablesExtension.create(), StrikethroughExtension.create());
        Parser parser = Parser
                .builder()
                .extensions(extensions)
                .build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer
                .builder()
                .attributeProviderFactory(new AttributeProviderFactory() {
                    @Override
                    public AttributeProvider create(AttributeProviderContext attributeProviderContext) {
                        return new TableAttributeProvider();
                    }
                })
                .extensions(extensions)
                .build();
        return renderer.render(document);
    }

    public static String markdownToHTML(InputStream markdown) {
        List<Extension> extensions = Arrays.asList(TablesExtension.create(),StrikethroughExtension.create());
        Parser parser = Parser
                .builder()
                .extensions(extensions)
                .build();
        Node document = null;
        try {
            document = parser.parseReader(new InputStreamReader(markdown));
        } catch (FileNotFoundException e) {
            System.out.println("markdown file doesn't exist");
        } catch (IOException e) {
            e.printStackTrace();
        }
        HtmlRenderer renderer = HtmlRenderer
                .builder()
                .extensions(extensions)
                .build();
        return renderer.render(document);
    }

    public static String hanziToPin(String hanziStr) {
        Pattern p = Pattern.compile("(\\w*)|(\\p{Punct}*)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(hanziStr);
        if (matcher.matches()) {
            return "";
        }
        List<String> pingyinStrs = new ArrayList<>();
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        // UPPERCASE：大写  (ZHONG)
        // LOWERCASE：小写  (zhong)
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);//输出大写

        // WITHOUT_TONE：无音标  (zhong)
        // WITH_TONE_NUMBER：1-4数字表示音标  (zhong4)
        // WITH_TONE_MARK：直接用音标符（必须WITH_U_UNICODE否则异常）  (zhòng)
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

        // WITH_V：用v表示ü  (nv)
        // WITH_U_AND_COLON：用"u:"表示ü  (nu:)
        // WITH_U_UNICODE：直接用ü (nü)
        format.setVCharType(HanyuPinyinVCharType.WITH_V);
        char[] chars = hanziStr.toCharArray();
        System.out.println("=========================");
        System.out.println(chars);
        System.out.println("=========================");
        try {
            for (char aChar : chars) {
                String str = String.valueOf(aChar);
                if (Pattern.matches("(\\w)|(\\p{Punct})", str)) {
                    pingyinStrs.add(str);
                    continue;
                }
                String[] pStrs = PinyinHelper.toHanyuPinyinStringArray(aChar, format);
                String s = Arrays.stream(pStrs).collect(Collectors.joining());
                pingyinStrs.add(s);
            }
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }
        return pingyinStrs.stream().collect(Collectors.joining(""));
    }

    public static String formatTime(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(date.getTime());
        return String.format("%1$tY/%1$tm/%1$te %1$tT",instance);
    }


    static class TableAttributeProvider implements AttributeProvider {
        @Override
        public void setAttributes(Node node, String tagName, Map<String, String> attributes) {
            if (node instanceof TableBlock) {
                attributes.put("class", "table table-hover");
            }
            if (node instanceof TableHead) {
                attributes.put("class", "thead-dark");
            }
        }
    }
}
