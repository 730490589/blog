package net.togogo.blog.controller.foreign;


import net.togogo.blog.service.ITBlogtypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author HB
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/blogtype")
public class TBlogtypeController {

    @Resource
    ITBlogtypeService itBlogtypeService;

    @RequestMapping("/typeList")
    @ResponseBody
    public String typeList(){
        return itBlogtypeService.findBlogTypeNameAndBlogCount();
    }

}
