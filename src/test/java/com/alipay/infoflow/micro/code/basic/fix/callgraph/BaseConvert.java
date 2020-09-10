/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.alipay.infoflow.micro.code.basic.fix.callgraph;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wb-zg494440
 * @version $Id: BaseConvert.java, v 0.1 2020年06月11日 15:46 wb-zg494440 Exp $
 */
public abstract class BaseConvert<DO,MODEL> {
    public List<DO> convertToDoList(List<MODEL> list) {
        List<DO> doList = new ArrayList<>(list.size());
        for (MODEL model : list) {
            doList.add(convertToDo(model));
        }
        return doList;
    }

    public List<MODEL> convertToModelList(List<DO> doList) {
        List<MODEL> modelList = new ArrayList<>(doList.size());
        for (DO dataObject : doList) {
            modelList.add(convertToModel(dataObject));
        }
        return modelList;
    }
    public abstract DO convertToDo(MODEL model);

    public abstract MODEL convertToModel(DO dataObject);
}