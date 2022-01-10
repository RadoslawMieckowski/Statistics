package CounterOfNumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestPrintSets {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("src/CounterOfNumbers/piątki.txt"));
        while (file.hasNextLine()) {
            int rowCounter = 0;
            int searchedTable[] = new int[5];
            String searchedTableString[]=file.nextLine().split("\t");
            //System.out.println(Arrays.toString(searchedTableString));
            for (int i=0;i<5;i++){
                searchedTable[i]=Integer.valueOf(searchedTableString[i]);
            }
            Scanner file2 = new Scanner(new File("src/posortowane losowania.txt"));
            while (file2.hasNextLine()) {
                rowCounter++;
               // int tableToCompare[] = new int[6];
                List<String> list = new ArrayList<>(6);
                String tableToCompareString[] =file2.nextLine().split("\t");
                for (int i = 0; i < 6; i++) {
                   // tableToCompare[i] = Integer.parseInt(tableToCompareString[i]);
                    list.add(String.valueOf(tableToCompareString[i]));
                }
                boolean success = false;
                int counter = 0;
                for (int i = 0; i < 5; i++) {
                    if (list.contains(String.valueOf(searchedTable[i]))) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    success = true;
                }

                if (success) {
                    System.out.println("Zestaw liczb: " + Arrays.toString(searchedTable) +
                            " znaleziony w linijce: " + rowCounter + "\t" + Arrays.toString(tableToCompareString));
                }
            }
            file2.close();
            System.out.println();
        }
        file.close();
    }
}
