package ticket;

public class TicketPool {
    public static int rest;
//    public int cnt;
    TicketPool(int trest) {
        rest = trest;
//        cnt = 0;
    }

    public int getRest() {
        int trest = rest;
        try {
            Thread.sleep((int) (Math.random() * 20));
        } catch (Exception e) {
            System.out.println(e);
        }
        return trest;
    }

    public void reduceRest(int delta) {
        try {
            Thread.sleep((int) (Math.random() * 20));
        } catch (Exception e) {
            System.out.println(e);
        }
        rest -= delta;
    }
}
