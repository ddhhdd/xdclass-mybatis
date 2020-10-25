package net.xdclass.online_class;

import net.xdclass.online_class.dao.VideoMapper;
import net.xdclass.online_class.domain.User;
import net.xdclass.online_class.domain.Video;
import net.xdclass.online_class.domain.VideoOrder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SqlSessionDemo {

    public static void main(String[] args) throws IOException {
        String resource = "config/mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取session
        try {
            SqlSession sqlSession = sqlSessionFactory.openSession();
            VideoMapper videoMapper = sqlSession.getMapper(VideoMapper.class);

//            // 通过video_id查询
//            Video video = videoMapper.selectById(40);
//            System.out.println(video.toString());

//            // 验证Mybatis一级缓存
//            for (int i = 0; i < 2; i++) {
//                Video video = videoMapper.selectById(40);
//                System.out.println(video.toString());
//            }

//            // 通过video_id查询，使用resultMap
//            Video video = videoMapper.selectBasedFieldByIdWithResultMap(40);
//            System.out.println(video.toString());

//            // 查询视频订单列表
//            List<VideoOrder> videoOrderList = videoMapper.queryVideoOrderList();
//            System.out.println(videoOrderList);

            // 查询视频订单列表（懒加载，即按需加载）
            List<VideoOrder> videoOrderList = videoMapper.queryVideoOrderListLazy();
            System.out.println(videoOrderList.size());

            for (VideoOrder videoOrder : videoOrderList) {
                System.out.println(videoOrder.getVideoTitle());
//                System.out.println(videoOrder.getUser().getName());
            }


//            // 查询用户订单列表
//            List<User> userList = videoMapper.queryUserOrder();
//            System.out.println(userList);

//
//            // 通过注解查询
//            List<Video> videoList = videoMapper.selectList();
//            System.out.println(videoList.toString());

//            // 多参数查询
//            List<Video> videos = videoMapper.selectByPointAndTitleLike(8.7,"CSS");
//            System.out.println(videos.toString());

            // 新增一条video记录
//            Video video = new Video();
//            video.setTitle("小滴课堂面试专题900道2020年10月23日1551");
//            video.setCoverImg("xdclass.net/aaa.png");
//            video.setPoint(9.4);
//            video.setCreateTime(new Date());
//            video.setPrice(9900);
//            video.setSummary("这个是面试专题概要");
//            int rows = videoMapper.add(video);
//            System.out.println(rows);
//            System.out.println(video.toString());

//            // 批量新增video记录
//            List<Video> videoList = new ArrayList<>();
//            Video video1 = new Video();
//            Video video2 = new Video();
//            video1.setTitle("小滴课堂面试专题900道111");
//            video1.setCoverImg("xdclass.net/aaa.png");
//            video1.setPoint(9.4);
//            video1.setCreateTime(new Date());
//            video1.setPrice(9900);
//            video1.setSummary("这个是面试专题概要111");
//            video2.setTitle("小滴课堂面试专题900道222");
//            video2.setCoverImg("xdclass.net/aaa.png");
//            video2.setPoint(9.4);
//            video2.setCreateTime(new Date());
//            video2.setPrice(9900);
//            video2.setSummary("这个是面试专题概要222");
//            videoList.add(video1);
//            videoList.add(video2);
//            int rows1 = videoMapper.addBatch(videoList);
//            System.out.println(rows1);
//            System.out.println(videoList.toString());

//            // 更新Video
//            Video video = new Video();
//            video.setId(51);
//            video.setTitle("小滴课堂面试专题900道-update");
//            videoMapper.updateVideo(video);
//            System.out.println(video.toString());

//            // 选择性更新Video
//            Video video = new Video();
//            video.setId(49);
//            video.setTitle("小滴课堂面试专题900道-update");
//            videoMapper.updateVideoSelective(video);
//            System.out.println(video.toString());

//            // 根据crate_time和price删除Video
//            Map<String, Object> map = new HashMap<>();
//            map.put("createTime","2020-10-21 01:22:42");
//            map.put("price",10000);
//            videoMapper.deleteByCreateTimeAndPrice(map);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
