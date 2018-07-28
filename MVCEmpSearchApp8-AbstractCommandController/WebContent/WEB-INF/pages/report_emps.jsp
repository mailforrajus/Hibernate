<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">
   <c:choose>
     <c:when test="${!empty listEmps}">
         <h1> All employee Detials </h1>
         <table border="1"  bgcolor="cyan" bordercolor="red">
          <c:forEach var="rdto" items="${listEmps}">
             <tr  bordercolor="blue">
               <td>${rdto.sno}</td>
               <td>${rdto.empNo}</td>
               <td>${rdto.empName}</td>
               <td>${rdto.empDesg}</td>
               <td>${rdto.empSalary}</td>
               <td>${rdto.deptNo} </td>
               <td>${rdto.mgrNo} </td>
             </tr>
          </c:forEach>
         </table>
     </c:when>
     <c:otherwise>
         <h1 style="color:red;text-align:center"> Records not found </h1>
     </c:otherwise>
  </c:choose>
    <br>
    <h1 style="color:red;text-align:center"><a href="home.htm">home</a> </h1>
