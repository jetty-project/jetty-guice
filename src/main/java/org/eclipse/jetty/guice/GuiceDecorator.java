//
// ========================================================================
// Copyright (c) 1995-2021 Mort Bay Consulting Pty Ltd and others.
//
// This program and the accompanying materials are made available under the
// terms of the Eclipse Public License v. 2.0 which is available at
// https://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
// which is available at https://www.apache.org/licenses/LICENSE-2.0.
//
// SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
// ========================================================================
//

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
