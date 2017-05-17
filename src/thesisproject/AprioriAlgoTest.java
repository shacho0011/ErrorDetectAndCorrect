/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisproject;

import domain.SupportCount;
import java.io.File;
import java.nio.file.Files;
import java.util.*;

/**
 *
 * @author Shadhin
 */
public class AprioriAlgoTest {

    public void test(List getlist, int l) {
        File itemSetFile = new File("itemSet.txt");
        File ruleFile = new File("rules.txt");
        try {
            Files.deleteIfExists(itemSetFile.toPath());
            itemSetFile.createNewFile();
            Files.deleteIfExists(ruleFile.toPath());
            ruleFile.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Writer writer = new Writer();
        String[] arr = new String[l];
        Iterator iterator1;
        iterator1 = getlist.iterator();
        int a = 0;
        while (iterator1.hasNext()) {
            arr[a++] = (String) iterator1.next();
        }
        int level = 4;
        LinkedList<LinkedList<HashSet>> list = new LinkedList<LinkedList<HashSet>>();
        list.add(new LinkedList<HashSet>());

        Set init;
        for (int i = 0; i < arr.length; i++) {
            init = new HashSet();
            init.add(arr[i]);
            list.get(0).add((HashSet) init);
        }

        //SupportCount Start
        String whereC = null;
        Iterator it1;
        Iterator it2;
        int minSupport = 0;
        HashMap<List, Integer> suppItem = new HashMap<List, Integer>();
        it1 = list.get(0).iterator();
        int item = 0;
        while (it1.hasNext()) {
            HashSet next = (HashSet) it1.next();
            it2 = next.iterator();
            while (it2.hasNext()) {
                String next1 = (String) it2.next();
                whereC = next1 + " = 1";
                SupportCount supportCount = new SupportCount();
                int supp = supportCount.getSupport("test", whereC);
                minSupport = minSupport + supp;
                List temp = new LinkedList();
                temp.add(next1);
                suppItem.put(temp, supp);
            }
            item++;
        }
        System.out.println("Item: " + item + " MINSUPP: " + minSupport);
        minSupport = (int) Math.ceil((double) minSupport / item);
        System.out.println("Min Support: " + minSupport + " Support: " + suppItem);
        //SupportCount End

        //Pruning Start
        Set keys = suppItem.keySet();
        System.out.println("SetTest: " + keys);
        Iterator itP = keys.iterator();
        list.get(0).clear();
        while (itP.hasNext()) {
            List indx = (List) itP.next();
            int k = suppItem.get(indx);
            if (k >= minSupport) {
                list.get(0).add(new HashSet(indx));
            }
        }
        //Pruning End

        writer.itemSetOutput(itemSetFile, new HashSet(list.get(0)));
        System.out.println("List 0: " + list.get(0));

        for (int index = 1; index < level; index++) {
            list.add(new LinkedList<HashSet>());
            for (int i = 0; i < list.get(index - 1).size(); i++) {
                for (int j = i + 1; j < list.get(index - 1).size(); j++) {
                    Set set = new HashSet();
                    Iterator<String> ite1 = (list.get(index - 1).get(i)).iterator();
                    Iterator<String> ite2 = (list.get(index - 1).get(j)).iterator();
                    while (ite1.hasNext() && ite2.hasNext()) {
                        set.add(ite1.next());
                        set.add(ite2.next());
                    }
                    if (set.size() == index + 1) {
                        list.get(index).add((HashSet) set);
                    }
                }
            }

            //SupportCount Start
//            minSupport = 0;
            suppItem.clear();
            //it1.remove();
            it1 = list.get(index).iterator();
            item = 0;
            while (it1.hasNext()) {
                HashSet next = (HashSet) it1.next();
                int nxtSize = next.size();
//                System.out.println("Sub Size: " + nxtSize);
                it2 = next.iterator();
                String tempWhere = "";
                while (it2.hasNext()) {
                    String next1 = (String) it2.next();
//                    System.out.println(next1);
                    tempWhere = tempWhere + next1 + " = 1";
                    if (nxtSize >= 2) {
                        tempWhere = tempWhere + " and ";
                        nxtSize--;
                    }
//                    System.out.println("Where: "+tempWhere);
                }

                SupportCount supportCount = new SupportCount();
                int supp = supportCount.getSupport("test", tempWhere);
//                minSupport = minSupport + supp;
                List temp = new LinkedList();
//                temp = new  next;
                suppItem.put(new LinkedList(next), supp);
                item++;
            }
//            System.out.println("Item: " + item + " MINSUPP: " + minSupport);
//            minSupport = (int) Math.ceil((double) minSupport / item);
            System.out.println("Min Support: " + minSupport + " Support: " + suppItem);
            //SupportCount End

            //Pruning Start
//            keys.clear();
            Set ky = suppItem.keySet();
            itP = ky.iterator();
//            System.out.println("SetTest: " + ky);
            list.get(index).clear();
            while (itP.hasNext()) {
                List indx = (List) itP.next();
                int k = suppItem.get(indx);
                if (k >= minSupport) {
                    list.get(index).add(new HashSet(indx));
                }
            }
            //Pruning End

            writer.itemSetOutput(itemSetFile, new HashSet(list.get(index)));
            System.out.println("List " + index + ": " + new HashSet(list.get(index)));

        }

        double minConfidence = 0.82;
        double confidence = 0;

        System.out.println("Rules:-");
        HashMap<Integer, Set> hashKey = new HashMap<Integer, Set>();
        HashMap<Integer, Set> hashValue = new HashMap<Integer, Set>();
        int hashTrack = 0;
        LinkedList key;
        LinkedList value;
        LinkedList<LinkedList<HashSet>> keyList;
        LinkedList valueList;
        LinkedHashSet linkedHS;
        Iterator iterator;
        //System.out.println("Full List: " + linkedHS);
        for (int inc = 0; inc < level; inc++) {
            linkedHS = new LinkedHashSet(list.get(inc));
            System.out.println("@@@ItemSet: " + linkedHS);
            iterator = linkedHS.iterator();
            while (iterator.hasNext()) {
                keyList = new LinkedList<LinkedList<HashSet>>();
                keyList.add(new LinkedList<HashSet>());
                valueList = new LinkedList();
                HashSet subSet = (HashSet) iterator.next();
                Set tempSubValue;
                Set tempSubKey;
                System.out.println("SubSet: { " + subSet + " }");
                if (subSet.size() >= 2) {

                    //SubSet Confidence Start
                    it1 = subSet.iterator();
                    int nxtSize = subSet.size();
                    String tempWhere = "";
                    while (it1.hasNext()) {
                        String next1 = (String) it1.next();
                        tempWhere = tempWhere + next1 + " = 1";
                        if (nxtSize >= 2) {
                            tempWhere = tempWhere + " and ";
                            nxtSize--;
                        }
                    }
                    SupportCount supportCount = new SupportCount();
                    double subConfidence = supportCount.getSupport("test", tempWhere);

                    //SubSet Confidence End
                    Iterator itr = subSet.iterator();
                    String[] arry = new String[subSet.size()];
                    int idx = 0;
                    //temp = new LinkedList();
                    while (itr.hasNext()) {
                        arry[idx++] = (String) itr.next();
                        //temp.add(arry[idx++]);
                    }
                    for (int i = 0; i < arry.length; i++) {
                        init = new HashSet();
                        init.add(arry[i]);
                        keyList.get(0).add((HashSet) init);
                    }

                    //Confidence Count Start
                    HashMap<List, Double> conItem = new HashMap<List, Double>();
                    conItem.clear();
                    it1 = keyList.get(0).iterator();
                    item = 0;
                    while (it1.hasNext()) {
                        HashSet next = (HashSet) it1.next();
                        nxtSize = next.size();
//                System.out.println("Sub Size: " + nxtSize);
                        it2 = next.iterator();
                        tempWhere = "";
                        while (it2.hasNext()) {
                            String next1 = (String) it2.next();
//                    System.out.println(next1);
                            tempWhere = tempWhere + next1 + " = 1";
                            if (nxtSize >= 2) {
                                tempWhere = tempWhere + " and ";
                                nxtSize--;
                            }
//                    System.out.println("Where: "+tempWhere);
                        }
                        supportCount = new SupportCount();
                        confidence = supportCount.getSupport("test", tempWhere);
                        conItem.put(new LinkedList(next), subConfidence / confidence);
                    }
//            System.out.println("Item: " + item + " MINSUPP: " + minSupport);
                    System.out.println("Min Confidence: " + minConfidence + " Confidence: " + conItem);
                    //Confidence Count End

                    //Pruning Start
//            keys.clear();
                    Set ky = conItem.keySet();
                    itP = ky.iterator();
//            System.out.println("SetTest: " + ky);
                    keyList.get(0).clear();
                    while (itP.hasNext()) {
                        List indx = (List) itP.next();
                        double k = conItem.get(indx);
                        if (k >= minConfidence) {
                            keyList.get(0).add(new HashSet(indx));
                        }
                    }
                    //Pruning End

                    //Value Gen Start
                    Iterator valIterator;
                    valIterator = keyList.get(0).iterator();
                    while (valIterator.hasNext()) {
                        tempSubValue = new HashSet();
                        tempSubKey = new HashSet();
                        tempSubKey = (Set) valIterator.next();
                        tempSubValue.addAll(subSet);
                        tempSubValue.removeAll(tempSubKey);

                        hashKey.put(hashTrack, tempSubKey);
                        hashValue.put(hashTrack++, tempSubValue);

                        valueList.add(tempSubValue);
                        writer.ruleOutput(ruleFile, tempSubKey, tempSubValue);
                    }
                    //Value Gen End
                    System.out.println("SubLevel 0: Key{ " + keyList.get(0) + " } --> Value{ " + valueList + " }");

                    for (int index = 1; index < subSet.size() - 1; index++) {

                        HashSet rearrangeList = new HashSet();
                        valueList = new LinkedList();
                        tempSubValue = new HashSet(); //nnewww
//                        tempSubValue.addAll(subSet);
                        for (int i = 0; i < keyList.get(index - 1).size(); i++) {
                            for (int j = i + 1; j < keyList.get(index - 1).size(); j++) {
                                Set set = new HashSet();
                                Iterator<String> ite1 = (keyList.get(index - 1).get(i)).iterator();
                                Iterator<String> ite2 = (keyList.get(index - 1).get(j)).iterator();
                                while (ite1.hasNext() && ite2.hasNext()) {
                                    set.add(ite1.next());
                                    set.add(ite2.next());
                                }
                                if (set.size() == index + 1) {
                                    rearrangeList.add(set);
                                }
                            }
                        }
                        keyList.add(new LinkedList<HashSet>(rearrangeList));
//                        System.out.println("Rearr: " + rearrangeList);
                        //keyList.get(index) = (LinkedList) .clone();

                        //Confidence Count Start
                        conItem.clear();
                        it1 = keyList.get(index).iterator();
                        while (it1.hasNext()) {
                            HashSet next = (HashSet) it1.next();
                            nxtSize = next.size();
//                System.out.println("Sub Size: " + nxtSize);
                            it2 = next.iterator();
                            tempWhere = "";
                            while (it2.hasNext()) {
                                String next1 = (String) it2.next();
//                    System.out.println(next1);
                                tempWhere = tempWhere + next1 + " = 1";
                                if (nxtSize >= 2) {
                                    tempWhere = tempWhere + " and ";
                                    nxtSize--;
                                }
//                    System.out.println("Where: "+tempWhere);
                            }
                            supportCount = new SupportCount();
                            confidence = supportCount.getSupport("test", tempWhere);
                            conItem.put(new LinkedList(next), subConfidence / confidence);
                        }
//            System.out.println("Item: " + item + " MINSUPP: " + minSupport);
                        System.out.println("Min Confidence: " + minConfidence + " Confidence: " + conItem);
                        //Confidence Count End

                        //Pruning Start
//            keys.clear();
                        ky = conItem.keySet();
                        itP = ky.iterator();
//            System.out.println("SetTest: " + ky);
                        keyList.get(index).clear();
                        while (itP.hasNext()) {
                            List indx = (List) itP.next();
                            double k = conItem.get(indx);
                            if (k >= minConfidence) {
                                keyList.get(index).add(new HashSet(indx));
                            }
                        }
                        //Pruning End

                        //Value Gen Start
                        valIterator = keyList.get(index).iterator();
                        while (valIterator.hasNext()) {
                            tempSubValue = new HashSet();
                            tempSubKey = new HashSet();
                            tempSubKey = (Set) valIterator.next();
//                            System.out.println("TempSubKey: " + tempSubKey);
                            tempSubValue.addAll(subSet);
//                            System.out.println("SubSet: " + tempSubValue);
                            tempSubValue.removeAll(tempSubKey);
//                            System.out.println("TempSubValue: " + tempSubValue);

                            hashKey.put(hashTrack, tempSubKey);
                            hashValue.put(hashTrack++, tempSubValue);

                            valueList.add(tempSubValue);

                            writer.ruleOutput(ruleFile, tempSubKey, tempSubValue);
                        }
                        //Value Gen End

//                        System.out.println("SubLevel " + index + ": Key{ " + new HashSet(keyList.get(index)) + " } --> Value{ " + valueList + " }");
                    }
                }

            }
        }

        Random random = new Random();
        int rand = random.nextInt(hashTrack);
        HashSet k = (HashSet) hashKey.get(rand);
        HashSet v = (HashSet) hashValue.get(rand);

        System.out.println(rand + ": " + k + " --> " + v);

//        Set keys = hashKey.keySet();
//        Iterator itP = keys.iterator();
//        while (itP.hasNext()) {
//            int indx = (int) itP.next();
//            HashSet k = (HashSet) hashKey.get(indx);
//            HashSet v = (HashSet) hashValue.get(indx);
//            System.out.println(indx + ": " + k + " --> " + v);
//        }
    }
}
