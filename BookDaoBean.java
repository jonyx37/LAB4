package struts2;

import java.sql.PreparedStatement;

public class BookDaoBean{
public boolean delete(String... isbn) throws Exception {
PreparedStatement ps=null;
try{
StringBuffer sb=new StringBuffer();
int len=isbn.length;
for(int i=0;i<len;i++){
	sb.append("?,");
}
sb.deleteCharAt(sb.length()-1);
System.out.println("sb="+sb.toString());
String sql="DELETE FROM t_book WHERE isbn in("+sb.toString()+")";
ps=DBHelper.getPS(sql);
for(int i=0;i<len;i++){
ps.setString(i+1,isbn[i]);
}
return ps.executeUpdate()>0;
}finally{
DBHelper.close(ps);
DBHelper.closeConnection();
}
}
}
