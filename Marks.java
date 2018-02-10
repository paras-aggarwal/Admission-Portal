import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Marks extends Frame implements ActionListener
{
	TextField roll,sem,total,obtained;
	Button back,save,refresh;
	public void sets()
	{
		setLayout(null);
		Label title=new Label("Student Marks Details",Label.RIGHT);
		Label Lroll=new Label("Roll Number: ",Label.RIGHT);
		Label Lsem=new Label("Semester: ",Label.RIGHT);
		Label Ltotal=new Label("Total Marks: ",Label.RIGHT);
		Label Lobtained=new Label("Obtained Marks: ",Label.RIGHT);
		
		roll=new TextField(20);
		sem=new TextField(20);
		total=new TextField(20);
		obtained=new TextField(20);
		
		back=new Button("Back");
		save=new Button("Save");
		refresh=new Button("Refresh");
		
		Font f1=new Font("SansSerif",Font.BOLD,24);
		Font f2=new Font("SansSerif",Font.BOLD,12);
		title.setFont(f1);
		Lroll.setFont(f2);
		Lsem.setFont(f2);
		Ltotal.setFont(f2);
		Lobtained.setFont(f2);
		back.setFont(f2);
		save.setFont(f2);
		refresh.setFont(f2);
		
		// add items to Frame Window
		add(title);
		add(Lroll);
		add(roll);
		add(Lsem);
		add(sem);
		add(Ltotal);
		add(total);
		add(Lobtained);
		add(obtained);
		add(back);
		add(save);
		add(refresh);

		back.addActionListener(this);
		save.addActionListener(this);
		refresh.addActionListener(this);

		//Set position
		title.setBounds(10,30,260,50);
		Lroll.setBounds(100,100,100,22);
		roll.setBounds(250,100,217,22);
		Lsem.setBounds(100,140,86,22);
		sem.setBounds(250,140,217,22);
		Ltotal.setBounds(100,180,98,22);
		total.setBounds(250,180,217,22);
		Lobtained.setBounds(100,220,120,22);
		obtained.setBounds(250,220,217,22);
		back.setBounds(145,260,70,32);		
		save.setBounds(250,260,70,32);
		refresh.setBounds(350,260,70,32);

		setSize(1000,720);	
		show();
	}
	public void actionPerformed(ActionEvent ae)
	{
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
		if(ae.getSource()==save)
		{
			String a,b,c,d;
			a=roll.getText();
			b=sem.getText();
			c=total.getText();
			d=obtained.getText();
			if(a.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Enter Roll Number");
				return;
			}
			if(b.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Enter Semester");
				return;
			}
			if(c.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Enter Total Marks");
				return;
			}
			if(d.length()==0)
			{
				JOptionPane.showMessageDialog(null,"Enter Obtained Marks");
				return;
			}
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cnc=DriverManager.getConnection("jdbc:odbc:marks");
				Statement sm=cnc.createStatement();
				String p,q,r,s;
				p=roll.getText();
				q=sem.getText();
				r=total.getText();
				s=obtained.getText();
				sm.executeUpdate("insert into marks values('"+p+"','"+q+"','"+r+"','"+s+"')");
				JOptionPane.showMessageDialog(null,"your data is successfully saved");
				save.setEnabled(false);
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
		if(ae.getSource()==refresh)
		{
			roll.setText("");
			sem.setText("");
			total.setText("");
			obtained.setText("");
			save.setEnabled(true);
		}	
	}
	public static void main(String args[])
	{
		Marks m1=new Marks();
		m1.sets();
		m1.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
}