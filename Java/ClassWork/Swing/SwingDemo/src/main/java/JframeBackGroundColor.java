import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class JframeBackGroundColor {
   public static void main(String[] args) {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setPreferredSize(new Dimension(550, 300));
      frame.getContentPane().setBackground(Color.BLUE);
      frame.pack();
      frame.setVisible(true);
   }
}
