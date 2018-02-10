import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class ViewCharges extends Frame implements ItemListener
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
		
		roll.setBounds(100,100,110,22);
		tt.setBounds(100,125,300,300);

		roll.addItemListener(this);

		setSize(950,670);
		show();

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cnc=DriverManager.getConnection("jdbc:odbc:Charges");
			Statement sm=cnc.createStatement();
			ResultSet rst=sm.executeQuery("Select roll from fee");
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
			Connection cnc=DriverManager.getConnection("jdbc:odbc:Charges");
			Statement sm=cnc.createStatement();
			ResultSet rst=sm.executeQuery("Select * from fee where roll='"+z+"'");
			String p,q,r,s,t;
			while(rst.next())
			{
				p=rst.getString(1);
				q=rst.getString(2);
				r=rst.getString(3);
				s=rst.getString(4);
				t=rst.getString(5);
	
				y=y+"\nRoll Number : "+p;
				y=y+"\nMonth of fee : "+q;
				y=y+"\nAmount : "+r;
				y=y+"\nTemporary : "+s;
				y=y+"\nOther charges : "+t;
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
		ViewCharges vc=new ViewCharges();
		vc.sets();
		vc.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
}