package glod.study.blog.controller;

import glod.study.blog.domain.Sort;
import glod.study.blog.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/21
 */
@Controller
@RequestMapping("/sort")
public class SortController {

    @Autowired
    private SortService sortService;

    @GetMapping("/all")
    @ResponseBody
    public List<Sort> selectAllSort(){
        return sortService.selectAllSort();
    }
}
