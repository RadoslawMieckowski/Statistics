package MoreThanOne;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class MoreThanOne {
    static int result[]=new int[6];
    static int newTab[]=new int[6];

    public static void main(String[] args){
        try {
            Scanner inResult=new Scanner(new File("src/posortowane losowania.txt"));
            Scanner inSearch;
            while(inResult.hasNextLine()){
                for (int i=0;i<6;i++){
                    result[i]=inResult.nextInt();
                }
               // System.out.println("Szukany wynik:"+Arrays.toString(result));
                int counterResult=0;
               // boolean displayResult=true;
                inSearch=new Scanner(new File("src/posortowane losowania.txt"));   //świetna metoda
                int rowCounter=0;
                while (inSearch.hasNextLine()){
                    rowCounter++;
                    for (int i=0;i<6;i++){
                        newTab[i]=inSearch.nextInt();
                    }
                    if(Arrays.equals(result,newTab)){   //świetna metoda
                        counterResult++;
                       // System.out.println(Arrays.toString(result)+" w linijce nr: "+rowCounter);
                    }
                }
                inSearch.close();
                if (counterResult>1) System.out.println("Wybrane losowanie "+Arrays.toString(result)+"pojawiło się "+counterResult+" razy.");
            }
            inResult.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
