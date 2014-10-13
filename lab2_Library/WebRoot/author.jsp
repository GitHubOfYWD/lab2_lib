<%@ page contentType="text/html;charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>»¶Ó­Ò³Ãæ</title>
</head>
<table width="650" height="100">
	<tr>
		<td colspan="4"><strong><font size="5"><s:property value="authorname" /></strong>
		</td>
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
	<tr>
	<td><strong><font size="5">All Books</strong></td>
	</tr>
	<tr>
		<!--<td>AuthorID</td>  -->
		<td><strong><strong><font color="red">Title</font></strong></strong></td>
		<td><strong><strong><font color="red">ISBN</font></strong></strong></td>
		<!-- <td>PublishDate</td> -->
		<!-- <td>Publisher</td> -->
		<!-- <td>Price</td> -->
		<td></td>
	</tr>
	<s:form theme="simple">
		<s:iterator value="lst" status="satt">
			<tr>
				<!--<td><s:property value="authorID"/></td>-->
				<!--<s:textfield name="authorID"/>-->
				<!--  <td><s:property value="authorID"/></td> -->
				<td><s:a href="author_showBook.action?isbn=%{isbn}&authorname=%{authorname} ">
						<s:property value="title" />
					</s:a>
				</td>
				<td><s:property value="isbn" />
				</td>
				<!--<td><s:property value="publishDate"/></td> -->
				<!--<td><s:property value="publisher"/></td> -->
				<!--<td><s:property value="price"/></td> -->
				<td> <s:a href="author_delBook.action?isbn=%{isbn}&authorname=%{authorname} " onclick="return confirm('ÄãÈ·¶¨ÒªÉ¾³ý¸Ã¼ÇÂ¼Âð£¿');">É¾³ý</s:a></td>
      <!--<td> <s:a href="homepage.jsp" onclick="return confirm('ÄãÈ·¶¨ÒªÉ¾³ý¸Ã¼ÇÂ¼Âð£¿');">É¾³ý</s:a></td>  -->
			</tr>
		</s:iterator>
		<tr><td>...........................</td><td>...........................</td></tr>
		<tr>
		<tr><td>.</td></tr>
		<tr>
		<td> <s:a href="Add Book.jsp">Add Book</s:a></td>
		</tr>
		<tr><td>.</td></tr>
		<tr>
		<td> <s:a href="homepage.jsp">&#60 Back</s:a></td>
		</tr>
		<tr><td>.</td></tr>
		<tr>
			<td><s:a href="homepage.jsp">HomePage</s:a>
			</td>
		</tr>
	</s:form>

</table>
</html>