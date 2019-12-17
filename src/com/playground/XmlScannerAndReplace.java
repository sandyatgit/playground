package com.playground;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.HashMap;

/**
 * Created by z002bbt on 4/20/17.
 */
public class XmlScannerAndReplace {

    private static String xmlContent ;

    private static HashMap<String, Element> elementsMap = new HashMap<>();

    public static void main(String... s) throws Exception{
        DocumentBuilder builder =  DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse("test.xml");
        NodeList list = doc.getElementsByTagName("*");
        for(int z = 0; z < list.getLength(); z++){
            Element element = (Element) list.item(z);
            handleChildNodes(element);
        }
        convertDocToString(doc);
        removeMultiRefTags("test-ouput.xml");
    }

    private static void handleChildNodes(Element ele){
        NodeList list = ele.getElementsByTagName("*");
        for (int i = 0; i < list.getLength(); i++) {
            Element element = (Element) list.item(i);
            if(element.getNodeName().equalsIgnoreCase("multiRef")){
                Element eleTobeReplaced = elementsMap.get(element.getAttribute("id"));
                if(eleTobeReplaced != null){
                    eleTobeReplaced.appendChild(element);
                    NamedNodeMap atts = element.getAttributes();
                    for(int j=0; j < atts.getLength(); j++){
                        Node attr  = atts.item(j);
                        if(attr.getNodeName() != "id"){
                            eleTobeReplaced.setAttribute(attr.getNodeName(), attr.getNodeValue());
                        }
                    }
                    eleTobeReplaced.removeAttribute("href");
                }
            }else if(element.getAttribute("href") != ""){
                elementsMap.put(element.getAttribute("href").replace("#",""), element);
            }
            handleChildNodes(element);
        }
    }

    private static void convertDocToString(Document document) throws TransformerException, FileNotFoundException, UnsupportedEncodingException {
        StringWriter sw = new StringWriter();
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        transformer.transform(source, new StreamResult(sw));
        //OutputStreamWriter oo = new OutputStreamWriter(new FileOutputStream("test-ouput-tmp.xml"), "utf-8");
        //transformer.transform(source, new StreamResult(oo));
        xmlContent= sw.toString();
    }

    private static void removeMultiRefTags(String outputFileName){
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(outputFileName);
            bw = new BufferedWriter(fw);
            xmlContent = xmlContent.replaceAll("</multiRef>","");
            xmlContent = xmlContent.replaceAll("<multiRef(.*?)>","");
            bw.write(xmlContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}
