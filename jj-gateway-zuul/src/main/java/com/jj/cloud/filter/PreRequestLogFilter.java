package com.jj.cloud.filter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class PreRequestLogFilter extends ZuulFilter {
	  private static final Logger LOGGER = LoggerFactory.getLogger(PreRequestLogFilter.class);

	  @Override
	  public String filterType() {
	    return "pre";
	  }

	  @Override
	  public int filterOrder() {
	    return 1;
	  }

	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }

	  @Override
	  public Object run() {
	    RequestContext ctx = RequestContext.getCurrentContext();
	    HttpServletRequest request = ctx.getRequest();
	    LOGGER.info("......"+request.getMethod());
	    PreRequestLogFilter.
	    LOGGER.info(String.format("send %s request to %s , %s ", request.getMethod(), request.getRequestURL().toString(),request.getSession().getId()));
	    return null;
	  }
	}

