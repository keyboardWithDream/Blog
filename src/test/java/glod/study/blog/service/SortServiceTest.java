package glod.study.blog.service;

import glod.study.blog.domain.Sort;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/21
 */
@SpringBootTest
public class SortServiceTest {

    @Autowired
    private SortService sortService;

    @Test
    public void testSelectAllSort(){
        List<Sort> sortList = sortService.selectAllSort();
        for (Sort sort : sortList) {
            System.out.println(sort);
        }
    }
}
