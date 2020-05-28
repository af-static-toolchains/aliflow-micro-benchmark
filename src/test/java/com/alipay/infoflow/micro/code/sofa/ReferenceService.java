/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.alipay.infoflow.micro.code.sofa;

import com.alipay.infoflow.micro.code.sofa.dataobject.SampleResult;

/**
 * 模拟实现外部RPC
 * @author wb-zg494440
 * @version $Id: ReferenceService.java, v 0.1 2019年12月09日 17:12 wb-zg494440 Exp $
 */
public interface ReferenceService {
    /**
     * query sample by name
     * @param name  name
     * @return  Wrapped Sample result
     */
    SampleResult querySampleByName(String name);

    /**
     * resolve result
     * @param result result
     */
    void resolve(SampleResult result);
}