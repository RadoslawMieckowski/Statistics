package NumberOfOccurrence1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class NumberOfOccurrence {
    static int oldTab[]=new int[6];
    static int newTab[]=new int[6];
    static int counter=0;
    public static void main(String[] args){
        try {
            wczytywanie();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    static void wczytywanie() throws FileNotFoundException {
        Scanner in=new Scanner(new File("src/main/resources/losowania.txt"));
        //in.useDelimiter(" ");

            for (int i=0;i<6;i++){
                oldTab[i]=in.nextInt();
            }
            System.out.println(Arrays.toString(oldTab));
            for (int i=0;i<6;i++){
                newTab[i]=in.nextInt();
            }
            System.out.println(Arrays.toString(newTab));
            liczenie();
            System.out.println(counter);

        while(in.hasNextLine()){
            oldTab=Arrays.copyOf(newTab,6);
            System.out.println(Arrays.toString(oldTab));
            for (int i=0;i<6;i++){
                newTab[i]=in.nextInt();
            }
            System.out.println(Arrays.toString(newTab));
            liczenie();
            System.out.println(counter);
        }
        in.close();
    }

    static void liczenie(){
        stop:
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(oldTab[i]== newTab[j]){
                    counter++;
                    break stop;
                }
            }
        }
    }
}
