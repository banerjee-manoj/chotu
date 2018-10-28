
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
	getAllCustomerNames();
	$("#mainContainer").load("./pages/payment/payment.html");
	
}

function loadJarDefaulterPage(){
	$("#mainContainer").load("./pages/defaulters/jarDefaulters.html");
}

function loadOrderHistory(){
	getAllCustomerNames();
	$("#mainContainer").load("./pages/order/orderHistory.html");
}
