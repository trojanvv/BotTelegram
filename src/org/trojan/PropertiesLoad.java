package org.trojan;

import java.io.*;
import java.util.Properties;

public class PropertiesLoad {

    private final Properties properties = new Properties();
    private static PropertiesLoad INSTANCE = null;

    private PropertiesLoad() {
        try {
            InputStream inR = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
            BufferedReader br = new BufferedReader(new InputStreamReader(inR,"windows-1251"));
            properties.load(br);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean init() {
        if (INSTANCE == null) {
            INSTANCE = new PropertiesLoad();
        }
        return true;
    }

    public static String getVar(String varName) {
        if (System.getProperty(varName) != null) {
            return System.getProperty(varName);
        } else if (INSTANCE.properties.getProperty(varName) != null) {
            return INSTANCE.properties.getProperty(varName);
        } else {
            return null;
        }
    }

    public static void setVar(String varName, String value) {
        if (System.getProperty(varName) != null) {
            System.setProperty(varName, value);
        } else if (INSTANCE.properties.getProperty(varName) != null) {
            INSTANCE.properties.setProperty(varName, value);
        } else {
            throw new RuntimeException("Переменной " + varName + " нет в списке переменных. .properties");
        }
    }
}
