/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.alipay.infoflow.micro.code.sofa.dataobject;

import java.util.Map;

/**
 * @author wb-zg494440
 * @version $Id: SampleResult.java, v 0.1 2019年12月09日 17:09 wb-zg494440 Exp $
 */
public class SampleResult {
    private int     code;
    private boolean success;
    private Object  value;
    private Map<String, String> ext;

    /**
     * Getter for property 'code'.
     *
     * @return Value for property 'code'.
     */
    public int getCode() {
        return code;
    }

    /**
     * Setter for property 'code'.
     *
     * @param code Value to set for property 'code'.
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * Getter for property 'success'.
     *
     * @return Value for property 'success'.
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * Setter for property 'success'.
     *
     * @param success Value to set for property 'success'.
     */
    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * Getter for property 'value'.
     *
     * @return Value for property 'value'.
     */
    public Object getValue() {
        return value;
    }

    /**
     * Setter for property 'value'.
     *
     * @param value Value to set for property 'value'.
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Getter for property 'ext'.
     *
     * @return Value for property 'ext'.
     */
    public Map<String, String> getExt() {
        return ext;
    }

    /**
     * Setter for property 'ext'.
     *
     * @param ext Value to set for property 'ext'.
     */
    public void setExt(Map<String, String> ext) {
        this.ext = ext;
    }
}