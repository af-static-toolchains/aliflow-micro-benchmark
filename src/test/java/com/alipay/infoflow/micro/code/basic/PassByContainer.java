package com.alipay.infoflow.micro.code.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class PassByContainer {
  static Logger logger = LoggerFactory.getLogger(PassByContainer.class);

  public void testNoContainer() {
    MyObject a = new MyObject();
    a.value = SourceSink.fromSource();
    SourceSink.toSink(a.fetchValue());
  }
  public void testList(){
    MyObject a = new MyObject();

    a.value = SourceSink.fromSource();
    List<MyObject> list = new ArrayList<>();
    list.add(a);
    SourceSink.toSink(list.get(0).value);
  }
  public void testList1(){
    MyObject a = new MyObject();
    a.value = SourceSink.fromSource();
    ArrayList<MyObject> list = new ArrayList<>();
    list.add(a);
    SourceSink.toSink(list.get(0).value);
  }
  public void testList2(){
    MyObject a = new MyObject();

    a.value = SourceSink.fromSource();
    List<MyObject> list = new ArrayList<>();
    list.add(a);
    SourceSink.toSink(list.get(0).getValue());
  }
  public void testList3(){
    MyObject a = new MyObject();

    a.value = SourceSink.fromSource();
    List<MyObject> list = new ArrayList<>();
    list.add(a);
    SourceSink.toSink(list.get(0).fetchValue());
  }
  public List<MyObject> readSourceList(){
    MyObject a = new MyObject();

    a.value = SourceSink.fromSource();
    List<MyObject> list = new ArrayList<>();
    list.add(a);
    return list;
  }
  public void testList4(){
    SourceSink.toSink(readSourceList().get(0).fetchValue());
  }

  public MyObject readSourceObject(){
    MyObject a = new MyObject();

    a.value = SourceSink.fromSource();
    return a;
  }
  public void testList5(){
    SourceSink.toSink(readSourceObject().value);
  }
  //source method
  public static String readSource() {
    return "source;" + Math.random();
  }

  public void multiClassTest(){
    List sources = new ArrayList();
    sources.add(buildSource());
    sources.add(buildSource());
    for (Object source : sources) {
      MyObject myObject = (MyObject) source;
      SourceSink.toSink(myObject.value);
    }
  }
  public void testList6(){
    MyObject a = new MyObject();

    a.value = SourceSink.fromSource();
    List<MyObject> list = new ArrayList<>();
    list.add(a);
    if(System.getProperty("yy").equals("xx")) {
      list = Collections.emptyList();
    }
    for(MyObject ele: list) {
      SourceSink.toSink(ele.fetchValue());
    }
  }
  public void multiClassLambdaTest(){
    List sources = new ArrayList();
    sources.add(buildSource());
    sources.add(buildSource());
    sources.forEach((source)->{
      MyObject myObject = (MyObject) source;
      SourceSink.toSink(myObject.value);
    });
  }
  public void multiClassLambdaTest2(){
    Set sources = new HashSet<>();
    sources.add(buildSource());
    sources.add(buildSource());
    sources.forEach((source)->{
      MyObject myObject = (MyObject) source;
      SourceSink.toSink(myObject.value);
    });
  }

  public void streamCollectTest(){
    Collection<MyObject> collection1 = new ArrayList();
    collection1.add(buildSource());
    Set<MyObject> collection2 = collection1.stream().filter(e -> false).collect(Collectors.toSet());
    collection2.forEach(source->SourceSink.toSink(source.value));
  }
  public void streamCollectTest2(){
    Collection<MyObject> collection1 = new ArrayList();
    collection1.add(buildSource());
    Set<String> collection2 = collection1.stream().map(o->o.value).collect(Collectors.toSet());
    collection2.forEach(SourceSink::toSink);
  }
  static MyObject buildSource(){
    MyObject ret = new MyObject();
    ret.value = SourceSink.fromSource();
    return ret;
  }

}

