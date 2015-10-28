

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JOptionPane;


public class mainpage extends JFrame
{
	JMenuBar menuBar = new JMenuBar();
	JMenu manager = new JMenu("Manager");
	JMenu sms = new JMenu("SMS");
	JMenu history = new JMenu("History");
	JMenu exit=new JMenu("Exit");
	
	JMenuItem contactbook = new JMenuItem("ContactBook");
	JMenuItem allcontacts=new JMenuItem("All Contacts");
	JMenuItem finder= new JMenuItem("Finder");
 
	JMenuItem smsmanager=new JMenuItem("SMS Manager");
	
	JMenuItem all=new JMenuItem("All History");
	JMenuItem googler=new JMenuItem("Googler");
	
	JMenuItem close=new JMenuItem("Close");
	
	mainpage()
	{
		setJMenuBar(menuBar);
		
		menuBar.add(manager);
		menuBar.add(sms);
		menuBar.add(history);
		menuBar.add(exit);
		
		manager.setMnemonic('m');
		sms.setMnemonic('s');
		history.setMnemonic('h');
		exit.setMnemonic('e');
		
		manager.add(contactbook);
		manager.add(allcontacts);
		manager.add(finder);
		
		sms.add(smsmanager);
		
		history.add(all);
		history.add(googler);
		
		exit.add(close);
		
		contactbook.setMnemonic('c');
		contactbook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		contactbook.setToolTipText("to open contactbook");
		contactbook.setBackground(Color.gray);
		contactbook.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
             {	
            	JOptionPane.showMessageDialog(null,"Opening ContactBook");
            	
            	new contacts();
             }
            });
		
		allcontacts.setMnemonic('a');
		allcontacts.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
		allcontacts.setToolTipText("to open data of all contacts");
		allcontacts.setBackground(Color.gray);
		allcontacts.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
             {	
            	JOptionPane.showMessageDialog(null,"Opening Data of all contacts");
            	
            		new allcontacts();
             }
        }	);
		
		finder.setMnemonic('f');
		finder.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));
		finder.setToolTipText("to open details of contact");
		finder.setBackground(Color.gray);
		finder.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
             {	
            	JOptionPane.showMessageDialog(null,"Finding Contact Details");
            	
            	new contactfinder();
             }
        }	);
		
		smsmanager.setMnemonic('n');
		smsmanager.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		smsmanager.setToolTipText("to open sms manager");
		smsmanager.setBackground(Color.gray);
		smsmanager.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
             {	
            	JOptionPane.showMessageDialog(null,"Opening SMS Manager");
            	
            	new Manager();
             }
        }	);
		
		all.setMnemonic('h');
		all.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.CTRL_MASK));
		all.setToolTipText("to open history");
		all.setBackground(Color.gray);
		all.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
             {	
            	JOptionPane.showMessageDialog(null,"Opening History");
            	
            		new contacts();
             }
        }	);
		
		googler.setMnemonic('g');
		googler.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,InputEvent.CTRL_MASK));
		googler.setToolTipText("to open history googler");
		googler.setBackground(Color.gray);
		googler.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
             {	
            	JOptionPane.showConfirmDialog(null,"Opening Googler");
            	
            		new historygoogler();
             }
        }	);
		
		close.setMnemonic('e');
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_MASK));
		close.setToolTipText("to close the page");
		close.setBackground(Color.gray);
		close.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent e)
             {	
            	JOptionPane.showMessageDialog(null,"Are u sure!!!");
            	dispose();
             }
        }	);
		

		
		setVisible(true);
		setSize(1380,700);
		
	}
	
	public static void main(String[] args) 
	{
		mainpage a=new mainpage();

	}

}
