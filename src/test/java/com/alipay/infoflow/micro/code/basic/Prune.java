package com.alipay.infoflow.micro.code.basic;

public class Prune {
  void pruneByContextInfo0() {
    SourceSink.toSink(queryByName().getValue());
  }
  void pruneByContextInfo1() {
    MyObject myObject = execute(new Invoker() {
      @Override
      public String invoke() {
        return queryByName().getValue();
      }
    });
    SourceSink.toSink(myObject.getValue());
  }

  //----------------------
  MyObject queryByName() {
    return execute(new Invoker() {
      @Override
      public String invoke() {
        return SourceSink.fromSource();
      }
    });
  }

  MyObject execute(Invoker invoker) {
    String res = invoker.invoke();
    MyObject my = new MyObject();
    my.setValue(res);
    return my;
  }

  interface Invoker {
    String invoke();
  }
}
