package com.alipay.infoflow.micro.tests;

import com.alipay.infoflow.micro.code.basic.DeepCopy;
import com.alipay.infoflow.util.TestConfig;
import org.junit.Assert;
import org.junit.Test;

public class DeepCopyTest {

  @Test
  public void testDeepCopy1() {
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/testDeepCopy1")
        .rewriteEntrypoints("<"+ DeepCopy.class.getName() +": void testDeepCopy()>\n")
        .run().getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void testDeepCopy2() {
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/testDeepCopy1")
        .rewriteEntrypoints("<"+DeepCopy.class.getName()+": void testDeepCopy2()>\n")
        .run().getResultSize();
    Assert.assertEquals(1, actual);
  }
}
