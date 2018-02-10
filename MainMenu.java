import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainMenu extends Frame implements ActionListener
{
	Button reg,detail,fee,book,marks,view,exit,about;
	/*ImageIcon ic=new ImageIcon("apply_now.jpg");
	JLabel jl2=new JLabel("apply_now",ic,JLabel.RIGHT);*/
	public void sets()
	{
		setLayout(null);
		setFont(new Font("SansSerif",Font.BOLD,12));
		Label title=new Label("Main Menu",Label.RIGHT);
		
		reg=new Button("Registration");
		detail=new Button("Details");
		fee=new Button("Fee");
		book=new Button("Books");
		marks=new Button("Marks");
		view=new Button("View");
		exit=new Button("Exit");
		about=new Button("About Us");

		Font f1=new Font("SansSerif",Font.BOLD,22);
		title.setFont(f1);
		
		// add items to Frame Window
		add(title);
		add(reg);
		add(detail);
		add(fee);
		add(book);
		add(marks);
		add(view);
		add(exit);
		add(about);
		//add(jl2);

		//Set position
		title.setBounds(370,30,150,42);
		reg.setBounds(200,220,150,42);
		detail.setBounds(200,260,150,42);
		fee.setBounds(200,300,150,42);
		book.setBounds(200,340,150,42);
		marks.setBounds(200,380,150,42);
		view.setBounds(200,420,150,42);
		exit.setBounds(200,460,150,42);
		about.setBounds(1000,600,150,42);
		//jl2.setBounds(450,200,500,500);

		reg.addActionListener(this);
		detail.addActionListener(this);
		fee.addActionListener(this);
		book.addActionListener(this);
		marks.addActionListener(this);
		view.addActionListener(this);
		exit.addActionListener(this);
		about.addActionListener(this);

		setSize(1366,730);
		show();
	}
	public void paint(Graphics g)
	{
		Image pic=Toolkit.getDefaultToolkit().getImage("apply_now.jpg");
		if(pic!=null)
		g.drawImage(pic,450,120,this);
	}
	public void actionPerformed(ActionEvent ae)
	{
		// Link to Registration page
		if(ae.getSource()==reg)
		{
			setVisible(false);
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
		// Link to details page
		if(ae.getSource()==detail)
		{
			setVisible(false);
			details d1=new details();
			d1.sets();
			d1.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});
		}
		// Link to charges page
		if(ae.getSource()==fee)
		{
			setVisible(false);
			Charges c1=new Charges();
			c1.sets();
			c1.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});
		}
		// Link to Books page
		if(ae.getSource()==book)
		{
			setVisible(false);
			Books b1=new Books();
			b1.sets();
			b1.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});
		}
		// Link to Marks page
		if(ae.getSource()==marks)
		{
			setVisible(false);
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
		//Link to view Page
		if(ae.getSource()==view)
		{
			setVisible(false);
			View v=new View();
			v.sets();
			v.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});
		}
		// Exit button
		if(ae.getSource()==exit)
		{
			System.exit(0);
		}
		//Link to about page
		if(ae.getSource()==about)
		{
			setVisible(false);
			about a1=new about();
			a1.sets();
			a1.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			});
		}
	}
	public static void main(String args[])
	{
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