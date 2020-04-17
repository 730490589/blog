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
@TableName("t_blogtype")
public class TBlogtype implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 博客分类名称
     */
    @TableField("typeName")
    private String typeName;

    /**
     * 博客优先级排序
     */
    @TableField("orderNo")
    private Integer orderNo;

    @TableField(exist = false)
    private Integer blogCount;


}
