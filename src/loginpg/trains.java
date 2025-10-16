package loginpg;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class trains {
	Connection con=null;
	public static Connection dbConnect()
	{
		 try {
			 Class.forName("org.sqlite.JDBC");
			 Connection con=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\asuds\\OneDrive\\Desktop\\java\\train.db");
			// JOptionPane.showMessageDialog(null,"connection successful");
			 return con;
		 }
		 catch(Exception e) {
			 JOptionPane.showMessageDialog(null,e);
			 return null;
		 }
	}
}
