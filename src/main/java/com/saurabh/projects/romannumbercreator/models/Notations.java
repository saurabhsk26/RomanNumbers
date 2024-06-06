package com.saurabh.projects.romannumbercreator.models;

import java.util.HashMap;

public class Notations {
    public static HashMap<Integer,String> notationMap= new HashMap<>();
    public static HashMap<Integer,String> extendedNotationMap = new HashMap<>();
    public Notations(){
        notationMap.put(1,"I");
        notationMap.put(5,"V");
        notationMap.put(10,"X");
        notationMap.put(50,"L");
        notationMap.put(100,"C");
        notationMap.put(500,"D");
        notationMap.put(1000,"M");

        extendedNotationMap.put(4,"IV");
        extendedNotationMap.put(9,"IX");
        extendedNotationMap.put(40,"XL");
        extendedNotationMap.put(90,"XC");
        extendedNotationMap.put(400,"CD");
        extendedNotationMap.put(900,"CM");
    }

}
