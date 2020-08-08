import java.awt.*;
import java.awt.event.*;
class FinderUI extends Frame implements ActionListener
{
	TextField t1,t2,t3,t4,t5,t6;
	Label l1,l2,l3;
	Panel p1;
	Button b1,b2;
	Utility u;
	Font f1;
	FinderUI()
	{
		setVisible(true);
		setSize(500,500);
		u = new Utility();
		t1 = new TextField(20);
		t2 = new TextField(20);
		t3 = new TextField(20);
		t4 = new TextField(20);
		t5 = new TextField(20);
		t6 = new TextField(20);
		l1 = new Label("Date");
		l2 = new Label("Month");
		l3 = new Label("Year");
		b1 = new Button("Day");
		b2 = new Button("Clear");
		p1 = new Panel();
		p1.setLayout(null);
		p1.add(l1);p1.add(l2);p1.add(l3);
		p1.add(t2);p1.add(t3);p1.add(t4);
		p1.add(t5);p1.add(b1);p1.add(b2);
		p1.setBackground(new Color(114,255,51));
		f1 = new Font("TORCH",Font.BOLD,15);
		l1.setFont(f1);l2.setFont(f1);l3.setFont(f1);
		t1.setText("\t\t\tDayFinder");
		t1.setFont(f1);
		b1.setFont(f1);b2.setFont(f1);
		t2.setFont(f1);t6.setFont(f1);
		t3.setFont(f1);t4.setFont(f1);t5.setFont(f1);
		l1.setBounds(105,100,50,20);l2.setBounds(200,100,70,20);
		l3.setBounds(305,100,50,20);
		t2.setBounds(100,130,50,25);t3.setBounds(200,130,50,25);
		t4.setBounds(300,130,50,25);

		b1.setBounds(100,185,65,30);t5.setBounds(180,185,170,30);
		add(t1,BorderLayout.NORTH);
		add(p1,BorderLayout.CENTER);b2.setBounds(365,155,65,30);
		add(t6,BorderLayout.SOUTH);

		b1.addActionListener(this);
		b2.addActionListener(this);
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
		int []a = {31,28,31,30,31,30,31,31,30,31,30,31};
		if(ae.getSource() == b1)
		{
			try
			{
			int f =0;
			int d = Integer.valueOf(t2.getText().trim());
			int m = Integer.valueOf(t3.getText().trim());
			int y = Integer.valueOf(t4.getText().trim());
			if(m==2 && u.isLeapYear(y))
				f = 1;
			if(d<=0 || d>(a[m-1] + f) || m<=0 || m>12 || y<=0)
				throw new Exception();
			String ans = u.dayFinder(d,m,y);
			t5.setText(ans);
		    }catch(Exception e)
		    {
		    	t6.setText("Invalid format or Date");
		    }
		    try{
		    	Thread.sleep(2000);
			clear();
		}catch(Exception e){}
		}
		else if(ae.getSource() == b2)
		   clear();
	}
	void clear()
	{
		    t2.setText(" ");
			t3.setText(" ");
			t4.setText(" ");
			t5.setText(" ");
			t6.setText(" ");
	}
	public static void main(String[] args) {
		new FinderUI();
	}
}