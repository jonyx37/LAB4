
<script language="javascript" type="text/javascript">
function checkAll(field){
var selectFlags=document.getElementsByName("selectFlag");
for(var i=0;i<selectFlags.length;i++){
selectFlags[i].checked=field.checked;
}
}

function modify(){
var count=0;
var j=0;
var selectFlags=document.getElementsByName("selectFlag");
for(var i=0;i<selectFlags.length;i++){
if(selectFlags[i].checked){
count++;
j=i;
}
	 }

if(count==0){
alert("请选择需要修改的书籍！");
return;
}

if(count>1){
alert("一次只能选择一条记录！");
return;
}

	//window.self.location="bookAction_updateInput?isbn="+selectFlags[j].value;
	location="bookAction_updateInput?isbn="+selectFlags[j].value;
}
function del(){
var flag=false;
var selectFlags=document.getElementsByName("selectFlag");

for(var i=0;i<selectFlags.length;i++){
if(selectFlags[i].checked){
flag=true;
}
}

if(!flag){
alert("请选择需要删除的记录！");
return;
}

if(confirm("确实要删除吗？","提示")){
with(document.getElementById("frm")){
action="bookAction_del";
method="post";
submit();
}
}
}
</script>
<center><h1>书籍列表</h1></center>
<form name="frm">
  <table width="760" border="1" align="center">
<tr  align="center">
<th><input type="checkbox" name="ifAll" onclick="checkAll(this)"/></th>
<th>书号</th>
<th>书名</th>
<th>单价</th>
<th colspan=2>操作类型</th>
</tr>
<s:iterator value="books" var="book">
<tr  align="center">
<td align="center"><input type="checkbox" name="selectFlag" value="<s:property value="#book.isbn"/>"/></td>
<td><s:property value="#book.isbn"/></td>
<td><s:property value="#book.bookName"/></td>
<td><s:property value="#book.unitPrice"/></td>
<td  colspan="2"><a href="javascript:modify()" >修改</a>
<a href="javascript:del()">删除</a></td>
</tr>
</s:iterator>
  </table>
</form>
