package service.impl;

import service.CondimentService;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class CondimentServiceImpl implements CondimentService {


    private static Map<Integer,String> stringMap;

    static {
        stringMap = new TreeMap<>();
        stringMap.put(1,"Lettuce");
        stringMap.put(2,"Tomato");
        stringMap.put(3,"Mustard");
        stringMap.put(4,"Sprouts");
    }


    @Override
    public ArrayList finAll() {
        return new ArrayList(stringMap.values());
    }
}
