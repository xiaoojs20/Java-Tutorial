import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;


public class GobangFrame extends JPanel implements GobangConfig {
    public Graphics g;//定义一支画笔
    public int[][] isAvail = new int[COLUMN][ROW];//定义一个二维数组来储存棋盘的落子情况
    public ArrayList<ChessPosition> ChessPositonList = new ArrayList<ChessPosition>();//保存每一步的落子情况
    public int turn = 0;//等于0时无法下棋
    public int ChooseType;//0表示人人对战，1表示人机对战，默认人人对战
    public int first = 0;//默认play1 先手
    public String title;
    public String AllMessage = "";
    public JPanel jp = new JPanel();
    public JFrame jf = new JFrame();
    public JLabel blackbar;
    public JLabel whitebar;
    public JLabel player2;
    public String name_b; //先手玩家名字
    public String name_w;
    public String record = "record: \n";
    public static HashMap<String, Integer> map = new HashMap<String, Integer>();//设置不同落子情况和相应权值的数组

    static {
        //被堵住
        map.put("01", 25);//眠1连
        map.put("02", 22);//眠1连
        map.put("001", 17);//眠1连
        map.put("002", 12);//眠1连
        map.put("0001", 17);//眠1连
        map.put("0002", 12);//眠1连

        map.put("0102", 25);//眠1连，15
        map.put("0201", 22);//眠1连，10
        map.put("0012", 15);//眠1连，15
        map.put("0021", 10);//眠1连，10
        map.put("01002", 25);//眠1连，15
        map.put("02001", 22);//眠1连，10
        map.put("00102", 17);//眠1连，15
        map.put("00201", 12);//眠1连，10
        map.put("00012", 15);//眠1连，15
        map.put("00021", 10);//眠1连，10

        map.put("01000", 25);//活1连，15
        map.put("02000", 22);//活1连，10
        map.put("00100", 19);//活1连，15
        map.put("00200", 14);//活1连，10
        map.put("00010", 17);//活1连，15
        map.put("00020", 12);//活1连，10
        map.put("00001", 15);//活1连，15
        map.put("00002", 10);//活1连，10

        //被墙堵住
        map.put("0101", 65);//眠2连，40
        map.put("0202", 60);//眠2连，30
        map.put("0110", 80);//眠2连，40
        map.put("0220", 76);//眠2连，30
        map.put("011", 80);//眠2连，40
        map.put("022", 76);//眠2连，30
        map.put("0011", 65);//眠2连，40
        map.put("0022", 60);//眠2连，30

        map.put("01012", 65);//眠2连，40
        map.put("02021", 60);//眠2连，30
        map.put("01102", 80);//眠2连，40
        map.put("02201", 76);//眠2连，30
        map.put("01120", 80);//眠2连，40
        map.put("02210", 76);//眠2连，30
        map.put("00112", 65);//眠2连，40
        map.put("00221", 60);//眠2连，30

        map.put("01100", 80);//活2连，40
        map.put("02200", 76);//活2连，30
        map.put("01010", 75);//活2连，40
        map.put("02020", 70);//活2连，30
        map.put("00110", 75);//活2连，40
        map.put("00220", 70);//活2连，30
        map.put("00011", 75);//活2连，40
        map.put("00022", 70);//活2连，30

        //被堵住
        map.put("0111", 150);//眠3连，100
        map.put("0222", 140);//眠3连，80

        map.put("01112", 150);//眠3连，100
        map.put("02221", 140);//眠3连，80

        map.put("01110", 1100);//活3连
        map.put("02220", 1050);//活3连
        map.put("01101", 1000);//活3连，130
        map.put("02202", 800);//活3连，110
        map.put("01011", 1000);//活3连，130
        map.put("02022", 800);//活3连，110

        map.put("01111", 3000);//4连，300
        map.put("02222", 3500);//4连，280
    }

    public int[][] weightArray = new int[COLUMN][ROW];//定义一个二维数组，保存各个点的权值

    public void initUI(int mode, String name_b, String name_w) {
        this.ChooseType = mode;
        this.name_b = name_b;
        this.name_w = name_w;
        this.readTxt("user.txt");
        //初始化一个界面,并设置标题大小等属性
        System.out.println(ChooseType);

        if (mode == 0) {
            title = "Gobang PVP";
        } else if (mode == 1) {
            title = "Gobang PVE";
        }
        jf.setTitle(title);
        jf.setSize(UIWIDTH, UIHIGHTH);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(3);
        jf.setLayout(new BorderLayout());
        jf.add(this, BorderLayout.CENTER);//添加到框架布局的中间部分

        //实现右边的JPanel容器界面
        jp.setPreferredSize(dim_info);//设置JPanel的大小
        jp.setBackground(Color.LIGHT_GRAY);//设置右边的界面颜色为白色
        jf.add(jp, BorderLayout.EAST);//添加到框架布局的东边部分
        jp.setLayout(new FlowLayout());//设置JPanel为流式布局
        jp.setBackground(new Color(153, 204, 238));

        //设置玩家头像
        PLAYER1.setImage(PLAYER1.getImage().getScaledInstance(dim_icon.width, dim_icon.height, Image.SCALE_DEFAULT));
        JLabel player1 = new JLabel(PLAYER1);
        player1.setPreferredSize(dim_icon);
        jp.add(player1);

        if (mode == 0) {
            PLAYER2.setImage(PLAYER2.getImage().getScaledInstance(dim_icon.width, dim_icon.height, Image.SCALE_DEFAULT));
            JLabel player2 = new JLabel(PLAYER2);
            player2.setPreferredSize(dim_icon);
            jp.add(player2);
        } else if (mode == 1) {
            COMPUTER.setImage(COMPUTER.getImage().getScaledInstance(dim_icon.width, dim_icon.height, Image.SCALE_DEFAULT));
            JLabel player2 = new JLabel(COMPUTER);
            player2.setPreferredSize(dim_icon);
            jp.add(player2);
        }

        JButton buttonP1 = new JButton(this.name_b);
        buttonP1.setFocusPainted(false);
        buttonP1.setContentAreaFilled(false);
        buttonP1.setBorderPainted(false);
        buttonP1.setBorder(null);//除去边框
        buttonP1.setFont(new Font("HGF9X_CNKI", Font.BOLD, button_font));
        buttonP1.setBackground(Color.WHITE);
        buttonP1.setPreferredSize(dim_button);
        jp.add(buttonP1);

        JButton buttonP2 = new JButton(this.name_w);
        buttonP2.setFocusPainted(false);
        buttonP2.setContentAreaFilled(false);
        buttonP2.setBorderPainted(false);
        buttonP2.setBorder(null);//除去边框
        buttonP2.setFont(new Font("HGF9X_CNKI", Font.BOLD, button_font));
        buttonP2.setBackground(Color.WHITE);
        buttonP2.setPreferredSize(dim_button);
        jp.add(buttonP2);

        //设置黑白条 选边
        BLACKBAR.setImage(BLACKBAR.getImage().getScaledInstance(dim_bar.width, dim_bar.height, Image.SCALE_DEFAULT));
        blackbar = new JLabel(BLACKBAR);
        blackbar.setPreferredSize(dim_bar);
        jp.add(blackbar);

        WHITEBAR.setImage(WHITEBAR.getImage().getScaledInstance(dim_bar.width, dim_bar.height, Image.SCALE_DEFAULT));
        whitebar = new JLabel(WHITEBAR);
        whitebar.setPreferredSize(dim_bar);
        jp.add(whitebar);

        //分割bar
        JLabel divbar = new JLabel("");
        divbar.setPreferredSize(dim_div);
        jp.add(divbar);

        JButton buttonStart = new JButton("NEW GAME");
        buttonStart.setFocusPainted(false);
        buttonStart.setContentAreaFilled(false);
        buttonStart.setFont(new Font("HGF9X_CNKI", Font.BOLD, button_font));
        buttonStart.setBackground(Color.WHITE);
        buttonStart.setPreferredSize(dim_button);
        jp.add(buttonStart);

        JButton buttonRenshu = new JButton("GIVE UP");
        buttonRenshu.setFocusPainted(false);
        buttonRenshu.setContentAreaFilled(false);
        buttonRenshu.setFont(new Font("HGF9X_CNKI", Font.BOLD, button_font));
        buttonRenshu.setBackground(Color.WHITE);
        buttonRenshu.setPreferredSize(dim_button);
        jp.add(buttonRenshu);

        JButton buttonHuiqi = new JButton("UNDO");
        buttonHuiqi.setFocusPainted(false);
        buttonHuiqi.setContentAreaFilled(false);
        buttonHuiqi.setFont(new Font("HGF9X_CNKI", Font.BOLD, button_font));
        buttonHuiqi.setBackground(Color.WHITE);
        buttonHuiqi.setPreferredSize(dim_button);
        jp.add(buttonHuiqi);

        JButton buttonQiuhe = new JButton("TIE"); //求和
        buttonQiuhe.setFocusPainted(false);
        buttonQiuhe.setContentAreaFilled(false);
        buttonQiuhe.setFont(new Font("HGF9X_CNKI", Font.BOLD, button_font));
        buttonQiuhe.setBackground(Color.WHITE);
        buttonQiuhe.setPreferredSize(dim_button);
        jp.add(buttonQiuhe);

        JButton buttonPause = new JButton("PAUSE"); //暂停
        buttonPause.setFocusPainted(false);
        buttonPause.setContentAreaFilled(false);
        buttonPause.setFont(new Font("HGF9X_CNKI", Font.BOLD, button_font));
        buttonPause.setBackground(Color.WHITE);
        buttonPause.setPreferredSize(dim_button);
        jp.add(buttonPause);

        JButton buttonRecord = new JButton("RECORD"); //暂停
        buttonRecord.setFocusPainted(false);
        buttonRecord.setContentAreaFilled(false);
        buttonRecord.setFont(new Font("HGF9X_CNKI", Font.BOLD, button_font));
        buttonRecord.setBackground(Color.WHITE);
        buttonRecord.setPreferredSize(dim_button);
        jp.add(buttonRecord);

        JButton buttonOut = new JButton("LOGOUT");  //注销
        buttonOut.setFocusPainted(false);
        buttonOut.setContentAreaFilled(false);
        buttonOut.setFont(new Font("HGF9X_CNKI", Font.BOLD, button_font));
        buttonOut.setBackground(Color.WHITE);
        buttonOut.setPreferredSize(dim_button);
        jp.add(buttonOut);

        JButton buttonExit = new JButton("EXIT");  //退出
        buttonExit.setFocusPainted(false);
        buttonExit.setContentAreaFilled(false);
        buttonExit.setFont(new Font("HGF9X_CNKI", Font.BOLD, button_font));
        buttonExit.setBackground(Color.WHITE);
        buttonExit.setPreferredSize(dim_button);
        jp.add(buttonExit);

        //设置选项按钮
        String[] boxname = {"PVP", "PVE"};
        JComboBox box = new JComboBox(boxname);
        box.setPreferredSize(dim_button);
//        jp.add(box);
        ButtonListener butListen = new ButtonListener(this, box);
        box.addActionListener(butListen);

        //对每一个按钮都添加状态事件的监听处理机制
        buttonStart.addActionListener(butListen);
        buttonRenshu.addActionListener(butListen);
        buttonHuiqi.addActionListener(butListen);
        buttonQiuhe.addActionListener(butListen);
        buttonExit.addActionListener(butListen);
        buttonOut.addActionListener(butListen);
        buttonPause.addActionListener(butListen);

        ActionListener listenerRecord =
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        showTxt("record.txt");
                        PopUp("落子记录", record);
                        System.out.println(record);
                    }
                };
        buttonRecord.addActionListener(listenerRecord);

        FrameListener fl = new FrameListener();
        fl.setGraphics(this);//获取画笔对象
        this.addMouseListener(fl);

        this.chatArea();
        jf.setVisible(true);

    }

    //想设计一个聊天功能
    public void chatArea() {
        JTextPane chatTextField = new JTextPane();
        chatTextField.setFont(new Font("黑体", Font.PLAIN, 14));
        chatTextField.setBounds(700, 260, 360, 160);
        chatTextField.setEditable(false);

        //滚动条
        JScrollPane scroll = new JScrollPane(chatTextField);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        chatTextField.setCaretPosition(chatTextField.getText().length());//处于最后一行
        chatTextField.setCaretPosition(chatTextField.getStyledDocument().getLength());  //实现垂直滚动条自动下滑到最低端
        chatTextField.setPreferredSize(dim_chat);
//        jp.add(scroll);
        jp.add(chatTextField);

        JTextArea inputTextField = new JTextArea();
        inputTextField.setFont(new Font("黑体", Font.PLAIN, 14));
        inputTextField.setWrapStyleWord(true);
        inputTextField.setEditable(true);
        inputTextField.setPreferredSize(dim_input);
        jp.add(inputTextField);

        JButton buttonSend = new JButton("SEND");
        buttonSend.setFocusPainted(false);
        buttonSend.setContentAreaFilled(false);
        buttonSend.setFont(new Font("HGF9X_CNKI", Font.BOLD, button_font));
        buttonSend.setPreferredSize(dim_button);
        jp.add(buttonSend);

        ActionListener listenerSendMessage =
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String newMessage = inputTextField.getText().toString();//获得文本框的内容
                        AllMessage += name_b + ": " + newMessage + "\n";
                        chatTextField.setText(AllMessage);
                        inputTextField.setText("");//清空输入
                        javax.swing.text.Document doc = chatTextField.getDocument();
                        chatTextField.setCaretPosition(doc.getLength());
                    }
                };
        buttonSend.addActionListener(listenerSendMessage);

        JComboBox<String> boxSendQuikly;
        final String[] strQuickMessage = {"...", "快点啊，等的你花都谢了。", "你是MM还是GG啊？", "牛啊牛啊！"};
        boxSendQuikly = new JComboBox<String>(strQuickMessage);
        boxSendQuikly.setSelectedIndex(0);
//        boxSendQuikly.setBounds(700, 480, 130, 28);
        jp.add(boxSendQuikly);

        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = boxSendQuikly.getSelectedItem().toString();
                AllMessage += name_b + ": " + s + "\n";
                chatTextField.setText(AllMessage);
                javax.swing.text.Document doc = chatTextField.getDocument();
                chatTextField.setCaretPosition(doc.getLength());
            }
        };
        boxSendQuikly.addActionListener(actionListener);
    }

    public void PopUp(String top, String result) {
        JOptionPane jo = new JOptionPane();
        jo.showMessageDialog(null, result, top, JOptionPane.PLAIN_MESSAGE);
    }

    //重写重绘方法
    public void paint(Graphics g) {
        super.paint(g);//画出白框
        //添加背景图片
        g.drawImage(BOARD, 0, 0, this.getWidth(), this.getHeight(), this);

        //重绘出棋盘
        g.setColor(Color.black);
        for (int i = 0; i < ROW; i++) {
            g.drawLine(X, Y + SIZE * i, X + SIZE * (COLUMN - 1), Y + SIZE * i);
        }
        for (int j = 0; j < COLUMN; j++) {
            g.drawLine(X + SIZE * j, Y, X + SIZE * j, Y + SIZE * (ROW - 1));
        }

        //重绘出棋子
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (isAvail[i][j] == 1) {
                    int countx = SIZE * j + SIZE / 2;
                    int county = SIZE * i + SIZE / 2;
                    g.drawImage(BLACKCHESS, countx - SIZE + X, county - SIZE / 2, SIZE, SIZE, null);
                } else if (isAvail[i][j] == 2) {
                    int countx = SIZE * j + SIZE / 2;
                    int county = SIZE * i + SIZE / 2;
                    g.drawImage(WHITECHESS, countx - SIZE + X, county - SIZE / 2, SIZE, SIZE, null);
                }
            }
        }
    }

    public void readTxt(String path){
        try {
            String encoding="GBK";
            File file=new File(path);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                this.name_b = bufferedReader.readLine();

                String lineTxt = "";
                while((lineTxt = bufferedReader.readLine()) != null){
                    this.name_w = lineTxt;
                }
                System.out.println( this.name_b);
                System.out.println( this.name_w);

                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }

    public void showTxt(String path){
        try {
            String encoding="GBK";
            File file=new File(path);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = "";
                while((lineTxt = bufferedReader.readLine()) != null){
                    record += lineTxt+"\n";
                    System.out.println(record);
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }
}
