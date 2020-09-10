/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.alipay.infoflow.micro.code.basic.fix.callgraph;

/**
 * @author wb-zg494440
 * @version $Id: MyObject0Convert.java, v 0.1 2020年06月11日 15:56 wb-zg494440 Exp $
 */
public class MyObject0Convert extends BaseConvert<MyObjectDO0, MyObjectModel0> {

    @Override
    public MyObjectDO0 convertToDo(MyObjectModel0 myObjectModel) {
        MyObjectDO0 dataObject = new MyObjectDO0();
        dataObject.setDoValue(myObjectModel.getModelValue());
        return dataObject;
    }

    @Override
    public MyObjectModel0 convertToModel(MyObjectDO0 dataObject) {
        MyObjectModel0 model = new MyObjectModel0();
        model.setModelValue(dataObject.getDoValue());
        return model;
    }
}