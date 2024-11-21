import javax.swing.*;

class MenuExample {
	JMenu menu, submenu;
	JMenuItem i1, i2, i3, i4, i5;

	MenuExample() {
		JFrame frame = new JFrame("Menu and MenuItem Example");
		JMenuBar mb = new JMenuBar();
		menu = new JMenu("Menu");
		submenu = new JMenu("Sub Menu");
		i1 = new JMenuItem("Item 1");
		i2 = new JMenuItem("Item 2");
		i3 = new JMenuItem("Item 3");
		i4 = new JMenuItem("Item 4");
		i5 = new JMenuItem("Item 5");
		menu.add(i1);
		menu.add(i2);
		menu.add(i3);
		submenu.add(i4);
		submenu.add(i5);
		menu.add(submenu);
		mb.add(menu);
		frame.setJMenuBar(mb);
		frame.setSize(400, 400);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null); // Setting the frame in the center of the screen.
		frame.setVisible(true);
	}

	public static void main(String args[]) {
		new MenuExample();
	}
}
