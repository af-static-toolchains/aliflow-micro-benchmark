package com.alipay.infoflow.micro.code.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
  static MyObject buildSource(){
    MyObject ret = new MyObject();
    ret.value = SourceSink.fromSource();
    return ret;
  }

}

