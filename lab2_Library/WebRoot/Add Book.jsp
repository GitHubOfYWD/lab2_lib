<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<s:form>
<tr><td><strong><font size="5" color="red"><s:property value="message" /></font></strong></td></tr>
</s:form>
<h4>Add book</h4>
<s:form action="author_addBook">
<s:textfield name="isbn" label="ISBN" value=""/>
<s:textfield name="authorname" label="Author Name" />
<s:textfield name="title" label="Title" />
<s:textfield name="pubdate" label="PublishDate" />
<s:textfield name="publisher" label="Publisher" />
<s:textfield name="price" label="price" />
<s:submit value="Add"/>
</s:form>
</body>
</html>