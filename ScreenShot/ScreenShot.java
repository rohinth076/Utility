import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

class ScreenShot extends Frame implements ActionListener
{
	JButton b1;
	static int i;
	ScreenShot()
	{
		setVisible(true);
		setSize(100,100);
		i = 1;
		b1 = new JButton("ScreenShot");

		b1.addActionListener(this);
		add(b1,BorderLayout.CENTER);//BorderLayout.CENTER

		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent ae){

		if(ae.getSource() == b1){
			try{
		    Robot r = new Robot();
			Rectangle capture =  new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
            BufferedImage Image = r.createScreenCapture(capture); 
            ImageIO.write(Image, "jpg", new File("C:\\Users\\USER\\Pictures\\Screenshots\\t"+i+".png"));
            i++; 
        }catch(Exception e){}
		}
	}
	public static void main(String[] args) {
		new ScreenShot();
	}
}