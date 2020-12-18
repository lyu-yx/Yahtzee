package game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputeAlgorithms {
    public static int acesResult, twosResult, threesResult, foursResult,
               fivesResult, sixesResult, upperScoreSum, upperBonus, upperTotal;
    public static int threeOfaKind, fourOfaKind, fullHouse, smallStraight,
               largeStraight, yahtzee, chance, yahtzeeBonus, lowerScoreSum,
               grandTotal;
    private static int yahtzeeCount = 0;
    public static boolean[] isOccupied = new boolean[13];

    private static int computeAces(List<Integer> imageSequence){
        int result = 0;
        for (int i : imageSequence) {
            if (i == 0) {
                result += 1;
            }
        }
        return result;
    }

    private static int computeTwos(List<Integer> imageSequence){
        int result = 0;
        for (int i : imageSequence) {
            if (i == 1) {
                result += 2;
            }
        }
        return result;
    }

    private static int computeThrees(List<Integer> imageSequence){
        int result = 0;
        for (int i : imageSequence) {
            if (i == 2) {
                result += 3;
            }
        }
        return result;
    }

    private static int computeFours(List<Integer> imageSequence){
        int result = 0;
        for (int i : imageSequence) {
            if (i == 3) {
                result += 4;
            }
        }
        return result;
    }

        private static int computeFives(List<Integer> imageSequence){
        int result = 0;
        for (int i : imageSequence) {
            if (i == 4) {
                result += 5;
            }
        }
        return result;
    }

    private static int computeSixes(List<Integer> imageSequence){
        int result = 0;
        for (int i : imageSequence) {
            if (i == 5) {
                result += 6;
            }
        }
        return result;
    }

    public static int computeUpperScoreSum() {
        upperScoreSum = acesResult + twosResult + threesResult
                        + foursResult + fivesResult + sixesResult;
        return  upperScoreSum;
    }

    public static int computeUpperBonus() {
        if (upperScoreSum >= 63) {
            upperBonus = 35;
        }
        return upperBonus;
    }

    public static int computeUpperTotal() {
        return upperTotal = upperBonus + upperScoreSum;
    }

    private static int computeThreeOfaKind(List<Integer> imageSequence) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : imageSequence) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }


        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 3) {
                return ComputeAlgorithms.sumUpSequence(imageSequence);
            }
        }

        return 0;
    }

    private static int computeFourOfaKind(List<Integer> imageSequence){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : imageSequence) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 4) {
                return ComputeAlgorithms.sumUpSequence(imageSequence);
            }
        }
        return 0;
    }


    private static int computeFullHouse(List<Integer> imageSequence){
        int result = 0;
        int size = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : imageSequence) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        size = map.size();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 3 && size == 2 || computeYahtzee(imageSequence) == 50 && upperAllSelected(isOccupied)) {
                return 25;
            }
        }
        return 0;
    }

    private static int computeSmallStraight(List<Integer> imageSequence){
        for (int i = 0; i < 3; i++) {
            if (imageSequence.contains(i) && imageSequence.contains(i + 1)
                && imageSequence.contains(i + 2) && imageSequence.contains(i + 3)
                || computeYahtzee(imageSequence) == 50 && upperAllSelected(isOccupied)) {
                return 30;
            }
        }
        return 0;
    }

    private static int computeLargeStraight(List<Integer> imageSequence){
        for (int i = 0; i < 2; i++) {
            if (imageSequence.contains(i) && imageSequence.contains(i + 1)
                && imageSequence.contains(i + 2) && imageSequence.contains(i + 3)
                && imageSequence.contains(i + 4)
                || computeYahtzee(imageSequence) == 50 && upperAllSelected(isOccupied)) {
                    return 40;
            }
        }
        return 0;
    }

    private static int computeYahtzee(List<Integer> imageSequence){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : imageSequence) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 5) {
                yahtzee = 50;
                yahtzeeCount++;
                return yahtzee;
            }
        }
        return 0;
    }

    private static int computeChance(List<Integer> imageSequence) {
        return ComputeAlgorithms.sumUpSequence(imageSequence);
    }


    static int computeYahtzeeBonus() {
        if (yahtzee != 0) {
            yahtzeeBonus = (yahtzeeCount - 1) * 100;
        }
        return yahtzeeBonus;
    }

    static int computeLowerSum() {
        return lowerScoreSum = threeOfaKind + fourOfaKind + fullHouse
                             + smallStraight + largeStraight + yahtzee
                             + chance + yahtzeeBonus;
    }

    static int computeGrandTotal() {
        return grandTotal = lowerScoreSum + upperScoreSum;
    }


    private static boolean upperAllSelected(boolean[] isOccupied) {
        return isOccupied[0] && isOccupied[1]  && isOccupied[2] && isOccupied[3] && isOccupied[4] && isOccupied[5];
    }

    public static void computeAllPossibleScore(List<Integer> imageSequence) {
        if (!isOccupied[0])
            acesResult = computeAces(imageSequence);
        if (!isOccupied[1])
            twosResult = computeTwos(imageSequence);
        if (!isOccupied[2])
            threesResult = computeThrees(imageSequence);
        if (!isOccupied[3])
            foursResult = computeFours(imageSequence);
        if (!isOccupied[4])
            fivesResult = computeFives(imageSequence);
        if (!isOccupied[5])
            sixesResult = computeSixes(imageSequence);
        if (!isOccupied[6])
            threeOfaKind = computeThreeOfaKind(imageSequence);
        if (!isOccupied[7])
            fourOfaKind = computeFourOfaKind(imageSequence);
        if (!isOccupied[8])
            fullHouse = computeFullHouse(imageSequence);
        if (!isOccupied[9])
            smallStraight = computeSmallStraight(imageSequence);
        if (!isOccupied[10])
            largeStraight = computeLargeStraight(imageSequence);
        if (!isOccupied[11])
            yahtzee = computeYahtzee(imageSequence);
        if (!isOccupied[12])
            chance = computeChance(imageSequence);
    }


    public static void resetAll() {
        for (int i = 0; i < 5; i++) {
            ImagePanel.imagePanelList.get(i).setImage(ImagePanel.diceImages[0]);
            ImagePanel.imagePanelList.get(i).scaleImage(0.5);
            ImagePanel.checkBoxesList.get(i).setSelected(false);

        }
        if (!isOccupied[0])//aces
            acesResult = 0;
        if (!isOccupied[1])//twos
            twosResult = 0;
        if (!isOccupied[2])//threes
            threesResult = 0;
        if (!isOccupied[3])//fours
            foursResult = 0;
        if (!isOccupied[4])//fives
            fivesResult = 0;
        if (!isOccupied[5])//sixes
            sixesResult = 0;
        if (!isOccupied[6])//threeOfaKind
            threeOfaKind = 0;
        if (!isOccupied[7])//fourOfaKind
            fourOfaKind = 0;
        if (!isOccupied[8])//FullHouse
            fullHouse = 0;
        if (!isOccupied[9])//smallStraight
            smallStraight = 0;
        if (!isOccupied[10])//largeStraight
            largeStraight = 0;
        if (!isOccupied[11])//yahtzee
            yahtzee = 0;
        if (!isOccupied[12])//chance
            chance = 0;


        UpperSectionPanel.renewUpperScore(ImagePanel.imageSequence);
        LowerSectionPanel.renewLowerScore(ImagePanel.imageSequence);
    }


    public static int sumUpSequence(List<Integer> imageSequence){
        int result = 0;
        for (int currSequence : imageSequence) {
            result += currSequence + 1;
        }
        return result;
    }

    public static void printImageSequence() {
        for (int i : ImagePanel.imageSequence) {
            System.out.println(i);
        }
    }
}
