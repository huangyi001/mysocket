package com.uptop.websocket.logback;

import org.apache.commons.lang.StringUtils;
import org.slf4j.MDC;

import java.util.UUID;


/**
 * Created by ASUS on 2017-11-02.
 */

public class TraceLogUtil {



    /**
     * 设置日志中的traceLogId字段的值
     * @param traceLogId
     */

    public static void setTraceLogId(String traceLogId) {
        if (StringUtils.isEmpty(traceLogId)) {
            MDC.put(MyMarker.TRACE_LOG_ID, createTraceLogId());
        } else {
            MDC.put(MyMarker.TRACE_LOG_ID, traceLogId);
        }
    }

    public static void setTraceLogId() {
        MDC.put(MyMarker.TRACE_LOG_ID, createTraceLogId());
    }

    public static String createTraceLogId() {
        return UUID.randomUUID().toString();
    }

    public static void setTimeStamp(long startTime){
        long endTime=System.currentTimeMillis();

        System.out.println((endTime-startTime) + "~~~~~~~~~~~~~~~");

        MDC.put("TIME_CONSUMING",String.valueOf(endTime-startTime)); ;
    }
}

