package net.togogo.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("t_comment")
public class TComment implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户IP地址
     */
    @TableField("userIp")
    private String userIp;

    /**
     * 所属博客id
     */
    @TableField("blogId")
    private Integer blogId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    @TableField("commentDate")
    private LocalDateTime commentDate;

    /**
     * 审核状态1：待审核 2：已审核
     */
    private Integer state;


}
