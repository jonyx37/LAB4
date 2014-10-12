package struts2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBHelper {

private static String driverName;

private static String url;

private static String userName;

private static String pwd;

private static ThreadLocal<Connection> connectionHolder=new ThreadLocal<Connection>();

static{
ResourceBundle rb=ResourceBundle.getBundle("db-config");
driverName=rb.getString("driverName");
url=rb.getString("url");
userName=rb.getString("userName");
pwd=rb.getString("pwd");

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
private static Connection getConnection() throws SQLException{
Connection conn=connectionHolder.get();
if(conn==null){
//得到连接对象
conn=DriverManager.getConnection(url,userName,pwd);
//将连接对象放入ThreadLocal对象中
connectionHolder.set(conn);
}

return conn;
}
public static void closeConnection() throws SQLException{
Connection conn=connectionHolder.get();

if(conn!=null){
conn.close();
conn=null;
connectionHolder.remove();
}
}
public static PreparedStatement getPS(String sql) throws SQLException{
	return getConnection().prepareStatement(sql);
}
public static ResultSet getRS(PreparedStatement ps) throws SQLException{
	return ps.executeQuery();
}
public static void close(PreparedStatement ps) throws SQLException{
if(ps!=null){
ps.close();
ps=null;
}
}

public static void close(ResultSet rs) throws SQLException{
if(rs!=null){
rs.close();
rs=null;
}
}

}
