package com.favtuts.array;

import java.util.Arrays;
import java.util.Collections;

public class SortArray {
    public static void main(String args[]){
		
		String[] unsortStringArray = new String[] {"c", "b", "a", "3", "2", "1"}; 
		int[] unsortIntArray = new int[] {7,5,4,6,1,2,3}; 
		
		System.out.println("Before sort");
		System.out.println("--- unsortStringArray ---");
		for(String temp: unsortStringArray){
			System.out.println(temp);
		}
		System.out.println("--- unsortIntArray ---");
		for(int temp: unsortIntArray){
			System.out.println(temp);
		}
		
		//sort it
		Arrays.sort(unsortStringArray);
		Arrays.sort(unsortIntArray);
		
		System.out.println("After sorted");
		System.out.println("--- unsortStringArray ---");
		for(String temp: unsortStringArray){
			System.out.println(temp);
		}
		System.out.println("--- unsortIntArray ---");
		for(int temp: unsortIntArray){
			System.out.println(temp);
		}
		
		//sort it, reverse order
		Arrays.sort(unsortStringArray,Collections.reverseOrder());
		
		System.out.println("After sorted - reserved order");
		System.out.println("--- unsortStringArray ---");
		for(String temp: unsortStringArray){
			System.out.println(temp);
		}

        // descending order, int[] cant, need boxed to Integer[] first
        Integer[] numObjects = Arrays.stream(unsortIntArray).boxed().toArray(Integer[]::new);
        Arrays.sort(numObjects, Collections.reverseOrder());
        System.out.println("--- unsortIntArray ---");
		for(Integer temp: numObjects){
			System.out.println(temp);
		}
	}
}
