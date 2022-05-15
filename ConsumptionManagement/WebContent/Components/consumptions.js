//Hide the alters on page load
$(document).ready(function()
{

	$("#alertSuccess").hide();

 	$("#alertError").hide();

}); 

$(document).on("click", "#btnSave", function(event)
{
	console.log($("#hidTrackIdSave").val());
	
	// Clear alerts---------------------
 $("#alertSuccess").text("");
 $("#alertSuccess").hide();
 $("#alertError").text("");
 $("#alertError").hide();

// Form validation-------------------
var status = validateItemForm();
if (status != true)
 {
 $("#alertError").text(status);
 $("#alertError").show();
 return;
 }
// If valid------------------------
 var type = ($("#hidTrackIdSave").val() == "") ? "POST" : "PUT";
console.log(type); 
 $.ajax(
 {
 url : "ConsumptionAPI",
 type : type,
 data : $("#formItem").serialize(),
 dataType : "text",
 complete : function(response, status)
 {
 onItemSaveComplete(response.responseText, status);
 }
 });
});

// CLIENT-MODEL================================================================
function validateItemForm()
{
// Customer name
if ($("#CusName").val().trim() == "")
 {
 return "Insert Customer Name.";
 }
// Peak Hour Unit 
if ($("#PeakHoursUnit").val().trim() == "")
 {
 return "Insert Peak Hours Unit.";
 }
// Normal Hours Unit
if ($("#NormalHoursUnit").val().trim() == "")
 {
 return "Insert Normal Hours Unit.";
 }
// is numerical value
var tmpContact = $("#NormalHoursUnit").val().trim();
if (!$.isNumeric(tmpContact))
 {
 return "Insert a numerical value for Normal Hours Unit.";
 }

// Month
if ($("#Month").val().trim() == "")
 {
 return "Insert Month.";
 }
// Account Number
if ($("#AccNumber").val().trim() == "")
 {
 return "Insert Account Number.";
 }
return true;
}

$(document).on("click", ".btnUpdate", function()
{
 $("#hidTrackIdSave").val($(this).data("TrackId"));
 $("#CusName").val($(this).closest("tr").find('td:eq(0)').text());
 $("#PeakHoursUnit").val($(this).closest("tr").find('td:eq(1)').text());
 $("#NormalHoursUnit").val($(this).closest("tr").find('td:eq(2)').text());
 $("#Month").val($(this).closest("tr").find('td:eq(3)').text());
 $("#AccNumber").val($(this).closest("tr").find('td:eq(4)').text());
});

function onItemSaveComplete(response, status)
{
	if (status == "success")
 	{
 		var resultSet = JSON.parse(response);
 		if (resultSet.status.trim() == "success")
 		{
 			$("#alertSuccess").text("Successfully saved.");
 			$("#alertSuccess").show();
			
 			$("#divItemsGrid").html(resultSet.data);
			
 		} else if (resultSet.status.trim() == "error")
 			{
			 	$("#alertError").text(resultSet.data);
 			 	$("#alertError").show();
 			}	
 	} else if (status == "error")
 		{
 			$("#alertError").text("Error while saving.");
 			$("#alertError").show();
 		} else
 			{
 				$("#alertError").text("Unknown error while saving..");
 				$("#alertError").show();
 			} 
		
 $("#hidTrackIdSave").val("");
 $("#formItem")[0].reset();
}


$(document).on("click", ".btnRemove", function()
{
	var id = $(this).data("TrackId");
	console.log("id is :"+id)
 $.ajax(
 {
 url : "ConsumptionAPI",
 type : "DELETE",
 data : "TrackId="  + $(this).data("TrackId"),
 dataType : "text",
 complete : function(response, status)
 {
	console.log(id)
 onItemDeleteComplete(response.responseText, status);
 }
 });
});

function onItemDeleteComplete(response, status)
{
if (status == "success")
 {
 var resultSet = JSON.parse(response);
 if (resultSet.status.trim() == "success")
 {
 $("#alertSuccess").text("Successfully deleted.");
 $("#alertSuccess").show();
 $("#divItemsGrid").html(resultSet.data);
 } else if (resultSet.status.trim() == "error")
 {
 $("#alertError").text(resultSet.data);
 $("#alertError").show();
 }
 } else if (status == "error")
 {
 $("#alertError").text("Error while deleting.");
 $("#alertError").show();
 } else
 {
 $("#alertError").text("Unknown error while deleting..");
 $("#alertError").show();
 }
	$("#hidItemIDSave").val(""); 
	$("#formItem")[0].reset(); 
}









