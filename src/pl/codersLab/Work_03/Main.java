package pl.codersLab.Work_03;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        guessTheNumber();
    }

    static void guessTheNumber() {
        int min = 0;
        int max = 1000;
        System.out.println("Pomyśl liczbę od 0 do 1000, a ja zgadnę w max 10 próbach");
        Scanner scanner = new Scanner(System.in);


        for (int i = 0; i <= 10; i++) {
            int guess = ((max - min) / 2) + min;
            System.out.println("Zgaduję " + guess);
            String ourComment = scanner.nextLine();
            while(true){
                if(ourComment.equals("za dużo")) {
                    max = guess;
                    break;
                } else if (ourComment.equals("za mało")) {
                    min = guess;
                    break;
                } else if (ourComment.equals("zgadłeś")) {
                    System.out.println("Wygrałem!!!");
                    System.exit(0);
                }
                else{
                    System.out.println("Nie oszukuj!!!");
                    break;
                }
            }
        }
    }
}
