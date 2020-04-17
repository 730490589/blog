package net.togogo.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.togogo.blog.entity.TBlogtype;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HB
 * @since 2020-04-16
 */
public interface TBlogtypeMapper extends BaseMapper<TBlogtype> {

    /**
     * 按日志类别查询并统计日志数量
     * @return
     */
    List<TBlogtype> findBlogTypeNameAndBlogCount();

}
