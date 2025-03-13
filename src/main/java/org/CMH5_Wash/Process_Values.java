package org.CMH5_Wash;

import java.util.List;
import java.util.ArrayList;

public class Process_Values {
    public static List<List<String>> fix(List<List<String>> iterated){
        List<List<String>> fixed = new ArrayList<>();
        for (List<String> row : iterated){
            //System.out.println(row);//raw rows
            if (row.size() == 14){
                row.add(4, "None");
            }
            if(
                !row.get(5) .equals("0.0") ||
                !row.get(6) .equals("0.0") ||
                !row.get(7) .equals("0.0") ||
                !row.get(8) .equals("0.0") ||
                !row.get(9) .equals("0.0") ||
                        !row.get(11) .equals("0.0") ||
                        !row.get(12) .equals("0.0") ||
                        !row.get(13) .equals("0.0") ||
                        !row.get(14) .equals("0.0")){
                fixed.add(row);
            }
        }
        return fixed;
    }
    public static List<List<String>> process(List<List<String>> fixed) {
        //System.out.println(fixed.get(5));
        List<List<String>> result = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        for(List<String> row : fixed){
            if (row.get(0).equals("Core Ops")){
                if(!temp.contains(row.get(5))){
                    temp.add(row.get(5));
                }
            }
        }
        System.out.println(AddValues.addListValues(temp));
        System.out.println(temp);
        return result;
    }
}
