package com.chengjs.risk.tools;

import com.chengjs.risk.enums.ConfigConstant;
import com.chengjs.risk.enums.RiskTypeEnum;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * XMLUtil: XML解析工具类 方式DOM4J
 * 用来解析Risk配置XML文件
 * 参考网址 http://www.cnblogs.com/Qian123/p/5231303.html
 * author: Chengjs, version:1.0.0, 2017-08-05
 */
public class XMLUtil {

  private static final Logger logger = LoggerFactory.getLogger(XMLUtil.class);
  private static Element rootElement = null;

  /**
   * RiskElementTitle为risk-validate中配置的针对 不同种类风险的 二级元素标签名称
   * @param riskElementTitle @see com.chengjs.risk.enums.RiskTypeEnum
   * @param riskElementTitle
   * @return
   */
  public static Element getFxElement(RiskTypeEnum riskElementTitle) throws DocumentException, IOException {
    if (rootElement == null) {
      synchronized (XMLUtil.class) {
        if (rootElement == null) {
          SAXReader saxReader = new SAXReader();
          File f = new File(XMLUtil.class.getResource("/").getPath() + ConfigConstant.RISK_PATH);
          Document doc = saxReader.read(f);
          rootElement = doc.getRootElement();
          logger.debug("解析文件获取rootElement");
        }
      }
    }
    return rootElement.element(String.valueOf(riskElementTitle).toLowerCase());
  }

  /**
   * 测试各种路径获取方式
   */
  private void testFilePath() throws IOException {
    // 第一种：获取类加载的根路径   E:\programers\wsp_svn_servyou\risk-validate\target\test-classes
    File f = new File(XMLUtil.class.getResource("/").getPath());
    System.out.println(f);

    // 获取当前类的所在工程路径; 如果不加“/”  获取当前类的加载目录
    // E:\programers\wsp_svn_servyou\risk-validate\target\test-classes\com\chengjs\risk\tools
    File f2 = new File(XMLUtil.class.getResource("").getPath());
    System.out.println(f2);

    // 第二种：获取项目路径    E:\programers\wsp_svn_servyou\risk-validate
    File directory = new File("");// 参数为空
    String courseFile = directory.getCanonicalPath();
    System.out.println(courseFile);

    // 第三种：  file:/E:/programers/wsp_svn_servyou/risk-validate/target/test-classes/
    URL xmlpath = XMLUtil.class.getClassLoader().getResource("");
    System.out.println(xmlpath);

    // 第四种： E:\programers\wsp_svn_servyou\risk-validate
    System.out.println(System.getProperty("user.dir"));
         /*
          * 结果： C:\Documents and Settings\Administrator\workspace\projectName
          * 获取当前工程路径
          */

    // 第五种：  获取所有的类路径 包括jar包的路径
    System.out.println(System.getProperty("java.class.path"));
  }

}
