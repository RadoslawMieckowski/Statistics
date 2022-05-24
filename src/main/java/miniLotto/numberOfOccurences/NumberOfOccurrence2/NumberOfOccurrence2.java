package miniLotto.numberOfOccurences.NumberOfOccurrence2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class NumberOfOccurrence2 {
    static int oldTab[]=new int[5];
    static int newTab[]=new int[5];
    static int counter=0;
    public static void main(String[] args){
        try {
            wczytywanie();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            //System.out.println(counter);
        }
    }
    static void wczytywanie() throws FileNotFoundException {
        Scanner in=new Scanner(new File("src/main/java/miniLotto/wyniki-minilotto-sortowane-parsed.csv"));
        //in.useDelimiter(" ");

        for (int i=0;i<5;i++){
            oldTab[i]=in.nextInt();
        }
        System.out.println(Arrays.toString(oldTab));
        for (int i=0;i<5;i++){
            newTab[i]=in.nextInt();
        }
        System.out.println(Arrays.toString(newTab));
        liczenie();
        System.out.println(counter);

        while(in.hasNextLine()){
            oldTab=Arrays.copyOf(newTab,5);
            System.out.println(Arrays.toString(oldTab));
            for (int i=0;i<5;i++){
                newTab[i]=in.nextInt();
            }
            System.out.println(Arrays.toString(newTab));
            liczenie();
            System.out.println(counter);
        }
        in.close();
    }

    static void liczenie(){
        int counterTwo=0;
        stop:
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(oldTab[i]== newTab[j]){
                    counterTwo++;
                    if(counterTwo==2){
                        counter++;
                        break stop;
                    }
                }
            }
        }
    }
}
