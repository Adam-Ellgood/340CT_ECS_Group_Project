<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd"-->

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--Browser tab name-->
        <title>Module Coursework Upload</title>
    </head>
    <body>
       <!--Form Declared, used for file upload-->
       <form action="TestServlet" method="post" enctype="multipart/form-data">
         <!--Text to screen interface-->
         <h1> Module (Code): Title </h1>
         <h5> Module Tutor: (name)</h5>
         <h5> This module is intended (...desc) </h5>
         <h5> Coursework 1: XYZ </h5>
         <h5> Issue Date: Semester 1 </h5>
         <h5> Due Date: XYZ </h5>
         <!--Browse file to upload-->
         <h5> Cover sheet: <input name="Coursework Coversheet" type="file"/> </h5>
         <h5> Coursework: <input name="Coursework Submission" type="file"/> </h5>
         <!--Submit and clear buttons-->
         <input value="Submit" type="submit"/>
         <input value="Clear" type="reset"/>
       </form>
    </body>
</html>