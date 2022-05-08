package com.qa.constants;

import com.qa.enums.ConfigProperties;
import com.qa.utils.PropertyUtils;

public final class FrameworkConstants {

    private FrameworkConstants(){
    }

    private static final String RESOURCEPATH = System.getProperty("user.dir")+"/src/test/resources";
    private static final String CONFIGFILEPATH = RESOURCEPATH + "/config/config.properties";
    private static final String EXCELFILEPATH = RESOURCEPATH + "/excel/testdataexe.xlsx";
    private static final int EXPLICITWAIT = 10;
    private static final String EXTENTREPORTFOLDERTPATH = System.getProperty("user.dir")+ "/extent-test-output/";
    private static String extentReportFilePath = "";



    public static String getConfigfilepath(){
        return CONFIGFILEPATH;
    }
    public static String getExcelFilePath(){
        return EXCELFILEPATH;
    }

    public static int getExplicitWait(){
        return EXPLICITWAIT;
    }

    public static String getExtentReportFilePath() throws Exception {

        if(extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();

        }
        return extentReportFilePath;
    }

    private static String createReportPath() throws Exception {
        if(PropertyUtils.getValue(String.valueOf(ConfigProperties.OVERRIDEREPORTS)).equalsIgnoreCase("no")){
            return EXTENTREPORTFOLDERTPATH+System.currentTimeMillis()+"/index.html";
        }
        else {
            return EXTENTREPORTFOLDERTPATH+"/index.html";
        }
    }


}
