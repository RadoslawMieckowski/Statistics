package miniLotto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class CounterOfFives {
    public static void main(String[] args) {
        int counter = 0;
        Scanner in;
        long liczbaPrzypadkow=0;
        Map<String,Integer> map= new HashMap<>();
        LinkedHashMap<String,Integer> sortedMap;
        System.out.println("Liczę.....");
        for (int c=1;c<=38;c++){
            for (int a=1;a<=39;a++){
                if (a>c){
                    for(int z=1;z<=40;z++){
                        if (z>a){
                            for(int i=1;i<=41;i++){
                                if(i>z){
                                    for (int j=1;j<=42;j++){
                                        if(j>i){
                                            liczbaPrzypadkow++;
                                            try {
                                                in = new Scanner(new File("src/miniLotto/wyniki-minilotto-sortowane-parsed.csv"));
                                                counter = 0;
                                                while (in.hasNextLine()) {
                                                    String tableStr[]=in.nextLine().split("\t");
                                                    for(int d=0;d<5;d++){
                                                        if(tableStr[d].equals(String.valueOf(c))){
                                                            for (int b=0;b<5;b++){
                                                                if (b!=d){
                                                                    if (tableStr[b].equals(String.valueOf(a))){
                                                                        for (int k=0;k<5;k++){
                                                                            if(k!=b && k!=d){
                                                                                if (tableStr[k].equals(String.valueOf(z))){
                                                                                    for (int x=0;x<5;x++){
                                                                                        if(x!=k && x!=b && x!=d){
                                                                                            if(tableStr[x].equals(String.valueOf(i))){
                                                                                                for (int y=0;y<5;y++){
                                                                                                    if(y!=x && y!=k && y!=b && y!=d){
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
                                                if (counter!=0){    //nie dodawaj do słownika piątek o 0-wym licznku
                                                    map.put(c + " | " + a + " | " + z + " | " + i + " | " + j,counter);
                                                }
                                            } catch (FileNotFoundException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                }

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
