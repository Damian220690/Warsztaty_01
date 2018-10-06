package pl.codersLab.Work_01;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        guessTheNumber();
    }

    static void guessTheNumber(){
        Random random = new Random();
        int computerNumber = random.nextInt(100)+1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zgadnij liczbę: ");
        String ourNumber = scanner.next();
        System.out.println(computerNumber);
        while(true){
           if(!StringUtils.isNumeric(ourNumber)){
               System.out.println("To nie jest liczba!!! Podaj liczbę");
               ourNumber = scanner.next();
           }
           else{
               int number = Integer.parseInt(ourNumber);
                if(number > computerNumber){
                    System.out.println("za dużo!!!");
                    ourNumber = scanner.next();
                }
                else if(number < computerNumber){
                    System.out.println("za mało!!!");
                    ourNumber = scanner.next();
                }
                else{
                    System.out.println("Zgadłeś!");
                    break;
                }
           }
        }
    }

}
