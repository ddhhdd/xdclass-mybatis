package net.xdclass.online_class.domain;

import lombok.Data;

import java.util.Date;

/**
 *
 * @author ddhhdd
 * @date 2020/10/22 22:16
 */
@Data
public class VideoOrder {
    /**
     * 视频订单自增id
     */
    private Integer id;
    /**
     * 订单唯一标识
     */
    private String outTradeNo;
    /**
     * 0表示未支付，1表示已支付
     */
    private Integer state;
    /**
     * 订单生成时间
     */
    private Date createTime;
    /**
     * 支付金额，单位分
     */
    private Integer totalFee;
    /**
     * 视频主键
     */
    private Integer videoId;
    /**
     * 视频标题
     */
    private String videoTitle;
    /**
     * 视频图片
     */
    private String videoImg;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 订单与用户是1:1关系
     */
    private User user;
}
