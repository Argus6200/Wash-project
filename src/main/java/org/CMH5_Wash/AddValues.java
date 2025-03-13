package org.CMH5_Wash;

import java.util.List;
import java.util.ArrayList;

public class AddValues {
    public static float addListValues(ArrayList<String> temp){
        float sum = 0;
        for(String value : temp){
            sum += Float.parseFloat(value);
        }

        return sum;
    }
}
