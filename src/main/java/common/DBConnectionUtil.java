package common;

import java.sql.Connection;
import javax.naming.Context; 
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnectionUtil {
	
	/**
	 * DB Connection Object Create Static Method
	 * @return Connection
	 */
	public static Connection getConnection() {
		try {
            Context context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool");
            Connection conn = dataSource.getConnection();
			return conn;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param con -> close target Connection
	 * @param stmt -> close target Statement
	 * @param rs -> close target ResultSet
	 */
    public static void close(Connection con, Statement stmt, ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
            	throw new RuntimeException(e);
            }
        }

        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
            	throw new RuntimeException(e);
            }
        }

        if(con != null){
            try {
                con.close();
            } catch (SQLException e) {
            	throw new RuntimeException(e);
            }
        }
    }
}
