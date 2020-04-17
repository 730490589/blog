package net.togogo.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import net.togogo.blog.entity.TBlogtype;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HB
 * @since 2020-04-16
 */
public interface ITBlogtypeService extends IService<TBlogtype> {

    /**
     * 按日志类别查询并统计日志数量
     * @return
     */
    String findBlogTypeNameAndBlogCount();

}
