package com.chengjs.risk.tools;

import com.chengjs.risk.enums.ConfigConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

/**
 * PropertiesUtil:
 * author: Chengjs, version:1.0.0, 2017-08-05
 */
public class PropertiesUtil {

  private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

  private static Properties prop = new Properties();

  static{
    try {
      prop.load(PropertiesUtil.class.getResourceAsStream(ConfigConstant.RISK_FIELD_PATH));

      //转码处理
      Set<Object> keyset = prop.keySet();
      Iterator<Object> iter = keyset.iterator();
      while (iter.hasNext()) {
        String key = (String) iter.next();
        String newValue = null;
        try {
          //属性配置文件自身的编码
          String propertiesFileEncode = ConfigConstant.CODE;
          newValue = new String(prop.getProperty(key).getBytes("ISO-8859-1"),propertiesFileEncode);
        } catch (UnsupportedEncodingException e) {
          newValue = prop.getProperty(key);
        }
        prop.setProperty(key, newValue);
      }

    } catch (Exception e) {
      logger.error("读取配置文件conf.properties出错！", e);
    }
  }

  public static Properties getProp() {
    return prop;
  }

}
