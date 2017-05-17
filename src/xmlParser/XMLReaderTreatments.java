/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlParser;

import domain.InsertData;
import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import model.Treatment;

/**
 *
 * @author Shadhin
 */
public class XMLReaderTreatments {

    int i;
    String filePath = "E:\\Education\\4.1\\thesis\\BART-Datasets\\customers-200k\\xml\\200k_treatments.xml";
    File input = new File(filePath);
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    InsertData insert = new InsertData();

    /*
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
                    int salary = Integer.parseInt(element.getElementsByTagName("salary").item(0).getTextContent());
                    Date date = Date.valueOf(element.getElementsByTagName("date").item(0).getTextContent());
                    String treat = element.getElementsByTagName("treatment").item(0).getTextContent();
                    String insurance = element.getElementsByTagName("insurance").item(0).getTextContent();
                    insert.insertTreatment(ssn, treat, date, treat, insurance);

                    System.out.println("SSN: " + element.getElementsByTagName("ssn").item(0).getTextContent());
                    System.out.println("Salary: " + element.getElementsByTagName("salary").item(0).getTextContent());
                    System.out.println("Date: " + element.getElementsByTagName("date").item(0).getTextContent());
                    System.out.println("Treatment: " + element.getElementsByTagName("treatment").item(0).getTextContent());
                    System.out.println("Insurance: " + element.getElementsByTagName("insurance").item(0).getTextContent());
                    //System.out.println("City: " + element.getElementsByTagName("city").item(0).getTextContent());
                    //System.out.println("Country Code: " + element.getElementsByTagName("cc").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\n----------------------------\nTotal Count: " + i);
    }
     */
    public void saxParser() {
        try {
            File inputFile = new File(filePath);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            TreatmentHandler handler = new TreatmentHandler();
            saxParser.parse(inputFile, handler);
            List<Treatment> mdList = handler.getTreatmentList();
            for (Treatment md : mdList) {
                insert.insertTreatment(md.getSsn(), md.getSalary(), md.getDate(), md.getTreat(), md.getInsurance());
                System.out.println(md);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
