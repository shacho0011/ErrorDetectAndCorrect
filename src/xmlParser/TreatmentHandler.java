/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlParser;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Treatment;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Shadhin
 */
public class TreatmentHandler extends DefaultHandler {
    
    Treatment treatment = null;
    private List<Treatment> treatmentList = null;
    
    public List<Treatment> getTreatmentList() {
        return treatmentList;
    }

    boolean bssn = false;
    boolean bsalary = false;
    boolean bdate = false;
    boolean btreat = false;
    boolean binsurance = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if(qName.equalsIgnoreCase("RECORD")){
            treatment = new Treatment();
            if(treatmentList == null) treatmentList = new ArrayList<>();
        } else if (qName.equalsIgnoreCase("SSN")) {
            bssn = true;
        } else if (qName.equalsIgnoreCase("Salary")) {
            bsalary = true;
        } else if (qName.equalsIgnoreCase("Date")) {
            bdate = true;
        } else if (qName.equalsIgnoreCase("Treatment")) {
            btreat = true;
        } else if (qName.equalsIgnoreCase("Insurance")) {
            binsurance = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("RECORD")) {
            treatmentList.add(treatment);
            System.out.println("----------------");
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        if (bssn) {
            treatment.setSsn(new String(ch, start, length));
            bssn = false;
        } else if (bsalary) {
            treatment.setSalary(Integer.parseInt(new String(ch, start, length)));
            bsalary = false;
        } else if (bdate) {
            treatment.setDate(Date.valueOf(new String(ch, start, length)));
            bdate = false;
        } else if (btreat) {
            treatment.setTreat(new String(ch, start, length));
            btreat = false;
        } else if (binsurance) {
            treatment.setInsurance(new String(ch, start, length));
            binsurance = false;
        }
    }
}
