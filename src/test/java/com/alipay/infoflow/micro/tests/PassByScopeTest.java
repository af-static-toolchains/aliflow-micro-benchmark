package com.alipay.infoflow.micro.tests;

import com.alipay.infoflow.micro.code.basic.PassByScope;
import com.alipay.infoflow.util.TestConfig;
import org.junit.Assert;
import org.junit.Test;

public class PassByScopeTest {

    @Test
    public void testScope() {
        int actual = TestConfig.getDefault()
                .setResultRootDir("./work/PassByScopeTest#testScope")
                .rewriteEntrypoints("<" + PassByScope.class.getName() + ": void testScope()>\n")
                .setLogLevelDebug(true)
                .setDumpJimple(true)
                .run().getResultSize();
        Assert.assertEquals(1, actual);
    }
    @Test
    public void testScope1() {
        int actual = TestConfig.getDefault()
                .setResultRootDir("./work/PassByScopeTest#testScope1")
                .rewriteEntrypoints("<" + PassByScope.class.getName() + ": void testScope1()>\n")
                .run().getResultSize();
        Assert.assertEquals(1, actual);
    }
    @Test
    public void testScope2() {
        int actual = TestConfig.getDefault()
                .setResultRootDir("./work/PassByScopeTest#testScope2")
                .rewriteEntrypoints("<" + PassByScope.class.getName() + ": void testScope2()>\n")
                .run().getResultSize();
        Assert.assertEquals(1, actual);
    }
    @Test
    public void testScopeResultWithoutResult() {
        int actual = TestConfig.getDefault()
                .setResultRootDir("./work/PassByScopeTest#testScopeResultWithoutResult")
                .rewriteEntrypoints("<" + PassByScope.class.getName() + ": void testScopeResultWithoutResult()>\n")
                .setLogLevelDebug(true)
                .run().getResultSize();
        Assert.assertEquals(1, actual);
    }
    @Test
    public void testScopeResultWithoutResult2() {
        int actual = TestConfig.getDefault()
                .setResultRootDir("./work/PassByScopeTest#testScopeResultWithoutResult2")
                .rewriteEntrypoints("<" + PassByScope.class.getName() + ": void testScopeResultWithoutResult2()>\n")
                .setLogLevelDebug(true)
                .run().getResultSize();
        Assert.assertEquals(1, actual);
    }
}
