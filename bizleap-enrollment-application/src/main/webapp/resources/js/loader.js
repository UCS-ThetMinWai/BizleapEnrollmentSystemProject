var active = "";

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

function showForm() {
	
	 if(document.getElementById("saveButton").value === "CreateSECTION") {
		 document.getElementById("section-list-detail-table").className = "hide";
		 document.getElementById("section-form").className = "show";
		 document.getElementById("employee-form").className = "show";
		 document.getElementById("courseForm").className = "show";
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
	 
}
function logout() {
	
	document.getElementById("menu").className = "hide";
	loadSection();
	document.getElementById("instructor-login-label").innerHTML = "Instructor click here...";
	 document.getElementById("instructor-login-label").onclick="shwLogiPanel()";
	document.getElementById("instructor-login-label").onclick =showLoginPanel();
	
}