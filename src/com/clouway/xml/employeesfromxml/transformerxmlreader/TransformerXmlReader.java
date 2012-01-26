package com.clouway.xml.employeesfromxml.transformerxmlreader;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import java.io.File;

/**
 * Created by Krasimir Dimitrov
 * Date: 1/11/12
 * Time: 5:32 PM
 */
public class TransformerXmlReader {

    public static void main(String[] args) {
        try {
            String xmlFile = "Employees";
            File file = new File(xmlFile);
            if(file.exists()){
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(xmlFile);

                Transformer tFormer = TransformerFactory.newInstance().newTransformer();

                tFormer.setOutputProperty(OutputKeys.METHOD, "text");
                Source source = new DOMSource(doc);
                DOMResult result = new DOMResult();
                tFormer.transform(source,result);
                System.out.println(result.getNode());
            }
            else{
                System.out.println("File Not Found!");
            }
        } catch (Exception e) {
            System.err.println(e);
            System.exit(0);
        }
    }
}
