package net.togogo.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.togogo.blog.entity.TBlog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HB
 * @since 2020-04-16
 */
public interface TBlogMapper extends BaseMapper<TBlog> {

    /**
     * 按日期查询博客并统计数量
     * @return
     */
    List<TBlog> findBlogDateAndCount();

    /**
     * 分页查询博客信息
     * @param page
     * @param blog
     * @return
     */
    IPage<TBlog> findBlogByPage(@Param("page") IPage<TBlog> page, @Param("blog") TBlog blog);

}
