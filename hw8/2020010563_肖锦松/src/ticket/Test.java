package ticket;

public class Test {

    static TicketPool pl;
    public static void main(String[] args) {
//        pl = new Ticket(0);
//        pl = new TicketPool()
//        for(int i = 0; i < 100; ++i) {
//            System.out.println(String.format("Test %d: %s", i, run_test(3000, 200) ? "Correct!" : "Wrong!"));
//        }
        int N = 0;
        System.out.println(String.format("Test %d: %s", ++N, run_test(30, 1) ? "Correct!" : "Wrong!"));
        System.out.println(String.format("Test %d: %s", ++N, run_test(300, 2) ? "Correct!" : "Wrong!"));
        System.out.println(String.format("Test %d: %s", ++N, run_test(500, 30) ? "Correct!" : "Wrong!"));
        System.out.println(String.format("Test %d: %s", ++N, run_test(3000, 50) ? "Correct!" : "Wrong!"));
        System.out.println(String.format("Test %d: %s", ++N, run_test(3000, 100) ? "Correct!" : "Wrong!"));
    }

    boolean check(int check_N) {
        for(int i = 0; i < check_N; ++i) {
            if(run_test(3000, 200) == false)
                return false;
        }
        return true;
    }

    static boolean run_test(int tot_tickets_max, int tot_cust_max) {
        int NTtickets = (int)(Math.random() * tot_tickets_max);
//        Ticket.tickets = NTtickets;
        TicketPool pl = new TicketPool(NTtickets);
        int NCust = Math.max(1, (int)(Math.random() * tot_cust_max));
        Ticket[] custs = new Ticket[NCust];
//        [0~1] z 0.5~1.5z -> (0~0.5)+1 z
        double avg_tickets = (double)NTtickets / (double)NCust;
        int tot_req = 0;
        for (int i = 0; i < NCust; ++i) {
            int temp = (int)Math.round(((Math.random() / 2.0 + 1) * avg_tickets));
            custs[i] = new Ticket(pl, temp);
//            custs[i].setReq(temp);
            tot_req += temp;
        }

        for(int i = 0; i < NCust; ++i)
            custs[i].start();
        for(int i = 0; i < NCust; ++i) {
            try {
                custs[i].join();
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }
        }

        int actual_got = 0;

        for(int i = 0; i < NCust; ++i) {
            actual_got += custs[i].getObtained();
        }

        if (tot_req <= NTtickets) {
//            System.out.println("situation 1");
            return actual_got == tot_req && pl.getRest() == (NTtickets - tot_req);
        }
        else {
//            System.out.println("situation 2");
            return actual_got == NTtickets && pl.getRest() == 0;
        }
    }
}
