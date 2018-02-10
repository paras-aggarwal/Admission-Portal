import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class ViewDetails extends Frame implements ItemListener
{
	Choice roll;
	TextArea tt;
	public void sets()
	{
		setLayout(null);
		roll=new Choice();
		tt=new TextArea();

		roll.add("");

		add(roll);
		add(tt);

		roll.addItemListener(this);

		roll.setBounds(100,100,110,22);
		tt.setBounds(100,125,300,300);

		setSize(950,670);
		show();

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cnc=DriverManager.getConnection("jdbc:odbc:stud_details");
			Statement sm=cnc.createStatement();
			ResultSet rst=sm.executeQuery("Select roll from details");
			String p;
			while(rst.next())
			{
				p=rst.getString(1);
				roll.add(p);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void itemStateChanged(ItemEvent ie)
	{
		String z=roll.getSelectedItem();
		String y="";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cnc=DriverManager.getConnection("jdbc:odbc:stud_details");
			Statement sm=cnc.createStatement();
			ResultSet rst=sm.executeQuery("Select * from details where roll='"+z+"'");
			String p,q,r,s,t;
			while(rst.next())
			{
				p=rst.getString(1);
				q=rst.getString(2);
				r=rst.getString(3);
				s=rst.getString(4);
				t=rst.getString(5);
	
				y=y+"\nRoll Number : "+p;
				y=y+"\nRegistration : "+q;
				y=y+"\nFee : "+r;
				y=y+"\nDate of Deposite : "+s;
				y=y+"\nConsetion : "+t;
			}
			tt.setText(y);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public static void main(String args[])
	{
		ViewDetails vd=new ViewDetails();
		vd.sets();
		vd.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
}