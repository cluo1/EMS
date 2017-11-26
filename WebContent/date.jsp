
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%><html>
  <head></head>
  <body>
    date:<%
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
      String date = sdf.format(new Date());
      out.println(date);
    %>
  </body>
</html>