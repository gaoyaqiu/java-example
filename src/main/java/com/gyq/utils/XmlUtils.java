package com.gyq.utils;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import java.io.*;
import java.util.*;

/**
 * xml处理工具类.
 *
 * @auther gaoyaqiu
 */
public class XmlUtils {

    /**
     * java 转换成xml
     *
     * @param obj 对象实例
     * @return String xml字符串
     */
    public static String toXml(Object obj) {
        XStream xstream = new XStream();
        //直接用jaxp dom来解释
        //XStream xstream=new XStream(new DomDriver());
        //XStream xstream=new XStream(new DomDriver("utf-8"));

        xstream.processAnnotations(obj.getClass());
        return xstream.toXML(obj);
    }

    /**
     * 将传入xml文本转换成Java对象
     *
     * @param xmlStr
     * @param cls    xml对应的class类
     * @return T   xml对应的class类的实例对象
     */
    public static <T> T toBean(String xmlStr, Class<T> cls) {
        // 注意：不是new Xstream(); 否则报错：java.lang.NoClassDefFoundError: org/xmlpull/v1/XmlPullParserFactory
        XStream xstream = new XStream(new DomDriver());
        xstream.processAnnotations(cls);
        T obj = (T) xstream.fromXML(xmlStr);
        return obj;
    }

    /**
     * 写到xml文件中去
     *
     * @param obj      对象
     * @param absPath  绝对路径
     * @param fileName 文件名
     * @return boolean
     */

    public static boolean toXMLFile(Object obj, String absPath, String fileName) throws IOException {
        String strXml = toXml(obj);
        String filePath = absPath + fileName;
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();

        }
        try (OutputStream ous = new FileOutputStream(file)) {
            ous.write(strXml.getBytes());
            ous.flush();
        }

        return true;
    }

    /**
     * 从xml文件读取报文
     *
     * @param absPath  绝对路径
     * @param fileName 文件名
     * @param cls
     * @return T
     * @throws Exception
     */
    public static <T> T toBeanFromFile(String absPath, String fileName, Class<T> cls) throws IOException {
        String filePath = absPath + fileName;
        InputStream ins = new FileInputStream(new File(filePath));

        XStream xstream = new XStream(new DomDriver("utf-8"));
        xstream.processAnnotations(cls);

        if (null != ins) {
            ins.close();
        }
        return (T) xstream.fromXML(ins);
    }

    /**
     * 将map转换xml字符串
     *
     * @param parameters
     * @return
     */
    public static String parseXML(Map<String, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry) it.next();
            String k = entry.getKey();
            String v = entry.getValue().toString();
            if (null != v && !"".equals(v) && !"appkey".equals(k)) {
                sb.append("<" + k + ">" + parameters.get(k) + "</" + k + ">\n");
            }
        }

        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * xml转map.
     *
     * @param xmlBytes
     * @param charset
     * @return
     * @throws Exception
     * @author
     */
    public static Map<String, String> toMap(byte[] xmlBytes, String charset) throws DocumentException {
        SAXReader reader = new SAXReader(false);
        InputSource source = new InputSource(new ByteArrayInputStream(xmlBytes));
        source.setEncoding(charset);
        Document doc = reader.read(source);
        Map<String, String> params = XmlUtils.toMap(doc.getRootElement());
        return params;
    }

    /**
     * xml转MAP.
     *
     * @param element
     * @return
     * @author
     */
    public static Map<String, String> toMap(Element element) {
        Map<String, String> rest = new HashMap<String, String>();
        List<Element> els = element.elements();
        for (Element el : els) {
            rest.put(el.getName().toLowerCase(), el.getTextTrim());
        }

        return rest;
    }

    /**
     * map转换xml字符串.
     *
     * @param params
     * @return
     */
    public static String toXml(Map<String, String> params) {
        StringBuilder buf = new StringBuilder();
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        buf.append("<xml>");
        for (String key : keys) {
            buf.append("<").append(key).append(">");
            buf.append("<![CDATA[").append(params.get(key)).append("]]>");
            buf.append("</").append(key).append(">\n");
        }

        buf.append("</xml>");
        return buf.toString();
    }

}
