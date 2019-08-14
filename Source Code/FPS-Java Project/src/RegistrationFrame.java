import java.awt.BorderLayout;
import java.util.Date;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.sql.*;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.ibm.icu.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import javax.swing.ImageIcon;

public class RegistrationFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Firstname;
	private JTextField gad;
	private JLabel lblGender;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnOthers;
	ButtonGroup group;
	private JLabel lblNewLabel_2;
	private JLabel lblMobileNo;
	private JTextField gmobno;
	private JLabel lblCity;
	private JTextField Income;
	private JButton btnRegister;
	private JButton btnNewButton;
	private JTextField gcity;
	private JLabel lblLastName;
	private JTextField lname;
	JDateChooser dateChooser;

    Pattern p;
    Matcher m;
    boolean b;
    
    
    String Fname;
    String Lname;
    String space=" ";
    String Fspace;
    String Fullname;
    String aadhar;
    long aid;
    String Date;
    String gender;
    String income;
    long lincome;
    String mobno;
    Date d=new Date();
    long Mobno;
    String city;
    static int count;
    private JLabel lblBk;
    
	
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	
	private void getMainFrame() {
		MainFrame m=new MainFrame();
		m.setVisible(true);
		this.setVisible(false);
	}
	
	private boolean Register() throws SQLException {
		
		int flag=0;
   	 Fname=Firstname.getText();
   	 p = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
   	 m = p.matcher(Fname);
   	 b = m.find();
			if(b || Fname.equalsIgnoreCase(""))
   	     {
				JOptionPane.showMessageDialog(null,"Invalid First Name!!");
				Firstname.requestFocusInWindow();
				Firstname.setText("");
				Fname="";	
				return false;
						
			}
			
		   	 Lname=lname.getText();
		   	 p = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
		   	 m = p.matcher(Lname);
		   	 b = m.find();
					if(b || Lname.equalsIgnoreCase(""))
		   	     {
						JOptionPane.showMessageDialog(null,"Invalid Last Name!!");
						lname.requestFocusInWindow();
						lname.setText("");
						Lname="";	
						return false;
								
					}		
		Fspace=Fname.concat(space);			
		Fullname=Fspace.concat(Lname);
		
		aadhar=gad.getText();
		try
		{
			aid=Long.parseLong(aadhar);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Invalid Aadhar id\nOnly Numerical values!!");
			gad.requestFocus();
			gad.setText("");
			aadhar="";
			return false;
		}
		if(aid<=0)
		{
			JOptionPane.showMessageDialog(null,"Invalid Aadhar id\nOnly Numerical values!!!");
			gad.requestFocus();
			gad.setText("");
			aadhar="";
			return false;
		}
		String Finalaadhar=String.valueOf(aid);
		if(Finalaadhar.length()!=12 )
		{
			JOptionPane.showMessageDialog(null,"Invalid Aadhar id!!");
			gad.requestFocus();
			gad.setText("");
			aadhar="";
			return false;
		}
		
		try {
			Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/fps?autoReconnect=true&useSSL=false","root","tiger");
			String sql1="Select * from Customer where Aadharid=?";
			PreparedStatement pst3=con1.prepareStatement(sql1); 
			pst3.setString(1, Finalaadhar);
			ResultSet rs=pst3.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(null,"Aadhar Id already in the database");
				gad.requestFocus();
				gad.setText("");
				aadhar="";
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		try{
			if(rdbtnMale.isSelected())
			{
				gender="M";
				flag=1;
			}
			if(rdbtnFemale.isSelected())
			{
				gender="F";
				flag=1;
			}
			if(rdbtnOthers.isSelected())
			{
				gender="O";
				flag=1;
			}
			}catch(Exception e)
			{
				System.out.println("Exception caught in gender");
				return false;
			}

		if(flag==0)
		{
			JOptionPane.showMessageDialog(null,"Gender not selected");
			return false;
		}
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date=sdf.format(dateChooser.getDate());
		
			
		income=Income.getText();
		try
		{
			lincome=Long.parseLong(income);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Invalid income");
			Income.requestFocus();
			Income.setText("");
			income="";
			return false;
		}
		if(lincome<0)
		{
			JOptionPane.showMessageDialog(null,"Invalid income");
			Income.requestFocus();
			Income.setText("");
			lincome=0;
			return false;
		}

		
		mobno=gmobno.getText();
		try
		{
			Mobno=Long.parseLong(mobno);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Invalid mobile no.!!");
			gmobno.requestFocus();
			gmobno.setText("");
			mobno="";
			return false;
		}
		if(Mobno<=0)
		{
			JOptionPane.showMessageDialog(null,"Invalid mobile no!!!");
			gmobno.requestFocus();
			gmobno.setText("");
			mobno="";
			return false;
		}
		String Finalmob=String.valueOf(Mobno);
		if(Finalmob.length()!=10 )
		{
			JOptionPane.showMessageDialog(null,"Invalid Mobile no.!!");
			gmobno.requestFocus();
			gmobno.setText("");
			mobno="";
			return false;
		}
		
		city=gcity.getText();
		
		System.out.println("Name->"+Fullname);
		System.out.println("Aadhar id->"+Finalaadhar);
		System.out.println("Gender->"+gender);	
		System.out.println("Income->"+lincome);
		System.out.println("Mobile no.->"+Mobno);
		System.out.println("City->"+city);

		count++;
		String sql="insert into Customer values(?,?,?,?,?,?)";
		String sql1="insert into Salary values(?,?,?)";
		 try 
     	(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fps?autoReconnect=true&useSSL=false","root","tiger");
         PreparedStatement pst = con.prepareStatement(sql)) {
			 	
	            	pst.setString(1,Finalaadhar);
	            	pst.setString(2,Fullname);
	            	pst.setString(3,gender);
	            	pst.setString(4,Date);
	                pst.setString(5,Finalmob);
	                pst.setString(6,city);
	                System.out.println("before execution");
	                pst.executeUpdate();
	                
	                

				  System.out.println("Insertion successful");

         

     } catch (SQLException ex){
     	ex.printStackTrace();
     }
		 String status="";
			if(lincome<=10000) {
				status="P1";
			}
			else if(lincome>10000 && lincome<=25000) {
				status="P2";
			}
			else if(lincome>25000) {
				status="P3";
			}
		 try 
	     	(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fps?autoReconnect=true&useSSL=false","root","tiger");
	         PreparedStatement pst = con.prepareStatement(sql1)) {
				 	
		            	pst.setString(1,Finalaadhar);
		            	pst.setLong(2,lincome);
		            	pst.setString(3,status);

		                System.out.println("before execution");
		                pst.executeUpdate();
		                
		                

					  System.out.println("Insertion successful");

	         

	     } catch (SQLException ex){
	     	ex.printStackTrace();
	     }
		return true;
		
		
	}
	
	public RegistrationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 70, 600, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistration = new JLabel("Registration");
		lblRegistration.setForeground(new Color(248, 248, 255));
		lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblRegistration.setOpaque(true);
		lblRegistration.setBackground(new Color(47, 79, 79));
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setBounds(0, 0, 598, 52);
		contentPane.add(lblRegistration);
		
		JLabel lblName = new JLabel("First Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setBounds(22, 75, 118, 32);
		contentPane.add(lblName);

		JLabel lblNewLabel_1 = new JLabel("Aadhaar ID:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(22, 161, 118, 37);
		contentPane.add(lblNewLabel_1);
		
		Firstname = new JTextField();
		Firstname.setFont(new Font("Tahoma", Font.BOLD, 16));
		Firstname.setBounds(150, 76, 311, 32);
		contentPane.add(Firstname);
		Firstname.setColumns(10);
		
		gad = new JTextField();
		gad.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gad.setBounds(150, 165, 311, 31);
		contentPane.add(gad);
		gad.setColumns(10);
		
		lblGender = new JLabel("Gender:");
		lblGender.setForeground(new Color(255, 255, 255));
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGender.setBounds(22, 209, 107, 32);
		contentPane.add(lblGender);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setForeground(new Color(255, 255, 255));
		rdbtnMale.setBackground(new Color(0, 128, 128));
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMale.setBounds(150, 210, 76, 32);
		contentPane.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(0, 128, 128));
		rdbtnFemale.setForeground(new Color(255, 255, 255));
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnFemale.setBounds(229, 210, 95, 32);
		contentPane.add(rdbtnFemale);
		
		rdbtnOthers = new JRadioButton("Others");
		rdbtnOthers.setBackground(new Color(0, 128, 128));
		rdbtnOthers.setForeground(new Color(255, 255, 255));
		rdbtnOthers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnOthers.setBounds(326, 210, 109, 32);
		contentPane.add(rdbtnOthers);
		
		group=new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
		group.add(rdbtnOthers);
		
		lblNewLabel_2 = new JLabel("DOB:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(22, 252, 95, 32);
		contentPane.add(lblNewLabel_2);
		
		lblMobileNo = new JLabel("Mobile no:");
		lblMobileNo.setForeground(new Color(255, 255, 255));
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMobileNo.setBounds(22, 338, 107, 32);
		contentPane.add(lblMobileNo);
		
		gmobno = new JTextField();
		gmobno.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gmobno.setBounds(195, 342, 262, 28);
		contentPane.add(gmobno);
		gmobno.setColumns(10);
		
		lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCity.setForeground(new Color(255, 255, 255));
		lblCity.setBounds(22, 396, 76, 37);
		contentPane.add(lblCity);
		
		gcity = new JTextField();
		gcity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		gcity.setBounds(150, 401, 285, 30);
		contentPane.add(gcity);
		gcity.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(10, 51, 574, 2);
		contentPane.add(separator);
		
		btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(204, 204, 204));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnRegister.setForeground(new Color(255, 0, 0));
		btnRegister.setBounds(83, 464, 125, 46);
		contentPane.add(btnRegister);
		
		btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.setForeground(new Color(51, 204, 51));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(261, 464, 118, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblIncome = new JLabel("Income:");
		lblIncome.setForeground(Color.WHITE);
		lblIncome.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIncome.setBounds(22, 295, 107, 32);
		contentPane.add(lblIncome);
		
		Income = new JTextField();
		Income.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Income.setBounds(150, 297, 262, 32);
		contentPane.add(Income);
		Income.setColumns(10);
	
		
		lblLastName = new JLabel("Last Name:");
		lblLastName.setForeground(new Color(248, 248, 255));
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLastName.setBounds(22, 118, 118, 32);
		contentPane.add(lblLastName);
		
		lname = new JTextField();
		lname.setFont(new Font("Tahoma", Font.BOLD, 16));
		lname.setBounds(150, 122, 311, 32);
		contentPane.add(lname);
		lname.setColumns(10);
		
		JLabel label = new JLabel("+91");
		label.setBackground(Color.WHITE);
		label.setOpaque(true);
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(150, 341, 35, 28);
		contentPane.add(label);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(150, 252, 134, 32);
		contentPane.add(dateChooser);
		
		lblBk = new JLabel("bk");
		lblBk.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\newshop.jpg"));
		lblBk.setBounds(0, 51, 598, 525);
		contentPane.add(lblBk);
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				getMainFrame();									 
			}
				}); 

		btnRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					if(Register())
					{
						JOptionPane.showMessageDialog(null,"Data Registered Successfully.");
						getMainFrame();
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
				}); 
	}
}
