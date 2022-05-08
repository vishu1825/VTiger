package com.qa.utils;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.qa.constants.FrameworkConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    private ExcelUtils() {

    }

    private static Map<String, String> testDataConfiguration = new HashMap<>();

    public static Map<String, String> readXlsPageObjects(String sqlQuery){
       testDataConfiguration = new HashMap<>();
        Fillo fillo = new Fillo();
        Connection connection ;
        Recordset recordset ;

        try {
            connection = fillo.getConnection(FrameworkConstants.getExcelFilePath());
            connection.executeUpdate(sqlQuery);
            recordset=connection.executeQuery(sqlQuery);
            List<String> fieldNames = recordset.getFieldNames();

            while(recordset.next()){
                for(String fieldName : fieldNames){
                    String fieldValue = recordset.getField(fieldName);
                    if(!fieldValue.isEmpty() && !(fieldName.equalsIgnoreCase("Serial"))
                            && !(fieldName.equalsIgnoreCase("Test_Case_Name"))) {
                        testDataConfiguration.put(fieldName , fieldValue);
                    }
                }
            }
            recordset.close();
            connection.close();
            return testDataConfiguration;

        }

        catch (FilloException e ){
            throw new RuntimeException("Please check the filepath and method are correct for " +e.getMessage());

        }


    }
}
