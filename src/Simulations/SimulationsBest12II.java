package Simulations;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SimulationsBest12II {
    static int statistics[]=new int[7];
    static int previous[]=new int[6];// będzie przechowywała poprzednie losowania
    public static void main(String[] args) {
        try {
            int startLine=3331;
            while(startLine<=6661){ //numer ostatniej lini pliku posortowane losowania, z której program bierze dane

                Scanner dataProvider= new Scanner(new File("src/posortowane losowania.txt"));
                for(int i=1;i<startLine;i++){   //ustawiamy dataProvidera na starcie-1, czyli na 3331-1 linii.
                    dataProvider.nextLine();
                }
                String previousStr[]=dataProvider.nextLine().split("\t");   //wczytujemy poprzednie losowanie
                for (int i=0;i<6;i++){
                    previous[i]=Integer.parseInt(previousStr[i]);   //przepisanie na tab intów
                }
                System.out.println("-------------------");
                System.out.println("start line: "+startLine);
                startLine++;
                String dataToSend;
                StringBuilder strbdr=new StringBuilder("");
                for (int i=0;i<6;i++){
                    strbdr.append(dataProvider.nextInt()+"\t");
                }
                dataProvider.close();

                HashMap<Integer,Integer> map= new HashMap<>(49);
                LinkedHashMap<Integer,Integer> sortedMap;
                Scanner reader;
                int counter;
                //int rowCounter=0;
                for(int i=1;i<=49;i++){     //liczymy występowanie każdej liczby
                    reader =new Scanner(new File("src/Simulations/posortowane losowania połowa.txt"));
                    counter=0;
                    while (reader.hasNextInt()){
                        int temp=reader.nextInt();
                        if(i==temp){
                            counter++;
                        }
                    }
                    map.put(i,counter);
                    reader.close();
                    //System.out.println(i+" wystąpiła "+counter+" razy.");
                }
                //System.out.println("liczby w kolejności od najrzadszych do najczęstszych:");
                sortedMap=map.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue,newValue)->oldValue, LinkedHashMap::new));
                Set<Integer> keys = sortedMap.keySet(); //zbiór kluczy
              /*  for (Integer key : keys) {      iterowanie po kluczach
                    System.out.println(key + " wystąpiła "+ sortedMap.get(key)+" razy.");
                }*/
                //int mockTable[]=new int[12];
                Integer mockTable[]=Arrays.copyOfRange(keys.toArray(new Integer[0]),0,49); //w wynikach czwartej 12 tki był błąd. from=1, co jest błędem, ale nie wpływało na wynik
                System.out.println("MockTable: "+Arrays.toString(mockTable));
                Integer[] PreliminarySelectedNumbers =Arrays.copyOfRange(mockTable,24,36);//36,48
                System.out.println("Preliminarily Selected numbers: "+Arrays.toString(PreliminarySelectedNumbers));

                int nextPopularNumberPointer =48;   //wskazanie następnej najczęstszej liczby
                for (int i=0;i<6;i++){
                    for (int j=0;j<12;j++){
                        if(PreliminarySelectedNumbers[j]==previous[i]){  //jeśli powtarzają się z poprzedniego losowania,
                            System.out.println("Powtórzona liczba: "+ PreliminarySelectedNumbers[j]);
                            PreliminarySelectedNumbers[j] = mockTable[nextPopularNumberPointer];            //to odpowiednio podmień
                            nextPopularNumberPointer--;
                            break;
                        }
                    }
                }

                System.out.println("Wybrany zestaw liczb: "+Arrays.toString(PreliminarySelectedNumbers));


                PrintWriter dataReceiver =new PrintWriter(new FileWriter("src/Simulations/posortowane losowania połowa.txt",true));
                dataToSend= strbdr.toString();
                System.out.println("Dopisanie do pliku: "+dataToSend);  //tworzenie zapisu do dataReceiver'a.
                dataReceiver.println(dataToSend);
                dataReceiver.close();

                String dataToSendTable[]=dataToSend.split("\t");     //tworzenie tablicy do porównania wyników
                int currentLotteryDraw[]=new int[6];
                for (int i=0;i<6;i++){
                    currentLotteryDraw[i]=Integer.parseInt(dataToSendTable[i]);
                }
                int hitNumbersCounter=0;
                for (int i=0;i<6;i++){
                    for (int j=0;j<12;j++){
                        if(PreliminarySelectedNumbers[j]==currentLotteryDraw[i]){  //liczenie trafionych liczb
                            hitNumbersCounter++;
                            break;
                        }
                    }
                }
                switch (hitNumbersCounter){
                    case 0:{
                        System.out.println("Niestety, kulą w płot...");
                        statistics[0]++;
                        break;
                    }
                    case 1:{
                        System.out.println("jedynka");
                        statistics[1]++;
                        break;
                    }
                    case 2:{
                        System.out.println("dwójka");
                        statistics[2]++;
                        break;
                    }
                    case 3:{
                        System.out.println("trójka");
                        statistics[3]++;
                        break;
                    }
                    case 4:{
                        System.out.println("czwórka");
                        statistics[4]++;
                        break;
                    }
                    case 5:{
                        System.out.println("piątka");
                        statistics[5]++;
                        break;
                    }
                    case 6:{
                        System.out.println("szóstka!!! Zostałeś milionerem!");
                        statistics[6]++;
                        break;
                    }
                }
                System.out.println("Statystyka: "+Arrays.toString(statistics));
                System.out.println("-------------------");
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
