package com.alipay.infoflow.micro.code.sofa.facade;

import com.alipay.infoflow.micro.code.sofa.Callback;
import com.alipay.infoflow.micro.code.sofa.ReferenceService;
import com.alipay.infoflow.micro.code.sofa.ReferenceServiceSub;
import com.alipay.infoflow.micro.code.sofa.SampleService;
import com.alipay.infoflow.micro.code.sofa.SampleServiceImpl;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleBO;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleDOSubSink;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleDOSubSource;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleDTO;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SampleFacadeImpl
 *
 * @author wb-zg494440
 * @version $Id: SampleFacadeImpl.java, v 0.1 2019/9/24 11:23 wb-zg494440 Exp $
 * date 2019/9/24
 */
//@SofaService
public class SampleFacadeImpl implements SampleFacade {
    //    @SofaReference
    private SampleService sampleService = new SampleServiceImpl();
    private ReferenceService referenceService = new ReferenceServiceSub();
    @Override
    public SampleDTO queryById(Integer id) {
        SampleBO sampleBO = sampleService.queryById(id);
        if (null == sampleBO) {
            return null;
        }
        return sampleBO.toDto();
    }

    @Override
    public List<SampleDTO> queryByIdListMap(Integer id) {
        return execute(new Callback<List<SampleDTO>>() {
            @Override
            public List<SampleDTO> query() {
                List<SampleBO> sampleBOList = Arrays.asList(sampleService.queryById(id));
                return sampleBOList.stream().map(bo -> bo.toDto()).collect(Collectors.toList());
            }
        });
    }

    @Override
    public List<SampleDTO> queryByName2Map(Integer id) {
        return execute(new Callback<List<SampleDTO>>() {
            @Override
            public List<SampleDTO> query() {
                List<SampleBO> sampleBOList = sampleService.queryByName2("");
                return sampleBOList.stream().map(bo -> bo.toDto()).collect(Collectors.toList());
            }
        });
    }

    @Override
    public SampleDTO queryBy(Integer id, String name) {
        return execute(new Callback<SampleDTO>() {
            @Override
            public SampleDTO query() {
                SampleDOSubSource source = new SampleDOSubSource();
                SampleDTO dto = new SampleDTO();
                dto.setName(source.name);
                return dto;
            }
        });
    }

    @Override
    public List<SampleDTO> queryByName(String name) {
        return sampleService.queryByName(name).stream().map(SampleBO::toDto).collect(Collectors.toList());
    }
    @Override
    public List<SampleBO> queryByName2(String name){
        return sampleService.queryByName2(name);
    }

    @Override
    public List<SampleDTO> queryForPage(int offset, int limit) {
        return sampleService.queryForPage(offset, limit).stream().map(SampleBO::toDto).collect(Collectors.toList());
    }

    @Override
    public void resolve(SampleDTO sampleDto) {
        sampleService.resolve(SampleBO.fromDto(sampleDto));
    }

    @Override
    public int resolve(List<SampleDTO> sampleDtos) {
        if (null == sampleDtos) {
            return 0;
        }
        List<SampleBO> sampleBOS = new ArrayList<>();
        for (SampleDTO sampleDto : sampleDtos) {
            sampleBOS.add(SampleBO.fromDto(sampleDto));
        }
        //return sampleService.resolve(sampleDtos.stream().map(sample -> SampleBO.fromDto(sample)).collect(Collectors.toList()));
        return sampleService.resolve(sampleBOS);
    }


    @Override
    public int resolveMap(List<SampleDTO> sampleDtos) {
        if (null == sampleDtos) {
            return 0;
        }
        boToDOSubSink(
                execute(new Callback<List<SampleBO>>() {
                    @Override
                    public List<SampleBO> query() {
                        return sampleDtos.stream().map(sample -> SampleBO.fromDto(sample)).collect(Collectors.toList());
                    }
                }));
        return 0;
    }
    @Override
    public int resolveMap2(List<SampleDTO> sampleDtos) {
        if (null == sampleDtos) {
            return 0;
        }
        boToDOSubSink(execute(new Callback<List<SampleBO>>() {
            @Override
            public List<SampleBO> query() {
                return sampleDtos.stream().map(sample ->{
                    SampleBO sampleBO = SampleBO.fromDto(sample);
                    //sampleBO.setRid(null);
                    return sampleBO;
                }).collect(Collectors.toList());
            }
        }));
        return 0;
    }

    @Override
    public void updateRid(String name, String rid) {
        List<SampleBO> sampleBOS = sampleService.queryByName(name);
        sampleBOS.forEach(sampleBO -> sampleBO.setRid(rid));
        sampleService.resolve(sampleBOS);
    }

    @Override
    public void updateRid(Integer id, String rid) {
        SampleBO sampleBO = sampleService.queryById(id);
        sampleBO.setRid(rid);
        sampleService.resolve(sampleBO);
    }

    @Override
    public SampleResult queryByNameResult(String name) {
        SampleResult result = new SampleResult();
        try {
            List<SampleDTO> samples = queryByName(name);
            result.setExt(new HashMap<>());
            samples.stream().findFirst().ifPresent(s -> result.getExt().put("rid", s.getRid()));
            result.setCode(0);
            result.setSuccess(true);
            result.setValue(samples);
        } catch (Exception e) {
            result.setCode(500);
            result.setSuccess(false);
        }
        return result;
    }

    @Override
    public void saveSampleByResult() {
        SampleResult result = referenceService.querySampleByName("");
        List<SampleDTO> sampleDTOList = (List<SampleDTO>) result.getValue();
        resolve(sampleDTOList);
    }

    @Override
    public void resolveToReference() {
        SampleResult result = queryByNameResult("");
        referenceService.resolve(result);
    }

    @Override
    public void resolveFromReference() {
        SampleResult result = referenceService.querySampleByName("");
        resolveSampleResult(result);
    }

    private <T> T execute(Callback<T> callback) {
        return callback.query();
    }

    private void toDOSubSink(List<SampleDTO> sampleDTOList) {
        for (SampleDTO sampleDTO : sampleDTOList) {
            toDOSubSink(sampleDTO);
        }
    }
    private void toDOSubSink(SampleDTO sampleDTO) {
        SampleDOSubSink sampleDOSubSink = new SampleDOSubSink();
        sampleDOSubSink.category = sampleDTO.getCategory();
        sampleDOSubSink.id = sampleDTO.getId();
        sampleDOSubSink.name = sampleDTO.getName();
        sampleDOSubSink.rid = sampleDTO.getRid();
        sampleDOSubSink.uuid = sampleDTO.getUuid();
    }
    private void boToDOSubSink(List<SampleBO> sampleBOList) {
        for (SampleBO sampleBO : sampleBOList) {
            toDOSubSink(sampleBO);
        }
    }
    private void toDOSubSink(SampleBO sampleBO) {
        SampleDOSubSink sampleDOSubSink = new SampleDOSubSink();
        sampleDOSubSink.category = sampleBO.getCategory();
        sampleDOSubSink.id = sampleBO.getId();
        sampleDOSubSink.name = sampleBO.getName();
        sampleDOSubSink.rid = sampleBO.getRid();
        sampleDOSubSink.uuid = sampleBO.getUuid();
    }
}
