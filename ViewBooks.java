import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class ViewBooks extends Frame implements ItemListener
{
	Choice booknum;
	TextArea tt;
	public void sets()
	{
		setLayout(null);
		booknum=new Choice();
		tt=new TextArea();

		booknum.add("");

		add(booknum);
		add(tt);

		booknum.addItemListener(this);

		booknum.setBounds(100,100,110,22);
		tt.setBounds(100,125,300,300);

		setSize(950,670);
		show();

		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cnc=DriverManager.getConnection("jdbc:odbc:books");
			Statement sm=cnc.createStatement();
			ResultSet rst=sm.executeQuery("Select book_number from books");
			String p;
			while(rst.next())
			{
				p=rst.getString(1);
				booknum.add(p);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void itemStateChanged(ItemEvent ie)
	{
		String z=booknum.getSelectedItem();
		String y="";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cnc=DriverManager.getConnection("jdbc:odbc:books");
			Statement sm=cnc.createStatement();
			ResultSet rst=sm.executeQuery("Select * from books where book_number='"+z+"'");
			String p,q,r,s,t;
			while(rst.next())
			{
				p=rst.getString(1);
				q=rst.getString(2);
				r=rst.getString(3);
				s=rst.getString(4);
				t=rst.getString(5);
	
				y=y+"\nStudent Name : "+p;
				y=y+"\nBook Name : "+q;
				y=y+"\nBook Number : "+r;
				y=y+"\nDate of Issue : "+s;
				y=y+"\nBook Title : "+t\n\n;
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
		ViewBooks vb=new ViewBooks();
		vb.sets();
		vb.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
}