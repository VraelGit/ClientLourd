package PPE;

import java.sql.Connection;
import java.sql.DriverManager;

public class getCon {
	
	Connection con = null;

	public Connection conBDD()
	{

		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbautopower?serverTimezone=UTC","root","");

		}catch(Exception e){
			System.out.println(e);
		}

		return con;
	}
}