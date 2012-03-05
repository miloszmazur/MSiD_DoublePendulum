package dp;


public class Simulation extends Thread{
	Foo panel;
	double h, g, l1, l2, m1, m2; 
	double[] z;
    double[] a,b,c,d;
    
    public Simulation(Foo panel, double h, double g, double l1, double l2, double m1, double m2, double[] z){
        this.panel = panel;
        this.h = h;
        this.g = g;
        this.l1 = l1;
        this.l2 = l2;
        this.m1 = m1;
        this.m2 = m2;
        this.z = z;
        this.a = new double[4];
        this.b = new double[4];
        this.c = new double[4];
        this.d = new double[4];
        start();  
      
    }
    public void set(double h, double l1, double l2, double m1, double m2, double[] z){
        this.h = h;
        this.l1 = l1;
        this.l2 = l2;
        this.m1 = m1;
        this.m2 = m2;
        this.z = z;
        this.a = new double[4];
        this.b = new double[4];
        this.c = new double[4];
        this.d = new double[4];
    }
    
    public void run()
    {
        
    	while(true){
            int x1=(int)(l1*Math.sin(z[0])+330);
            int y1=(int)(l1*Math.cos(z[0])+220);
            int x2=(int)(x1+l2*Math.sin(z[1]));
            int y2=(int)(y1+l2*Math.cos(z[1]));
            panel.setCoord(x1,y1,x2,y2);
            panel.repaint();

            try{
            	//zobaczmy, co sie stanie, jak zmienimy na milisekundy BYLO: 1000*H
                Thread.sleep((int)(h));
            }catch(InterruptedException e){
                System.out.println("Unfortunate... well, something. Something unfortunate just happened");
            }
            //magia
            a[0] = z[2];
            a[1] = z[3];
            a[2] = (float)(-g*(2*m1+m2)*Math.sin(Math.toRadians(z[0]))-m2*g*Math.sin(Math.toRadians(z[0]-2*z[1]))-2*Math.sin(Math.toRadians(z[0]-z[1]))*m2*(z[3]*z[3]*l2+z[2]*z[2]*l1*Math.cos(Math.toRadians(z[0]-z[1]))))/(float)(l1*(2*m1+m2-m2*Math.cos(Math.toRadians(2*z[0]-2*z[1]))));
            a[3] = (float)(2*Math.sin(z[0]-z[1])*(z[2]*z[2]*l1*(m1+m2)+g*(m1+m2)*Math.cos(z[0])+z[3]*z[3]*l2*m2*Math.cos(z[0]-z[1])))/(float)(l1*(2*m1+m2-m2*Math.cos(2*z[0]-2*z[1])));
           
            b[0] = z[2] + (float)0.5*h*a[2];
            b[1] = z[3] + (float)0.5*h*a[3];
            b[2] = (float)(-g*(2*m1+m2)*Math.sin(z[0]+0.5*h*a[0])-m2*g*Math.sin(z[0]-2*z[1]+0.5*h*a[0]-h*a[1])-2*Math.sin(z[0]-z[1]+0.5*h*a[0]-0.5*h*a[1])*m2*((z[3]+0.5*h*a[3])*(z[3]+0.5*h*a[3])*l2+(z[2]+0.5*h*a[2])*(z[2]+0.5*h*a[2])*l1*Math.cos(z[0]-z[1]+0.5*h*a[0]-0.5*h*a[1])))/(float)(l1*(2*m1+m2-m2*Math.cos(2*z[0]-2*z[1]+h*a[0]-h*a[1])));
            b[3] = (float)(2*Math.sin(z[0]-z[1]+0.5*h*a[0]-0.5*h*a[1])*((z[2]+0.5*h*a[2])*(z[2]+0.5*h*a[2])*l1*(m1+m2)+g*(m1+m2)*Math.cos(z[0]+0.5*h*a[0])+(z[3]+0.5*h*a[3])*(z[3]+0.5*h*a[3])*l2*m2*Math.cos(z[0]-z[1]+0.5*h*a[0]-0.5*h*a[1])))/(float)(l1*(2*m1+m2-m2*Math.cos(2*z[0]-2*z[1]+h*a[0]-h*a[1])));
            
            c[0] = z[2] + (float)0.5*h*b[2];
            c[1] = z[3] + (float)0.5*h*b[3];
            c[2] = (float)(-g*(2*m1+m2)*Math.sin(z[0]+0.5*h*b[0])-m2*g*Math.sin(z[0]-2*z[1]+0.5*h*b[0]-h*b[1])-2*Math.sin(z[0]-z[1]+0.5*h*b[0]-0.5*h*b[1])*m2*((z[3]+0.5*h*b[3])*(z[3]+0.5*h*b[3])*l2+(z[2]+0.5*h*b[2])*(z[2]+0.5*h*b[2])*l1*Math.cos(z[0]-z[1]+0.5*h*b[0]-0.5*h*b[1])))/(float)(l1*(2*m1+m2-m2*Math.cos(2*z[0]-2*z[1]+h*b[0]-h*b[1])));
            c[3] = (float)(2*Math.sin(z[0]-z[1]+0.5*h*b[0]-0.5*h*b[1])*((z[2]+0.5*h*b[2])*(z[2]+0.5*h*b[2])*l1*(m1+m2)+g*(m1+m2)*Math.cos(z[0]+0.5*h*b[0])+(z[3]+0.5*h*b[3])*(z[3]+0.5*h*b[3])*l2*m2*Math.cos(z[0]-z[1]+0.5*h*b[0]-0.5*h*b[1])))/(float)(l1*(2*m1+m2-m2*Math.cos(2*z[0]-2*z[1]+h*b[0]-h*b[1])));
            
            d[0] = z[2] + h*c[2];
            d[1] = z[3] + h*c[3];
            d[2] = (float)(-g*(2*m1+m2)*Math.sin(z[0]+h*c[0])-m2*g*Math.sin(z[0]-2*z[1]+h*c[0]-2*h*c[1])-2*Math.sin(z[0]-z[1]+h*c[0]-h*c[1])*m2*((z[3]+h*c[3])*(z[3]+h*c[3])*l2+(z[2]+h*c[2])*(z[2]+h*c[2])*l1*Math.cos(z[0]-z[1]+h*c[0]-h*c[1])))/(float)(l1*(2*m1+m2-m2*Math.cos(2*z[0]-2*z[1]+2*h*c[0]-2*h*c[1])));
            d[3] = (float)(2*Math.sin(z[0]-z[1]+h*c[0]-h*c[1])*((z[2]+h*c[2])*(z[2]+h*c[2])*l1*(m1+m2)+g*(m1+m2)*Math.cos(z[0]+h*c[0])+(z[3]+h*c[3])*(z[3]+h*c[3])*l2*m2*Math.cos(z[0]-z[1]+h*c[0]-h*c[1])))/(float)(l1*(2*m1+m2-m2*Math.cos(2*z[0]-2*z[1]+2*h*c[0]-2*h*c[1])));
            
            //ultimate kompilacja
            z[0] = z[0] + h/6*(a[0]+2*b[0]+2*c[0]+d[0]);
            z[1] = z[1] + h/6*(a[1]+2*b[1]+2*c[1]+d[1]);
            z[2] = z[2] + h/6*(a[2]+2*b[2]+2*c[2]+d[2]);
            z[3] = z[3] + h/6*(a[3]+2*b[3]+2*c[3]+d[3]);
       }
    }
}

