package com.alipay.infoflow.micro.code.sofa.dataobject;


/**
 * SampleBO
 *
 * @author wb-zg494440
 * @version $Id: SampleBO.java, v 0.1 2019/9/24 10:28 wb-zg494440 Exp $
 * date 2019/9/24
 */
public class SampleBO {
    private Integer id;
    private String name;
    private String uuid;
    private String rid;
    private SampleType type;
    private SampleCategory category;

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for property 'uuid'.
     *
     * @return Value for property 'uuid'.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Setter for property 'uuid'.
     *
     * @param uuid Value to set for property 'uuid'.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Getter for property 'rid'.
     *
     * @return Value for property 'rid'.
     */
    public String getRid() {
        return rid;
    }

    /**
     * Setter for property 'rid'.
     *
     * @param rid Value to set for property 'rid'.
     */
    public void setRid(String rid) {
        this.rid = rid;
    }

    /**
     * Getter for property 'type'.
     *
     * @return Value for property 'type'.
     */
    public SampleType getType() {
        return type;
    }

    /**
     * Setter for property 'type'.
     *
     * @param type Value to set for property 'type'.
     */
    public void setType(SampleType type) {
        this.type = type;
    }

    /**
     * Getter for property 'category'.
     *
     * @return Value for property 'category'.
     */
    public SampleCategory getCategory() {
        return category;
    }

    /**
     * Setter for property 'category'.
     *
     * @param category Value to set for property 'category'.
     */
    public void setCategory(SampleCategory category) {
        this.category = category;
    }

    public static SampleBO fromDo(SampleDO sampleDo) {
        SampleBO sampleBo = new SampleBO();
        sampleBo.setId(sampleDo.getId());
        sampleBo.setName(sampleDo.getName());
        sampleBo.setUuid(sampleDo.getUuid());
        sampleBo.setRid(sampleDo.getRid().toLowerCase());
        sampleBo.setType(SampleType.valueOf(sampleDo.getType().getValue()));
        sampleBo.setCategory(sampleDo.getCategory());
        return sampleBo;
    }

    public static SampleBO fromDto(SampleDTO sampleDto) {
        SampleBO sampleBo = new SampleBO();
        sampleBo.setId(sampleDto.getId());
        sampleBo.setName(sampleDto.getName());
        sampleBo.setUuid(sampleDto.getUuid());
        sampleBo.setRid(sampleDto.getRid());
        sampleBo.setType(SampleType.valueOf(sampleDto.getType()));
        sampleBo.setCategory(sampleDto.getCategory());
        return sampleBo;
    }

    public SampleDO toDo() {
        SampleDO sampleDo = new SampleDO();
        sampleDo.setId(id);
        sampleDo.setName(name);
        sampleDo.setUuid(uuid);
        sampleDo.setRid(rid);
        sampleDo.setType(SampleDO.SampleType.valueOf(type.getValue()));
        sampleDo.setCategory(category);
        return sampleDo;
    }

    public SampleDTO toDto() {
        SampleDTO sampleDto = new SampleDTO();
        sampleDto.setId(id);
        sampleDto.setName(name);
        sampleDto.setUuid(uuid);
        sampleDto.setRid(rid);
        sampleDto.setType(type.name());
        sampleDto.setCategory(category);
        return sampleDto;
    }


    public enum SampleType{
        NORMAL(0), OTHER(1);

        private int value;

        SampleType(int value) {
            this.value = value;
        }

        public static SampleType valueOf(int value) {
            for (SampleType sampleType : SampleType.values()) {
                if (sampleType.value == value) {
                    return sampleType;
                }
            }
            return null;
        }

        /**
         * Getter for property 'value'.
         *
         * @return Value for property 'value'.
         */
        public int getValue() {
            return value;
        }
    }
}
