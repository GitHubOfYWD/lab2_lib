<%@ page contentType="text/html;charset=GBK"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head><title>欢迎页面</title></head>
  <table width="650" height="100" >
    <tr>
      <td colspan="4"><strong><font size="10">All the authors</font></strong></td>
    </tr>
    <tr>
      <td>ID</td>
      <td>姓名</td>
      <td>年龄</td>
      <td>国籍</td>
    </tr>
    <s:iterator value="aulst" status="satt">
    <tr>
      <td><s:property value="id"/></td>
      <!-- <td><s:property value="name"/></td> -->
      <td> <s:a href="author_searchAuthor.action?authorname=%{name}"><s:property value="name"/></s:a></td>
      <td><s:property value="age"/></td>
      <td><s:property value="country"/></td>
    </tr>
    </s:iterator>
    <tr><td>...........................</td><td>...........................</td></tr>
		<tr><td>.</td></tr>
		<tr><td>.</td></tr>
    <tr><td><s:a href="homepage.jsp">HomePage</s:a></td></tr>
  </table>
</html>