package loginpg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class loginW {

	JFrame frame;
	private JTextField name;
	private JPasswordField pwd;
	PreparedStatement pstmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginW window = new loginW();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con=null;
	public loginW() {
		initialize();
		con = sqlite.dbConnect();
	}
	/**
	 * Create the application.
	 */
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 937, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USER NAME :");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 21));
		lblNewLabel.setBounds(88, 125, 163, 67);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD :");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel_1.setBounds(91, 225, 160, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		name = new JTextField();
		name.setToolTipText("enter username");
		name.setFont(new Font("Tahoma", Font.PLAIN, 19));
		name.setForeground(new Color(0, 0, 0));
		name.setBounds(264, 136, 262, 48);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		pwd = new JPasswordField();
		pwd.setBackground(new Color(255, 255, 255));
		pwd.setForeground(Color.BLACK);
		pwd.setToolTipText("enter password");
		pwd.setBounds(264, 218, 262, 48);
		frame.getContentPane().add(pwd);
		
		JButton btnNewButton = new JButton("User Login");
		btnNewButton.setBackground(new Color(255, 255, 224));
		btnNewButton.setToolTipText("Already have an account..");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String nm=name.getText();
				String pass=new String(pwd.getPassword());
				String query="select * from details where usertype = 'user' ";
				PreparedStatement	pstmt=con.prepareStatement(query);
				ResultSet rst = pstmt.executeQuery();
				System.out.println(pass);
				System.out.println(rst.getString(1)+","+rst.getString(2));
				int flag=0;
				while(rst.next()) {
					String unm=rst.getString(1);
					String upwd=rst.getString(2);
				if(nm.equals(unm) && pass.equals(upwd)) {
					Update up=new Update();
					up.setVisible(true);
					flag=1;
				}
				}
				if(flag==0) {
					name.setText("");
					pwd.setText("");
					JOptionPane.showMessageDialog(null, "invalid username or password");
				}
				}
				catch(SQLException ex){
					JOptionPane.showMessageDialog(null, ex);
				}
				}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(133, 340, 118, 39);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("RAILWAY VENTURES");
		lblNewLabel_2.setBackground(new Color(255, 255, 0));
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Arial Black", Font.BOLD, 32));
		lblNewLabel_2.setBounds(353, 11, 410, 85);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("Admin Login");
		btnNewButton_1.setBackground(new Color(255, 255, 224));
		btnNewButton_1.setToolTipText("Only for admin use");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					String query="select * from details where usertype = 'admin' ";
					PreparedStatement	pstmt=con.prepareStatement(query);
					ResultSet rst = pstmt.executeQuery();
				String nm=name.getText();
				String pass=new String(pwd.getPassword());
				rst.next();
				String anm=rst.getString(1);
				String apwd=rst.getString(2);
				System.out.println(anm+","+rst.getString(2));
				rst.next();
				if( nm.equals(anm) && pass.equals(apwd)) {
					admin ad=new admin();
					ad.setVisible(true);
				}
				else {
					name.setText("");
					pwd.setText("");
					JOptionPane.showMessageDialog(null, "invalid username or password");
					}}
					catch(SQLException ex){
						JOptionPane.showMessageDialog(null, ex);
					}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(380, 340, 131, 39);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Register");
		btnNewButton_2.setBackground(new Color(255, 255, 224));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register r=new register();
				r.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(219, 452, 124, 39);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Don't have an account? Create an Account");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setBounds(133, 422, 301, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\asuds\\Downloads\\tr2.jpg"));
		lblNewLabel_4.setBounds(33, -27, 883, 558);
		frame.getContentPane().add(lblNewLabel_4);
	}
}
