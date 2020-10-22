package glod.study.blog.dao;

import glod.study.blog.domain.Label;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/21
 */
@Repository
public interface LabelDao {

    /**
     * 通过文章id查询标签
     * @param articleId 文章id
     * @return 标签
     */
    @Select("select * from t_label where name in (select label_name from t_article_label where article_id = #{articleId})")
    List<Label> selectLabelByArticleId(String articleId);

    /**
     * 通过名称查询标签信息
     * @param labelName 标签名称
     * @return 标签信息
     */
    @Select("select * from t_label where name = #{labelName}")
    Label selectLabelByName(String labelName);
}
