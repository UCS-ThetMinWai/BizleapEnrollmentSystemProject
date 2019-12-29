var active = "";

function saveCourse(){
	var courseName = document.getElementById("course-name").value;
	var courseFee = document.getElementById("fee").value;
	
	var request = new XMLHttpRequest;
	
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		alert("Successfully saved!");
		document.getElementById("courseForm").className = "hide";
		getAllEntityDetail("COURSE");	
	}
	
	parameter = {};
	parameter["name"] = courseName;
	parameter["fee"] = courseFee;
	console.log(parameter);
	request.open("POST", "courses/create", true);
	request.setRequestHeader('Content-Type', 'application/json');
	request.send(JSON.stringify(parameter));
}

function saveEmployee(){
	var employeeName = document.getElementById("employee-name").value;
	var employeeAddress = document.getElementById("employee-address").value;
	var employeeAge = document.getElementById("employee-age").value;
	var employeeEmail = document.getElementById("employeeEmail").value;
	var employeePassword = document.getElementById("employeePassword").value;
	var employeePosition = document.getElementById("employee-position").value;
	var employeePhoneNumber = document.getElementById("employee-phoneNumber").value;
	var employeeSalary = document.getElementById("employee-salary").value;
	
	var request = new XMLHttpRequest;
	
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		alert("Successfully saved!");
		document.getElementById("employee-form").className = "hide";
		getAllEntityDetail("EMPLOYEE");	
	}
	
	parameter = {};
	parameter["name"] = employeeName;
	parameter["address"] = employeeAddress;
	parameter["age"] = employeeAge;
	parameter["email"] = employeeEmail;
	parameter["password"] = employeePassword;
	parameter["phoneNumber"] = employeePhoneNumber;
	parameter["position"] = employeePosition;
	parameter["salary"] = employeeSalary;
	console.log(parameter);
	request.open("POST", "employees/create", true);
	request.setRequestHeader('Content-Type', 'application/json');
	request.send(JSON.stringify(parameter));
}


