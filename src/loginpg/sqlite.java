package loginpg;
import java.sql.*;

import javax.swing.JOptionPane;
public class sqlite {
	Connection con=null;
	public static Connection dbConnect()
	{
		 try {
			 Class.forName("org.sqlite.JDBC");
			 Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\asuds\\OneDrive\\Desktop\\java\\userdetails.db");
			// JOptionPane.showMessageDialog(null,"connection successful");
			 return con;
		 }
		 catch(Exception e) {
			 JOptionPane.showMessageDialog(null,e);
			 return null;
		 }
	}
}
