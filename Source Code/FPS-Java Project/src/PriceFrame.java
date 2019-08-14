import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import java.sql.*;

import javax.swing.JSpinner;
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
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class PriceFrame extends JFrame {

	private JPanel contentPane;
	ButtonGroup group;
	String status="";
	private JTextField textField;
	JRadioButton rdbtnP;
	JRadioButton rdbtnP_1;
	JRadioButton rdbtnP_2;
	JComboBox comboBox;
	private JLabel lblBk;
	/**
	 * Launch the application.


	/**
	 * Create the frame.
	 */
	public PriceFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 70, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChangePrice = new JLabel("Change price");
		lblChangePrice.setOpaque(true);
		lblChangePrice.setForeground(new Color(255, 245, 238));
		lblChangePrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChangePrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblChangePrice.setBackground(new Color(47, 79, 79));
		lblChangePrice.setBounds(0, 0, 444, 53);
		contentPane.add(lblChangePrice);
		
		rdbtnP = new JRadioButton("P1");
		rdbtnP.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnP.setBackground(new Color(0, 139, 139));
		rdbtnP.setBounds(20, 116, 79, 34);
		contentPane.add(rdbtnP);
		
		rdbtnP_1 = new JRadioButton("P2");
		rdbtnP_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnP_1.setBackground(new Color(0, 139, 139));
		rdbtnP_1.setBounds(145, 116, 88, 34);
		contentPane.add(rdbtnP_1);
		
		 rdbtnP_2 = new JRadioButton("P3");
		rdbtnP_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnP_2.setBackground(new Color(0, 139, 139));
		rdbtnP_2.setBounds(297, 116, 88, 34);
		contentPane.add(rdbtnP_2);
		
		group=new ButtonGroup();
		group.add(rdbtnP_1);
		group.add(rdbtnP_2);
		group.add(rdbtnP);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 17));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Wheat", "Rice", "Sugar", "Salt", "Oil", "Spices", "Dals"}));
		comboBox.setBounds(20, 198, 157, 45);
		contentPane.add(comboBox);
		
		JLabel lblChoose = new JLabel("Choose status");
		lblChoose.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblChoose.setBounds(20, 64, 353, 45);
		contentPane.add(lblChoose);
		
		JLabel lblNewLabel = new JLabel("Price");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 245, 238));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(20, 271, 89, 45);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textField.setBounds(145, 271, 173, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText("0");
		
		JButton btnChange = new JButton("Change");
		btnChange.setBackground(new Color(192, 192, 192));
		btnChange.setForeground(new Color(255, 0, 0));
		btnChange.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnChange.setBounds(65, 344, 112, 45);
		contentPane.add(btnChange);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(0, 100, 0));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBackground(new Color(211, 211, 211));
		btnBack.setBounds(229, 344, 99, 45);
		contentPane.add(btnBack);
		
		lblBk = new JLabel("bk");
		lblBk.setIcon(new ImageIcon("E:\\downloads\\shopping-1165437_640.jpg"));
		lblBk.setBounds(0, 50, 450, 375);
		contentPane.add(lblBk);
		
			
		btnChange.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(pricechange())
					{
						JOptionPane.showMessageDialog(null, "Price changed sucessfully");
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
		
		btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				getMainFrame();
			}
				});
		

		}
	
	boolean pricechange() throws SQLException {
		int flag=0;
		try{
			if(rdbtnP.isSelected())
			{
				status="P1";
				flag=1;
				
			}
			if(rdbtnP_1.isSelected())
			{
				status="P2";
				flag=1;

				
			}
			if(rdbtnP_2.isSelected())
			{
				status="P3";
				flag=1;

				
			}
			}catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
		if(flag==0) {
			JOptionPane.showMessageDialog(null, "Please select status");
			return false;
		}
		
		Float price;
		String item=(String)comboBox.getSelectedItem();
		String p=textField.getText();
		
		try {
			price=Float.parseFloat(p);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Invlaid entry for price");
			textField.requestFocus();
			textField.setText("0");
			p="";
			return false;
		}
		if(price<0)
		{
			JOptionPane.showMessageDialog(null, "Invlaid entry for dal");
			textField.requestFocus();
			textField.setText("0");
			p="";
			return false;
		}
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fps?autoReconnect=true&useSSL=false","root","tiger");
		if(status.equals("P1")) {
			String sql="update Item_price set P1=? where Item_id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setFloat(1,price);
			if(item.equals("Wheat")) {
				pst.setInt(2,101);
			}
			
			if(item.equals("Rice")) {
				pst.setInt(2,102);
			}
			if(item.equals("Sugar")) {
				pst.setInt(2,103);
				
			}
			if(item.equals("Salt")) {
				pst.setInt(2,104);
			}
			if(item.equals("Oil")) {
				pst.setInt(2,105);
			}
			if(item.equals("Spices")) {
				pst.setInt(2,107);
			}
			if(item.equals("Dals")) {
				pst.setInt(2,106);
			}
			pst.executeUpdate();
		}
		if(status.equals("P2")) {
			String sql="update Item_price set P2=? where Item_id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setFloat(1,price);
			if(item.equals("Wheat")) {
				pst.setInt(2,101);
			}
			
			if(item.equals("Rice")) {
				pst.setInt(2,102);
			}
			if(item.equals("Sugar")) {
				pst.setInt(2,103);
				
			}
			if(item.equals("Salt")) {
				pst.setInt(2,104);
			}
			if(item.equals("Oil")) {
				pst.setInt(2,105);
			}
			if(item.equals("Spices")) {
				pst.setInt(2,107);
			}
			if(item.equals("Dals")) {
				pst.setInt(2,106);
			}
			pst.executeUpdate();
		}
		if(status.equals("P3")) {
			String sql="update Item_price set P3=? where Item_id=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setFloat(1,price);
			if(item.equals("Wheat")) {
				pst.setInt(2,101);
			}
			
			if(item.equals("Rice")) {
				pst.setInt(2,102);
			}
			if(item.equals("Sugar")) {
				pst.setInt(2,103);
				
			}
			if(item.equals("Salt")) {
				pst.setInt(2,104);
			}
			if(item.equals("Oil")) {
				pst.setInt(2,105);
			}
			if(item.equals("Spices")) {
				pst.setInt(2,107);
			}
			if(item.equals("Dals")) {
				pst.setInt(2,106);
			}
			pst.executeUpdate();
		}
		
		return true;
	}
	

	private void getMainFrame() {
		MainFrame m=new MainFrame();
		m.setVisible(true);
		this.setVisible(false);
	}
}

