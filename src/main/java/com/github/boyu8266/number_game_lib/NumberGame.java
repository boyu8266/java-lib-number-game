package com.github.boyu8266.number_game_lib;

public class NumberGame {

    private int luckyNumber = Integer.MIN_VALUE;
    private HintType hintType;

    public enum HintType {

        IN_RANGE(Integer.MIN_VALUE, Integer.MIN_VALUE),
        THE_RIGHT_ANSWER(Integer.MIN_VALUE, Integer.MIN_VALUE);

        private int max;
        private int min;

        HintType(int max, int min) {
            this.max = max;
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public int getMin() {
            return min;
        }
    }

    public NumberGame(int max) {
        createNewGame(max);
    }

    private void initialNumbers() {
        luckyNumber = Integer.MIN_VALUE;
        hintType = HintType.IN_RANGE;
        hintType.min = Integer.MIN_VALUE;
        hintType.max = Integer.MIN_VALUE;
    }

    public void createNewGame(int max) {
        if (max < 0 || max > Integer.MAX_VALUE) {
            System.out.println("create new game failure.");
            return;
        }
        initialNumbers();
        luckyNumber = (int) (Math.random() * max) + 1;
        hintType.min = 1;
        hintType.max = max;
    }

    public HintType getHintType() {
        return hintType;
    }

    public HintType guessNumber(int number) {
        if (number == luckyNumber) {
            hintType = HintType.THE_RIGHT_ANSWER;
            hintType.max = luckyNumber;
            hintType.min = number;
            return getHintType();
        }

        if (number > hintType.getMax() || number < hintType.getMin()) {
            return getHintType();
        }
        hintType = HintType.IN_RANGE;
        if (number < luckyNumber) {
            hintType.min = number;
        } else if (number > luckyNumber) {
            hintType.max = number;
        }
        return getHintType();
    }

}
