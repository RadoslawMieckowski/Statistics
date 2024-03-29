package CounterOfNumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class CounterOfTrios {
    public static void main(String[] args) {
        int counter = 0;
        Scanner in;
        int liczbaPrzypadkow=0;
        Map<String,Integer> map= new HashMap<>();
        LinkedHashMap<String,Integer> sortedMap;
        System.out.println("Liczę.....");
        for(int z=1;z<=47;z++){
            for(int i=1;i<=48;i++){
                if(i>z){
                    for (int j=1;j<=49;j++){
                        if(j>i){
                            liczbaPrzypadkow++;
                            try {
                                in = new Scanner(new File("src/losowania.txt"));
                                counter = 0;
                                while (in.hasNextLine()) {
                                    String tableStr[]=in.nextLine().split("\t");
                                    for (int k=0;k<6;k++){
                                        if (tableStr[k].equals(String.valueOf(z))){
                                            for (int x=0;x<6;x++){
                                                if(x!=k){
                                                    if(tableStr[x].equals(String.valueOf(i))){
                                                        for (int y=0;y<6;y++){
                                                            if(y!=x && y!=k){
                                                                if(tableStr[y].equals(String.valueOf(j))){
                                                                    counter++;
                                                                    break;
                                                                }
                                                            }
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
                                // System.out.println(i +" | "+ j+" | Licznik: "+counter);
                                map.put(z +" | "+ i+" | "+j,counter);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }


            }
        }

        System.out.println("Liczba przypadków: "+liczbaPrzypadkow);
        sortedMap=map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue,newValue)->oldValue, LinkedHashMap::new));
        Set<String> keys = sortedMap.keySet(); //zbiór kluczy
        for (String key : keys) {     // iterowanie po kluczach
            System.out.println(key + " | licznik: "+sortedMap.get(key));
        }
    }

}
