/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.alipay.infoflow.micro.code.basic.fix.callgraph;

import com.alipay.infoflow.micro.code.basic.SourceSink;

import java.util.Arrays;

/**
 *
 * @author wb-zg494440
 * @version $Id: FixCallGraph.java, v 0.1 2020年06月11日 15:45 wb-zg494440 Exp $
 */
public class FixCallGraph {
    public void convertImplTest(){
        MyObjectModel0 model0 = new MyObjectModel0();
        model0.setModelValue(SourceSink.fromSource());
        MyObjectModel1 model1 = new MyObjectModel1();
        model1.setModelValue1(SourceSink.fromSource());
        MyObject0Convert convert0 = new MyObject0Convert();
        BaseConvert<MyObjectDO1, MyObjectModel1> convert1 = new MyObject1Convert();
        convert0.convertToDoList(Arrays.asList(model0)).get(0).getDoValue();
        SourceSink.toSink(convert1.convertToDoList(Arrays.asList(model1)).get(0).getDoValue());
    }
}