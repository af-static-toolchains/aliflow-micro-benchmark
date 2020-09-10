package com.alipay.infoflow.micro.tests;

import com.alipay.infoflow.micro.code.basic.PassByContainer;
import com.alipay.infoflow.util.TestConfig;
import com.alipay.infoflow.util.TestRunner;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TestRunner.class)
public class PassByContainerTest {
  @Test
  public void testNoContainer(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/PassByContainerTest#testNoContainer")
        .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void testNoContainer()>\n")
        .run()
        .getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void testList(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/PassByContainerTest#testList")
        .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void testList()>\n")
        .run()
        .getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void testList1(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/#PassByContainerTesttestList1")
        .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void testList1()>\n")
        .run()
        .getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void testList2(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/PassByContainer#TesttestList2")
        .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void testList2()>\n")
        .run()
        .getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void testList3(){
      int actual = TestConfig.getDefault()
          .setResultRootDir("./work/PassByContainerTest#testList3")
          .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void testList3()>\n")
          .run()
          .getResultSize();
      Assert.assertEquals(1, actual);
  }
  @Test
  public void testList4(){
      int actual = TestConfig.getDefault()
          .setResultRootDir("./work/PassByContainerTest#testList4")
          .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void testList4()>\n")
          .run()
          .getResultSize();
      Assert.assertEquals(1, actual);
  }
  @Test
  public void testList6(){
      int actual = TestConfig.getDefault()
          .setResultRootDir("./work/PassByContainerTest#testList6")
          .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void testList6()>\n")
          .setDumpJimple(true)
          .run()
          .getResultSize();
      Assert.assertEquals(1, actual);
  }
  @Test
  public void multiClassTest(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/PassByContainerTest#multiClassTest")
        .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void multiClassTest()>\n")
        .run()
        .getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Ignore
  @Test
  public void multiClassLambdaTest(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/PassByContainerTest#multiClassLambdaTest")
        .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void multiClassLambdaTest()>\n")
        .run()
        .getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void streamCollectTest(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/PassByContainerTest#streamCollectTest")
        .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void streamCollectTest()>\n")
        .run()
        .getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void streamCollectTest2(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/PassByContainerTest#streamCollectTest2")
        .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void streamCollectTest2()>\n")
        .run()
        .getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Ignore
  @Test
  public void multiClassLambdaTest2(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/PassByContainerTest#multiClassLambdaTest2")
        .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void multiClassLambdaTest2()>\n")
        .run()
        .getResultSize();
    Assert.assertEquals(1, actual);
  }
}
