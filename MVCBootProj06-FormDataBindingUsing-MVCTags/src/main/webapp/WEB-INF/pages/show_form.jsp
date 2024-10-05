<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm" %>

<h1  style="color:cyan;text-align:center"> Student Registration Form  </h1>

<frm:form  modelAttribute="stud">
 <table border="0" align="center" bgcolor="yellow">
     <tr>
        <td>Sno:: </td>
        <td><frm:input type="text" path="sno"/> </td>
     </tr>
      <tr>
        <td>Sname:: </td>
        <td><frm:input type="text" path="sname"/> </td>
     </tr>
      <tr>
        <td>Sadd:: </td>
        <td><frm:input type="text" path="sadd"/> </td>
     </tr>
        <tr>
        <td>avg:: </td>
        <td><frm:input type="text" path="avg"/> </td>
     </tr>
      <tr>
            <td colspan="2"><input type="submit" value="register student"> </td>
     </tr>
     
 
 </table>

</frm:form>
