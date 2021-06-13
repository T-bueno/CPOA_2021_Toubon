<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calculatrice</title>
</head>

<style type="text/css">
.title{
    font-size: 25px;
    font-style: italic;
    font-family: sans-serif;
    color: #0C620C;
  }
  #case{
      height: 37px;
      width: 200px;
      border: 2px solid #2D882D;
      border-radius: 10px;
  }

  .number{
      height: 50px;
      width: 50px;
      font-size: 25px;
      color: white;
      border: 2px solid #2D882D;
      border-radius: 10px;
      background-color: #5FAE5F;
  }
  .number:hover {
    background-color: #0C620C;
  }

  .operator{
      height: 50px;
      width: 50px;
      font-size: 25px;
      color: white;
      border: 2px solid #5FAE5F;
      border-radius: 10px;
      background-color: #9FD29F;
  }
  .operator:hover{
      background-color: #0C620C;
  }

</style>

<body>
	Welcome to the new calculatrice - YES WE CAN
	<h1>Entrer une expression mathématique</h1>
	<s:form name="myForm"
		action="controller.CalculatriceController.calculer.action"
		method="POST">
		<s:textfield label="Expression" name="expression" />
		<s:submit name="submit" />
	</s:form>
	Le résultat de l'expression ' ${expression}' est : ${resultat}
	
	<!-- Spring -->
<%-- 	<form:form method="POST" name="formSpring" action="/addEmployee"> --%>
<!-- 		<label for="label">Expression :</label> -->
<!-- 		<button type="submit" value="Submit">test</button> -->
<%-- 	</form:form> --%>



  <body>
     <center>
      <h1 class="title">Calculator<h1>
      <s:form name="myForm"
		action="controller.CalculatriceController.calculer.action"
		method="POST">
      
      <table>
        <tr>
          <td colspan="4" align="right" id="case">
            <span id="calc-output"></span>
          </td>
        </tr>
     </table>
     <table>
       <tr>
         <td>
           <input class="number" type="button" value="1" id="button-1" onclick="btm(1)"/>
         </td>
         <td>
           <input class="number" type="button" value="2" id="button-2" onclick="btm(2)"/>
         </td>
         <td>
           <input class="number" type="button" value="3" id="button-3" onclick="btm(3)"/>
         </td>
         <td>
           <input class="operator" type="button" value="C" id="button-C" onclick="btmClean()"/>
         </td>
       </tr>

       <tr>
         <td>
           <input class="number" type="button" value="4" id="button-4" onclick="btm(4)"/>
         </td>
         <td>
           <input class="number" type="button" value="5" id="button-5" onclick="btm(5)"/>
         </td>
         <td>
           <input class="number" type="button" value="6" id="button-6" onclick="btm(6)"/>
         </td>
         <td>
           <input class="operator" type="button" value="+" id="button-+" onclick="btmPlus()"/>
         </td>
       </tr>

       <tr>
         <td>
           <input class="number" type="button" value="7" id="button-7" onclick="btm(7)"/>
         </td>
         <td>
           <input class="number" type="button" value="8" id="button-8" onclick="btm(8)"/>
         </td>
         <td>
           <input class="number" type="button" value="9" id="button-9" onclick="btm(9)"/>
         </td>
         <td>
           <input class="operator" type="button" value="-" id="button--" onclick="btmLess()"/>
         </td>
       </tr>

       <tr>
         <td>
           <input class="operator" type="button" value="x" id="button-*" onclick="btmMultiply()"/>
         </td>
         <td>
           <input class="number"type="button" value="0" id="button-0" onclick="btm(0)"/>
         </td>
         <td>
           <input class="operator" type="button" value="÷" id="button-/" onclick="btmDivision()"/>
         </td>
         <td>
           <input class="operator" type="button" value="=" id="button-=" onclick="btmEgal()"/>
           <s:submit type="button" action="controller.CalculatriceController.calculer.action" method="execute" cssClass="button equal-sign operator btn btn-default" value="Résultat" cssStyle="margin:10px auto 5px 2px; padding:5px;"/>
          
         </td>
       </tr>

     </table>
     </s:form>
     </center>

  </body>
  
  <script>
  function btm(val) {
      document.getElementById("calc-output").innerHTML += val;
  }
  function btmClean(){
     document.getElementById("calc-output").innerHTML = "";
  }
  function btmPlus() {
     document.getElementById("calc-output").innerHTML += "+";
  }
  function btmLess() {
     document.getElementById("calc-output").innerHTML += "-";
  }
  function btmMultiply() {
     document.getElementById("calc-output").innerHTML += "*";
  }
  function btmDivision() {
     document.getElementById("calc-output").innerHTML += "/";
  }
</script>

</html>
