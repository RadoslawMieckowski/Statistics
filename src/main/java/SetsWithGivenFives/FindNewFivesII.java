package SetsWithGivenFives;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindNewFivesII {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("src/SetsWithGivenFives/piątki_wystąpienia_licznik_2.txt"));
        String[] tabOfSix;  //tablica zawięrającalicznik
        String[] tabOfSearchedFives;
        Set<String> setOfsearchedFives;
        Set<String> setOfSix;
        Scanner wszystkieLosowania;
        //System.out.println("Nowe piątki po 2 razy:");
        int counterWszystkichDwójek = 0;
        while (in.hasNextLine()) {
            tabOfSix = in.nextLine().replace(" | ", "\t").split("\t");
            //System.out.println("setOfSix" + setOfSix);
            tabOfSearchedFives = Arrays.copyOf(tabOfSix, 5);
            setOfsearchedFives = new HashSet<>(Set.of(tabOfSearchedFives));
            wszystkieLosowania = new Scanner(new File("src/losowania.txt"));
            int counter = 0;
            while (wszystkieLosowania.hasNextLine()){
                String[] localSix = wszystkieLosowania.nextLine().split("\t");  //tablica zawierająca cały zestaw z losowania
                setOfSix = new HashSet<>(Set.of(localSix));
                if(setOfSix.containsAll(setOfsearchedFives)) {
                    counter++;
                }
            }
            if(counter == 3) {  //w razie szukania nowych trójek można dać tu 3 zamiast 2
                counterWszystkichDwójek++;
                System.out.println(Arrays.toString(tabOfSearchedFives) + "\tlicznik: " + counter);
            }
            wszystkieLosowania.close();
        }
        System.out.println("wszystkie przypadki łącznie: " + counterWszystkichDwójek);
        in.close();
    }

}
