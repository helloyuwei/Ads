package com.yw.ads.web.filter;

import com.yw.ads.web.HTMLEscapeRequestWrapper;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created by dylanyu on 12/18/2015.
 */
public class HTMLEscapeFilter extends FilterAdapter {

    @Override
    public void doFilter(ServletRequest pRequest, ServletResponse pResponse, FilterChain pChain) throws IOException, ServletException {
        HttpServletRequestWrapper requestWrapper = new HTMLEscapeRequestWrapper((HttpServletRequest) pRequest);
        pChain.doFilter(requestWrapper, pResponse);
    }

}
