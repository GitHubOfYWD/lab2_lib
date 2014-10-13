<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
 <body>
 <s:form>
<tr><td><strong><font size="6" color="red">Library of Weidong Yuan ^_^</font></strong></td></tr>
</s:form>
<s:form>
<tr>
		<td> <s:a href="Add Author.jsp">Add Author</s:a></td>
</tr>
<tr><td>.</td></tr>
<!--
<h3>Add author</h3>
<s:form action="HelloWorld">
<s:textfield name="id" label="AuthorID"/>
<s:textfield name="name" label="name" />
<s:textfield name="age" label="age" />
<s:textfield name="country" label="country" />
<s:submit value="Add"/>
</s:form> 
-->
<tr>
		<td> <s:a href="Add Book.jsp">Add Book</s:a></td>
</tr>
<tr><td>.</td></tr>

</s:form>


<!-- 
<h4>Add book</h4>
<s:form action="addbook">
<s:textfield name="isbn" label="ISBN"/>
<s:textfield name="authorid" label="AuthorID" />
<s:textfield name="title" label="Title" />
<s:textfield name="pubdate" label="PublishDate" value="*"/>
<s:textfield name="publisher" label="Publisher" value="*" />
<s:textfield name="price" label="price" value="*" />
<s:submit value="Add"/>
</s:form>
 -->



<s:form action="author_showAll">
<s:submit value="show all author"/>
</s:form>

<s:form action="author_searchAuthor">
<s:textfield name="authorname" label="AuthorName" value=""/>
<s:submit value="search"/>
</s:form>


<s:form action="author_findBook">
<s:textfield name="title" label="BookName" value=""/>
<s:submit value="search"/>
</s:form>

</body>
</html>