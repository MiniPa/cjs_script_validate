package com.chengjs.risk.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * PropertiesUtil2:
 * author: Chengjs, version:1.0.0, 2017-08-05
 */
public class PropertiesUtil2 {

  private static final String RISK_PROP_PATH = "/risk-validate.properties";
  private static Properties prop = null;

  public static Properties getRiskProperties() {
    return prop;
  }

  private PropertiesUtil2() throws IOException {
    initChineseProp4();
  }

  private void initNormalProperties() throws IOException {
    prop = new Properties();
    prop.load(this.getClass().getResourceAsStream(RISK_PROP_PATH));
  }

  private void initChineseProp4() throws IOException { // null
    prop = new Properties();
    prop.load(new InputStreamReader(this.getClass().getResourceAsStream(RISK_PROP_PATH),"UTF-8"));
  }

  private void initChineseProp3() throws IOException { // null
    prop = new Properties();
    InputStream inputStream = this.getClass().getResourceAsStream(RISK_PROP_PATH);
    BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
    prop.load(bf);
  }

  private void initChineseProp2() throws IOException { // null
    prop = new Properties();
    prop.load(new InputStreamReader(
        PropertiesUtil2.class.getClassLoader().getResourceAsStream(RISK_PROP_PATH),
        "UTF-8"));
  }

  private Properties initChineseProp1() throws IOException { // 中文乱码
    if (prop == null) {
      synchronized (PropertiesUtil2.class) {
        if (prop == null) {
          prop = new Properties();
          InputStream inputStream = this.getClass().getResourceAsStream(RISK_PROP_PATH);
          BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
          prop.load(bf);
        }
      }
    }
    return prop;
  }
}
