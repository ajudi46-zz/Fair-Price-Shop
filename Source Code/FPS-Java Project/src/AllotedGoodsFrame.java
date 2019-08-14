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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

class Tabledata extends AbstractTableModel{

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
}


public class AllotedGoodsFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JTextArea Searchresult;
	private JLabel lblBk;
	private JTable table;
	private JTable table_1;
	private JScrollPane scrollPane;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	
	
		
	
	public AllotedGoodsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 70, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStock = new JLabel("Alloted Goods");
		lblStock.setForeground(new Color(240, 255, 240));
		lblStock.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStock.setBackground(new Color(47, 79, 79));
		lblStock.setOpaque(true);
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setBounds(0, 0, 797, 51);
		contentPane.add(lblStock);
				
		/*Searchresult = new JTextArea(10,10);
		Searchresult.setFont(new Font("Monospaced", Font.PLAIN, 17));*/
		
		
		

		
		/*JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(407, 93, 17, 246);
		contentPane.add(scrollBar);
		*/

		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(340, 410, 108, 34);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 62, 764, 299);
		contentPane.add(scrollPane_1);
		
		table_3 = new JTable();
		table_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane_1.setViewportView(table_3);
		/*
		JScrollPane scrollPane_1 = new JScrollPane(table_2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setBounds(10, 76, 764, 329);
		contentPane.add(scrollPane_1);
		
		table_2 = new JTable();
		table_2.setForeground(new Color(105, 105, 105));
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		scrollPane_1.setViewportView(table_2);
		
	
		*/
		

		try {
			String sql="Select *from AllotedGoods";
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fps?autoReconnect=true&useSSL=false","root","tiger");
			 PreparedStatement pst = con.prepareStatement(sql);	
			 ResultSet rs=pst.executeQuery();
			 table_3.setModel(DbUtils.resultSetToTableModel(rs));
			 int count=1;
			 /*
			 while(rs.next()) {
				 table_3.setValueAt(rs.getString(count), 1, 1);
				 count++;
			 }*/
			
			 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		/*
		JScrollPane sp=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setLocation(22, 69);
		contentPane.add(sp);
		sp.setVisible(true);
		sp.setSize(389,246);*/
		
				lblBk = new JLabel("bk");
		lblBk.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\newshop.jpg"));
		lblBk.setBounds(0, 51, 797, 440);
		contentPane.add(lblBk);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMainFrame();
			}
		});
		
		

	}
	
	private void getMainFrame() {
		MainFrame m=new MainFrame();
		m.setVisible(true);
		this.setVisible(false);
	}
}
