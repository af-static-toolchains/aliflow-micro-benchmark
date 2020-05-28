/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.alipay.infoflow.micro.code.sofa;

import com.alipay.infoflow.micro.code.sofa.dataobject.SampleResult;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleResultSubSink;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleResultSubSource;

/**
 *
 * @author wb-zg494440
 * @version $Id: ReferenceServiceSub.java, v 0.1 2019年12月09日 17:15 wb-zg494440 Exp $
 */
public class ReferenceServiceSub implements ReferenceService{
    @Override
    public SampleResult querySampleByName(String name) {
        SampleResultSubSource subSource = new SampleResultSubSource();
        SampleResult result = new SampleResult();
        result.setCode(subSource.code);
        result.setSuccess(subSource.success);
        result.setValue(subSource.value);
        return result;
    }

    @Override
    public void resolve(SampleResult result) {
        SampleResultSubSink subSink = new SampleResultSubSink();
        subSink.code = result.getCode();
        subSink.success = result.isSuccess();
        subSink.value = result.getValue();
        subSink.ext = result.getExt();
    }

}