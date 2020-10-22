package glod.study.blog.dao;

import glod.study.blog.domain.Sort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/22
 */
@SpringBootTest
public class SortDaoTest {

    @Autowired
    private SortDao sortDao;

    @Test
    void selectAll(){
        List<Sort> sortList = sortDao.selectAllSort();
        for (Sort sort : sortList) {
            System.out.println(sort);
        }
    }
}
