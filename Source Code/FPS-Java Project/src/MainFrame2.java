import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class MainFrame2 extends JFrame {

	private JPanel contentPane;
	private JTextField getus;
	private JPasswordField pwdPass;
	
	String user;
	String password;

	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 */
	boolean verify() {
		user=getus.getText();
		
		if(user.equalsIgnoreCase(""))
		{
			JOptionPane.showMessageDialog(null,"Invalid Username!!");
			getus.requestFocusInWindow();
			getus.setText("");
		    user="";
		    return false;
		}
		password=pwdPass.getText();
		if(password.equalsIgnoreCase(""))
		{
			JOptionPane.showMessageDialog(null,"Invalid Password!!");
			pwdPass.requestFocusInWindow();
			pwdPass.setText("");
			password="";
		    return false;
		}
		try {
			Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/fps?autoReconnect=true&useSSL=false","root","tiger");
			String sql1="Select * from Loginusers where Username=? and Password=?";
			PreparedStatement pst3=con1.prepareStatement(sql1); 
			pst3.setString(1,user);
			pst3.setString(2,password);
			ResultSet rs=pst3.executeQuery();
			if(!rs.next()) {
				JOptionPane.showMessageDialog(null,"Invalid Username or Password!");
				return false;
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	private void getMainFrame() {
		MainFrame m=new MainFrame();
		m.setVisible(true);
		this.setVisible(false);
	}
	
	private void getMainFrame3() {
		MainFrame3 m=new MainFrame3();
		m.setVisible(true);
		this.setVisible(false);
	}
	
	public MainFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 70, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFpsIcon = new JLabel("fps icon");
		lblFpsIcon.setIcon(new ImageIcon("E:\\downloads\\fps2.png"));
		lblFpsIcon.setBounds(143, 28, 198, 194);
		contentPane.add(lblFpsIcon);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLogin.setBounds(170, 220, 145, 48);
		contentPane.add(lblLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblUsername.setBounds(0, 279, 173, 42);
		contentPane.add(lblUsername);
		
		getus = new JTextField();
		getus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getus.setBounds(180, 279, 272, 42);
		contentPane.add(getus);
		getus.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPassword.setBounds(0, 332, 173, 42);
		contentPane.add(lblPassword);
		
		pwdPass = new JPasswordField();
		pwdPass.setEchoChar('*');
		pwdPass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pwdPass.setBounds(180, 332, 272, 42);
		contentPane.add(pwdPass);
		
		JButton btnNewButton = new JButton("Sign in");
		btnNewButton.setBounds(50, 433, 173, 42);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(new Color(204, 204, 204));
		contentPane.add(btnNewButton);
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.setBounds(268, 433, 173, 42);
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSignup.setForeground(Color.BLUE);
		btnSignup.setBackground(new Color(204, 204, 204));
		contentPane.add(btnSignup);
		
		JCheckBox chckbxSpass = new JCheckBox("Show password");
		chckbxSpass.setForeground(new Color(255, 0, 0));
		chckbxSpass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxSpass.setBounds(151, 384, 135, 23);
		contentPane.add(chckbxSpass);
		
		btnSignup.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				getMainFrame3();
			}
				});
		
		chckbxSpass.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(chckbxSpass.isSelected()) {
					pwdPass.setEchoChar((char)0);
				}
				else {
					pwdPass.setEchoChar('*');
				}
			}
				});
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
					user=getus.getText();
					password=pwdPass.getText();
					if((user.equals("admin") && password.equals("admin")) || (verify()) ){
						getMainFrame();
					}
			}
				}); 
		
		JButton btnForgotPassword = new JButton("Forgot Password");
		btnForgotPassword.setBounds(170, 486, 153, 31);
		btnForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnForgotPassword.setForeground(new Color(255, 0, 0));
		btnForgotPassword.setBackground(new Color(204, 204, 204));
		contentPane.add(btnForgotPassword);
		
		btnForgotPassword.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String aadhar;
					aadhar=JOptionPane.showInputDialog("Please enter your AadharId");
					if(aadhar.equalsIgnoreCase("")){
						JOptionPane.showMessageDialog(null,"Invalid id");
					}
					try {
						Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/fps?autoReconnect=true&useSSL=false","root","tiger");
						String sql1="Select * from Loginusers where AadharId=?";
						PreparedStatement pst3=con1.prepareStatement(sql1); 
						pst3.setString(1,aadhar);
						ResultSet rs=pst3.executeQuery();
						if(!rs.next()) {
							JOptionPane.showMessageDialog(null,"Aadhar Id not in the database. Please sign up");
							
						}
						else {
							JOptionPane.showMessageDialog(null,"Username-"+rs.getString("Username")+"\n"+"Password-"+rs.getString("Password"));
						}

					}
					catch(Exception e1)
					{
						e1.printStackTrace();
					}
			}
				}); 
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setForeground(new Color(240, 255, 240));
		btnNewButton_1.setBounds(409, 11, 65, 55);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, 
						   "Are you sure you want to exit?",null, JOptionPane.YES_NO_OPTION);
						if(result == JOptionPane.YES_OPTION) {

							System.exit(0); 
						} 
				
			}
				}); 
		
		JLabel lblBk = new JLabel("bk");
		lblBk.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\newshop.jpg"));
		lblBk.setBounds(0, 0, 504, 573);
		contentPane.add(lblBk);
		

		

		

	}
}
