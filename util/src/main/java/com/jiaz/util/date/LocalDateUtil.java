package com.jiaz.util.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocalDateUtil {

    public int betweenMonths(String startDate,String endDate){
        LocalDate start = LocalDate.parse(startDate , DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate end = LocalDate.parse(endDate , DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<LocalDate> dates = Stream.iterate(start, date -> date.plusMonths(1))
                .limit(ChronoUnit.MONTHS.between(start, end))
                .collect(Collectors.toList());
        return dates.size();
    }
}
