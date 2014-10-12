package struts2;

LAST edit；

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Service;

import struts2.bookService;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public abstract class BookAction extends ActionSupport implements ModelDriven<Book>{
private String[] selectFlag;
public String[] getSelectFlag() {
	return selectFlag;
}
public void setSelectFlag(String[] selectFlag) {
	this.selectFlag = selectFlag;
}
private Book book=new Book();
public Book getBook() {
	return book;
}
private List<Book> books=new ArrayList<Book>();
private String isbn;
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
public List<Book> getBooks() {
return books;
}
private String msg;
public String getMsg() {
	return msg;
}
//private BookService bookService=Service.getBookService();
public String updateInput() throws Exception{
	 isbn=ServletActionContext.getRequest().getParameter("isbn");
System.out.println("updateInput:"+isbn);
//this.book=bookService.select(isbn);
return "updateInput";
}
public String update() throws Exception{
System.out.println("book="+book);
//if(bookService.update(book))
{
this.msg="图书修改成功！";
System.out.println("---update------");
return "update";
}
}

public String del() throws Exception{
//bookService.delete(selectFlag);
this.msg="图书删除成功！";
System.out.println("---del------");
return "del";
}
public String select() throws Exception{
//books=bookService.select();
System.out.println("---select------");
return "select";
}

public String execute() throws Exception {
	return super.execute();
}
public String add() throws Exception{
//struts2.bookService.add(this.getModel());
this.msg="图书添加成功！";
System.out.println("---add------");
return "add";
}
public void validateAdd() throws Exception{
//if("".equals(book.getIsbn()))
	{
this.addFieldError("isbn","图书编号不能为空！");
}

//if("".equals(book.getBookName()))
	{
this.addFieldError("bookName","图书名称不能为空！");
}
}
}

