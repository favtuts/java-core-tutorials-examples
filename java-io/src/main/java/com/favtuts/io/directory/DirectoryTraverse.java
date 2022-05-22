package com.favtuts.io.directory;

import java.io.File;

public class DirectoryTraverse {

	public static void main (String args[]) {

		displayIt(new File("/home/tvt/workspace/favtuts/test"));
	}
	
	public static void displayIt(File node){
		
		System.out.println(node.getAbsoluteFile());
		
		if(node.isDirectory()){
			String[] subNote = node.list();
			for(String filename : subNote){
				displayIt(new File(node, filename));
			}
		}
		
	}
}