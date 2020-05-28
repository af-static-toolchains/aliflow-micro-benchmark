package com.alipay.infoflow.micro.code.sofa.dao;


import com.alipay.infoflow.micro.code.sofa.dataobject.SampleBO;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleDO;

import java.util.List;

/**
 * SampleDao
 *
 * @author wb-zg494440
 * @version $Id: SampleDao.java, v 0.1 2019/9/24 10:42 wb-zg494440 Exp $
 * date 2019/9/24
 */
public interface SampleDao {
    /**
     * id查询
     * @param id
     * @return
     */
    SampleDO queryById(Integer id);

    /**
     * name查询
     * @param name
     * @return
     */
    List<SampleDO> queryByName(String name);
    List<SampleBO> queryByName2(String name);

    /**
     * page查询
     * @param offset
     * @param limit
     * @return
     */
    List<SampleDO> queryForPage(int offset, int limit);

    /**
     * insert
     * @param sample
     */
    void insert(SampleDO sample);

    /**
     * batch insert
     * @param sampleList
     */
    void insertBatch(List<SampleDO> sampleList);

    /**
     * update someone
     * @param sample
     */
    void update(SampleDO sample);

    /**
     * batch update
     * @param sampleList
     * @return
     */
    int update(List<SampleDO> sampleList);
}
