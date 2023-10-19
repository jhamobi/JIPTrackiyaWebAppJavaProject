package com.jhamobi.trackiya.server.tomcat.servlet;

import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.jhamobi.trackiya.server.tomcat.action.Action;

/**
 * 
 * @author majha
 *
 */
public abstract class GenericChannelServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String, Action> actionsMap;

    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
    }

    /**
     * Called by the servlet container to indicate to a servlet that the
     * servlet is being taken out of service.  See {@link javax.servlet.Servlet#destroy()}.
     */
    public void destroy() {
        //Flush the cached destinations, and hope they will be collected
    	actionsMap.clear();
    }


}
