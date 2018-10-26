package com.example.springcloud.filter;

import com.example.springcloud.util.FilterUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.log4j.Logger;

public class ResponseFilter extends ZuulFilter {

    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;
    private static final Logger logger = Logger.getLogger(ResponseFilter.class);

    //@Autowired
    //FilterUtil filterUtil;

    @Override
    public String filterType() {
        return "RESPONSE_FILTER_TYPE";
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        logger.info("outbound headers:" + FilterUtil.getCorrelationId());
        //获取原始HTTP请求中传入的关联ID，并将它注入响应中
        context.getResponse().addHeader(FilterUtil.CORRELATION_ID, FilterUtil.getCorrelationId());
        //记录传出的请求URI，它将显示Zuul的用户请求的传入和传出条目
        logger.info("outgoing request for:" + context.getRequest().getRequestURI());
        return null;
    }
}
