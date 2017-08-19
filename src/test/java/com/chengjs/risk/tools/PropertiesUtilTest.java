package com.chengjs.risk.tools;

import org.junit.Test;

import java.io.IOException;
import java.util.Properties;

/**
 * PropertiesUtilTest:
 * author: Chengjs, version:1.0.0, 2017-08-05
 */
public class PropertiesUtilTest {

  @Test
  public void propertiesLoadTest() throws IOException {
    Properties prop = PropertiesUtil.getProp();
    System.out.println(prop);
  }

}