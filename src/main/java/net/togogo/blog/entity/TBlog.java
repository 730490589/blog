package net.togogo.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author HB
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_blog")
public class TBlog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 博客标题
     */
    private String title;

    /**
     * 博客摘要信息
     */
    private String summary;

    /**
     * 博客发布时间
     */
    @TableField("releaseDate")
    private Date releaseDate;

    /**
     * 点击阅读量
     */
    @TableField("clickHit")
    private Integer clickHit;

    /**
     * 评论数量
     */
    @TableField("replyHit")
    private Integer replyHit;

    /**
     * 博客内容
     */
    private String content;

    /**
     * 博客所属分类
     */
    @TableField("typeId")
    private Integer typeId;

    /**
     * 关键词
     */
    @TableField("keyWord")
    private String keyWord;

    /**
     * 发布日期
     */
    @TableField(exist = false)
    private String releaseDateStr;

    /**
     * 博客数量
     */
    @TableField(exist = false)
    private Integer blogCount;


}
