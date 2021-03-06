package com.favtuts.converter;

public class IPAddressConverter {

    public long ipToLong(String ipAddress) {
        String[] ipAddressInArray = ipAddress.split("\\.");

        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++) {
            int power = 3 - i;
            int ip = Integer.parseInt(ipAddressInArray[i]);
            result += ip * Math.pow(256, power);
        }

        return result;
    }

    public long ipToLong2(String ipAddress) {
        String[] ipAddressInArray = ipAddress.split("\\.");

        long result = 0;
        for (int i = 3; i >= 0; i--) {

            long ip = Long.parseLong(ipAddressInArray[3 - i]);

            // left shifting 24,16,8,0 and bitwise OR

            // 1. 192 << 24
            // 1. 168 << 16
            // 1. 1 << 8
            // 1. 2 << 0
            result |= ip << (i * 8);

        }

        return result;
    }

    public String longToIp(long i) {

		return ((i >> 24) & 0xFF) + 
                   "." + ((i >> 16) & 0xFF) + 
                   "." + ((i >> 8) & 0xFF) + 
                   "." + (i & 0xFF);

	}

	public String longToIp2(long ip) {
		StringBuilder sb = new StringBuilder(15);

		for (int i = 0; i < 4; i++) {

			// 1. 2
			// 2. 1
			// 3. 168
			// 4. 192
			sb.insert(0, Long.toString(ip & 0xff));

			if (i < 3) {
				sb.insert(0, '.');
			}

			// 1. 192.168.1.2
			// 2. 192.168.1
			// 3. 192.168
			// 4. 192
			ip = ip >> 8;

		}

		return sb.toString();
	}

    public static void main(String[] args) {

        IPAddressConverter obj = new IPAddressConverter();

        System.out.println("Converting ip address 192.168.1.2 to Decimal value");
		System.out.println("iptoLong  : " + obj.ipToLong("192.168.1.2"));
		System.out.println("iptoLong2 : " + obj.ipToLong2("192.168.1.2"));

        System.out.println("Converting Decimal value to IP Address");
		System.out.println("longToIp  : " + obj.longToIp(3232235778L));
		System.out.println("longToIp2 : " + obj.longToIp2(3232235778L));
    }
}
