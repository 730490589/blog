package net.togogo.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.togogo.blog.entity.TBlog;
import net.togogo.blog.mapper.TBlogMapper;
import net.togogo.blog.service.ITBlogService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HB
 * @since 2020-04-16
 */
@Service
public class TBlogServiceImpl extends ServiceImpl<TBlogMapper, TBlog> implements ITBlogService {

    @Resource
    TBlogMapper tBlogMapper;

    @Resource
    RedisTemplate<String,String> redisTemplate;


    @Override
    public String findBlogDateAndCount() {

//        先从缓存中获取数据，没有再查询数据库，然后把数据存到缓存
        String blogInfo = redisTemplate.opsForValue().get("blog_date_count");
//        判断是否有数据
        if (blogInfo == null || blogInfo.equals("")||blogInfo.length()==0){
//            缓存中没有数据，从数据库获取
            List<TBlog> blogs = tBlogMapper.findBlogDateAndCount();

//            转换成JSON数据
            blogInfo=  JSON.toJSONString(blogs);

//            存入缓存
            redisTemplate.opsForValue().set("blog_date_count",blogInfo);
        }

        return blogInfo;
    }

    @Override
    public IPage<TBlog> findBlogByPage(IPage<TBlog> page, TBlog blog) {
        return tBlogMapper.findBlogByPage(page, blog);
    }

    @Override
    public TBlog findBlogById(Integer id) {

//        修改博客的点击数量
//        先查询博客信息
        TBlog blog = tBlogMapper.findBlogById(id);
//        把点击数量拿出来进行 +1 然后在放回去
        blog.setClickHit(blog.getClickHit() + 1);
//        最后更新到数据库
        tBlogMapper.updateById(blog);

        return tBlogMapper.findBlogById(id);
    }
}
