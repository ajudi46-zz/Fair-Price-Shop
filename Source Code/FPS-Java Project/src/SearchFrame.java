import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class SearchFrame extends JFrame {

	private JPanel contentPane;
	private JTextField aid;
	private JButton btnBack;
	private JButton Search;
	/**
	 * Launch the application.
	 */
	String aadhar;
	Long Aid;
	private JTextArea Searchresult;
	private JLabel lblBk;

	
	private void getMainFrame() {
		MainFrame m=new MainFrame();
		m.setVisible(true);
		this.setVisible(false);
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
		if(flag==0)
		{
			System.out.println(Finalaadhar);
			String sql="select * from Customer where Aadharid=?";

			try 
	     	(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fps?autoReconnect=true&useSSL=false","root","tiger");
	         PreparedStatement pst = con.prepareStatement(sql)) {
				pst.setString(1, Finalaadhar);
				ResultSet rs=pst.executeQuery();
				if(rs.next())
				{
					Searchresult.setText("Name=>"+rs.getString("Name")+"\n"+"AadharId=>"+rs.getString("Aadharid")+"\n"+"Gender=>"+rs.getString("Gender")+"\n"+"Date of Birth->=>"+rs.getString("DOB")+"\n"+"Mobile no.=>"+rs.getString("Mobno")+"\n"+"City=>"+rs.getString("City")+"\n");
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
	/**
	 * Create the frame.
	 */
	public SearchFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 70, 500, 500);
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
		Searchresult.setBounds(22, 179, 452, 271);
		contentPane.add(Searchresult);
		
		lblBk = new JLabel("bk");
		lblBk.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\newshop.jpg"));
		lblBk.setBounds(0, 49, 494, 432);
		contentPane.add(lblBk);
		
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				getMainFrame();
									 
			}
				});
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
		

	}
}
