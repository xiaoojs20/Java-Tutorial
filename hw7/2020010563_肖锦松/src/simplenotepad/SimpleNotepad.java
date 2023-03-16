import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class SimpleNotepad extends JFrame implements ActionListener{
    private JTextArea inputText;
    private JScrollPane pane;

    public SimpleNotepad() {
        super("Notepad");
        JPanel panel = (JPanel)getContentPane();
        panel.setLayout(null);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout(5,1));

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");

        JMenuItem open=new JMenuItem("Open");
        open.addActionListener(this);
        menu.add(open);
        JMenuItem save=new JMenuItem("Save");
        save.addActionListener(this);
        menu.add(save);
        menuBar.add(menu);

        this.setJMenuBar(menuBar);
        inputText=new JTextArea();
        inputText.setLineWrap(true);
        pane=new JScrollPane(inputText);
        contentPane.add(pane);
        setVisible(true);
    }
    public static void main(String[] args) {
        SimpleNotepad app = new SimpleNotepad();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) {
        String cmd = event.getActionCommand();
        if ("Open".equals(cmd)) {
            File srcFile=null;
            JFileChooser fileChooser=new JFileChooser();
            int res=fileChooser.showOpenDialog(null);
            if(res==JFileChooser.APPROVE_OPTION) {
                srcFile=fileChooser.getSelectedFile();
            }
            try {
                if(srcFile!=null) {
                    InputStream is = new FileInputStream(srcFile);
                    byte[] buffer = new byte[8 * 1024];
                    int len;
                    while ((len = is.read(buffer)) != -1) {
                        String text = new String(buffer, 0, len, "UTF-8");
                        inputText.append(text);
                    }
                    is.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if ("Save".equals(cmd)) {
            File destFile=null;
            JFileChooser fileChooser=new JFileChooser();
            int res = fileChooser.showSaveDialog(null);
            if (res == JFileChooser.APPROVE_OPTION) {
                destFile = fileChooser.getSelectedFile();
            } else
                return;

            try {
                if(destFile!=null) {
                    OutputStream os = new FileOutputStream(destFile);
                    os.write(inputText.getText().getBytes("UTF-8"));
                    os.close();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}