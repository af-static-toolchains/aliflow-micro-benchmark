package com.alipay.infoflow.micro.code.basic;

public class MyObject extends SuperObject{
  public String value = "hello";
  public void setValue(String v) {
    this.value = v;
  }
  public String getValue(){
    return this.value;
  }

  @Override
  public String fetchValue() {
    return this.value;
  }
}
