<%@taglib uri="/struts-tags"  prefix="s" %>
<form action="bookAction_update" method="post">
  <table>
  <tr>
  <td>Book ID</td>
  <td><input name="isbn" value="<s:property value="book.isbn"/>"></td>
  </tr>
  
  <tr>
  <td>Book Name</td>
  <td><input name="bookName" value="<s:property value="book.bookName"/>"></td>
  </tr>
  
  <tr>
  <td>Book Price</td>
  <td><input name="unitPrice" value="<s:property value="book.unitPrice"/>"></td>
  </tr>
  
  </table>
  
  <input type="submit" value="修改">
  </form>
