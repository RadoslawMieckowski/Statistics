package lotto_plus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Parser {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "src/lotto_plus.txt";
        String pathParsed = "src/lotto_plus_parsed.txt";
        File file = new File(path);
        Scanner in =new Scanner(file);
        PrintWriter out =new PrintWriter(pathParsed);
        while (in.hasNextLine()){
            String line = in.nextLine().replace(';', '\t');
            out.println(line);
        }
        in.close();
        out.close();
    }
}
