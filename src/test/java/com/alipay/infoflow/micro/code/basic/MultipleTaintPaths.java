package com.alipay.infoflow.micro.code.basic;

import com.alipay.infoflow.micro.code.basic.MyObject;
import com.alipay.infoflow.micro.code.basic.SourceSink;

public class MultipleTaintPaths {
  public void main1() {
    MyObject o1 = serve1();
    MyObject o2 = serve2();
    show(o1);
    show(o2);
  }

  // From Flowdroid paper
  void main3 () {
    MyObject p = new MyObject() , p2 = new MyObject();
    taintIt (SourceSink.fromSource() , p );
    SourceSink.toSink(p.value);
    taintIt (" public ", p2 );
    SourceSink.toSink( p2.value);
  }
  void taintIt ( String in , MyObject out ) {
    MyObject x = out ;
    x.value = in ;
    SourceSink.toSink( out.value);
  }

  //TODO: more test cases
  public void main2() {
    //call context sensitive
    Identity identity = new Identity();
    identity.id = SourceSink.fromSource();
    toIdentity(identity.getId());
  }
  public void main4() {
    //call context sensitive
    Identity identity = new Identity();
    identity.id = SourceSink.fromSource();
    //SourceSink.toSink(identity.getId());
  }
  void toIdentity(String id) {
    Identity newid = new Identity();
    newid.id = id;
    SourceSink.toSink(newid.getId());
  }
  class Identity{
    String id;
    public String getId() {
      return id;
    }
    public void setId(String id) {
      this.id = id;
    }
  }

  public MyObject serve1(){
    return readSourceObject();
  }

  public MyObject serve2(){
    return readSourceObject();
  }

  public void show(MyObject o){
    SourceSink.toSink(o.fetchValue());
  }

  public MyObject readSourceObject(){
    MyObject a = new MyObject();
    a.value = SourceSink.fromSource();
    return a;
  }
}
