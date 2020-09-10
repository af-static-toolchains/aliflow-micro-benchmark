# ANTaint-micro-benchmark
A micro-benchmark for testing static taint analysis. Each test is like follows. The <b>rewriteEntrypoints</b> specifies the 
entry points, the <b>setSourceSinkConfigFile</b> specifies the sources and sinks, and the <b>setTaintWrapperConfigFile</b> 
sepecifies the configuration files for taint propagation rules. Please contact jagger.wj@antfin.com for more details.

    @Test
    public void queryByNameTaint() {
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryByNameTaint")
            .rewriteEntrypoints("<"+ SampleFacadeImplWrap.class.getName()+": void queryForPage(int,int)>\n")
            .setTaintWrapperConfigFile(wrapperFile) // default: "./EasyTaintWrapperSource.txt"
            .setSourceSinkConfigFile(sourceFile) // default: "./SourcesAndSinks.txt"
            .run()
            .getResultSize();
        Assert.assertEquals(5, actual);
    }
