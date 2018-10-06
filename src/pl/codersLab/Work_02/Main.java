package pl.codersLab.Work_02;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        randomNumbers();
    }

    static void randomNumbers() {
        Integer[] arr = new Integer[49];
        ArrayList<Integer> ourList = new ArrayList<Integer>();
        ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        List<Integer> listOfNumbers = Arrays.asList(arr);
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < 6; i++) {
            System.out.println("Please enter " + (i + 1) + " value:");
            Scanner scanner = new Scanner(System.in);
            while(true) {
                String number = scanner.next();
                int newNumber = 0;
                if(StringUtils.isNumeric(number)) {
                    newNumber = Integer.parseInt(number);
                    if (!ourList.contains(newNumber) && listOfNumbers.contains(newNumber)) {
                        ourList.add(newNumber);
                        break;
                    } else if (ourList.contains(newNumber)) {
                        System.out.println("This value is already entered!!! Please enter another");
                    } else if (!listOfNumbers.contains(newNumber)) {
                        System.out.println("Please enter the value from range 1-49 ");
                    }
                }
                else{
                    System.out.println("Please enter numeric value!!!");
                }
            }
        }
        Collections.sort(ourList);
        System.out.println("Your numbers: "+ ourList.toString());

        showNumbersFromDraw(randomNumbers);

        for(int numberFromOurList : ourList){
            if(randomNumbers.contains(numberFromOurList)){
                counter++;
            }
        }
        System.out.println("You hit " + counter + " number");
    }

    static List<Integer> showNumbersFromDraw(ArrayList<Integer> list){
        Random random = new Random();
        for(int i = 0; i < 6; i++) {
            int result = random.nextInt(49) + 1;
            list.add(result);
        }
        System.out.println("Numbers from draw:" + list.toString());
        return list;
    }
}
