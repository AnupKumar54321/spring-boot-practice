<%@ page  isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>


<h1  style="color:red;text-align:center"> Edit the Employee Details </h1>

<frm:form  modelAttribute="emp">
  <table  align="center" bgcolor="cyan" >
    <tr>
      <td> Employee number :: </td>
      <td> <frm:input path="empno"  readonly="true"/> </td>  
    </tr>
   
    <tr>
      <td> Employee name :: </td>
      <td> <frm:input path="empname"/> </td>  
    </tr>
  <tr>
      <td> Employee  salary :: </td>
      <td> <frm:input path="sal"/> </td>  
    </tr>
    <tr>
      <td> Employee  dept no :: </td>
      <td> <frm:input type="number" min="10" max="99" path="deptno"/> </td>  
    </tr>
     <tr>
       <td colspan="2"><input type="submit"  value="Edit Employee"> </td>
     </tr>
       
  </table>


</frm:form>