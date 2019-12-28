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
			// var br = document.createElement("br");
			// var boId = document.createElement("span");
			var nameSpan = document.createElement("span");
			nameSpan.innerHTML = data.course.name;
			// boId.innerHTML = data.boId;
			// major.append(boId);
			// major.append(br);
			panel.append(nameSpan);
			// major.style.margin="20px";
			divisionContainer.append(panel);
			detail.append(divisionContainer);
			// document.getElementById("detail-table").className = "hide";

		});
		document.getElementById("detail-table").className = "show";
// document.getElementById("major-content").onmouseover = function(){
// this.style.background = "grey";
// }

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

// document.getElementById("student-content").onmouseover = function(){
// this.style.background = "grey";
// }

	}
	request.open("GET", "students/list", true);
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
			document.getElementById("employee-list-detail-table").className += "show";
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
	// document.getElementById("section-list-detail-table").className = "hide";
// document.getElementById("detail-table").className = "show";
	 document.getElementById("saveButton").className = "show";
	 document.getElementById("saveButton").value="Create" + entityType;
	 alert(document.getElementById("saveButton").value);
}
//
//
// else if(entityType == "STUDENT") {
// document.getElementById("student-list-detail-table").className = "show";
// }
// else if(entityType == "EMPLOYEE") {
// document.getElementById("employee-list-detail-table").className += "show";
// }
// else if(entityType == "COURSE") {
// document.getElementById("course-list-detail-table").className = "show";
// }
// else if(entityType == "PAYMENT") {
// document.getElementById("payment-list-detail-table").className = "show";
// }
// else if(entityType == "BATCH") {
// document.getElementById("batch-list-detail-table").className = "show";
// }
// }

function showForm() {
	 alert("show form btn clicked");
	 alert("before if statement : "+document.getElementById("saveButton").value);
	 if(document.getElementById("saveButton").value === "CreateSECTION") {
		 alert(document.getElementById("saveButton").value);
//		 document.getElementById("detail-table").className = "show";
		 document.getElementById("section-list-detail-table").className = "hide";
		 document.getElementById("section-form").className = "show";
		 document.getElementById("employee-form").className = "show";
		 document.getElementById("course-form").className = "show";
// document.getElementById("student-form").className = "show";
// document.getElementById("payment-form").className = "show";
// document.getElementById("course-form").className = "show";
	 }
}
function logout() {
	
	document.getElementById("menu").className = "hide";
	loadSection();
	document.getElementById("instructor-login-label").innerHTML = "Instructor click here...";
	 document.getElementById("instructor-login-label").onclick="shwLogiPanel()";
	document.getElementById("instructor-login-label").onclick =showLoginPanel();
	
}