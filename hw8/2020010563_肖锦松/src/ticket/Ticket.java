package ticket;

public class Ticket extends Thread{
    int need_tickets;
    int get_tickets;
    /*
    构造函数，两个参数，tpl代表目标票池，treq代表需要抢的票数
    */
    public Ticket(TicketPool tpl, int treq){
        need_tickets = treq;
        run(tpl);
    }
    /*
    抢票过程：查询目标漂池剩余的票数
    如果剩余票数大于等于需要的票数，则在目标漂池中抢走需要的票数
    如果剩余票数小于需要的票数，则在目标漂池中抢走剩余票数
    */
    public void run(TicketPool tpl){
        if(tpl.getRest() >= need_tickets){
            get_tickets = need_tickets;
            tpl.reduceRest(need_tickets);
        }
        else if(tpl.getRest() < need_tickets){
            get_tickets = tpl.getRest();
            tpl.reduceRest(tpl.getRest());
        }
    }
    /*
    查询抢票结果：返回抢到的票的数量
    */
    public int getObtained(){
        return get_tickets;
    }
}

