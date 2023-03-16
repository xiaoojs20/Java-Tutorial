package date;

public class Date {
    String print_date;

    Date(String data_str) {
        String myyear, mymonth, myday;
        String[] split_date = data_str.split(" ");
        // 处理月
        if (split_date[0].equals("Jan.")) {
            mymonth = "01";
        } else if (split_date[0].equals("Feb.")) {
            mymonth = "02";
        } else if (split_date[0].equals("Mar.")) {
            mymonth = "03";
        } else if (split_date[0].equals("Apr.")) {
            mymonth = "04";
        } else if (split_date[0].equals("May.")) {
            mymonth = "05";
        } else if (split_date[0].equals("Jun.")) {
            mymonth = "06";
        } else if (split_date[0].equals("Jul.")) {
            mymonth = "07";
        } else if (split_date[0].equals("Aug.")) {
            mymonth = "08";
        } else if (split_date[0].equals("Sept.")) {
            mymonth = "09";
        } else if (split_date[0].equals("Oct.")) {
            mymonth = "10";
        } else if (split_date[0].equals("Nov.")) {
            mymonth = "11";
        } else if (split_date[0].equals("Dec.")) {
            mymonth = "12";
        } else {
            mymonth = "00";
        }
        // 处理日 注意补零
        if (split_date[1].length() == 2) {
            myday = "0" + split_date[1].substring(0, 1);
        } else if (split_date[1].length() == 3) {
            myday = split_date[1].substring(0, 2);
        } else {
            myday = "00";
        }
        // 处理年
        myyear = split_date[2];

        this.print_date = myyear + "/" + mymonth + "/" + myday;

    }

    Date(String ip_month, int ip_day, int ip_year) {
        String myyear, mymonth, myday;
        // 处理月
        if (ip_month.equals("Jan.")) {
            mymonth = "01";
        } else if (ip_month.equals("Feb.")) {
            mymonth = "02";
        } else if (ip_month.equals("Mar.")) {
            mymonth = "03";
        } else if (ip_month.equals("Apr.")) {
            mymonth = "04";
        } else if (ip_month.equals("May.")) {
            mymonth = "05";
        } else if (ip_month.equals("Jun.")) {
            mymonth = "06";
        } else if (ip_month.equals("Jul.")) {
            mymonth = "07";
        } else if (ip_month.equals("Aug.")) {
            mymonth = "08";
        } else if (ip_month.equals("Sept.")) {
            mymonth = "09";
        } else if (ip_month.equals("Oct.")) {
            mymonth = "10";
        } else if (ip_month.equals("Nov.")) {
            mymonth = "11";
        } else if (ip_month.equals("Dec.")) {
            mymonth = "12";
        } else {
            mymonth = "00";
        }
        // 处理日
        myday = String.valueOf(ip_day);
        if (myday.length() == 1) {
            myday = "0" + myday;
        }
        // 处理年
        myyear = String.valueOf(ip_year);

        this.print_date = myyear + "/" + mymonth + "/" + myday;
    }

    Date(int ip_year, int ip_month, int ip_day) {
        String myyear, mymonth, myday;
        // 处理年
        myyear = String.valueOf(ip_year);
        // 处理月 注意补零
        mymonth = String.valueOf(ip_month);
        if(mymonth.length() == 1){
            mymonth = "0" + mymonth;
        }
        // 处理日 注意补零
        myday = String.valueOf(ip_day);
        if(myday.length() == 1){
            myday = "0" + myday;
        }

        this.print_date = myyear + "/" + mymonth + "/" + myday;
    }

    public String print() {
        return this.print_date;
    }

}
