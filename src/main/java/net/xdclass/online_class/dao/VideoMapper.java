package net.xdclass.online_class.dao;

import net.xdclass.online_class.domain.User;
import net.xdclass.online_class.domain.Video;
import net.xdclass.online_class.domain.VideoOrder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author ddhhdd
 */
public interface VideoMapper extends Mapper<Video> {


    /**
     * 根据视频id查找视频对象
     *
     * @param videoId
     * @return
     */
    // @Param("video_id")，给参数取别名，如果是多个参数，不取别名的话会找不到（一个参数可能不会出错）
    Video selectById(@Param("video_id") int videoId);

    /**
     * 视频列表
     *
     * @return
     */
    // 如果sql简单，没有过多的表关联，则用注解相对简单
    @Select("select * from video")
    List<Video> selectList();

    /**
     * 根据评分和标题模糊查询
     *
     * @param point
     * @param title
     * @return
     */
    // 多个参数的情况下，如果不取别名，则会找不到
    List<Video> selectByPointAndTitleLike(@Param("point") double point, @Param("title") String title);

    /**
     * 新增video
     *
     * @param video
     * @return
     */
    int add(Video video);

    /**
     * 批量插入Video
     *
     * @param videoList
     * @return
     */
    int addBatch(List<Video> videoList);

    /**
     * 更新视频
     * (注意这里传的是Video，而不是id，所以通常情况下这么做就行了)
     *
     * @param video
     * @return
     */
    int updateVideo(Video video);

    /**
     * 选择性更新Video
     *
     * @param video
     * @return
     */
    int updateVideoSelective(Video video);

    /**
     * 根据crate_time和price删除Video
     *
     * @param map
     * @return
     */
    int deleteByCreateTimeAndPrice(Map<String, Object> map);

    /**
     * 根据视频id查找视频对象，使用resultMap
     *
     * @param videoId
     * @return
     */
    Video selectBasedFieldByIdWithResultMap(@Param("video_id") int videoId);

    /**
     * 查找视频订单列表
     * @return
     */
    List<VideoOrder> queryVideoOrderList();

    /**
     * 查找视频订单列表（懒加载，即按需加载）
     * @return
     */
    List<VideoOrder> queryVideoOrderListLazy();

    /**
     * 查询用户订单列表
     * @return
     */
    List<User> queryUserOrder();

}
