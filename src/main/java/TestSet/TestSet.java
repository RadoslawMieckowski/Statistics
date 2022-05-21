package TestSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TestSet {
    public static void main(String[] args) {
        int searchedTable[]=new int[6];
        int tableToCompare[]=new int[6];
        try {
            Scanner file =new Scanner(new File("src/posortowane losowania.txt"));
            Scanner in=new Scanner(System.in);
            System.out.println("Wczytaj zestaw 6 liczb (niekoniecznie w kolejności).");
            for (int i=0;i<6;i++) {
                searchedTable[i] = in.nextInt();
            }
            Arrays.sort(searchedTable);
            int rowCounter=0;
                boolean failure=true;
                while (file.hasNextLine()){
                    rowCounter++;
                    for (int i=0;i<6;i++){
                        tableToCompare[i]=file.nextInt();
                    }
                    Arrays.sort(tableToCompare);
                    boolean success=Arrays.equals(searchedTable,tableToCompare);
                    if(success){
                        System.out.println("Zestaw liczb: "+Arrays.toString(searchedTable)+
                                " znaleziony w linijce: "+rowCounter);
                        success=false;
                        failure=false;
                    }
                }
                if(failure) System.out.println("Zestaw: "+Arrays.toString(searchedTable)+
                        " nigdy wcześniej nie wystąpił.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
