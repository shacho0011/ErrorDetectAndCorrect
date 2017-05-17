/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlParser;

import domain.InsertData;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Shadhin
 */
public class XMLReaderCustomer {

    int i;
    String filePath = "E:\\Education\\4.1\\thesis\\BART-Datasets\\customers-200k\\xml\\200k_customers.xml";
    File input = new File(filePath);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    InsertData insert = new InsertData();
    public void domParser() {
        
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(input);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("RECORD");

            System.out.println("----------------------------");

            for (i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                System.out.println("\nCurrent Element: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    
                    String ssn = element.getElementsByTagName("ssn").item(0).getTextContent();
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String phone = element.getElementsByTagName("phone").item(0).getTextContent();
                    double cfPhone =Double.parseDouble(element.getElementsByTagName("cfphone").item(0).getTextContent());
                    String street = element.getElementsByTagName("str").item(0).getTextContent();
                    String city = element.getElementsByTagName("city").item(0).getTextContent();
                    int countryCode = Integer.parseInt(element.getElementsByTagName("cc").item(0).getTextContent());
                    insert.insertCustomer(ssn, name, phone, cfPhone, street, city, countryCode);

                    System.out.println("SSN: " + element.getElementsByTagName("ssn").item(0).getTextContent());
                    System.out.println("Name: " + element.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Phone: " + element.getElementsByTagName("phone").item(0).getTextContent());
                    System.out.println("CFPhone: " + element.getElementsByTagName("cfphone").item(0).getTextContent());
                    System.out.println("Street: " + element.getElementsByTagName("str").item(0).getTextContent());
                    System.out.println("City: " + element.getElementsByTagName("city").item(0).getTextContent());
                    System.out.println("Country Code: " + element.getElementsByTagName("cc").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n----------------------------\nTotal Count: " + i);
    }
}
