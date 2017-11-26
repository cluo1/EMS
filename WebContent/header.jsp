<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>


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
              <a href="#">main</a>
            </h1>
          </div>
          <div id="navigation">
          </div>
        </div>
