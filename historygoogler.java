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

public class historygoogler extends JFrame
{
	

	JPanel pnl1=new  JPanel();
	JPanel logopnl=new JPanel();
	
	JLabel lb1=new JLabel(),lb2=new JLabel("Message  :"),lb3=new JLabel("Date/Time  :"),lb4=new JLabel("Category  :");
	JLabel logolb=new JLabel(new ImageIcon("cooltextapplogo.png"));
	
	JButton btn1=new JButton("Googler"),btn2=new JButton("Find"),btn3=new JButton("Find");
   
	JTextField txt1=new JTextField();
    
	JComboBox cb1=new JComboBox(),cb2=new JComboBox();
    
	Connection con;
    PreparedStatement pst;
    ResultSet rs;
    JTable tbl1;
    JScrollPane s1;
    Font font;
    
    
    historygoogler()
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
	add(pnl1);
	pnl1.setBorder(BorderFactory.createTitledBorder(""));
	pnl1.setSize(690,700);
	pnl1.setLocation(0, 0);
	 pnl1.setBackground(Color.gray);
         
	 c.add(pnl1);
	 
	 logopnl=new JPanel();
	 logopnl.setLayout(null);
	 logopnl.setBounds(690,0,690,700);
	 logopnl.setBackground(Color.gray);
	 add(logopnl);
	  
	 logolb.setBounds(10,10,650,650); 
	 logopnl.add(logolb);

	 
      cb1.setBounds(260, 139, 130, 30);
	  cb1.setEditable(true);
	 
	 
	  cb2=new JComboBox();
      String []cat={"Friends","Relatives","Others"};
      cb2=new JComboBox(cat);
      cb2.insertItemAt("Category", 0);
      cb2.setSelectedIndex(0);
	 
	 txt1.setBounds(260, 200, 130, 30);
	 cb2.setBounds(260, 260, 130, 30);
	 
	 btn1.setBounds(430, 140, 120, 30);
	 btn2.setBounds(430, 200, 120, 30);
	 btn3.setBounds(430, 260, 120, 30);
	 
	 
	 lb1=new JLabel(new ImageIcon("cooltexthistorygoogler.png"));
	 lb1.setBounds(0,20,600,100);
	 
	 lb2.setBounds(120, 140, 120, 30);
	 
	 lb3.setBounds(100, 200, 120, 30);
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
	 pnl1.add(cb2);
	 pnl1.add(btn1);
	 pnl1.add(btn2);
	 pnl1.add(btn3);
	 
	 
		
		
		////////////coding/////////////////////////////////////
		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
			try
			{
				pst=con.prepareStatement("select * from history where message like  ?");
	
					pst.setString(1, "%"+cb1.getSelectedItem().toString()+"%");
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
	////////////////////////////////////////////////////////////////////////////////////////			
		btn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
			try {
				pst=con.prepareStatement("select * from history where date&time like  ?");
			
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
					   
					   s1.setBounds(10, 350, 610, 100);
					   
					   }
						catch(Exception ex){ex.printStackTrace();}
				      }
			
		});
	/////////////////////////////////////////////////////////////////////////////////
		btn3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
			try 
			{
				pst=con.prepareStatement("select * from history where category=?");
				pst.setString(1, cb2.getSelectedItem().toString());
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
				
		
		setTitle("HISTORY GOOGLER");
		setVisible(true);
		setSize(1380,700);

     }

 	public static void main (String[] args)
 	{
 		new historygoogler();
 		
 	}
}
