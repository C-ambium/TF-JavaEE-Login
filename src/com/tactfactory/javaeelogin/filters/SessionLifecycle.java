package com.tactfactory.javaeelogin.filters;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionLifecycle
 * @author Colin Cerveaux @C-ambium
 */
@WebListener
public class SessionLifecycle implements HttpSessionListener {

    /**
     * Default constructor.
     */
    public SessionLifecycle() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  {
         // TODO Auto-generated method stub
    }

    /**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  {
         // TODO Auto-generated method stub
    }

}
