package com.silkaitis.utility;

import java.util.Properties;

/**
 * Utility class to load the properties ignoring case sensitivity.
 */
public class CaselessProperties extends Properties {

    public Object put(Object key, Object value) {
        String lowercase = ((String) key).toLowerCase();
        return super.put(lowercase, value);
    }

    public String getProperty(String key) {
        String lowercase = key.toLowerCase();
        return super.getProperty(lowercase);
    }

    public String getProperty(String key, String defaultValue) {
        String lowercase = key.toLowerCase();
        return super.getProperty(lowercase, defaultValue);
    }
}
