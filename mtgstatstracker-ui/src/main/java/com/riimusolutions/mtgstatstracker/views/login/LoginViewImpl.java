package com.riimusolutions.mtgstatstracker.views.login;

import com.riimusolutions.mtgstatstracker.mvp.View;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;

@CDIView("login-view")
public class LoginViewImpl extends View<LoginPresenter> implements ILoginView {

    public static final String VIEW_NAME = "login-view";

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public void enter(ViewChangeEvent event) {
        super.enter(event);
        createContent();
    }

    @Override
    protected void createContent() {
        MSTLoginForm loginForm = new MSTLoginForm(getPresenter());
        addComponent(loginForm);
        setComponentAlignment(loginForm, Alignment.MIDDLE_CENTER);

    }

}
