package numtreeset;

import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		int[] a = new int[] {12, 83, 83, 12, 44, 23, 12};
		NumTreeSet s = new NumTreeSet(a);
		try {
			if (s.work() == 4) {
				System.out.println("Correct!");
			} else {
				System.out.println("Wrong!");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
