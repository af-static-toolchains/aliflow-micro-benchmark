package com.alipay.infoflow.micro.code.basic;

public class SourceSink {
  public static String fromSource() {
    return "source" + Math.random();
  }
  //sink method
  public static void toSink(String value){
    String.valueOf(value);
  }
}
