package lotto_plus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Parser {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "src/miniLotto/wyniki-minilotto-sortowane.csv";
        String pathParsed = "src/miniLotto/wyniki-minilotto-sortowane-parsed.csv";
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
