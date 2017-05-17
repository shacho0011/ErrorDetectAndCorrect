/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisproject;

import domain.GetAttributeSet;
import xmlParser.XMLReaderTreatments;

/**
 *
 * @author Shadhin
 */
public class ThesisProject {

    /**
     * @param args the command line arguments
     */
    //static long start, end, result;
    public static void main(String[] args) {
        // TODO code application logic here
//        start = System.currentTimeMillis();
//
//        XMLReaderCustomer customer = new XMLReaderCustomer();
//        XMLReaderEmp emp = new XMLReaderEmp();
//        XMLReaderMaster master = new XMLReaderMaster();
//        XMLReaderMd md = new XMLReaderMd();
//        XMLReaderTax tax = new XMLReaderTax();
//        XMLReaderTreatments treatments = new XMLReaderTreatments();
//
//        customer.domParser();
//        emp.domParser();
//        master.domParser();
//        md.domParser();
//        tax.domParser();
//        treatments.domParser();
//
//        end = System.currentTimeMillis();
//        result = end - start;
//        System.out.println("Time: " + result + "milli second");
//
//        ViewFrame start = new ViewFrame();
//        start.setVisible(true);
//
//        XMLReaderTreatments treatments = new XMLReaderTreatments();
//        treatments.saxParser();
//        XMLReaderTax tax = new XMLReaderTax();
//        tax.saxParser();
//        XMLReaderMd md = new XMLReaderMd();
//        md.saxParser();
        GetAttributeSet attributeSet = new GetAttributeSet();
        attributeSet.getAttributeSet("test");

    }
}
