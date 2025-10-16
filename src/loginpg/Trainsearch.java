package loginpg;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Trainsearch extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String selectedClassName = null;
	int selectedTRAIN_NUM = 0;
	int pnr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
//				try {
//					//Trainsearch frame = new Trainsearch();
//					//frame.setVisible(true);
//						
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Connection con=null;
	private JTable table;
	private JTable table_1;
	private JTextField p1name;
	private JTextField p1age;
	private JTextField pnum;
	private JTextField p2name;
	private JTextField p2age;
	private JTextField p3name;
	private JTextField p3age;
	
	
	public Trainsearch(String source,String destination,String date) {
		
		con=trains.dbConnect();
		System.out.println(date);
		System.out.println(destination);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1238, 688);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(170, 201, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("GET DETAILS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				 String query="SELECT DISTINCT t.NAME, t.TRAIN_NUM,t.DEPARTURE,t.ARRIVAL,t.SCHEDULED_ON,c.DATE FROM Trains t JOIN class c ON t.TRAIN_NUM=c.TRAIN_NUM WHERE t.SRC=? AND t.DEST=? AND c.DATE=?";
					PreparedStatement pstmt=con.prepareStatement(query);
					pstmt.setString(1,source);
					pstmt.setString(2, destination);
					pstmt.setString(3, date);
					ResultSet rst=pstmt.executeQuery();
					if(rst!=null) {
					table.setModel(DbUtils.resultSetToTableModel(rst));
					table.setRowHeight(20);
					table.setFont(new Font("Times New Roman", Font.PLAIN, 19));
					Font headerFont =new Font("Times New Roman", Font.BOLD, 19);
					table.getTableHeader().setFont(headerFont);
					}
					rst.close();
					pstmt.close();
				}
				catch(Exception e1) {
					System.out.println(e1);
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(481, 0, 149, 48);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 54, 819, 172);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 809, 167);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
       // scrollPane.setVisible(false);
        

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 237, 819, 378);
		contentPane.add(scrollPane_1);
		//scrollPane_1.setVisible(false);
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			 int r = table.getSelectedRow();
			    int c = table.getSelectedColumn();
			   selectedTRAIN_NUM=(int)table.getModel().getValueAt(r, c);
			    try {
			    	String query = "SELECT TL.TRAIN_NUM,TL.NAME , CT.DATE, CT.CLASS,CT.AVLB_SEATS, CT.FARE " +
			                   "FROM class CT " +
			                   "JOIN Trains TL ON CT.TRAIN_NUM = TL.TRAIN_NUM  " +
			                   "WHERE CT.TRAIN_NUM = ? AND CT.DATE = ?";
			        PreparedStatement pstmt = con.prepareStatement(query);
			       
					pstmt.setInt(1, selectedTRAIN_NUM);
			        pstmt.setString(2, date);
			        ResultSet rs = pstmt.executeQuery();
			        table_1.setModel(DbUtils.resultSetToTableModel(rs));
			        table_1.setRowHeight(20);
			        Font font = new Font("Times New Roman", Font.PLAIN, 14); 
			        table_1.setFont(font);
			        Font headerFont = new Font("Times New Roman", Font.BOLD, 15); 
			        table_1.getTableHeader().setFont(headerFont);
			        rs.close();
			        pstmt.close();
			    } 
			    catch (Exception e1) {
			        JOptionPane.showMessageDialog(null, e1);
			    }
		}
		
	});

		
		
		
		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 int r = table_1.getSelectedRow();
				    int c = table_1.getSelectedColumn();
				    selectedClassName = String.valueOf(table_1.getModel().getValueAt(r, c));
				   

				   //selectedClassName=(String)table_1.getModel().getValueAt(r, c);
				   JOptionPane.showMessageDialog(null,selectedClassName);
			}
			
		});
		
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(839, 11, 385, 578);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		p1name = new JTextField();
		p1name.setBounds(143, 103, 232, 32);
		panel_1.add(p1name);
		p1name.setColumns(10);
		p1name.setVisible(false);
		
		JLabel lblname = new JLabel("PASSENGER\r\n NAME:");
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblname.setBounds(20, 101, 130, 32);
		panel_1.add(lblname);
		lblname.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("PASSENGER DETAILS");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(156, 11, 174, 38);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblgender = new JLabel("GENDER:\r\n");
		lblgender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblgender.setBounds(37, 152, 85, 17);
		panel_1.add(lblgender);
		lblgender.setVisible(false);
		
		JLabel lblage = new JLabel("AGE:");
		lblage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblage.setBounds(56, 207, 49, 14);
		panel_1.add(lblage);
		lblage.setVisible(false);
		
		p1age = new JTextField();
		p1age.setBounds(143, 200, 232, 32);
		panel_1.add(p1age);
		p1age.setColumns(10);
		p1age.setVisible(false);
		
		JLabel lblNewLabel_4 = new JLabel("No. of passengers :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 60, 130, 23);
		panel_1.add(lblNewLabel_4);
		
		
		pnum = new JTextField();
		pnum.setBounds(143, 60, 49, 32);
		panel_1.add(pnum);
		pnum.setColumns(10);
		
		JLabel lblp2 = new JLabel("PASSENGER NAME:");
		lblp2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblp2.setBounds(10, 264, 138, 32);
		panel_1.add(lblp2);
		lblp2.setVisible(false);
		
		JLabel lblg2 = new JLabel("GENDER:");
		lblg2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblg2.setBounds(55, 322, 85, 23);
		panel_1.add(lblg2);
		lblg2.setVisible(false);
		
		JLabel lbla2 = new JLabel("AGE:");
		lbla2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbla2.setBounds(73, 378, 49, 14);
		panel_1.add(lbla2);
		lbla2.setVisible(false);
		p2name = new JTextField();
		p2name.setBounds(143, 260, 232, 32);
		panel_1.add(p2name);
		p2name.setColumns(10);
		p2name.setVisible(false);
		p2age = new JTextField();
		p2age.setBounds(143, 377, 232, 32);
		panel_1.add(p2age);
		p2age.setColumns(10);
		p2age.setVisible(false);
		JLabel lblp3 = new JLabel("PASSENGER NAME:\r\n");
		lblp3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblp3.setBounds(18, 435, 122, 32);
		panel_1.add(lblp3);
		lblp3.setVisible(false);
		
		JLabel lblg3 = new JLabel("GENDER:");
		lblg3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblg3.setBounds(55, 484, 85, 23);
		panel_1.add(lblg3);
		lblg3.setVisible(false);
		JLabel lbla3 = new JLabel("AGE:");
		lbla3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbla3.setBounds(73, 541, 49, 14);
		panel_1.add(lbla3);
		lbla3.setVisible(false);
		p3name = new JTextField();
		p3name.setColumns(10);
		p3name.setBounds(143, 435, 232, 32);
		panel_1.add(p3name);
		p3name.setVisible(false);
		p3age = new JTextField();
		p3age.setColumns(10);
		p3age.setBounds(143, 534, 232, 32);
		p3age.setVisible(false);
		panel_1.add(p3age);
		
		JComboBox p1gender = new JComboBox();
		p1gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		p1gender.setModel(new DefaultComboBoxModel(new String[] {"male", "female", "others"}));
		p1gender.setBounds(143, 146, 232, 32);
		p1gender.setVisible(false);
		panel_1.add(p1gender);
		
		JComboBox p2gender = new JComboBox();
		p2gender.setModel(new DefaultComboBoxModel(new String[] {"male", "female", "others"}));
		p2gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		p2gender.setBounds(143, 313, 232, 32);
		p2gender.setVisible(false);
		panel_1.add(p2gender);
		
		JComboBox p3gender = new JComboBox();
		p3gender.setModel(new DefaultComboBoxModel(new String[] {"male", "female", "others"}));
		p3gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		p3gender.setBounds(143, 486, 232, 32);
		p3gender.setVisible(false);
		panel_1.add(p3gender);
		
		
	
		JButton btnNewButton_1 = new JButton("Enter details");
		

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
            try {
            	int n=Integer.parseInt(pnum.getText());
            	
                if (n == 1) {
                	lblname.setVisible(true);
                	lblgender.setVisible(true);
                	lblage.setVisible(true);
                	
                    p1name.setVisible(true);
                    p1gender.setVisible(true);
                    p1age.setVisible(true);
                }
                else if(n==2) {
                     	lblname.setVisible(true);
                     	lblgender.setVisible(true);
                     	lblage.setVisible(true);
                     	
                         p1name.setVisible(true);
                         p1gender.setVisible(true);
                         p1age.setVisible(true);
                         
                         lblp2.setVisible(true);
                         lblg2.setVisible(true);
                         lbla2.setVisible(true);
                         p2name.setVisible(true);
                         p2gender.setVisible(true);
                         p2age.setVisible(true);
                }     
                else if(n==3) {  
                	lblname.setVisible(true);
                 	lblgender.setVisible(true);
                 	lblage.setVisible(true);
                 	
                     p1name.setVisible(true);
                     p1gender.setVisible(true);
                     p1age.setVisible(true);
                     
                     lblp2.setVisible(true);
                     lblg2.setVisible(true);
                     lbla2.setVisible(true);
                     p2name.setVisible(true);
                     p2gender.setVisible(true);
                     p2age.setVisible(true);
                         lblp3.setVisible(true);
                         lblg3.setVisible(true);
                         lbla3.setVisible(true);
                         p3name.setVisible(true);
                         p3gender.setVisible(true);
                         p3age.setVisible(true);             
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                }
                
              }
                catch(Exception e1) {
                	JOptionPane.showMessageDialog(null, "n should not be zero");
                }
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(224, 60, 153, 32);
		panel_1.add(btnNewButton_1);
		
		
		
		JButton book = new JButton("BOOK NOW");
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int[] age=new int[3];
				    int[] sno = new int[3];
				    String[] cno=new String[3];
		    	String[] nm=new String[3];
		    	String[] gen=new String[3];
		    	Random rand=new Random();
					int n=Integer.parseInt(pnum.getText());
					if(n==1) {
						nm[0]=p1name.getText();
						age[0]=Integer.parseInt(p1age.getText());
						gen[0]=(String) p1gender.getSelectedItem();
						}
					else if(n==2) {
						nm[0]=p1name.getText();
						age[0]=Integer.parseInt(p1age.getText());
						gen[0]=(String) p1gender.getSelectedItem();
						nm[1]=p2name.getText();
						age[1]=Integer.parseInt(p2age.getText());
						gen[1]=(String) p2gender.getSelectedItem();
					}
					else if(n==3) {
						nm[0]=p1name.getText();
						age[0]=Integer.parseInt(p1age.getText());
						gen[0]=(String) p1gender.getSelectedItem();
						nm[1]=p2name.getText();
						age[1]=Integer.parseInt(p2age.getText());
						gen[1]=(String) p2gender.getSelectedItem();
						nm[2]=p3name.getText();
						age[2]=Integer.parseInt(p3age.getText());
						gen[2]=(String) p3gender.getSelectedItem();
					}
					
					String q="SELECT FARE,AVLB_SEATS FROM class WHERE CLASS='"+ selectedClassName + "' AND DATE='" + date +"' AND TRAIN_NUM="+ selectedTRAIN_NUM;
					PreparedStatement pstmt=con.prepareStatement(q);
					ResultSet rsClass=pstmt.executeQuery();
					//JOptionPane.showMessageDialog(null,"data fetched from class table  "+ selectedClassName+ ""+ date+ "" +selectedTRAIN_NUM);
			    	int availableSeats=0;
			    	int fare = 0;
					if(rsClass.next()) {
						fare = rsClass.getInt("FARE");
						 availableSeats= rsClass.getInt("AVLB_SEATS");	
						// JOptionPane.showMessageDialog(null, availableSeats);
					}
					rsClass.close();
					pstmt.close();	
					if(availableSeats>=n) {
					String q1="SELECT COACH_NO, SEAT_NO FROM seat WHERE DATE=? AND AVLB_STATUS='available' AND CLASS=? AND TRAIN_NUM=?";
				    PreparedStatement pstmt1=con.prepareStatement(q1);
				    
				    pstmt1.setString(1, date);
				    pstmt1.setString(2, selectedClassName);
				    pstmt1.setInt(3, selectedTRAIN_NUM);
				    ResultSet rs=pstmt1.executeQuery();
				   // JOptionPane.showMessageDialog(null,"data fetched from seat table");
				    int c=0;
				    int i=0;
				    
				    while(rs.next() && c<n ) {
				    	cno[i]=rs.getString("COACH_NO");
				    	 sno[i]=rs.getInt("SEAT_NO");
				    	c++;i++;
				    }
				    rs.close();
				    pstmt1.close();
				    pnr=rand.nextInt(999999)+100000;
				    	for(int j=0;j<n;j++) {
				    		String q2="INSERT INTO passenger(Pname,Age,Gender,CoachNo,SeatNo,PNR) VAlUES(?,?,?,?,?,?)";
				    		PreparedStatement pstmt2=con.prepareStatement(q2);
				    		//JOptionPane.showMessageDialog(null,"data inserted in passenger table");
				    		pstmt2.setString(1, nm[j]);
			    			pstmt2.setInt(2, age[j]);
			    			pstmt2.setString(3, gen[j]);
			    			pstmt2.setString(4, cno[j]);
			    			pstmt2.setInt(5, sno[j]);
			    			pstmt2.setInt(6, pnr);
			    			pstmt2.executeUpdate();
			    			pstmt2.close();
				    		    
				    	String q3="UPDATE seat SET AVLB_STATUS='booked' WHERE CLASS=? AND TRAIN_NUM=? AND DATE=? AND COACH_NO=? AND SEAT_NO=?";
				    	PreparedStatement pstmt3=con.prepareStatement(q3);
				    	pstmt3.setString(1, selectedClassName);
		    			pstmt3.setInt(2, selectedTRAIN_NUM);
		    			pstmt3.setString(3, date);
		    			pstmt3.setString(4, cno[j]);
		    			pstmt3.setInt(5, sno[j]);
		    			pstmt3.executeUpdate();
		    			pstmt3.close();
		    			String q4="INSERT INTO Book_details(PNR,TRAIN_NUM,DATE,CLASS) VALUES(?,?,?,?)";
		    			PreparedStatement pstmt4=con.prepareStatement(q4);
				    	pstmt4.setInt(1, pnr);
		    			pstmt4.setInt(2, selectedTRAIN_NUM);
		    			pstmt4.setString(3, date);
		    			pstmt4.setString(4, selectedClassName);
		    			pstmt4.execute();
		    			pstmt4.close();
				}
				    	int totalFare=fare*n;
				    	JOptionPane.showMessageDialog(null,"Seat booked Successfully! total fare: "+totalFare);
				    	Ticket t=new Ticket(selectedTRAIN_NUM, pnr, selectedClassName,n, date);
				    	t.setVisible(true);
				    	String q4="UPDATE class SET AVLB_SEATS=AVLB_SEATS-"+n +" WHERE CLASS='"+selectedClassName + "' AND DATE='" + date +"' AND TRAIN_NUM="+ selectedTRAIN_NUM;
				    	PreparedStatement pst=con.prepareStatement(q4);
				    	pst.executeUpdate();
				    	
				    	pst.close();	
				    	//JOptionPane.showMessageDialog(null,q4);
				    	
					}
					else{
						JOptionPane.showMessageDialog(null,"Not enough seats available!");
					}
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
				}
		});
		book.setForeground(new Color(0, 0, 255));
		book.setFont(new Font("Tahoma", Font.PLAIN, 14));
		book.setBounds(946, 600, 134, 40);
		contentPane.add(book);
	
}
	}
		

