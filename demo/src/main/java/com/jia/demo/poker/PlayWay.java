package com.jia.demo.poker;

public class PlayWay {
    private String name;
    private PokerCard.ColorEnum colorEnum;
    private Integer colorNum;

    PlayWay(){

    }

    public PlayWay(String name,PokerCard.ColorEnum colorEnum,Integer colorNum){
        this.name=name;
        this.colorEnum=colorEnum;
        this.colorNum=colorNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PokerCard.ColorEnum getColorEnum() {
        return colorEnum;
    }

    public void setColorEnum(PokerCard.ColorEnum colorEnum) {
        this.colorEnum = colorEnum;
    }

    public Integer getColorNum() {
        return colorNum;
    }

    public void setColorNum(Integer colorNum) {
        this.colorNum = colorNum;
    }
}
