package com.riimusolutions.mtgstatstracker.mvp;

import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("rawtypes")
public abstract class View<P extends Presenter> extends VerticalLayout
        implements com.vaadin.navigator.View {

    private P presenter;

    public View() {
        presenter = createPresenter();
        setSizeFull();
    }

    protected abstract void createContent();

    protected abstract P createPresenter();

    protected P getPresenter() {
        return presenter;
    }

}
