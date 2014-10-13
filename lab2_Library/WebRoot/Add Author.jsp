<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>
<s:form>
<tr><td><strong><font size="5" color="red"><s:property value="message" /></font></strong></td></tr>
</s:form>
<h3>Add author</h3>
<s:form action="author_addAuthor">
<s:textfield name="authorid" label="AuthorID"/>
<s:textfield name="authorname" label="name" />
<s:textfield name="age" label="age" />
<s:textfield name="country" label="country" />
<s:submit value="Add"/>
</s:form>
</body>
</html>