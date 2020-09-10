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

    /**
     * executeInScope2Bridge->
     * executeInScope2->
     * BaseInScopeWithOutResult#invoke->
     * BaseInScope2#callback->
     * BaseInScope2$1#callbackReal->
     * InScope2$1#invoke : return source ->
     * BaseInScope2$1#callbackReal: value=source ->
     * executeInScope2Bridge : return MyObject ->
     * testScopeResultWithoutResult : sink fetchValue
     */
    public void testScopeResultWithoutResult() {
        MyObject a = new MyObject();
        a.value = SourceSink.fromSource();
        executeInScope2Bridge(new Invoke<String>() {

            @Override
            public void check() {
            }

            @Override
            public String invoke() {
                SourceSink.toSink(a.value);
                return null;
            }
        });
    }
    public void testScopeResultWithoutResult2() {
        MyObject a = new MyObject();
        a.setValue(SourceSink.fromSource());
        executeInScope2Bridge(new Invoke<String>() {

            @Override
            public void check() {
            }

            @Override
            public String invoke() {
                SourceSink.toSink(a.getValue());
                return null;
            }
        });
    }
    void executeInScope(InScope inScope) {
        inScope.invoke();
    }
    void executeInScope2(InScope2 inScope) {
        inScope.invoke();
    }
    MyObject executeInScope2Bridge(Invoke<String> invoke) {
        executeInScope2(new BaseInScope2(){
            @Override
            void callbackReal() {
                invoke.invoke();
            }
        });
        return null;
    }

    /**
     * InScope
     */
    public interface InScope{
        /**
         * invoke
         */
        void invoke();
    }

    /**
     * InScope has return
     * @param <T>
     */
    public interface InScope2<T>{
        T invoke();
    }

    /**
     * InScope has return and check
     * @param <T>
     */
    public interface Invoke<T> {
        void check();

        T invoke();
    }
    abstract class BaseInScopeWithOutResult implements InScope2{
        @Override
        public Object invoke() {
            callback();
            return null;
        }

        abstract void callback();
    }

    abstract class BaseInScope2 extends BaseInScopeWithOutResult{
        @Override
        void callback() {
            callbackReal();
        }
        abstract void callbackReal();
    }
}