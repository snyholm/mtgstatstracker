package com.riimusolutions.mtgstatstracker.views.login;

import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.server.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

public class MSTLoginForm extends VerticalLayout {

    private LoginPresenter presenter;

    private TextField username;
    private PasswordField password;

    private Button forgotAccount;
    private Button signUp;

    public MSTLoginForm(LoginPresenter presenter) {
        this.presenter = presenter;
        createContent();

        setSizeUndefined();
    }

    private void createContent() {
        username = new TextField("Username");
        password = new PasswordField("Password");

        username.addValueChangeListener(e -> clearFieldOnTextInput(e));

        forgotAccount = new Button("Forgot username/password");
        forgotAccount.setStyleName(ValoTheme.BUTTON_LINK);
        forgotAccount.addClickListener(e -> attemptLogin());

        signUp = new Button("Sign Up");
        signUp.setStyleName(ValoTheme.BUTTON_LINK);

        addComponents(username, password, forgotAccount, signUp);

    }

    private void clearFieldOnTextInput(ValueChangeEvent<String> event) {
        ((TextField) event.getComponent()).setComponentError(null);
    }

    private void attemptLogin() {

        if (!username.isEmpty() && !password.isEmpty()) {
            presenter.attemptLogin(username.getValue(), password.getValue());
        } else if (username.isEmpty()) {
            username.setComponentError(
                    new UserError("Username cannot be empty"));
        } else {
            password.setComponentError(
                    new UserError("Password cannot be empty"));
        }
    }

}
