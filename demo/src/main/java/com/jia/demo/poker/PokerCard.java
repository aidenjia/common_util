package com.jia.demo.poker;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mr.jia
 */
public class PokerCard {

    private ColorEnum color;
    private PokerNumEnum number;
    private static Map<ColorEnum, Integer> colorNumMap;
    private Integer reformCardCode;

    enum ColorEnum {
        HEART("heart"), SPADE("spade"), DIAMOND("diamond"), CLUB("club");
        String colorStr;

        ColorEnum(String colorStr) {
            this.colorStr = colorStr;
        }
    }

    enum PokerNumEnum {
        AS(1), TWO(2), THREE(3),
        FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
        NINE(9), TEN(10), J(11), Q(12),
        K(13), BLACK_JOKER(20), RED_JOKER(20);
        Integer num;

        PokerNumEnum(Integer num) {
            this.num = num;
        }
    }


    public PokerCard() {
    }

    public PokerCard(ColorEnum color, PokerNumEnum number, Integer reformCardCode) {
        this.color = color;
        this.number = number;
        colorNumMap = new ConcurrentHashMap();
        colorNumMap.put(color.HEART, 0);
        colorNumMap.put(color.DIAMOND, 0);
        colorNumMap.put(color.SPADE, 0);
        colorNumMap.put(color.CLUB, 0);
        this.reformCardCode = reformCardCode;
    }


    @Override
    public boolean equals(Object object) {
        if (null == object) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (object instanceof PokerCard) {
            PokerCard pokerCard = (PokerCard) object;
            if (pokerCard.number.equals(this.number)
                    && pokerCard.color.equals(this.color))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (number == null ? 0 : number.hashCode());
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (reformCardCode.hashCode());
        return result;
    }

    /**
     * set poker's color represents number to compare
     *
     * @param color
     * @param colorNum
     */
    public void setColorNum(ColorEnum color, Integer colorNum) {
        if (null == color || null == colorNum) {
            throw new IllegalArgumentException("illegal args");
        }
        colorNumMap.put(color, colorNum);
    }

    /**
     * @param pokerCard1
     * @param pokerCard2
     * @return 1 represent bigger 0 represent equal -1 represent smaller
     */
    public static int CompareTo(PokerCard pokerCard1, PokerCard pokerCard2) {
        int result = colorNumMap.get(pokerCard1.color).compareTo(colorNumMap.get(pokerCard2.color));
        if (result == 0) {
            result = pokerCard1.number.num.compareTo(pokerCard2.number.num);
        }
        return result;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public PokerNumEnum getNumber() {
        return number;
    }

    public void setNumber(PokerNumEnum number) {
        this.number = number;
    }

}
