package TestSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Formatter {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner source=new Scanner(new File("src/TestSet/najczęstszePiątki.txt"));
         String table[];
        PrintWriter out=new PrintWriter("src/TestSet/najczęstszePiątkiSformatowane.txt");
        while (source.hasNextLine()){
            table=source.nextLine().replace(" | ","\t").split("\t");
            //System.out.println(Arrays.toString(table));
            StringBuilder lineToSend=new StringBuilder("");
            for (int i=0;i<4;i++){
                lineToSend.append(table[i]+"\t");
            }
            System.out.println(lineToSend+"11");
            out.println(lineToSend+"11");
        }
        out.close();
        source.close();
    }

}
