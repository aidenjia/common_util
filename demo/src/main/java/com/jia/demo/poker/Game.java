package com.jia.demo.poker;

import java.util.*;

public class Game {
    private PlayWay playWay;
    private List<Player> playerList;
    private Set<PokerCard> pokerCardSet;
    private Integer playNum;

    public Game() {
        // playWay = new PlayWay();
        playerList = new ArrayList<>();
        pokerCardSet = new HashSet<>();
        // playNum = 0;
    }

    public void init(Integer playerNum, PlayWay playWay) {
        this.playNum = playerNum;
        this.playWay = playWay;
        ***REMOVED***
        for (int i = 1; i <= playerNum; i++) {
            Player player = new Player("player" + i, String.valueOf(i));
            playerList.add(player);
        }
        for (PokerCard.PokerNumEnum numEnum : PokerCard.PokerNumEnum.values()) {
            if (numEnum.equals(PokerCard.PokerNumEnum.RED_JOKER) ||
                    numEnum.equals(PokerCard.PokerNumEnum.BLACK_JOKER)) {
                PokerCard pokerCard = new PokerCard(PokerCard.ColorEnum.SPADE, numEnum);
                pokerCardSet.add(pokerCard);
                continue;
            }
            for (PokerCard.ColorEnum colorEnum : PokerCard.ColorEnum.values()) {
                PokerCard pokerCard = new PokerCard(colorEnum, numEnum);
                // set color's number by playWay
                pokerCard.setColorNum(playWay.getColorEnum(), playWay.getColorNum());
                pokerCardSet.add(pokerCard);
            }
        }
    }

    public int playing() {
        int numResult = 0;
        for (Player player : playerList) {
            if (null != player.getPokerCard()) {
                numResult += player.getPokerCard().getNumber().num;
                //将手里牌清空
                player.setPokerCard(null);
            }
        }
        System.out.println("numResult=" + numResult);
        return numResult;
    }

    public class Send implements Runnable {
        private Player player;
        private PokerCard pokerCard;

        Send(Player player, PokerCard pokerCard) {
            this.player = player;
            this.pokerCard = pokerCard;
        }
        @Override
        public void run() {
            synchronized (player) {
                if (null == player.getPokerCard() && pokerCard.isSendFlag() == false) {
                    System.out.println("........thread is running:" + Thread.currentThread().getName());
                    //send card
                    player.setPokerCard(pokerCard);
                    pokerCard.setSendFlag(true);
                    String format = "player=%s,num=%s";
                    System.out.println(String.format(format, player.getName(), player.getPokerCard().getNumber().num));
                }
            }
        }
    }

//    public void send() {
//        for (Player player : playerList) {
//            for (PokerCard pokerCard : pokerCardSet) {
//                if (null == player.getPokerCard()) {
//                    System.out.println("........thread is running:" + Thread.currentThread().getName());
//                    //send card
//                    player.setPokerCard(pokerCard);
//                    //remove
//                    pokerCardSet.remove(pokerCard);
//                    break;
//                }
//            }
//        }
//    }


    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Set<PokerCard> getPokerCardSet() {
        return pokerCardSet;
    }

    public void setPokerCardSet(Set<PokerCard> pokerCardSet) {
        this.pokerCardSet = pokerCardSet;
    }

    public Integer getPlayNum() {
        return playNum;
    }

    public void setPlayNum(Integer playNum) {
        this.playNum = playNum;
    }
}
