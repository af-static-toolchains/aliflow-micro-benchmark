package com.alipay.infoflow.micro.code.sofa.facade;


import com.alipay.infoflow.micro.code.sofa.dataobject.SampleBO;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleDTO;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleResult;

import java.util.List;

/**
 * SampleFacade
 *
 * @author wb-zg494440
 * @version $Id: SampleFacade.java, v 0.1 2019/9/24 10:37 wb-zg494440 Exp $
 * date 2019/9/24
 */
public interface SampleFacade {
    /**
     * id查询
     * @param id
     * @return
     */
    SampleDTO queryById(Integer id);

    /**
     * query by ?
     * @param id
     * @param name
     * @return
     */
    SampleDTO queryBy(Integer id,String name);

    /**
     * name查询
     * @param name
     * @return
     */
    List<SampleDTO> queryByName(String name);

    /**
     * query by name 不同return
     * @param name
     * @return
     */
    List<SampleBO> queryByName2(String name);

    /**
     * for page 查询
     * @param offset
     * @param limit
     * @return
     */
    List<SampleDTO> queryForPage(int offset, int limit);

    /**
     * 保存
     * @param sampleDto
     */
    void resolve(SampleDTO sampleDto);

    /**
     * 批量保存
     * @param sampleDtos
     * @return
     */
    int resolve(List<SampleDTO> sampleDtos);

    /**
     * 通过name更新rid
     * @param name
     * @param rid
     */
    void updateRid(String name, String rid);

    /**
     * 通过id更新rid
     * @param id
     * @param rid
     */
    void updateRid(Integer id, String rid);

    /**
     * name 查询（ObjectField）
     * @param name
     * @return
     */
    SampleResult queryByNameResult(String name);

    /**
     * 内部通过 service reference 获得result对象，使用result对象保存到DB
     */
    void saveSampleByResult();

    /**
     * 保存sample result
     *
     * @param result result
     */
    default void resolveSampleResult(SampleResult result) {
        if (result.isSuccess()) {
            List<SampleDTO> sampleList = (List<SampleDTO>) result.getValue();
            resolve(sampleList);
        }
    }

    /**
     * 模拟外部服务调用写入
     */
    void resolveToReference();

    /**
     * 模拟外部服务调用读取
     */
    void resolveFromReference();
}
