import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import java.io.*;

public class Login extends JFrame implements GobangConfig {
    public JPanel ljp = new JPanel();
    public int mode;
    public String name_1;
    public String name_2;

    public void initUI(int mode) {
        this.setTitle("Login");
        this.setSize(UIWIDTH, UIHIGHTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setLayout(null);
        this.mode = mode; //0 PVP 1 PVE

        //游戏标题及作者
        JLabel title = new JLabel("Gobang");
        title.setFont(new Font("HGF9X_CNKI", Font.BOLD, 50));
        title.setBounds(540, 200, 300, 100);
        this.add(title);

        JLabel author = new JLabel("肖锦松 2020010563");
        author.setFont(new Font("黑体", Font.BOLD + Font.ITALIC, 15));
        author.setBounds(1050, 650, 200, 80);
        this.add(author);

        JLabel Username_1 = new JLabel("ID 1");
        Username_1.setFont(new Font("HGF9X_CNKI", Font.BOLD, 20));
        Username_1.setBounds(440, 365, 50, 100);
        this.add(Username_1);

        JLabel Username_2 = new JLabel("ID 2");
        Username_2.setFont(new Font("HGF9X_CNKI", Font.BOLD, 20));
        Username_2.setBounds(440, 465, 150, 100);
        this.add(Username_2);

        JTextField Textname_1 = new JTextField();
        Textname_1.setFont(new Font("HGF9X_CNKI", Font.BOLD, 20));
        Textname_1.setBounds(520, 400, 300, 30);
        name_1 = Textname_1.getText();
        this.add(Textname_1);

        if (this.mode == 0) { //PVP
            JTextField Textname_2 = new JTextField();
            Textname_2.setFont(new Font("HGF9X_CNKI", Font.BOLD, 20));
            Textname_2.setBounds(520, 500, 300, 30);
            name_2 = Textname_2.getText();
            this.add(Textname_2);

            JButton buttonLogin = new JButton("Start PVP");
            buttonLogin.setFocusPainted(false);
            buttonLogin.setContentAreaFilled(false);
            buttonLogin.setBounds(600, 600, 150, 40);
            buttonLogin.setFont(new Font("HGF9X_CNKI", Font.BOLD, button_font));
            buttonLogin.setBackground(Color.WHITE);
            this.add(buttonLogin);
            ButtonListener bu = new ButtonListener(this);
            buttonLogin.addActionListener(bu);

            ActionListener listenerStartPVP =
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            name_1 = Textname_1.getText().toString();//获得文本框的内容
                            name_2 = Textname_2.getText().toString();//获得文本框的内容
                            iofunc(name_1 + "\n" + name_2);
                        }
                    };
            buttonLogin.addActionListener(listenerStartPVP);

        } else if (this.mode == 1) { // PVE
            JTextField Textname_2 = new JTextField();
            Textname_2.setFont(new Font("HGF9X_CNKI", Font.BOLD, 20));
            Textname_2.setBounds(520, 500, 300, 30);
            Textname_2.setEditable(false);
            this.add(Textname_2);

            JButton buttonLogin = new JButton("Start PVE");
            buttonLogin.setFocusPainted(false);
            buttonLogin.setContentAreaFilled(false);
            buttonLogin.setBounds(600, 600, 150, 40);
            buttonLogin.setFont(new Font("HGF9X_CNKI", Font.BOLD, button_font));
            buttonLogin.setBackground(Color.WHITE);
            this.add(buttonLogin);
            ButtonListener bu = new ButtonListener(this);
            buttonLogin.addActionListener(bu);

            ActionListener listenerStartPVE =
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            name_1 = Textname_1.getText().toString();//获得文本框的内容
                            iofunc(name_1);
                        }
                    };
            buttonLogin.addActionListener(listenerStartPVE);
        }

        this.getContentPane().setBackground(new Color(253, 230, 224));
        this.setVisible(true);

        this.menuBar();
    }

    //重写重绘方法
    public void paint(Graphics g) {
        super.paint(g);
    }

    public void menuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("选项");
        JMenuItem menuStart = new JMenuItem("开始游戏");
        JMenuItem menuPalse = new JMenuItem("暂停游戏");
        JMenuItem menuRestart = new JMenuItem("重新开始");
        JMenuItem menuExit = new JMenuItem("退出游戏");
        JMenuItem menuOut = new JMenuItem("注销账户");
        menuExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuBar.add(menu);
        menu.add(menuStart);
        menu.add(menuPalse);
        menu.add(menuRestart);
        menu.add(menuOut);
        menu.add(menuExit);

        this.setJMenuBar(menuBar);
    }

    public void iofunc(String id){
        try{
            File file =new File("user.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            //true = append file
            FileWriter fileWritter = new FileWriter(file.getName(),false);
            fileWritter.write(id);
            fileWritter.close();
            System.out.println("IO");

        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
