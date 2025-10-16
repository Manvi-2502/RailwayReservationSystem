package loginpg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import org.jdesktop.swingx.JXDatePicker;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class Update extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFrom;
	private JTextField txtTo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	

	/**
	 * Create the frame.
	 */
	Connection con=null;
	private JTextField pnrno;
	private JTextField psname;
	private JTextField trnum;
	private JTextField cls;
	private JTextField dt;
	private JTextField cn;
	private JTextField sn;
	public Update() {
		
		con=trains.dbConnect();
		 setTitle("Train Finder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 603);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 10, 968, 546);
	    contentPane.add(tabbedPane, BorderLayout.CENTER);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 205, 252));
		tabbedPane.addTab("SEARCH TRAIN", null, panel, null);
		panel.setLayout(null);
		
		JLabel lbl = new JLabel("FROM");
		lbl.setBounds(109, 81, 111, 39);
		lbl.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		panel.add(lbl);
		
		JLabel lblNewLabel_1 = new JLabel("TO");
		lblNewLabel_1.setBounds(119, 162, 84, 39);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		panel.add(lblNewLabel_1);
		
		txtFrom = new JTextField();
		txtFrom.setToolTipText("Enter Source");
		txtFrom.setBounds(230, 86, 215, 39);
		txtFrom.setBorder(new MatteBorder(1,1,2,2,(Color) new Color(0,0,0)));
		panel.add(txtFrom);
		txtFrom.setColumns(10);
		
		txtTo = new JTextField();
		txtTo.setToolTipText("Enter destination");
		txtTo.setBorder(new MatteBorder(1,1,2,2,(Color) new Color(0,0,0)));
		txtTo.setBounds(230, 167, 215, 39);
		panel.add(txtTo);
		txtTo.setColumns(10);
		
		JXDatePicker picker=new JXDatePicker();
		picker.setBounds(230, 250, 210, 40);
		picker.setBorder(new MatteBorder(1,1,2,2,(Color) new Color(0,0,0)));
		picker.setBackground(new Color(255,255,255));
		picker.getEditor().setFont(new Font("Times New Roman", Font.BOLD, 16));
		picker.setDate(Calendar.getInstance().getTime());
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		picker.setFormats(f);
		panel.add(picker);
		JLabel lblNewLabel_3 = new JLabel("DATE");
		lblNewLabel_3.setBounds(119, 246, 70, 39);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		panel.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Search Trains");
		btnNewButton.setBounds(184, 365, 173, 39);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(100, 149, 237));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  String source = txtFrom.getText().trim();
			            String destination = txtTo.getText().trim();
			            String date =f.format(picker.getDate());
			            
			            
			            
			            System.out.println("Source: " + source);
			            System.out.println("Destination: " + destination);
			            System.out.println("Date: " + date);
					
					if(source.equals("") || destination.equals("")|| date.equals("")) {
						JOptionPane.showMessageDialog(null, "Enter the details");
						txtFrom.setText("");
						txtTo.setText("");
					}
					else {
						
						Trainsearch t1=new Trainsearch(source,destination,date);
						System.out.println(date);
						System.out.println(destination);
						t1.setVisible(true);
					}
				  
					}
				catch(Exception e1) {
					System.out.println(e1);				
				JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\asuds\\OneDrive\\Pictures\\pexels-senuscape-728360-1658967.jpg"));
		lblNewLabel.setBounds(534, 0, 429, 518);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Seamless travel, effortless booking...");
		lblNewLabel_2.setForeground(new Color(0, 0, 160));
		lblNewLabel_2.setFont(new Font("Script MT Bold", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(136, 0, 306, 39);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(170, 201, 242));
		tabbedPane.addTab("CANCEL TICKET", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Enter PNR ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(210, 23, 132, 50);
		panel_1.add(lblNewLabel_4);
		
		pnrno = new JTextField();
		pnrno.setBounds(326, 31, 205, 40);
		panel_1.add(pnrno);
		pnrno.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Passenger Name");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(34, 129, 145, 32);
		panel_1.add(lblNewLabel_5);
		
		psname = new JTextField();
		psname.setColumns(10);
		psname.setBounds(210, 128, 205, 40);
		panel_1.add(psname);
		
		JLabel lblNewLabel_6 = new JLabel("Train Number");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(34, 201, 132, 32);
		panel_1.add(lblNewLabel_6);
		
		trnum = new JTextField();
		trnum.setColumns(10);
		trnum.setBounds(210, 201, 205, 39);
		panel_1.add(trnum);
		
		
		
		
		JLabel lblNewLabel_6_1 = new JLabel("Class");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6_1.setBounds(34, 267, 132, 32);
		panel_1.add(lblNewLabel_6_1);
		
		cls = new JTextField();
		cls.setColumns(10);
		cls.setBounds(210, 266, 205, 40);
		panel_1.add(cls);
		
		JLabel lblNewLabel_7 = new JLabel("Date");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(517, 135, 87, 21);
		panel_1.add(lblNewLabel_7);
		
		dt = new JTextField();
		dt.setColumns(10);
		dt.setBounds(614, 129, 205, 39);
		panel_1.add(dt);
		
		JLabel lblNewLabel_7_1 = new JLabel("Coach no.");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7_1.setBounds(512, 213, 87, 21);
		panel_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("Seat no.");
		lblNewLabel_7_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7_2.setBounds(512, 278, 87, 21);
		panel_1.add(lblNewLabel_7_2);
		
		cn = new JTextField();
		cn.setColumns(10);
		cn.setBounds(614, 201, 205, 39);
		panel_1.add(cn);
		
		sn = new JTextField();
		sn.setColumns(10);
		sn.setBounds(614, 276, 205, 39);
		panel_1.add(sn);
		
		JButton btnNewButton_1 = new JButton("GET DETAILS");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				 String pnr = pnrno.getText().trim();
		            String pname = psname.getText().trim();

		            if (pnr.isEmpty() || pname.isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Enter both PNR and passenger name.");
		                return;
		            }

		            PreparedStatement ps = con.prepareStatement(
		                "SELECT b.TRAIN_NUM, b.DATE, b.CLASS, p.CoachNo, p.SeatNo " +
		                "FROM Book_details b JOIN Passenger p ON b.PNR = p.PNR " +
		                "WHERE b.PNR = ? AND p.Pname = ?");
		            ps.setString(1, pnr);
		            ps.setString(2, pname);

		            ResultSet rs = ps.executeQuery();

		            if (rs.next()) {
		                trnum.setText(rs.getString("TRAIN_NUM"));
		                dt.setText(rs.getString("DATE"));
		               cls.setText(rs.getString("CLASS"));
		                cn.setText(rs.getString("CoachNo"));
		                sn.setText(rs.getString("SeatNo"));
		            } else {
		                JOptionPane.showMessageDialog(null, "Passenger not found.");
		            }

		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
		        }
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(90, 147, 222));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(225, 375, 182, 41);
		panel_1.add(btnNewButton_1);
		
 		
		
		JButton btnNewButton_2 = new JButton("Cancel Ticket");
		btnNewButton_2.setBackground(new Color(90, 147, 222));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
			            String pnr = pnrno.getText().trim();
			            String pname = psname.getText().trim();
			            String trainNum = trnum.getText().trim();
			            String date = dt.getText().trim();
			            String trainClass = cls.getText().trim();
			            String coachNo = cn.getText().trim();
			            String seatNo = sn.getText().trim();

			            // 1. Delete passenger
			            PreparedStatement deletePassenger = con.prepareStatement(
			                "DELETE FROM Passenger WHERE PNR = ? AND Pname = ? AND CoachNo = ? AND SeatNo = ?");
			            deletePassenger.setString(1, pnr);
			            deletePassenger.setString(2, pname);
			            deletePassenger.setString(3, coachNo);
			            deletePassenger.setString(4, seatNo);
			            int rowsDeleted = deletePassenger.executeUpdate();

			            if (rowsDeleted == 0) {
			                JOptionPane.showMessageDialog(null, "Passenger not found or already cancelled.");
			                return;
			            }

			            // 2. Update seat availability
			            PreparedStatement updateSeat = con.prepareStatement(
			                "UPDATE Seat SET AVLB_STATUS = 'Available' WHERE TRAIN_NUM = ? AND DATE = ? AND CLASS = ? AND COACH_NO = ? AND SEAT_NO = ?");
			            updateSeat.setString(1, trainNum);
			            updateSeat.setString(2, date);
			            updateSeat.setString(3, trainClass);
			            updateSeat.setString(4, coachNo);
			            updateSeat.setString(5, seatNo);
			            updateSeat.executeUpdate();

			            // 3. Increment AVLB_SEATS
			            PreparedStatement updateClass = con.prepareStatement(
			                "UPDATE Class SET AVLB_SEATS = AVLB_SEATS + 1 WHERE TRAIN_NUM = ? AND DATE = ? AND CLASS = ?");
			            updateClass.setString(1, trainNum);
			            updateClass.setString(2, date);
			            updateClass.setString(3, trainClass);
			            updateClass.executeUpdate();

			            JOptionPane.showMessageDialog(null, "Passenger cancelled successfully.");

			            // Optional: Clear all fields after cancellation
			            pnrno.setText("");
			 		    psname.setText("");
			 		    trnum.setText("");
			 		    dt.setText("");
			 		    cls.setText("");
			 		    cn.setText("");
			 		    sn.setText("");
			           // clearFields();

			        }
				 catch (Exception ex) {
			            ex.printStackTrace();
			            JOptionPane.showMessageDialog(null, "Cancellation failed: " + ex.getMessage());
			        }
			}
		
		});
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_2.setBounds(621, 375, 182, 41);
		panel_1.add(btnNewButton_2);
		
	}
}
