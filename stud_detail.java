import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
public class stud_detail extends Frame implements ActionListener
{
	TextField roll;
	Button show;
	TextArea tt;
	String w="";
	public void sets()
	{
		setLayout(null);
		Label Lroll=new Label("Roll Number : ",Label.RIGHT);

		roll=new TextField(20);
		tt=new TextArea(w,4,5);
		show=new Button("Show");

		add(Lroll);
		add(roll);
		add(show);
		add(tt);

		Lroll.setBounds(100,150,100,22);
		roll.setBounds(250,150,217,22);
		show.setBounds(500,145,72,32);
		tt.setBounds(100,200,520,300);

		show.addActionListener(this);

		setSize(950,670);
		show();
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cnc=DriverManager.getConnection("jdbc:odbc:registration");
			Statement sm=cnc.createStatement();
			String a,b,c,d,e,f,g,h,i,j;
			b=roll.getText();
			ResultSet rst=sm.executeQuery("Select * from  registration where roll='"+b+"'");
			int x=0;
			while(rst.next())
			{
				a=rst.getString(1);
				b=rst.getString(2);
				c=rst.getString(3);
				d=rst.getString(4);
				e=rst.getString(5);
				f=rst.getString(6);
				g=rst.getString(7);
				h=rst.getString(8);
				i=rst.getString(9);
				j=rst.getString(10);

				w="Name : "+a;
				w=w+"\nRoll : "+b;
				w=w+"\nMob : "+c;
				w=w+"\nFather : "+d;
				w=w+"\nGender : "+e;
				w=w+"\nStream : "+f;
				w=w+"\nSemester : "+g;
				w=w+"\nDOB : "+h;
				w=w+"\nAddress : "+i;
				w=w+"\nCity : "+j;
				tt.setText(w);
				x=1;
			}
			if(x==0)
			{
				JOptionPane.showMessageDialog(null,"No data exists");
				return;
			}
			rst.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String args[])
	{
		stud_detail sd=new stud_detail();
		sd.sets();
		sd.addWindowListener(new WindowAdapter()
		{
			public void WindowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
}