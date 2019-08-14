import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;

public class MainFrame3 extends JFrame {

	private JPanel contentPane;
	private JTextField Firstname;
	private JTextField gad;
	private JLabel lblGender;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnOthers;
	ButtonGroup group;
	private JButton btnRegister;
	private JButton btnNewButton;
	private JLabel lblLastName;
	private JTextField lname;
	
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
    private JLabel lblUsername;
    private JTextField getuser;
    private JLabel lblPassword;
    private JPasswordField pwdPass;
    private JPasswordField pwdCpass;
    private JLabel lblConfirmPassword;
    Pattern p;
    Matcher m;
    boolean b;
    
    String username;
    String password;
    String cpassword;
    private JLabel label;
    
	/**
	 * Launch the application.
*/

	private void getMainFrame2() {
		MainFrame2 m=new MainFrame2();
		m.setVisible(true);
		this.setVisible(false);
	}
	
	boolean Register() {
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
			
			username=getuser.getText();
			if(username.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null,"Invalid username");
				getuser.requestFocus();
				username="";
				return false;
			}
			if(username.contains(" ")) {
				JOptionPane.showMessageDialog(null,"Username should not contain space");
				getuser.requestFocus();
				username="";
				return false;
			}
			else if(username.length()<5) {
				JOptionPane.showMessageDialog(null,"Username's length should be greater 5 or more than 5");
				getuser.requestFocus();
				username="";
				return false;
			}
			password=pwdPass.getText();
			if(password.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null,"Invalid password");
				pwdPass.requestFocus();
				pwdPass.setText("");
				password="";
				return false;
			}
			if(password.contains(" ")) {
				JOptionPane.showMessageDialog(null,"Password should not contain space");
				pwdPass.requestFocus();
				pwdPass.setText("");
				password="";
				return false;
			}
			else if(password.length()<5) {
				JOptionPane.showMessageDialog(null,"Password's length should be greater 5 or more than 5");
				pwdPass.requestFocus();
				pwdPass.setText("");
				password="";
				return false;
			}
			cpassword=pwdCpass.getText();
			if(cpassword.equalsIgnoreCase("")) {
				JOptionPane.showMessageDialog(null,"Invalid confirmed password");
				pwdCpass.requestFocus();
				pwdCpass.setText("");
				cpassword="";
				return false;
			}
			if(!cpassword.equals(password)) {
				JOptionPane.showMessageDialog(null,"Password unequal");
				pwdCpass.requestFocus();
				pwdCpass.setText("");
				cpassword="";
				return false;
			}
			
			
			int flag=0;
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
			
			try {
				Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/fps?autoReconnect=true&useSSL=false","root","tiger");
				String sql1="insert into Loginusers values(?,?,?,?)";
				PreparedStatement pst3=con1.prepareStatement(sql1); 
				pst3.setString(1,Finalaadhar);
				pst3.setString(2,Fullname);
				pst3.setString(3, username);
				pst3.setString(4, password);
				pst3.executeUpdate();

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		
		return true;}
	/**
	 * Create the frame.
	 */
	public MainFrame3() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 70, 520, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistration = new JLabel("Login Registration");
		lblRegistration.setForeground(new Color(248, 248, 255));
		lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblRegistration.setOpaque(true);
		lblRegistration.setBackground(new Color(47, 79, 79));
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setBounds(0, 1, 504, 52);
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
		lblGender.setBounds(22, 349, 107, 32);
		contentPane.add(lblGender);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setForeground(new Color(255, 255, 255));
		rdbtnMale.setBackground(new Color(0, 128, 128));
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMale.setBounds(150, 350, 76, 32);
		contentPane.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(0, 128, 128));
		rdbtnFemale.setForeground(new Color(255, 255, 255));
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnFemale.setBounds(228, 350, 95, 32);
		contentPane.add(rdbtnFemale);
		
		rdbtnOthers = new JRadioButton("Others");
		rdbtnOthers.setBackground(new Color(0, 128, 128));
		rdbtnOthers.setForeground(new Color(255, 255, 255));
		rdbtnOthers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnOthers.setBounds(325, 350, 109, 32);
		contentPane.add(rdbtnOthers);
		
		group=new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
		group.add(rdbtnOthers);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(10, 51, 574, 2);
		contentPane.add(separator);
		
		btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(204, 204, 204));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnRegister.setForeground(new Color(255, 0, 0));
		btnRegister.setBounds(101, 402, 125, 46);
		contentPane.add(btnRegister);
		
		btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.setForeground(new Color(51, 204, 51));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(253, 402, 118, 46);
		contentPane.add(btnNewButton);
	
		
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
		
		lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(11, 209, 118, 37);
		contentPane.add(lblUsername);
		
		getuser = new JTextField();
		getuser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		getuser.setBounds(150, 207, 311, 32);
		contentPane.add(getuser);
		getuser.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setBounds(22, 257, 107, 32);
		contentPane.add(lblPassword);
		
		pwdPass = new JPasswordField();
		pwdPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pwdPass.setBounds(150, 254, 311, 32);
		contentPane.add(pwdPass);
		
		pwdCpass = new JPasswordField();
		pwdCpass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pwdCpass.setBounds(196, 297, 265, 32);
		contentPane.add(pwdCpass);
		
		lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setForeground(new Color(255, 255, 255));
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPassword.setBounds(22, 297, 164, 37);
		contentPane.add(lblConfirmPassword);
		
		label = new JLabel("New label");
		label.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\newshop.jpg"));
		label.setBounds(0, 1, 504, 500);
		contentPane.add(label);
		
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				getMainFrame2();									 
			}
				}); 

		btnRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					if(Register())
					{
						JOptionPane.showMessageDialog(null,"Login user registered successfully.");
						getMainFrame2();
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} /*catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
				}); 
	}
	}


