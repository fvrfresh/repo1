import redis.clients.jedis.Jedis;
import redis.clients.jedis.ZParams;

import java.util.*;


public class RedisMain {


    private static final int ONE_WEEK_IN_SECONDS = 7 * 86400;
    private static final int VOTE_SCORE = 432;
    private static final int ARTICLES_PER_PAGE = 25;

    public static void main(String[] args) {
        RedisMain main = new RedisMain();
        main.run();
    }

    public void article_vote(Jedis redis, String user, String article){
        long interval = System.currentTimeMillis() / 1000 - ONE_WEEK_IN_SECONDS;
        if (redis.zscore("time", article) < interval){
            return;
        }
        String article_id = article.substring(article.indexOf(":") + 1);
        if (redis.sadd("voted:" + article_id, user) == 1){
            redis.zincrby("score:", VOTE_SCORE, article);
            redis.hincrBy(article, "votes", 1);
        }

    }

    public String post_article(Jedis redis, String user, String title, String link){
        String article_id = String.valueOf(redis.incr("article:"));
        String voted = "voted:" + article_id;
        redis.sadd(voted, user);
        redis.expire(voted, ONE_WEEK_IN_SECONDS);
        Long now = System.currentTimeMillis() / 1000;
        String article = "article:" + article_id;
        Map<String, String> map = new HashMap<>();
        map.put("title", title);
        map.put("link", link);
        map.put("poster", user);
        map.put("time", now.toString());
        map.put("votes", "1");
        redis.hmset(article, map);
        redis.zadd("score:", Double.parseDouble(String.valueOf(now + VOTE_SCORE)),article);
        redis.zadd("time", now, article);
        return article_id;
    }

    public List<Map<String, String>> getArticles(Jedis redis, int page){
        return getArticles(redis, page, "score:");
    }
    public List<Map<String, String>> getArticles(Jedis redis, int page, String score){
        int start = (page -1) * ARTICLES_PER_PAGE;
        int end = start + ARTICLES_PER_PAGE - 1;
        Set<String> ids = redis.zrevrange(score, start, end);
        List<Map<String,String>> articles = new ArrayList<Map<String, String>>();
        for (String id : ids){
            Map<String,String> article_data = redis.hgetAll(id);
            article_data.put("id", id);
            articles.add(article_data);
        }
        return articles;
    }

    public void addGroups(Jedis redis, String article_id, String[] toAdd){
        String article = "article:" + article_id;
        for (String group : toAdd){
            redis.sadd("group:" + group, article);
        }
    }
    public List<Map<String,String>> getGroupArticles(Jedis redis, String group, int page){
        return getGroupArticles(redis, group, page, "score:");
    }

    public List<Map<String,String>> getGroupArticles(Jedis redis, String group, int page, String score){
        String key = score + group;
        if (!redis.exists(key)){
            ZParams params = new ZParams().aggregate(ZParams.Aggregate.MAX);
            redis.zinterstore(key,params,"group:" + group, score);
            redis.expire(key, 60);
        }
        return getArticles(redis, page, key);
    }

    public void run(){
        Jedis redis = new Jedis("localhost", 6379);
        redis.auth(String.valueOf(123456));
        String articleId = post_article(redis, "username", "A title", "http://www.google.com");
        System.out.println("We posted a new article with id: " + articleId);
        System.out.println("Its HASH looks like:");
        Map<String,String> articleData = redis.hgetAll("article:" + articleId);
        for (Map.Entry<String, String> entry : articleData.entrySet()) {
            System.out.println(" " + entry.getKey() + ":" + entry.getValue());
        }
        System.out.println();
        article_vote(redis, "other_user", "article:" + articleId);
        String votes = redis.hget("article:" + articleId, "votes");
        System.out.println("We voted for the article, it now has votes: " + votes);
        assert Integer.parseInt(votes) > 1;
        System.out.println("The currently highest-scoring articles are:");
        List<Map<String,String>> articles = getArticles(redis, 1);
        printArticles(articles);
        assert articles.size()>=1;
        addGroups(redis, articleId,new String[]{"new-group"});
        System.out.println("We added the article to a new group, other articles include:");
        articles = getGroupArticles(redis, "new-group", 1);
        printArticles(articles);
        assert articles.size()>=1;

    }

    private void printArticles(List<Map<String,String>> articles){
        for (Map<String,String> article : articles){
            System.out.println("  id: " + article.get("id"));
            for (Map.Entry<String,String> entry : article.entrySet()){
                if (entry.getKey().equals("id")){
                    continue;
                }
                System.out.println("    " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }

}
