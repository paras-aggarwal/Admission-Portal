import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class ViewRegistration extends Frame implements ItemListener
{
	Choice mobile;
	TextArea tt;
	public void sets()
	{
		setLayout(null);
		mobile=new Choice();
		tt=new TextArea();
		
		mobile.add("");
		
		add(mobile);
		add(tt);
		
		mobile.setBounds(100,100,100,22);
		tt.setBounds(100,130,200,200);
		
		mobile.addItemListener(this);
		
		setSize(950,670);
		show();

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cnc=DriverManager.getConnection("jdbc:odbc:register");
			Statement sm=cnc.createStatement();
			ResultSet rst=sm.executeQuery("Select mob from register");
			String p;
			while(rst.next())
			{
				p=rst.getString(1);
				mobile.add(p);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
	}
	public void itemStateChanged(ItemEvent ie)
	{
		String z=mobile.getSelectedItem();
		String y="";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cnc=DriverManager.getConnection("jdbc:odbc:register");
			Statement sm=cnc.createStatement();
			ResultSet rst=sm.executeQuery("Select * from register where mob='"+z+"'");
			String p,q,r,s,t,u,v,w,x;
			while(rst.next())
			{
				p=rst.getString(1);
				q=rst.getString(2);
				r=rst.getString(3);
				s=rst.getString(4);
				t=rst.getString(5);
				u=rst.getString(6);
				v=rst.getString(7);
				w=rst.getString(8);
				x=rst.getString(9);	
				y=y+"\n"+p;
				y=y+"\n"+q;
				y=y+"\n"+r;
				y=y+"\n"+s;
				y=y+"\n"+t;
				y=y+"\n"+u;
				y=y+"\n"+v;
				y=y+"\n"+w;
				y=y+"\n"+x;
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
		ViewRegistration vr=new ViewRegistration();
		vr.sets();
		vr.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
}		