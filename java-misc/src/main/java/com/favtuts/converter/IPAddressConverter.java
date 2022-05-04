package com.favtuts.converter;

public class IPAddressConverter {
    
    public static long ipToLong(String ipAddress) {
        String[] ipAddressInArray = ipAddress.split("\\.");

        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {
            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);
            result += ip * Math.pow(256, power);
        }

        return result;
    }

    public static long ipToLongBitShifting(String ipAddress) {
        String[] ipAddressInArray = ipAddress.split("\\.");

        long result = 0;
        for (int i = 3; i >= 0; i--) {
			
            long ip = Long.parseLong(ipAddressInArray[3 - i]);
                
            //left shifting 24,16,8,0 and bitwise OR
                
            //1. 192 << 24
            //1. 168 << 16
            //1. 1   << 8
            //1. 2   << 0
            result |= ip << (i * 8);
            
        }
    
        return result;
    }

    public static void main(String[] args) {
        long ipNum = ipToLong("192.168.1.2");
        System.out.println(ipNum);
        ipNum = ipToLongBitShifting("192.168.1.2");
        System.out.println(ipNum);
    }
}
