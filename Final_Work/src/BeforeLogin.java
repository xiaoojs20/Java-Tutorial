import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;


public class BeforeLogin extends JFrame implements GobangConfig {
    public JPanel ljp = new JPanel();

    public void initUI() {
        this.setTitle("BeforeLogin");
        this.setSize(UIWIDTH, UIHIGHTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setResizable(false);
        this.setLayout(null);

        //游戏标题及作者
        JLabel title = new JLabel("Gobang");
        title.setFont(new Font("HGF9X_CNKI", Font.BOLD, 50));
        title.setBounds(540, 200, 300, 100);
        this.add(title);

        JLabel author = new JLabel("肖锦松 2020010563");
        author.setFont(new Font("黑体", Font.BOLD + Font.ITALIC, 15));
        author.setBounds(1050, 650, 200, 80);
        this.add(author);

        JButton buttonPVP = new JButton("PVP");
        buttonPVP.setFocusPainted(false);
        buttonPVP.setContentAreaFilled(false);
        buttonPVP.setBounds(600, 400, 100, 40);
        buttonPVP.setFont(new Font("HGF9X_CNKI", Font.BOLD, button_font));
        buttonPVP.setBackground(Color.WHITE);
        this.add(buttonPVP);

        JButton buttonPVE = new JButton("PVE");
        buttonPVE.setFocusPainted(false);
        buttonPVE.setContentAreaFilled(false);
        buttonPVE.setBounds(600, 500, 100, 40);
        buttonPVE.setFont(new Font("HGF9X_CNKI", Font.BOLD, button_font));
        buttonPVE.setBackground(Color.WHITE);
        this.add(buttonPVE);

        ButtonListener bu = new ButtonListener(this);
        buttonPVP.addActionListener(bu);
        buttonPVE.addActionListener(bu);

        this.getContentPane().setBackground(new Color(253, 230, 224));
        this.setVisible(true);
    }

    //重写重绘方法
    public void paint(Graphics g) {
        super.paint(g);
    }

    public static void main(String args[]) {
        BeforeLogin bl = new BeforeLogin();
        bl.initUI();
    }
}
