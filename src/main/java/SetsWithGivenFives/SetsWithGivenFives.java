package SetsWithGivenFives;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetsWithGivenFives {
    public static void main(String[] args) {
        int searchedTable[]=new int[5];
        int tableToCompare[]=new int[6];
        try {
            Scanner file =new Scanner(new File("src/lotto_plus_parsed.txt"));
            Scanner in=new Scanner(System.in);
            System.out.println("Wczytaj zestaw 5 liczb (niekoniecznie w kolejności).");
            for (int i=0;i<5;i++) {
                searchedTable[i] = in.nextInt();
            }
            //Arrays.sort(searchedTable);
            int rowCounter=0;
            boolean failure=true;
            while (file.hasNextLine()){
                rowCounter++;
                List<String> list=new ArrayList<>(6);
                for (int i=0;i<6;i++){
//                    if (file.hasNextInt()) {
                        tableToCompare[i]=file.nextInt();
//                    }
                    list.add(String.valueOf(tableToCompare[i]));
                }
                boolean success=false;
                int counter=0;
                for (int i=0;i<5;i++){
                    if (list.contains(String.valueOf(searchedTable[i]))){
                        counter++;
                    }
                }
                if(counter==5){
                    success=true;
                }

                if(success){
                    System.out.println("Zestaw liczb: "+Arrays.toString(searchedTable)+
                            " znaleziony w linijce: "+rowCounter+"\t"+Arrays.toString(tableToCompare));
                    failure=false;
                }
            }
            if(failure) System.out.println("Zestaw: "+Arrays.toString(searchedTable)+
                    " nigdy wcześniej nie wystąpił.");
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
