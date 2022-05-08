package com.qa.utils;

import com.qa.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private static Properties property = new Properties();

    static {

        try {
            FileInputStream file = new FileInputStream(FrameworkConstants.getConfigfilepath());
            property.load(file);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private PropertyUtils() {

    }

    public static String getValue(String key) throws Exception {
        if (Objects.isNull(property.getProperty(key.toLowerCase())) || Objects.isNull(key)) {
            throw new Exception("Property name " + key + " is not found.Please check configurations");
        }
        return property.getProperty(key.toLowerCase());

    }

}
