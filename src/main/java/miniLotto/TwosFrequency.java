package miniLotto;

import miniLotto.utilities.Statistics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//points to lista numerów linii, w których wystąpiły dwójki
public class TwosFrequency {
    public static void main(String[] args) {
        Scanner in;
        LinkedList<Integer> distances = null;
        LinkedList<Integer> points = null;
        for(int i=1;i<=41;i++){
            for (int j=1;j<=42;j++){
                if(j>i){
                    try {
                        in = new Scanner(new File("src/miniLotto/wyniki-minilotto-sortowane-parsed.csv"));
                        int line = 0;
                        distances = new LinkedList();
                        points = new LinkedList<>();
                        while (in.hasNextLine()) {
                            line++;
                            String tableStr[]=in.nextLine().split("\t");
                            for (int x=0;x<5;x++){
                                if(tableStr[x].equals(String.valueOf(i))){
                                    for (int y=0;y<5;y++){
                                        if(y!=x){
                                            if(tableStr[y].equals(String.valueOf(j))){
                                               points.add(line);
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        in.close();
                        for (int e = 0; e < points.size() - 1; e++) {
                            distances.add(points.get(e + 1) - points.get(e));
                        }
                       // System.out.println(points);
                        System.out.println();
                        System.out.println("--------------------------------------------");
                        System.out.println(i + " | " + j);
                        System.out.println(distances);
                        System.out.println(
                                "największa przerwa: " +
                                distances.stream().mapToInt(Integer::intValue).max() + "\t"
                        );
                        System.out.println(
                                "najmniejsza przerwa: " +
                                distances.stream().mapToInt(Integer::intValue).min() + "\t"
                        );
                        System.out.println(
                                "średnia przerwa: " +
                                        distances.stream().mapToInt(Integer::intValue).average() + "\t"
                        );
                        System.out.println(
                                "Mediana: " + (Statistics.findMedian(distances))//uwaga: po tej instrukcji distances jest już posortowana!!!
                        );
                        System.out.println(
                                "Trzeci kwantyl: " +
                                        (Statistics.findQ3(distances)) + "\t"
                        );
                        System.out.println(
                                "Ostatnie wystąpienie było: " +
                                        (line - points.getLast()) + " losowań temu." + "\t"
                        );
                        //System.out.println(distances.stream().mapToInt(Integer::intValue).summaryStatistics());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
