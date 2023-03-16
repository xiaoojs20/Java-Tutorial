package date;

public class Test {
	public static void main(String[] args) {
		Date date0 = new Date("Jan. 14, 2014");
		String ans = date0.print();
		System.out.printf("output: %s, %s\n", ans, ans.equals("2014/01/14") ? "Correct!" : "Wrong!" );
		
		Date date1 = new Date("Oct.", 20, 2017);
 		ans = date1.print();
		System.out.printf("output: %s, %s\n", ans, ans.equals("2017/10/20") ? "Correct!" : "Wrong!" );

		Date date2 = new Date(2018, 3, 31);
		ans = date2.print();
		System.out.printf("output: %s, %s\n", ans, ans.equals("2018/03/31") ? "Correct!" : "Wrong!" );

	}
}
