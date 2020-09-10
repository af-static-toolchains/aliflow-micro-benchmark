package com.alipay.infoflow.micro.tests;

import com.alipay.infoflow.micro.code.basic.fix.callgraph.FixCallGraph;
import com.alipay.infoflow.util.TestConfig;
import org.junit.Assert;
import org.junit.Test;

public class FixCallGraphTest {

    @Test
    public void convertImplTest() {
        int actual = TestConfig.getDefault()
                .setResultRootDir("./work/FixCallGraphTest.convertTest")
                .rewriteEntrypoints("<" + FixCallGraph.class.getName() + ": void convertImplTest()>\n")
                .setDumpCg(true).setDumpJimple(true)
                .run().getResultSize();
        Assert.assertEquals(1, actual);
    }
}
