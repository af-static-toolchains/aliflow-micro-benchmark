package com.alipay.infoflow.micro.code.basic;

public class MyOuterObject1 {

  public MyObject inner;

  public MyOuterObject1 setInner(MyObject obj) {
    this.inner = obj;
    return this;
  }
  public MyObject getInner(){
    return this.inner;
  }

  public MyOuterObject1 deepCopy(MyObject inner) {
    //mock as a native call, this taint is only propagated by easyTaintWrapper
    return new MyOuterObject1();
  }
  public Object deepCopy2(MyOuterObject1 inner) {
    //mock as a native call, this taint is only propagated by easyTaintWrapper
    return new MyOuterObject2();
  }
}
