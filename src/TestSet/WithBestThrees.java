package TestSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WithBestThrees {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner wszystkieLosowania = new Scanner(new File("src/losowania.txt"));
        int statystyka[]=new int[7];
        while (wszystkieLosowania.hasNextLine()){
            Scanner mojeLosy = new Scanner(new File("src/TestSet/najczęstszeTrójkiSformatowane.txt"));
            String tab[]= wszystkieLosowania.nextLine().split("\t");
            while (mojeLosy.hasNextLine()){
                String los[]= mojeLosy.nextLine().split("\t");
                List<String> list=new ArrayList<>(6);
                for (String liczba:los){
                    list.add(liczba);
                }
                int counter=0;
                for (int i=0;i<6;i++){
                    if(list.contains(tab[i])){
                        counter++;
                    }
                }
                switch (counter){
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
            mojeLosy.close();
        }
        wszystkieLosowania.close();

        System.out.println("================PODSUMOWANIE================");
        System.out.println("Satystyka: "+ Arrays.toString(statystyka));
        double partSum =0;
        double liczbaWszystkichLosowań =6671;
        double chances=0;
        for (int i=0;i<7;i++){
            if (i>=3&&i<=6){
                partSum +=statystyka[i];
            }
        }
        chances=partSum/ liczbaWszystkichLosowań;
        chances=chances*100;
        System.out.printf("Szanse na trafienie trójki, czwórki, piątki,lub szóśtki wynosi: %.2f%%" ,chances);


    }
}

