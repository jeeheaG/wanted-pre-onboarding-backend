package com.ginger.myjobserver2024.global.config;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedTimeUtil {
    private static final String zoneId ="Asia/Seoul";
    private static final String dateTimePattern = "yyyy/MM/dd HH:mm:ss";

    public static ZonedDateTime getZonedDateTime() {
        return ZonedDateTime.now(ZoneId.of(zoneId));
    }

    public static String getZonedTimestamp() {
        return getZonedDateTime().format(DateTimeFormatter.ofPattern(dateTimePattern));
    }

}
