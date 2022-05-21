package Simulations;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class PreviousPlusSixBest {

        static int statistics[]=new int[7];

        public static void main(String[] args) {
            try {
                int startLine=3331;
                while(startLine<=6661){ //numer ostatniej lini pliku posortowane losowania, z której program bierze dane

                    Scanner dataProvider= new Scanner(new File("src/posortowane losowania.txt"));
                    for(int i=1;i<=startLine;i++){   //ustawiamy dataProvidera na starcie, czyli na 3331 linii.
                        dataProvider.nextLine();
                    }
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
                    for(int i=1;i<=49;i++){
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

                    Scanner scannerForPrevious=new Scanner(new File("src/Simulations/posortowane losowania połowa.txt"));
                    int beforeStartLine=startLine-1;
                    while (beforeStartLine<=6660){
                        scannerForPrevious.nextLine();      //ustawienie skanera linię wcześniej
                        beforeStartLine++;
                    }
                    String previousTableStr[]=scannerForPrevious.nextLine().split("\t");    //pobranie linii
                    scannerForPrevious.close();

                    for(String key:previousTableStr){
                        sortedMap.remove(Integer.parseInt(key));
                    }

                    Set<Integer> keys = sortedMap.keySet(); //zbiór kluczy
                   // System.out.println("Klucze: "+Arrays.toString(keys.toArray()));
              /*  for (Integer key : keys) {      iterowanie po kluczach
                    System.out.println(key + " wystąpiła "+ sortedMap.get(key)+" razy.");
                }*/
                    //int mockTable[]=new int[12];
                    Integer mockTable[]=Arrays.copyOfRange(keys.toArray(new Integer[0]),37,43);//37,49
                    int selectedNumbers[]=new int[12];

                    for (int i=0;i<6;i++){
                        selectedNumbers[i]=mockTable[i].intValue();
                    }

                    for (int i=6;i<12;i++){
                        selectedNumbers[i]=Integer.parseInt(previousTableStr[i-6]); //dopełnienie do 12 liczb podprzednim losowaniem
                    }

                    System.out.println("-------------------");
                    System.out.println("Wybrany zestaw liczb: "+Arrays.toString(selectedNumbers));


                    PrintWriter dataReceiver =new PrintWriter(new FileWriter("src/Simulations/posortowane losowania połowa.txt",true));
                    dataToSend= strbdr.toString();
                    System.out.println("Dopisanie do pliku: "+dataToSend);
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
                            if(selectedNumbers[j]==currentLotteryDraw[i]){  //liczenie trafionych liczb
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

