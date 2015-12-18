package com.yw.ads.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Created by dylanyu on 12/18/2015.
 */
public class HTMLEscapeRequestWrapper extends HttpServletRequestWrapper {

    public HTMLEscapeRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String pName) {
        return StringEscapeUtils.escapeHtml3(StringEscapeUtils.escapeHtml4(this.getRequest().getParameter(pName)));
    }
}