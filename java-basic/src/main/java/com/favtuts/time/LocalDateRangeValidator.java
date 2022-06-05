package com.favtuts.time;

import java.time.LocalDate;

public class LocalDateRangeValidator {
    private final LocalDate startDate;
    private final LocalDate endDate;

    public LocalDateRangeValidator(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public boolean isWithinRange(LocalDate testDate) {

        // exclusive startDate and endDate
        // return testDate.isBefore(endDate) && testDate.isAfter(startDate);

        // inclusive startDate and endDate
        return (testDate.isEqual(startDate) || testDate.isEqual(endDate))
                || (testDate.isBefore(endDate) && testDate.isAfter(startDate));

    }
}
