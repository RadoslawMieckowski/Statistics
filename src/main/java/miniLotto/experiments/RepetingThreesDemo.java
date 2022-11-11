package miniLotto.experiments;

import miniLotto.utilities.Statistics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RepetingThreesDemo {
    static int oldTab[]=new int[5];
    static int newTab[]=new int[5];
    static int counter=0;
    static LinkedList<Integer> winningDistances;
    static int counterOfDistancesBetweenThrees = 1;

    public static void main(String[] args) {
        winningDistances = new LinkedList<>();
        Scanner in = readFile("src/main/java/miniLotto/wyniki-minilotto-sortowane-parsed.csv");
        lookForThreesAndMakeWinningDistancesList(in);// mamy obliczone znalezione winning distances
        System.out.println();
        System.out.println("==========================================");
        System.out.println("interwały znalezionych przypadków: ");
        System.out.println(winningDistances);
        double median = Statistics.findMedian(winningDistances);
        System.out.println("Mediana zbioru: " + median);
        double q3 = Statistics.findQ3(winningDistances);
        System.out.println("Trzeci kwantyl zbioru: " + q3);
        double lastOccurence = winningDistances.getLast();// zależy nam na ostatnim przypadku nieposortowanego zbioru
        System.out.println("Ostatni przypadek: " + lastOccurence);
        double avg = winningDistances.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        System.out.println("Średni interwał: " + avg);
        System.out.println("posortowane interwały znalezionych przypadków: ");
        List<Integer> winningDistancesCopy = new ArrayList<>(winningDistances);
        Collections.sort(winningDistancesCopy);
        System.out.println(winningDistancesCopy);
        in.close();
    }

    static Scanner readFile(String fileName) {
        Scanner in = null;
        try {
            in = new Scanner(new File(fileName));
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

        findingWinningDistancesAndCountWins();
        System.out.println(counter);

        while (in.hasNextLine()) {
            oldTab = Arrays.copyOf(newTab,5);
            System.out.println(Arrays.toString(oldTab));
            for (int i = 0; i < 5; i++){
                newTab[i] = in.nextInt();
            }
            System.out.println(Arrays.toString(newTab));
            findingWinningDistancesAndCountWins();
            System.out.println("liczba znalezionych przypadków (trójek z poprzedniego losowania): "
                    + counter);
        }
    }

    static void findingWinningDistancesAndCountWins(){
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
