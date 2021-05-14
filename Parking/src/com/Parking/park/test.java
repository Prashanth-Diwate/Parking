package com.Parking.park;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;

public class test {
    public Map<String, Method> methodMap;

    public test() {
        methodMap = new HashMap<String, Method>();
        try {
            populateCommandsHashMap();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    private void populateCommandsHashMap() throws NoSuchMethodException {
    
        methodMap.put("create", Park.class.getMethod("createParkLot", String.class));
        methodMap.put("park", Park.class.getMethod("park", String.class, String.class));
        methodMap.put("leave", Park.class.getMethod("leave", String.class));
        methodMap.put("status", Park.class.getMethod("status"));
        methodMap.put("regNumForCarWithColor", Park.class.getMethod("getRegNumFromColor", String.class));
        methodMap.put("slotNumForCarWithColor", Park.class.getMethod("getSlotNumFromColor", String.class));
        methodMap.put("slotNumberForRegNum", Park.class.getMethod("getSlotNumFromRegNum", String.class));
    }
}
