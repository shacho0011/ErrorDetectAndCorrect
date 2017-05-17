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
import model.Md;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Shadhin
 */
public class XMLReaderMd {

    int i;
    String filePath = "E:\\Education\\4.1\\thesis\\BART-Datasets\\employees-200k\\xml\\200ktuples_md.xml";
    File input = new File(filePath);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    InsertData insert = new InsertData();

    public void domParser() {
        try {
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(input);
            doc.getDocumentElement().normalize();
            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("md");

            System.out.println("----------------------------");

            for (i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                System.out.println("\nCurrent Element: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String dept = element.getElementsByTagName("dept").item(0).getTextContent();
                    int salary = Integer.parseInt(element.getElementsByTagName("salary").item(0).getTextContent());
                    String manager = element.getElementsByTagName("manager").item(0).getTextContent();
//                    insert.insertMd(name, dept, salary, manager);

                    //System.out.println("SSN: " + element.getElementsByTagName("ssn").item(0).getTextContent());
                    System.out.println("Name: " + element.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Department: " + element.getElementsByTagName("dept").item(0).getTextContent());
                    System.out.println("Salary: " + element.getElementsByTagName("salary").item(0).getTextContent());
                    System.out.println("Manager: " + element.getElementsByTagName("manager").item(0).getTextContent());
                    //System.out.println("City: " + element.getElementsByTagName("city").item(0).getTextContent());
                    //System.out.println("Country Code: " + element.getElementsByTagName("cc").item(0).getTextContent());
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
            MdHandler handler = new MdHandler();
            saxParser.parse(inputFile, handler);
            List<Md> mdList = handler.getMdList();
            for (Md md : mdList) {
                insert.insertMd(md.getName(), md.getDept(), md.getSalary(), md.getManager());
                System.out.println(md);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
