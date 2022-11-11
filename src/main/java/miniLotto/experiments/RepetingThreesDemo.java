package miniLotto.experiments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class RepetingThreesDemo {
    static int oldTab[]=new int[5];
    static int newTab[]=new int[5];
    static int counter=0;
    static LinkedList<Integer> winningDistances;
    static int counterOfDistancesBetweenThrees = 1;

    public static void main(String[] args) {
        winningDistances = new LinkedList<>();
        Scanner in = wczytywanie();
        lookForThreesAndMakeWinningDistancesList(in);
    }

    static Scanner wczytywanie() {
        Scanner in = null;
        try {
            in = new Scanner(new File("src/main/java/miniLotto/wyniki-minilotto-sortowane-parsed.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return in;
    }

    static void lookForThreesAndMakeWinningDistancesList(Scanner in) {
        for (int i=0;i<5;i++){
            oldTab[i]=in.nextInt();
        }
        System.out.println(Arrays.toString(oldTab));
        for (int i=0;i<5;i++){
            newTab[i]=in.nextInt();
        }
        System.out.println(Arrays.toString(newTab));
        findingWinningDistances();
        System.out.println(counter);

        while(in.hasNextLine()){
            oldTab=Arrays.copyOf(newTab,5);
            System.out.println(Arrays.toString(oldTab));
            for (int i=0;i<5;i++){
                newTab[i]=in.nextInt();
            }
            System.out.println(Arrays.toString(newTab));
            findingWinningDistances();
            System.out.println(counter);
        }
    }

    static void findingWinningDistances(){
        boolean isSuccess = false;
        int counterThree =0;
        stop:
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(oldTab[i]== newTab[j]){
                    counterThree++;
                    if(counterThree ==3){
                        counter++;
                        isSuccess = true;
                        winningDistances.add(counterOfDistancesBetweenThrees);
                        counterOfDistancesBetweenThrees = 1;
                        break stop;
                    }
                }
            }
        }
        if (isSuccess == false) {
            counterOfDistancesBetweenThrees++;
        }
    }
}
