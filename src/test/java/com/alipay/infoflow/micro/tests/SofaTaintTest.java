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
 *
 * @author wb-zg494440
 * @version $Id: SampleTaintTest.java, v 0.1 2019/11/12 20:09 wb-zg494440 Exp $
 * date 2019/11/12
 */
@RunWith(TestRunner.class)
public class SofaTaintTest {
    private static final String QUERY_BY_ID            = "<"+ SampleFacadeImplWrap.class.getName()+": void queryById(java.lang.Integer)>\n";
    private static final String QUERY_BY_NAME          = "<"+ SampleFacadeImplWrap.class.getName()+": void queryByName(java.lang.String)>\n";
    private static final String QUERY_BY_NAME2         = "<"+ SampleFacadeImplWrap.class.getName()+": void queryByName2(java.lang.String)>\n";
    private static final String QUERY_FOR_PAGE         = "<"+ SampleFacadeImplWrap.class.getName()+": void queryForPage(int,int)>\n";
    private static final String SINGLE_RESOLVE         = "<"+ SampleFacadeImplWrap.class.getName()+": void resolve("+ SampleDTO.class.getName() +")>\n";
    private static final String BATCH_RESOLVE          = "<"+ SampleFacadeImplWrap.class.getName()+": void resolve(java.util.List)>\n";
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
     * 只报出一条
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
    public void queryByName2Taint() {
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryByName2Taint")
            .rewriteEntrypoints(QUERY_BY_NAME2)
            .run()
            .getResultSize();
        Assert.assertEquals(4, actual);
    }

    /**
     * 问题: 只报出rid和uuid两条path
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
     * 问题: sourceMethod与sinkMethod与实际path不符
     * 如: 从 SampleDaoImpl.queryById -> SampleFacadeImplWrap.queryByName  是错误的一条path
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
     * 问题: 无结果  ,found 6 sources and 5 sinks, Obtainted 1 connections between sources and sinks 5times
     * 2020.2.12 no sources found
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
     * found connections 8 lines
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
     * 问题: 无论DOSub的ID是否为null，sink method都是insert 【已解决】
     * found connections 5 lines
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
     * rid是外部传入,type有枚举转换不算应有8条path
     * 实际9条path
     * SampleDaoImpl.queryById -> SampleDaoImpl.insert 的rid 字段误报
     * found connections 9 lines
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
     * Object result return expect 6 path
     * 2019.12.10 found 5 path, omission 1 path( ext)
     * 2020.2.12 found connection 5 lines found 5 path
     * FIXME later samples.stream().findFirst().ifPresent(s -> result.getExt().put("rid", s.getRid()));
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
     * Object result argument expect 4 path
     * found connection 5 lines found 5 path
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
     * service reference write   include map expect 5 path
     * 2019.12.9 map那条path漏报
     * 2020.2.12 found connection 5 lines found 5 path
     * FIXME later samples.stream().findFirst().ifPresent(s -> result.getExt().put("rid", s.getRid()));
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
     * service reference write expect 4 path
     * found connections 5 lines found 5 paths
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
     * {@link SampleFacadeImplWrap#saveSampleByResult()}
     * {@link SampleFacadeImplWrap#queryByNameResult(String)}
     * found connections 10 lines found 10 path
     * FIXME later samples.stream().findFirst().ifPresent(s -> result.getExt().put("rid", s.getRid()));
     */
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
     * {@link SampleFacadeImplWrap#saveSampleByResult2()}
     * {@link SampleFacadeImplWrap#queryByNameResult2()}
     * 误报  SampleDOSubSource -> SampleDOSubSink
     * 预期  SampleDOSubSource -> SampleResultWrapSink
     *      SampleResultWrapSource -> SampleDOSubSink （漏报）
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
