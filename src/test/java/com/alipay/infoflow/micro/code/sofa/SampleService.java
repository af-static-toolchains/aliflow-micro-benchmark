package com.alipay.infoflow.micro.code.sofa;


import com.alipay.infoflow.micro.code.sofa.dataobject.SampleBO;

import java.util.List;

/**
 * SampleService
 *
 * @author wb-zg494440
 * @version $Id: SampleService.java, v 0.1 2019/11/12 17:40 wb-zg494440 Exp $
 * date 2019/11/12
 */
public interface SampleService {
    /**
     * id查询
     * @param id
     * @return
     */
    SampleBO queryById(Integer id);

    /**
     * name查询
     * @param name
     * @return
     */
    List<SampleBO> queryByName(String name);
    List<SampleBO> queryByName2(String name);

    /**
     * for page 查询
     * @param offset
     * @param limit
     * @return
     */
    List<SampleBO> queryForPage(int offset, int limit);

    /**
     * 保存
     * @param sampleBo
     */
    void resolve(SampleBO sampleBo);

    /**
     * 批量保存
     * @param sampleBos
     * @return
     */
    int resolve(List<SampleBO> sampleBos);
}
