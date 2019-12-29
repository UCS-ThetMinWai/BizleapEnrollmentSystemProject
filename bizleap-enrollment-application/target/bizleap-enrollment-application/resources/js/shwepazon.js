var active = "";

function saveCourse() {
	var courseName = document.getElementById("course-name").value;
	var courseFee = document.getElementById("fee").value;

	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if (request.readyState != 4)
			return;
		if (request.status != 200) {
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
function saveSection() {

	var name = document.getElementById("name").value;
	var dayType = document.getElementById("dayType").value;
	// var startDate = document.getElementById("startDate").value;
	// var endDate = document.getElementById("endDate").value;
	// var startTime = document.getElementById("startTime").value;
	// var endTime = document.getElementById("endTime").value;
	var courseBoId = document.getElementById("course").value;
	var employeeBoId = document.getElementById("employee").value;

	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if (request.readyState != 4)
			return;
		if (request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		alert("Successfully saved!");
	}
	parameter = {};
	parameter["name"] = name;
	parameter["dayType"] = dayType;
	// parameter["startDate"] = startDate;
	// parameter["endDate"] = dayType;
	// parameter["startTime"] = startTime;
	// parameter["endTime"] = endTime;
	parameter["courseBoId"] = courseBoId;
	parameter["employeeBoId"] = employeeBoId;
	request.open("POST", "sections/create" + "?input="
			+ JSON.stringify(parameter), true);
	request.send();
}

function saveEmployee() {

	var employeeName = document.getElementById("employee-name").value;
	var employeeAddress = document.getElementById("employee-address").value;
	var employeeAge = document.getElementById("employee-age").value;
	var employeeEmail = document.getElementById("employeeEmail").value;
	var employeePassword = document.getElementById("employeePassword").value;
	var employeePosition = document.getElementById("employee-position").value;
	var employeePhoneNumber = document.getElementById("employee-phoneNumber").value;
	var employeeSalary = document.getElementById("employee-salary").value;
	// document.getElementById("teacherForm").className = "hide";

	var request = new XMLHttpRequest;

	request.onreadystatechange = function() {
		if (request.readyState != 4)
			return;
		if (request.status != 200) {
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

function register() {

	var name = document.getElementById("student-name").value;
	var address = document.getElementById("student-address").value;
	var email = document.getElementById("student-email").value;
	var phoneNumber = document.getElementById("student-phonenumber").value;
	var age = document.getElementById("student-age").value;
	var enrollType = "REGISTER";
	var sectionBoId = document.getElementById("detail-register-section-id").value;
	var courseBoId = document.getElementById("course-input-id").value;
	var employeeBoId = document.getElementById("employee-input-id").value;
	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if (request.readyState != 4)
			return;
		if (request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		alert("Successfully saved!");
		// document.getElementById("teacherForm").className = "hide";
	}

	parameter = {};
	parameter["name"] = name;
	parameter["address"] = address;
	parameter["email"] = email;
	parameter["phoneNumber"] = phoneNumber;
	parameter["age"] = age;
	parameter["enrollType"] = enrollType;
	parameter["sectionBoId"] = sectionBoId;
	parameter["courseBoId"] = courseBoId;
	parameter["employeeBoId"] = employeeBoId;
	request.open("POST", "students/create" + "?input="
			+ JSON.stringify(parameter), true);
	request.send();
}
