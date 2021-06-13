<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

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
  #expression{
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

	
<!-- Spring -->
<%-- 	<form:form method="POST" name="formSpring" action="/addEmployee"> --%>
<!-- 		<label for="label">Expression :</label> -->
<!-- 		<button type="submit" value="Submit">test</button> -->
<%-- 	</form:form> --%>



  <body>
     <center>
      <h1 class="title">Calculatrice</h1>
      	<s:form name="myForm"
		action="controller.CalculatriceController.calculer.action"
		method="POST">

      <table>
        <tr>
          <td colspan="4" align="right" id="case">
            	<s:textfield id="expression" name="expression"/>

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
           <input class="operator" type="button" value="(" id="button-/" onclick="btmParentheseOuverte()"/>
         </td>
         <td>
           <input class="operator" type="button" value=")" id="button-/" onclick="btmParentheseFerme()"/>
         </td>
         <td>
          		<s:submit name="submit" />
         </td>
       </tr>
        </table>
         </s:form>
         </center>
         
         Le résultat de l'expression ' ${expression}' est : ${resultat}

  </body>
  
  <script>
  function btm(val) {
      document.getElementById("expression").value += val;
  }
  function btmClean(){
     document.getElementById("expression").value = "";
  }
  function btmPlus() {
     document.getElementById("expression").value += "+";
  }
  function btmLess() {
     document.getElementById("expression").value += "-";
  }
  function btmMultiply() {
     document.getElementById("expression").value += "*";
  }
  function btmDivision() {
     document.getElementById("expression").value += "/";
  }
  function btmParentheseOuverte(){
	  document.getElementById("expression").value += "(";
  }
  function btmParentheseFerme(){
	  document.getElementById("expression").value += ")";
  }
  
</script>

</html>
