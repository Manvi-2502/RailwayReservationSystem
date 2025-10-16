package loginpg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.SystemColor;

public class Ticket extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int selectedTRAIN_NUM=0;
					int pnr=0;
					String selectedClassName=null;
					int n=0;
					String date=null;
					Ticket frame = new Ticket(selectedTRAIN_NUM, pnr, selectedClassName,n, date);
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
	public Ticket(int selectedTRAIN_NUM,int pnr,String selectedClassName,int n,String date) {
		con=trains.dbConnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1227, 650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(191, 224, 251));
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(65, 105, 225)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PASSENGER \r\nNAME :");
		lblNewLabel.setBounds(10, 87, 180, 41);
		lblNewLabel.setForeground(new Color(5, 18, 133));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TRAIN  TICKET");
		lblNewLabel_1.setBounds(10, 11, 350, 41);
		lblNewLabel_1.setForeground(SystemColor.activeCaptionText);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.ITALIC, 26));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("FROM :");
		lblNewLabel_2.setBounds(756, 404, 101, 41);
		lblNewLabel_2.setForeground(new Color(5, 18, 133));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TO :");
		lblNewLabel_3.setBounds(756, 479, 72, 34);
		lblNewLabel_3.setForeground(new Color(5, 18, 133));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("GENDER :");
		lblNewLabel_4.setBounds(27, 167, 95, 34);
		lblNewLabel_4.setForeground(new Color(5, 18, 133));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("DATE :");
		lblNewLabel_5.setBounds(39, 559, 83, 34);
		lblNewLabel_5.setForeground(new Color(5, 18, 133));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("TRAIN NAME :");
		lblNewLabel_6.setBounds(745, 156, 137, 54);
		lblNewLabel_6.setForeground(new Color(5, 18, 133));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("AGE :");
		lblNewLabel_7.setBounds(27, 234, 67, 54);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setForeground(new Color(5, 18, 133));
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("CLASS :");
		lblNewLabel_8.setBounds(27, 407, 95, 35);
		lblNewLabel_8.setForeground(new Color(5, 18, 133));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("PNR :");
		lblNewLabel_9.setBounds(745, 11, 112, 37);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("SEAT NO. :");
		lblNewLabel_10.setBounds(27, 328, 120, 41);
		lblNewLabel_10.setForeground(new Color(5, 18, 133));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("COACH NO. :");
		lblNewLabel_11.setBounds(27, 489, 110, 25);
		lblNewLabel_11.setForeground(new Color(5, 18, 133));
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("TRAIN NUM :");
		lblNewLabel_12.setBounds(745, 87, 137, 42);
		lblNewLabel_12.setForeground(new Color(5, 18, 133));
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("PRICE :");
		lblNewLabel_13.setBounds(756, 556, 95, 28);
		lblNewLabel_13.setForeground(new Color(5, 18, 133));
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_13);
		
		JLabel name1 = new JLabel("n1");
		name1.setBounds(223, 87, 166, 30);
		name1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(name1);
		
		JLabel gen1 = new JLabel("g1");
		gen1.setBounds(218, 169, 83, 30);
		gen1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(gen1);
		
		JLabel age1 = new JLabel("a1");
		age1.setBounds(223, 244, 83, 30);
		age1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(age1);
		
		JLabel Class = new JLabel("cls");
		Class.setBounds(223, 409, 180, 30);
		Class.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(Class);
		
		JLabel seat1 = new JLabel("s1");
		seat1.setBounds(223, 333, 137, 30);
		seat1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(seat1);
		
		JLabel coach = new JLabel("cno");
		coach.setBounds(223, 486, 180, 30);
		coach.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(coach);
		
		JLabel pnrNo = new JLabel("");
		pnrNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnrNo.setBounds(892, 22, 180, 30);
		contentPane.add(pnrNo);
		
		JLabel trname = new JLabel("tn");
		trname.setBounds(913, 169, 180, 30);
		trname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(trname);
		
		JLabel from = new JLabel("f");
		from.setBounds(923, 409, 180, 30);
		from.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(from);
		
		JLabel tnum = new JLabel("trno");
		tnum.setBounds(913, 93, 180, 30);
		tnum.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(tnum);
		
		JLabel to = new JLabel("t");
		to.setBounds(913, 486, 180, 30);
		to.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(to);
		
		JLabel Date = new JLabel("dt");
		Date.setBounds(223, 556, 166, 30);
		Date.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(Date);
		
		JLabel price = new JLabel("pr");
		price.setBounds(923, 556, 180, 30);
		price.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(price);
		
		JLabel lblNewLabel_12_1 = new JLabel("DEPARTURE :");
		lblNewLabel_12_1.setBounds(745, 241, 160, 41);
		lblNewLabel_12_1.setForeground(new Color(5, 18, 133));
		lblNewLabel_12_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_12_1);
		
		JLabel lblNewLabel_12_2 = new JLabel("ARRIVAL :");
		lblNewLabel_12_2.setBounds(756, 328, 101, 41);
		lblNewLabel_12_2.setForeground(new Color(5, 18, 133));
		lblNewLabel_12_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_12_2);
		
		JLabel arrive = new JLabel("arr");
		arrive.setBounds(923, 333, 180, 30);
		arrive.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(arrive);
		
		JLabel depart = new JLabel("dpt");
		depart.setBounds(913, 246, 180, 30);
		depart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(depart);
		
		JLabel name2 = new JLabel("");
		name2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		name2.setBounds(399, 87, 137, 30);
		contentPane.add(name2);
		
		JLabel name3 = new JLabel("");
		name3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		name3.setBounds(559, 87, 160, 36);
		contentPane.add(name3);
		
		JLabel gen2 = new JLabel("");
		gen2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gen2.setBounds(402, 167, 78, 34);
		contentPane.add(gen2);
		
		JLabel gen3 = new JLabel("");
		gen3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		gen3.setBounds(559, 167, 83, 34);
		contentPane.add(gen3);
		
		JLabel age2 = new JLabel("");
		age2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		age2.setBounds(403, 248, 49, 26);
		contentPane.add(age2);
		
		JLabel age3 = new JLabel("");
		age3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		age3.setBounds(563, 234, 56, 36);
		contentPane.add(age3);
		
		JLabel seat2 = new JLabel("");
		seat2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		seat2.setBounds(416, 336, 36, 25);
		contentPane.add(seat2);
		
		JLabel seat3 = new JLabel("");
		seat3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		seat3.setBounds(563, 330, 56, 40);
		contentPane.add(seat3);
		try {
		String query="SELECT * FROM Passenger WHERE PNR=?";
		PreparedStatement pstmt=con.prepareStatement(query);
		pstmt.setLong(1,pnr);
		ResultSet rs = pstmt.executeQuery();
		
//		if(rs.next()) {
//			name1.setText(rs.getString("Pname"));
//			age1.setText(String.valueOf(rs.getInt("Age")));
//			gen1.setText(rs.getString("Gender"));
//			coach.setText(String.valueOf(rs.getInt("CoachNo")));
//			seat1.setText(String.valueOf(rs.getInt("SeatNo")));
//			
//		}
//		if(rs.next()) {
//			name2.setText(rs.getString("Pname"));
//			age2.setText(String.valueOf(rs.getInt("Age")));
//		gen2.setText(rs.getString("Gender"));
//			seat2.setText(String.valueOf(rs.getInt("SeatNo")));
//			
//		}
//		if(rs.next()) {
//			name3.setText(rs.getString("Pname"));
//			age3.setText(String.valueOf(rs.getInt("Age")));
//			gen3.setText(rs.getString("Gender"));
//		seat3.setText(String.valueOf(rs.getInt("SeatNo")));
//		}
		int count = 0;
		while (rs.next() && count<n) {
			 count++;
		    if (count == 1) {
		        name1.setText(rs.getString("Pname"));
		        age1.setText(String.valueOf(rs.getInt("Age")));
		        gen1.setText(rs.getString("Gender"));
		        coach.setText(String.valueOf(rs.getInt("CoachNo")));
		        seat1.setText(String.valueOf(rs.getInt("SeatNo")));
		    } else if (count == 2) {
		        name2.setText(rs.getString("Pname"));
		        age2.setText(String.valueOf(rs.getInt("Age")));
		        gen2.setText(rs.getString("Gender"));
		        seat2.setText(String.valueOf(rs.getInt("SeatNo")));
		    } else if (count == 3) {
		        name3.setText(rs.getString("Pname"));
		        age3.setText(String.valueOf(rs.getInt("Age")));
		        gen3.setText(rs.getString("Gender"));
		        seat3.setText(String.valueOf(rs.getInt("SeatNo")));
		    }
		   
		}
		System.out.println("Total rows fetched: " + count);

		
//		JLabel[] names = {name1, name2, name3};
//		JLabel[] ages = {age1, age2, age3};
//		JLabel[] gens = {gen1, gen2, gen3};
//		JLabel[] seats = {seat1, seat2, seat3};
//
//		int i = 0;
//		while (rs.next() && i < 3) {
//		    names[i].setText(rs.getString("Pname"));
//		    ages[i].setText(String.valueOf(rs.getInt("Age")));
//		    gens[i].setText(rs.getString("Gender"));
//		    seats[i].setText(String.valueOf(rs.getInt("SeatNo")));
//		    if (i == 0) { // only set coach once if it's common to all passengers
//		        coach.setText(String.valueOf(rs.getInt("CoachNo")));
//		    }
//		    i++;
//		}

		rs.close();
		pstmt.close();
		
		String q="SELECT * FROM Book_details WHERE PNR = ?";
		PreparedStatement pstmt1=con.prepareStatement(q);
		pstmt1.setLong(1, pnr);
		ResultSet rs1=pstmt1.executeQuery();
	while(rs1.next()) {
			tnum.setText(String.valueOf(rs1.getInt("TRAIN_NUM")));
			pnrNo.setText(String.valueOf(rs1.getInt("PNR")));
			Date.setText(rs1.getString("DATE"));
			Class.setText(rs1.getString("CLASS"));
		}
	rs1.close();
	pstmt1.close();
	String q1="SELECT * FROM TRAINS WHERE TRAIN_NUM="+selectedTRAIN_NUM;
	PreparedStatement pstmt2=con.prepareStatement(q1);
	ResultSet rs2=pstmt2.executeQuery();
	while(rs2.next()) {
		trname.setText(rs2.getString("NAME"));
		from.setText(rs2.getString("SRC"));
		to.setText(rs2.getString("DEST"));
		arrive.setText(rs2.getString("ARRIVAL"));
		depart.setText(rs2.getString("DEPARTURE"));
		
	}
	rs2.close();
	pstmt2.close();
String q2="SELECT FARE FROM CLASS WHERE CLASS= ?";
PreparedStatement pstmt3=con.prepareStatement(q2);
pstmt3.setString(1, selectedClassName);
ResultSet rs3=pstmt3.executeQuery();
while(rs3.next()) {
	int fareForOnePassenger = rs3.getInt("FARE");
    int totalFare = fareForOnePassenger * n; // Calculate total fare for n passengers
    price.setText(String.valueOf(totalFare)); 
}
	rs3.close();
	pstmt3.close();
	}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null,e1);
		}
	}
}
