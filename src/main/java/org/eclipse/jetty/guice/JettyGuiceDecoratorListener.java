package org.eclipse.jetty.guice;

import javax.servlet.ServletContextEvent;

import com.google.inject.servlet.GuiceServletContextListener;
import org.eclipse.jetty.servlet.ServletContextHandler;

public abstract class JettyGuiceDecoratorListener extends GuiceServletContextListener
{
    private GuiceDecorator decorator;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        super.contextInitialized(servletContextEvent);
        decorator = new GuiceDecorator(getInjector());
        ServletContextHandler contextHandler = ServletContextHandler.getServletContextHandler(servletContextEvent.getServletContext());
        contextHandler.getObjectFactory().addDecorator(decorator);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        ServletContextHandler contextHandler = ServletContextHandler.getServletContextHandler(servletContextEvent.getServletContext());
        contextHandler.getObjectFactory().removeDecorator(decorator);
        super.contextDestroyed(servletContextEvent);
    }
}
