package net.togogo.blog.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.togogo.blog.entity.TBlogtype;
import net.togogo.blog.mapper.TBlogtypeMapper;
import net.togogo.blog.service.ITBlogtypeService;
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
public class TBlogtypeServiceImpl extends ServiceImpl<TBlogtypeMapper, TBlogtype> implements ITBlogtypeService {

    @Resource
    TBlogtypeMapper tBlogtypeMapper;

    @Resource
    RedisTemplate<String,String> redisTemplate;

    @Override
    public String findBlogTypeNameAndBlogCount() {
//        从缓存当中获取博客分类数据
        String blogTypeInfo = redisTemplate.opsForValue().get("blog_name_count");
//        判断redis缓存中是否存在数据，如果缓冲中没有，则查询数据，再把数据放到缓存中
        if (blogTypeInfo == null || blogTypeInfo.equals("") || blogTypeInfo.length() == 0){
//            redis缓存中没有数据，所以从数据库查找
            List<TBlogtype> blogtypes = tBlogtypeMapper.findBlogTypeNameAndBlogCount();

//            将查询到的数据抓换成JSON数据
            blogTypeInfo =  JSON.toJSONString(blogtypes);

//            把数据放到缓存中
            redisTemplate.opsForValue().set("blog_name_count",blogTypeInfo);
        }
        return blogTypeInfo;
    }
}
