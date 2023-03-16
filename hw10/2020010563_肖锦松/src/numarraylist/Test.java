package numarraylist;

import java.util.ArrayList;

public class Test {
	
	public static void main(String args[]) {
		int[] a = new int[] {1512, 8013, 23, 5514};
		NumArrayList l = new NumArrayList(a);
		ArrayList<Integer> res = l.work();
		try {
			if (res.get(0) == 8013 && res.get(1) == 5514) {
				System.out.println("Correct!");
			} else {
				System.out.println("Wrong!");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
