<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<s:form>
<tr><td colspan="4"><strong><font size="5" color="red"><s:property value="message" /></font></strong></td></tr>
</s:form>


<s:form action="author_addAuthorAndBook">
<tr><td><font size=10><strong>Author:</strong></font></td></tr>
<s:textfield name="authorid" label="AuthorID"/>
<s:textfield label="Author Name" value="%{authorname}" readonly="true"/>
<s:textfield name="age" label="age" />
<s:textfield name="country" label="country" />
<tr><td>.</td></tr>
<tr><td>.</td></tr>
<tr><td><font size=10><strong>Book:</strong></font></td></tr>
<s:textfield name="isbn" label="ISBN" value="%{isbn}" readonly="true" disable="true"/>
<s:textfield name="authorname" label="Author Name" value="%{authorname}" readonly="true"/>
<s:textfield name="title" label="Title" value="%{title}" readonly="true"/>
<s:textfield name="pubdate" label="PublishDate" value="%{pubdate}" readonly="true"/>
<s:textfield name="publisher" label="Publisher" value="%{publisher}"  readonly="true"/>
<s:textfield name="price" label="price" value="%{price}"  readonly="true"/>
<s:submit value="Done"/>
<tr><td>.</td></tr>
<tr><td><s:a href="homepage.jsp">HomePage</s:a></td></tr>
</s:form>
</body>
</html>