var active = "";

function loadAction(currentElement, activeId) {
	
	var request = new XMLHttpRequest;
	active = activeId;

	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		
		document.getElementById("content").innerHTML = request.responseText;
		
		if(active == "department") {
			loadDepartment();
			document.getElementById("department-content").className = "hide";	
		}
		else if(active == "teacher") {
			loadTeacher();
			document.getElementById("teacher-content").className = "hide";
		}
		else if(active == "staff") {
			loadStaff();
			document.getElementById("staff-content").className = "hide";
		}
		else if(active == "major") {
			loadMajor();
			document.getElementById("major-content").className = "hide";
		}
		else if(active == "student") {
			loadStudent();
			document.getElementById("student-content").className = "hide";
		}
		else if (active == "batch") {
			loadBatch();
			document.getElementById("batch-content").className = "hide";
		}
		// else if (active == "payment") {
		// loadPayment();
		// document.getElementById("payment-content").className = "hide";
		// }
	}
		request.open("GET", active + "/all", true);
	
	request.send();
}


function loadSection() {
	
	var detail = document.getElementById("detail");
	detail.innerHTML = "";
	var request = new XMLHttpRequest;
	
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		var divisionContainer = document.createElement("div");
		divisionContainer.setAttribute("class","cards");
		var sectionJSON = JSON.parse(request.responseText);
		sectionJSON.forEach(data => {
			
			var panel = document.createElement("div");
			panel.setAttribute("class","card");
			panel.setAttribute("id",data.boId);
			panel.setAttribute("onclick","getDetail(this,'SECTION')");
			var nameSpan = document.createElement("span");
			nameSpan.innerHTML = data.course.name;
			panel.append(nameSpan);
			divisionContainer.append(panel);
			detail.append(divisionContainer);
		});
		document.getElementById("detail-table").className = "show";

	}
	request.open("GET", "sections/list", true);
	request.send();
}



function loadStudent() {
	var content = document.getElementById("content");
	content.innerHTML = "";
	var request = new XMLHttpRequest;

	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		
		var studentJSON = JSON.parse(request.responseText);
		studentJSON.forEach(data => {
			var student = document.createElement("div");
			student.setAttribute("id",data.boId);
			student.setAttribute("onclick","getDetail(this,'STUDENT')");
			var br = document.createElement("br");
			var boId = document.createElement("span");
			var name = document.createElement("span");
			name.innerHTML = data.name;
			boId.innerHTML = data.boId;
			student.append(boId);
			student.append(br);
			student.append(name);
			student.style.margin="20px";
			content.append(student);
			document.getElementById("detail-table").className = "hide";


		});

	}
	request.open("GET", "students/list", true);
	request.send();
}

function loadBatch() {
	var content = document.getElementById("content");
	content.innerHTML = "";
	var request = new XMLHttpRequest;

	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		
		var batchJSON = JSON.parse(request.responseText);
		batchJSON.forEach(data => {
			var batch = document.createElement("div");
			batch.setAttribute("id",data.boId);
			batch.setAttribute("onclick","getDetail(this,'BATCH')");
			var br = document.createElement("br");
			var boId = document.createElement("span");
			var name = document.createElement("span");
			var startDate = document.createElement("span");
			var endDate = document.createElement("span");
			name.innerHTML = data.name;
			boId.innerHTML = data.boId;
			startDate.innerHTML = data.start-date;
			endDate.innerHTML = data.end-date;
			batch.append(boId);
			batch.append(br);
			batch.append(name);
			batch.append(br);
			batch.append(startDate);
			batch.append(br);
			batch.append(endDate);
			batch.style.margin="20px";
			content.append(batch);
			document.getElementById("detail-table").className = "hide";

		});

// document.getElementById("student-content").onmouseover = function(){
// this.style.background = "grey";
// }

	}
	request.open("GET", "batchs/list", true);
	request.send();
}

function loadPayment() {
	var content = document.getElementById("content");
	content.innerHTML = "";
	var request = new XMLHttpRequest;

	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		
		var paymentJSON = JSON.parse(request.responseText);
		paymentJSON.forEach(data => {
			var payment = document.createElement("div");
			payment.setAttribute("id",data.boId);
			payment.setAttribute("onclick","getDetail(this,'PAYMENT')");
			var br = document.createElement("br");
			var boId = document.createElement("span");
			var name = document.createElement("span");
			var fee = document.createElement("span");
			var discount = document.createElement("span");
			var discription = document.createElement("span");
			name.innerHTML = data.name;
			boId.innerHTML = data.boId;
			fee.innerHTML = data.fee;
			discount.innerHTML = data.discount;
			discription.innerHTML = data.discription;
			payment.append(boId);
			payment.append(br);
			payment.append(name);
			payment.append(br);
			payment.append(fee);
			payment.append(br);
			payment.append(discoount);
			payment.append(br);
			payment.append(discription);
			payment.style.margin="20px";
			content.append(payment);
			document.getElementById("detail-table").className = "hide";

		});

// document.getElementById("student-content").onmouseover = function(){
// this.style.background = "grey";
// }

	}
	request.open("GET", "payments/list", true);
	request.send();
}

var detailId;
function getDetail(element, entityType) {
	
	var request = new XMLHttpRequest;

	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		document.getElementById("detail").innerHTML = request.responseText;
		document.getElementById("detail-table").className = "show";
		if(entityType == "SECTION") {
			document.getElementById("section-detail-table").className = "show";
		}
		else if(entityType == "REGISTER") {
			document.getElementById("registerForm").className = "show";
		}
		else if(entityType == "TEACHER") {
			document.getElementById("teacher-detail-table").className = "show";
		}

		else if(entityType == "STAFF") {
			document.getElementById("staff-detail-table").className = "show";
		}
		else if(entityType == "PAYMENT") {
			document.getElementById("payment-detail-table").className = "show";
		}
		else if(entityType == "BATCH") {
			document.getElementById("batch-detail-table").className = "show";
		}
		else if(entityType == "MAJOR") {
			document.getElementById("major-detail-table").className = "show";
		}
		else if(entityType == "STUDENT") {
			document.getElementById("student-detail-table").className = "show";
		}
	}
	detailId = element;
	parameter = {};
	if(entityType !="REGISTER") {
	var boId = element.id;
	parameter["boId"] = boId;
	}
	else { 
		parameter["boId"] = element;
	}
	request.open("GET", "detail/"+ entityType + "?input=" + JSON.stringify(parameter), true);
	request.send();
}


function getAllEntityDetail(entityType) {
	
	var request = new XMLHttpRequest;

	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		document.getElementById("detail").innerHTML = request.responseText;
		document.getElementById("detail-table").className = "show";
		if(entityType == "SECTION") {
			document.getElementById("section-list-detail-table").className = "show";
		}
		else if(entityType == "STUDENT") {
			document.getElementById("student-list-detail-table").className = "show";
		}
		else if(entityType == "EMPLOYEE") {
			document.getElementById("employee-list-detail-table").className = "show";
		}
		else if(entityType == "COURSE") {
			document.getElementById("course-list-detail-table").className = "show";
		}
		else if(entityType == "PAYMENT") {
			document.getElementById("payment-list-detail-table").className = "show";
		}
		else if(entityType == "BATCH") {
			document.getElementById("batch-list-detail-table").className = "show";
		}
	}
	request.open("GET", "getAll/"+ entityType, true);
	request.send();
}

function addNewDepartment() {
	document.getElementById("departmentForm").className = "show";
	document.getElementById("department-detail-table").className = "hide";
}

function saveDepartment() {
	var departmentName = document.getElementById("department-name").value;
	
	var request = new XMLHttpRequest;
	
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		alert("Successfully saved!");
		loadAction("","department");
		document.getElementById("departmentForm").className = "hide";
	}
	
	parameter = {};
	parameter["name"] = departmentName;
	request.open("POST", "departments/create", true);
	request.setRequestHeader('Content-Type', 'application/json');
	request.send(JSON.stringify(parameter));
}

function getNewTeacherForm(){
	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}

		document.getElementById("detail").innerHTML = request.responseText;
		document.getElementById("detail-table").className = "show";
		document.getElementById("teacherForm").className = "show";
		// document.getElementById("teacher-detail-table").className = "hide";
		
	}
	request.open("GET","new/teachers",true);
	request.send();
}

function saveTeacher(){
	
	var departmentBoId = document.getElementById("department").value;
	var teacherName = document.getElementById("teacher-name").value;
	
	var request = new XMLHttpRequest;
	
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		alert("Successfully saved!");
		loadAction("","teacher");
		document.getElementById("teacherForm").className = "hide";
	}
	
	parameter = {};
	parameter["name"] = teacherName;
	parameter["departmentBoId"] = departmentBoId;
	request.open("POST", "teachers/create" + "?input=" + JSON.stringify(parameter) , true);
	request.send();
}

function getNewStaffForm(){
	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}

		document.getElementById("detail").innerHTML = request.responseText;
		document.getElementById("detail-table").className = "show";
		document.getElementById("staffForm").className = "show";
		// document.getElementById("teacher-detail-table").className = "hide";
		
	}
	request.open("GET","new/staffs",true);
	request.send();
}

function saveStaff(){
	
	var departmentBoId = document.getElementById("department1").value;
	var staffName = document.getElementById("staff-name").value;
	
	var request = new XMLHttpRequest;
	
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		alert("Successfully saved!");
		loadAction("","staff");
		document.getElementById("staffForm").className = "hide";
	}
	
	parameter = {};
	parameter["name"] = staffName;
	parameter["departmentBoId"] = departmentBoId;
	request.open("POST", "staffs/create" + "?input=" + JSON.stringify(parameter) , true);
	request.send();
}

function addNewMajor() {
	document.getElementById("majorForm").className = "show";
	document.getElementById("major-detail-table").className = "hide";
}

function addNewStudentForm() {
	document.getElementById("registerForm").className = "show";
	document.getElementById("section-detail-table").className = "hide";	
}

function saveMajor() {
	var majorName = document.getElementById("major-name").value;
	
	var request = new XMLHttpRequest;
	
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		alert("Successfully saved!");
		loadAction("","major");
		document.getElementById("majorForm").className = "hide";
	}
	
	parameter = {};
	parameter["name"] = majorName;
	request.open("POST", "majors/create", true);
	request.setRequestHeader('Content-Type', 'application/json');
	request.send(JSON.stringify(parameter));
}

function getNewStudentForm(){
	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}

		document.getElementById("detail").innerHTML = request.responseText;
		document.getElementById("detail-table").className = "show";
		document.getElementById("studentForm").className = "show";
		// document.getElementById("teacher-detail-table").className = "hide";
		
	}
	request.open("GET","new/students",true);
	request.send();
}

function saveStudent(){
	
	var majorBoId = document.getElementById("major").value;
	var studentName = document.getElementById("student-name").value;
	
	var request = new XMLHttpRequest;
	
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		alert("Successfully saved!");
		loadAction("","student");
		document.getElementById("studentForm").className = "hide";
	}
	
	parameter = {};
	parameter["name"] = studentName;
	parameter["majorBoId"] = majorBoId;
	request.open("POST", "students/create" + "?input=" + JSON.stringify(parameter) , true);
	request.send();
}

function saveBatch() {
	var batchName = document.getElementById("batch-name").value;
	var startDate = document.getElementById("start-date").value;
	var endDate = document.getElementById("end-date").value;
	
	var request = new XMLHttpRequest;
	
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		alert("Successfully saved!");
		// loadAction("","batch");
		getAllEntityDetail('BATCH');
		document.getElementById("batch-form").className = "hide";
	}
	
	parameter = {};
	parameter["name"] = batchName;
	parameter["startDate"] = startDate;
	parameter["endDate"] = endDate;
	request.open("POST", "batchs/create", true);
	request.setRequestHeader('Content-Type', 'application/json');
	request.send(JSON.stringify(parameter));
}

function savePayment() {
	var paymentName = document.getElementById("payment-name").value;
	var fee = document.getElementById("payment-fee").value;
	var discount = document.getElementById("payment-discount").value;
	var discription = document.getElementById("payment-discription").value;
	var request = new XMLHttpRequest;
	var studentBoId = document.getElementById("studentBoId").innerHTML;
	
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		alert("Successfully saved!");
		// loadAction("","batch");
		getAllEntityDetail('STUDENT');
		document.getElementById("payment-form").className = "hide";
	}
	
	parameter = {};
	parameter["name"] = paymentName;
	parameter["fee"] = fee;
	parameter["discount"] = discount;
	parameter["discription"] = discription;
	parameter["studentBoId"] = studentBoId;
// request.open("POST", "payments/create", true);
	request.open("POST", "payments/create" + "?input=" + JSON.stringify(parameter) , true);
	request.setRequestHeader('Content-Type', 'application/json');
	request.send(JSON.stringify(parameter));
}

function showLoginPanel() {
	
	document.getElementById('instructor-login-label').className = 'hide';
	document.getElementById('employee-login-panel').className = 'show'; 
	var workspace = document.getElementById("workspace");
	var footer = document.getElementById("home-footer");
	var detail = document.getElementById("detail");
	detail.setAttribute("disabled","true");
	workspace.style.top = "20px";
	detail.style.top="0px";
	footer.style.height="200px";
}

function hideLoginPanel(){
	var workspace = document.getElementById("workspace");
	var footer = document.getElementById("home-footer");
	var detail = document.getElementById("detail");
	workspace.style.top = "70px";
	detail.style.top="25px";
	footer.style.height="40px";
	document.getElementById("employee-login-panel").className = "hide";
	document.getElementById("instructor-login-label").className = "show";
}


function authorization() {
	var email=document.getElementById("employee-email").value;
	var password=document.getElementById("emplyee-password").value;
	alert("email:"+email+" password:"+password);
	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
		document.getElementById("detail").innerHTML = "";
		alert(request.responseText);
		if(request.responseText == "true") {
			hideLoginPanel();
			document.getElementById("menu").className = "show";
			document.getElementById("instructor-login-label").innerHTML = "Now Login : "+email;
			document.getElementById("instructor-login-label").onclick = null;	
		}
	}
	request.open("GET", "employees/authorize/"+email+"/"+password, true);
	request.send();
}

function saveItem(entityType) {
	
	 document.getElementById("saveButton").className = "show";
	 document.getElementById("saveButton").value="Create" + entityType;
	 alert(document.getElementById("saveButton").value);
}

function showForm(element) {
	entity = element || "";
	 alert("before if statement : "+document.getElementById("saveButton").value);
	 if(document.getElementById("saveButton").value === "CreateSECTION") {
		 getAllCourseEmployee();
		 
	 }
	 else if(document.getElementById("saveButton").value == "CreateCOURSE") {
		 document.getElementById("course-list-detail-table").className = "hide";
		 document.getElementById("courseForm").className = "show";
	 }
	 else if(document.getElementById("saveButton").value == "CreateEMPLOYEE") {
		 document.getElementById("employee-list-detail-table").className = "hide";
		 document.getElementById("employee-form").className = "show";
		 document.getElementById("employeeEmail").value = "";
		 document.getElementById("employeePassword").value = "";
	 }
	 else if(document.getElementById("saveButton").value === "CreateBATCH") {
		 alert(document.getElementById("saveButton").value);
// document.getElementById("detail-table").className = "show";
		 document.getElementById("batch-list-detail-table").className = "hide";
		 document.getElementById("batch-form").className = "show";
// document.getElementById("student-form").className = "show";
// document.getElementById("payment-form").className = "show";
// document.getElementById("course-form").className = "show";
	 }
	 else if(document.getElementById("add-payment").value === "Add") {
		 alert(document.getElementById("add-payment").value);
		 console.log(entity);
		// document.getElementById("detail-table").className = "show";
		 document.getElementById("student-list-detail-table").className = "hide";
		 document.getElementById("payment-form").className = "show";
		 document.getElementById("studentBoId").innerHTML = entity;
	 }

}

function getAllCourseEmployee() {
	alert("inside getallcourseemployee method");	
	var request = new XMLHttpRequest;
	request.onreadystatechange = function() {
		if(request.readyState != 4)
			return;
		if(request.status != 200) {
			alert("Error return " + request.status);
			return;
		}
			 alert("success getAllCourseEmployee method");
			 document.getElementById("detail").innerHTML = request.responseText;
			 document.getElementById("detail-table").className = "show";
			// document.getElementById("section-list-detail-table").className = "hide";
			 document.getElementById("section-form").className = "show";
	}
	alert("go to server");
	request.open("GET", "getAll/COURSE_EMPLOYEE", true);
	 request.send();
}


function logout() {
	
	document.getElementById("menu").className = "hide";
	loadSection();
	document.getElementById("instructor-login-label").innerHTML = "Instructor click here...";
	document.getElementById("instructor-login-label").onclick="shwLogiPanel()";
	document.getElementById("instructor-login-label").onclick =showLoginPanel();
	
}