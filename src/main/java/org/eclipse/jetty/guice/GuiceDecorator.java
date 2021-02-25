package org.eclipse.jetty.guice;

import com.google.inject.Injector;
import org.eclipse.jetty.util.Decorator;

public class GuiceDecorator implements Decorator
{
    private final Injector injector;

    public GuiceDecorator(Injector injector)
    {
        this.injector = injector;
    }

    @Override
    public <T> T decorate(T t)
    {
        injector.injectMembers(t);
        return t;
    }

    @Override
    public void destroy(Object o)
    {
    }
}
