package miniLotto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TestPrintSets {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("src/miniLotto/czwórki od dwóch wystąpień.txt"));
       // PrintWriter out=new PrintWriter("src/CounterOfNumbers/WszystkieDaneDoWykresu.txt");
        while (file.hasNextLine()) {
            int rowCounter = 0;
            String searchedTableString[]=file.nextLine().split("\t");
            Scanner file2 = new Scanner(new File("src/miniLotto/wyniki-minilotto-sortowane-parsed.csv"));
            while (file2.hasNextLine()) {
                rowCounter++;
                List<String> list = new ArrayList<>(5);
                String tableToCompareString[] =file2.nextLine().split("\t");
                for (int i = 0; i < 5; i++) {
                    list.add((tableToCompareString[i]));
                }
                boolean success = false;
                int counter = 0;
                for (int i = 0; i < 4; i++) {
                    if (list.contains((searchedTableString[i]))) {
                        counter++;
                    }
                }
                if (counter == 4) {
                    success = true;
                }

                if (success) {
                    StringBuilder strbdr=new StringBuilder("");

                    System.out.println("Zestaw liczb: " + Arrays.toString(searchedTableString) +
                            " znaleziony w linijce: " + rowCounter + "\t" + Arrays.toString(tableToCompareString));
                    strbdr.append(rowCounter+"\t");

                    //out.println(strbdr);
                    System.out.println();
                }
            }
            file2.close();
            System.out.println();
        }
        file.close();
        //out.close();
    }
}
