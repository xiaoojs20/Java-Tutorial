import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorWord extends JFrame {
    private JLabel labelWord;
    private JRadioButton btnRed, btnBlue, btnBlack;
    public ColorWord() {
        super("ColorWord");
        JPanel panel = (JPanel)getContentPane();
        panel.setLayout(null);    // 自由布局
        setResizable(false);         // 不允许用户改变窗口大小
        labelWord = new JLabel("Word");
        labelWord.setFont(new Font("宋体", Font.BOLD, 28));
        btnRed = new JRadioButton("Red");
        btnRed.setFont(new Font("宋体", Font.PLAIN, 24));
        btnBlue = new JRadioButton("Blue");
        btnBlue.setFont(new Font("宋体", Font.PLAIN, 24));
        btnBlack = new JRadioButton("Black");
        btnBlack.setFont(new Font("宋体", Font.PLAIN, 24));
        ButtonGroup groupColor = new ButtonGroup();
        groupColor.add(btnRed);
        groupColor.add(btnBlue);
        groupColor.add(btnBlack);

        labelWord.setBounds(200, 50, 410, 40);  // 手工设定控件的位置和大小
        btnRed.setBounds(40, 200, 100, 40);
        btnBlue.setBounds(210, 200, 100, 40);
        btnBlack.setBounds(380, 200, 100, 40);

        panel.add(labelWord);
        panel.add(btnRed);
        panel.add(btnBlue);
        panel.add(btnBlack);
        setSize(520, 350);
        setVisible(true);

        ActionListener listenerRedWord =
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        labelWord.setForeground(Color.RED);
                    }
                };
        btnRed.addActionListener(listenerRedWord);

        ActionListener listenerGreenWord =
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        labelWord.setForeground(Color.BLUE);
                    }
                };
        btnBlue.addActionListener(listenerGreenWord);

        ActionListener listenerBlueWord =
                new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        labelWord.setForeground(Color.BLACK);
                    }
                };
        btnBlack.addActionListener(listenerBlueWord);
    }

    public static void main(String[] args) {
        ColorWord app = new ColorWord();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

