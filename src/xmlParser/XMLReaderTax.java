/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlParser;

import domain.InsertData;
import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import model.Tax;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Shadhin
 */
public class XMLReaderTax {
    int i;
    String filePath = "E:\\Education\\4.1\\thesis\\BART-Datasets\\tax-200k\\xml\\200k_tax.xml";
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

            for (i = 0; i < 100; i++) {
                Node node = nList.item(i);
                System.out.println("\nCurrent Element: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    
                    String fname = element.getElementsByTagName("fname").item(0).getTextContent();
                    String lname = element.getElementsByTagName("lname").item(0).getTextContent();
                    String gender = element.getElementsByTagName("gender").item(0).getTextContent();
                    int areaCode = Integer.parseInt(element.getElementsByTagName("areacode").item(0).getTextContent());
                    String phone = element.getElementsByTagName("phone").item(0).getTextContent();
                    String city = element.getElementsByTagName("city").item(0).getTextContent();
                    String state = element.getElementsByTagName("state").item(0).getTextContent();
                    int zip = Integer.parseInt(element.getElementsByTagName("zip").item(0).getTextContent());
                    String marritalStatus = element.getElementsByTagName("maritalstatus").item(0).getTextContent();
                    int child = Integer.parseInt(element.getElementsByTagName("haschild").item(0).getTextContent());
                    int salary = Integer.parseInt(element.getElementsByTagName("salary").item(0).getTextContent());
                    double rate = Double.parseDouble(element.getElementsByTagName("rate").item(0).getTextContent());
                    int singleEx = Integer.parseInt(element.getElementsByTagName("singleexemp").item(0).getTextContent());
                    int marriedEx = Integer.parseInt(element.getElementsByTagName("marriedexemp").item(0).getTextContent());
                    int childEx = Integer.parseInt(element.getElementsByTagName("childexemp").item(0).getTextContent());
//                    insert.insertTax(fname, lname, gender, areaCode, phone, city, state, zip, marritalStatus, child, salary, rate, singleEx, marriedEx, childEx);
                    
                    System.out.println("First Name: " + element.getElementsByTagName("fname").item(0).getTextContent());
                    System.out.println("Last Name: " + element.getElementsByTagName("lname").item(0).getTextContent());
                    System.out.println("Gender: " + element.getElementsByTagName("gender").item(0).getTextContent());
                    System.out.println("Area Code: " + element.getElementsByTagName("areacode").item(0).getTextContent());
                    System.out.println("Phone: " + element.getElementsByTagName("phone").item(0).getTextContent());
                    System.out.println("City: " + element.getElementsByTagName("city").item(0).getTextContent());
                    System.out.println("State: " + element.getElementsByTagName("state").item(0).getTextContent());
                    System.out.println("Zip: " + element.getElementsByTagName("zip").item(0).getTextContent());
                    System.out.println("Marital Status: " + element.getElementsByTagName("maritalstatus").item(0).getTextContent());
                    System.out.println("Child: " + element.getElementsByTagName("haschild").item(0).getTextContent());
                    System.out.println("Salary: " + element.getElementsByTagName("salary").item(0).getTextContent());
                    System.out.println("Rate: " + element.getElementsByTagName("rate").item(0).getTextContent());
                    System.out.println("Single Ex-Emp: " + element.getElementsByTagName("singleexemp").item(0).getTextContent());
                    System.out.println("Married Ex-Emp: " + element.getElementsByTagName("marriedexemp").item(0).getTextContent());
                    System.out.println("Child Ex-Emp: " + element.getElementsByTagName("childexemp").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n----------------------------\nTotal Count: " + i);
    }
    
    
    public void saxParser() {
        try {
            File inputFile = new File(filePath);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            TaxHandler handler = new TaxHandler();
            saxParser.parse(inputFile, handler);
            List<Tax> taxList = handler.getTaxList();
            for (Tax tax : taxList) {
                insert.insertTax(tax.getFname(), tax.getLname(), tax.getGender(), tax.getAreaCode(), tax.getPhone(), tax.getCity(), tax.getState(), tax.getZip(), tax.getMarritalStatus(), tax.getChildren(), tax.getSalary(), tax.getRate(), tax.getSingleEx(), tax.getMarriedEx(), tax.getChildEx());
            }
            System.out.println("Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
