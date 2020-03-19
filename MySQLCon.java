package PPE;

import java.util.*;
import java.sql.*;

public class MySQLCon {

	private int nbRow;
	private int usrAct;
	private int authLogin;
	getCon c1 = new getCon();
	
	Connection con = c1.conBDD();

	public ArrayList<String> getUsername()
	{	
		ArrayList<String> uLogin = new ArrayList<String>();

		try{
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery("select uLogin from utilisateur");

			rs.beforeFirst();
			while(rs.next()){
				uLogin.add(rs.getString(1));	
			}

			stmt.close();
			rs.close();

		}catch(Exception e){
			System.out.println(e);
		}

		return uLogin;
	}

	public int activateUsrAcc(String usrAcc)
	{

		try{
			Statement stmt = con.createStatement();
			
			nbRow = stmt.executeUpdate("update utilisateur set uActif = 1 where ulogin = '"+usrAcc+"'");

			stmt.close();

		}catch(Exception e){
			System.out.println(e);
		}

		return nbRow;
	}

	public int verifActivAcc(String usrAcc)
	{

		try{
			Statement stmt = con.createStatement();	
			
			ResultSet rs = stmt.executeQuery("select uActif from utilisateur where ulogin = '"+usrAcc+"'");
			
			if(rs.next()){
				usrAct = rs.getInt(1);
			}
			
			stmt.close();
			rs.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return usrAct;
	}
	
	public ArrayList<String> ActivAcc()
	{

		ArrayList<String> uActif = new ArrayList<String>();
		
		try{
			Statement stmt = con.createStatement();	
			
			ResultSet rs = stmt.executeQuery("select uActif from utilisateur");
			
			rs.beforeFirst();
			while(rs.next()){
				uActif.add(rs.getString(1));	
			}
			
			stmt.close();
			rs.close();
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return uActif;
	}
	
	public int deactivateUsrAcc(String usrAcc)
	{

		try{
			Statement stmt = con.createStatement();
			
			nbRow = stmt.executeUpdate("update utilisateur set uActif = 0 where ulogin = '"+usrAcc+"'");

			stmt.close();

		}catch(Exception e){
			System.out.println(e);
		}

		return nbRow;
	}
	
	public int login(String login, String pass)
	{
		try{
			Statement stmt = con.createStatement();
			
			ResultSet verifLogin = stmt.executeQuery("select uadmin from utilisateur where ulogin = '"+login+"' and uMDP = '"+pass+"'");
			
			verifLogin.beforeFirst();
			while(verifLogin.next()){
				authLogin = verifLogin.getInt(1);	
			}
			
			stmt.close();
			verifLogin.close();

		}catch(Exception e){
			System.out.println(e);
		}

		return authLogin;
	}
	
}
