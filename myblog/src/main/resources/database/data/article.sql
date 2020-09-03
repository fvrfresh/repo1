insert into article(title, content, createdAt,category) VALUES ('default_post','default_post.md','2020-8-14 21:59','programming');

desc article;


select  * from article;

select id, title, content, createdAt,description from article order by createdAt desc limit 0,3;

update article set article.description='用于测试的默认博博文文用于测试的默认' where id=1;
update article set article.description='用于测试的博文博文薄用于测试的默认1' where id=2;
update article set article.description='用于测试的默认博博文文用于测试的默认2' where id=3;
update article set article.description='用于测试的默认博文博文用于测试的默认3' where id=4;
update article set article.description='用于测试的默认博文博文用于测试的默认4' where id=5;

insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post1','deleted_post1.md','2020-8-01 21:59','programming','用于测试回收站的默认博博文文用于测试的默认2','2020-1-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post2','deleted_post2.md','2020-8-02 21:59','programming','用于测试回收站的默认博博文文用于测试的默认2','2020-2-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post3','deleted_post3.md','2020-8-03 21:59','programming','用于测试回收站的默认博博文文用于测试的默认2','2020-3-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post4','deleted_post4.md','2020-8-04 21:59','travel','用于测试回收站的默认博博文文用于测试的默认2','2020-4-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post5','deleted_post5.md','2020-8-05 21:59','thinking','用于测试回收站的默认博博文文用于测试的默认2','2020-5-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post6','deleted_post6.md','2020-8-06 21:59','programming','用于测试回收站的默认博博文文用于测试的默认2','2020-6-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post7','deleted_post7.md','2020-8-07 21:59','hometown','用于测试回收站的默认博博文文用于测试的默认2','2020-7-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post8','deleted_post8.md','2020-8-08 21:59','programming','用于测试回收站的默认博博文文用于测试的默认2','2020-8-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post9','deleted_post9.md','2020-8-09 21:59','programming','用于测试回收站的默认博博文文用于测试的默认2','2020-9-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post10','deleted_post10.md','2020-8-10 21:59','thinking','用于测试回收站的默认博博文文用于测试的默认2','2020-10-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post11','deleted_post11.md','2020-8-11 21:59','hometown','用于测试回收站的默认博博文文用于测试的默认2','2020-11-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post12','deleted_post12.md','2020-8-12 21:59','programming','用于测试回收站的默认博博文文用于测试的默认2','2020-12-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post13','deleted_post13.md','2020-8-13 21:59','hometown','用于测试回收站的默认博博文文用于测试的默认2','2019-1-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post14','deleted_post14.md','2020-8-14 11:59','programming','用于测试回收站的默认博博文文用于测试的默认2','2018-2-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post15','deleted_post15.md','2020-8-15 12:59','travel','用于测试回收站的默认博博文文用于测试的默认2','2017-2-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post16','deleted_post16.md','2020-8-15 12:59','travel','用于测试回收站的默认博博文文用于测试的默认2','2016-2-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post17','deleted_post17.md','2020-8-15 12:59','programming','用于测试回收站的默认博博文文用于测试的默认2','2015-2-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post18','deleted_post18.md','2020-8-15 12:59','programming','用于测试回收站的默认博博文文用于测试的默认2','2014-2-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post19','deleted_post19.md','2020-8-15 12:59','travel','用于测试回收站的默认博博文文用于测试的默认2','2013-2-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post20','deleted_post20.md','2020-8-15 12:59','programming','用于测试回收站的默认博博文文用于测试的默认2','2012-2-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post21','deleted_post21.md','2020-8-15 12:59','hometown','用于测试回收站的默认博博文文用于测试的默认2','2011-2-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post22','deleted_post22.md','2020-8-15 12:59','thinking','用于测试回收站的默认博博文文用于测试的默认2','2010-2-12 20:12:22');
insert into article_deleted(title, content, createdAt,category,description,deletedAt) VALUES ('deleted_post23','deleted_post23.md','2020-8-15 12:59','programming','用于测试回收站的默认博博文文用于测试的默认2','2009-2-12 20:12:22');

insert into article(title, content, createdAt,category,description) VALUES ('postForDeletion1','postForDeletion1.md','2020-7-15 12:59','programming','用于测试*删除*的默认博博文文用于测试的默认1');
insert into article(title, content, createdAt,category,description) VALUES ('postForDeletion2','postForDeletion2.md','2020-6-15 12:59','programming','用于测试*删除*的默认博博文文用于测试的默认2');
insert into article(title, content, createdAt,category,description) VALUES ('postForDeletion3','postForDeletion3.md','2020-5-15 12:59','programming','用于测试*删除*的默认博博文文用于测试的默认3');
insert into article(title, content, createdAt,category,description) VALUES ('postForDeletion4','postForDeletion4.md','2020-4-15 12:59','programming','用于测试*删除*的默认博博文文用于测试的默认4');
insert into article(title, content, createdAt,category,description) VALUES ('postForDeletion5','postForDeletion5.md','2020-3-15 12:59','programming','用于测试*删除*的默认博博文文用于测试的默认5');
insert into article(title, content, createdAt,category,description) VALUES ('postForDeletion6','postForDeletion6.md','2020-2-15 12:59','programming','用于测试*删除*的默认博博文文用于测试的默认6');
insert into article(title, content, createdAt,category,description) VALUES ('postForDeletion7','postForDeletion7.md','2020-1-15 12:59','programming','用于测试*删除*的默认博博文文用于测试的默认7');
insert into article(title, content, createdAt,category,description) VALUES ('postForDeletion8','postForDeletion8.md','2019-12-15 12:59','programming','用于测试*删除*的默认博博文文用于测试的默认8');

delete from article_deleted;
alter table article_deleted
modify column title varchar(255) not null;

select  id, title, content, createdAt, htmlString, category, description, deletedAt from article_deleted where title = 'deleted_post9';

desc article_deleted;

update article set title='上传测试' where id=106;

select * from article where category='hometown';

alter table article add index title_idx(title);

show index from article;

create table if not exists article_deleted
(
    id int auto_increment,
    title varchar(255) not null,
    content text null not  null ,
    createdAt timestamp not null,
    htmlString text,
    category varchar (255) not null,
    description varchar(255) not null,
    constraint article_pk
        primary key (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

create unique index article_deleted_title_uindex
    on article (title);

select count('id') from article;

insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('zhangsan','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','secondTitle','2020-8-24 20:12:32');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('lisi','写的什么玩意儿，退钱退钱','12345672qq.com','http://localhost:8080','test_post14','2020-8-19 20:20:00');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('wangwu','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','test_post13','2020-8-17 20:12:32');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('zhangletian','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','test_post12','2020-8-25 20:12:32');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('libai','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','test_post11','2020-8-26 20:12:32');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('luyiming','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','test_post10','2020-8-27 20:12:32');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('zhangyiming','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','test_post9','2020-8-28 20:12:32');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('liyanhong','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','test_post8','2020-8-29 20:12:32');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('leijun','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','test_post7','2020-8-30 20:12:32');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('liuqiangdong','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','secondTitle','2020-8-31 20:12:32');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('yancai','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','test_post13','2020-9-01 20:12:32');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('zhangliangying','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','secondTitle','2020-9-02 20:12:32');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('wangwei','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','test_post14','2020-9-03 20:12:32');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('wangbo','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','test_post14','2020-9-10 20:12:32');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('huangfeihong','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','secondTitle','2020-9-12 20:12:32');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('guanyu','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','test_post6','2020-9-13 20:12:32');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('zhangfei','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','test_post12','2020-9-14 20:12:32');
insert into comments(username, content, email, website, articleTitle, createdAt) VALUES ('liubei','写的不错啊，多多益善','12345672qq.com','http://localhost:8080','test_post12','2020-9-15 20:12:32');
insert into comments(username, content, email, website, articleTitle, replying,createdAt) VALUES ('guanyu','关羽回复张三的话话话话话','12345672qq.com','http://localhost:8080','secondTitle','zhangsan','2020-8-24 23:12:32');
insert into comments(username, content, email, website, articleTitle, replying,createdAt) VALUES ('lisi','李四回复张三的话话话话话','12345672qq.com','http://localhost:8080','secondTitle','zhangsan','2020-8-25 20:12:32');
insert into comments(username, content, email, website, articleTitle, replying,createdAt) VALUES ('zhangletian','张乐天回复关羽的话话话话话','12345672qq.com','http://localhost:8080','secondTitle','guanyu','2020-8-25 22:12:32');
insert into comments(username, content, email, website, articleTitle, replying,createdAt) VALUES ('zhangletian','张乐天回复张三的话话话话话','12345672qq.com','http://localhost:8080','secondTitle','lisi','2020-8-26 20:12:32');
insert into comments(username, content, email, website, articleTitle, replying,createdAt) VALUES ('wangwu','王五回复张乐天的话话话话话','12345672qq.com','http://localhost:8080','test_post12','zhangletian','2020-9-13 20:20:32');
insert into comments(username, content, email, website, articleTitle, replying,createdAt) VALUES ('wangwu','王五回复李白的话话话话话','12345672qq.com','http://localhost:8080','test_post11','libai','2020-9-13 20:30:32');
insert into comments(username, content, email, website, articleTitle, replying,createdAt) VALUES ('luyiming','卢一鸣回复王五的话话话话话','12345672qq.com','http://localhost:8080','test_post13','wangwu','2020-9-14 20:12:32');
insert into comments(username, content, email, website, articleTitle, replying,createdAt) VALUES ('luyiming','卢一鸣回复张一鸣的话话话话话','12345672qq.com','http://localhost:8080','test_post9','zhangyiming','2020-9-15 20:12:32');
insert into comments(username, content, email, website, articleTitle, replying,createdAt) VALUES ('leijun','雷军回复李彦宏的话话话话话','12345672qq.com','http://localhost:8080','test_post8','liyanhong','2020-9-16 20:12:32');
insert into comments(username, content, email, website, articleTitle, replying,createdAt) VALUES ('yancai','艳彩回复雷军的话话话话话','12345672qq.com','http://localhost:8080','test_post7','leijun','2020-9-17 20:12:32');
insert into comments(username, content, email, website, articleTitle, replying,createdAt) VALUES ('liubei','刘备回复关羽的话话话话话','12345672qq.com','http://localhost:8080','test_post6','guanyu','2020-9-18 20:12:32');
insert into comments(username, content, email, website, articleTitle, replying,createdAt) VALUES ('liyanhong','李彦宏回复雷军的话话话话话','12345672qq.com','http://localhost:8080','test_post8','leijun','2020-9-19 20:12:32');
insert into comments(username, content, email, website, articleTitle, replying,createdAt) VALUES ('guanyu','关于回复张飞的话话话话话','12345672qq.com','http://localhost:8080','test_post12','zhangfei','2020-9-20 20:12:32');

desc comments;

select username,content,email,website,createdAt,articleTitle from comments where articleTitle="secondTitle" and replying is null order by createdAt asc limit 0,2

select username,content,email,website,createdAt from comments where replying = 'zhangsan' and articleTitle = 'secondTitle'

delete from comments where id >= 38;

select  * from comments;
select username,content,email,website,createdAt,articleTitle from comments where articleTitle='secondTitle' and replying is null order by createdAt asc limit 0,4;

show create table quotes;

show index from tags;

desc tags;
select distinct tag from tags;
select id,tag,concat(article_title) from tags group by tag;
select category,count(title) from article group by category;

insert into album(logoFile)
select distinct logoFile from article;

select distinct a.logoFile, b.category from article a left join album b on a.logoFile = b.logoFile;
truncate articles_featured;