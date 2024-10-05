<%@ page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>


<h1  style="color:blue;text-align:center"> Report Page </h1>

<c:choose>
   <c:when  test="${!empty  empList}">
      <table border="1" align="center" bgcolor="yellow">
         <tr>
           <th>EMPNO</th><th>ENAME</th><th>JOB</th><th>SAL</th><th>DEPTNO</th>
           <th> Operations </th>
         </tr>
        <c:forEach  var="emp" items="${empList}">
            <tr>
              <td>${emp.empno} </td>
             <td>${emp.empname} </td>
             <td>${emp.job} </td>
             <td>${emp.sal} </td>
             <td>${emp.deptno} </td>      
             <td><a href="edit?no=${emp.empno}"><img src="images/edit.jpeg" width="30px" height="30px"></a>
                     <a href="delete?no=${emp.empno}"  onclick="return confirm('Do you Really Want to Delete the Employee?')"><img src="images/delete.jpeg" width="30px" height="30px"></a>
                </td>      
             
            </tr>
        </c:forEach>
      </table>
   </c:when>
   <c:otherwise>
              <h1  style="color:red;text-align:center"> No Records found  </h1>
   </c:otherwise>
</c:choose>

                            <h1 style="color:red;text-align:center"><a href="register"><img src="images/add.jpeg" width="100" height="100px"></a>
                                            &nbsp;&nbsp;&nbsp; <a href="./"><img src="images/home.jpg" width="100px" height="100px"></a>
                            </h1>
                            
                            <br><br>
                            <h1 style="text-align:center;color:green">${resultMsg}</h1>
                            
            