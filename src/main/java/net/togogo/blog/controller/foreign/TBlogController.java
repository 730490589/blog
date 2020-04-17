package net.togogo.blog.controller.foreign;


import net.togogo.blog.entity.TBlog;
import net.togogo.blog.service.ITBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author HB
 * @since 2020-04-16
 */
@Controller
@RequestMapping("/blog")
public class TBlogController {

    @Resource
    ITBlogService itBlogService;

    @RequestMapping("/blogDateList")
    @ResponseBody
    public String blogDateList(){

        return itBlogService.findBlogDateAndCount();
    }


    @RequestMapping("/view/{id}")
    public String view(@PathVariable Integer id, Model model){

        TBlog blog = itBlogService.findBlogById(id);
        model.addAttribute("blog",blog);

        model.addAttribute("pageContent","foreign/blog/view");
        return "index";
    }

}
