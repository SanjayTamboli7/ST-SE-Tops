import java.awt.event.WindowListener;
import java.awt.*;
import java.awt.event.*;

import java.awt.Color;

public class FrameDemo implements WindowListener {

	FrameDemo() {

		// Create a frame
		Frame f = new Frame("WindowListener Example");
		Image icon = new javax.swing.ImageIcon("images/android.png").getImage();
		
		// Create a label
		Label l = new Label("GeeksforGeeks");

		// Set properties of label
		l.setBounds(100, 90, 140, 20);
		l.setForeground(Color.GREEN);
		l.setFont(new Font("Serif", Font.BOLD, 22));

		// Add it to the frame
		f.add(l);

		// Add windowListener to the frame
		f.addWindowListener(this);

		// Set properties of frame
		f.setSize(400, 300);
		f.setLayout(null);
		f.setVisible(true);
		f.setIconImage(icon);
		f.setResizable(false); // Disable resizing

	}

    public void windowOpened(WindowEvent e) 
    { 
        System.out.println("Window is opened!"); 
    } 
  
    public void windowClosing(WindowEvent e) 
    { 
        System.out.println("Window is closing..."); 
        System.exit(0); 
    } 
  
    public void windowClosed(WindowEvent e) 
    { 
        System.out.println("Window is closed!"); 
    } 
  
    public void windowIconified(WindowEvent e) 
    { 
        System.out.println("Window is iconified!"); 
    } 
  
    public void windowDeiconified(WindowEvent e) 
    { 
        System.out.println("Window is deiconified!"); 
    } 
  
    public void windowActivated(WindowEvent e) 
    { 
        System.out.println("Window is activated!"); 
    } 
  
    public void windowDeactivated(WindowEvent e) 
    { 
        System.out.println("Window is deactivated!"); 
    } 
	
	public static void main(String args[]) {
		new FrameDemo();
	}
}
