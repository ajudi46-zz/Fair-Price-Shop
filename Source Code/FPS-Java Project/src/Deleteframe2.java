import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;

public class Deleteframe2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtDeleteAadharId;
	private JTextField textField_1;
	private JTextField textField;
	String aadhar;
	/**
	 * Launch the application.
	 */
	public void getaadharid(String ad) {
		aadhar=ad;
	}

	/**
	 * Create the frame.
	 */
	
	
	public void getdelete() {
		Deleteframe df=new Deleteframe();
		df.setVisible(true);
		this.setVisible(false);
	}
	public Deleteframe2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 150);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDeleteAadharId = new JTextField();
		txtDeleteAadharId.setBackground(new Color(0, 139, 139));
		txtDeleteAadharId.setText("Delete Aadhar Id");
		txtDeleteAadharId.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtDeleteAadharId.setBounds(10, 11, 151, 28);
		contentPane.add(txtDeleteAadharId);
		txtDeleteAadharId.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(0, 139, 139));
		textField_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField_1.setBounds(171, 11, 142, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_1.setText(aadhar);
		
		textField = new JTextField();
		textField.setBackground(new Color(0, 139, 139));
		textField.setText("?");
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setBounds(323, 11, 19, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNo = new JButton("No");
		btnNo.setForeground(Color.RED);
		btnNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNo.setBackground(SystemColor.controlHighlight);
		btnNo.setBounds(72, 50, 89, 23);
		contentPane.add(btnNo);
		
		JButton btnNewButton = new JButton("Yes");
		btnNewButton.setForeground(new Color(50, 205, 50));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(171, 50, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				getdelete();
									 
			}
				});
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Deleteframe dff=new Deleteframe();
				aadhar=dff.sendad;
				textField_1.setText(aadhar);
				
				deletecust();
				getdelete();
									 
			}
				});
		
	}
	
	public void deletecust() {
		
		String sql="delete from Customer where Aadharid=?";
		
		
		
		System.out.println(aadhar);
		try 
     	(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fps?autoReconnect=true&useSSL=false","root","tiger");
         PreparedStatement pst = con.prepareStatement(sql)) {
			System.out.println("before ");
			pst.setString(1, aadhar);
			pst.executeUpdate();
			
     } catch (SQLException ex){
     	ex.printStackTrace();
     }
	}
}
