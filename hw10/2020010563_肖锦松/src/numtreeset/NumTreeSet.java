package numtreeset;

import java.util.TreeSet;

public class NumTreeSet {
    TreeSet nums = new TreeSet();

    public NumTreeSet(int[] a){
        for(int num:a){
            nums.add(num);
        }
    }

    public int work(){
//        for(Object num:nums){
//
//        }
        return nums.size();
    }
}
