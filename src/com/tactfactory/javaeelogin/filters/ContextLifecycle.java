package com.tactfactory.javaeelogin.filters;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * Application Lifecycle Listener implementation class ContextLifecycle
 * @author Colin Cerveaux @C-ambium
 */
@WebListener
public class ContextLifecycle implements ServletContextListener {

    /**
     * Default constructor.
     */
    public ContextLifecycle() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  {

        System.out.println("*** SERVER DOWN ***");
    }

    /**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  {

        System.out.println("*** SERVER START ***");
    }

}
