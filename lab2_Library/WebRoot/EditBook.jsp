<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<body>

<h4>Edit book</h4>
<tr>
      <td colspan="4"><strong><s:property value="authorname"/></strong></td>
</tr>
<s:iterator value="lst" status="satt">
<s:form action="author_editBook">
<s:textfield name="authorname"  value="%{authorname}"  style="display:none" readonly="true" disable="true"/>
<s:textfield name="isbn" label="ISBN" value="%{isbn}" readonly="true" disable="true"/>
<s:textfield name="authorid" label="AuthorID" value="%{authorID}" />
<s:textfield name="title" label="Title" value="%{title}"/>
<s:textfield name="pubdate" label="PublishDate" value="%{publishDate}"/>
<s:textfield name="publisher" label="Publisher" value="%{publisher}" />
<s:textfield name="price" label="price" value="%{price}" />
<s:submit value="Done"/>
</s:form>
</s:iterator>


</body>
</html>