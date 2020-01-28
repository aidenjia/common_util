package com.jia.demo.poker;

import java.util.*;

public class Game {
    private List<Player> playerList = new ArrayList<>();
    private Set<PokerCard> pokerCardSet = Collections.synchronizedSet(new HashSet<>());
    private Integer threadCount;
    private volatile int numResult;


    public Game() {
    }

    public void init(Integer threadCount, Integer reformCardCode) {
        this.threadCount = threadCount;
        ***REMOVED***
        for (int i = 1; i <= threadCount; i++) {
            Player player = new Player("player" + i, String.valueOf(i));
            playerList.add(player);
        }
        for (PokerCard.PokerNumEnum numEnum : PokerCard.PokerNumEnum.values()) {
            if (numEnum.equals(PokerCard.PokerNumEnum.RED_JOKER) ||
                    numEnum.equals(PokerCard.PokerNumEnum.BLACK_JOKER)) {
                PokerCard pokerCard = new PokerCard(PokerCard.ColorEnum.SPADE, numEnum, reformCardCode);
                pokerCardSet.add(pokerCard);
                continue;
            }
            for (PokerCard.ColorEnum colorEnum : PokerCard.ColorEnum.values()) {
                PokerCard pokerCard = new PokerCard(colorEnum, numEnum, reformCardCode);
                pokerCardSet.add(pokerCard);
            }
        }
    }


    public void playing(Integer ruleSum) throws InterruptedException {
        int roundNum;
        if (pokerCardSet.size() % threadCount > 0) {
            roundNum = (pokerCardSet.size() / threadCount) + 1;
        } else {
            roundNum = pokerCardSet.size() / threadCount;
        }
        for (int j = 0; j < roundNum; j++) {
            System.out.println("..........round" + (j + 1) + ".......");
            //reset numResult
            numResult = 0;
            for (Player player : playerList) {
                //use multi-thread
                Thread thread = new Thread(new Send(player));
                thread.setName("thread-" + player.getName());
                thread.start();
                thread.join();
            }
            System.out.println("numResult=" + numResult);
            if (numResult >= ruleSum) {
                System.out.println("player win game over!!");
                break;
            }
        }
    }


    public class Send implements Runnable {
        private Player player;

        Send(Player player) {
            this.player = player;
        }

        @Override
        public void run() {
            if (null == player.getPokerCard()) {
                Iterator<PokerCard> pokerCardIterator = pokerCardSet.iterator();
                while (pokerCardIterator.hasNext()) {
                    PokerCard pokerCard = pokerCardIterator.next();
                    numResult += pokerCard.getNumber().num;
                    pokerCardIterator.remove();
                    String format = "player=%s,num=%s,color=%s,thread=%s";
                    System.out.println(String.format(format, player.getName(), pokerCard.getNumber().num, pokerCard.getColor().colorStr, Thread.currentThread().getName()));
                    break;
                }
            }
        }
    }
}
