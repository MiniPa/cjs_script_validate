package com.chengjs.risk.tools;

import com.chengjs.risk.enums.RiskTypeEnum;
import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Iterator;

/**
 * XMLUtilTest:
 * author: Chengjs, version:1.0.0, 2017-08-05
 */
public class XMLUtilTest {
  private static Logger logger = LoggerFactory.getLogger(XMLUtilTest.class);

  @Test
  public void XMLUtilTest() throws DocumentException, IOException {
    logger.debug("开始遍历风险配置");
    Element ele = XMLUtil.getFxElement(RiskTypeEnum.SS);
    Iterator it = ele.elementIterator();
    while (it.hasNext()) {
      Element risk = (Element) it.next();
      String code = risk.element("code").getTextTrim();
      String desc = risk.element("desc").getTextTrim();
      String level = risk.element("level").getTextTrim();
      String script = risk.element("script").getTextTrim();
      logger.debug("风险比对条件: " + code + desc + level + script);
    }
    logger.debug("结束遍历风险配置");
  }
}