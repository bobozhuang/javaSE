package main.java.com.bobozhuang.collection.poker;

import java.util.Comparator;

/**
 * description：
 * author Hubery
 * date 2020-08-30
 * version v0.0.1
 * since v0.0.1
 **/
public class PokerSorter implements Comparator<String> {

    public PokerSorter() {
    }

    @Override
    public int compare(String poker1, String poker2) {
        if(poker2.equals("☀")
                || (!poker1.equals("☀") && poker2.equals("🌙"))) {
            return -1;
        } else if (poker1.equals("☀") || poker1.equals("🌙")) {
            return 1;
        }

        int value1 = getValue(poker1);
        int value2 = getValue(poker2);
        int res = value1 - value2;
        if (res == 0) {
            String color1 = poker1.substring(0, 1);
            String color2 = poker2.substring(0, 1);

            res = dealValueSame(color1, color2);
        }
        return res;
    }
    private int dealValueSame(String color1, String color2) {
        if (color1.equals("♣")) {
            return 1;
        } else if (color1.equals("♥")
                || (color1.equals("♠") && color2.equals("♣"))
                || ((color1.equals("♦") && !color2.equals("♥")))) {
            return -1;
        }
        return 1;
    }

    private int getValue(String poker) {
        if (poker.substring(1).equals("A")) {
            return 1;
        } else if (poker.substring(1).equals("J")) {
            return 11;
        } else if (poker.substring(1).equals("Q")) {
            return 12;
        } else if (poker.substring(1).equals("K")) {
            return 13;
        } else {
            return Integer.valueOf(poker.substring(1));
        }
    }

}
