
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	
	private void getRegFrame() {
		RegistrationFrame rf=new RegistrationFrame();
		rf.setVisible(true);
		this.setVisible(false);
	
	}
	
	
	private void getDeleteFrame() {
		Deleteframe df=new Deleteframe();
		df.setVisible(true);
		this.setVisible(false);
	}
	
	private void getSearchFrame() {
		SearchFrame sf=new SearchFrame();
		sf.setVisible(true);
		this.setVisible(false);

		
	}

	private void getStockFrame() {
		StockFrame Sf=new StockFrame();
		Sf.setVisible(true);
		this.setVisible(false);

	
	}
	
	private void getAddItemsFrame() {
		AddItemsFrame Sf=new AddItemsFrame();
		Sf.setVisible(true);
		this.setVisible(false);
		
	
	}
	
	private void getDFrame() {
		DeliverItemsFrame Df=new DeliverItemsFrame();
		Df.setVisible(true);
		this.setVisible(false);

	
	}
	
	private void getAGFrame() {
		AllotedGoodsFrame A=new AllotedGoodsFrame();
		A.setVisible(true);
		this.setVisible(false);

	
	}
	
	private void getPFrame() {
		PriceFrame A=new PriceFrame();
		A.setVisible(true);
		this.setVisible(false);

	
	}
	
	private void getMainFrame2() {
		MainFrame2 A=new MainFrame2();
		A.setVisible(true);
		this.setVisible(false);

	
	}
	
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 70, 500, 670);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton addC = new JButton("Add Customer");
		addC.setBounds(10, 285, 226, 50);
		addC.setFont(new Font("Tahoma", Font.BOLD, 17));
		addC.setForeground(new Color(51, 51, 255));
		addC.setBackground(new Color(204, 204, 204));
		contentPane.add(addC);
		
		JButton search = new JButton("Search ");
		search.setBounds(246, 285, 226, 50);
		search.setForeground(new Color(51, 51, 255));
		search.setFont(new Font("Tahoma", Font.BOLD, 17));
		search.setBackground(new Color(204, 204, 204));
		contentPane.add(search);
		
		JButton addItem = new JButton("Add Items");
		addItem.setBounds(10, 355, 226, 50);
		addItem.setFont(new Font("Tahoma", Font.BOLD, 17));
		addItem.setForeground(new Color(51, 51, 255));
		addItem.setBackground(new Color(204, 204, 204));
		contentPane.add(addItem);
		
		JButton delitems = new JButton("Deliver Items");
		delitems.setBounds(246, 426, 226, 50);
		delitems.setForeground(new Color(51, 51, 255));
		delitems.setFont(new Font("Tahoma", Font.BOLD, 17));
		delitems.setBackground(new Color(204, 204, 204));
		contentPane.add(delitems);
		
		JButton btnNewButton = new JButton("Alloted Goods");
		btnNewButton.setBounds(248, 502, 226, 50);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setForeground(new Color(51, 51, 255));
		btnNewButton.setBackground(new Color(204, 204, 204));
		contentPane.add(btnNewButton);
		
		
		JLabel lblFairPriceShop = new JLabel("FAIR PRICE SHOP");
		lblFairPriceShop.setBounds(0, 0, 496, 50);
		lblFairPriceShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblFairPriceShop.setForeground(new Color(245, 255, 250));
		lblFairPriceShop.setOpaque(true);
		lblFairPriceShop.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFairPriceShop.setBackground(new Color(47, 79, 79));
		contentPane.add(lblFairPriceShop);
		
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 61, 484, 2);
		separator.setBackground(new Color(245, 255, 250));
		contentPane.add(separator);
		
		JButton btnStock = new JButton("Stock");
		btnStock.setBounds(246, 356, 226, 49);
		btnStock.setBackground(new Color(204, 204, 204));
		btnStock.setForeground(new Color(51, 51, 255));
		btnStock.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(btnStock);
		
		JButton btnNewButton_1 = new JButton("Delete Customer");
		btnNewButton_1.setBounds(10, 426, 226, 50);
		btnNewButton_1.setForeground(new Color(51, 51, 255));
		btnNewButton_1.setBackground(new Color(204, 204, 204));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(btnNewButton_1);
		
		JButton btnChangePrice = new JButton("Change price ");
		btnChangePrice.setBounds(10, 502, 226, 50);
		btnChangePrice.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnChangePrice.setForeground(new Color(51, 51, 255));
		btnChangePrice.setBackground(new Color(204, 204, 204));
		contentPane.add(btnChangePrice);
		
		JButton btnExit = new JButton("Logout");
		btnExit.setBounds(161, 563, 176, 48);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnExit.setForeground(new Color(255, 0, 0));
		btnExit.setBackground(new Color(204, 204, 204));
		contentPane.add(btnExit);
		
		btnExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, 
						   "Are you sure you want to log out?",null, JOptionPane.YES_NO_OPTION);
						if(result == JOptionPane.YES_OPTION) {

							getMainFrame2();	 
						} 
										 
			}
				}); 
		
		JLabel lblBk = new JLabel("BK");
		lblBk.setBounds(0, 0, 865, 641);
		lblBk.setIcon(new ImageIcon("C:\\Users\\User\\Pictures\\newshop.jpg"));
		
		contentPane.add(lblBk);
		
		
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("E:\\downloads\\fps3.png"));
		label.setOpaque(true);
		label.setBounds(144, 74, 203, 182);
		contentPane.add(label,0);
		
		
		
		
		
		
		
		btnChangePrice.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				getPFrame();
									 
			}
				});
		addC.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				getRegFrame();
									 
			}
				});
		
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				getSearchFrame();
									 
			}
				});
		
		btnStock.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				getStockFrame();
				
									 
			}
				});

		addItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				getAddItemsFrame();
				
									 
			}
				});
		
		delitems.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				getDFrame();
				
									 
			}
				});
		
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				getAGFrame();
				
									 
			}
				});
		
		btnNewButton_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				getDeleteFrame();
									 
			}
				});
	}
}
