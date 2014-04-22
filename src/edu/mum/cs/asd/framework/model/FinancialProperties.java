package edu.mum.cs.asd.framework.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FinancialProperties {

    private Properties properties;

    public FinancialProperties() {
        try {           
            properties = new Properties();
            
            properties.load(getClass().getClassLoader().getResourceAsStream("financial.properties"));
        } catch (FileNotFoundException e) {

        } catch (IOException ex) {
            Logger.getLogger(FinancialProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getProperty(String key) {
        String val = properties.getProperty(key);
        if (val == null) {
            val = properties.getProperty(key, "Button");
        }
        return val;
    }

}
