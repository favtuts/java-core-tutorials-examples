package com.favtuts.io.howto.compress;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.zip.GZIPInputStream;

import com.favtuts.io.object.Address;

public class Deserializer implements Serializable {

    public static void main(String[] args) {
        
       Deserializer deserializer = new Deserializer();
	   Address address = deserializer.deserialzeAddress();
	   System.out.println(address);

    }

    public Address deserialzeAddress(){
	   
        Address address;
      
        try{
             
            FileInputStream fin = new FileInputStream("/home/tvt/workspace/favtuts/address.gz");
            GZIPInputStream gis = new GZIPInputStream(fin);
            ObjectInputStream ois = new ObjectInputStream(gis);
            address = (Address) ois.readObject();
            ois.close();
           
            return address;
            
        }catch(Exception ex){
            ex.printStackTrace();
            return null;
        } 
    } 
    
}
