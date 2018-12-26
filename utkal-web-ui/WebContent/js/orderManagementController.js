function getCustomerOrderDetails(){
	
	$("#successDiv").css("display","none");	 
	
	var customerId=$("#customerIdHidden").val();
		var date=$("#orderDate").val();
		
	
	$.ajax({
		
		 type: 'GET',
	     url : serviceHost+'/order/getOrderDetails/'+customerId+'/'+date,	    
	     crossdomain: true,
	     beforeSend : function(){},
	     complete: function() {
	     },
	     success: function(resp, status) {
	     
	       if(resp.orderId==0){
	    	
	    	$("#mobSpan").text(resp.customerMobileNumber);
	    	$("#addressSpan").text(resp.address);
	    	$("#normalJarRateSpan").text(resp.normalJarRate);
	    	$("#coldJarRateSpan").text(resp.coldJarRate);	    
	    	$("#customerDataDiv").css("display","block");
	    	$("#orderDiv").css("display","block");
	    	$("#editBtn").css("display","none");
	    	
	       }else {
	    	  console.log(resp);
	    	   populatePreloadedData(resp);
	       }
	     },
	     error: function(resp, status) {console.log("Error");}
	    
		
	});	
	
	
}


function editOrder(){
	$("#createBtn").css("display","inline-block");
	$("#editBtn").css("display","none");
	$("#normalJarOrder").removeAttr('disabled','false');
	$("#coldJarOrder").removeAttr('disabled','false');
	$("#containerOrdered").removeAttr('disabled','false');
	$("#normalJarReturned").removeAttr('disabled','false');
	$("#coldJarReturned").removeAttr('disabled','false');
	$("#normalJarFilledReturned").removeAttr('disabled','false');
	$("#coldJarFilledReturned").removeAttr('disabled','false');
	$("#containerReturned").removeAttr('disabled','false');
	$("#payment").removeAttr('disabled','false');
	
}


function populatePreloadedData(resp){
	
	$("#mobSpan").text(resp.customerMobileNumber);
	$("#addressSpan").text(resp.address);
	$("#orderId").val(resp.orderId);
	$("#normalJarRateSpan").text(resp.normalJarRate);
	$("#coldJarRateSpan").text(resp.coldJarRate);	 
	$("#normalJarOrder").val(resp.normalJarOrdered);
	$("#normalJarOrder").attr('disabled','true');
	$("#coldJarOrder").val(resp.coldJarOrdered);
	$("#coldJarOrder").attr('disabled','true');
	$("#containerOrdered").val(resp.containerOrdered);
	$("#containerOrdered").attr('disabled','true');
	$("#normalJarReturned").val(resp.normalEmptyJarReturned);
	$("#normalJarReturned").attr('disabled','true');
	$("#coldJarReturned").val(resp.coldEmptyJarReturned);
	$("#coldJarReturned").attr('disabled','true');
	$("#normalJarFilledReturned").val(resp.normalFilledJarReturned);
	$("#normalJarFilledReturned").attr('disabled','true');
	$("#coldJarFilledReturned").val(resp.coldFilledJarReturned);
	$("#coldJarFilledReturned").attr('disabled','true');
	$("#containerReturned").val(resp.containerReturned);
	$("#containerReturned").attr('disabled','true');
	$("#totalBill").text(resp.totalBill);
	$("#payment").val(resp.payment);
	$("#payment").attr('disabled','true');
	$("#paymentId").val(resp.paymentId);
	
	$("#createBtn").css("display","none");
	$("#editBtn").css("display","inline-block");
	
	
	$("#customerDataDiv").css("display","block");
	$("#orderDiv").css("display","block");
	
}

function calculate(){
	
	normalJarRate=$("#normalJarRateSpan").text();
	coldJarRate=$("#coldJarRateSpan").text();
	normalJarOrder =$("#normalJarOrder").val();
	coldJarOrder=$("#coldJarOrder").val();
	normalFilledJarReturn=$("#normalJarFilledReturned").val();
    coldFilledJarReturn=$("#coldJarFilledReturned").val();
    $("#totalBill").text((normalJarRate*normalJarOrder+coldJarRate*coldJarOrder)-(normalFilledJarReturn*normalJarRate+coldFilledJarReturn*coldJarRate));
	
	
}

function createOrder(){
	$(".overlay").show();
	var customerId=$("#customerIdHidden").val();
	var orderId=$("#orderId").val();
	//{"customerId":0,"customerName":"Manoj Banerjee","customerMobileNumber":"983011","address":"sampleAddress","customerType":"Regular","securityDeposit":"500","normalJarRate":"30","coldJarRate":"30","startDate":"2018/09/08","active":null,"noOfContainer":"5"}
	var jsonData='{"orderId":'+orderId+',"customerId":'+customerId+',"paymentId":'+$("#paymentId").val()+',"orderDate":"'+$("#orderDate").val()+'","normalJarOrdered":"'+$("#normalJarOrder").val()+'","coldJarOrdered":"'+$("#coldJarOrder").val()+'","containerOrdered":"'+$("#containerOrdered").val()+'",'+
	'"normalEmptyJarReturned":"'+$("#normalJarReturned").val()+'","coldEmptyJarReturned":"'+$("#coldJarReturned").val()+'","normalFilledJarReturned":"'+$("#normalJarFilledReturned").val()+'","coldFilledJarReturned":"'+$("#coldJarFilledReturned").val()+'","containerReturned":"'+$("#containerReturned").val()+'","totalBill":"'+$("#totalBill").text()+'","payment":"'+$("#payment").val()+'"}'
	
	
	console.log(jsonData);
	
	
	$.ajax({		
		 type: 'POST',
	     url : serviceHost+'/order/createOrder',
	     data : jsonData,
	     contentType: 'application/json',
	     crossdomain: true,
	     beforeSend : function(){},
	     complete: function() {
	     },
	     success: function(resp, status) {console.log("Success");
	     console.log(resp);
	     $("#orderDate").val("");
	     $("#customerNameSearch").val("");
	     $("#customerDataDiv").css("display","none");
	     $("#orderDiv").css("display","none");
	     $("#successDiv").load("./pages/successPage.html");
	     setTimeout(function(){
	    	 $("#successMessage").text("Order Id : "+resp.orderId+" Created");
		     $("#successDiv").css("display","block");
		     $("#mainDiv").hide();
		     $(".overlay").hide();
	     },1000);
	     
	     
	     
	     },
	     error: function(resp, status) {console.log("Error");
	     $(".overlay").hide();}
	    
		
	});
}

// Order History Details:

function getOrderHistory(){
    $(".overlay").show();
	var customerId=$("#customerIdHidden").val();
	var startDate=$("#startDate").val();
	var endDate=$("#endDate").val();
	
	var jsonData='{"customerId":"'+customerId+'","startDate":"'+startDate+'","endDate":"'+endDate+'"}'
	console.log(jsonData);

	$.ajax({		
		 type: 'POST',
	     url : serviceHost+'/order/orderHistory',
	     data : jsonData,
	     contentType: 'application/json',
	     crossdomain: true,
	     beforeSend : function(){},
	     complete: function() {
	     },
	     success: function(resp, status) {console.log("Success");
	     console.log(resp);
	     
	     setTimeout(function(){
	    	 
		     
		     
		     $(".overlay").hide();
	     },1000);
	     
	     
	     
	     },
	     error: function(resp, status) {console.log("Error");
	     $(".overlay").hide();}
	    
		
	});
}