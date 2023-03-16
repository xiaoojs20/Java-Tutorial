package numarraylist;

import java.util.ArrayList;

public class NumArrayList {
    ArrayList<Integer> numArray = new ArrayList<Integer>();
    ArrayList<Integer> newNumArray = new ArrayList<Integer>();
    public NumArrayList(int[] a){
        for(int i = 0; i < a.length; i++){
            numArray.add(a[i]);
        }
    }

    public ArrayList<Integer> work(){
        for(Object num:numArray){
            if((int)num >= 5000){
                newNumArray.add((int)num);
            }
        }
        return newNumArray;
    }

}
