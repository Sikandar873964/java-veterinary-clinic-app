package com.ucen.vetclinicjavafx.vetclinicjavafx.app.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateTimeUtils {

    private static final DateTimeFormatter LOCAL_TIME_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter LOCAL_DATE_TIME_DATE_TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public LocalTime parseLocalTime(String timeString) {
        return LocalTime.parse(timeString, LOCAL_TIME_DATE_TIME_FORMATTER);
    }

    public LocalDateTime parseLocalDateTime(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, LOCAL_DATE_TIME_DATE_TIME_FORMATTER);
    }
}
