<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>添加员工</title>
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
            add Emp info:
          </h1>
          <form action="add.do" method="post">
            <table cellpadding="0" cellspacing="0" border="0"
              class="form_table">
              <tr>
                <td valign="middle" align="right">
                                   姓名:
                </td>
                <td valign="middle" align="left">
                  <input type="text" class="inputgri" name="name" />
                </td>
              </tr>
              <tr>
                <td valign="middle" align="right">
                                   薪水：
                </td>
                <td valign="middle" align="left">
                  <input type="text" class="inputgri" name="sal" />
                </td>
              </tr>
              <tr>
                <td valign="middle" align="right">
                                    年龄：
                </td>
                <td valign="middle" align="left">
                  <input type="text" class="inputgri" name="age" />
                </td>
              </tr>
            </table>
            <p>
              <input type="submit" class="button" value="确定" />
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
