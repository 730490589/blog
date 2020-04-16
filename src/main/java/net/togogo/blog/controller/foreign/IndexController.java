package net.togogo.blog.controller.foreign;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.togogo.blog.entity.TBlog;
import net.togogo.blog.service.ITBlogService;
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
        Page<TBlog> page = new Page<>(currtent,5);
//        分页查询
        IPage<TBlog> iPage = itBlogService.findBlogByPage(page, blog);
//        获取博客的数据列表
        List<TBlog> blogs = iPage.getRecords();

//        存到模型中
        model.addAttribute("blogs",blogs);

        return "index";
    }

}
