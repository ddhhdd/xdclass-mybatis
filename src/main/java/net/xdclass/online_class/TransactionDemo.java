package net.xdclass.online_class;

import net.xdclass.online_class.dao.VideoMapper;
import net.xdclass.online_class.domain.Video;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ddhhdd
 */
public class TransactionDemo {

    public static void main(String[] args) throws IOException {
        String resource = "config/mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取session
        /*
        如果参数设置为true，则不需要sqlSession.commit();可以看源码，该参数表示是否自动commit；
         */
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);

            // 新增一条video记录
            Video video = new Video();
            video.setTitle("小滴课堂面试专题900道2020年10月23日1551");
            video.setCoverImg("xdclass.net/aaa.png");
            video.setPoint(9.4);
            /*
             1. 日期格式化，DateTimeFormatter线程安全，与LocalDateTime结合使用；
             2. 解决相差8小时问题：数据库字段要为varchar类型，pojo为String类型；
             3. sql格式化函数DATE_FORMAT()在select中可生效，在insert语句中报语法错误；（2020年10月25日21:47:29-ddh）
             */
            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            video.setCreateTime(dtf.format(dateTime));

            video.setPrice(9900);
            video.setSummary("这个是面试专题概要");
            int rows = videoMapper.add(video);
            // 如果autoCommit参数设置为true，则不需要手动commit了；
            // sqlSession.commit();
            System.out.println(rows);
            System.out.println(video.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.close();
    }
}
