package com.joykmax;

public class ChartData {
    private String textVal;
    private Integer percentVal;

    public ChartData(String textVal, Integer percentVal) {
        this.textVal = textVal;
        this.percentVal = percentVal;
    }

    public String getText() {
        return this.textVal;
    }
    public Integer getPercentVal() {
        return this.percentVal;
    }
}
