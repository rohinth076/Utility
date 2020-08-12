import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Shortcut extends Frame implements ActionListener
{
	Runtime rt;
	JTextField tf1,tf2;
	JButton b1;
	Font f;
	Panel p;

	Shortcut()
	{
		setVisible(true);
		setSize(500,500);

		rt= Runtime.getRuntime();
		tf1 = new JTextField();
		tf2 = new JTextField();
		b1 = new JButton("Open");
		p  = new Panel();
		f = new Font("TORCH",Font.BOLD,20);


		p.add(tf1);p.add(b1);
		tf1.setFont(f);
		tf2.setFont(f);
		p.setLayout(null);
		p.setBackground(new Color(0,128,128));
		tf1.setBounds(100,100,200,50);b1.setBounds(350,100,100,50);
		add(p,BorderLayout.CENTER);
		add(tf2,BorderLayout.SOUTH);
		b1.addActionListener(this);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}

		});
	}
	public void actionPerformed(ActionEvent ae)
	{
		try{
			if(ae.getSource() == b1)
			{
				String name = tf1.getText().trim();
				if(! name.isEmpty())
				{
					rt.exec(name);
					tf2.setText("Filed Opened");
				}
				else
					tf2.setText("Invalid name");
			}
			}catch(Exception e){
				tf2.setText("Invalid name");
		}
	}
	public static void main(String[] args) {
		new Shortcut();
	}
} 