package net.xdclass.online_class.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * 视频类
 *
 * @author ddhhdd
 */
@Data
@Table(name = "video")
public class Video implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    /**
     * 视频标题
     */
    private String title;
    /**
     * 概述
     */
    private String summary;
    /**
     * 封面图
     */
    private String coverImg;
    /**
     * 价格,分
     */
    @Column(name = "price")
    private Integer price;
    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String createTime;
    /**
     * 评分默认8.7，最高10分
     */
    private Double point;
    /**
     * 子分类id
     */
    private Integer cId;
}
