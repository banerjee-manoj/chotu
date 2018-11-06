function getJarDefaulters() {


	
	customerId = $("#customerIdHidden").val();
	startDate = $("#startDate").val();
	endDate = $("#endDate").val();
	customerType = $("#customerType").val();

	if (customerId == "" || customerId == 0) {
//		alert("Please select a Customer");
	}
	if (startDate == "") {
	//	alert("Please select a Start Date");
	}
	if (endDate == "") {
		//alert("Please select an End Date");
	}
	if (customerType == "") {
		//alert("Please select a Customer Type");
	}

	jsonData = '{"customerId":"' + customerId + '","startDate":"' + startDate
			+ '","endDate":"' + endDate + '","customerType":"' + customerType
			+ '"}';

	console.log(jsonData);
	
	
	
	$(".overlay").show();
	$("#defaulterSearchResult tbody tr").remove();
	$("#defaulterSearchResult").DataTable().destroy();
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
	    	// alert("success");
	    	 console.log(resp);
	    	$("#defaulterSearchResult tbody tr").remove();
	    		$("#defaulterSearchResult").DataTable().destroy();
	    	  var trHtml = ''; 
		      $.each(resp,function(i,item){
		    	
		    trHtml += "<tr><td>"+item.customerName+"</td>" +
		    "<td>"+item.normalJarTaken+"</td>"+
		    "<td>"+item.normalEmptyJarReturned+"</td>"+
		    "<td>"+item.normalFilledJarReturned+"</td>"+
		    "<td>"+item.coldJarTaken+"</td>"+
		    "<td>"+item.coldEmptyJarReturned+"</td>"+
		    "<td>"+item.coldFilledJarReturned+"</td>"+
		    "<td>"+item.normalJarPending+"</td>"+
		    "<td>"+item.coldJarPending+"</td>"+
		    
		    "</tr>";
		    });
		      $('#defaulterSearchResult').append(trHtml);
		      $('#defaulterSearchResult').DataTable();
		      $(".overlay").hide();
		      //alert("Done");
		      
	    		
	    	 
	   },
	     error: function(resp, status) {
	    	 $("#mainContainer").load("./pages/errorPage.html");
	    		setTimeout(() => {
	    			getAllCustomerNames();	
	    		}, 200);
	    		
	    		setTimeout(() => {
	    			$(".overlay").hide();
	    		}, 500);
	    	
	    	 console.log("Error");}
	    
		
	});
	
	
	
	
}