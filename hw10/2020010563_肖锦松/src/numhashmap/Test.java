package numhashmap;

public class Test {
	public static void main(String[] args) {
		NumHashMap h = new NumHashMap();
		try {
			if (h.decrypt("Foxxy Uyrxn").equals("Hello World")) {
				System.out.println("Correct!");
			} else {
				System.out.println("Wrong!");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
