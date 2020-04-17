package net.togogo.blog.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@TableName("t_blogger")
public class TBlogger implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    @TableField("userName")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 个人简介
     */
    private String profile;

    /**
     * 昵称
     */
    @TableField("nickName")
    private String nickName;

    /**
     * 座右铭
     */
    private String sign;

    /**
     * 博主头像
     */
    @TableField("imageName")
    private String imageName;


}
