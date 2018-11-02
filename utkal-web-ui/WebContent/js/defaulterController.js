function getJarDefaulters() {

	alert("Jar Defaulters..");
	
	customerId = $("#customerIdHidden").val();
	startDate = $("#startDate").val();
	endDate = $("#endDate").val();
	customerType = $("#customerType").val();

	if (customerId == "" || customerId == 0) {
		alert("Please select a Customer");
	}
	if (startDate == "") {
		alert("Please select a Start Date");
	}
	if (endDate == "") {
		alert("Please select an End Date");
	}
	if (customerType == "") {
		alert("Please select a Customer Type");
	}

	jsonData = '{"customerId":"' + customerId + '","startDate":"' + startDate
			+ '","endDate":"' + endDate + '","customerType":"' + customerType
			+ '"}';

	console.log(jsonData);

	$(".overlay").show();
	$.ajax({
		
		 type: 'POST',
	     url : serviceHost+'/defaulter/jar',
	     data : jsonData,
	     contentType: 'application/json',
	     crossdomain: true,
	     beforeSend : function(){},
	     complete: function() {
	    },
	     success: function(resp, status) {
	    	 $("#successDiv").load("./pages/successPage.html");
		     setTimeout(function(){
		    	 $("#successMessage").text("Customer Id : "+resp.customerId+" Created");
			     $("#successDiv").css("display","block");			     
			     $("#customerFormDiv").css("display","none");
			     $("#customerSearchResultDiv").css("display","none"); 
			     $(".overlay").hide();
		     },500);
	    	 
	   },
	     error: function(resp, status) {
	    	 $(".overlay").hide();
	    	 console.log("Error");}
	    
		
	});
	
	
	
	
}