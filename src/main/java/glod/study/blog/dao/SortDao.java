package glod.study.blog.dao;

import glod.study.blog.domain.Sort;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/20
 */
@Repository
public interface SortDao {

    /**
     * 查询所有类别
     * @return 类别
     */
    @Select("select * from sort")
    List<Sort> selectAllSort();
}
