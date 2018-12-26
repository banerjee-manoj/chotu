
function loadCreateCustomerPage(){
	
	 $("#errorMessage").text("");
	 $('#mainContainer').show();
	$("#mainContainer").load("./pages/customer/addCustomer.html");
}


function loadSearchCustomerPage(){
	$("#errorMessage").text("");
	$('#mainContainer').show();
	$(".overlay").show();
	$("#mainContainer").load("./pages/customer/searchCustomer.html");
	setTimeout(() => {
		getAllCustomerNames();	
	}, 200);
	setTimeout(() => {
		$(".overlay").hide();
	}, 500);
}


function loadAllCustomerPage(){
	$("#errorMessage").text("");
	$('#mainContainer').show();
	$(".overlay").show();
	$("#mainContainer").load("./pages/customer/showAllCustomer.html");
	setTimeout(() => {
		getAllCustomer();	
	}, 200);
	setTimeout(() => {
		
	}, 200);
	
}


function loadOrderManagementpage(){
	$("#errorMessage").text("");
	$('#mainContainer').show();
	$(".overlay").show();
	$("#mainContainer").load("./pages/order/manageOrder.html");
	setTimeout(() => {
		getAllCustomerNames();	
	}, 200);
	
	setTimeout(() => {
		$(".overlay").hide();
	}, 500);
}

function loadManagePayment(){
	$("#errorMessage").text("");
	$('#mainContainer').show();
	$(".overlay").show();
	
	$("#mainContainer").load("./pages/payment/payment.html");
	setTimeout(() => {
		getAllCustomerNames();	
	}, 200);
	
	setTimeout(() => {
		$(".overlay").hide();
	}, 500);
	
}

function loadJarDefaulterPage(){
	$("#errorMessage").text("");
	$('#mainContainer').show();
$(".overlay").show();
	
$("#mainContainer").load("./pages/defaulters/jarDefaulters.html");
	setTimeout(() => {
		getAllCustomerNames();	
	}, 200);
	
	setTimeout(() => {
		$(".overlay").hide();
	}, 500);
	
	
}

function loadOrderHistory(){
	$("#errorMessage").text("");
	$('#mainContainer').show();
	getAllCustomerNames();
	$("#mainContainer").load("./pages/order/orderHistory.html");
}
