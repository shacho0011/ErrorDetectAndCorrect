/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thesisproject;

import java.io.File;
import java.nio.file.Files;
import java.util.*;

/**
 *
 * @author Shadhin
 */
public class AprioriAlgo {

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
        writer.itemSetOutput(itemSetFile, new HashSet(list.get(0)));
//        System.out.println("List 0: " + list.get(0));

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

            writer.itemSetOutput(itemSetFile, new HashSet(list.get(index)));
//            System.out.println("List " + index + ": " + new HashSet(list.get(index)));

        }

//        HashMap<Integer, HashSet> hashM = new HashMap();
//        for (int i = 0; i <= level; i++) {
//            Iterator<HashSet> it = list.get(i).iterator();
//            LinkedHashSet linkedHS = new LinkedHashSet();
//            while (it.hasNext()) {
//                linkedHS.add(it.next());
//            }
//            hashM.put(i, linkedHS);
//        }
//        for (int i = 0; i <= level; i++) {
//            hashM.get(0);
//        }
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
//            System.out.println("@@@ItemSet: " + linkedHS);
            iterator = linkedHS.iterator();
            while (iterator.hasNext()) {
                keyList = new LinkedList<LinkedList<HashSet>>();
                keyList.add(new LinkedList<HashSet>());
                valueList = new LinkedList();
                HashSet subSet = (HashSet) iterator.next();
                Set tempSubValue;
                Set tempSubKey;

//                System.out.println("SubSet: { " + subSet + " }");
                if (subSet.size() >= 2) {
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
//                    System.out.println("SubLevel 0: Key{ " + keyList.get(0) + " } --> Value{ " + valueList + " }");

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
