function getPaymentDetails() {

	var customerId = $("#customerIdHidden").val();
	$.ajax({

		type : 'GET',
		url : serviceHost + '/order/getTotalBillByCustomerId/' + customerId,
		crossdomain : true,
		beforeSend : function() {
		},
		complete : function() {
		},
		success : function(resp, status) {

			$("#totalBillSpan").text(resp.totalBill);
			$("#totalPaymentRecvdDiv").text(resp.totalPayment);

			$("#customerPaymentDiv").css("display", "block");
			$("#paymentDetailsDiv").css("display", "block");

		},
		error : function(resp, status) {
			console.log("Error");
		}

	});

}

function createPayment() {

	var customerId = $("#customerIdHidden").val();

	//{"customerId":0,"customerName":"Manoj Banerjee","customerMobileNumber":"983011","address":"sampleAddress","customerType":"Regular","securityDeposit":"500","normalJarRate":"30","coldJarRate":"30","startDate":"2018/09/08","active":null,"noOfContainer":"5"}
	var jsonData = '{"orderId":0,"paymentId":0,"customerId":' + customerId
			+ ',"paymentDate":"' + $("#paymentDate").val() + '",'
			+ '"payment":"' + $("#payment").val() + '"}'

	$.ajax({
		type : 'POST',
		url : serviceHost + '/order/createPayment',
		data : jsonData,
		contentType : 'application/json',
		crossdomain : true,
		beforeSend : function() {
		},
		complete : function() {
		},
		success : function(resp, status) {
			$("#successDiv").load("./pages/successPage.html");
			setTimeout(function() {
				$("#successMessage").text(
						"Payment Id : " + resp.paymentId + " Created");
				$("#successDiv").css("display", "block");
				$("#paymentModule").css("display", "none");
			}, 200);

		},
		error : function(resp, status) {
			console.log("Error");
		}

	});
}

function getPaymentHistory() {

	$(".overlay").show();
	var customerId = $("#customerIdHidden").val();
	var startDate = $("#startDate").val();
	var endDate = $("#endDate").val();

	var jsonData = '{"customerId":"' + customerId + '","startDate":"'
			+ startDate + '","endDate":"' + endDate + '"}'

	$("#paymentHistoryTable").DataTable().destroy();
	$("#paymentHistoryTable tbody tr").remove();
	$.ajax({
		type : 'POST',
		url : serviceHost + '/order/paymentHistory',
		data : jsonData,
		contentType : 'application/json',
		crossdomain : true,
		beforeSend : function() {
		},
		complete : function() {
		},
		success : function(resp, status) {

			var trHtml = '';
			$.each(resp.customerPaymentDetails, function(i, item) {
				trHtml += "<tr><td>" + item.customerName + "</td>" + "<td>"
						+ item.paymentDate + "</td>" + "<td>" + item.payment
						+ "</td></tr>";
			});
			$('#paymentHistoryTable').append(trHtml);
			$('#paymentHistoryTable').DataTable();

			$('#customerDataDiv').show();
			$('#totalPaymentReceived').text(resp.totalPaymentReceived);

			$(".overlay").hide();
			$('#paymentHistoryTable').show();
		},
		error : function(resp, status) {
			console.log("Error");
			$(".overlay").hide();
		}

	});

}
