import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//public class SwingJFrameDemo {
//
//}
@SuppressWarnings({ "serial", "unused" })
public class SwingJFrameDemo extends javax.swing.JFrame {
    public SwingJFrameDemo() {
        super("Simple / regular JFrame");
        
        JFrame frame = new JFrame("Demo program for JFrame");
        JTextField textFieldUserName = new JTextField(50);
               
        frame.setLayout(new GridBagLayout());
        frame.add(textFieldUserName);
         
    }
    
    public static void main(String[] args) {
        new SwingJFrameDemo().setVisible(true);
    }    
    
}