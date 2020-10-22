package glod.study.blog.dao;

import glod.study.blog.domain.Label;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/22
 */
@SpringBootTest
public class LabelDaoTest {

    @Autowired
    private LabelDao labelDao;

    @Test
    public void testSelectLabelByArticleId(){
        List<Label> labelList = labelDao.selectLabelByArticleId("0");
        for (Label label : labelList) {
            System.out.println(label);
        }
    }
}
