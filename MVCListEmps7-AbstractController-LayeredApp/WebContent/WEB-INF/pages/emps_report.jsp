<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">
   <c:choose>
     <c:when test="${!empty listEmps}">
         <h1> All employee Detials </h1>
         <table border="1"  bgcolor="cyan" bordercolor="red">
          <c:forEach var="dto" items="${listEmps}">
             <tr  bordercolor="blue">
               <td>${dto.sno}</td>
               <td>${dto.empNo}</td>
               <td>${dto.ename}</td>
               <td>${dto.desg}</td>
               <td>${dto.salary}</td>
               <td>${dto.deptNo} </td>
             </tr>
          </c:forEach>
         </table>
     </c:when>
     <c:otherwise>
         <h1 style="color:red;text-align:center"> Records not found </h1>
     </c:otherwise>
  </c:choose>
    <br>
    <h1 style="color:red;text-align:center"><a href="welcome.htm">home</a> </h1>
