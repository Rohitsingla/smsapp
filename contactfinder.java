package mainpage;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



public class contactfinder extends JFrame
{

	JPanel pnl1=new  JPanel();
	JPanel pnl2=new JPanel();
	
	JLabel lb1=new JLabel(),lb2=new JLabel("Category  :"),lb3=new JLabel("Name  :"),lb4=new JLabel("Mobile no.  :");
	JLabel lapplogo=new JLabel(new ImageIcon("cooltextapplogo.png"));
	
	JButton btn1=new JButton("Googler"),btn2=new JButton("Find"),btn3=new JButton("Find");
	
    JTextField txt1=new JTextField(),txt2=new JTextField();
    
    JComboBox cb1=new JComboBox();
    
    Connection con;
    
    PreparedStatement pst;
     
    ResultSet rs;
    
    JTable tbl1;
    
    JScrollPane s1;
    
    Font font;
    
    
     contactfinder()
     {

	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3309/sms","root","bce");
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	
	
	Container c=getContentPane();
	c.setLayout(null);

	pnl1.setLayout(null);
	pnl1.setBounds(0,0,730,700);
	pnl1.setBackground(Color.gray);
    c.add(pnl1);
    
    pnl2.setLayout(null);
    pnl2.setBounds(730,0,710,700);
    pnl2.setBackground(Color.GRAY);
    c.add(pnl2);
    
    lapplogo.setBounds(0,0,650,700);
    pnl2.add(lapplogo);
    
	 
    String []cat={"Friends","Relatives","Others"};
    cb1=new JComboBox(cat);
    cb1.insertItemAt("Category", 0);
	 
    cb1.setBounds(260, 139, 130, 30);
	cb1.setSelectedIndex(0);
	 
	txt1.setBounds(260, 200, 130, 30);
	txt2.setBounds(260, 260, 130, 30);
	 
	btn1.setBounds(430, 140, 120, 30);
	btn2.setBounds(430, 200, 120, 30);
	btn3.setBounds(430, 260, 120, 30);
	 
	 
	 
	 
	 lb1=new JLabel(new ImageIcon("cooltextcontactfinder.png"));
	 lb1.setBounds(10, 0, 730,100);
	 
	 
	 lb2.setBounds(120, 140, 120, 30);
	 lb3.setBounds(150, 200, 120, 30);
	 lb4.setBounds(110, 260, 120, 30);
	 
	 font = new Font("Verdana", Font.PLAIN, 18);   
	 lb2.setFont(font);  
     font = new Font("Verdana", Font.PLAIN, 18);   
	 lb3.setFont(font);  
	 font = new Font("Verdana", Font.PLAIN, 18);   
	 lb4.setFont(font);  
		 
	 

	   lb2.setForeground(Color.white);
	   lb3.setForeground(Color.white);
	   lb4.setForeground(Color.white);

	 
	 pnl1.add(lb1);
	 pnl1.add(lb2);
	 pnl1.add(cb1);
	 pnl1.add(lb3);
	 pnl1.add(txt1);
	 pnl1.add(lb4);
	 pnl1.add(txt2);
	 pnl1.add(btn1);
	 pnl1.add(btn2);
	 pnl1.add(btn3);
	 
	 
	
		
	///	/////////	/ coding////////////////////////////////////
	 
		
		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
			try {
				pst=con.prepareStatement("select * from contactbook where category=?");
				//	String sql = "Select * from contactbook where catg=?";
					pst.setString(1, cb1.getSelectedItem().toString());
					//pst=con.prepareStatement(sql);
					rs=pst.executeQuery();
					java.sql.ResultSetMetaData md = rs.getMetaData();
					Vector<String> columnNames = new Vector<String>();
					Vector data = new Vector();

					   int columns = md.getColumnCount();
					   for (int i = 1; i <= columns; i++) {
					   columnNames.addElement( md.getColumnName(i) );
					   }
					   //--------------------------------------------------
					   while (rs.next())
					   {
					   Vector row = new Vector(columns);
					   for (int i = 1; i <= columns; i++)
					       {
					          row.addElement( rs.getObject(i) );
					       }
					   data.addElement( row );
					   }
					   rs.close();
					   pst.close();
					   
					   tbl1=new JTable(data,columnNames);
					   s1=new JScrollPane(tbl1);
					 // JTable table = new JTable(data, columnNames);
					 //  tbl1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					 //  tbl1.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
					   
					 //  JScrollPane scrollPane = new JScrollPane( tbl1 );
					   tbl1.setBackground(Color.gray);
					   tbl1.setSelectionBackground(Color.WHITE);
					  
					   //Container c=getContentPane();
					   //JPanel pnl=new JPanel();
					   setLayout(null);
					   
					   //add(pnl);
					   
					  add( s1);
					   
					   s1.setBounds(10, 350, 610, 100);
					   
					   }
						catch(Exception ex){ex.printStackTrace();}
				      }
			
		});
				
	////////////////////////////////////////////////////////////////////////////////
		
		btn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
			try {
				pst=con.prepareStatement("select * from contactbook where sname like  ?");
				
				//	String sql = "Select * from contactbook where catg=?";
					pst.setString(1, "%"+txt1.getText()+"%");
					//pst=con.prepareStatement(sql);
					rs=pst.executeQuery();
					java.sql.ResultSetMetaData md = rs.getMetaData();
					Vector<String> columnNames = new Vector<String>();
					Vector data = new Vector();

					   int columns = md.getColumnCount();
					   for (int i = 1; i <= columns; i++) {
					   columnNames.addElement( md.getColumnName(i) );
					   }
					   //--------------------------------------------------
					   while (rs.next())
					   {
					   Vector row = new Vector(columns);
					   for (int i = 1; i <= columns; i++)
					       {
					          row.addElement( rs.getObject(i) );
					       }
					   data.addElement( row );
					   }
					   rs.close();
					   pst.close();
					   
					   tbl1=new JTable(data,columnNames);
					   s1=new JScrollPane(tbl1);
					 // JTable table = new JTable(data, columnNames);
					 //  tbl1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					 //  tbl1.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
					   
					 //  JScrollPane scrollPane = new JScrollPane( tbl1 );
					   tbl1.setBackground(Color.gray);
					   tbl1.setSelectionBackground(Color.WHITE);
					  
					   //Container c=getContentPane();
					   //JPanel pnl=new JPanel();
					   setLayout(null);
					   
					   //add(pnl);
					   
					  add( s1);
					   
					   s1.setBounds(10, 350, 610, 200);
					   
					   }
						catch(Exception ex){ex.printStackTrace();}
				      }
			
		});
				
		
		/////////////////////////////////////////////////////////////////////
		
		btn3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
			try {
				pst=con.prepareStatement("select * from contactbook where mobileno like  ?");
				
				//	String sql = "Select * from contactbook where catg=?";
					pst.setString(1, "%"+txt2.getText()+"%");
					//pst=con.prepareStatement(sql);
					rs=pst.executeQuery();
					java.sql.ResultSetMetaData md = rs.getMetaData();
					Vector<String> columnNames = new Vector<String>();
					Vector data = new Vector();

					   int columns = md.getColumnCount();
					   for (int i = 1; i <= columns; i++) {
					   columnNames.addElement( md.getColumnName(i) );
					   }
					   //--------------------------------------------------
					   while (rs.next())
					   {
					   Vector row = new Vector(columns);
					   for (int i = 1; i <= columns; i++)
					       {
					          row.addElement( rs.getObject(i) );
					       }
					   data.addElement( row );
					   }
					   rs.close();
					   pst.close();
					   
					   tbl1=new JTable(data,columnNames);
					   s1=new JScrollPane(tbl1);
					 // JTable table = new JTable(data, columnNames);
					 //  tbl1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					 //  tbl1.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
					   
					 //  JScrollPane scrollPane = new JScrollPane( tbl1 );
					   tbl1.setBackground(Color.gray);
					   tbl1.setSelectionBackground(Color.WHITE);
					  
					   //Container c=getContentPane();
					   //JPanel pnl=new JPanel();
					   setLayout(null);
					   
					   //add(pnl);
					   
					  add( s1);
					   
					   s1.setBounds(10, 350, 610, 200);
					   
					   }
						catch(Exception ex){ex.printStackTrace();}
				      }
			
		});
				
		setTitle("CONTACT FINDER");
		setVisible(true);
		setSize(1380,700);
	 
		
		}


	public static void main (String[] args)
	{
		new contactfinder();
		
	}

	


}
