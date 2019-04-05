package com.mironov.forum_api;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.mironov.forum_api.DAO.DAO;
import com.mironov.forum_api.DAO.DAOImpl;
import com.mironov.forum_api.Service.Service;
import com.mironov.forum_api.Service.ServiceImpl;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

import java.util.HashMap;
import java.util.Map;


public class MyGuiceServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {

        return Guice.createInjector(new ServletModule(){
            @Override
            protected void configureServlets(){
                //serve("/forum").with(ForumServlet.class);
                bind(Service.class).to(ServiceImpl.class);
                bind(DAO.class).to(DAOImpl.class);
                serve("/*").with(GuiceContainer.class);
                // Configuring Jersey via Guice:
                bind(ForumServlet.class);

            }


        });
    }
}
