package com.alipay.infoflow.micro.tests;

import com.alipay.infoflow.micro.code.basic.Prune;
import com.alipay.infoflow.util.TestConfig;
import org.junit.Assert;
import org.junit.Test;

public class PruneTest {

  @Test public void testPruneByContextInfo0(){
    int actual = TestConfig.getDefault()
                .setResultRootDir("./work/PruneTest#testPruneByContextInfo0")
                .rewriteEntrypoints("<" + Prune.class.getName() + ": void pruneByContextInfo0()>\n")
                .setDumpJimple(true)
                .setLogLevelDebug(true)
                .run().getResultSize();
        Assert.assertEquals(1, actual);
  }
  @Test public void testPruneByContextInfo1(){
    int actual = TestConfig.getDefault()
                .setResultRootDir("./work/PruneTest#testPruneByContextInfo1")
                .rewriteEntrypoints("<" + Prune.class.getName() + ": void pruneByContextInfo1()>\n")
                .setDumpJimple(true)
                .setLogLevelDebug(true)
                .run().getResultSize();
        Assert.assertEquals(1, actual);
  }
}
