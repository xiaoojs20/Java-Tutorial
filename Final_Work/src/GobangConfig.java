import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;

//接口，存放参数
public interface GobangConfig {
    int X = 60;
    int Y = 20;
    int SIZE = 50;
    int ROW = 15;
    int COLUMN = 15;
    int UIWIDTH = 1265;
    int UIHIGHTH = 785;
    int MESSAGEWIDTH = 420;//设置右边信息栏的宽度
    Image BLACKCHESS = new ImageIcon("pic\\black.png").getImage();
    Image WHITECHESS = new ImageIcon("pic\\white.png").getImage();
    Image BOARD = new ImageIcon("pic\\board.png").getImage();
    ImageIcon PLAYER1 = new ImageIcon("pic\\p1.png");
    ImageIcon PLAYER2 = new ImageIcon("pic\\player_2.png");
    ImageIcon BLACKBAR = new ImageIcon("pic\\blackbar.png");
    ImageIcon WHITEBAR = new ImageIcon("pic\\whitebar.png");
    ImageIcon COMPUTER = new ImageIcon("pic\\computer.png");
    Dimension dim_info = new Dimension(MESSAGEWIDTH, 0);//设置右边信息栏的大小
    Dimension dim_bar = new Dimension(160, 20);//设置黑白条的大小
    Dimension dim_div = new Dimension(320, 20);//设置分割条的大小
    Dimension dim_icon = new Dimension(160, 160);//设置头像组件的大小
    Dimension dim_button = new Dimension(140, 40);//设置右边按钮组件的大小
    int button_font = 15;
    Dimension dim_chat = new Dimension(300, 180);//设置右边聊天框组件的大小
    Dimension dim_input = new Dimension(300, 40);//设置右边输入框的大小
}
