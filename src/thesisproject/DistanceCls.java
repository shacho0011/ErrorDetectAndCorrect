/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisproject;

import domain.DisplayData;
import domain.GetAttributeSet;
import domain.SupportCount;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Shadhin
 */
public class DistanceCls {

    static GetAttributeSet getAttributeSet = new GetAttributeSet();
    static SupportCount supportCount = new SupportCount();
    static List<HashMap<Integer, List>> keyList = new LinkedList<>();
    static List<HashMap<Integer, Double>> valueList = new LinkedList<>();
    static List<LinkedList<List>> setList = new LinkedList<>();
    static Iterator iterator;
    static Iterator iterator1;
    static double minDis;
    static int indx;

    static HashMap<Integer, List> keyListRule;
    static HashMap<Integer, Double> conListRule;

    static List<LinkedList<List>> tempSetList;
    static HashMap<Integer, List> hashKey = new HashMap<>();
    static HashMap<Integer, List> hashValue = new HashMap<>();
    static HashMap<Integer, Double> hashConDis = new HashMap<>();
    static int ruleIndx = 0;

//    public static void main(String[] args) {
//        subSet();
//        ruleGenerator();
//
//        System.out.println("Key: " + hashKey);
//        System.out.println("Value: " + hashValue);
//        System.out.println("ConDis: " + hashConDis);
//        errorDetection();
//    }
    
    public static void call() {
        subSet();
        ruleGenerator();
        System.out.println("Key: " + hashKey);
        System.out.println("Value: " + hashValue);
        System.out.println("ConDis: " + hashConDis);
    }
    public static void subSet() {

        List attribute;
//        attribute = new LinkedList();
        attribute = getAttributeSet.getAttributeSet("test_emp");
        indx = 0;
        calculateDistance(attribute);
        prune(keyList.get(indx), valueList.get(indx), minDis);
        for (indx = 1; indx < 4; indx++) {
            attribute.clear();
            for (int i = 0; i < setList.get(indx - 1).size(); i++) {
                for (int j = i + 1; j < setList.get(indx - 1).size(); j++) {
                    Set set = new HashSet();
                    Iterator<String> ite1 = (setList.get(indx - 1).get(i)).iterator();
                    Iterator<String> ite2 = (setList.get(indx - 1).get(j)).iterator();
                    while (ite1.hasNext() && ite2.hasNext()) {
                        set.add(ite1.next());
                        set.add(ite2.next());
                    }
                    if (set.size() == indx + 1) {
                        attribute.add(new ArrayList(set));
                    }
                }
            }
            calculateDistance(new ArrayList(new HashSet(attribute)));
            prune(keyList.get(indx), valueList.get(indx), minDis);
        }
    }

    public static void calculateDistance(List list) {
        iterator = list.iterator();
        double dis = 0;
        keyList.add(new HashMap<>());
        valueList.add(new HashMap<>());
        int i = 0;
        while (iterator.hasNext()) {
            String column = "";
            List next = (List) iterator.next();
            int size = next.size();
            iterator1 = next.iterator();
            while (iterator1.hasNext()) {
                column = column + (String) iterator1.next();
                if (size >= 2) {
                    column = column + ", ";
                    size--;
                }
            }
            double indDis = supportCount.distance(column, "test_emp");
            keyList.get(indx).put(i, next);
            valueList.get(indx).put(i++, indDis);
            dis = dis + indDis;
        }
        minDis = Math.ceil(dis / list.size());
    }

    public static void prune(HashMap key, HashMap value, double minDis) {
        setList.add(new LinkedList());
        Set index = (Set) keyList.get(indx).keySet();
        iterator = index.iterator();
        while (iterator.hasNext()) {
            int next = (int) iterator.next();
            double dist = valueList.get(indx).get(next);
            if (dist <= minDis) {
                setList.get(indx).add(keyList.get(indx).get(next));
            }

        }
        System.out.println("Post SetList: " + setList.get(indx));
    }

    public static void ruleGenerator() {
        List tempSet;
        for (int level = 1; level < 3; level++) {
            Iterator it1 = setList.get(level).iterator();
//            System.out.println("Set: " + setList.get(level));
            while (it1.hasNext()) {
                List next = (List) it1.next();
//                System.out.println("SubSet: " + next);
                double subDis = calculateSubDistance(next);
                Iterator it2 = next.iterator();
                tempSet = new LinkedList();
                while (it2.hasNext()) {
                    List tempList = new LinkedList();
                    tempList.add(it2.next());
                    tempSet.add(tempList);
                }
                subSetRule(next, tempSet, subDis);
            }
        }

    }

    public static double calculateSubDistance(List list) {
        String column = "";
        int size = list.size();
        iterator = list.iterator();
        while (iterator.hasNext()) {
            column = column + (String) iterator.next();
            if (size >= 2) {
                column = column + ", ";
                size--;
            }
        }
//        System.out.println("SQL: " + column);
        double subDis = supportCount.distance(column, "test_emp");
        return subDis;
    }

    public static void subSetRule(List subSet, List list, double subDis) {
        tempSetList = new LinkedList<>();
        indx = 0;
        tempSetList.add(new LinkedList());
        tempSetList.get(indx).addAll(list);
//        System.out.println("NewList: "+tempSetList.get(indx));
        calculateRuleDistance(subSet, tempSetList.get(indx), subDis);

        for (indx = 1; indx < subSet.size() - 1; indx++) {
            tempSetList.add(new LinkedList<>());
            for (int i = 0; i < tempSetList.get(indx - 1).size(); i++) {
                for (int j = i + 1; j < tempSetList.get(indx - 1).size(); j++) {
                    Set set = new HashSet();
                    Iterator<String> ite1 = (tempSetList.get(indx - 1).get(i)).iterator();
                    Iterator<String> ite2 = (tempSetList.get(indx - 1).get(j)).iterator();
                    while (ite1.hasNext() && ite2.hasNext()) {
                        set.add(ite1.next());
                        set.add(ite2.next());
                    }
                    if (set.size() == indx + 1) {
                        tempSetList.get(indx).add(new ArrayList(set));
                    }
                }
            }
            calculateRuleDistance(subSet, tempSetList.get(indx), subDis);
//            System.out.println("NEW_LIST: "+ tempSetList.get(indx));
        }
        
    }

    public static void calculateRuleDistance(List subSet, List list, double subDis) {

        keyListRule = new HashMap<>();
        conListRule = new HashMap<>();
        iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            String column = "";
            List next = (List) iterator.next();
            int size = next.size();
            iterator1 = next.iterator();
            while (iterator1.hasNext()) {
                column = column + (String) iterator1.next();
                if (size >= 2) {
                    column = column + ", ";
                    size--;
                }
            }
            double indDis = supportCount.distance(column, "test_emp");
            keyListRule.put(i, next);
            conListRule.put(i++, indDis);
        }

        Set tempK = keyListRule.keySet();
        iterator = tempK.iterator();
        while (iterator.hasNext()) {
            int k = (int) iterator.next();
            double c = conListRule.get(k);
            List l = keyListRule.get(k);

            if ((c / subDis) >= 0.6) {
                hashKey.put(ruleIndx, l);
                List temp = new LinkedList();
                temp.addAll(subSet);
                temp.removeAll(l);
//                System.out.println("Lst: " + list + " > " + l + " -> " + temp);
                hashValue.put(ruleIndx, temp);
                hashConDis.put(ruleIndx++, c / subDis);
            }
        }

    }

    static Integer ruleValue;
    public static String errorDetection() {
        Random random = new Random();
        ruleValue = random.nextInt(hashKey.size());
        List ruleLeft = new LinkedList();
        List ruleRight = new LinkedList();
        ruleLeft = hashKey.get(ruleValue);
        ruleRight = hashValue.get(ruleValue);
        String rule = ruleLeft + " > " + ruleRight;
        System.out.println(ruleValue + " " + ruleLeft + " > " + ruleRight);
        iterator = ruleLeft.iterator();
        String where = "";
        Scanner scanner = new Scanner(System.in);

        int size;
        size = ruleLeft.size();
        String column = "";
        while (iterator.hasNext()) {
            column = column + (String) iterator.next();
            if (size > 1) {
                column = column + ",";
                size--;
            }
        }
        System.out.println(column);
        DisplayData displayData = new DisplayData();
        List val = displayData.getColumnValues(column);
        System.out.println("Const Column Value: " + val);

        iterator = ruleLeft.iterator();
        iterator1 = val.iterator();
        size = ruleLeft.size();
        while (iterator.hasNext() && iterator1.hasNext()) {
            where = where + iterator.next() + " = " + '"' + iterator1.next() + '"';
            if (size > 1) {
                where = where + " and ";
                size--;
            }
        }
        System.out.println("Where: " + where);

        iterator = ruleRight.iterator();
        size = ruleRight.size();
        column = "";
        while (iterator.hasNext()) {
            column = column + iterator.next();
            if (size > 1) {
                column = column + ", ";
                size--;
            }
        };
        displayData.createTempDtatabase(where);
        displayData.computeFrequency(column);
        
        return rule;
    }
    
    static float errorCorrection(){
        Random random = new Random();
        ruleValue = random.nextInt(hashKey.size());
        System.out.println("Rule Number: "+ruleValue);
        List ruleLeft = new LinkedList();
        ruleLeft = hashKey.get(ruleValue);
        List ruleRight = new LinkedList();
        ruleRight = hashValue.get(ruleValue);
        System.out.println(ruleLeft+" > "+ruleRight);
        DisplayData data = new DisplayData();
        float avgFrq = 0;
        avgFrq =  data.getAvgFrequency();
        System.out.println("Average Frequency: "+avgFrq);
        
        return avgFrq;
        
    }
    
    
    static void errDataExt(){
        float avgFrq = errorCorrection();
        DisplayData data = new DisplayData();
        data.errDataSelection(avgFrq);
    }
    
    static void topValues(){
        List ruleLeft = new LinkedList();
        ruleLeft = hashKey.get(ruleValue);
        List ruleRight = new LinkedList();
        ruleRight = hashValue.get(ruleValue);
        System.out.println(ruleRight);
        
        HashMap<String, Integer> topValue = new HashMap<>();
        DisplayData data = new DisplayData();
        Iterator itr = ruleRight.iterator();
        while(itr.hasNext()){
            String key = (String)itr.next();
            //System.out.println(itr.next());
            topValue = data.valueCounter(key);
        System.out.println("TOp ValuE: "+topValue);    
        }
        
    }
    
    
    
    public static void main(String[] args) {
        call();
        errorDetection();
        //errDataExt();
        topValues();
    }
}
