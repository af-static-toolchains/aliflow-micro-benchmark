# aliflow-micro-benchmark
A micro-benchmark for testing static taint analysis. Each test is like follows. The <b>rewriteEntrypoints</b> specifies the 
entry points, the <b>setSourceSinkConfigFile</b> specifies the sources and sinks, and the <b>setEasyTaintWrapperConfigFile</b> 
sepecifies the configuration files for taint propagation rules.

    @Test
    public void queryByNameTaint() {
        int actual = TestConfig.getDefault()
            .setResultRootDir("./work/SofaTaintTest#queryByNameTaint")
            .rewriteEntrypoints("<"+ SampleFacadeImplWrap.class.getName()+": void queryForPage(int,int)>\n")
            .setEasyTaintWrapperConfigFile(wrapperFile) // default: "./EasyTaintWrapperSource.txt"
            .setSourceSinkConfigFile(sourceFile) // default: "./SourcesAndSinks.txt"
            .run()
            .getResultSize();
        Assert.assertEquals(5, actual);
    }
