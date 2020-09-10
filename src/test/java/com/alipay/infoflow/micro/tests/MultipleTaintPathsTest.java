package com.alipay.infoflow.micro.tests;

import com.alipay.infoflow.micro.code.basic.MultipleTaintPaths;
import com.alipay.infoflow.util.TestConfig;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class MultipleTaintPathsTest {
  @Test
  public void testMultiplePaths1(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/MultipleTaintPathsTest#testMultiplePaths1")
        .rewriteEntrypoints("<"+ MultipleTaintPaths.class.getName() +": void main1()>\n")
        .run().getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void testMultiplePaths2(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/MultipleTaintPathsTest#testMultiplePaths2")
        .rewriteEntrypoints("<"+ MultipleTaintPaths.class.getName() +": void main2()>\n")
        .run().getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Ignore
  @Test
  public void testMultiplePaths4(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/MultipleTaintPathsTest#testMultiplePaths4")
        .rewriteEntrypoints("<"+ MultipleTaintPaths.class.getName() +": void main4()>\n")
        .run().getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Ignore
  @Test
  public void testMultiplePaths3(){
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/MultipleTaintPathsTest#testMultiplePaths3")
        .rewriteEntrypoints("<"+ MultipleTaintPaths.class.getName() +": void main3()>\n")
        .run().getResultSize();
    Assert.assertEquals(2, actual);
  }
}
