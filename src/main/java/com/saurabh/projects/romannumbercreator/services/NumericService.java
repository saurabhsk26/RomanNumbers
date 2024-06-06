package com.saurabh.projects.romannumbercreator.services;

import com.saurabh.projects.romannumbercreator.models.Notations;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Map;

@Service
public class NumericService {


    Notations notations = new Notations();
//    public NumericService(){
//        notations = new Notations();
//    }

    /*
     * Rules
     * if a number is satisfied in a single unit then don't check for extra units.
     * if a number is one less than next larger notation then use subtractive notation.
     *
     *  */
    public String convert2Roman(String numeric){
        int len = numeric.length();

        ArrayList<Integer> vals = breakNumberInTerms(numeric, len);
        return mapValues(vals);
    }

    private String mapValues(ArrayList<Integer> vals) {
        NumericService numericService = new NumericService();
        StringBuilder sbuilder = new StringBuilder();
        int len = vals.size();
        for(int i=len-1; i >=0; i--){

            String rm = Notations.notationMap.get(vals.get(i));
            if(rm != null && !rm.isEmpty() && !rm.isBlank()){
                sbuilder.append(rm);
            }
            else{
                sbuilder.append(numericService.getValue(vals.get(i)));
            }

        }
        return sbuilder.toString();
    }

    public String getValue(int val){

        int min = Integer.MAX_VALUE;
        int valv = 0;
        //check for largest smaller value in notationMap
        for(Map.Entry<Integer, String> v : Notations.notationMap.entrySet()){
            int result = val - v.getKey();
            if(result > 0) {
                min = Math.min(min, result);
                valv = v.getKey();
            }
        }
        String resultant = "";
        if(valv != 0) {
            for (int i = 1; i <= 3; i++) {
                if (val == (valv * i)) {
                    for (int j = 1; j <= i; j++) {
                        resultant = resultant.concat(Notations.notationMap.get(valv));
                    }
                }
            }
            if(resultant.isEmpty()){
                int valc=0;
                int newMin=Integer.MAX_VALUE;
                for(Map.Entry<Integer,String> var : Notations.extendedNotationMap.entrySet()){
                    int result = val - var.getKey();
                    if(result >= 0){
                        if(result < newMin){
                            newMin = result;
                            valc = var.getKey();
                        }

                    }
                }
                resultant = resultant.concat(Notations.extendedNotationMap.get(valc));
            }
        }
        return resultant;
    }
    private ArrayList<Integer> breakNumberInTerms(String numeric, int len) {
        ArrayList<Integer> vals = new ArrayList<>();
        int num = Integer.parseInt(numeric);
        for(int i=0;i<len;i++){
            int temp = num % 10;
            temp = temp * (int)Math.pow(10,i);
            num = num / 10;
            vals.add(temp);
        }
//        System.out.println(vals.toString());
        return vals;
    }
}
