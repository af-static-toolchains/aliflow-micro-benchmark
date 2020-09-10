package com.alipay.infoflow.micro.code.sofa.facade;

import com.alipay.infoflow.micro.code.sofa.Callback;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleBO;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleDO;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleDOSubSink;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleDOSubSource;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleDTO;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleDTOWrapSink;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleDTOWrapSource;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleResult;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleResultWrapSink;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleResultWrapSource;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SampleFacadeImpl
 *
 * @author wb-zg494440
 * @version $Id: SampleFacadeImpl.java, v 0.1 2019/9/24 11:23 wb-zg494440 Exp $
 * date 2019/9/24
 */
//@SofaService
public class SampleFacadeImplWrap {
    //    @SofaReference
    private SampleFacadeImpl entryService = new SampleFacadeImpl();

    public void queryById(Integer id) {
        SampleDTO sampleDTO = entryService.queryById(id);
        SampleDTOWrapSink sink = new SampleDTOWrapSink();
        sink.id = sampleDTO.getId();
        sink.name = sampleDTO.getName();
        sink.rid = sampleDTO.getRid();
        sink.uuid = sampleDTO.getUuid();
        sink.type = sampleDTO.getType();
        sink.category = sampleDTO.getCategory();
        SampleDTO dto = new SampleDTO();
        dto.setId(sampleDTO.getId());
        dto.setName(sampleDTO.getName());
        dto.setRid(sampleDTO.getRid());
        dto.setUuid(sampleDTO.getUuid());
        dto.setType(sampleDTO.getType());
        dto.setCategory(sampleDTO.getCategory());
    }

    public void queryByName(String name) {
        List sampleDTOS = entryService.queryByName(name);
        List dtoSinks = new ArrayList();
        for (Object dtoObject : sampleDTOS) {
            SampleDTO dto = (SampleDTO) dtoObject;
            SampleDTOWrapSink sink = new SampleDTOWrapSink();
            sink.id = dto.getId();
            sink.name = dto.getName();
            sink.rid = dto.getRid();
            sink.uuid = dto.getUuid();
            sink.type = dto.getType();
            sink.category = dto.getCategory();
            dtoSinks.add(sink);
        }
    }
    public void queryByIdListMap(int id) {
        List sampleDTOS = entryService.queryByName2Map(id);
        List dtoSinks = new ArrayList();
        for (Object dtoObject : sampleDTOS) {
            SampleDTO dto = (SampleDTO) dtoObject;
            SampleDTOWrapSink sink = new SampleDTOWrapSink();
            sink.id = dto.getId();
            sink.rid = dto.getRid();
            sink.uuid = dto.getUuid();
            dtoSinks.add(sink);
        }
    }
    public void queryByName2Map(int id) {
        List sampleDTOS = entryService.queryByName2Map(id);
        List dtoSinks = new ArrayList();
        for (Object dtoObject : sampleDTOS) {
            SampleDTO dto = (SampleDTO) dtoObject;
            SampleDTOWrapSink sink = new SampleDTOWrapSink();
            sink.id = dto.getId();
            sink.name = dto.getName();
            sink.uuid = dto.getUuid();
            dtoSinks.add(sink);
        }
    }

    public void queryByNameMapReflect(String name) {
        List sampleDTOS = entryService.queryByName(name);
        List<SampleDTO> sampleDtoFromMapList = new ArrayList<>();
        List<Map<String, Object>> dtoMaps = wrapMap(sampleDTOS);
        for (Map<String, Object> dtoMap : dtoMaps) {
            SampleDTO dto2 = new SampleDTO();
            unwrapMapToDTO(dtoMap, dto2);
            sampleDtoFromMapList.add(dto2);
        }
        List dtoSinks = new ArrayList();
        for (Object dtoObject : sampleDtoFromMapList) {
            SampleDTO dto = (SampleDTO) dtoObject;
            SampleDTOWrapSink sink = new SampleDTOWrapSink();
            sink.id = dto.getId();
            sink.name = dto.getName();
            sink.rid = dto.getRid();
            sink.uuid = dto.getUuid();
            sink.type = dto.getType();
            sink.category = dto.getCategory();
            dtoSinks.add(sink);
        }
    }
    public void queryByNameMapReflect2(String name) {
        List sampleDTOS = entryService.queryByName(name);
        List<SampleDTO> sampleDtoFromMapList = new ArrayList<>();
        List<Map<String, Object>> dtoMaps = wrapMap(sampleDTOS);
        for (Map<String, Object> dtoMap : dtoMaps) {
            SampleDTO dto2 = new SampleDTO();
            unwrapMapToDTO(dtoMap, dto2);
            sampleDtoFromMapList.add(dto2);
        }
        List dtoSinks = new ArrayList();
        for (Object dtoObject : sampleDtoFromMapList) {
            SampleDTO dto = (SampleDTO) dtoObject;
            SampleDTOWrapSink sink = new SampleDTOWrapSink();
            sink.id = dto.getId();
            sink.name = dto.getName();
            sink.rid = dto.getRid();
            sink.uuid = dto.getUuid();
            sink.type = dto.getType();
            sink.category = dto.getCategory();
            dtoSinks.add(sink);
        }
    }

    private void unwrapMapToDTO(Map<String, Object> dtoMap, SampleDTO dto2) {
        for (Field field : SampleDTO.class.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                field.set(dto2, dtoMap.get(field.getName()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private List<Map<String, Object>> wrapMap(List sampleDTOS) {
        List<Map<String, Object>> dtoMaps = new ArrayList<>();
        for (Object sampleDTO : sampleDTOS) {
            Map<String, Object> dtoMap = wrapMap((SampleDTO) sampleDTO);
            dtoMaps.add(dtoMap);
        }
        return dtoMaps;
    }

    private Map<String, Object> wrapMap(SampleDTO sampleDTO) {
        SampleDTO dto = sampleDTO;
        Map<String, Object> dtoMap = new HashMap<>();
        dtoMap.put("name", dto.getName());
        dtoMap.put("category", dto.getCategory());
        dtoMap.put("rid", dto.getRid());
        dtoMap.put("uuid", dto.getUuid());
        dtoMap.put("type", dto.getType());
        return dtoMap;
    }

    public void queryByCallback1(Integer id, String name) {
        SampleDTO dto = execute(new Callback<SampleDTO>() {
            //  callback1
            @Override
            public SampleDTO query() {
                SampleDOSubSource source = new SampleDOSubSource();
                SampleDTO dto = new SampleDTO();
                dto.setName(source.name);
                return dto;
            }
        });
        SampleDTOWrapSink sink = new SampleDTOWrapSink();
        sink.name = dto.getName();
    }
    public void queryByCallback2(Integer id, String name) {
        SampleDTO dto = execute(new Callback<SampleDTO>() {
            //  callback2
            @Override
            public SampleDTO query() {
                SampleDOSubSource source = new SampleDOSubSource();
                SampleDTO dto = new SampleDTO();
                dto.setName(source.name);
                return dto;
            }
        });
        SampleDTOWrapSink sink = new SampleDTOWrapSink();
        sink.name = dto.getName();
    }

    public void queryByCallback3(Integer id, String name) {
        SampleDOSubSource source = new SampleDOSubSource();
        SampleDTO sdto = new SampleDTO();
        sdto.setName(source.name);

        SampleDTO dto = execute(new Callback<SampleDTO>() {
            @Override
            public SampleDTO query() {
                return sdto;
            }
        });
        SampleDTOWrapSink sink = new SampleDTOWrapSink();
        sink.name = dto.getName();
    }

    public void queryByCallback4(Integer id, String name) {
        SampleDOSubSource source = new SampleDOSubSource();
        SampleDTO sdto = new SampleDTO();
        sdto.setName(source.name);

        SampleDTO dto = execute(new Callback<SampleDTO>() {
            @Override
            public SampleDTO query() {
                return sdto;
            }
        });
        SampleDTOWrapSink sink = new SampleDTOWrapSink();
        sink.name = dto.getName();
    }

    public void queryByCallback5(Integer id, String name) {
        SampleDOSubSource source = new SampleDOSubSource();
        SampleDTO sdto = new SampleDTO();
        sdto.setName(source.name);

        SampleDTO dto = execute(new CallbackImpl(sdto));
        SampleDTOWrapSink sink = new SampleDTOWrapSink();
        sink.name = dto.getName();
    }

    public void queryByCallback6(Integer id, String name) {
        SampleDOSubSource source = new SampleDOSubSource();
        SampleDTO sdto = new SampleDTO();
        sdto.setName(source.name);

        SampleDTO dto = execute(new CallbackImpl(sdto));
        SampleDTOWrapSink sink = new SampleDTOWrapSink();
        sink.name = dto.getName();
    }
    class CallbackImpl implements Callback<SampleDTO> {
        SampleDTO dto;
        CallbackImpl (SampleDTO dto) {
            this.dto = dto;
        }
        @Override
        public SampleDTO query() {
            return dto;
        }
    }
    public void queryByName2(String name) {
        List sampleBO = entryService.queryByName2(name);
        List dtoSinks = new ArrayList();
        for (Object dtoObject : sampleBO) {
            SampleBO dto = (SampleBO) dtoObject;
            SampleDTOWrapSink sink = new SampleDTOWrapSink();
            sink.id = dto.getId();
            sink.name = dto.getName();
            sink.rid = dto.getRid();
            sink.uuid = dto.getUuid();
            dtoSinks.add(sink);
        }
    }

    public void queryForPage(int offset, int limit) {
        List<SampleDTO> sampleDTOS = entryService.queryForPage(offset, limit);
        List dtoSinks = new ArrayList();
        for (SampleDTO dto : sampleDTOS) {
            SampleDTOWrapSink sink = new SampleDTOWrapSink();
            sink.id = dto.getId();
            sink.name = dto.getName();
            sink.rid = dto.getRid();
            sink.uuid = dto.getUuid();
            sink.type = dto.getType();
            sink.category = dto.getCategory();
            dtoSinks.add(sink);
        }
    }

    public void resolve(SampleDTO sampleDto) {
        SampleDTOWrapSource source = new SampleDTOWrapSource();
        SampleDTO dto = new SampleDTO();
        source.id = sampleDto.getId();
        source.name = sampleDto.getName();
        source.rid = sampleDto.getRid();
        source.uuid = sampleDto.getUuid();
        dto.setId(source.id);
        dto.setName(source.name);
        dto.setRid(source.rid);
        dto.setUuid(source.uuid);
        dto.setType(source.type);
        dto.setCategory(source.category);
        entryService.resolve(dto);
    }

    public void resolve(List<SampleDTO> sampleDtos) {
        List sourceList = new ArrayList();
        sourceList.add(new SampleDTOWrapSource());
        List dtoList = new ArrayList();
        for (Object dtoSource : sourceList) {
            SampleDTOWrapSource source = (SampleDTOWrapSource) dtoSource;
            SampleDTO dto = new SampleDTO();
            dto.setId(source.id);
            dto.setName(source.name);
            dto.setRid(source.rid);
            dto.setUuid(source.uuid);
            dto.setType(source.type);
            dto.setCategory(source.category);
            dtoList.add(dto);
        }
        entryService.resolve(dtoList);
    }
    public void resolveMap(List<SampleDTO> sampleDtos) {
        List sourceList = new ArrayList();
        sourceList.add(new SampleDTOWrapSource());
        List dtoList = new ArrayList();
        for (Object dtoSource : sourceList) {
            SampleDTOWrapSource source = (SampleDTOWrapSource) dtoSource;
            SampleDTO dto = new SampleDTO();
            dto.setId(source.id);
            dto.setName(source.name);
            dto.setRid(source.rid);
            dto.setUuid(source.uuid);
            dto.setType(source.type);
            dto.setCategory(source.category);
            dtoList.add(dto);
        }
        entryService.resolveMap(dtoList);
    }
    public void resolveMap2(List<SampleDTO> sampleDtos) {
        List sourceList = new ArrayList();
        sourceList.add(new SampleDTOWrapSource());
        List dtoList = new ArrayList();
        for (Object dtoSource : sourceList) {
            SampleDTOWrapSource source = (SampleDTOWrapSource) dtoSource;
            SampleDTO dto = new SampleDTO();
            dto.setId(source.id);
            dto.setName(source.name);
            dto.setRid(source.rid);
            dto.setUuid(source.uuid);
            dto.setType(source.type);
            dto.setCategory(source.category);
            dtoList.add(dto);
        }
        entryService.resolveMap2(dtoList);
    }

    public void updateRid(String name, String rid) {
        entryService.updateRid(name, rid);
    }

    public void updateRid(Integer id, String rid) {
        entryService.updateRid(id, rid);
    }

    public void queryByNameResult(String name) {
        SampleResult result = entryService.queryByNameResult(name);
        SampleResultWrapSink wrapSink = new SampleResultWrapSink();
        wrapSink.code = result.getCode();
        wrapSink.success = result.isSuccess();
        wrapSink.value = result.getValue();
        wrapSink.ext = result.getExt();
    }

    public void saveSampleByResult() {
        entryService.saveSampleByResult();
    }


    public void queryByNameResult2() {
        SampleResult result = new SampleResult();
        SampleDOSubSource sampleDoSource = new SampleDOSubSource();
        SampleDO sampleDO = new SampleDO();
        sampleDO.setType(sampleDoSource.type);
        sampleDO.setRid(sampleDoSource.rid);
        sampleDO.setId(sampleDoSource.id);
        sampleDO.setName(sampleDoSource.name);
        sampleDO.setCategory(sampleDoSource.category);
        sampleDO.setUuid(sampleDoSource.uuid);
        result.setValue(SampleBO.fromDo(sampleDO));
        SampleResultWrapSink wrapSink = new SampleResultWrapSink();
        wrapSink.code = result.getCode();
        wrapSink.success = result.isSuccess();
        wrapSink.value = result.getValue();
        wrapSink.ext = result.getExt();
    }

    public void saveSampleByResult2() {
        SampleResultWrapSource resultWrapSource = new SampleResultWrapSource();
        SampleResult result = new SampleResult();
        result.setValue(resultWrapSource.value);
        SampleBO sampleBo = (SampleBO) result.getValue();
        SampleDO sampleDo = sampleBo.toDo();
        SampleDOSubSink doSink = new SampleDOSubSink();
        doSink.type = sampleDo.getType();
        doSink.rid = sampleDo.getRid();
        doSink.id = sampleDo.getId();
        doSink.name = sampleDo.getName();
        doSink.category = sampleDo.getCategory();
        doSink.uuid = sampleDo.getUuid();
    }


    public void resolveSampleResult(SampleResult result) {
        SampleResultWrapSource wrapSource = new SampleResultWrapSource();
        SampleResult param = new SampleResult();
        param.setSuccess(wrapSource.success);
        param.setCode(wrapSource.code);
        param.setValue(wrapSource.value);
        param.setExt(wrapSource.ext);
        entryService.resolveSampleResult(param);
    }

    public void resolveToReference() {
        entryService.resolveToReference();
    }

    public void resolveFromReference() {
        entryService.resolveFromReference();
    }

    private <T> T execute(Callback<T> callback) {
        return callback.query();
    }
}
