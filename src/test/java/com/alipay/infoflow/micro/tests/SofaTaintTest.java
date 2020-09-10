package com.alipay.infoflow.micro.tests;

import com.alipay.infoflow.micro.code.sofa.dataobject.SampleDTO;
import com.alipay.infoflow.micro.code.sofa.dataobject.SampleResult;
import com.alipay.infoflow.micro.code.sofa.facade.SampleFacadeImplWrap;
import com.alipay.infoflow.util.TestConfig;
import com.alipay.infoflow.util.TestRunner;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * SampleTaintTest
 */
@RunWith(TestRunner.class)
public class SofaTaintTest {
    private static final String QUERY_BY_ID            = "<"+ SampleFacadeImplWrap.class.getName()+": void queryById(java.lang.Integer)>\n";
    private static final String QUERY_BY_NAME          = "<"+ SampleFacadeImplWrap.class.getName()+": void queryByName(java.lang.String)>\n";
    private static final String QUERY_BY_NAME_MAP_REFLECT = "<"+ SampleFacadeImplWrap.class.getName()+": void queryByNameMapReflect(java.lang.String)>\n";
    private static final String QUERY_BY_NAME2         = "<"+ SampleFacadeImplWrap.class.getName()+": void queryByName2(java.lang.String)>\n";
    private static final String QUERY_FOR_PAGE         = "<"+ SampleFacadeImplWrap.class.getName()+": void queryForPage(int,int)>\n";
    private static final String SINGLE_RESOLVE         = "<"+ SampleFacadeImplWrap.class.getName()+": void resolve("+ SampleDTO.class.getName() +")>\n";
    private static final String BATCH_RESOLVE          = "<"+ SampleFacadeImplWrap.class.getName()+": void resolve(java.util.List)>\n";
    private static final String BATCH_RESOLVE_MAP          = "<"+ SampleFacadeImplWrap.class.getName()+": void resolveMap(java.util.List)>\n";
    private static final String BATCH_RESOLVE_MAP2          = "<"+ SampleFacadeImplWrap.class.getName()+": void resolveMap2(java.util.List)>\n";
    private static final String QUERY_MAP1          = "<"+ SampleFacadeImplWrap.class.getName()+": void queryByIdListMap(int)>\n";
    private static final String QUERY_MAP2          = "<"+ SampleFacadeImplWrap.class.getName()+": void queryByName2Map(int)>\n";
    private static final String UPDATE_RID_BY_ID       = "<"+ SampleFacadeImplWrap.class.getName()+": void updateRid(java.lang.Integer,java.lang.String)>\n";
    private static final String UPDATE_RID_BY_NAME     = "<"+ SampleFacadeImplWrap.class.getName()+": void updateRid(java.lang.String,java.lang.String)>\n";
    private static final String QUERY_BY_NAME_RESULT   = "<"+ SampleFacadeImplWrap.class.getName()+": void queryByNameResult(java.lang.String)>\n";
    private static final String QUERY_BY_NAME_RESULT2  = "<"+ SampleFacadeImplWrap.class.getName()+": void queryByNameResult2()>\n";
    private static final String RESOLVE_SAMPLE_RESULT  = "<"+ SampleFacadeImplWrap.class.getName()+": void resolveSampleResult("+ SampleResult.class.getName() +")>\n";
    private static final String RESOLVE_TO_REFERENCE   = "<"+ SampleFacadeImplWrap.class.getName()+": void resolveToReference()>\n";
    private static final String RESOLVE_FROM_REFERENCE = "<"+ SampleFacadeImplWrap.class.getName()+": void resolveFromReference()>\n";
    public static final String SAVE_SAMPLE_BY_RESULT   = "<"+ SampleFacadeImplWrap.class.getName()+": void saveSampleByResult()>\n";
    public static final String SAVE_SAMPLE_BY_RESULT2  = "<"+ SampleFacadeImplWrap.class.getName()+": void saveSampleByResult2()>\n";
    public static final String QUERY_BY_CALLBACK1  = "<"+ SampleFacadeImplWrap.class.getName()+": void queryByCallback1(java.lang.Integer,java.lang.String)>\n";
    public static final String QUERY_BY_CALLBACK2  = "<"+ SampleFacadeImplWrap.class.getName()+": void queryByCallback2(java.lang.Integer,java.lang.String)>\n";
    public static final String QUERY_BY_CALLBACK3  = "<"+ SampleFacadeImplWrap.class.getName()+": void queryByCallback3(java.lang.Integer,java.lang.String)>\n";
    public static final String QUERY_BY_CALLBACK4  = "<"+ SampleFacadeImplWrap.class.getName()+": void queryByCallback4(java.lang.Integer,java.lang.String)>\n";
    public static final String QUERY_BY_CALLBACK5  = "<"+ SampleFacadeImplWrap.class.getName()+": void queryByCallback5(java.lang.Integer,java.lang.String)>\n";
    public static final String QUERY_BY_CALLBACK6  = "<"+ SampleFacadeImplWrap.class.getName()+": void queryByCallback6(java.lang.Integer,java.lang.String)>\n";

    /**
     * 2020.2.13 pass
     */
    @Test
    public void queryByIdTaint() {
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryByIdTaint")
            .rewriteEntrypoints(QUERY_BY_ID)
            .run()
            .getResultSize();
        Assert.assertEquals(5, actual);
    }

    /**
     * 2020.2.13 pass
     */
    @Test
    public void queryByNameTaint() {
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryByNameTaint")
            .rewriteEntrypoints(QUERY_BY_NAME)
            .run()
            .getResultSize();
        Assert.assertEquals(5, actual);
    }
    /**
     * 2020.2.13 pass
     */
    @Test
    public void queryByNameMapReflectTaint() {
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryByNameMapReflect")
            .rewriteEntrypoints(QUERY_BY_NAME_MAP_REFLECT)
            .setLogLevelDebug(true)
            .run()
            .getResultSize();
        Assert.assertEquals(5, actual);
    }

    /**
     * 2020.2.13 pass
     */
    @Test
    public void queryByName2Taint() {
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryByName2Taint")
            .rewriteEntrypoints(QUERY_BY_NAME2)
            .run()
            .getResultSize();
        Assert.assertEquals(4, actual);
    }

    /**
     * 2020.2.13 pass
     */
    @Test
    public void queryForPageTaint() {
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryForPageTaint")
            .rewriteEntrypoints(QUERY_FOR_PAGE)
            .run()
            .getResultSize();
        Assert.assertEquals(5, actual);
    }

    /**
     * 2020.2.13 pass
     */
    @Test
    public void queryAllTaint(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryAllTaint")
            .rewriteEntrypoints(QUERY_BY_ID + QUERY_BY_NAME + QUERY_FOR_PAGE)
            .run()
            .getResultSize();
        Assert.assertEquals(15, actual);
    }

    /**
     * 2020.2.13 pass
     */
    @Test
    public void singleResolve(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#singleResolve")
            .rewriteEntrypoints(SINGLE_RESOLVE)
            .run()
            .getResultSize();
        Assert.assertEquals(10, actual);
    }

    /**
     * 2020.2.13 pass
     */
    @Test
    public void batchResolve(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#batchResolve")
            .rewriteEntrypoints(BATCH_RESOLVE)
            .run()
            .getResultSize();
        Assert.assertEquals(10, actual);
    }

    /**
     */
    @Test
    public void batchResolveMap(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#batchResolveMap")
            .rewriteEntrypoints(BATCH_RESOLVE_MAP)
            .run()
            .getResultSize();
        Assert.assertEquals(5, actual);
    }
    /**
     */
    @Test
    public void batchResolveMap2(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#batchResolveMap2")
            .rewriteEntrypoints(BATCH_RESOLVE_MAP2)
            .run()
            .getResultSize();
        Assert.assertEquals(5, actual);
    }
    /**
     */
    @Test
    public void batchResolveMapAll(){
        int actual = TestConfig.getDefault()
                .setResultRootDir("./work/SofaTaintTest#batchResolveMapAll")
                .rewriteEntrypoints(BATCH_RESOLVE_MAP + BATCH_RESOLVE_MAP2)
                .run()
                .getResultSize();
        Assert.assertEquals(10, actual);
    }
    /**
     */
    @Test
    public void QUERY_MAP1(){
        int actual = TestConfig.getDefault()
                .setResultRootDir("./work/SofaTaintTest#queryMap1")
                .rewriteEntrypoints(QUERY_MAP1)
                .run()
                .getResultSize();
        Assert.assertEquals(3, actual);
    }
    /**
     */
    @Test
    public void QUERY_MAP2(){
        int actual = TestConfig.getDefault()
                .setResultRootDir("./work/SofaTaintTest#queryMap2")
                .rewriteEntrypoints(QUERY_MAP2)
                .run()
                .getResultSize();
        Assert.assertEquals(3, actual);
    }
    /**
     */
    @Test
    public void QUERY_MAPAll(){
        int actual = TestConfig.getDefault()
                .setResultRootDir("./work/SofaTaintTest#queryMapAll")
                .rewriteEntrypoints(QUERY_MAP1 + QUERY_MAP2)
                .run()
                .getResultSize();
        Assert.assertEquals(6, actual);
    }

    /**
     * 2020.2.13 pass
     * 2020.2.14 pass [expected should be 20]
     */
    @Test
    public void allResole(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#allResole")
            .rewriteEntrypoints(SINGLE_RESOLVE + BATCH_RESOLVE)
            .run()
            .getResultSize();
        Assert.assertEquals(20, actual);
    }

    /**
     * 2020.2.13 pass
     */
    @Test
    public void updateRidById(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#updateRidById")
            .rewriteEntrypoints(UPDATE_RID_BY_ID)
            .run()
            .getResultSize();
        Assert.assertEquals(8, actual);
    }

    /**
     * 2020.2.13 pass
     */
    @Test
    public void updateRidByName(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#updateRidByName")
            .rewriteEntrypoints(UPDATE_RID_BY_NAME)
            .run()
            .getResultSize();
        Assert.assertEquals(10, actual);
    }

    /**
     * 2020.2.13 pass
     * 2020.2.14 pass [expected should be 18]
     */
    @Test
    public void updateRidAll(){
      int actual = TestConfig.getDefault()
          .setResultRootDir("./work/SofaTaintTest#updateRidAll")
          .rewriteEntrypoints(UPDATE_RID_BY_ID + UPDATE_RID_BY_NAME)
          .run()
          .getResultSize();
      Assert.assertEquals(18, actual);
    }

    /**
     */
    @Test
    public void queryByNameResult(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryByNameResult")
            .rewriteEntrypoints(QUERY_BY_NAME_RESULT)
            .run()
            .getResultSize();
        Assert.assertEquals(5, actual);
    }

    /**
     * 2020.2.13 pass
     */
    @Test
    public void resolveSampleResult() {
      int actual = TestConfig.getDefault()
          .setResultRootDir("./work/SofaTaintTest#resolveSampleResult")
          .rewriteEntrypoints(RESOLVE_SAMPLE_RESULT)
          .run()
          .getResultSize();
      Assert.assertEquals(10, actual);
    }

    /**
     */
    @Test
    public void resolveToReference(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#resolveToReference")
            .rewriteEntrypoints(RESOLVE_TO_REFERENCE)
            .run()
            .getResultSize();
        Assert.assertEquals(5, actual);
    }

    /**
     * 2020.2.13 pass
     */
    @Test
    public void resolveFromReference() {
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#resolveFromReference")
            .rewriteEntrypoints(RESOLVE_FROM_REFERENCE)
            .run()
            .getResultSize();
        Assert.assertEquals(10, actual);
    }

    /**
     */
    @Ignore
    @Test
    public void saveAndQuery(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#saveSampleByResultAndQueryByNameResult")
            .rewriteEntrypoints(SAVE_SAMPLE_BY_RESULT + QUERY_BY_NAME_RESULT)
            .run()
            .getResultSize();
        Assert.assertEquals(16, actual);
    }

    @Test
    public void saveSampleByResult(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#saveSampleByResult")
            .rewriteEntrypoints(SAVE_SAMPLE_BY_RESULT)
            .run()
            .getResultSize();
        Assert.assertEquals(10, actual);
    }
    /**
     *      2020.2.13 pass
     */
    @Test
    public void saveSampleByResult2(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#saveSampleByResult2")
            .rewriteEntrypoints(SAVE_SAMPLE_BY_RESULT2 + QUERY_BY_NAME_RESULT2)
            .run()
            .getResultSize();
        Assert.assertEquals(10, actual);
    }

    @Test
    public void queryByCallBacks12(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryByCallBack12")
            .rewriteEntrypoints(QUERY_BY_CALLBACK1 + QUERY_BY_CALLBACK2)
            .run()
            .getResultSize();
        Assert.assertEquals(2, actual);
    }
    @Test
    public void queryByCallBacks13(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryByCallBack13")
            .rewriteEntrypoints(QUERY_BY_CALLBACK1 + QUERY_BY_CALLBACK3)
            .run()
            .getResultSize();
        Assert.assertEquals(2, actual);
    }
    @Test
    public void queryByCallBacks15(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryByCallBack13")
            .rewriteEntrypoints(QUERY_BY_CALLBACK1 + QUERY_BY_CALLBACK5)
            .run()
            .getResultSize();
        Assert.assertEquals(2, actual);
    }
    @Test
    public void queryByCallBack1(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryByCallBack1")
            .rewriteEntrypoints(QUERY_BY_CALLBACK1)
            .run()
            .getResultSize();
        Assert.assertEquals(1, actual);
    }
    @Ignore //the same with queryByCallBack1
    @Test
    public void queryByCallBack2(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryByCallBack2")
            .rewriteEntrypoints(QUERY_BY_CALLBACK2)
            .run()
            .getResultSize();
        Assert.assertEquals(1, actual);
    }
    @Test
    public void queryByCallBacks34(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryByCallBacks34")
            .rewriteEntrypoints(QUERY_BY_CALLBACK3 + QUERY_BY_CALLBACK4)
            .run()
            .getResultSize();
        Assert.assertEquals(2, actual);
    }
    @Test
    public void queryByCallBacks56(){
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryByCallBacks56")
            .rewriteEntrypoints(QUERY_BY_CALLBACK5 + QUERY_BY_CALLBACK6)
            .run()
            .getResultSize();
        Assert.assertEquals(2, actual);
    }
}
