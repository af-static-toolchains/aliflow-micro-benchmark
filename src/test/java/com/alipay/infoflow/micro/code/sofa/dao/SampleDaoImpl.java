package com.alipay.infoflow.micro.code.sofa.dao;


import com.alipay.infoflow.micro.code.sofa.dataobject.SampleBO;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleDO;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleDOSubSink;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleDOSubSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SampleDaoImpl
 *
 * @author wb-zg494440
 * @version $Id: SampleDaoImpl.java, v 0.1 2019/9/24 10:45 wb-zg494440 Exp $
 * date 2019/9/24
 */
public class SampleDaoImpl implements SampleDao {
    @Override
    public SampleDO queryById(Integer id) {
        SampleDOSubSource source = new SampleDOSubSource();
        SampleDO sampleDO = new SampleDO();
        sampleDO.setId(source.id);
        sampleDO.setName(source.name);
        sampleDO.setRid(source.rid);
        sampleDO.setUuid(source.uuid);
        sampleDO.setType(source.type);
        sampleDO.setCategory(source.category);
        return sampleDO;
    }

    @Override
    public List<SampleDO> queryByName(String name) {
        Map<String, Object> parameters = new HashMap<>(8);
        parameters.put("name", name);
        List sourceList = new ArrayList<>();
        List result = new ArrayList<>();
        sourceList.add(new SampleDOSubSource());
        for (Object o : sourceList) {
            SampleDOSubSource source = (SampleDOSubSource) o;
            SampleDO sampleDO = new SampleDO();
            sampleDO.setId(source.id);
            sampleDO.setName(source.name);
            sampleDO.setRid(source.rid);
            sampleDO.setUuid(source.uuid);
            sampleDO.setType(source.type);
            sampleDO.setCategory(source.category);
            result.add(sampleDO);
        }
        return result;
    }
    @Override
    public List<SampleBO> queryByName2(String name){
        Map<String, Object> parameters = new HashMap<>(8);
        parameters.put("name", name);
        List sourceList = new ArrayList<>();
        List result = new ArrayList<>();
        sourceList.add(new SampleDOSubSource());
        for (Object o : sourceList) {
            SampleDOSubSource source = (SampleDOSubSource) o;
            SampleBO sampleBO = new SampleBO();
            sampleBO.setId(source.id);
            sampleBO.setName(source.name);
            sampleBO.setRid(source.rid);
            sampleBO.setUuid(source.uuid);
            result.add(sampleBO);
        }
        return result;
    }

    @Override
    public List<SampleDO> queryForPage(int offset, int limit) {
        Map<String, Object> parameters = new HashMap<>(8);
        parameters.put("offset", offset);
        parameters.put("limit", limit);
        List<SampleDOSubSource> sourceList = new ArrayList<>();
        List<SampleDO> result = new ArrayList<>();
        sourceList.add(new SampleDOSubSource());
        for (SampleDOSubSource source : sourceList) {
            SampleDO sampleDO = new SampleDO();
            sampleDO.setId(source.id);
            sampleDO.setName(source.name);
            sampleDO.setRid(source.rid);
            sampleDO.setUuid(source.uuid);
            result.add(sampleDO);
            sampleDO.setType(source.type);
            sampleDO.setCategory(source.category);
        }
        return result;
    }

    @Override
    public void insert(SampleDO sample) {
        SampleDOSubSink sink = new SampleDOSubSink();
        sink.id = sample.getId();
        sink.name = sample.getName();
        sink.rid = sample.getRid();
        sink.uuid = sample.getUuid();
        sink.type = sample.getType();
        sink.category = sample.getCategory();
    }

    @Override
    public void insertBatch(List<SampleDO> sampleList) {
        for (SampleDO sampleDO : sampleList) {
            insert(sampleDO);
        }
    }

    @Override
    public void update(SampleDO sample) {
        SampleDOSubSink sink = new SampleDOSubSink();
        sink.id = sample.getId();
        sink.name = sample.getName();
        sink.rid = sample.getRid();
        sink.uuid = sample.getUuid();
        sink.type = sample.getType();
        sink.category = sample.getCategory();
    }

    @Override
    public int update(List<SampleDO> sampleList) {
        sampleList.forEach(this::update);
        return 0;
    }
}
