package mainpage;


import java.awt.Color;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class contacts extends JFrame
{
	JPanel p1,p2,p3,p4,p5;
	
	JLabel lc,ln,lmob,ldob,ladd,lcity,lod;
	JLabel lpic=new JLabel(new ImageIcon("cooltextcontactbook.png"));
	JLabel lapplogo=new JLabel(new ImageIcon("cooltextapplogo.png"));
	
	JComboBox cc,cd,cm,cy;
	
	JTextField tn,tm,tc;
	
	JButton n,a,s,m,e,cl;
	
	PreparedStatement pst;
	
	Connection con;
	
	JTextArea tadd,tod;
	
	JScrollPane sr;
	
	String cat[]={"Family","Friends","Others"};
	
	String date[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16",
			"17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	
	String mth[]={"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
	
	String yr[]={"1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004",
			"2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019",
			"2020","2021","2022","2023","2024","2025","2026","2027"};
	
	
	contacts()
	
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
		
//*****************************************************************************************************		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		c.setLayout(null);
		
//*******************  Features Panel  ****************************************************************	
		p1=new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.gray);
		p1.setBorder(BorderFactory.createLineBorder(Color.black));
		p1.setBounds(30, 250, 350, 310);
		c.add(p1);
		
//*******************  Button Panel    *****************************************************************		
		
		p2=new JPanel();
		p2.setLayout(null);
		p2.setBackground(Color.gray);
		p2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		p2.setBounds(400, 250, 150, 300);
		c.add(p2);
		
//*******************  Contact Pic Panel   *************************************************************	
		
		p3=new JPanel();
		p3.setLayout(null);
		p3.setBackground(Color.black);
		p3.setBorder(BorderFactory.createLineBorder(Color.black));
		p3.setBounds(30, 10, 520, 90);
		c.add(p3);
		
//******************  APP logo panel      *************************************************************		
		
		p4=new JPanel();
		p4.setLayout(null);
		p4.setBackground(Color.black);
		p4.setBorder(BorderFactory.createLineBorder(Color.black));
		p4.setBounds(700, 10, 690, 700);
		c.add(p4);

//*****************  Background color     ************************************************************
		
		p5=new JPanel();
		p5.setLayout(null);
		p5.setBackground(Color.gray);
		p5.setBorder(BorderFactory.createLineBorder(Color.black));
		p5.setBounds(0, 0, 1380, 700);
		c.add(p5);
		
//****************************************************************************
		
		n=new JButton("New");
		a=new JButton("Add");
		s=new JButton("Search");
		m=new JButton("Modify");
		e=new JButton("Exit");
		cl=new JButton("Delete");
		n.setBounds(30, 40, 90, 25);p2.add(n);
		a.setBounds(30, 75, 90, 25);p2.add(a);
		s.setBounds(30, 110, 90, 25);p2.add(s);
		m.setBounds(30, 145, 90, 25);p2.add(m);
		cl.setBounds(30, 180, 90, 25);p2.add(cl);
		e.setBounds(30, 215, 90, 25);p2.add(e);
		
		
//*****************************************************************************
		
		lc=new JLabel("Category");
		ln=new JLabel("Name");
		lmob=new JLabel("Mobile No.");		
		ldob=new JLabel("Birthday");
		lcity=new JLabel("City");
		ladd=new JLabel("Address");
		lod=new JLabel("Other Details");
		
		lc.setBounds(20, 10, 100, 25);p1.add(lc);
		ln.setBounds(20, 45, 100, 25);p1.add(ln);
		lmob.setBounds(20, 80, 100, 25);p1.add(lmob);
		ldob.setBounds(20, 115, 100, 25);p1.add(ldob);
		lcity.setBounds(20, 150, 100, 25);p1.add(lcity);
		ladd.setBounds(20, 185, 100, 25);p1.add(ladd);
		lod.setBounds(20, 240, 100, 25);p1.add(lod);
		
//*******************************************************************************
		
		lpic.setBounds(5,5,500,80);
		p3.add(lpic);
		
		lapplogo.setBounds(0,0,690,700);
		p4.add(lapplogo);
		
//******************************************************************************
		
		cc=new JComboBox(cat);
		cc.setBounds(140, 10, 150, 25);p1.add(cc);
		cd=new JComboBox(date);
		cd.setBounds(140, 115, 40, 25);p1.add(cd);
		cm=new JComboBox(mth);
		cm.setBounds(185, 115, 65, 25);p1.add(cm);
		cy=new JComboBox(yr);
		cy.setBounds(255, 115, 60, 25);p1.add(cy);
		
//***************************************************************************
		
		tn=new JTextField("");
		tm=new JTextField("");
		tc=new JTextField("");
		tadd=new JTextArea("");
		tod=new JTextArea("");
		tn.setBounds(140, 45, 150, 25);p1.add(tn);
		tm.setBounds(140, 80, 150, 25);p1.add(tm);
		tc.setBounds(140, 150, 150, 25);p1.add(tc);
		tadd.setBounds(140, 185, 150, 45);p1.add(tadd);
		tod.setBounds(140, 240, 150, 45);p1.add(tod);
		
		JScrollPane sadd=new JScrollPane(tadd);
		sadd.setBounds(140,185,150,50);
		p1.add(sadd);
		
		JScrollPane sod=new JScrollPane(tod);
		sod.setBounds(140,240,150,50);
		p1.add(sod);
		
		
//**************************************************************************
		
		n.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) 
			{
				tn.setText("");
				tm.setText("");
				tc.setText("");
				tadd.setText("");
				tod.setText("");
				cd.setSelectedIndex(0);
				cm.setSelectedIndex(0);
				cy.setSelectedIndex(0);
				
			}
		});
			
//***************************************************************************
		
		e.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
		
				JOptionPane.showMessageDialog(null, "Are u sure!");
				dispose();
			}
		});
		
//*****************************************************************************
			
			a.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0)
				{						
				try
				{
					
					pst=con.prepareStatement("insert into contactbook values(?,?,?,?,?,?,?)");
					pst.setString(1, cc.getSelectedItem().toString());
					pst.setString(2, tn.getText());
					pst.setString(3, tm.getText());
					String s=cd.getSelectedItem()+"/"+cm.getSelectedItem()+"/"+cy.getSelectedItem();
					pst.setString(4, s);
					pst.setString(5, tc.getText());
					pst.setString(6, tadd.getText());
					pst.setString(7, tod.getText());
					int  r=pst.executeUpdate();
					if(r==1)
					JOptionPane.showMessageDialog(null, "Record Saved");
					else
					JOptionPane.showMessageDialog(null, "Record NOt Saved");
				}
					catch (Exception e)
				{
					e.printStackTrace();
				}
				}		
		});
		
//*********************************************************************************************
			
			
			 s.addActionListener(new ActionListener() 
			  {
				public void actionPerformed(ActionEvent arg0) 
				 {	 
					try
					{
					pst=con.prepareStatement("select * from contactbook where sname=?");
					pst.setString(1,tn.getText());
				    ResultSet rs=pst.executeQuery();
					while(rs.next())
					{
					cc.setSelectedItem(rs.getString("category"));
					tm.setText(rs.getString("mobileno"));						
			/*		cd.setSelectedItem(rs.getString("date"));
					cm.setSelectedItem(rs.getString("month"));
					cy.setSelectedItem(rs.getString("year"));	*/     
				    tadd.setText(rs.getString("address"));
					tc.setText(rs.getString("city"));
					tod.setText(rs.getString("otherdetails"));
					
					}
				}
			 
				catch(Exception ex)
				{
					ex.printStackTrace();
					}
		}
});
	
//***********************************************************************************************
			 
	/*		cl.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					try
					{
						pst=con.prepareStatement("delete from contactbook where sname=?");
						//pst.setString(1,tn.getText());
						
							JOptionPane.showMessageDialog(null,"Are u sure!");
							pst.setString(1, cc.setSelectedIndex(0).toString());
							tm.setText("");
							cd.setSelectedIndex(0);
							cm.setSelectedIndex(0);
							cy.setSelectedIndex(0);
							tc.setText("");
							tadd.setText("");
							tod.setText("");
							
							int rs=pst.executeUpdate();
							
					}
						catch(Exception e)
						{
							e.printStackTrace();
						}
				}
			});
			 
		*/	 
			 
			 
	// Modify Button********************************************************************
			 
			 m.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent arg0) 
					{
					         try{	
								//JOptionPane.showMessageDialog(null, "please enter the user id you want to update");	
							    pst=con.prepareStatement("update contactbook set category=?,mobileno=?,city=?,address=?,otherdetails=? where sname=? ");
							    pst.setString(1,tn.getText().toString());
							    pst.setString(2,cc.getSelectedItem().toString());
							    pst.setString(3,tm.getText().toString());
					/*		    pst.setString(3,d.getSelectedItem().toString());
							    pst.setString(4,m.getSelectedItem().toString());
							    pst.setString(5,y.getSelectedItem().toString());				*/
							    pst.setString(4,tadd.getText().toString());
							//    pst.setString(5,cb.getText().toString());
							    pst.setString(5,tc.getText().toString() );
							    pst.setString(6,tod.getText().toString() );

							//    pst.setString(9,nm.getText().toString());
							    
							    int s=pst.executeUpdate();
							    if(s!=0)
							    	JOptionPane.showMessageDialog(null, "Updated");
							    else
							    	JOptionPane.showMessageDialog(null, "Invalid id");
					         }
					         catch(Exception e){e.printStackTrace();}
					}
				});


			 
			 
			 
		setTitle("Contact Book");	 
		setBackground(Color.gray);	 
		setVisible(true);
		setSize(1380, 700);
		
		
	}
		public static void main(String[] args)
			{
				new contacts();
			}
}
