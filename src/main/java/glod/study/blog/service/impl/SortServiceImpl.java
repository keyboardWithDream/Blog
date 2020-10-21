package glod.study.blog.service.impl;

import glod.study.blog.dao.SortDao;
import glod.study.blog.domain.Sort;
import glod.study.blog.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Harlan
 * @Date 2020/10/20
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class SortServiceImpl implements SortService {

    @Autowired
    private SortDao sortDao;

    @Override
    public List<Sort> selectAllSort() {
        return sortDao.selectAllSort();
    }
}
