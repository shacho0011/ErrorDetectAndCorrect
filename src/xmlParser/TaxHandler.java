/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlParser;

import java.util.ArrayList;
import java.util.List;
import model.Tax;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Shadhin
 */
public class TaxHandler extends DefaultHandler {
    
    Tax tax = null;
    private List<Tax> taxList = null;
    
    public List<Tax> getTaxList() {
        return taxList;
    }
    
    boolean bFName = false;
    boolean bLName = false;
    boolean bGender = false;
    boolean bACode = false;
    boolean bPhone = false;
    boolean bCity = false;
    boolean bState = false;
    boolean bZip = false;
    boolean bMStatus = false;
    boolean bChild = false;
    boolean bSalary = false;
    boolean bRate = false;
    boolean bSingleExEmp = false;
    boolean bMarriedExEmp = false;
    boolean bChildExEmp = false;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("RECORD")) {
            tax = new Tax();
            if (taxList == null) {
                taxList = new ArrayList<>();
            }
        } else if (qName.equalsIgnoreCase("fname")) {
            bFName = true;
        } else if (qName.equalsIgnoreCase("lname")) {
            bLName = true;
        } else if (qName.equalsIgnoreCase("gender")) {
            bGender = true;
        } else if (qName.equalsIgnoreCase("areacode")) {
            bACode = true;
        } else if (qName.equalsIgnoreCase("phone")) {
            bPhone = true;
        } else if (qName.equalsIgnoreCase("city")) {
            bCity = true;
        } else if (qName.equalsIgnoreCase("state")) {
            bState = true;
        } else if (qName.equalsIgnoreCase("zip")) {
            bZip = true;
        } else if (qName.equalsIgnoreCase("maritalstatus")) {
            bMStatus = true;
        } else if (qName.equalsIgnoreCase("haschild")) {
            bChild = true;
        } else if (qName.equalsIgnoreCase("salary")) {
            bSalary = true;
        } else if (qName.equalsIgnoreCase("rate>")) {
            bRate = true;
        } else if (qName.equalsIgnoreCase("singleexemp")) {
            bSingleExEmp = true;
        } else if (qName.equalsIgnoreCase("marriedexemp")) {
            bMarriedExEmp = true;
        } else if (qName.equalsIgnoreCase("childexemp")) {
            bChildExEmp = true;
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("RECORD")) {
            taxList.add(tax);
            System.out.println("--");
        }
    }
    
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (bFName) {
            tax.setFname(new String(ch, start, length));
            bFName = false;
        } else if (bLName) {
            tax.setLname(new String(ch, start, length));
            bLName = false;
        } else if (bGender) {
            tax.setGender(new String(ch, start, length));
            bGender = false;
        } else if (bACode) {
            tax.setAreaCode(Integer.parseInt(new String(ch, start, length)));
            bACode = false;
        } else if (bPhone) {
            tax.setPhone(new String(ch, start, length));
            bPhone = false;
        } else if (bCity) {
            tax.setCity(new String(ch, start, length));
            bCity = false;
        } else if (bState) {
            tax.setState(new String(ch, start, length));
            bState = false;
        } else if (bZip) {
            tax.setZip(Integer.parseInt(new String(ch, start, length)));
            bZip = false;
        } else if (bMStatus) {
            tax.setMarritalStatus(new String(ch, start, length));
            bMStatus = false;
        } else if (bChild) {
            tax.setChildren(new String(ch, start, length));
            bChild = false;
        } else if (bSalary) {
            tax.setSalary(Integer.parseInt(new String(ch, start, length)));
            bSalary = false;
        } else if (bRate) {
            tax.setRate(Double.valueOf(new String(ch, start, length)));
            bRate = false;
        } else if (bSingleExEmp) {
            tax.setSingleEx(Integer.parseInt(new String(ch, start, length)));
            bSingleExEmp = false;
        } else if (bMarriedExEmp) {
            tax.setMarriedEx(Integer.parseInt(new String(ch, start, length)));
            bMarriedExEmp = false;
        } else if (bChildExEmp) {
            tax.setChildEx(Integer.parseInt(new String(ch, start, length)));
            bChildExEmp = false;
        }
    }
}
