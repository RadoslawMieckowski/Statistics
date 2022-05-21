package TestSet;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int zestaw[]=new int[12];
        int start=1;
        while (start!=39){
            for(int i=0;i<12;i++){
                zestaw[i]=start+i;
            }
            System.out.println(Arrays.toString(zestaw));
            start++;
        }
    }
}
