package loginpg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
public class admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField trname1;
	private JTextField trnum1;
	private JTextField trfrom1;
	private JTextField trto1;
	private JTextField departure1;
	private JTextField arrival1;
	private JTextField trName;
	private JTextField trnum;
	private JTextField trfrom;
	private JTextField trto;
	private JTextField departure;
	private JTextField arrival;
Connection con=null;
PreparedStatement pst;
private JTextField tfslp;
private JTextField tfac1;
private JTextField tfac2;
private JTextField tfac3;
private JTextField textField;
private JTextField textField_1;
private JTextField textField_2;
private JTextField textField_3;
private JTextField textField_4;
private JTextField textField_5;
private JTextField textField_12;
private JTextField textField_13;
private JTextField textField_14;
private JTextField textField_15;
private JTextField tname;
private JTextField tnum;
private JTextField source;
private JTextField dest;
private JTextField depart;
private JTextField arr;
private JTextField slpno;
private JTextField ac1no;
private JTextField ac2no;
private JTextField ac3no;
private JTextField slpf;
private JTextField ac1f;
private JTextField ac2f;
private JTextField ac3f;
private JTextField slpfare;
private JTextField ac1fare;
private JTextField ac2fare;
private JTextField ac3fare;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin frame = new admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void setData(int no,String date, String cls, int seat, int fare) throws SQLException   {
		  System.out.print(no+date+cls+seat+fare);
   	 String sql = "insert into class(TRAIN_NUM,DATE,CLASS,TOTAL_SEATS,AVLB_SEATS,FARE) values(?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(sql);
       pstmt.setInt(1, no);
       pstmt.setString(2, date);
       pstmt.setString(3, cls);
       pstmt.setInt(4, seat);
       pstmt.setInt(5, seat);
       pstmt.setInt(6, fare);
       pstmt.executeUpdate();
       pstmt.close();
   }


	/**
	 * Create the frame.
	 */
	public admin() {
		con=trains.dbConnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 918, 733);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 887, 650);
		contentPane.add(tabbedPane);
		
		JPanel panel_5 = new JPanel();
		tabbedPane.addTab("ADD TRAIN", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBounds(448, 5, 1, 1);
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_5.add(panel_3_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("NAME");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(52, 61, 69, 17);
		panel_3_1.add(lblNewLabel_3_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(120, 47, 269, 39);
		panel_3_1.add(textField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("NUMBER");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(429, 59, 97, 20);
		panel_3_1.add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(536, 47, 269, 39);
		panel_3_1.add(textField_1);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("DEPARTURE");
		lblNewLabel_2_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3_1.setBounds(26, 252, 110, 39);
		panel_3_1.add(lblNewLabel_2_3_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("ARRIVAL");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(439, 252, 110, 39);
		panel_3_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("FROM");
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2_1.setBounds(52, 149, 110, 39);
		panel_3_1.add(lblNewLabel_2_2_2_1);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("TO");
		lblNewLabel_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1_1.setBounds(439, 155, 110, 39);
		panel_3_1.add(lblNewLabel_2_2_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(120, 149, 269, 36);
		panel_3_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(536, 149, 269, 45);
		panel_3_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(120, 252, 218, 36);
		panel_3_1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(536, 252, 231, 39);
		panel_3_1.add(textField_5);
		
		JComboBox comboBox_2_1 = new JComboBox();
		comboBox_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2_1.setBounds(335, 252, 52, 36);
		panel_3_1.add(comboBox_2_1);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1_1_1.setBounds(763, 252, 52, 36);
		panel_3_1.add(comboBox_1_1_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(120, 335, 250, 212);
		panel_3_1.add(panel_6);
		
		JLabel lblNewLabel_8 = new JLabel("NUMBER OF SEATS");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(49, 11, 157, 27);
		panel_6.add(lblNewLabel_8);
		
		JLabel lblNewLabel_1_3 = new JLabel("SLEEPER");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_3.setBounds(21, 59, 79, 27);
		panel_6.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("AC-I");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_1.setBounds(21, 97, 49, 23);
		panel_6.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("AC-II");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_1.setBounds(21, 131, 49, 21);
		panel_6.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("AC-III");
		lblNewLabel_7_1.setBounds(21, 171, 49, 14);
		panel_6.add(lblNewLabel_7_1);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(110, 63, 96, 20);
		panel_6.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(110, 99, 96, 20);
		panel_6.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(110, 132, 96, 20);
		panel_6.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(110, 168, 96, 20);
		panel_6.add(textField_15);
		
		JButton btnModify_1 = new JButton("MODIFY");
		btnModify_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnModify_1.setBounds(354, 591, 125, 39);
		panel_3_1.add(btnModify_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(new Color(204, 204, 255));
		panel_3_2.setLayout(null);
		panel_3_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3_2.setBounds(0, 0, 894, 700);
		panel_5.add(panel_3_2);
		
		JLabel lblNewLabel_3_2 = new JLabel("NAME");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_2.setBounds(52, 61, 69, 17);
		panel_3_2.add(lblNewLabel_3_2);
		
		tname = new JTextField();
		tname.setColumns(10);
		tname.setBounds(120, 47, 269, 39);
		panel_3_2.add(tname);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("NUMBER");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(429, 59, 97, 20);
		panel_3_2.add(lblNewLabel_1_1_2);
		
		tnum = new JTextField();
		tnum.setColumns(10);
		tnum.setBounds(536, 47, 269, 39);
		panel_3_2.add(tnum);
		
		JLabel lblNewLabel_2_3_2 = new JLabel("DEPARTURE");
		lblNewLabel_2_3_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3_2.setBounds(26, 252, 110, 39);
		panel_3_2.add(lblNewLabel_2_3_2);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("ARRIVAL");
		lblNewLabel_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1_2.setBounds(439, 252, 110, 39);
		panel_3_2.add(lblNewLabel_2_1_1_2);
		
		JLabel lblNewLabel_2_2_2_2 = new JLabel("FROM");
		lblNewLabel_2_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2_2.setBounds(52, 149, 110, 39);
		panel_3_2.add(lblNewLabel_2_2_2_2);
		
		JLabel lblNewLabel_2_2_1_1_2 = new JLabel("TO");
		lblNewLabel_2_2_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1_2.setBounds(439, 155, 110, 39);
		panel_3_2.add(lblNewLabel_2_2_1_1_2);
		
		source = new JTextField();
		source.setColumns(10);
		source.setBounds(120, 149, 269, 36);
		panel_3_2.add(source);
		
		dest = new JTextField();
		dest.setColumns(10);
		dest.setBounds(536, 149, 269, 45);
		panel_3_2.add(dest);
		
		depart = new JTextField();
		depart.setColumns(10);
		depart.setBounds(120, 252, 218, 36);
		panel_3_2.add(depart);
		
		arr = new JTextField();
		arr.setColumns(10);
		arr.setBounds(536, 252, 231, 39);
		panel_3_2.add(arr);
		
		JComboBox dCombo = new JComboBox();
		dCombo.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		dCombo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dCombo.setBounds(335, 252, 52, 36);
		panel_3_2.add(dCombo);
		
		JComboBox aCombo = new JComboBox();
		aCombo.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		aCombo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aCombo.setBounds(763, 252, 52, 36);
		panel_3_2.add(aCombo);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(204, 204, 204));
		panel_7.setLayout(null);
		panel_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_7.setBounds(39, 322, 231, 212);
		panel_3_2.add(panel_7);
		
		JLabel lblNewLabel_9 = new JLabel("NUMBER OF SEATS");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_9.setBounds(49, 11, 157, 27);
		panel_7.add(lblNewLabel_9);
		
		JLabel lblNewLabel_1_4 = new JLabel("SLEEPER");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_4.setBounds(21, 59, 79, 27);
		panel_7.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_2_2 = new JLabel("AC-I");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_2.setBounds(21, 97, 49, 23);
		panel_7.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_5_2 = new JLabel("AC-II");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_2.setBounds(21, 131, 49, 21);
		panel_7.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_7_2 = new JLabel("AC-III");
		lblNewLabel_7_2.setBounds(21, 171, 49, 14);
		panel_7.add(lblNewLabel_7_2);
		
		slpno = new JTextField();
		slpno.setToolTipText("should be less than 5");
		slpno.setColumns(10);
		slpno.setBounds(110, 63, 96, 20);
		panel_7.add(slpno);
		
		ac1no = new JTextField();
		ac1no.setToolTipText("should be less than 5");
		ac1no.setColumns(10);
		ac1no.setBounds(110, 99, 96, 20);
		panel_7.add(ac1no);
		
		ac2no = new JTextField();
		ac2no.setToolTipText("should be less than 5");
		ac2no.setColumns(10);
		ac2no.setBounds(110, 132, 96, 20);
		panel_7.add(ac2no);
		
		ac3no = new JTextField();
		ac3no.setToolTipText("should be less than 5");
		ac3no.setColumns(10);
		ac3no.setBounds(110, 168, 96, 20);
		panel_7.add(ac3no);
		JLabel lblNewLabel_11 = new JLabel("SCHEDULE ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11.setBounds(81, 0, 125, 33);
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(204, 204, 204));
		panel_9.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_9.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_9.setBounds(609, 322, 238, 255);
		panel_3_2.add(panel_9);
		panel_9.setLayout(null);
		
		panel_9.add(lblNewLabel_11);
		
		JCheckBox mon = new JCheckBox("MONDAY");
		mon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mon.setBounds(18, 70, 99, 23);
		panel_9.add(mon);
		
		JLabel lblNewLabel_12 = new JLabel("WEEKLY");
		lblNewLabel_12.setForeground(SystemColor.textHighlight);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12.setBounds(18, 40, 67, 23);
		panel_9.add(lblNewLabel_12);
		
		JCheckBox tue = new JCheckBox("TUESDAY");
		tue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tue.setBounds(18, 96, 99, 23);
		panel_9.add(tue);
		
		JCheckBox wed = new JCheckBox("WEDNESDAY");
		wed.setFont(new Font("Tahoma", Font.PLAIN, 12));
		wed.setForeground(new Color(0, 0, 0));
		wed.setBounds(18, 122, 99, 23);
		panel_9.add(wed);
		
		JCheckBox thu = new JCheckBox("THURSDAY");
		thu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		thu.setBounds(18, 150, 99, 23);
		panel_9.add(thu);
		
		JCheckBox fri = new JCheckBox("FRIDAY");
		fri.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fri.setBounds(18, 176, 99, 23);
		panel_9.add(fri);
		
		JCheckBox sat = new JCheckBox("SATURDAY");
		sat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sat.setBounds(18, 202, 99, 23);
		panel_9.add(sat);
		
		JCheckBox sun = new JCheckBox("SUNDAY");
		sun.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sun.setBounds(18, 228, 99, 23);
		panel_9.add(sun);
		
		JCheckBox daily = new JCheckBox("DAILY");
		daily.setFont(new Font("Tahoma", Font.BOLD, 14));
		daily.setForeground(SystemColor.textHighlight);
		daily.setFont(new Font("Tahoma", Font.BOLD, 13));
		daily.setBounds(120, 41, 99, 23);
		panel_9.add(daily);
		
		
		JButton btnAddTrain = new JButton("ADD TRAIN");
		btnAddTrain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name,from,to,dep,arrive;
					int ac3,ac2,ac1,no,slp,fac1,fac2,fac3,fslp;
					name=tname.getText();
					no=Integer.parseInt(tnum.getText());
					from=source.getText();
					to=dest.getText();
					dep=depart.getText();
					arrive=arr.getText();
					String atime=(String)aCombo.getSelectedItem();
					String dtime=(String)dCombo.getSelectedItem();
					String days = "";
					if (mon.isSelected()) {
					    days += "Mon ";
					}
					if (tue.isSelected()) {
					    days += "Tue ";
					}
					if (wed.isSelected()) {
					    days += "Wed ";
					}
					if (thu.isSelected()) {
					    days += "Thu ";
					}
					if (fri.isSelected()) {
					    days += "Fri ";
					}
					if (sat.isSelected()) {
					    days += "Sat ";
					}
					if (sun.isSelected()) {
					    days += "Sun ";
					}
					if (daily.isSelected()) {
					    days += "Daily";
					}
					slp= Integer.parseInt(slpno.getText());
					ac1= Integer.parseInt(ac1no.getText());
					ac2= Integer.parseInt(ac2no.getText());
					ac3= Integer.parseInt(ac3no.getText());
					fslp= Integer.parseInt(slpfare.getText());
					fac1= Integer.parseInt(ac1fare.getText());
					fac3= Integer.parseInt(ac3fare.getText());
					fac2= Integer.parseInt(ac2fare.getText());
					String query="insert into Trains (TRAIN_NUM,NAME,SRC,DEST,DEPARTURE,ARRIVAL,SCHEDULED_ON) values(?,?,?,?,?,?,?)";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setInt(1,no);
					pst.setString(2,name);
					pst.setString(3,from);
					pst.setString(4,to);
					pst.setString(5,dep+""+dtime);
					pst.setString(6,arrive+""+atime);
					pst.setString(7,days);
					pst.executeUpdate();
					pst.close();
					
					String[] classes= {"AC1","AC2","AC3","SLEEPER"};
					//String[] weekDays = {"Sun","Mon", "Tue", "Wed","Thu", "Fri","Sat"};
					//String[] date = {"2025-02-02","2025-02-03","2025-02-04","2025-02-05","2025-02-06","2025-02-07","2025-02-08"}; 
					int numberOfDaysToAdd = 90; // or any number of days in the future
					String[] date = new String[numberOfDaysToAdd];
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

					for (int i = 0; i < numberOfDaysToAdd; i++) {
					    LocalDate futureDate = LocalDate.now().plusDays(i);
					    date[i] = futureDate.format(formatter);
					}
					int[] seats= {ac1,ac2,ac3,slp};
					int[] fare= {fac1,fac2,fac3,fslp};
					if(days.equals("Daily")) {
						for(int i=0;i<date.length; i++) {
								for(int j=0; j<4; j++) {
									setData(no,date[i], classes[j],seats[j],fare[j]);
									for(int k = 1;k<=5;k++) {
										String qs="insert into seat(TRAIN_NUM,DATE,CLASS,COACH_NO,SEAT_NO,AVLB_STATUS) values(?,?,?,?,?,?)";
										PreparedStatement ps=con.prepareStatement(qs);
														ps.setInt(1,no);
														ps.setString(2, date[i]);
														ps.setString(3,classes[j]);
														ps.setInt(4,j+1);
														ps.setInt(5,k);
														if (seats[j] != 0) {
													        String avl = "available";
													        ps.setString(6, avl);
													    } else {
													        String avl = "unavailable";
													        ps.setString(6, avl);
													    }
														ps.executeUpdate();
														ps.close();
				
									}}
							}
					}
					else if(days.length()>1) {
//					String [] day=days.split("\\s+");
//					for(String currDay : day) {
//						for(int i=0;i<weekDays.length; i++) {
//							if(currDay.equals(weekDays[i])) {
//								for(int j=0; j<4; j++) {
//									setData(no,date[i], classes[j],seats[j],fare[j]);
//									for(int k = 1;k<=5;k++) {
//										String qs="insert into seat(TRAIN_NUM,DATE,CLASS,COACH_NO,SEAT_NO,AVLB_STATUS) values(?,?,?,?,?,?)";
//										PreparedStatement pstm=con.prepareStatement(qs);
//														pstm.setInt(1,no);
//														pstm.setString(2, date[i]);
//														pstm.setString(3,classes[j]);
//														pstm.setInt(4,j+1);
//														pstm.setInt(5,k);
//														if (seats[j] != 0) {
//													        String avl = "available";
//													        pstm.setString(6, avl);
//													    } else {
//													        String avl = "unavailable";
//													        pstm.setString(6, avl);
//													    }
//														pstm.executeUpdate();
//														pstm.close();
//								}
//								
//							}
//						}
//					}
//					}
						String[] day = days.split("\\s+");

				        for (int i = 0; i < date.length; i++) {
				            LocalDate localDate = LocalDate.parse(date[i], formatter);
				            String dayOfWeek = localDate.getDayOfWeek().toString().substring(0, 1).toUpperCase() +
				                    localDate.getDayOfWeek().toString().substring(1, 2).toLowerCase() +
				                    localDate.getDayOfWeek().toString().substring(2, 3).toLowerCase(); // "Mon", "Tue", etc.

				            for (String currDay : day) {
				                if (currDay.equals(dayOfWeek)) {
				                    for (int j = 0; j < 4; j++) {
				                        setData(no, date[i], classes[j], seats[j], fare[j]);
				                        for (int k = 1; k <= 5; k++) {
				                            String qs = "insert into seat(TRAIN_NUM,DATE,CLASS,COACH_NO,SEAT_NO,AVLB_STATUS) values(?,?,?,?,?,?)";
				                            PreparedStatement pstm = con.prepareStatement(qs);
				                            pstm.setInt(1, no);
				                            pstm.setString(2, date[i]);
				                            pstm.setString(3, classes[j]);
				                            pstm.setInt(4, j + 1);
				                            pstm.setInt(5, k);
				                            String avl = (seats[j] != 0) ? "available" : "unavailable";
				                            pstm.setString(6, avl);
				                            pstm.executeUpdate();
				                            pstm.close();
				                        }
				                    }
				                }
				            }
					}
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
					JOptionPane.showMessageDialog(null,"details added");
					tname.setText("");
					source.setText("");
					dest.setText("");
					tnum.setText("");
					arr.setText("");
					depart.setText("");
					slpno.setText("");
					ac1no.setText("");
					ac2no.setText("");
					ac3no.setText("");
					slpfare.setText("");
					ac1fare.setText("");
					ac2fare.setText("");
					ac3fare.setText("");
			
			}
		});
		btnAddTrain.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAddTrain.setBounds(289, 555, 125, 39);
		panel_3_2.add(btnAddTrain);
		
		JPanel panel_8_1 = new JPanel();
		panel_8_1.setBackground(new Color(204, 204, 204));
		panel_8_1.setLayout(null);
		panel_8_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_8_1.setBounds(331, 322, 218, 212);
		panel_3_2.add(panel_8_1);
		
		JLabel lblNewLabel_10_1 = new JLabel("FARE OF SEATS");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_10_1.setBounds(64, 11, 117, 24);
		panel_8_1.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("SLEEPER");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_5_1.setBounds(10, 46, 79, 27);
		panel_8_1.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_2_5_1 = new JLabel("AC-I");
		lblNewLabel_2_5_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_5_1.setBounds(20, 84, 49, 23);
		panel_8_1.add(lblNewLabel_2_5_1);
		
		JLabel lblNewLabel_5_3_1 = new JLabel("AC-II");
		lblNewLabel_5_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_3_1.setBounds(20, 119, 49, 21);
		panel_8_1.add(lblNewLabel_5_3_1);
		
		JLabel lblNewLabel_7_3_1 = new JLabel("AC-III");
		lblNewLabel_7_3_1.setBounds(20, 162, 49, 14);
		panel_8_1.add(lblNewLabel_7_3_1);
		
		slpfare = new JTextField();
		slpfare.setColumns(10);
		slpfare.setBounds(99, 50, 96, 20);
		panel_8_1.add(slpfare);
		
		ac1fare = new JTextField();
		ac1fare.setColumns(10);
		ac1fare.setBounds(99, 86, 96, 20);
		panel_8_1.add(ac1fare);
		
		ac2fare = new JTextField();
		ac2fare.setColumns(10);
		ac2fare.setBounds(99, 120, 96, 20);
		panel_8_1.add(ac2fare);
		
		ac3fare = new JTextField();
		ac3fare.setColumns(10);
		ac3fare.setBounds(99, 159, 96, 20);
		panel_8_1.add(ac3fare);
		
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("MODIFY DETAILS", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(204, 204, 255));
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setLayout(null);
		panel_3.setBounds(0, 0, 1108, 700);
		panel_1.add(panel_3);
		
		JLabel lblNewLabel_3 = new JLabel("NAME");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(52, 61, 69, 17);
		panel_3.add(lblNewLabel_3);
		
		trname1 = new JTextField();
		trname1.setColumns(10);
		trname1.setBounds(120, 47, 269, 39);
		panel_3.add(trname1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NUMBER");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(429, 59, 97, 20);
		panel_3.add(lblNewLabel_1_1);
		
		trnum1 = new JTextField();
		trnum1.setColumns(10);
		trnum1.setBounds(536, 47, 269, 39);
		panel_3.add(trnum1);
		
		JLabel lblNewLabel_2_3 = new JLabel("DEPARTURE");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(26, 252, 110, 39);
		panel_3.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("ARRIVAL");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(439, 252, 110, 39);
		panel_3.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("FROM");
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2.setBounds(52, 149, 110, 39);
		panel_3.add(lblNewLabel_2_2_2);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("TO");
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1.setBounds(439, 155, 110, 39);
		panel_3.add(lblNewLabel_2_2_1_1);
		
		trfrom1 = new JTextField();
		trfrom1.setColumns(10);
		trfrom1.setBounds(120, 149, 269, 36);
		panel_3.add(trfrom1);
		
		trto1 = new JTextField();
		trto1.setColumns(10);
		trto1.setBounds(536, 149, 269, 45);
		panel_3.add(trto1);
		
		departure1 = new JTextField();
		departure1.setColumns(10);
		departure1.setBounds(120, 252, 218, 36);
		panel_3.add(departure1);
		
		arrival1 = new JTextField();
		arrival1.setColumns(10);
		arrival1.setBounds(536, 252, 231, 39);
		panel_3.add(arrival1);
		
		JComboBox dcombo = new JComboBox();
		dcombo.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		dcombo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dcombo.setBounds(335, 252, 52, 36);
		panel_3.add(dcombo);
		
		JComboBox acombo = new JComboBox();
		acombo.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		acombo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		acombo.setBounds(763, 252, 52, 36);
		panel_3.add(acombo);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(26, 335, 250, 212);
		panel_3.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NUMBER OF SEATS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(49, 11, 157, 27);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SLEEPER");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(21, 59, 79, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AC-I");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(21, 97, 49, 23);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("AC-II");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(21, 131, 49, 21);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("AC-III");
		lblNewLabel_7.setBounds(21, 171, 49, 14);
		panel.add(lblNewLabel_7);
		
		tfslp = new JTextField();
		tfslp.setBounds(110, 63, 96, 20);
		panel.add(tfslp);
		tfslp.setColumns(10);
		
		tfac1 = new JTextField();
		tfac1.setBounds(110, 99, 96, 20);
		panel.add(tfac1);
		tfac1.setColumns(10);
		
		tfac2 = new JTextField();
		tfac2.setBounds(110, 132, 96, 20);
		panel.add(tfac2);
		tfac2.setColumns(10);
		
		tfac3 = new JTextField();
		tfac3.setBounds(110, 168, 96, 20);
		panel.add(tfac3);
		tfac3.setColumns(10);
		
		JButton btnModify = new JButton("MODIFY");
		btnModify.setBounds(348, 569, 125, 39);
		panel_3.add(btnModify);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="update Trains set NAME='"+trname1.getText()+"'  ,SOURCE='"+trfrom1.getText()+"' ,DEST='"+trto1.getText()+"' ,DEPART='"+departure1.getText()+"' ,ARRIVAL='"+arrival1.getText()+"' where NUM="+trnum1.getText();
					PreparedStatement pst=con.prepareStatement(query);	
					pst.execute();
					JOptionPane.showMessageDialog(null, "data modified");
					pst.close();
					}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e);
					e1.printStackTrace();
				}
			}
		});
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(204, 204, 204));
		panel_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_8.setBounds(314, 335, 250, 212);
		panel_3.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_10 = new JLabel("FARE OF SEATS");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(64, 11, 117, 24);
		panel_8.add(lblNewLabel_10);
		
		JLabel lblNewLabel_1_5 = new JLabel("SLEEPER");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_5.setBounds(10, 46, 79, 27);
		panel_8.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_2_5 = new JLabel("AC-I");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2_5.setBounds(20, 84, 49, 23);
		panel_8.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_5_3 = new JLabel("AC-II");
		lblNewLabel_5_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5_3.setBounds(20, 119, 49, 21);
		panel_8.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_7_3 = new JLabel("AC-III");
		lblNewLabel_7_3.setBounds(20, 162, 49, 14);
		panel_8.add(lblNewLabel_7_3);
		
		slpf = new JTextField();
		slpf.setColumns(10);
		slpf.setBounds(99, 50, 96, 20);
		panel_8.add(slpf);
		
		ac1f = new JTextField();
		ac1f.setColumns(10);
		ac1f.setBounds(99, 86, 96, 20);
		panel_8.add(ac1f);
		
		ac2f = new JTextField();
		ac2f.setColumns(10);
		ac2f.setBounds(99, 120, 96, 20);
		panel_8.add(ac2f);
		
		ac3f = new JTextField();
		ac3f.setColumns(10);
		ac3f.setBounds(99, 159, 96, 20);
		panel_8.add(ac3f);
		
		JPanel panel_9_1 = new JPanel();
		panel_9_1.setLayout(null);
		panel_9_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_9_1.setBackground(new Color(204, 204, 204));
		panel_9_1.setBounds(605, 328, 238, 255);
		panel_3.add(panel_9_1);
		
		JLabel lblNewLabel_11_1 = new JLabel("SCHEDULE ");
		lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11_1.setBounds(81, 0, 125, 33);
		panel_9_1.add(lblNewLabel_11_1);
		
		JCheckBox mon_1 = new JCheckBox("MONDAY");
		mon_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mon_1.setBounds(18, 70, 99, 23);
		panel_9_1.add(mon_1);
		
		JLabel lblNewLabel_12_1 = new JLabel("WEEKLY");
		lblNewLabel_12_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_12_1.setBounds(18, 40, 67, 23);
		panel_9_1.add(lblNewLabel_12_1);
		
		JCheckBox tue_1 = new JCheckBox("TUESDAY");
		tue_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tue_1.setBounds(18, 96, 99, 23);
		panel_9_1.add(tue_1);
		
		JCheckBox wed_1 = new JCheckBox("WEDNESDAY");
		wed_1.setForeground(Color.BLACK);
		wed_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		wed_1.setBounds(18, 122, 99, 23);
		panel_9_1.add(wed_1);
		
		JCheckBox thu_1 = new JCheckBox("THURSDAY");
		thu_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		thu_1.setBounds(18, 150, 99, 23);
		panel_9_1.add(thu_1);
		
		JCheckBox fri_1 = new JCheckBox("FRIDAY");
		fri_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fri_1.setBounds(18, 176, 99, 23);
		panel_9_1.add(fri_1);
		
		JCheckBox sat_1 = new JCheckBox("SATURDAY");
		sat_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sat_1.setBounds(18, 202, 99, 23);
		panel_9_1.add(sat_1);
		
		JCheckBox sun_1 = new JCheckBox("SUNDAY");
		sun_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sun_1.setBounds(18, 228, 99, 23);
		panel_9_1.add(sun_1);
		
		JCheckBox daily_1 = new JCheckBox("DAILY");
		daily_1.setForeground(SystemColor.textHighlight);
		daily_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		daily_1.setBounds(120, 41, 99, 23);
		panel_9_1.add(daily_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("DELETE TRAIN", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(204, 204, 255));
		panel_4.setLayout(null);
		panel_4.setBounds(0, 11, 837, 601);
		panel_2.add(panel_4);
		
		JLabel lblNewLabel_4 = new JLabel("NAME");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(52, 61, 69, 17);
		panel_4.add(lblNewLabel_4);
		
		trName = new JTextField();
		trName.setColumns(10);
		trName.setBounds(120, 47, 269, 39);
		panel_4.add(trName);
		
		JLabel lblNewLabel_1_2 = new JLabel("NUMBER");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(429, 59, 97, 20);
		panel_4.add(lblNewLabel_1_2);
		
		trnum = new JTextField();
		trnum.setColumns(10);
		trnum.setBounds(536, 47, 269, 39);
		panel_4.add(trnum);
		
		JLabel lblNewLabel_2_4 = new JLabel("DEPARTURE");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_4.setBounds(26, 252, 110, 39);
		panel_4.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("ARRIVAL");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_2.setBounds(439, 252, 110, 39);
		panel_4.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_2_3 = new JLabel("FROM");
		lblNewLabel_2_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_3.setBounds(52, 149, 110, 39);
		panel_4.add(lblNewLabel_2_2_3);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("TO");
		lblNewLabel_2_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_2.setBounds(439, 155, 110, 39);
		panel_4.add(lblNewLabel_2_2_1_2);
		
		trfrom = new JTextField();
		trfrom.setColumns(10);
		trfrom.setBounds(120, 149, 269, 36);
		panel_4.add(trfrom);
		
		trto = new JTextField();
		trto.setColumns(10);
		trto.setBounds(536, 149, 269, 45);
		panel_4.add(trto);
		
		departure = new JTextField();
		departure.setColumns(10);
		departure.setBounds(120, 252, 218, 36);
		panel_4.add(departure);
		
		arrival = new JTextField();
		arrival.setColumns(10);
		arrival.setBounds(536, 252, 231, 39);
		panel_4.add(arrival);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String q5 = "DELETE FROM Passenger WHERE PNR IN (SELECT PNR FROM Book_details WHERE TRAIN_NUM = ?)";
					PreparedStatement ps5 = con.prepareStatement(q5);
					ps5.setInt(1, Integer.parseInt(trnum.getText()));
					ps5.execute();
					ps5.close();

					 String q4="delete from Book_details where TRAIN_NUM="+trnum.getText();
		                PreparedStatement pstmt=con.prepareStatement(q4);
		                 pstmt.execute();
		                 pstmt.close();
		                 
		                 String q3="delete from seat where TRAIN_NUM="+trnum.getText();
		                 PreparedStatement pstm=con.prepareStatement(q3);
		                  pstm.execute();
		                  pstm.close();
		                  
		                  String q2="delete from class where TRAIN_NUM="+trnum.getText();
		                  PreparedStatement ps=con.prepareStatement(q2);
		                   ps.execute();
		                   ps.close();
		                   
                String query="delete from Trains where TRAIN_NUM="+trnum.getText();
                 PreparedStatement pst=con.prepareStatement(query);
                pst.execute();
                pst.close();
              
              JOptionPane.showMessageDialog(null,"data deleted");
              trName.setText("");
				trfrom.setText("");
				trto.setText("");
				trnum.setText("");
				arrival.setText("");
				departure.setText("");
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(475, 381, 125, 39);
		panel_4.add(btnDelete);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_3.setBounds(335, 252, 52, 36);
		panel_4.add(comboBox_3);
		
		JComboBox comboBox_1_2 = new JComboBox();
		comboBox_1_2.setModel(new DefaultComboBoxModel(new String[] {"AM", "PM"}));
		comboBox_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1_2.setBounds(763, 252, 52, 36);
		panel_4.add(comboBox_1_2);
		
		JButton btnNewButton = new JButton("GET DETAILS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int number ;
					number = Integer.parseInt(trnum.getText());
					String query="select * from Trains where TRAIN_NUM=? ";
					PreparedStatement pstmt=con.prepareStatement(query);
					pstmt.setInt(1, number);
					ResultSet rst=pstmt.executeQuery();
					String nm= rst.getString("NAME");
					String src=rst.getString("SRC"); 
					String dst=rst.getString("DEST");
					String arrive=rst.getString("ARRIVAL");
					String dep=rst.getString("DEPARTURE");
					trName.setText(nm);
					departure.setText(dep);
					arrival.setText(arrive);
					trfrom.setText(src);
					trto.setText(dst);
					rst.close();
					pstmt.close();
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(190, 381, 125, 39);
		panel_4.add(btnNewButton);
		
		JLabel lblNewLabel_6 = new JLabel("AC-III");
		lblNewLabel_6.setBounds(147, 505, 49, 14);
		contentPane.add(lblNewLabel_6);
	}
}
