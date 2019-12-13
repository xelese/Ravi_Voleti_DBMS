async function loadPatientProfile() {
	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}
	response = await fetch('http://localhost:8080/find/appointment/patient', {
	    method: 'GET',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  }
  	});

	data = await response.json();
	console.log(data)
	for(key in data) {

		var para = document.createElement("p");
		para.style.margin = "50px";

		var node = document.createTextNode("Appointment on " + key);
		para.appendChild(node);


		var node2 = document.createTextNode(" with Doctor " + data[key].split(":")[0]);
		para.appendChild(node2);

		var node3 = document.createTextNode(" at " + data[key].split(":")[1] + "\n");
		para.appendChild(node3);

		var btn1 = document.createElement("BUTTON");   // Create a <button> element
		btn1.innerHTML = "Give feedback for this doctor"; 
		btn1.id = data[key].split(":")[2];

		btn1.onclick = function() { addFeedbackDoc(this.id) }; 
		btn1.style.margin = "20px";

		var btn2 = document.createElement("BUTTON");   // Create a <button> element
		btn2.innerHTML = "Give feedback for this location"; 
		btn2.id = data[key].split(":")[1]
		btn2.onclick = function() { addFeedbackLoc(this.id) }; 
		btn2.style.margin = "20px";

		var element = document.getElementById("pappt");
		element.appendChild(para);
		para.appendChild(btn1);
		para.appendChild(btn2);


	}

}

async function loadDoctorProfile() {
	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}
	response = await fetch('http://localhost:8080/find/appointment/doctor', {
	    method: 'GET',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  }
  	});

	data = await response.json();
	console.log(data)
	for(key in data) {

		var para = document.createElement("p");
		para.style.margin = "50px";

		var node = document.createTextNode("Appointment on " + key);
		para.appendChild(node);


		var node2 = document.createTextNode(" with Patient " + data[key].split(":")[0]);
		para.appendChild(node2);

		var node3 = document.createTextNode(" at " + data[key].split(":")[1] + "\n");
		para.appendChild(node3);

		var element = document.getElementById("doc-appointments");
		element.appendChild(para);
	}

	showDoctorRewards();
}

async function showConditions() {
	var condition = document.getElementById("searchCond").value;
	response = await fetch('http://localhost:8080/find/'
	 + condition, {
	    method: 'GET',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  }
  	});

	data = await response.json();
	for(var i = 0; i < data.length; i++ ) {
		var para = document.createElement("p");
		para.style.margin = "50px";

		var node = document.createTextNode(data[i]);
		para.appendChild(node);

		var element = document.getElementById("conditions");
		element.appendChild(para);
	}
}

async function showConditionsAnonymous() {
	var condition = document.getElementById("searchCondA").value;
	response = await fetch('http://localhost:8080/find/'
	 + condition, {
	    method: 'GET',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  }
  	});

	data = await response.json();
	for(var i = 0; i < data.length; i++ ) {
		var para = document.createElement("p");
		para.style.margin = "50px";

		var node = document.createTextNode(data[i]);
		para.appendChild(node);

		var element = document.getElementById("anonymouscond");
		element.appendChild(para);
	}
}

async function showLocations() {
	response = await fetch('http://localhost:8080/find/locality', {
	    method: 'GET',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  }
  	});

	data = await response.json();
	for(var i = 0; i < data.length; i++ ) {
		var para = document.createElement("p");
		para.style.margin = "50px";

		var node = document.createTextNode(data[i]);
		para.appendChild(node);

		var element = document.getElementById("locations");
		element.appendChild(para);
	}
}

async function registerCondition() {
	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}
	var condition = document.getElementById("newcondition").value;
	response = await fetch('http://localhost:8080/register/doctor/condition', {
		method: 'POST',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  },
	    body: JSON.stringify({"conditions": [condition]})
  	});

	data = await response.json();
	if(data == true) {
		alert("Registered for condition: " + condition);
	} else {
		alert("Already registered for condition or server error, try again");

	}
}

async function registerLocation() {
	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}
	var location = document.getElementById("newlocation").value;
	response = await fetch('http://localhost:8080/register/doctor/locality', {
		method: 'POST',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  },
	    body: JSON.stringify({"localities": [location]})
  	});

	data = await response.json();
	if(data == true) {
		alert("Registered for location: " + location);
	} else {
		alert("Already registered for location or server error, try again");

	}
}


async function showDoctors() {
	var condition = document.getElementById("searchDoc").value;
	response = await fetch('http://localhost:8080/find/doctor/'
	 + condition, {
	    method: 'GET',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  }
  	});

	data = await response.json();
	console.log(data);
	count = 0;
	var element = document.getElementById("doctors");
	element.style.margin = "50px";
	element.innerHTML = "";
	for(var key in data) {
		count++;
		var para = document.createElement("p");
		para.style.margin = "50px";
		para.id = key;
		var node = document.createTextNode(data[key]);
		para.appendChild(node);
		var node2 = document.createTextNode("  at  " + key.split(":")[1]);
		para.appendChild(node2);
		var input = document.createElement("input");
		input.type = "text";
		input.id = key + "date";
		input.placeholder = "Enter date of appointment";
		input.style.margin = "20px";

		var btn = document.createElement("BUTTON");   // Create a <button> element
		btn.innerHTML = "Make Appointment"; 
		btn.id = key;
		btn.onclick = function() { appoint(this.id) }; 
		btn.style.margin = "20px";
		var element = document.getElementById("doctors");
		element.appendChild(para);
		para.appendChild(input);
		para.appendChild(btn);



	}

	if(count == 0) {
		var element = document.getElementById("doctors");
		element.style.margin = "50px";
		element.innerHTML = "No doctor signed up yet";
	}
}


async function showDoctorsAnonymous() {
	var condition = document.getElementById("searchDocA").value;
	response = await fetch('http://localhost:8080/find/doctor/'
	 + condition, {
	    method: 'GET',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  }
  	});

	data = await response.json();
	console.log(data);
	count = 0;
	for(var key in data) {
		var element = document.getElementById("anonymousdoc");
		element.style.margin = "50px";
		element.innerHTML = "";
		count++;
		var para = document.createElement("p");
		para.style.margin = "50px";
		para.id = key;
		var node = document.createTextNode(data[key]);
		para.appendChild(node);
		var node2 = document.createTextNode("  at  " + key.split(":")[1]);
		para.appendChild(node2);
		var input = document.createElement("input");
		input.type = "text";
		input.id = "date";
		input.placeholder = "Enter date of appointment";
		input.style.margin = "20px";

		var btn = document.createElement("BUTTON");   // Create a <button> element
		btn.innerHTML = "Make Appointment"; 
		btn.onclick = function() { appoint(key) }; 
		btn.style.margin = "20px";
		var element = document.getElementById("anonymousdoc");
		element.appendChild(para);
		para.appendChild(input);
		para.appendChild(btn);



	}

	if(count == 0) {
		var element = document.getElementById("anonymousdoc");
		element.style.margin = "50px";
		element.innerHTML = "No doctor signed up yet";
	}
}



async function appoint(key) {
	var date = document.getElementById(key + "date").value;
	response = await fetch('http://localhost:8080/register/appointment/'
	 + key.split(":")[0] + "/" + key.split(":")[1], {
		method: 'POST',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  },
	    body: JSON.stringify({"date": date})
  	});

	data = await response.json();
	if(data == true) {
		alert("Appointment made for date: " + date);

	} else {
		alert("Error, make sure you are logged in !" );

	}

}

async function addLocation() {
	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}
	var name = document.getElementById("loc").value;
	var address = document.getElementById("add").value;

	response = await fetch('http://localhost:8080/register/locality', {
		method: 'POST',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  },
	    body: JSON.stringify({"name": name, "address": address})
  	});

	data = await response.json();
	if(data == true) {
		alert("Added new location: " + name);
	} else {
		alert("Already added location or server error, try again");

	}
}


async function addReward() {
	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}
	var desc = document.getElementById("desc").value;
	var count = document.getElementById("count").value;
	var loc = document.getElementById("rloc").value;
	var med = document.getElementById("med").value;
	var amt = document.getElementById("amt").value;
	var type = document.getElementById("rtype").value;

	if(type == "free") {
		response = await fetch('http://localhost:8080/register/free/' + loc, {
			method: 'POST',
		    credentials: 'include',
			headers: {
			    'Accept': 'application/json',
			    'Content-Type': 'application/json'
			  },
		    body: JSON.stringify({"description": desc, "countOfReward": count, "medicineName": med})
	  	});
	} else {
		response = await fetch('http://localhost:8080/register/discount/' + loc , {
			method: 'POST',
		    credentials: 'include',
			headers: {
			    'Accept': 'application/json',
			    'Content-Type': 'application/json'
			  },
		    body: JSON.stringify({"description": desc, "countOfReward": count, "amount": amt})
	  	});
	}



	data = await response.json();
	if(data == true) {
		alert("Added new Reward: " + desc);
	} else {
		alert("Already added Reward or server error, try again");

	}
}


async function showDoctorRewards() {
	response = await fetch('http://localhost:8080/find/reward/location/doctor'
	, {
	    method: 'GET',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  }
  	});

	data = await response.json();
	rewards = data["rewards"];
	console.log(rewards);

	count = 0;
	for(var i=0; i < rewards.length; i++) {
		count++;
		var para = document.createElement("p");
		para.style.margin = "50px";
		para.id = rewards[i];
		var node = document.createTextNode(rewards[i]);
		para.appendChild(node);

		var btn = document.createElement("BUTTON");   // Create a <button> element
		btn.innerHTML = "Sign Up"; 
		btn.id = rewards[i];

		btn.onclick = function() { signReward(this.id) }; 
		btn.style.margin = "20px";
		var element = document.getElementById("doc-rewards");
		element.appendChild(para);
		para.appendChild(btn);



	}

	if(count == 0) {
		var element = document.getElementById("doc-rewards");
		element.style.margin = "50px";
		element.innerHTML = "No reward to sign up for yet";
	}
}


async function signReward(key) {
	response = await fetch('http://localhost:8080/register/doctor/reward'
	, {
		method: 'POST',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  },
	    body: JSON.stringify({"rewards": [key]})
  	});

	data = await response.json();
	if(data == false) {
		alert("Error, try again");

	} else {
		alert("Signed up for reward: " + key);

	}

}


async function addFeedbackDoc(doc) {
	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}
	document.getElementById("feedback").style.display = "block";


	document.getElementById("sendfeed").onclick = async function() {
		var rate = document.getElementById("rate").value;
		var rev = document.getElementById("rev").value;

		response = await fetch('http://localhost:8080/register/rating/doctor/' + doc, {
			method: 'POST',
		    credentials: 'include',
			headers: {
			    'Accept': 'application/json',
			    'Content-Type': 'application/json'
			  },
		    body: JSON.stringify({"rating": rate})
	  	});

	  	response = await fetch('http://localhost:8080/register/review/doctor/' + doc, {
			method: 'POST',
		    credentials: 'include',
			headers: {
			    'Accept': 'application/json',
			    'Content-Type': 'application/json'
			  },
		    body: JSON.stringify({"review": rev})
	  	});


		data = await response.json();
		if(data == true) {
			alert("Added new Feedback successfully");
			document.getElementById("feedback").style.display = "none";

		} else {
			alert("Server error, try again");

		}



	}
}


async function addFeedbackLoc(loc) {
	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}

	document.getElementById("feedback").style.display = "block";


	document.getElementById("sendfeed").onclick = async function() {
		var rate = document.getElementById("rate").value;
		var rev = document.getElementById("rev").value;

		response = await fetch('http://localhost:8080/register/rating/locality/' + loc, {
			method: 'POST',
		    credentials: 'include',
			headers: {
			    'Accept': 'application/json',
			    'Content-Type': 'application/json'
			  },
		    body: JSON.stringify({"rating": rate})
	  	});

	  	response = await fetch('http://localhost:8080/register/review/locality/' + loc, {
			method: 'POST',
		    credentials: 'include',
			headers: {
			    'Accept': 'application/json',
			    'Content-Type': 'application/json'
			  },
		    body: JSON.stringify({"review": rev})
	  	});


		data = await response.json();
		if(data == true) {
			alert("Added new Feedback successfully");
			document.getElementById("feedback").style.display = "none";

		} else {
			alert("Server error, try again");

		}



	}


}


async function loadManager() {

	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}
	response = await fetch('http://localhost:8080/find/feedback/appManager', {
	    method: 'GET',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  }
  	});

	data = await response.json();
	console.log(data)
	for(key in data) {

		var para = document.createElement("p");
		para.style.margin = "50px";

		var node = document.createTextNode(data[key]);
		para.appendChild(node);

		var btn1 = document.createElement("BUTTON");   // Create a <button> element
		btn1.innerHTML = "Mark as seen"; 
		btn1.id = key;

		btn1.onclick = function() { seenFeedback(this.id) }; 
		btn1.style.margin = "20px";

		var element = document.getElementById("allFeedback");
		element.appendChild(para);
		para.appendChild(btn1);


	}

}


async function seenFeedback(key) {
	try{
		response = await fetch('http://localhost:8080/update/feedback/'
		 + key, {
	    method: 'PUT',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  },
  	}) 

	} catch(error) {
		alert("Error updating");
	}

	success = await response.json();
	console.log(success)
	if(success == true) {
		document.getElementById(key).style.display = "none";
		alert("Successful");
					
	}
} 

function updatePat() {
	location = 'updatePat.html'
}

function updateDoc() {
	location = 'updateDoc.html'
	
}

function updateLoc() {
	location = 'updateLoc.html'
	
}

async function loadUpdatePatient() {
	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}
	response = await fetch('http://localhost:8080/find/patient', {
	    method: 'GET',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  }
  	});

	data = await response.json();
	console.log(data)
	for(key in data) {

		var para = document.createElement("p");
		para.style.margin = "50px";

		var node = document.createTextNode("Patient " + data[key]);
		para.appendChild(node);

		var btn1 = document.createElement("BUTTON");   // Create a <button> element
		btn1.innerHTML = "Update"; 
		btn1.id = key;

		var btn2 = document.createElement("BUTTON");   // Create a <button> element
		btn2.innerHTML = "Delete"; 
		btn2.id = key;

		btn1.onclick = function() { updatePatient(this.id) }; 
		btn1.style.margin = "20px";

		btn2.onclick = function() { deletePatient(this.id) }; 
		btn2.style.margin = "20px";

		var element = document.getElementById("allPat");
		element.appendChild(para);
		para.appendChild(btn1);
		para.appendChild(btn2);

	}

}


async function loadUpdateDoctor() {
	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}
	response = await fetch('http://localhost:8080/find/doctor', {
	    method: 'GET',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  }
  	});

	data = await response.json();
	console.log(data)
	for(key in data) {

		var para = document.createElement("p");
		para.style.margin = "50px";

		var node = document.createTextNode("Doctor " + data[key]);
		para.appendChild(node);

		var btn1 = document.createElement("BUTTON");   // Create a <button> element
		btn1.innerHTML = "Update"; 
		btn1.id = key;

		var btn2 = document.createElement("BUTTON");   // Create a <button> element
		btn2.innerHTML = "Delete"; 
		btn2.id = key;

		btn2.onclick = function() { deleteDoctor(this.id) }; 
		btn2.style.margin = "20px";

		btn1.onclick = function() { updateDoctor(this.id) }; 
		btn1.style.margin = "20px";

		var element = document.getElementById("allDoc");
		element.appendChild(para);
		para.appendChild(btn1);
		para.appendChild(btn2);



	}

}


async function loadUpdateLocation() {
	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}
	response = await fetch('http://localhost:8080/find/locality', {
	    method: 'GET',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  }
  	});

	data = await response.json();
	console.log(data)
	for(var i = 0; i < data.length; i++) {

		var para = document.createElement("p");
		para.style.margin = "50px";

		var node = document.createTextNode("Location " + data[i]);
		para.appendChild(node);

		var btn1 = document.createElement("BUTTON");   // Create a <button> element
		btn1.innerHTML = "Update"; 
		btn1.id = data[i];

		var btn2 = document.createElement("BUTTON");   // Create a <button> element
		btn2.innerHTML = "Delete"; 
		btn2.id = data[i];



		btn1.onclick = function() { updateLocation(this.id) }; 
		btn1.style.margin = "20px";

		btn2.onclick = function() { deleteLocation(this.id) }; 
		btn2.style.margin = "20px";

		var element = document.getElementById("allLoc");
		element.appendChild(para);
		para.appendChild(btn1);
		para.appendChild(btn2);

	}

}




async function updatePatient(key) {

	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}

	document.getElementById("updatePatient").style.display = "block";


	document.getElementById("sendUpdatePatient").onclick = async function() {
		var uname = document.getElementById("upuname").value;
		var psw = document.getElementById("uppsw").value;

		response = await fetch('http://localhost:8080/update/patient/' + key, {
			method: 'PUT',
		    credentials: 'include',
			headers: {
			    'Accept': 'application/json',
			    'Content-Type': 'application/json'
			  },
		    body: JSON.stringify({"userName": uname, "password": psw})
	  	});

		data = await response.json();
		if(data == true) {
			alert("Updated successfully");
			document.getElementById("updatePatient").style.display = "none";

		} else {
			alert("Server error, try again");

		}
	}
	
}



async function updateDoctor(key) {

	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}

	document.getElementById("updateDoctor").style.display = "block";


	document.getElementById("sendUpdateDoctor").onclick = async function() {
		var uname = document.getElementById("uduname").value;
		var psw = document.getElementById("udpsw").value;

		response = await fetch('http://localhost:8080/update/doctor/' + key, {
			method: 'PUT',
		    credentials: 'include',
			headers: {
			    'Accept': 'application/json',
			    'Content-Type': 'application/json'
			  },
		    body: JSON.stringify({"userName": uname, "password": psw})
	  	});

		data = await response.json();
		if(data == true) {
			alert("Updated successfully");
			document.getElementById("updateDoctor").style.display = "none";

		} else {
			alert("Server error, try again");

		}
	}
	
}


async function updateLocation(key) {

	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}

	document.getElementById("updateLocation").style.display = "block";


	document.getElementById("sendUpdateLocation").onclick = async function() {
		var name = document.getElementById("ulloc").value;
		var add = document.getElementById("uladd").value;

		response = await fetch('http://localhost:8080/update/locality/' + key, {
			method: 'PUT',
		    credentials: 'include',
			headers: {
			    'Accept': 'application/json',
			    'Content-Type': 'application/json'
			  },
		    body: JSON.stringify({"name": name, "address": add})
	  	});

		data = await response.json();
		if(data == true) {
			alert("Updated successfully");
			document.getElementById("updateLocation").style.display = "none";

		} else {
			alert("Server error, try again");

		}
	}
	
}

async function deletePatient(key) {

	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}

	response = await fetch('http://localhost:8080/delete/patient/' + key, {
		method: 'DELETE',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  },
  	});

	data = await response.json();
	if(data == true) {
		alert("Deleted successfully");
		location.reload();

	} else {
		alert("Server error, try again");

	}
	


}


async function deleteDoctor(key) {

	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}

	response = await fetch('http://localhost:8080/delete/doctor/' + key, {
		method: 'DELETE',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  },
  	});

	data = await response.json();
	if(data == true) {
		alert("Deleted successfully");
		location.reload();

	} else {
		alert("Server error, try again");

	}


}


async function deleteLocationDoc(key) {

	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}

	response = await fetch('http://localhost:8080/delete/doctor/locality/' + key, {
		method: 'DELETE',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  },
  	});

	data = await response.json();
	if(data == true) {
		alert("Deleted successfully");
		location.reload();

	} else {
		alert("Server error, try again");

	}

}



async function loadDelLocation() {

	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}
	response = await fetch('http://localhost:8080/find/locality/doctor', {
	    method: 'GET',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  }
  	});

	data = await response.json();
	console.log(data)
	for(var i = 0; i < data.length; i++) {

		var para = document.createElement("p");
		para.style.margin = "50px";

		var node = document.createTextNode("Location " + data[i]);
		para.appendChild(node);

		var btn1 = document.createElement("BUTTON");   // Create a <button> element
		btn1.innerHTML = "Delete"; 
		btn1.id = data[i];

		btn1.onclick = function() { deleteLocationDoc(this.id) }; 
		btn1.style.margin = "20px";

		var element = document.getElementById("dellocations");
		element.appendChild(para);
		para.appendChild(btn1);


	}

}


async function deleteLocation(key) {

	var login = localStorage.getItem('login');
	if(login == null) {
		alert("Not logged In");
		location = "login.html";
	}

	response = await fetch('http://localhost:8080/delete/locality/' + key, {
		method: 'DELETE',
	    credentials: 'include',
		headers: {
		    'Accept': 'application/json',
		    'Content-Type': 'application/json'
		  },
  	});

	data = await response.json();
	if(data == true) {
		alert("Deleted successfully");
		location.reload();

	} else {
		alert("Server error, try again");

	}

}