import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.sql.*;
import java.util.*;
import javax.swing.table.*;
class View extends JFrame implements ActionListener,ItemListener
{
	Button back;
	CheckboxGroup cbg;
	javax.swing.JTable text;
	Checkbox reg,details,fee,books,marks;
	JLabel xl;
	JLabel x2;
	JLabel x3;
	JLabel x4;
	JLabel x5;
	Container cc=getContentPane();
	public void sets()
	{
		cc.setLayout(null);
		back=new Button("Back");
		cbg=new CheckboxGroup();
		cc.add(back);
		reg=new Checkbox("Registration",cbg,false);
		cc.add(reg);
		details=new Checkbox("Details",cbg,false);
		cc.add(details);
		fee=new Checkbox("Fee",cbg,false);
		cc.add(fee);
		books=new Checkbox("Books",cbg,false);
		cc.add(books);
		marks=new Checkbox("Marks",cbg,false);
		cc.add(marks);
		
		back.setBounds(50,95,72,32);
		reg.setBounds(150,100,100,22);
		details.setBounds(260,100,80,22);
		fee.setBounds(350,100,60,22);
		books.setBounds(420,100,60,22);
		marks.setBounds(490,100,60,22);

		back.addActionListener(this);
		reg.addItemListener(this);
		details.addItemListener(this);
		fee.addItemListener(this);
		books.addItemListener(this);
		marks.addItemListener(this);

		Font f1=new Font("SansSerif",Font.BOLD,12);
		back.setFont(f1);
		reg.setFont(f1);
		details.setFont(f1);
		fee.setFont(f1);
		books.setFont(f1);
		marks.setFont(f1);
		
		setSize(1000,720);
		this.setVisible(true);
		this.validate();
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
	}
	public void itemStateChanged(ItemEvent ie)
	{
		reg.setEnabled(false);
		details.setEnabled(false);
		fee.setEnabled(false);
		books.setEnabled(false);
		marks.setEnabled(false);
		text=null;
		String x=cbg.getSelectedCheckbox().getLabel();
		if(x.equals("Registration"))
		{
			// Adding a grid of data in the page.
			cc.setLayout(null);
			Label xl;
			Vector columnNames=new Vector();
			Vector data=new Vector();
			
			//super("VIEWING DATA");
			xl=new Label("");
			cc.setLayout(null);
			resize(1000,720);
			cc.add(xl);
			xl.setBounds(100,100,100,100);
			//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:register");
				String sql="Select * from register";
				Statement stat=con.createStatement();
				ResultSet rs=stat.executeQuery(sql);
				ResultSetMetaData md=rs.getMetaData();
				int columns=md.getColumnCount();
				for(int i=1;i<=columns;i++)
				{
					columnNames.addElement(md.getColumnName(i));
				}
				while(rs.next())
				{
					Vector row=new Vector(columns);
					for(int i=1;i<=columns;i++)
					{
						row.addElement(rs.getObject(i));
					}
					data.addElement(row);
				}
				rs.close();
				stat.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			text=new javax.swing.JTable(data,columnNames);
			text.setBounds(100,200,600,200);
			TableColumn col;
			for(int i=0;i<text.getColumnCount();i++)
			{
				col=text.getColumnModel().getColumn(i);
				col.setMaxWidth(300);
			}
			javax.swing.JScrollPane scrollPane=new javax.swing.JScrollPane(text);
			cc.add(scrollPane);
			scrollPane.setBounds(100,200,600,200);
			//JOptionPane.showMessageDialog(null,"Student Details ok");
			this.setVisible(true);
			this.validate();
		}
		if(x.equals("Details"))
		{
			cc.setLayout(null);
			Label x2;
			Vector columnNames=new Vector();
			Vector data=new Vector();
			

			//super("VIEWING DATA");
			x2=new Label("");
			cc.setLayout(null);
			resize(1000,720);
			cc.add(x2);
			x2.setBounds(100,100,100,100);
			//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:stud_details");
				String sql="Select * from details";
				Statement stat=con.createStatement();
				ResultSet rs=stat.executeQuery(sql);
				ResultSetMetaData md=rs.getMetaData();
				int columns=md.getColumnCount();
				for(int i=1;i<=columns;i++)
				{
					columnNames.addElement(md.getColumnName(i));
				}
				while(rs.next())
				{
					Vector row=new Vector(columns);
					for(int i=1;i<=columns;i++)
					{
						row.addElement(rs.getObject(i));
					}
					data.addElement(row);
				}
				rs.close();
				stat.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			text=new javax.swing.JTable(data,columnNames);
			text.setBounds(100,200,600,200);
			TableColumn col;
			for(int i=0;i<text.getColumnCount();i++)
			{
				col=text.getColumnModel().getColumn(i);
				col.setMaxWidth(300);
			}
			javax.swing.JScrollPane scrollPane=new javax.swing.JScrollPane(text);
			cc.add(scrollPane);
			scrollPane.setBounds(100,200,600,200);
			//JOptionPane.showMessageDialog(null,"Student Details ok");
			this.setVisible(true);
			this.validate();
		}
		if(x.equals("Fee"))
		{
			cc.setLayout(null);
			Label x3;
			Vector columnNames=new Vector();
			Vector data=new Vector();
			

			//super("VIEWING DATA");
			x3=new Label("");
			cc.setLayout(null);
			resize(1000,720);
			cc.add(x3);
			x3.setBounds(100,100,100,100);
			//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:Charges");
				String sql="Select * from fee";
				Statement stat=con.createStatement();
				ResultSet rs=stat.executeQuery(sql);
				ResultSetMetaData md=rs.getMetaData();
				int columns=md.getColumnCount();
				for(int i=1;i<=columns;i++)
				{
					columnNames.addElement(md.getColumnName(i));
				}
				while(rs.next())
				{
					Vector row=new Vector(columns);
					for(int i=1;i<=columns;i++)
					{
						row.addElement(rs.getObject(i));
					}
					data.addElement(row);
				}
				rs.close();
				stat.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			text=new javax.swing.JTable(data,columnNames);
			text.setBounds(100,200,600,200);
			TableColumn col;
			for(int i=0;i<text.getColumnCount();i++)
			{
				col=text.getColumnModel().getColumn(i);
				col.setMaxWidth(300);
			}
		javax.swing.JScrollPane scrollPane=new javax.swing.JScrollPane(text);
			cc.add(scrollPane);
			scrollPane.setBounds(100,200,600,200);
			//JOptionPane.showMessageDialog(null,"Student Details ok");
			this.setVisible(true);
			this.validate();
		}
		if(x.equals("Books"))
		{
			cc.setLayout(null);
			Label x4;
			Vector columnNames=new Vector();
			Vector data=new Vector();
			

			//super("VIEWING DATA");
			x4=new Label("");
			cc.setLayout(null);
			resize(1000,720);
			cc.add(x4);
			x4.setBounds(100,100,100,100);
			//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:books");
				String sql="Select * from books";
				Statement stat=con.createStatement();
				ResultSet rs=stat.executeQuery(sql);
				ResultSetMetaData md=rs.getMetaData();
				int columns=md.getColumnCount();
				for(int i=1;i<=columns;i++)
				{
					columnNames.addElement(md.getColumnName(i));
				}
				while(rs.next())
				{
					Vector row=new Vector(columns);
					for(int i=1;i<=columns;i++)
					{
						row.addElement(rs.getObject(i));
					}
					data.addElement(row);
				}
				rs.close();
				stat.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			text=new javax.swing.JTable(data,columnNames);
			text.setBounds(100,200,600,200);
			TableColumn col;
			for(int i=0;i<text.getColumnCount();i++)
			{
				col=text.getColumnModel().getColumn(i);
				col.setMaxWidth(300);
			}
			javax.swing.JScrollPane scrollPane=new javax.swing.JScrollPane(text);
			cc.add(scrollPane);
			scrollPane.setBounds(100,200,600,200);
			//JOptionPane.showMessageDialog(null,"Student Details ok");
			this.setVisible(true);
			this.validate();
		}
		if(x.equals("Marks"))
		{
			cc.setLayout(null);
			Label x5;
			Vector columnNames=new Vector();
			Vector data=new Vector();
			

			//super("VIEWING DATA");
			x5=new Label("");
			cc.setLayout(null);
			resize(1000,720);
			cc.add(x5);
			x5.setBounds(100,100,100,100);
			//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection con=DriverManager.getConnection("jdbc:odbc:marks");
				String sql="Select * from marks";
				Statement stat=con.createStatement();
				ResultSet rs=stat.executeQuery(sql);
				ResultSetMetaData md=rs.getMetaData();
				int columns=md.getColumnCount();
				for(int i=1;i<=columns;i++)
				{
					columnNames.addElement(md.getColumnName(i));
				}
				while(rs.next())
				{
					Vector row=new Vector(columns);
					for(int i=1;i<=columns;i++)
					{
						row.addElement(rs.getObject(i));
					}
					data.addElement(row);
				}
				rs.close();
				stat.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			text=new javax.swing.JTable(data,columnNames);
			text.setBounds(100,200,600,200);
			TableColumn col;
			for(int i=0;i<text.getColumnCount();i++)
			{
				col=text.getColumnModel().getColumn(i);
				col.setMaxWidth(300);
			}
			javax.swing.JScrollPane scrollPane=new javax.swing.JScrollPane(text);
			cc.add(scrollPane);
			scrollPane.setBounds(100,200,600,200);
			//JOptionPane.showMessageDialog(null,"Student Details ok");
			this.setVisible(true);
			this.validate();
		}
	}
	public static void main(String args[])
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		View v1=new View();
		v1.sets();
		v1.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}
}