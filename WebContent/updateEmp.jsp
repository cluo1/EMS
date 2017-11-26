<%@page import="entity.Employee"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<html>
  <head>
    <title>update Emp</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css"
      href="css/style.css" />
  </head>

  <body>
    <div id="wrap">
      <div id="top_content">
          <div id="header">
            <div id="rightheader">
              <p>
                                 时间： <%Date date=new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
                String s = sdf.format(date);
                out.print(s);
              %>
                <br />
              </p>
            </div>
            <div id="topheader">
              <h1 id="title">
                <a href="#">Main</a>
              </h1>
            </div>
            <div id="navigation">
            </div>
          </div>
        <div id="content">
          <p id="whereami">
          </p>
          <h1>
            update Emp info:
          </h1>
          <% 
            Employee e = (Employee)request.getAttribute("update");
            String name = e.getName();
            double sal = e.getSal();
            int age = e.getAge();
           %>
          <form action="modify.do?id=<%=e.getId()%>" method="post">
            <table cellpadding="0" cellspacing="0" border="0"
              class="form_table">
              <tr>
                
                <td valign="middle" align="right">  
                  id
                </td>
                <td valign="middle" align="left">
                  <%=e.getId() %>
                </td>
              </tr>
              <tr>
                <td valign="middle" align="right">
                  name:
                </td>
                <td valign="middle" align="left">
                  <input type="text" class="inputgri" name="name" value="<%=name%>"/>               
                </td>
              </tr>
              <tr>
                <td valign="middle" align="right">
                  salary:
                </td>
                <td valign="middle" align="left">
                  <input type="text" class="inputgri" name="sal" value="<%=sal%>"/>
                </td>
              </tr>
              <tr>
                <td valign="middle" align="right">
                  age:
                </td>
                <td valign="middle" align="left">
                  <input type="text" class="inputgri" name="age" value="<%=age%>"/>
                </td>
                
              </tr>
            </table>
            <p>
              <input type="submit" class="button" value="Confirm" />
            </p>
          </form>
        </div>
      </div>
      <div id="footer">
        <div id="footer_bg">
          ABC@126.com
        </div>
      </div>
    </div>
  </body>
</html>
