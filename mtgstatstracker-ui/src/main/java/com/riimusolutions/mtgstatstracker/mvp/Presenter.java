package com.riimusolutions.mtgstatstracker.mvp;

public abstract class Presenter<V extends IView> {

    private V view;

    public Presenter(V view) {
        this.view = view;
    }

    protected V getView() {
        return view;
    }

}
