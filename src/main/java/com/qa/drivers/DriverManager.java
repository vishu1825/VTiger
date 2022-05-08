package com.qa.drivers;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private DriverManager(){
    }

    private static final ThreadLocal<WebDriver> dr =new ThreadLocal<>();

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driverref) {
        dr.set(driverref);
    }

    public static void unload(){
        dr.remove();
    }
}
