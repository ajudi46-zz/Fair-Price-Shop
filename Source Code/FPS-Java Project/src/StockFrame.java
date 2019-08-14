import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.ImageIcon;

public class StockFrame extends JFrame {

	private JPanel contentPane;
	private JTextField Qwheat;
	private JTextField Qrice;
	private JTextField Qsugar;
	private JTextField Qsalt;
	private JTextField Qoil;
	private JTextField Qspice;
	private JTextField Qdal;

	/**
	 * Launch the application.
	 */

	
	private void getMainFrame() {
		MainFrame m=new MainFrame();
		m.setVisible(true);
		this.setVisible(false);
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public StockFrame()   {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 70, 450, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setForeground(new Color(240, 255, 240));
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStock.setBackground(new Color(25, 25, 112));
		lblStock.setOpaque(true);
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setBounds(0, 0, 434, 49);
		contentPane.add(lblStock);
		
		JLabel lblWheat = new JLabel("Wheat");
		lblWheat.setHorizontalAlignment(SwingConstants.CENTER);
		lblWheat.setForeground(new Color(255, 255, 240));
		lblWheat.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWheat.setBounds(10, 60, 89, 42);
		contentPane.add(lblWheat);
		
		Qwheat = new JTextField();
		Qwheat.setEditable(false);
		Qwheat.setFont(new Font("Tahoma", Font.BOLD, 17));
		Qwheat.setBounds(138, 60, 259, 42);
		contentPane.add(Qwheat);
		Qwheat.setColumns(10);
		
		JLabel lblRice = new JLabel("Rice");
		lblRice.setHorizontalAlignment(SwingConstants.CENTER);
		lblRice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRice.setForeground(new Color(255, 255, 240));
		lblRice.setBounds(0, 112, 89, 42);
		contentPane.add(lblRice);
		
		Qrice = new JTextField();
		Qrice.setEditable(false);
		Qrice.setFont(new Font("Tahoma", Font.BOLD, 17));
		Qrice.setBounds(138, 113, 259, 42);
		contentPane.add(Qrice);
		Qrice.setColumns(10);
		
		JLabel lblSugar = new JLabel("Sugar");
		lblSugar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSugar.setForeground(new Color(255, 255, 240));
		lblSugar.setBackground(new Color(0, 139, 139));
		lblSugar.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSugar.setBounds(0, 165, 89, 42);
		contentPane.add(lblSugar);
		
		Qsugar = new JTextField();
		Qsugar.setEditable(false);
		Qsugar.setFont(new Font("Tahoma", Font.BOLD, 16));
		Qsugar.setBounds(138, 167, 259, 41);
		contentPane.add(Qsugar);
		Qsugar.setColumns(10);
		
		JLabel lblSalt = new JLabel("Salt");
		lblSalt.setForeground(new Color(255, 255, 240));
		lblSalt.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSalt.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalt.setBackground(new Color(0, 139, 139));
		lblSalt.setBounds(13, 218, 76, 42);
		contentPane.add(lblSalt);
		
		Qsalt = new JTextField();
		Qsalt.setEditable(false);
		Qsalt.setFont(new Font("Tahoma", Font.BOLD, 16));
		Qsalt.setBounds(138, 219, 259, 42);
		contentPane.add(Qsalt);
		Qsalt.setColumns(10);
		
		JLabel lblOil = new JLabel("Oil");
		lblOil.setHorizontalAlignment(SwingConstants.CENTER);
		lblOil.setForeground(new Color(255, 255, 240));
		lblOil.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOil.setBounds(0, 270, 76, 41);
		contentPane.add(lblOil);
		
		Qoil = new JTextField();
		Qoil.setEditable(false);
		Qoil.setFont(new Font("Tahoma", Font.BOLD, 16));
		Qoil.setBounds(138, 272, 259, 39);
		contentPane.add(Qoil);
		Qoil.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Spices");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 240));
		lblNewLabel.setEnabled(true);
		lblNewLabel.setBackground(new Color(0, 139, 139));
		lblNewLabel.setBounds(10, 322, 76, 39);
		contentPane.add(lblNewLabel);
		
		Qspice = new JTextField();
		Qspice.setEditable(false);
		Qspice.setFont(new Font("Tahoma", Font.BOLD, 17));
		Qspice.setBounds(138, 322, 259, 39);
		contentPane.add(Qspice);
		Qspice.setColumns(10);
		
		JLabel lblDals = new JLabel("Dals");
		lblDals.setForeground(new Color(248, 248, 255));
		lblDals.setHorizontalAlignment(SwingConstants.CENTER);
		lblDals.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDals.setBounds(10, 370, 66, 42);
		contentPane.add(lblDals);
		
		Qdal = new JTextField();
		Qdal.setEditable(false);
		Qdal.setFont(new Font("Tahoma", Font.BOLD, 17));
		Qdal.setBounds(138, 376, 259, 36);
		contentPane.add(Qdal);
		Qdal.setColumns(10);
		
		JButton btnAdd = new JButton("Back");
		btnAdd.setForeground(new Color(0, 128, 0));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdd.setBounds(160, 438, 111, 42);
		contentPane.add(btnAdd);
		
		JLabel lblBk = new JLabel("bk");
		lblBk.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\newshop.jpg"));
		lblBk.setBounds(0, 48, 446, 455);
		contentPane.add(lblBk);
		
		btnAdd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				getMainFrame();
									 
			}
				});
		
		try {
			stockdisplay();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void stockdisplay() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fps?autoReconnect=true&useSSL=false","root","tiger");
			 Statement stmt = con.createStatement();
			 System.out.println("Wheat");
			  ResultSet rs=stmt.executeQuery("select Quantity from Items where Item_name='Wheat'");
			  if(rs.next())
			  {
				  Qwheat.setText(rs.getString("Quantity"));
			  }
			  
			  Statement stmt1 = con.createStatement();
			  ResultSet rs1=stmt1.executeQuery("select Quantity from Items where Item_name='Rice'");
			  if(rs1.next())
				{
					  Qrice.setText(rs1.getString("Quantity"));
				  }
				  rs1.close();
					 Statement stmt2 = con.createStatement();
					  ResultSet rs2=stmt2.executeQuery("select Quantity from Items where Item_name='Sugar'");
					  while(rs2.next())
					  {
						  Qsugar.setText(rs2.getString("Quantity"));
					  }
					  rs2.close();
						 Statement stmt3 = con.createStatement();
						  ResultSet rs3=stmt3.executeQuery("select Quantity from Items where Item_name='salt'");
						  while(rs3.next())
						  {
							  Qsalt.setText(rs3.getString("Quantity"));
						  }	  
						  rs3.close();
							 Statement stmt4 = con.createStatement();
							  ResultSet rs4=stmt4.executeQuery("select Quantity from Items where Item_name='Oil'");
							  while(rs4.next())
							  {
								  Qoil.setText(rs4.getString("Quantity"));
							  }	 
							  
								 Statement stmt5 = con.createStatement();
								  ResultSet rs5=stmt5.executeQuery("select Quantity from Items where Item_name='Spices'");
								  while(rs5.next())
								  {
									  Qspice.setText(rs5.getString("Quantity"));
								  }	 
								  
									 Statement stmt6 = con.createStatement();
									  ResultSet rs6=stmt6.executeQuery("select Quantity from Items where Item_name='Dals'");
									  while(rs6.next())
									  {
										  Qdal.setText(rs6.getString("Quantity"));
									  }	 
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
