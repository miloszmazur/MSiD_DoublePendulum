package dp;



import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
	JButton engage;
	
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
		gui.setSize(920, 535);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setLocationRelativeTo(null);
		gui.setTitle("Double Pendulum");
		gui.setLayout(null);
		field = new Foo();
		field.setBounds(200,10,700,470);
		buttons = new JPanel();
		buttons.setBounds(10,10,180,470);
		buttons.setLayout((LayoutManager) new BoxLayout(buttons,BoxLayout.Y_AXIS));
		JLabel l1c = new JLabel("Length 1 (m)");
		JLabel l2c = new JLabel("Length 2 (m)");
		JLabel m1c = new JLabel("Mass 1 (kg)");
		JLabel m2c = new JLabel("Mass 2 (kg)");
		JLabel k1c = new JLabel("Angle 1 (deg)");
		JLabel k2c = new JLabel("Angle 2 (deg)");
		JLabel h = new JLabel("Time step (s) (keep REALLY low)");
		JLabel g = new JLabel("Gravitational constant (m/s^2)");
		
		l1t = new JTextField("100");
		l2t = new JTextField("100");
		m1t = new JTextField("1");
		m2t = new JTextField("10");
		k1t = new JTextField("45");
		k2t = new JTextField("45");
		ht = new JTextField("0.0001");
		gt = new JTextField("10");
		
		engage = new JButton("Simulate");
		
		buttons.add(l1c);
		buttons.add(l1t);
		buttons.add(l2c);
		buttons.add(l2t);
		buttons.add(m1c);
		buttons.add(m1t);
		buttons.add(m2c);
		buttons.add(m2t);
		buttons.add(k1c);
		buttons.add(k1t);
		buttons.add(k2c);
		buttons.add(k2t);
		buttons.add(h);
		buttons.add(ht);
		buttons.add(g);
		buttons.add(gt);
		buttons.add(engage);
		
		engage.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
                    initLoad();
                } 
				catch (Exception ex) {
                    System.out.println("Something has gone really, really bad. If you're smarter than me, try to guess what.");
                }
				
			}
        });
		
		gui.add(field);
		gui.add(buttons);
        
	}
	public void initLoad(){
	      
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
