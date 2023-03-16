package complex;

public class Test {
	public static void main(String[] args) {
		Complex c = new Complex(1, 1);
		String ans = c.print();
//		System.out.println(c.print());
		System.out.printf("output: %s , %s\n", ans, ans.equals("1.000+1.000i") ? "Correct" : "Wrong");
		
		c.add(new Complex(2, 3));
		ans = c.print();
		System.out.printf("output: %s , %s\n", ans, ans.equals("3.000+4.000i") ? "Correct" : "Wrong");

//		System.out.println(c.print());
//		System.out.println(c.realPart == 3 && c.imaginaryPart == 4 ? "Correct!" : "Wrong!");
//		System.out.println("");
		
		c.sub(new Complex(4, 0.5));
		ans = c.print();
		System.out.printf("output: %s , %s\n", ans, ans.equals("-1.000+3.500i") ? "Correct" : "Wrong");

		c.add(new Complex(2, -1.5));
		ans = c.print();
		System.out.printf("output: %s , %s\n", ans, ans.equals("1.000+2.000i") ? "Correct" : "Wrong");

		c.multi(new Complex(3, 2));
		ans = c.print();
		System.out.printf("output: %s , %s\n", ans, ans.equals("-1.000+8.000i") ? "Correct" : "Wrong");

		c.div(new Complex(3, 2));
		ans = c.print();
		System.out.printf("output: %s , %s\n", ans, ans.equals("1.000+2.000i") ? "Correct" : "Wrong");
//		System.out.println(c.print());
//		System.out.println(c.realPart == -1 && c.imaginaryPart == 3.5 ? "Correct!" : "Wrong!");
	}
}
