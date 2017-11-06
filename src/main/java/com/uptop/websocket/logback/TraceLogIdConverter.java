package com.uptop.websocket.logback;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;


/**
 * Created by ASUS on 2017-11-02.
 */

public class TraceLogIdConverter extends ClassicConverter {

    @Override
    public String convert(ILoggingEvent event) {
        try {
            return event.getMDCPropertyMap().get(MyMarker.TRACE_LOG_ID);
        }
        catch (Exception e) {
            return "";
        }
    }

}
