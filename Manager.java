

import java.awt.Color;

//import static SmsManager.smsDone.*;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.*;

//import com.mysql.jdbc.CallableStatement;



public class Manager extends JFrame
{
	JLabel lsm=new JLabel(new ImageIcon("cooltextsmsmanager.png"));
	JLabel lmsg=new JLabel("Message");
	JLabel lsel=new JLabel("Selected Mobile No.");	
	JLabel lcat=new JLabel("Category");
	JLabel lname=new JLabel("Name");
	JLabel lmob=new JLabel("Mobile no.");
	
	JLabel logolb=new JLabel();
	JLabel lb=new JLabel("Label");
	
	JPanel pnl;
	JPanel logopnl;
	
	JComboBox cate;
	
	JList name,mobno;
	
	JTextField txtsel=new JTextField("");
	
	JButton bpro;
	JButton bsend=new JButton("Send");
	
	JTextArea tmsg=new JTextArea("");
	
	Border brdr;
	
	PreparedStatement pst;
	
	Connection con;
	
	
	Manager()
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
		
		
		pnl=new JPanel();
		pnl.setLayout(null);
		pnl.setBounds(20,20,600,550);
		pnl.setBackground(Color.gray);
		brdr=BorderFactory.createLineBorder(Color.black);
		pnl.setBorder(brdr);
		add(pnl);
		
		pnl.add(lsm);
		lsm.setBounds(20,10,550,100);
		
		lcat.setBounds(50,100,100,50);
		pnl.add(lcat);
		
		lname.setBounds(20,130,80,50);
		pnl.add(lname);
		
		lmob.setBounds(140,130,100,50);
		pnl.add(lmob);
	
		
		String []lcat={"Friends","Family","Others"};
		
		cate=new JComboBox(lcat);
		cate.setBounds(120,120,80,20);
		
		name=new JList ();
		name.setBounds(20,160,100,20);
		
		mobno=new JList();
		mobno.setBounds(140,160,100,20);
		
		 JScrollPane scrollname=new JScrollPane(name);
		 scrollname.setBounds(20,160,100,40);
	   	 pnl.add(scrollname);
		
	   	 JScrollPane scrollmobno=new JScrollPane(mobno);
		 scrollmobno.setBounds(140,160,100,40);
	   	 pnl.add(scrollmobno);
		
		
		
		cate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				DefaultListModel model=new DefaultListModel();
				DefaultListModel model1=new DefaultListModel();
				try
				{
					pst=con.prepareStatement("select sname , mobileno from contactbook where category=?");
					pst.setString(1, cate.getSelectedItem().toString());
					
					ResultSet rs=pst.executeQuery(); 
					while(rs.next())
					{
						String s=rs.getString("sname");
						model.addElement(s);
						String s1=rs.getString("mobileno");
						model1.addElement(s1);
					}
					name.setModel(model);
					mobno.setModel(model1);
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
				
		
			name.addListSelectionListener(new ListSelectionListener()
		  {	
				public void valueChanged(ListSelectionEvent e) 
		  		{
			  		int indx=name.getSelectedIndex();
					mobno.setSelectedIndex(indx);
		  		}
			});
		
			mobno.addListSelectionListener(new ListSelectionListener()
			{
				public void valueChanged(ListSelectionEvent e)
				{
					int indx=mobno.getSelectedIndex();
					name.setSelectedIndex(indx);
					String lng=mobno.getSelectedValue().toString();
					txtsel.setText(lng);
					
				}
			});
			
		 pnl.add(cate);
		 pnl.add(name);
		 pnl.add(mobno);
		 
		
		 // Button Proceed************************************
		 
		 bpro=new JButton("Proceed");
		 bpro.setBounds(100,210,120,20);
		 add(bpro);
		 pnl.add(bpro);
		 
		 bpro.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0) {
				int x[]=name.getSelectedIndices();
				mobno.setSelectedIndices(x);
				Object[] o1 = mobno.getSelectedValues();
				String s=new String();
				for(Object itm2:o1)
				{
					s=s+itm2.toString()+",";
				}
				txtsel.setText(s);
				}
			});
			
				 
		 //  Send Button************************************
		 
		 bsend.setBounds(100,500,120,20);
		 pnl.add(bsend);
			
		
		     
		 bsend.addActionListener(new ActionListener() 
		 {
			public void actionPerformed(ActionEvent arg0)
			 {
				//bceSunSoftSend("sunsoft123","sunsoft123","txtsel.getText()","tmsg.getText()","SUNSFT");
			   // for(Object itm:o)
				
				String ms=	smsDone.bceSunSoftSend("sunsoft123","sunsoft123",txtsel.getText(),tmsg.getText(),"SUNSFT");
				
				if(ms.indexOf("font")!=-1)
				{
					Object nms[]=name.getSelectedValues();
					Object mobs[]=mobno.getSelectedValues();
					
					
					for(int i=0;i<nms.length;i++)
					{
						String nm=(String)nms[i];
						String mob=(String)mobs[i];
				
			    {
			    	try
			    	{
			    		pst=con.prepareStatement("select * from contactbook where sname=?");
			    		pst.setString(1, name.getSelectedValue().toString());
			    		ResultSet rs=pst.executeQuery();
			    		Calendar calendar = Calendar.getInstance();
			    		java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
			    		 
			    		if(rs.next())
			    		{
			    			pst=con.prepareStatement("insert  into history values(?,?,?,?)");
			    			pst.setString(1, name.getSelectedValue().toString());
			    			pst.setString(2, rs.getString("mobileno"));
			    			pst.setString(3, tmsg.getText());
			    			pst.setTimestamp(4, ourJavaTimestampObject);
			    			 
			    			int r=pst.executeUpdate();
			    			if(r!=0)
			    				JOptionPane.showMessageDialog(null,"Record Saved in history..");
			    			else
			    				JOptionPane.showMessageDialog(null,"Record not saved in history");
			    		}
			    	}
			    	catch(Exception e2)
			    	{
			    		e2.printStackTrace();
			    	}
			    }
					}
				}
					
			    else
					JOptionPane.showMessageDialog(null, "Internet not connected....");
		 } 
	});
		 
		 
		 
		lsel.setBounds(20,250,150,20);
		add(lsel);
		pnl.add(lsel);
		
		txtsel.setBounds(140,250,200,20);
		pnl.add(txtsel);
		
		lmsg.setBounds(20,280,100,20);
		pnl.add(lmsg);
		
		tmsg.setBounds(140,280,200,200);
		pnl.add(tmsg);
		
		JScrollPane scrollmsg=new JScrollPane(tmsg);
		scrollmsg.setBounds(140,280,200,200);
		pnl.add(scrollmsg);
		
		 logopnl=new JPanel();
		 logopnl.setLayout(null);
		 logopnl.setBounds(650,20,700,850);
		 logopnl.setBackground(Color.gray);
		 brdr=BorderFactory.createLineBorder(Color.black);
		 logopnl.setBorder(brdr);
		 add(logopnl);
		  
		 logolb=new JLabel(new ImageIcon("cooltextapplogo.png"));
		 logolb.setBounds(20,20,650,750);
		 logopnl.add(logolb);
		 
		 lb.setBounds(20,20,100,20);
		 logopnl.add(lb);
		 
		/* pnl=new JPanel();
			pnl.setLayout(null);
			pnl.setBounds(20,20,600,550);
			pnl.setBackground(Color.gray);
			brdr=BorderFactory.createLineBorder(Color.black);
			pnl.setBorder(brdr);
			add(pnl);
			
		*/
		setVisible(true);
		setSize(1000,900);
		
	}
	
	public static void main(String[] args) 
	{
	
		new Manager();
	}

}
