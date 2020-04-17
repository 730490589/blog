package net.togogo.blog.controller.foreign;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.togogo.blog.entity.TBlog;
import net.togogo.blog.service.ITBlogService;
import net.togogo.blog.utils.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    ITBlogService itBlogService;

    @RequestMapping(value = {"/","/index","/index.html"})
    public String index(TBlog blog, @RequestParam(value = "page",defaultValue = "1") Long currtent, Model model){
//        创建分页对象，指定当前页面及每页显示的数量
        Integer size = 5;
        Page<TBlog> page = new Page<>(currtent,size);
//        分页查询
        IPage<TBlog> iPage = itBlogService.findBlogByPage(page, blog);

//        判断查询是否条件是否为空
        StringBuffer param = new StringBuffer();
        if (blog != null){
            if (blog.getTypeId()!=null){
                param.append("typeId="+blog.getTypeId());
            }

            if (blog.getReleaseDateStr() != null && !blog.getReleaseDateStr().equals("")){
                param.append("releaseDateSt="+blog.getReleaseDateStr());
            }
        }

//        获取博客的数据列表
        List<TBlog> blogs = iPage.getRecords();

//        页面代码块，在index.html页面的中间内容模块使用th:insert
        model.addAttribute("pageContent","foreign/main");

//        存放分页信息
        model.addAttribute("pageCode", PageUtil.getPageintion("/index.html",iPage.getTotal(),currtent.intValue(),size,param.toString()));

//        存到模型中
        model.addAttribute("blogs",blogs);

        return "index";
    }

}
