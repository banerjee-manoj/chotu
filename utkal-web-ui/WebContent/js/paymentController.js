
function getPaymentDetails(){

	var customerId=$("#customerIdHidden").val();
	$.ajax({
		
		 type: 'GET',
	     url : serviceHost+'/order/getTotalBillByCustomerId/'+customerId,	    
	     crossdomain: true,
	     beforeSend : function(){},
	     complete: function() {
	     },
	     success: function(resp, status) {
	    	 console.log();
	    	 $("#totalBillSpan").text(resp.totalBill);
		     $("#totalPaymentRecvdDiv").text(resp.totalPayment);
		    	    
		    	$("#customerPaymentDiv").css("display","block");
		    	$("#paymentDetailsDiv").css("display","block");
		    	
	    
	     },
	     error: function(resp, status) {console.log("Error");}
	    
		
	});	
	
	
}

function createPayment(){
	
var customerId=$("#customerIdHidden").val();
	
	//{"customerId":0,"customerName":"Manoj Banerjee","customerMobileNumber":"983011","address":"sampleAddress","customerType":"Regular","securityDeposit":"500","normalJarRate":"30","coldJarRate":"30","startDate":"2018/09/08","active":null,"noOfContainer":"5"}
	var jsonData='{"orderId":0,"paymentId":0,"customerId":'+customerId+',"paymentDate":"'+$("#paymentDate").val()+'",'+
	'"payment":"'+$("#payment").val()+'"}'
	
	
	
	
	
	$.ajax({		
		 type: 'POST',
	     url : serviceHost+'/order/createPayment',
	     data : jsonData,
	     contentType: 'application/json',
	     crossdomain: true,
	     beforeSend : function(){},
	     complete: function() {
	     },
	     success: function(resp, status) {console.log("Success");
	     console.log(resp);
	    
	     $("#successDiv").load("./pages/successPage.html");
	     setTimeout(function(){
	    	 $("#successMessage").text("Payment Id : "+resp.paymentId+" Created");
		     $("#successDiv").css("display","block");
		     $("#paymentModule").css("display","none");
	     },200);
	     
	     
	     
	     },
	     error: function(resp, status) {console.log("Error");}
	    
		
	});
}

