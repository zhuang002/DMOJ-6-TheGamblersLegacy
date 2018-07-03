/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thegamblerslegacy;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class TheGamblersLegacy {

    static Scanner sc=new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n=sc.nextInt();
        for (int i=0;i<n;i++) {
            calculate(sc.nextInt());
        }
    }

    private static void calculate(int nextInt) {
        ArrayList<Integer> changes=new ArrayList();
        int value=nextInt;
        int index=changesFind(changes,value);
        changes.add(value);
        while (index<0) {  
            value=getNext(value);
            index=changesFind(changes,value);
            changes.add(value);
        }
        if (index==changes.size()-2) {
            System.out.printf("Equilibrium: Bob's investment becomes $%d after %d second(s)!\r\n",value,index);
        } else {
            System.out.printf("Instability: Loop of length %d encountered after %d second(s)!\r\n", 
                    changes.size()-index-1,index);
        }
        
    }

    private static int changesFind(ArrayList<Integer> changes,int value) {
        for (int i=changes.size()-1;i>=0;i--){
            if (changes.get(i)==value)
                return i;
        }
        return -1;
    }

    private static int getNext(int value) {
        int power=((int)Math.log10(value))+1;
        int next=0;
        int rest=value;
        
        while(rest>0) {
            int remainder=rest%10;
            next+=Math.pow(remainder, power);
            rest=rest/10;
        }
        return next;
    }
}
