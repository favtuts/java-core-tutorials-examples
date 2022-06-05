package com.favtuts.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class EpochTimeConverter {
    
    public static void main(String[] args) {

        long epoch = Instant.now().toEpochMilli();
        System.out.println(epoch);

        LocalDate ld = Instant.ofEpochMilli(epoch)
                .atZone(ZoneId.systemDefault()).toLocalDate();
        System.out.println(ld);

        LocalDateTime ldt = Instant.ofEpochMilli(epoch)
                .atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(ldt);
        
    }    
}
