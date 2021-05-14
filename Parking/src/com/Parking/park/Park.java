package com.Parking.park;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Park {
	static Scanner scan = new Scanner(System.in);
	int size=0;
	private class Car{
		String reg_no;
		String color;
		public Car(String reg_no,String color) {
			this.reg_no= reg_no;
			this.color=color;
		}
	}
	ArrayList<Integer> availableslots;
	Map<String,Car> register;
	Map<String,String> slot;
	Map<String,ArrayList<String>> color;
	
	public void createParkLot(String lotCount) {
		try{
			this.size=Integer.parseInt(lotCount);
		} catch(Exception e) {
			System.out.println("Lot Count Invalid \n");
		}
		this.availableslots =new ArrayList<Integer>() {};
		
		for(int i=1;i<=this.size;i++) {
			availableslots.add(i);
		}
		this.register = new HashMap<String, Car>();
		this.slot = new HashMap<String,String>();
		this.color = new HashMap<String,ArrayList<String>>();
		System.out.println("Parking lot created with "+lotCount+" slots \n");;
	}
	
	public void park(String reg_no,String color) {
		if(this.size==0) {
			System.out.println("Parking lot unable to create \n");
		} else if(this.register.size()==this.size) {
			System.out.println("Apology,Parking lot is not empty \n");;
		} else {
			Collections.sort(availableslots);
			String slots=availableslots.get(0).toString();
			Car car= new Car(reg_no,color);
			this.register.put(slots,car);
			this.slot.put(reg_no,slots);
			if(this.color.containsKey(color)) {
				ArrayList<String> reg_no_list=this.color.get(color);
				this.color.remove(color);
				reg_no_list.add(reg_no);
				this.color.put(color, reg_no_list);
			} else {
				ArrayList<String> reg_no_list= new ArrayList<String>();
				reg_no_list.add(reg_no);
				this.color.put(color,reg_no_list);
			}
			System.out.println("Slot Allocated With Number: "+slots);;
			System.out.println();
			availableslots.remove(0);
		}
	}
	public void leave(String slotNo) {
		if(this.size==0) {
			System.out.println("Parking lot not created \n");
		} else if(this.register.size()>0) {
			Car carLeave = this.register.get(slotNo);
			if(carLeave!=null) {
				this.register.remove(slotNo);
				this.slot.remove(carLeave.reg_no);
				ArrayList<String> reg_no_list=this.color.get(carLeave.color);
				if(reg_no_list.contains(carLeave.reg_no)) {
					reg_no_list.remove(carLeave.reg_no);
				}
				this.availableslots.add(Integer.parseInt(slotNo));
				System.out.println("Slot Number "+slotNo+" is free");
				System.out.println();
			} else {
                System.out.println("Slot number " + slotNo + " is already empty");
                System.out.println();
            }
        } else {
            System.out.println("Parking lot is empty");
            System.out.println();
        }
	}
	public void status() {
		if(this.size==0) {
			System.out.println("Parking lot not created \n");
		} else if(this.register.size()>0) {
			System.out.println("Slot No. \tRegistration No. \tColor");
			Car car;
			for(int i=1;i<=this.size;i++) {
				String key= Integer.toString(i);
				if(this.register.containsKey(key)) {
					car=this.register.get(key);
					System.out.println(i+"\t"+car.reg_no+"\t"+car.color);;
				}
			}
			System.out.println();
		} else {
			System.out.println("Parking lot is empty");
            System.out.println();
		}
	}
	public void getRegNumFromColor(String color) {
		if (this.size == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.color.containsKey(color)) {
            ArrayList<String> regNoList = this.color.get(color);
            System.out.println();
            for (int i=0; i < regNoList.size(); i++) {
                if (!(i==regNoList.size() - 1)){
                    System.out.print(regNoList.get(i) + ",");
                } else {
                    System.out.print(regNoList.get(i));
                }
            }
        } else {
            System.out.println("Not found");
            System.out.println();
        }
	}
	public void getSlotNumFromColor(String color) {
		if (this.size == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.color.containsKey(color)) {
            ArrayList<String> regNoList = this.color.get(color);
            ArrayList<Integer> slotList = new ArrayList<Integer>();
            System.out.println();
            for (int i=0; i < regNoList.size(); i++) {
                slotList.add(Integer.valueOf(this.slot.get(regNoList.get(i))));
            }
            Collections.sort(slotList);
            for (int j=0; j < slotList.size(); j++) {
                if (!(j == slotList.size() - 1)) {
                    System.out.print(slotList.get(j) + ",");
                } else {
                    System.out.print(slotList.get(j));
                }
            }
            System.out.println();
        } else {
            System.out.println("Not found");
            System.out.println();
        }
	}
	public void getSlotNumFromRegNum(String reg_no) {
		if (this.size == 0) {
            System.out.println("Sorry, parking lot is not created");
            System.out.println();
        } else if (this.slot.containsKey(reg_no)) {
            System.out.println(this.slot.get(reg_no));
        } else {
            System.out.println("Not found");
            System.out.println();
        }
	}
}
