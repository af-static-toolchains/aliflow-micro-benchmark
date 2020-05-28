package com.alipay.infoflow.micro.code.basic;

public class MyOuterObject2 {

  private MyObject inner;

  public MyOuterObject2 setInner(MyObject obj) {
    this.inner = obj;
    return this;
  }
  public MyObject getInner(){
    return this.inner;
  }
}
