package loginpg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class register extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JPasswordField pwd;
	private JPasswordField cpwd;
	PreparedStatement pstmt;
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register frame = new register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con=null;
	private JTextField email;
	private JTextField ph;
	
	/**
	 * Create the frame.
	 */
	public register() {
		con = sqlite.dbConnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 565);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 201, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER USER NAME:");
		lblNewLabel.setBounds(27, 154, 221, 63);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 20));
		contentPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(243, 166, 302, 49);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CREATE PASSWORD:");
		lblNewLabel_1.setBounds(27, 264, 197, 55);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 20));
		contentPane.add(lblNewLabel_1);
		
		pwd = new JPasswordField();
		pwd.setBounds(243, 272, 302, 49);
		pwd.setToolTipText("Password must have at atleast 8 characters, including uppercase and lowercase alphabets");
		contentPane.add(pwd);
		
		JLabel lblNewLabel_2 = new JLabel("CONFIRM PASSWORD:");
		lblNewLabel_2.setBounds(27, 374, 221, 55);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 20));
		contentPane.add(lblNewLabel_2);
		
		cpwd = new JPasswordField();
		cpwd.setBounds(243, 383, 302, 47);
		cpwd.setToolTipText("should be same as the password created");
		contentPane.add(cpwd);
		
		JButton btnNewButton = new JButton("CREATE ACCOUNT");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setBounds(735, 383, 205, 41);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nm=name.getText();
					String pass=new String(pwd.getPassword());
					String cpass=new String(cpwd.getPassword());
					String pattern="(?=.*[a-z])(?=.*[A-Z]).{8,}";
					if(pass.equals(cpass)) {
						Pattern p=Pattern.compile(pattern);
						Matcher m= p.matcher(cpass);
						if(m.matches()) {
							String query="insert into details(username,pwd) values (?,?)";
							PreparedStatement pstmt=con.prepareStatement(query); 
							pstmt.setString(1, nm);
							pstmt.setString(2, pass);
							pstmt.executeUpdate();
							pstmt.close();	
							JOptionPane.showMessageDialog(null,"Registration successfull");
						}
						else {
							JOptionPane.showMessageDialog(null,"invalid password");
							pwd.setText("");
							cpwd.setText("");
						}
					}
					else {
						pwd.setText("");
						cpwd.setText("");
						JOptionPane.showMessageDialog(null,"Password mismatched!");
					}			
				}
				catch(SQLException ex){
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("REGISTRATION FOR NEW USER");
		lblNewLabel_3.setBounds(389, 25, 420, 88);
		lblNewLabel_3.setForeground(new Color(0, 51, 153));
		lblNewLabel_3.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 24));
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setBounds(980, 384, 124, 38);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				loginW window = new loginW();
				window.frame.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel("ENTER EMAIL:");
		lblNewLabel_4.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_4.setBounds(586, 170, 161, 31);
		contentPane.add(lblNewLabel_4);
		
		email = new JTextField();
		email.setBounds(730, 166, 378, 49);
		contentPane.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("PHONE NO.:");
		lblNewLabel_5.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_5.setBounds(593, 271, 131, 41);
		contentPane.add(lblNewLabel_5);
		
		ph = new JTextField();
		ph.setBounds(730, 272, 378, 49);
		contentPane.add(ph);
		ph.setColumns(10);
	}
}
