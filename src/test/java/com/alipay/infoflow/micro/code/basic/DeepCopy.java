package com.alipay.infoflow.micro.code.basic;

import com.alipay.infoflow.micro.code.basic.MyObject;
import com.alipay.infoflow.micro.code.basic.MyOuterObject1;
import com.alipay.infoflow.micro.code.basic.MyOuterObject2;
import com.alipay.infoflow.micro.code.basic.SourceSink;

import java.util.HashMap;
import java.util.Map;

public class DeepCopy {

  public void testDeepCopy(){
    MyObject a = new MyObject();
    a.value = SourceSink.fromSource();
    MyOuterObject1 b = new MyOuterObject1();
    b.setInner(a); //b.inner.value is tainted
    MyOuterObject2 c = (MyOuterObject2) b.deepCopy2(b); // b.inner.value -> c.inner.value
    SourceSink.toSink(c.getInner().fetchValue());
  }

  public void testDeepCopy2(){
    MyObject a = new MyObject();
    a.value = SourceSink.fromSource();
    MyOuterObject1 b = new MyOuterObject1();
    b.setInner(a); //b.inner.value is tainted
    MyOuterObject2 c = (MyOuterObject2) b.deepCopy2(b); // b.inner.value -> c.inner.value
    Map<String, MyOuterObject2> map = new HashMap();
    map.put("key", c);

    SourceSink.toSink(map.get("key").getInner().fetchValue());
  }
}
