package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static void intConfigReader() {
        try {
            prop = new Properties();
            prop.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\qa_properties.properties"));
            // "E:\\uiAutomation\\src\\test\\resources\\config\\qa_properties.properties"
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getProp(String Key) {
        return prop.getProperty(Key);
    }
}
