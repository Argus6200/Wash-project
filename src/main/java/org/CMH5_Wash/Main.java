package org.CMH5_Wash;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //String filePath = "C:\\Users\\funny\\Career\\CMH5\\Wash_project\\wash_Input.xlsx";
        String filePath = "\\C:\\Users\\funny\\Career\\CMH5\\PPA_NIT_2.12.25.csv";

        //JavaFX.startApp();
        if (filePath.endsWith("xlsx")){
            List<List<String>> iterated = File_iteration.iterateXLSX(filePath);
            List<List<String>> fixed_Vals = Process_Values.fix(iterated);
            List<List<String>>processed_Vals = Process_Values.process(fixed_Vals);
        } else if(filePath.endsWith("csv")){
            List<List<String>> iterated = File_iteration.iterateCSV(filePath);
            List<List<String>> fixed_Vals = Process_Values.fix(iterated);
            List<List<String>>processed_Vals = Process_Values.process(fixed_Vals);
        }
        //iterate through the excel file and return the array list containing the values


        //input the array list to fix the values that don't have a 5th value and remove rows only containing 0's




        //System.out.println(fixed_Vals);


    }
}
