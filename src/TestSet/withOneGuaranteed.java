package TestSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class withOneGuaranteed {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file=new Scanner(new File("src/losowania.txt"));
        Scanner in=new Scanner(System.in);
        System.out.println("Wprowadź zestaw:");
        int zestaw[]=new int[5];
        for(int i=0;i<5;i++){
            zestaw[i]=in.nextInt();
        }
        System.out.println("Wybrany zestaw liczb: "+ Arrays.toString(zestaw));
        System.out.println("-----------------------");
        int temptable[]=new int[6];
        in.close();
        int statystyka[]=new int[7];
        while(file.hasNextLine()){
            String temptableStr[]=file.nextLine().split("\t");
            for (int i=0;i<6;i++){
                temptable[i]=Integer.parseInt(temptableStr[i]);
            }
            int counter=1;
            for (int i=0;i<6;i++){
                for(int j=0;j<5;j++){
                    if(zestaw[j]==temptable[i]){
                        counter++;
                        break;
                    }
                }
            }
            switch (counter){
                case 0:{
                    statystyka[0]++;
                    break;
                }
                case 1:{
                    statystyka[1]++;
                    break;
                }
                case 2:{
                    statystyka[2]++;
                    break;
                }
                case 3:{
                    statystyka[3]++;
                    break;
                }
                case 4:{
                    statystyka[4]++;
                    break;
                }
                case 5:{
                    statystyka[5]++;
                    break;
                }
                case 6:{
                    statystyka[6]++;
                    break;
                }
            }

        }
        file.close();
        System.out.println("================PODSUMOWANIE================");
        System.out.println("Satystyka: "+Arrays.toString(statystyka));
        double partSum =0;
        double sum=0;
        double chances=0;
        for (int i=0;i<7;i++){
            sum+=statystyka[i];
            if (i>=3&&i<=6){
                partSum +=statystyka[i];
            }
        }
        chances=partSum/sum;
        chances=chances*100;
        System.out.printf("Szanse na trafienie trójki, czwórki, piątki,lub szóśtki wynosi: %.2f%%" ,chances);

    }
}
