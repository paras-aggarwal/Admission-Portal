import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class stud_details extends Frame implements ItemListener
{
	Choice sel;
	TextArea tt;
	public void sets()
	{
		setLayout(null);
		tt=new TextArea();
		sel=new Choice();
		sel.add("");
		
		add(sel);
		add(tt);

		sel.setBounds(100,100,100,32);
		tt.setBounds(100,130,300,200);

		sel.addItemListener(this);
		
		setSize(950,600);
		show();
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cnc=DriverManager.getConnection("jdbc:odbc:stud");
			Statement sm=cnc.createStatement();
			ResultSet rst=sm.executeQuery("Select roll from stud");
			String p;
			while(rst.next())
			{
				p=rst.getString(1);
				sel.add(p);
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
		String x=sel.getSelectedItem();
		String y="";
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cnc=DriverManager.getConnection("jdbc:odbc:stud");
			Statement sm=cnc.createStatement();
			ResultSet rst=sm.executeQuery("Select * from stud where roll='"+x+"'");
			String p,q,r;
			while(rst.next())
			{
				p=rst.getString(1);
				q=rst.getString(2);
				r=rst.getString(3);
				y=y+"\nName : "+p;
				y=y+"\nRoll number : "+q;
				y=y+"\nMarks : "+r;
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
		stud_details sd=new stud_details();
		sd.sets();
		sd.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
}