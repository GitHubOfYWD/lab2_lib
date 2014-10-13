<%@ page contentType="text/html;charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head><title>»¶Ó­Ò³Ãæ</title></head>
  <table width="400" height="100">
    <tr>
      <td colspan="4"><s:a href="author_searchAuthor.action?authorname=%{au.name} "><strong><font size="10"><s:property value="au.name"/></font></strong></s:a></td>
    </tr>
    
    
    
    
    <tr>
	<td><strong><font color="red">ID</font></strong></td>
	<td><s:property value="au.id" /></td>
	</tr>
	<tr>
	<td><strong><font color="red">Age</font></strong></td>
	<td><s:property value="au.age" /></td>
	</tr>
	<tr>
	<td><strong><font color="red">Country</font></strong></td>
	<td><s:property value="au.country" /></td>
	</tr>
	
	<tr>
	<td><strong>........................</strong></td>
	<td><strong>........................</strong></td>
	</tr>
	<tr>
	<td><strong>.</strong></td>
	</tr>
	<tr>
	<td><strong>.</strong></td>
	</tr>
    
    
    
    
    
    <s:form theme="simple">
    <s:iterator value="lst" status="satt">
    <tr>
      <td><strong><font color="red">Title:</font></strong></td>
      <td><s:property value="title" /></td>
    </tr>
    <tr>
      <td><strong><font color="red">ISBN:</font></strong></td>
      <td><s:property value="isbn"/></td>
    </tr>
    <tr>
    <td><strong><font color="red">PublishDate:</font></strong></td>
      <td><s:property value="publishDate"/></td>
    </tr>
    <tr>
    <td><strong><font color="red">Publisher:</font></strong></td>
      <td><s:property value="publisher"/></td>
    </tr>
    <tr>
    <td><strong><font color="red">Price:</font></strong></td>
      <td><s:property value="price"/></td>
    </tr>
    <tr>
    </tr>
    </s:iterator>
    <tr><td>...........................</td><td>...........................</td></tr>
	
		<tr><td>.</td></tr>
	<tr>
		<!-- 
		<td> <s:a href="author_delBook.action?isbn=%{isbn}&authorname=%{authorname}" onclick="return confirm('ÄãÈ·¶¨ÒªÉ¾³ý¸Ã¼ÇÂ¼Âð£¿');">É¾³ý</s:a></td>
		 -->
		<td> <s:a href="author_edit.action?isbn=%{isbn}&authorname=%{authorname} ">ÐÞ¸Ä</s:a></td>
	</tr>
	
	<tr><td>.</td></tr>
	<tr>
		<td> <s:a href="author_searchAuthor.action?authorname=%{au.name} ">&#60 Back</s:a></td>
	</tr>
	
	
	<tr><td>.</td></tr>
    <tr><td><s:a href="homepage.jsp">HomePage</s:a></td></tr>
    </s:form>
    
  </table>
</html>