package TestSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class FindAnythingII {
    public static void main(String[] args) throws FileNotFoundException {
        int temptable[]=new int[6];
        int zestaw[]=new int[12];
        int start=1;
        while (start!=39){
            for(int i=0;i<12;i++){
                zestaw[i]=start+i;
            }
            System.out.println("-----------------------");
            System.out.println("Wybrany zestaw liczb: "+ Arrays.toString(zestaw));
            start++;
            Scanner file=new Scanner(new File("src/posortowane losowania.txt"));
            for (int i=1;i<3332;i++){
                file.nextLine();
            }
            int statystyka[]=new int[7];
            while(file.hasNextLine()){
                String temptableStr[]=file.nextLine().split("\t");
                for (int i=0;i<6;i++){
                    temptable[i]=Integer.parseInt(temptableStr[i]);
                }
                // System.out.println(Arrays.toString(temptableStr));
                int counter=0;
                for (int i=0;i<6;i++){
                    for(int j=0;j<12;j++){
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
                        System.out.println("zostałeś milionerem! Znaleziona szóstka: "+Arrays.toString(temptable));
                        break;
                    }
                }
            }
            System.out.println("================PODSUMOWANIE================");
            System.out.println("Statystyka: "+Arrays.toString(statystyka));
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
            System.out.printf("Szanse na trafienie trójki, czwórki, piątki,lub szóśtki wynosi: %.2f%% \n" ,chances);
            System.out.println("---------------------------");
            file.close();
        }
    }
}
