package com.example.springcloud.util;

import com.netflix.zuul.context.RequestContext;

public class FilterUtil {

    public static final String CORRELATION_ID = "tmx-correlation-id";
    public static String getCorrelationId() {
        RequestContext context = RequestContext.getCurrentContext();
        if (context.getRequest().getHeader(CORRELATION_ID) != null) {
            return context.getRequest().getHeader(CORRELATION_ID);
        } else {
            return context.getZuulRequestHeaders().get(CORRELATION_ID);
        }
    }

    public static void setCorrelationId(String correlationId) {
        RequestContext context = RequestContext.getCurrentContext();
        context.addZuulRequestHeader(CORRELATION_ID,correlationId);
    }
}
