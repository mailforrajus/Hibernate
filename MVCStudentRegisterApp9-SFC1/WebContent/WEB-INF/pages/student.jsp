<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1 style="text-align:center">Student Registration page</h1>

<form:form  method="POST" commandName="stCmd">
    student name::<form:input path="sname"/> <br>
    student address::<form:input path="sadd"/> <br>
    student course::<form:input path="course"/> <br>
    student Percentage::<form:input path="percentage"/> <br>
    
    <input type="submit"  value="register"/>
</form:form>

