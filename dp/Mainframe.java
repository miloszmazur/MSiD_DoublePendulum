package dp;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Mainframe extends JFrame{

	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	JFrame gui;
	Foo field;
	JPanel buttons;
	double mass1, mass2, len1, len2, an1, an2;
	double h, g;
	double[]z;
	JTextField l1t, l2t;
	JTextField m1t, m2t;
	JTextField k1t, k2t;
	JTextField ht, gt;
	Simulation motherload;
	
	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater (new Runnable()
		{
			public void run()
			{
				new Mainframe();
	}
		});
	}

	Mainframe()
	{
		 try {
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        } catch (ClassNotFoundException ex) {
	        } catch (InstantiationException ex) {
	        } catch (IllegalAccessException ex) {
	        } catch (UnsupportedLookAndFeelException ex){
	        }
		 init();
         

	}
	
	//tu dzieje siê magia. i gui.
	public void init()
	{
		gui = new JFrame();
		gui.setSize(800, 600);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		field = new Foo();
		buttons = new JPanel();
		//przyciski do parametrów
		// proponujê po lewej daæ przyciski - trzeba ustawiæ inny layout. Ja bêdê prawdopobobnie
		//w nieludzkich godzinach dostepny, takze no.
		JLabel l1c = new JLabel("d³ 1");
		JLabel l2c = new JLabel("d³ 2");
		JLabel m1c = new JLabel("m 1");
		JLabel m2c = new JLabel("m 2");
		JLabel k1c = new JLabel("kat 1");
		JLabel k2c = new JLabel("kat 2");
		JLabel h = new JLabel("Krok czasu");
		JLabel g = new JLabel("stala graw");
		
		l1t = new JTextField("     0    ");
		l2t = new JTextField("     0    ");
		m1t = new JTextField("     0    ");
		m2t = new JTextField("     0    ");
		k1t = new JTextField("     0    ");
		k2t = new JTextField("     0    ");
		
		buttons.add(l1c);
		buttons.add(l1t);
		buttons.add(l2c);
		buttons.add(l2t);
		buttons.add(m1c);
		buttons.add(m1t);
		buttons.add(m2c);
		buttons.add(m2t);
		
		gui.add(field);
		gui.add(buttons);
        
	}
	public void ititLoad(){
	      
    	mass1=Double.parseDouble(m1t.getText());
    	mass2=Double.parseDouble(m2t.getText());
    	len1=Double.parseDouble(l1t.getText());
    	len2=Double.parseDouble(l2t.getText());
    	an1=Math.toRadians(Double.parseDouble(k1t.getText()));
    	an2=Math.toRadians(Double.parseDouble(k2t.getText()));
    	h=Double.parseDouble(ht.getText());
    	g=Double.parseDouble(gt.getText());
        z = new double[] {an1,an2,0,0};
        if(motherload==null){
            motherload = new Simulation(field,h,g,len1,len2,mass1,mass2,z);
        }
        else{
            motherload.set(h,len1,len2,mass1,mass2,z);
        }
    }
}
