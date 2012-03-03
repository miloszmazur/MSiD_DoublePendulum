package dp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Mainframe extends JFrame{

	/**
	 * @param args
	 */
	JFrame gui;
	JPanel field;
	JPanel buttons;
	
	public static void main(String[] args) 
	{
		
		new Mainframe();
	}

	Mainframe()
	{
		 try {
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        } catch (ClassNotFoundException ex) {
	        } catch (InstantiationException ex) {
	        } catch (IllegalAccessException ex) {
	        } catch (UnsupportedLookAndFeelException ex) {
	        }
		 init();
         this.setLocationRelativeTo(null);

	}
	
	//tu dzieje siê magia. i gui.
	public void init()
	{
		gui = new JFrame();
		field = new Foo(300, 300);
		buttons = new JPanel();
		//przyciski do parametrów
		//TODO wiecej parametrów, lol. I ³adniejsze u³o¿enie, ale to potem zrobiê, bo po có¿.
		// proponujê po lewej daæ przyciski - trzeba ustawiæ inny layout. Ja bêdê prawdopobobnie
		//w nieludzkich godzinach dostepny, takze no.
		JButton l1c = new JButton("d³ 1");
		JButton l2c = new JButton("d³ 2");
		JButton m1c = new JButton("m 1");
		JButton m2c = new JButton("m 2");
		
		JTextField l1t = new JTextField("     0    ");
		JTextField l2t = new JTextField("     0    ");
		JTextField m1t = new JTextField("     0    ");
		JTextField m2t = new JTextField("     0    ");
		
		buttons.add(l1c);
		buttons.add(l1t);
		buttons.add(l2c);
		buttons.add(l2t);
		buttons.add(m1c);
		buttons.add(m1t);
		buttons.add(m2c);
		buttons.add(m2t);
		
		gui.add(field, "North");
		gui.add(buttons, "South");
        gui.setSize(800, 600);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
