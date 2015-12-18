package com.yw.ads.web.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.MDC;

/**
 * Created by dylanyu on 12/18/2015.
 */
public class Log4jMdcFilter extends FilterAdapter {
    public static final String SESSION_ID = "sessionId";

    @Override
    public void doFilter(ServletRequest pRequest, ServletResponse pResponse, FilterChain pChain) throws IOException, ServletException {
        if (pRequest instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) pRequest;
            MDC.put(SESSION_ID, httpServletRequest.getSession().getId());
        }
        pChain.doFilter(pRequest, pResponse);
    }

    @Override
    public void destroy() {
        MDC.remove(SESSION_ID);
    }
}
