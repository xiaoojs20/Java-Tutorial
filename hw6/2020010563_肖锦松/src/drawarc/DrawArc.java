import java.awt.*;
import javax.swing.*;
public class DrawArc extends JFrame {
    public DrawArc () {
        super(" DrawArc");
        setVisible(true);
        setSize(600, 600);
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.GREEN);
        g.fillRect(293, 250, 14, 310);
        g.setColor(Color.BLUE);
        g.fillArc(150, 100,300, 300, 30, 30);
        g.fillArc(150, 100,300, 300, 120, 30);
        g.fillArc(150, 100,300, 300, 210, 30);
        g.fillArc(150, 100,300, 300, 300, 30);
        g.setColor(Color.BLACK);
        g.setFont( new Font( "Monospaced", Font.ITALIC, 16) );
        g.drawString( "Welcome to Java world", 30, 550 );
    }
    public static void main(String[] args) {
        DrawArc app = new DrawArc();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
