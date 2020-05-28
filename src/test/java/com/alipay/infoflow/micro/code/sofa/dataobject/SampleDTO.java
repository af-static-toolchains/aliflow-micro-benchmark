package com.alipay.infoflow.micro.code.sofa.dataobject;

/**
 * SampleDTO
 *
 * @author wb-zg494440
 * @version $Id: SampleDTO.java, v 0.1 2019/9/24 10:29 wb-zg494440 Exp $
 * date 2019/9/24
 */
public class SampleDTO {
    private Integer id;
    private String name;
    private String uuid;
    private String rid;
    private String type;
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
    public String getType() {
        return type;
    }

    /**
     * Setter for property 'type'.
     *
     * @param type Value to set for property 'type'.
     */
    public void setType(String type) {
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

}
