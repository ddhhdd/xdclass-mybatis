package net.xdclass.online_class.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 *
 * @author ddhhdd
 * @date 2020/10/22 22:29
 */
@Data
public class User {
    /**
     * 自增主键
     */
    private Integer id;
    /**
     * 昵称
     */
    private String name;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 头像
     */
    private String headImg;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 用户与订单是1：N关系
     */
    private List<VideoOrder> videoOrderList;
}
