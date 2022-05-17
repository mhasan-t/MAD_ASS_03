package com.example.mad_ass_03;

import java.util.ArrayList;

public class OptionsDataModel {

    private String ops;
    Boolean isCorrect;

    public String getOps() {
        return ops;
    }

    public void setOps(String ops) {
        this.ops = ops;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }

    public OptionsDataModel(String ops, Boolean isCorrect) {
        this.ops = ops;
        this.isCorrect = isCorrect;
    }
}
