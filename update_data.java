// Database connectivity with MySql
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class update_data extends Frame implements ActionListener
{
	TextArea tt;
	Button show;
	public void sets()
	{
		setLayout(null);
		show=new Button("Show");
		tt=new TextArea();
		
		add(show);
		add(tt);

		show.addActionListener(this);
		
		show.setBounds(100,100,72,32);
		tt.setBounds(175,100,300,300);

		setSize(950,670);
		show();
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==show)
		{
			try
			{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cnc=DriverManager.getConnection("jdbc:odbc:update1");
			Statement sm=cnc.createStatement();
			String a,b,w="";
				ResultSet rst=sm.executeQuery("Select * from  table1");
				int x=0;
				while(rst.next())
				{
					a=rst.getString(1);
					b=rst.getString(2);

					// Update data in database
					int p;
					p=Integer.parseInt(b);
					p=(p*5)/100+p;
					b=""+p;
					Statement sm2=cnc.createStatement();
					sm2.executeUpdate("Update table1 set sal='"+b+"' where name='"+a+"' ");
					
					w=w+"Name : "+a;
					w=w+"\nSalary : "+b+"\n\n";
					
					x=1;
				}
				tt.setText(w);
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
	}
	public static void main(String args[])
	{
		update_data ud=new update_data();
		ud.sets();
		ud.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
}