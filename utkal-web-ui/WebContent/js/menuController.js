
function loadCreateCustomerPage(){
	
	
	$("#mainContainer").load("./pages/customer/addCustomer.html");
}


function loadSearchCustomerPage(){
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
	$(".overlay").show();
	$("#mainContainer").load("./pages/customer/showAllCustomer.html");
	setTimeout(() => {
		getAllCustomer();	
	}, 200);
	setTimeout(() => {
		
	}, 200);
	
}


function loadOrderManagementpage(){
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
	getAllCustomerNames();
	$("#mainContainer").load("./pages/order/orderHistory.html");
}
