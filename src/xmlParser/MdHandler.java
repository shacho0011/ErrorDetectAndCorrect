/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlParser;

import java.util.ArrayList;
import java.util.List;
import model.Md;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Shadhin
 */
public class MdHandler extends DefaultHandler {

    Md md = null;
    private List<Md> mdList = null;
    
    public List<Md> getMdList() {
        return mdList;
    }

    boolean bName = false;
    boolean bDept = false;
    boolean bSalary = false;
    boolean bManager = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if(qName.equalsIgnoreCase("md")){
            md =new Md();
            if(mdList==null) mdList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("dept")) {
            bDept = true;
        } else if (qName.equalsIgnoreCase("salary")) {
            bSalary = true;
        } else if (qName.equalsIgnoreCase("manager")) {
            bManager = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("md")) {
            mdList.add(md);
//            System.out.println("--------------------");
        }
    }
    String name, dept, salary, manager;

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (bName) {
            md.setName(new String(ch, start, length));
//            System.out.println("Name: " + name);
            bName = false;
        } else if (bDept) {
            md.setDept(new String(ch, start, length));
//            System.out.println("Dept: " + dept);
            bDept = false;
        } else if (bSalary) {
            md.setSalary(Integer.parseInt(new String(ch, start, length)));
//            System.out.println("Salary: " + salary);
            bSalary = false;
        } else if (bManager) {
            md.setManager(new String(ch, start, length));
//            System.out.println("Manager: " + manager);
            bManager = false;
        }
//        System.out.println("Name: " + name);
//        System.out.println("Dept: " + dept);
//        System.out.println("Salary: " + salary);
//        System.out.println("Manager: " + manager);
    }
}
