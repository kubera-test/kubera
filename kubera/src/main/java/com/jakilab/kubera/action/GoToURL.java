package com.jakilab.kubera.action;

import com.codeborne.selenide.Selenide;

public class GoToURL implements Action {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void execute() {
        Selenide.open(url);
    }

    @Override
    public void validate() {

    }
}
