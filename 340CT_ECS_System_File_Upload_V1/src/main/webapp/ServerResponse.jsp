<%@ page import="javax.servlet.http.Part" %>
<!--  !-->
<html>
<head>
  <title>Coursework Confirmation</title>
</head>

<body>
  <h1>Coursework Upload Server Status</h1>
  <h3>Please see if your submission has successfully reached the ECS server</h3>
  <br>

<%
  for (Part p: request.getParts()) {
    /* When fetching the file parts, print file details such as;
      name, size and file type. */
    out.write("---------------------------------------------------------------------------------------------------------------------------" + "<br/>\n");
    out.write("Part name: " + p.getName() + "<br/>\n");
    out.write("Size: " + p.getSize() + " " + "(Notice: If '0' no file has been submitted!)" + "<br/>\n");
    out.write("Content Type: " + p.getContentType() + "<br/>\n");
    out.write("---------------------------------------------------------------------------------------------------------------------------" + "<br/>\n");
    out.write("<br/>\n");
  }
%>

</body>
</html>

