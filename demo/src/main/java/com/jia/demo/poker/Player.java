package com.jia.demo.poker;

public class Player {
    private String name;
    private String playerId;
    private PokerCard pokerCard;

    public Player(String name, String playerId) {
        this.name = name;
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public PokerCard getPokerCard() {
        return pokerCard;
    }

    public void setPokerCard(PokerCard pokerCard) {
        this.pokerCard = pokerCard;
    }
}
