package org.CMH5_Wash;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;

public class File_iteration {
    public static List<List<String>> iterateXLSX(String filePath) {
        List<List<String>> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(new File(filePath)); Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);  // Get the first sheet

            // Loop through each row in the sheet
            for (Row row : sheet) {
                List<String> rowData = new ArrayList<>();
                // Loop through each cell in the row
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            rowData.add(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            rowData.add(String.valueOf(cell.getNumericCellValue()));
                            break;
                        case BOOLEAN:
                            rowData.add(String.valueOf(cell.getBooleanCellValue()));
                            break;
                        default:
                            rowData.add("");  // Handle unknown or empty cells
                            break;
                    }
                }
                data.add(rowData);  // Add the row data to the list
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
    public static List<List<String>> iterateCSV(String filePath){
        List<List<String>> data = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            List<String> rowData = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null){
                List<String> values = Arrays.asList(line.split(","));
                data.add(values);
                }

            //while((line = br.readLine()) != null){}

        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }
}
