package miniLotto;

import miniLotto.models.Two;
import miniLotto.utilities.Serializer;
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
        LinkedList<Integer> distances;
        LinkedList<Integer> points;
        LinkedList<Two> listToSerialize = new LinkedList<>();
        for(int i=1;i<=41;i++){
            for (int j=1;j<=42;j++){
                if(j>i){
                    try {
                        in = new Scanner(new File("src/main/java/miniLotto/wyniki-minilotto-sortowane-parsed.csv"));
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
                        Two pair = Two.builder()
                                .firstNumber(i)
                                .secondNumber(j)
                                .distances(distances)
                                .build();
                        System.out.println(distances);

                        pair.setMaxInterval(distances.stream()
                                .mapToInt(Integer::intValue)
                                .max()
                                .getAsInt());

                        System.out.println(
                                "największa przerwa: " + pair.getMaxInterval() + "\t"
                        );

                        pair.setMinInterval(distances.stream()
                                .mapToInt(Integer::intValue)
                                .min()
                                .getAsInt());

                        System.out.println(
                                "najmniejsza przerwa: " + pair.getMinInterval() + "\t"
                        );

                        pair.setAvgInterval(distances.stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .getAsDouble());

                        System.out.println(
                                "średnia przerwa: " + pair.getAvgInterval() + "\t"
                        );

                        pair.setMedOfintervals(Statistics.findMedian(distances)); //uwaga: po tej instrukcji distances jest już posortowana!!!
                        System.out.println("Mediana: " + pair.getMedOfintervals());

                        pair.setQ3Ofintervals(Statistics.findQ3(distances));
                        System.out.println("Trzeci kwantyl: " + pair.getQ3Ofintervals()+ "\t");

                        pair.setLastOccurence(line - points.getLast());
                        System.out.println(
                                "Ostatnie wystąpienie było: " + pair.getLastOccurence() + " losowań temu." + "\t"
                        );

                        pair.setMedOfintervals(pair.getMedOfintervals());
                        System.out.println("Czy ostatnie wystąpienie jest większe od mediany wystąpień: " + "\t" +
                                pair.isLastBiggerthanMed());

                        pair.setQ3Ofintervals(pair.getQ3Ofintervals());
                        System.out.println("Czy ostatnie wystąpienie jest większe od" +
                                " trzeciego kwartylu wystąpień: " + pair.isLastBiggerthanQ3() + "\t");

                        listToSerialize.add(pair);
                        //System.out.println(distances.stream().mapToInt(Integer::intValue).summaryStatistics());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        Serializer.serialize(listToSerialize, "src/main/resources/Twos_serialized.ser");
    }
}
