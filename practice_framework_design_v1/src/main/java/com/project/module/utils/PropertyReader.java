package com.project.module.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private Properties properties;

    public PropertyReader()
    {
        properties = new Properties();
        try {
            FileInputStream input=new FileInputStream(System.getProperty("user.dir")+"\\configurations\\GlobalProperties.propertise");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

}
