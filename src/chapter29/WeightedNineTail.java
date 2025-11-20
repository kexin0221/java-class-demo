package chapter29;

import chapter28.NineTailModel;
import java.util.Scanner;

public class WeightedNineTail {
    public static void main(String[] args) {
        // Prompt the user to enter nine coins' Hs and Ts
        System.out.print("Enter an initial nine coins' Hs and Ts: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        char[] initialNode = s.toCharArray();

        WeightedNineTailModel model = new WeightedNineTailModel();
        java.util.List<Integer> path = model.getShortestPath(NineTailModel.getIndex(initialNode));

        System.out.println("The steps to flip the coins are ");
        for (Integer integer : path) NineTailModel.printNode(NineTailModel.getNode(integer));

        System.out.println("The number of flips is " + model.getNumberOfFlips(NineTailModel.getIndex(initialNode)));
    }
}
