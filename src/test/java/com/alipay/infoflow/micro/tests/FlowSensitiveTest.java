package com.alipay.infoflow.micro.tests;

import com.alipay.infoflow.micro.code.basic.FlowSensitive;
import com.alipay.infoflow.util.TestConfig;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
@Ignore
public class FlowSensitiveTest {
  @Test
  public void testAddToContainerOrder1() {
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/FlowSensitiveTest#testAddToContainerOrder1")
        .rewriteEntrypoints("<"+ FlowSensitive.class.getName() +": void testAddToContainerOrder1()>\n")
        .run().getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void testAddToContainerOrder2() {
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/FlowSensitiveTest#testAddToContainerOrder2")
        .rewriteEntrypoints("<"+ FlowSensitive.class.getName() +": void testAddToContainerOrder2()>\n")
        .run().getResultSize();
    Assert.assertEquals(1, actual);
  }

  /**
   * map container
   */
  @Test
  public void testAddToContainerOrder3() {
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/FlowSensitiveTest#testAddToContainerOrder3")
        .rewriteEntrypoints("<"+ FlowSensitive.class.getName() +": void testAddToContainerOrder3()>\n")
        .run().getResultSize();
    Assert.assertEquals(1, actual);
  }

  /**
   * map container double get
   */
  @Test
  public void testAddToContainerOrder4() {
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/FlowSensitiveTest#testAddToContainerOrder4")
        .rewriteEntrypoints("<"+ FlowSensitive.class.getName() +": void testAddToContainerOrder4()>\n")
        .run().getResultSize();
    Assert.assertEquals(1, actual);
  }

  /**
   * map container lambda double get
   */
  @Test @Ignore
  public void testAddToContainerOrder5() {
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/FlowSensitiveTest#testAddToContainerOrder5")
        .rewriteEntrypoints("<"+ FlowSensitive.class.getName() +": void testAddToContainerOrder5()>\n")
        .run().getResultSize();
    Assert.assertEquals(1, actual);
  }
   @Test
  public void testAddToObjectOrder0() {
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/FlowSensitiveTest#testAddToObjectOrder0")
        .rewriteEntrypoints("<"+ FlowSensitive.class.getName() +": void testAddToObjectOrder0()>\n")
        .setDumpJimple(true)
        .run().getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void testAddToObjectOrder1() {
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/FlowSensitiveTest#testAddToObjectOrder1")
        .rewriteEntrypoints("<"+ FlowSensitive.class.getName() +": void testAddToObjectOrder1()>\n")
        .run().getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test @Ignore
  public void testAddToObjectOrder2() {
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/FlowSensitiveTest#testAddToObjectOrder2")
        .rewriteEntrypoints("<"+ FlowSensitive.class.getName() +": void testAddToObjectOrder2()>\n")
        .run().getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void testAddToObjectOrder3() {
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/FlowSensitiveTest#testFlowsensitive3")
        .rewriteEntrypoints("<"+ FlowSensitive.class.getName() +": void testAddToObjectOrder3()>\n")
        .run().getResultSize();
    Assert.assertEquals(1, actual);
  }
  @Test
  public void testFlowsensitive() {
    int actual = TestConfig.getDefault()
        .setResultRootDir("./work/FlowSensitiveTest#testFlowsensitive")
        .rewriteEntrypoints("<"+ FlowSensitive.class.getName() +": void testFlowsensitive()>\n")
        .run().getResultSize();
    Assert.assertEquals(1, actual);
  }

}
