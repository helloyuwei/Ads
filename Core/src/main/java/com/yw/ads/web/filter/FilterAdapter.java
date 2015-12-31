package com.yw.ads.web.filter;

import java.io.IOException;
import javax.servlet.*;

/**
 * Created by dylanyu on 12/18/2015.
 */
public abstract class FilterAdapter implements Filter {
    @Override
    public void init(FilterConfig pFilterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest pServletRequest, ServletResponse pServletResponse, FilterChain pFilterChain) throws IOException, ServletException {
    }

    @Override
    public void destroy() {

    }
}
