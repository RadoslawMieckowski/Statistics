package miniLotto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TwosFrequency {
    public static void main(String[] args) {
        Scanner in;
        LinkedList<Integer> distances = null;
        for(int i=1;i<=41;i++){
            for (int j=1;j<=42;j++){
                if(j>i){
                    try {
                        in = new Scanner(new File("src/miniLotto/wyniki-minilotto-sortowane-parsed.csv"));
                        int line = 0;
                        distances = new LinkedList();
                        while (in.hasNextLine()) {
                            line++;
                            String tableStr[]=in.nextLine().split("\t");
                            for (int x=0;x<5;x++){
                                if(tableStr[x].equals(String.valueOf(i))){
                                    for (int y=0;y<5;y++){
                                        if(y!=x){
                                            if(tableStr[y].equals(String.valueOf(j))){
                                                if (distances.isEmpty()){
                                                    distances.add(line);
                                                } else {
                                                    distances.add(line - distances.getLast());
                                                }
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                        in.close();
                        distances.removeFirst();
                        System.out.println();
                        System.out.println("--------------------------------------------");
                        System.out.println(i + " | " + j);
                        System.out.println(
                                "największa przerwa: " +
                                distances.stream().mapToInt(Integer::intValue).max() + "\t"
                        );
                        System.out.println(
                                "najmniejększa przerwa: " +
                                distances.stream().mapToInt(Integer::intValue).min() + "\t"
                        );
                        System.out.println(
                                "średnia przerwa: " +
                                        distances.stream().mapToInt(Integer::intValue).average() + "\t"
                        );
                        //System.out.println(distances.stream().mapToInt(Integer::intValue).summaryStatistics());
                        System.out.println(distances);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
