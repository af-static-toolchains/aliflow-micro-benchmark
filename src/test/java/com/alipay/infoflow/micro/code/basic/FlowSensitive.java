package com.alipay.infoflow.micro.code.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class FlowSensitive {
  public void testAddToContainerOrder1(){
    List<MyObject> list = new ArrayList<>();
    MyObject a = new MyObject();
    list.add(a);
    taintIt(a);

    SourceSink.toSink(list.get(0).fetchValue());
  }
  public void testAddToContainerOrder2(){
    List<MyObject> list = new ArrayList<>();
    MyObject a = new MyObject();
    list.add(a);
    taintIt(list.get(0));

    SourceSink.toSink(list.get(0).fetchValue());
  }

  /**
   * map container
   */
  public void testAddToContainerOrder3(){
    Map<String, MyObject> map = new HashMap<>();
    MyObject a = new MyObject();
    map.put(String.valueOf(a), a);
    taintIt(a);
    SourceSink.toSink(map.get(null).fetchValue());
  }

  /**
   * map container double get
   */
  public void testAddToContainerOrder4(){
    Map<String, MyObject> map = new HashMap<>();
    MyObject a = new MyObject();
    map.put(null, a);
    taintIt(map.get(null));
    SourceSink.toSink(map.get(null).fetchValue());
  }

  /**
   * container 跨body
   */
  public void testAddToContainerOrder5(){
    Map<String, MyObject> map = new HashMap<>();
    Supplier<Map<String, MyObject>> supplier = () -> map;
    MyObject a = new MyObject();
    supplier.get().put(null, a);
    taintIt(supplier.get().get(null));
    SourceSink.toSink(supplier.get().get(null).fetchValue());
  }
  public void testAddToObjectOrder0(){
    MyOuterObject1 b = new MyOuterObject1();
    MyObject a = new MyObject();
    b.inner = a; // { b.inner = a }
    taintIt(a);

    SourceSink.toSink(b.getInner().fetchValue());
  }
  public void testAddToObjectOrder3(){
    MyOuterObject1 b = new MyOuterObject1();
    MyObject a = new MyObject();
    b.inner = a;
    a.value = SourceSink.fromSource();
    SourceSink.toSink(b.getInner().fetchValue());
  }
  public void testAddToObjectOrder1(){
    MyOuterObject1 b = new MyOuterObject1();
    MyObject a = new MyObject();
    b.setInner(a); // { b.inner = a }
    taintIt(a);

    SourceSink.toSink(b.getInner().fetchValue());
  }
  public void testAddToObjectOrder2(){
    MyOuterObject1 b = new MyOuterObject1();
    MyObject a = new MyObject();
    b.setInner(a); // b.inner = a
    taintIt(b.getInner());

    SourceSink.toSink(b.getInner().fetchValue());
  }
  public void taintIt(MyObject a) {
    a.value = SourceSink.fromSource();
  }
  public void testFlowsensitive() {
    String src = SourceSink.fromSource();
    MyObject object = new MyObject();
    taintIt(src, object);
    SourceSink.toSink(object.value);
  }
  public void taintIt(String in,  MyObject out){
    out.value = in;
  }
}
