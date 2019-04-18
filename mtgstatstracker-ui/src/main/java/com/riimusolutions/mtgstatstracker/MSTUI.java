package com.riimusolutions.mtgstatstracker;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;

import com.riimusolutions.mtgstatstracker.backend.CrudService;
import com.riimusolutions.mtgstatstracker.views.login.LoginViewImpl;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.cdi.server.VaadinCDIServlet;
import com.vaadin.data.provider.CallbackDataProvider;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

/**
 *
 */
@Theme("msttheme")
@CDIUI("")
public class MSTUI extends UI {

    @Inject
    CDIViewProvider viewProvider;

    private CrudService<Person> service = new CrudService<>();
    private DataProvider<Person, String> dataProvider = new CallbackDataProvider<>(
            query -> service.findAll().stream(),
            query -> service.findAll().size());

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setNavigator(new Navigator(this, this));
        getNavigator().addProvider(viewProvider);
        getNavigator().navigateTo(LoginViewImpl.VIEW_NAME);

    }

    @WebServlet(urlPatterns = "/*", name = "MSTUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MSTUI.class, productionMode = false)
    public static class MSTUIServlet extends VaadinCDIServlet {
    }
}
