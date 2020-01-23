package com.jia.demo.poker;

import java.util.concurrent.*;

public class Boostrap {
    private static Integer playNum = 0;

    public static void main(String[] args) {
        Game game = new Game();
        PlayWay playWay = new PlayWay("sum", PokerCard.ColorEnum.CLUB, 0);
        playNum = 2;
        game.init(playNum, playWay);
        int roundCount;
        if (game.getPokerCardSet().size() % playNum > 0) {
            roundCount = (game.getPokerCardSet().size() / playNum) + 1;
        } else {
            roundCount = game.getPokerCardSet().size() / playNum;
        }
        ExecutorService pool = Executors.newFixedThreadPool(playNum);
        for (int j = 1; j <= roundCount; j++) {
            System.out.println("..........round" + j + ".......");
            for (Player player : game.getPlayerList()) {
                for (PokerCard pokerCard : game.getPokerCardSet()) {
                    pool.execute(game.new Send(player, pokerCard));
                }
            }
            int numResult = game.playing();
            if (numResult >= 50) {
                System.out.println("player win");
            }
        }
    }
}
