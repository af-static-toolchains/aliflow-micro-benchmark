package com.alipay.infoflow.micro.code.basic;

public class SinkObject {
  private String value = "hello";

  public String getValue(){
    return this.value;
  }

  public void setValue(String value) {
    this.value = value;
  }
  public String fetchValue() {
    return this.value;
  }
}
