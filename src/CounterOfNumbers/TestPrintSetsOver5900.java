package CounterOfNumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class TestPrintSetsOver5900 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("src/CounterOfNumbers/piątki.txt"));
        PrintWriter out=new PrintWriter("src/CounterOfNumbers/daneDoWykresu1.txt");
        while (file.hasNextLine()) {
            int rowCounter = 0;
            String searchedTableString[]=file.nextLine().split("\t");
            Scanner file2 = new Scanner(new File("src/posortowane losowania.txt"));
            Map<Integer,String> map= new TreeMap<>();
            while (file2.hasNextLine()) {
                rowCounter++;
                List<String> list = new ArrayList<>(6);
                String tableToCompareString[] =file2.nextLine().split("\t");
                for (int i = 0; i < 6; i++) {
                    list.add((tableToCompareString[i]));
                }
                boolean success = false;
                int counter = 0;
                for (int i = 0; i < 5; i++) {
                    if (list.contains((searchedTableString[i]))) {
                        counter++;
                    }
                }
                if (counter == 5) {
                    success = true;
                }

                if (success) {
                    map.put(rowCounter,Arrays.toString(tableToCompareString));
                    for (int key:map.keySet()){
                        if (key>=5900){
                            StringBuilder strbdr=new StringBuilder("");
                            for (int result: map.keySet()){
                                System.out.println("Zestaw liczb: " + Arrays.toString(searchedTableString) +
                                        " znaleziony w linijce: " + result + "\t" + map.get(result));
                                strbdr.append(result+"\t");
                            }
                            out.println(strbdr);
                            System.out.println();
                            System.out.println();
                            break;
                        }
                    }
                }
            }
            file2.close();
        }
        file.close();
        out.close();
    }
}
