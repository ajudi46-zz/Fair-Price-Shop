import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Deleteframe extends JFrame {

	private JPanel contentPane;
	private JTextField aid;
	private JButton btnBack;
	private JButton Search;
	private JLabel lblBk;
	/**
	 * Launch the application.
	 */
	String aadhar="";
	public String sendad;
	Long Aid;
	private JButton btnDelete;
	private JTextArea Searchresult;
	private JButton btnDelete_1;

	/**
	 * Launch the application.
	 */


	public Deleteframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 70,500,600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setForeground(new Color(248, 248, 255));
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSearch.setBackground(new Color(47, 79, 79));
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setOpaque(true);
		lblSearch.setBounds(0, 0, 494, 52);
		contentPane.add(lblSearch);
		
		aid = new JTextField();
		aid.setFont(new Font("Tahoma", Font.BOLD, 16));
		aid.setBounds(200, 63, 274, 39);
		contentPane.add(aid);
		aid.setColumns(10);
		
		JLabel lblEnterAadharId = new JLabel("Enter Aadhar ID");
		lblEnterAadharId.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterAadharId.setForeground(new Color(248, 248, 255));
		lblEnterAadharId.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEnterAadharId.setBackground(new Color(0, 139, 139));
		lblEnterAadharId.setBounds(22, 63, 185, 37);
		contentPane.add(lblEnterAadharId);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(new Color(46, 139, 87));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBackground(new Color(135, 206, 235));
		btnBack.setBounds(106, 118, 89, 37);
		contentPane.add(btnBack);
		
		Search = new JButton("Search");
		Search.setBackground(Color.LIGHT_GRAY);
		Search.setForeground(Color.RED);
		Search.setFont(new Font("Tahoma", Font.BOLD, 18));
		Search.setBounds(250, 118, 107, 37);
		contentPane.add(Search);
		
		Searchresult = new JTextArea();
		Searchresult.setFont(new Font("Monospaced", Font.PLAIN, 17));
		Searchresult.setBounds(22, 166, 452, 294);
		contentPane.add(Searchresult);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(186, 488, 89, 37);
		btnDelete.setBackground(new Color(192, 192, 192));
		btnDelete.setForeground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(btnDelete);
	
		lblBk = new JLabel("bk");
		lblBk.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\newshop.jpg"));
		lblBk.setBounds(0, 49, 494, 512);
		contentPane.add(lblBk);
		
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				getMainFrame();
									 
			}
				});
		
	/*	btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(192, 192, 192));
		btnDelete.setForeground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDelete.setBounds(149, 322, 105, 28);
		contentPane.add(btnDelete);*/
		
		Search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				try {
					validateaadhar();
			
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
									 
			}
				});
		

		
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				if(aadhar.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Please enter the id");
				}
				else
				{
					int result = JOptionPane.showConfirmDialog(null, 
							   "Are you sure you want to delete the id?",null, JOptionPane.YES_NO_OPTION);
							if(result == JOptionPane.YES_OPTION) {
							    deletecust();
							    aid.requestFocus();
							    aid.setText("");
							    Searchresult.setText("");
							    aadhar="";
							    
							} 
				}
									 
			}
				});
	}
	private void getMainFrame() {
		MainFrame m=new MainFrame();
		m.setVisible(true);
		this.setVisible(false);
	}
	
	private void getDeleteframe2() {
		Deleteframe2 df2=new Deleteframe2();
		df2.setVisible(true);
		
	}
	
	public void deletecust() {
		
		String sql="delete from Customer where Aadharid=?";
		String sql1="delete from Salary where Aadharid=?";
		
		
		
		System.out.println(aadhar);
		try 
     	(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fps?autoReconnect=true&useSSL=false","root","tiger");
         PreparedStatement pst = con.prepareStatement(sql)) {
			System.out.println("before ");
			pst.setString(1, aadhar);
			pst.executeUpdate();
			System.out.println("After");
			
			PreparedStatement pst2 = con.prepareStatement(sql1);
			pst2.setString(1, aadhar);
			pst2.executeUpdate();
			
     } catch (SQLException ex){
     	ex.printStackTrace();
     }
	}
	
	public void validateaadhar() throws SQLException {
		aadhar=aid.getText();
		int flag=1;
		try
		{
			Aid=Long.parseLong(aadhar);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Invalid Aadhar id\nOnly Numerical values!!");
			aid.requestFocus();
			aid.setText("");
			aadhar="";
			return ;
			
		}
		if(Aid<=0)
		{
			JOptionPane.showMessageDialog(null,"Invalid Aadhar id\nOnly Numerical values!!!");
			aid.requestFocus();
			aid.setText("");
			aadhar="";
			return;
		}
		String Finalaadhar=String.valueOf(Aid);
		if(Finalaadhar.length()!=12 )
		{
			JOptionPane.showMessageDialog(null,"Invalid Aadhar id!!");
			aid.requestFocus();
			aid.setText("");
			aadhar="";
			return ;
		}
		flag=0;
		aadhar=Finalaadhar;
		if(flag==0)
		{
			String sql="select * from Customer where Aadharid=?";
			
			try 
	     	(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fps?autoReconnect=true&useSSL=false","root","tiger");
	         PreparedStatement pst = con.prepareStatement(sql)) {
				System.out.println("before ");
				pst.setString(1, Finalaadhar);
				ResultSet rs=pst.executeQuery();
				System.out.println("after");
				if(rs.next())
				{
					Searchresult.setText("Name=>"+rs.getString("Name")+"\n"+"AadharId=>"+rs.getString("Aadharid")+"\n"+"Gender"+rs.getString("Gender")+"\n"+"Mobile no."+rs.getString("Mobno")+"\n"+"City=>"+rs.getString("City")+"\n");
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(null, " Aadhar id not in the database");
					aid.requestFocus();
					aid.setText("");
					Searchresult.setText(" ");
					
				}
				
				
				
	     } catch (SQLException ex){
	     	ex.printStackTrace();
	     }
		}
		
		
		
	}
}
