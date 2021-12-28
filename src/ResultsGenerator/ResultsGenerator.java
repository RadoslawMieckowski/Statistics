package ResultsGenerator;

import java.util.Arrays;
import java.util.Scanner;

public class ResultsGenerator {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int table[]=new int[6];
        System.out.println("Wprowadź liczby: ");
        for (int i=0;i<6;i++){
            table[i]=in.nextInt();
        }
        Arrays.sort(table);
        System.out.println("Wprowadzony zestaw: "+Arrays.toString(table));
        do {
            for (int i=0;i<6;i++){
                table[i]= (int) (Math.random()*(4)+table[i]-2);
            }
        }while(table[0]== table[1]||
                table[1]== table[2]||
                table[2]== table[3]||
                table[3]== table[4]||
                table[4]== table[5]);
        System.out.println("wylosowany zestaw: "+Arrays.toString(table));

    }
}
