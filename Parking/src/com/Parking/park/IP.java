package com.Parking.park;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IP {
	    test testing;
	    static Park parking;
	    public IP() {
	        testing = new test();
	        parking = new Park();
	    }
	    public void parseTextInput(String inputString) {
	        // Split the input string to get command and input value
	        String[] input = inputString.split(" ");
	        switch (input.length) {
	            case 1:
	                try {
	                    Method method = testing.methodMap.get(inputString);
	                    if (method != null) {
	                        method.invoke(parking);
	                    } else {
	                        System.out.println("Invalid input");
	                    }
	                } catch (IllegalAccessException e) {
	                    e.printStackTrace();
	                } catch (InvocationTargetException e) {
	                    e.printStackTrace();
	                }
	                break;
	            case 2:
	                try {
	                    Method method = testing.methodMap.get(input[0]);
	                    if (method != null) {
	                        method.invoke(parking, input[1]);
	                    } else {
	                        System.out.println("Invalid input");
	                    }
	                } catch (IllegalAccessException e) {
	                    e.printStackTrace();
	                } catch (InvocationTargetException e) {
	                    e.printStackTrace();
	                }
	                break;
	            case 3:
	                try {
	                    Method method = testing.methodMap.get(input[0]);
	                    if (method != null) {
	                        method.invoke(parking, input[1], input[2]);
	                    } else {
	                        System.out.println("Invalid input");
	                    }
	                } catch (IllegalAccessException e) {
	                    e.printStackTrace();
	                } catch (InvocationTargetException e) {
	                    e.printStackTrace();
	                }
	                break;
	            default:
	                System.out.println("Invalid input.");
	        }
	    }
	}


