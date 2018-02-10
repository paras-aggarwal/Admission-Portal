import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Registration extends Frame implements ActionListener,ItemListener
{
	TextField name,mobile,fname,address,city;
	Checkbox male,female;
	CheckboxGroup gen;
	Choice stream,sem,date,month,year;
	Button back,submit,refresh;
	String k="";
	ImageIcon ii=new ImageIcon("admission_process.jpg");
	JLabel jl=new JLabel("admission_process",ii,JLabel.RIGHT);
	public void sets()
	{
		setLayout(null);
		Label title=new Label("Student Registration Form",Label.RIGHT);
		Label Lname=new Label("Name: ",Label.RIGHT);
		Label Lmobile=new Label("Mobile Number: ",Label.RIGHT);
		Label Lfname=new Label("Father's Name: ",Label.RIGHT);
		Label Lgender=new Label("Gender: ",Label.RIGHT);
		Label Lstream=new Label("Stream: ",Label.RIGHT);
		Label Lsem=new Label("Semester: ",Label.RIGHT);
		Label Ldob=new Label("Date of Birth: ",Label.RIGHT);
		Label Laddress=new Label("Address: ",Label.RIGHT);
		Label Lcity=new Label("City: ",Label.RIGHT);

		name=new TextField(20);
		mobile=new TextField(10);
		fname=new TextField(20);
		address=new TextField(70);
		city=new TextField(20);

		back=new Button("Back");
		submit=new Button("Submit");
		refresh=new Button("Refresh");

		gen=new CheckboxGroup();
		male=new Checkbox("Male",gen,false);
		female=new Checkbox("Female",gen,false);

		stream=new Choice();
		sem=new Choice();
		date=new Choice();
		month=new Choice();
		year=new Choice();

		// add items to list
		stream.add("");
		stream.add("Civil Engineering");
		stream.add("Mechanical Engineering");
		stream.add("Electrical Engineering");
		stream.add("Computer Engineering");
		stream.add("Electronics and Communication");
		stream.add("Architechtural Assistantship");
		stream.add("Plastic Technology");
		stream.add("Automobile Engineering");

		sem.add("");
		sem.add("1st");
		sem.add("3rd");

		date.add("");
		date.add("1");
		date.add("2");
		date.add("3");
		date.add("4");
		date.add("5");
		date.add("6");
		date.add("7");
		date.add("8");
		date.add("9");
		date.add("10");
		date.add("11");
		date.add("12");
		date.add("13");
		date.add("14");
		date.add("15");
		date.add("16");
		date.add("17");
		date.add("18");
		date.add("19");
		date.add("20");
		date.add("21");
		date.add("22");
		date.add("23");
		date.add("24");
		date.add("25");
		date.add("26");
		date.add("27");
		date.add("28");
		date.add("29");
		date.add("30");

		month.add("");
		month.add("January");
		month.add("February");
		month.add("March");
		month.add("April");
		month.add("May");
		month.add("June");
		month.add("July");
		month.add("August");
		month.add("September");
		month.add("October");
		month.add("November");
		month.add("December");

		year.add("");
		year.add("1990");
		year.add("1991");
		year.add("1992");
		year.add("1993");
		year.add("1994");
		year.add("1995");
		year.add("1996");
		year.add("1997");
		year.add("1998");
		year.add("1999");
		year.add("2000");
		year.add("2001");
		year.add("2002");
		year.add("2003");
		year.add("2004");
		year.add("2005");	
		
		// add items to frame window
		add(title);
		add(Lname);
		add(name);
		add(Lmobile);
		add(mobile);
		add(Lfname);
		add(fname);
		add(Lgender);
		add(male);
		add(female);
		add(Lstream);
		add(stream);
		add(Lsem);
		add(sem);
		add(Ldob);
		add(date);
		add(month);
		add(year);
		add(Laddress);
		add(address);
		add(Lcity);
		add(city);
		add(back);
		add(submit);
		add(refresh);
		add(jl);
	
		Font f1=new Font("SansSerif",Font.BOLD,24);
		Font f2=new Font("SansSerif",Font.BOLD,12);
		title.setFont(f1);
		Lname.setFont(f2);
		Lmobile.setFont(f2);
		Lfname.setFont(f2);
		Lgender.setFont(f2);
		Lstream.setFont(f2);
		Lsem.setFont(f2);
		Ldob.setFont(f2);
		Laddress.setFont(f2);
		Lcity.setFont(f2);
		back.setFont(f2);
		submit.setFont(f2);
		refresh.setFont(f2);

		name.addActionListener(this);
		mobile.addActionListener(this);
		fname.addActionListener(this);
		male.addItemListener(this);
		female.addItemListener(this);
		stream.addItemListener(this);
		sem.addItemListener(this);
		date.addItemListener(this);
		month.addItemListener(this);
		year.addItemListener(this);
		back.addActionListener(this);
		submit.addActionListener(this);
		refresh.addActionListener(this);
		
		// set positions
		title.setBounds(10,30,320,50);
		Lname.setBounds(100,100,50,22);
		name.setBounds(250,100,217,22);
		Lmobile.setBounds(102,140,100,22);
		mobile.setBounds(250,140,217,22);
		Lfname.setBounds(100,180,100,22);
		fname.setBounds(250,180,217,22);
		Lgender.setBounds(59,220,100,22);
		male.setBounds(250,220,50,22);
		female.setBounds(350,220,60,22);
		Lstream.setBounds(59,260,100,22);
		stream.setBounds(250,260,215,22);
		Lsem.setBounds(92,300,80,22);
		sem.setBounds(250,300,50,22);
		Ldob.setBounds(106,340,80,22);
		date.setBounds(250,340,45,22);
		month.setBounds(300,340,100,22);
		year.setBounds(405,340,60,22);
		Laddress.setBounds(66,380,100,22);
		address.setBounds(250,380,217,22);
		Lcity.setBounds(60,420,80,22);
		city.setBounds(250,420,217,22);
		back.setBounds(145,460,70,32);
		submit.setBounds(250,460,70,32);
		refresh.setBounds(350,460,70,32);
		jl.setBounds(500,5,850,450);

		// frame window
		setSize(1366,730);	
		show();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==submit)
		{
			String a,b,c,d,e,f,g,h,i,j;
			a=name.getText();
			b=mobile.getText();
			c=fname.getText();
			d=stream.getSelectedItem();
			e=sem.getSelectedItem();
			f=date.getSelectedItem();
			g=month.getSelectedItem();
			h=year.getSelectedItem();
			i=address.getText();
			j=city.getText();
			
			if(a.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Enter Name");
				return;
			}
			if(b.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Enter Mobile");
				return;
			}
			if(c.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Enter Father's Name");
				return;
			}
			if(d.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Select Stream");
				return;
			}
			if(e.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Select Semester");
				return;
			}
			if(f.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Select Date");
				return;
			}
			if(g.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Select Month");
				return;
			}
			if(h.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Select Year");
				return;
			}
			if(i.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Enter Address");
				return;
			}
			if(j.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Enter City");
				return;
			}
			if(k.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Select Gender");
				return;
			}
		
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cnc=DriverManager.getConnection("jdbc:odbc:register");
				Statement sm=cnc.createStatement();
				String p,q,r,s,t,u,v,w,x,y,z;
				p=name.getText();
				q=mobile.getText();
				r=fname.getText();
				s=gen.getSelectedCheckbox().getLabel();
				t=stream.getSelectedItem();
				u=sem.getSelectedItem();
				v=date.getSelectedItem();
				w=month.getSelectedItem();
				x=year.getSelectedItem();
				y=address.getText();
				z=city.getText();
				sm.executeUpdate("insert into register values('"+p+"','"+q+"','"+r+"','"+s+"','"+t+"','"+u+"','"+v+w+x+"','"+y+"','"+z+"')");
				JOptionPane.showMessageDialog(null,"Your data is successfully saved");
				submit.setEnabled(false);
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
		if(ae.getSource()==back)
		{
			setVisible(false);
			MainMenu m1=new MainMenu();
			m1.sets();
			m1.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});
		}
		if(ae.getSource()==refresh)
		{
			name.setText("");
			mobile.setText("");
			fname.setText("");
			gen.setCurrent(null);
			stream.select(0);
			sem.select(0);
			date.select(0);
			month.select(0);
			year.select(0);
			address.setText("");
			city.setText("");
			submit.setEnabled(true);
		}	
	}
	public void itemStateChanged(ItemEvent ie)
	{	
		k=gen.getSelectedCheckbox().getLabel();
	}
	public static void main(String args[])
	{
		Registration r1=new Registration();
		r1.sets();
		r1.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
}