package glod.study.blog.service;

import glod.study.blog.domain.Sort;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/20
 */
public interface SortService {

    /**
     * 查询所有类别
     * @return 类别list
     */
    List<Sort> selectAllSort();
}
