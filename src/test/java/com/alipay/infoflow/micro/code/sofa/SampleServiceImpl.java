package com.alipay.infoflow.micro.code.sofa;


import com.alipay.infoflow.micro.code.sofa.dao.SampleDao;
import com.alipay.infoflow.micro.code.sofa.dao.SampleDaoImpl;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleBO;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleDO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SampleServiceImpl
 *
 * @author wb-zg494440
 * @version $Id: SampleServiceImpl.java, v 0.1 2019/9/24 11:16 wb-zg494440 Exp $
 * date 2019/9/24
 */
//@SofaService
public class SampleServiceImpl implements SampleService {
    private SampleDao sampleDao = new SampleDaoImpl();
    @Override
    public SampleBO queryById(Integer id) {
        return SampleBO.fromDo(sampleDao.queryById(id));
    }


    @Override
    public List<SampleBO> queryByName(String name) {
        return sampleDao.queryByName(name).stream().map(sample -> SampleBO.fromDo(sample)).collect(Collectors.toList());
    }
    @Override
    public List<SampleBO> queryByName2(String name){
        return sampleDao.queryByName2(name).stream().collect(Collectors.toList());
    }

    @Override
    public List<SampleBO> queryForPage(int offset, int limit) {
        return sampleDao.queryForPage(offset, limit).stream().map(sample -> SampleBO.fromDo(sample)).collect(Collectors.toList());
    }

    @Override
    public void resolve(SampleBO sampleBo) {
        if (null == sampleBo.getId()) {
            sampleDao.insert(sampleBo.toDo());
        }else{
            sampleDao.update(sampleBo.toDo());
        }
    }

    @Override
    public int resolve(List<SampleBO> sampleBos) {
        int resolvedCount = 0;
        List<SampleDO> insertSampleDoList = new ArrayList<>();
        //List<SampleDO> insertSamples = sampleBos.stream().filter(sampleBo -> null == sampleBo.getId()).map(SampleBO::toDo).collect(Collectors.toList());
        List<SampleDO> updateSamples = sampleBos.stream().filter(sampleBo -> null != sampleBo.getId()).map(SampleBO::toDo).collect(Collectors.toList());
//        if (!insertSamples.isEmpty()) {
//            sampleDao.insertBatch(insertSamples);
//            resolvedCount = insertSamples.size();
//        }
        for (SampleBO sampleBo : sampleBos) {
            insertSampleDoList.add(sampleBo.toDo());
        }
        if (!insertSampleDoList.isEmpty()) {
            sampleDao.insertBatch(insertSampleDoList);
            resolvedCount = insertSampleDoList.size();
        }
        if (!updateSamples.isEmpty()) {
            resolvedCount += sampleDao.update(updateSamples);
        }
        return resolvedCount;
    }
}
