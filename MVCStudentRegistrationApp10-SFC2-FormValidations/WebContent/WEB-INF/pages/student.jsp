<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1 style="text-align:center">Student Registration page</h1>
<script language="JavaScript" src="validation.js">
</script>
<noscript>
   <h1 style="color:red;text-align:center"> Enable java script </h1>
</noscript>
<form:form  method="POST" commandName="stCmd" onsubmit="return validation(this)">
<%-- <p style="color:red">
   <form:errors path="*"/>
   </p>  <br> --%>
    student name::<form:input path="sname"/> <form:errors path="sname"/> <span id="snameErr"></span> <br>
    student address::<form:input path="sadd"/> <form:errors path="sadd"/> <span id="saddErr"></span><br>
    student course::<form:input path="course"/> <form:errors path="course"/><span id="courseErr"> </span><br>
    student Percentage::<form:input path="percentage"/> <form:errors path="percentage"/><span id="percentageErr"> </span><br>
     <form:hidden path="vflag"/>
    <input type="submit"  value="register"/>
</form:form>
<style>
  span{color:red;font-size:10px }
</style>
