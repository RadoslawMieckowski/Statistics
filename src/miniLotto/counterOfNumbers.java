//package miniLotto;
//
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.*;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class counterOfNumbers {
//    public static void main(String[] args)  {
//        HashMap<Integer,Integer> map= new HashMap<>(42);
//        LinkedHashMap<Integer,Integer> sortedMap;
//
//        try {
//            File file = new File("src/miniLotto/wyniki-minilotto-sortowane.csv");
//            InputStream targetStream = new FileInputStream(file);
//            String string = new String(targetStream.readAllBytes(), StandardCharsets.UTF_8);    //!!!! genialne!!!
//            Stream<String> source = targetStream.filter(x -> !x.equals(";"));
//            System.out.println(source.collect(Collectors.toList()).toString());
//            for(int i=1;i<=42;i++){
//                String temp = String.valueOf(i);
//                long counter = source.filter(x ->(x.equals(temp)))
//                        .count();
//                map.put(i, (int)counter);
//                System.out.println(i+" wystąpiła "+counter+" razy.");
//            }
//
//            System.out.println("liczby w kolejności od najrzadszych do najczęstszych:");
//            sortedMap=map.entrySet()
//                    .stream()
//                    .sorted(Map.Entry.comparingByValue())
//                    .collect(Collectors.toMap(
//                            Map.Entry::getKey,
//                            Map.Entry::getValue,
//                            (oldValue,newValue)->oldValue, LinkedHashMap::new));
//            Set<Integer> keys = sortedMap.keySet(); //zbiór kluczy
//            for (Integer key : keys) {      //iterowanie po kluczach
//                System.out.println(key + " wystąpiła "+ sortedMap.get(key)+" razy.");
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
