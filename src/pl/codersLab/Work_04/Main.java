package pl.codersLab.Work_04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(throwDice("rzuc 1D20+0"));
    }

    private static Integer throwDice(String throwCommand) {
        Random random = new Random();
        Integer result = 0;
        String diceDeclaration = throwCommand.split(" ")[1];

        int dIndex = diceDeclaration.indexOf("D");
        int plusIndex = diceDeclaration.indexOf("+");

        String throwCountStr = diceDeclaration.substring(0, dIndex);
        String diceTypeStr = diceDeclaration.substring(dIndex + 1, plusIndex);
        String bonusStr = diceDeclaration.substring(plusIndex + 1);

        Integer throwCount = new Integer(throwCountStr);
        Integer diceType = new Integer(diceTypeStr);
        Integer bonus = new Integer(bonusStr);

        for(int i = 0 ; i < throwCount ; i++){
            result = random.nextInt(diceType) + 1;
        }

        result += bonus;

        return result;
    }
}
