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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class DeliverItemsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField aid;
	String aadhar="";
	
	public String getaadhar() {
	
		return aadhar;
	}

	/**
	 * Launch the application.
	 */

	
	private void getMainFrame() {
		MainFrame m=new MainFrame();
		m.setVisible(true);
		this.setVisible(false);
	}
	
	private void getD2frame() {
		DeliverItemsFrame2 df2=new DeliverItemsFrame2(aadhar);
		df2.setVisible(true);
		this.setVisible(false);
	}

	/**
	 * Create the frame.
	 */
	public DeliverItemsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 70, 520, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearch = new JLabel("Deliver");
		lblSearch.setForeground(new Color(248, 248, 255));
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSearch.setBackground(new Color(47, 79, 79));
		lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.setOpaque(true);
		lblSearch.setBounds(0, 0, 517, 52);
		contentPane.add(lblSearch);
		
		aid = new JTextField();
		aid.setFont(new Font("Tahoma", Font.BOLD, 17));
		aid.setBounds(190, 65, 304, 39);
		contentPane.add(aid);
		aid.setColumns(10);
		
		JLabel lblEnterAadharId = new JLabel("Enter Aadhar ID");
		lblEnterAadharId.setForeground(new Color(248, 248, 255));
		lblEnterAadharId.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterAadharId.setBackground(new Color(0, 139, 139));
		lblEnterAadharId.setBounds(10, 65, 170, 37);
		contentPane.add(lblEnterAadharId);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(46, 139, 87));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBackground(new Color(135, 206, 235));
		btnBack.setBounds(263, 140, 89, 39);
		contentPane.add(btnBack);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(250, 128, 114));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdd.setBounds(95, 140, 89, 39);
		contentPane.add(btnAdd);
		
		JLabel lblBk = new JLabel("Bk");
		lblBk.setIcon(new ImageIcon("E:\\downloads\\shopping-1165437_640.jpg"));
		lblBk.setBounds(0, 51, 517, 270);
		contentPane.add(lblBk);
		

		
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				getMainFrame();
									 
			}
				});
		
		btnAdd.addActionListener(new ActionListener(){
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

	public void validateaadhar() throws SQLException {
		aadhar=aid.getText();
		int flag=1;
		Long Aid;
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
		System.out.println(aadhar);
		if(flag==0)
		{
			String sql="select * from Customer where Aadharid=?";
			
			try 
	     	(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fps?autoReconnect=true&useSSL=false","root","tiger");
	         PreparedStatement pst = con.prepareStatement(sql)) {
				System.out.println("before ");
				pst.setString(1, aadhar);
				ResultSet rs=pst.executeQuery();
				System.out.println("after");
				if(!rs.next())
				{
					JOptionPane.showMessageDialog(null, " Aadhar id not in the database");
					aid.requestFocus();
					aid.setText("");
					
				}
				else
				{
					String sql1="Select * from Allotedgoods where Aadharid=?";
					PreparedStatement pst1 = con.prepareStatement(sql1);
					pst1.setString(1, aadhar);
					ResultSet rs9=pst1.executeQuery();
					if(rs9.next()) {
						JOptionPane.showMessageDialog(null, "This aadhar id already bought the ration!");
						aid.requestFocus();
					}
					else {
						getD2frame();
					}
				}

				
				
				
	     } catch (SQLException ex){
	     	ex.printStackTrace();
	     }
		}
	}
}
