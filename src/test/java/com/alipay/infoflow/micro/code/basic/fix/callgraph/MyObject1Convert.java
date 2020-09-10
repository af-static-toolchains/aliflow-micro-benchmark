/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.alipay.infoflow.micro.code.basic.fix.callgraph;

/**
 * @author wb-zg494440
 * @version $Id: MyObject0Convert.java, v 0.1 2020年06月11日 15:56 wb-zg494440 Exp $
 */
public class MyObject1Convert extends BaseConvert<MyObjectDO1, MyObjectModel1> {

    @Override
    public MyObjectDO1 convertToDo(MyObjectModel1 myObjectModel) {
        MyObjectDO1 dataObject = new MyObjectDO1();
        dataObject.setDoValue(myObjectModel.getModelValue1());
        return dataObject;
    }

    @Override
    public MyObjectModel1 convertToModel(MyObjectDO1 dataObject) {
        MyObjectModel1 model = new MyObjectModel1();
        model.setModelValue1(dataObject.getDoValue());
        return model;
    }
}