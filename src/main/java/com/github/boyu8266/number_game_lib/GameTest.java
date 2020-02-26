package com.github.boyu8266.number_game_lib;


import com.github.boyu8266.number_game_lib.NumberGame.HintType;

import java.util.Scanner;

public class GameTest {

    public static void main(String... args) {
        NumberGame game = new NumberGame(100);
        HintType hintType = game.getHintType();

        Scanner reader = new Scanner(System.in);
        while (hintType != HintType.THE_RIGHT_ANSWER) {
            System.out.println(hintType.getMin() + " ~ " + hintType.getMax() + ": ");
            int n = reader.nextInt();
            hintType = game.guessNumber(n);
            System.out.println("------");
        }
        System.out.println("lucky number: " + hintType.getMax());
        System.out.println("guess number: " + hintType.getMin());
        reader.close();
    }

}
