<%@page import="model.Consumption" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consumption Management</title>
<link rel="stylesheet" href="Views/bootstrap.css">
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Consumption Management</h1>
				<form id="formItem" name="formItem">
					Customer Name: <input id="CusName"
						name="CusName" type="text" class="form-control form-control-sm"> <br>
					Peak Hours Unit: <input id="PeakHoursUnit" name="PeakHoursUnit"
						type="text" class="form-control form-control-sm"> <br> Normal Hours Unit:
					 <input id="NormalHoursUnit" name="NormalHoursUnit"
						type="text" class="form-control form-control-sm"> <br> Month:
					<input id="Month" name="Month" type="text"
						class="form-control form-control-sm"> <br> Account Number: <input
						id="AccNumber" name="AccNumber" type="text"
						class="form-control form-control-sm"> <br> <input id="btnSave"
						name="btnSave" type="button" value="Save" class="btn btn-primary"> <input type="hidden" id="hidTrackIdSave" name="hidTrackIdSave"
						value="">
				</form>
				<br>
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
				<div id="divItemsGrid">
				<%
				consumption consumptionObj = new consumption();
				 					out.print(consumptionObj.readConsumptions());
				%>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="Components/jquery.min.js" type="text/javascript"></script>
<script src="Components/consumptions.js" type="text/javascript"></script>
</html>