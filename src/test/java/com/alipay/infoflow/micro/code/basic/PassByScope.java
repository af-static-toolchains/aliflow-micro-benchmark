/**
 * Alipay.com Inc. Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.alipay.infoflow.micro.code.basic;

/**
 *
 * @author comfan
 * @version $Id: PassByScope.java, v 0.1 2020年03月27日 17:29 comfan Exp $
 */
public class PassByScope {
    public void testScope() {
        String src = SourceSink.fromSource();
        MyObject a = new MyObject();
        new InScope(){
            @Override
            public void invoke() {
                a.value = src;
            }
        }.invoke();

        SourceSink.toSink(a.fetchValue());
    }
    public void testScope1() {
        MyObject a = new MyObject();
        new InScope(){
            @Override
            public void invoke() {
                a.value = SourceSink.fromSource();
            }
        }.invoke();

        SourceSink.toSink(a.fetchValue());
    }
    public void testScope2() {
        MyObject a = new MyObject();
        executeInScope(new InScope(){
            @Override
            public void invoke() {
                a.setValue(SourceSink.fromSource());
            }
        });
        SourceSink.toSink(a.fetchValue());
    }

    void executeInScope(InScope inScope) {
        inScope.invoke();
    }

    public interface InScope{
        /**
         * invoke
         */
        void invoke();
    }
}