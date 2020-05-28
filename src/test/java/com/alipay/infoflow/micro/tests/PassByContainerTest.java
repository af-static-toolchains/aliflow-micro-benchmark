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
        .setResultRootDir("./work/testNoContainer")
        .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void testNoContainer()>\n")
        .run()
        .getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void testList(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/testList")
        .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void testList()>\n")
        .run()
        .getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void testList1(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/testList1")
        .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void testList1()>\n")
        .run()
        .getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void testList2(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/testList2")
        .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void testList2()>\n")
        .run()
        .getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void testList3(){
      int actual = TestConfig.getDefault()
          .setResultRootDir("./work/testList3")
          .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void testList3()>\n")
          .run()
          .getResultSize();
      Assert.assertEquals(1, actual);
  }
  @Test
  public void testList4(){
      int actual = TestConfig.getDefault()
          .setResultRootDir("./work/testList4")
          .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void testList4()>\n")
          .run()
          .getResultSize();
      Assert.assertEquals(1, actual);
  }
  @Test
  public void multiClassTest(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/multiClassTest")
        .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void multiClassTest()>\n")
        .run()
        .getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void multiClassLambdaTest(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/multiClassLambdaTest")
        .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void multiClassLambdaTest()>\n")
        .run()
        .getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Ignore
  @Test
  public void multiClassLambdaTest2(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/multiClassLambdaTest2")
        .rewriteEntrypoints("<"+ PassByContainer.class.getName() +": void multiClassLambdaTest2()>\n")
        .run()
        .getResultSize();
    Assert.assertEquals(1, actual);
  }
}
