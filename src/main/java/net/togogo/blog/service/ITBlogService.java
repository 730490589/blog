package net.togogo.blog.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import net.togogo.blog.entity.TBlog;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HB
 * @since 2020-04-16
 */
public interface ITBlogService extends IService<TBlog> {

    /**
     * 按日期查询博客并统计数量
     * @return
     */
   String findBlogDateAndCount();

    /**
     * 分页查询博客信息
     * @param page
     * @param blog
     * @return
     */
   IPage<TBlog> findBlogByPage(IPage<TBlog> page,TBlog blog);

}
