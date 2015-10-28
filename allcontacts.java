package mainpage;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class allcontacts extends JFrame
{
	
	JPanel pnl1=new JPanel();
	JPanel logopnl=new JPanel();
	JPanel picpnl=new JPanel();
	JButton btn1=new JButton("All Contacts");
	JLabel lb1=new JLabel(new ImageIcon("cooltextallcontacts.png"));
	
	JLabel logolb=new JLabel();
		
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs;
			
		allcontacts()
		{
			
			
			try
			{
				}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Container c=getContentPane();
			c.setLayout(null);

			pnl1.setLayout(null);
			pnl1.setBorder(BorderFactory.createLineBorder(Color.black));
			pnl1.setBounds(0,0,700,700);
			pnl1.setBackground(Color.gray);
		    c.add(pnl1);
			 
			 
			 lb1.setBounds(10, 10, 650, 150);
			 pnl1.add(lb1);
				
			 btn1.setBounds(270, 250, 120, 30);
			 pnl1.add(btn1);
			 
			 logopnl.setLayout(null);
			 logopnl.setBorder(BorderFactory.createLineBorder(Color.black));
			 logopnl.setBounds(700,0,680,700);
			 logopnl.setBackground(Color.black);
			 c.add(logopnl);
			 
			 
			 logolb=new JLabel(new ImageIcon("cooltextapplogo.png"));
			 logopnl.add(logolb);
			 logolb.setBounds(0,0,650,700);
			 
			 	
		///////////////////////////////////////////////////////////////////////////////
				
				
				
				btn1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0)
					{
						try
						{
							
							Class.forName("com.mysql.jdbc.Driver");
							con=DriverManager.getConnection("jdbc:mysql://localhost:3309/sms","root","bce");
						
						  String sql = "Select * from contactbook";
						    pstmt = con.prepareStatement(sql);
						    rs = pstmt.executeQuery();
						   ResultSetMetaData md = rs.getMetaData();
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
						   pstmt.close();
						   JTable table = new JTable(data, columnNames);
						   table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						   table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
						   
						   JScrollPane scrollPane = new JScrollPane( table );
						   table.setBackground(Color.gray);
						   table.setSelectionBackground(Color.white);
						  
						   Container c=getContentPane();
						   JPanel pnl=new JPanel();
						   setLayout(null);
						   
						   add(pnl);
						   
						  add( scrollPane );
						   scrollPane.setBounds(20, 300, 550, 200);
						   
						  
					}
						   catch(Exception ex)
						   {
							   ex.printStackTrace();
						   }
					}
						
						   
				});
				
				
				
				setBackground(Color.gray);
				setTitle("ALL CONTACTS");
				setVisible(true);
				setSize(1380, 700);
			
			
				
}
				public static void main(String[] args)
				{
					new allcontacts();
				}

}
