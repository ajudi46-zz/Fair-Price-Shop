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
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class AddItemsFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Awheat;
	private JTextField Arice;
	private JTextField Asugar;
	private JTextField Asalt;
	private JTextField Aoil;
	private JTextField Aspices;
	private JTextField Adal;
	private JTextField Swheat;
	private JTextField Srice;
	private JTextField Ssugar;
	private JTextField Ssalt;
	private JTextField Soil;
	private JTextField Sspices;
	private JTextField Sdal;
	String gwheat;
	String grice;
	String gsugar;
	String gsalt;
	String goil;
	String gspice;
	String gdal;
	private JLabel lblBk;
	
	
	/**
	 * Launch the application.
	 */

	private void getMainFrame() {
		MainFrame m=new MainFrame();
		m.setVisible(true);
		this.setVisible(false);
	}
	/**
	 * Create the frame.ti
	 */
	
	boolean addItem(){
		gwheat=Awheat.getText();
		float intwheat;
		float intrice;
		float intsugar;
		float intsalt;
		float intoil;
		float intspice;
		float intdal;
		try {
			intwheat=Float.parseFloat(gwheat);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Invalid entry for wheat");
			Awheat.requestFocus();
			Awheat.setText("0");
			gwheat="";
			return false;
		}
		if(intwheat<0)
		{
			JOptionPane.showMessageDialog(null, "Invalid entry for wheat");
			Awheat.requestFocus();
			Awheat.setText("0");
			gwheat="";
			return false;
		}
		grice=Arice.getText();
		try {
			intrice=Float.parseFloat(grice);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Invalid entry for rice1");
			Arice.requestFocus();
			Arice.setText("0");
			grice="";
			return false;
		}
		if(intrice<0)
		{
			JOptionPane.showMessageDialog(null, "Invalid entry for rice2");
			Arice.requestFocus();
			Arice.setText("0");
			grice="";
			return false;
		}
		
		gsugar=Asugar.getText();
		try {
			intsugar=Float.parseFloat(gsugar);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Invlaid entry for sugar");
			Asugar.requestFocus();
			Asugar.setText("0");
			gsugar="";
			return false;
		}
		if(intsugar<0)
		{
			JOptionPane.showMessageDialog(null, "Invlaid entry for sugar");
			Asugar.requestFocus();
			Asugar.setText("0");
			gsugar="";
			return false;
		}
		
		gsalt=Asalt.getText();
		try {
			intsalt=Float.parseFloat(gsalt);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Invlaid entry for salt");
			Asalt.requestFocus();
			Asalt.setText("0");
			gsalt="";
			return false;
		}
		if(intsalt<0)
		{
			JOptionPane.showMessageDialog(null, "Invlaid entry for salt");
			Asalt.requestFocus();
			Asalt.setText("0");
			gsalt="";
			return false;
		}
		
		goil=Aoil.getText();
		try {
			intoil=Float.parseFloat(goil);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Invlaid entry for oil");
			Aoil.requestFocus();
			Aoil.setText("0");
			goil="";
			return false;
		}
		if(intoil<0)
		{
			JOptionPane.showMessageDialog(null, "Invlaid entry for oil");
			Aoil.requestFocus();
			Aoil.setText("0");
			goil="";
			return false;
		}
		
		gspice=Aspices.getText();
		try {
			intspice=Float.parseFloat(gspice);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Invlaid entry for spice");
			Aspices.requestFocus();
			Aspices.setText("0");
			gspice="";
			return false;
		}
		if(intspice<0)
		{
			JOptionPane.showMessageDialog(null, "Invlaid entry for spice");
			Aspices.requestFocus();
			Aspices.setText("0");
			gspice="";
			return false;
		}
		
		
		gdal=Adal.getText();
		try {
			intdal=Float.parseFloat(gdal);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Invlaid entry for dal");
			Adal.requestFocus();
			Adal.setText("0");
			gdal="";
			return false;
		}
		if(intdal<0)
		{
			JOptionPane.showMessageDialog(null, "Invlaid entry for dal");
			Adal.requestFocus();
			Adal.setText("0");
			gdal="";
			return false;
		}
		
		String sql="update Items set Quantity=Quantity+? where Item_name=?";
		 try 
	     	(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fps?autoReconnect=true&useSSL=false","root","tiger");
	         PreparedStatement pst = con.prepareStatement(sql)) {
			 	
			 	System.out.println("Wheat");
	            pst.setFloat(1,intwheat);
	            pst.setString(2,"Wheat");
	            pst.executeUpdate(); 
		            
		            System.out.println("Rice");
		            pst.setFloat(1,intrice);
		            pst.setString(2,"Rice");
		            pst.executeUpdate(); 
		            
		            pst.setString(2,"Rice");
		            pst.setFloat(1,intsugar);
		            pst.setString(2,"Sugar");
		            pst.executeUpdate(); 
		            
		            pst.setFloat(1,intsalt);
		            pst.setString(2,"Salt");
		            pst.executeUpdate(); 
		            
		            pst.setFloat(1,intsalt);
		            pst.setString(2,"Salt");
		            pst.executeUpdate(); 
		            
		            pst.setFloat(1,intoil);
		            pst.setString(2,"Oil");
		            pst.executeUpdate(); 
		            
		            pst.setFloat(1,intspice);
		            pst.setString(2,"Spices");
		            pst.executeUpdate(); 
		            
		            pst.setFloat(1,intdal);
		            pst.setString(2,"Dals");
		            pst.executeUpdate(); 
		            
		            stockdisplay();

	     } catch (SQLException ex){
	     	ex.printStackTrace();
	     }
		return true;
	}
	public AddItemsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350,70, 510, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStock = new JLabel("Stock Addition(in kgs)");
		lblStock.setForeground(new Color(240, 255, 240));
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStock.setBackground(new Color(25, 25, 112));
		lblStock.setOpaque(true);
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setBounds(0, 0, 506, 56);
		contentPane.add(lblStock);
		
		JLabel lblWheat = new JLabel("Wheat");
		lblWheat.setHorizontalAlignment(SwingConstants.CENTER);
		lblWheat.setForeground(new Color(255, 255, 240));
		lblWheat.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWheat.setBounds(10, 90, 86, 43);
		contentPane.add(lblWheat);
		
		Awheat = new JTextField();
		Awheat.setFont(new Font("Tahoma", Font.BOLD, 17));
		Awheat.setBounds(138, 90, 147, 43);
		contentPane.add(Awheat);
		Awheat.setColumns(10);
		
		JLabel lblRice = new JLabel("Rice");
		lblRice.setHorizontalAlignment(SwingConstants.CENTER);
		lblRice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRice.setForeground(new Color(255, 255, 240));
		lblRice.setBounds(20, 144, 76, 43);
		contentPane.add(lblRice);
		
		Arice = new JTextField();
		Arice.setFont(new Font("Tahoma", Font.BOLD, 17));
		Arice.setBounds(138, 144, 147, 43);
		contentPane.add(Arice);
		Arice.setColumns(10);
		
		JLabel lblSugar = new JLabel("Sugar");
		lblSugar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSugar.setForeground(new Color(255, 255, 240));
		lblSugar.setBackground(new Color(0, 139, 139));
		lblSugar.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSugar.setBounds(20, 197, 76, 43);
		contentPane.add(lblSugar);
		
		Asugar = new JTextField();
		Asugar.setFont(new Font("Tahoma", Font.BOLD, 17));
		Asugar.setBounds(138, 198, 147, 43);
		contentPane.add(Asugar);
		Asugar.setColumns(10);
		
		JLabel lblSalt = new JLabel("Salt");
		lblSalt.setForeground(new Color(255, 255, 240));
		lblSalt.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSalt.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalt.setBackground(new Color(0, 139, 139));
		lblSalt.setBounds(10, 251, 76, 43);
		contentPane.add(lblSalt);
		
		Asalt = new JTextField();
		Asalt.setFont(new Font("Tahoma", Font.BOLD, 17));
		Asalt.setBounds(138, 252, 147, 43);
		contentPane.add(Asalt);
		Asalt.setColumns(10);
		
		JLabel lblOil = new JLabel("Oil");
		lblOil.setHorizontalAlignment(SwingConstants.CENTER);
		lblOil.setForeground(new Color(255, 255, 240));
		lblOil.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblOil.setBounds(10, 305, 76, 43);
		contentPane.add(lblOil);
		
		Aoil = new JTextField();
		Aoil.setFont(new Font("Tahoma", Font.BOLD, 17));
		Aoil.setBounds(138, 306, 147, 42);
		contentPane.add(Aoil);
		Aoil.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Spices");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setForeground(new Color(255, 255, 240));
		lblNewLabel.setEnabled(true);
		lblNewLabel.setBackground(new Color(0, 139, 139));
		lblNewLabel.setBounds(10, 357, 76, 43);
		contentPane.add(lblNewLabel);
		
		Aspices = new JTextField();
		Aspices.setFont(new Font("Tahoma", Font.BOLD, 17));
		Aspices.setBounds(138, 359, 147, 41);
		contentPane.add(Aspices);
		Aspices.setColumns(10);
		
		JLabel lblDals = new JLabel("Dals");
		lblDals.setForeground(new Color(248, 248, 255));
		lblDals.setHorizontalAlignment(SwingConstants.CENTER);
		lblDals.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDals.setBounds(10, 404, 86, 43);
		contentPane.add(lblDals);
		
		Adal = new JTextField();
		Adal.setFont(new Font("Tahoma", Font.BOLD, 17));
		Adal.setBounds(138, 411, 147, 43);
		contentPane.add(Adal);
		Adal.setColumns(10);
		
		JButton add = new JButton("Add");
		add.setForeground(new Color(250, 128, 114));
		add.setFont(new Font("Tahoma", Font.BOLD, 18));
		add.setBounds(99, 477, 104, 43);
		contentPane.add(add);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(new Color(0, 128, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(249, 478, 104, 40);
		contentPane.add(btnNewButton_1);
		
		Swheat = new JTextField();
		Swheat.setEditable(false);
		Swheat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Swheat.setBackground(Color.LIGHT_GRAY);
		Swheat.setBounds(311, 90, 163, 43);
		contentPane.add(Swheat);
		Swheat.setColumns(10);
		
		Srice = new JTextField();
		Srice.setBackground(Color.LIGHT_GRAY);
		Srice.setEditable(false);
		Srice.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Srice.setBounds(311, 145, 163, 43);
		contentPane.add(Srice);
		Srice.setColumns(10);
		
		Ssugar = new JTextField();
		Ssugar.setBackground(Color.LIGHT_GRAY);
		Ssugar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Ssugar.setEditable(false);
		Ssugar.setBounds(311, 198, 163, 43);
		contentPane.add(Ssugar);
		Ssugar.setColumns(10);
		
		Ssalt = new JTextField();
		Ssalt.setBackground(Color.LIGHT_GRAY);
		Ssalt.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Ssalt.setEditable(false);
		Ssalt.setBounds(311, 251, 163, 43);
		contentPane.add(Ssalt);
		Ssalt.setColumns(10);
		
		Soil = new JTextField();
		Soil.setEditable(false);
		Soil.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Soil.setBackground(Color.LIGHT_GRAY);
		Soil.setBounds(311, 305, 163, 43);
		contentPane.add(Soil);
		Soil.setColumns(10);
		
		Sspices = new JTextField();
		Sspices.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Sspices.setEditable(false);
		Sspices.setBackground(Color.LIGHT_GRAY);
		Sspices.setBounds(310, 357, 164, 43);
		contentPane.add(Sspices);
		Sspices.setColumns(10);
		
		Sdal = new JTextField();
		Sdal.setEditable(false);
		Sdal.setBackground(Color.LIGHT_GRAY);
		Sdal.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Sdal.setBounds(309, 411, 165, 43);
		contentPane.add(Sdal);
		Sdal.setColumns(10);
		
		lblBk = new JLabel("bk");
		lblBk.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\newshop.jpg"));
		lblBk.setBounds(0, 54, 506, 487);
		contentPane.add(lblBk);
		
		try {
			stockdisplay();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		makezero();
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				getMainFrame();
									 
			}
				});
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(addItem()) {
					JOptionPane.showMessageDialog(null," Items added succesfully!!!");
					makezero();
				}
			}
		});
		
	}
	
	public void makezero() {
		Awheat.setText("0");
		Arice.setText("0");
		Asugar.setText("0");
		Asalt.setText("0");
		Aoil.setText("0");
		Aspices.setText("0");
		Adal.setText("0");
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
				  Swheat.setText(rs.getString("Quantity"));
			  }
			  
			  Statement stmt1 = con.createStatement();
			  ResultSet rs1=stmt1.executeQuery("select Quantity from Items where Item_name='Rice'");
			  if(rs1.next())
				{
					  Srice.setText(rs1.getString("Quantity"));
				  }
				  rs1.close();
					 Statement stmt2 = con.createStatement();
					  ResultSet rs2=stmt2.executeQuery("select Quantity from Items where Item_name='Sugar'");
					  while(rs2.next())
					  {
						  Ssugar.setText(rs2.getString("Quantity"));
					  }
					  rs2.close();
						 Statement stmt3 = con.createStatement();
						  ResultSet rs3=stmt3.executeQuery("select Quantity from Items where Item_name='salt'");
						  while(rs3.next())
						  {
							  Ssalt.setText(rs3.getString("Quantity"));
						  }	  
						  rs3.close();
							 Statement stmt4 = con.createStatement();
							  ResultSet rs4=stmt4.executeQuery("select Quantity from Items where Item_name='Oil'");
							  while(rs4.next())
							  {
								  Soil.setText(rs4.getString("Quantity"));
							  }	 
							  
								 Statement stmt5 = con.createStatement();
								  ResultSet rs5=stmt5.executeQuery("select Quantity from Items where Item_name='Spices'");
								  while(rs5.next())
								  {
									  Sspices.setText(rs5.getString("Quantity"));
								  }	 
								  
									 Statement stmt6 = con.createStatement();
									  ResultSet rs6=stmt6.executeQuery("select Quantity from Items where Item_name='Dals'");
									  while(rs6.next())
									  {
										  Sdal.setText(rs6.getString("Quantity"));
									  }	 
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
