package CounterOfNumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Counter {
    public static void main(String[] args)  {
        HashMap<Integer,Integer> map= new HashMap<>(49);
        LinkedHashMap<Integer,Integer>sortedMap;

        try {
            Scanner in;
            int counter;
            //int rowCounter=0;
            for(int i=1;i<=49;i++){
                in =new Scanner(new File("src/losowania.txt"));
                counter=0;
                while (in.hasNextInt()){
                    int temp=in.nextInt();
                    if(i==temp){
                        counter++;
                    }
                }
                map.put(i,counter);
                in.close();
                //System.out.println(i+" wystąpiła "+counter+" razy.");
            }
            System.out.println("liczby w kolejności od najrzadszych do najczęstszych:");
            sortedMap=map.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (oldValue,newValue)->oldValue, LinkedHashMap::new));
            Set <Integer>keys = sortedMap.keySet(); //zbiór kluczy
            for (Integer key : keys) {      //iterowanie po kluczach
                System.out.println(key + " wystąpiła "+ sortedMap.get(key)+" razy.");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
