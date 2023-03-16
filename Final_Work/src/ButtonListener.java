import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;

public class ButtonListener implements GobangConfig, ActionListener {
    public GobangFrame gf;
    public int mode;
    public JComboBox box;
    public Login loginui;
    public BeforeLogin bfloginui;

    public ButtonListener(BeforeLogin bfloginui) {
        this.bfloginui = bfloginui;
    }

    public ButtonListener(Login loginui) {
        this.loginui = loginui;
    }

    public ButtonListener(GobangFrame gf, JComboBox box) {
        this.gf = gf;//获取左半部分的画板
        this.box = box;//获取可选框对象
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("NEW GAME")) {
            File myObj = new File("record.txt");
            myObj.delete();
//            System.out.println(gf.ChooseType);
            if (gf.ChooseType == 1){
                gf.PopUp("选边", "玩家执黑棋\n机器执白棋");
                gf.name_b = "PLAYER";
                gf.name_w = "ROBOT";
            }
            if (gf.ChooseType == 0) {
                int ran = (int) (Math.random() * (100 - 1) + 1);
                if (ran <= 50) {
                    gf.PopUp("选边", "玩家一执黑棋\n玩家二执白棋");
                    gf.blackbar.setIcon(BLACKBAR);
                    gf.whitebar.setIcon(WHITEBAR);
//                    gf.name_b = "PLAYER 1";
//                    gf.name_w = "PLAYER 2";
                } else {
                    gf.PopUp("选边", "玩家一执白棋\n玩家二执黑棋");
                    gf.blackbar.setIcon(WHITEBAR);
                    gf.whitebar.setIcon(BLACKBAR);
//                    gf.name_b = "PLAYER 2";
//                    gf.name_w = "PLAYER 1";
                }
            }

            //重绘棋盘
            for (int i = 0; i < gf.isAvail.length; i++)
                for (int j = 0; j < gf.isAvail[i].length; j++)
                    gf.isAvail[i][j] = 0;
            gf.repaint();
            //如果是开始新游戏的按钮，再为左半部分设置监听方法
            gf.turn = 1;
        }
        //判断当前点击的按钮是不是悔棋
        else if (e.getActionCommand().equals("UNDO")) {
            if ((gf.ChessPositonList.size() > 1) && (gf.turn != 0)) {
                //把棋子数组相应的位置置为0；
                ChessPosition l = new ChessPosition();
                //获取最后一个棋子的对象信息
                l = gf.ChessPositonList.remove(gf.ChessPositonList.size() - 1);
                //把相应的数组位置置为0
                gf.isAvail[l.Listi][l.Listj] = 0;
                //把玩家还原为上一步的玩家
                if (gf.turn == 1) gf.turn++;
                else gf.turn--;

                //直接调用gf的重绘方法，重绘方法的画笔应该是在棋盘页面还没生成的时候就要获取
                //调用repaint会自动调用paint方法，而且不用给参数
                gf.repaint();
            } else {
                gf.PopUp("错误提示", "不可悔棋!");
            }
        } else if (e.getActionCommand().equals("GIVE UP")) {
            if (gf.turn == 0) {
                gf.PopUp("错误提示", "不可认输");
            }
            if (this.mode == 1 && gf.turn != 0) {
                gf.PopUp("认输", "玩家认输");
            }
            if (this.mode == 0 && gf.turn != 0) {
                if (gf.turn == 1) gf.PopUp("认输", "黑方认输，白方赢");
                if (gf.turn == 2) gf.PopUp("认输", "白方认输，黑方赢");
            }
            //重新把棋盘设置为不可操作
            gf.turn = 0;
        } else if (e.getActionCommand().equals("TIE")) {
            if (gf.turn == 0) {
                gf.PopUp("错误提示", "不可求和");
            }
            if (this.mode == 1 && gf.turn != 0) {
                gf.PopUp("求和", "玩家向人机申请和棋");
            }
            if (this.mode == 0 && gf.turn != 0) {
                if (gf.turn == 1) gf.PopUp("求和", "黑方向白方申请和棋");
                if (gf.turn == 2) gf.PopUp("求和", "白方向黑方申请和棋");
            }
            //重新把棋盘设置为不可操作
            gf.turn = 0;
        } else if (e.getActionCommand().equals("PAUSE")) {
            if (gf.turn == 0) {
                gf.PopUp("错误提示", "不可暂停");
            }
            if (this.mode == 1 && gf.turn != 0) {
                gf.PopUp("暂停", "请求暂停");
            }
            if (this.mode == 0 && gf.turn != 0) {
                if (gf.turn == 1) gf.PopUp("暂停", "黑方请求暂停");
                if (gf.turn == 2) gf.PopUp("暂停", "白方请求暂停");
            }
        } else if (e.getActionCommand().equals("LOGOUT")) {
            BeforeLogin bfl = new BeforeLogin();//初始化一个五子棋界面的对象
            bfl.initUI();//调用方法进行界面的初始化
            gf.jf.dispose();
        } else if (e.getActionCommand().equals("EXIT")) {
            System.exit(0);
        } else if (e.getActionCommand().equals("Start PVP")) {
            GobangFrame gf = new GobangFrame();//初始化一个五子棋界面的对象
            gf.initUI(0, loginui.name_1, loginui.name_2);//调用方法进行界面的初始化
            loginui.dispose();
        } else if (e.getActionCommand().equals("Start PVE")) {
            GobangFrame gf = new GobangFrame();//初始化一个五子棋界面的对象
            gf.initUI(1, loginui.name_1, "ROBOT");//调用方法进行界面的初始化
            loginui.dispose();
        } else if (e.getActionCommand().equals("PVP")) {
            System.out.println("PVP");
            Login lg = new Login();
            this.mode = 0;
            lg.initUI(mode);
            bfloginui.dispose();
        } else if (e.getActionCommand().equals("PVE")) {
            System.out.println("PVE");
            Login lg = new Login();
            this.mode = 1;
            lg.initUI(mode);
            bfloginui.dispose();
        }
    }

}
