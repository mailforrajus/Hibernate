
function validation(frm){
	alert("Client side form validations......");
	//read form data
	 var sname=frm.sname.value;
	 var sadd=frm.sadd.value;
	 var course=frm.course.value;
	 var percentage=frm.percentage.value;
	 //empty validation error messages
	 document.getElementById("snameErr").innerHTML="";
	 document.getElementById("saddErr").innerHTML="";
	 document.getElementById("courseErr").innerHTML="";
	 document.getElementById("percentageErr").innerHTML="";
	 
	 //set hidden box value to "yes" indicating that client side form validations are happening
	 frm.vflag.value="yes";
	 //perform clientside form validations
	 if(sname==""){
		document.getElementById("snameErr").innerHTML="student name is mandatory";
		 frm.sname.focus();
		 return false;
	 }
	 if(sadd==""){
		 document.getElementById("saddErr").innerHTML="student adress is mandatory";
		 frm.sadd.focus();
		 return false;
	 }
	
	 if(course==""){
		 document.getElementById("courseErr").innerHTML="student course is mandatory";
		 frm.course.focus();
		 return false;
	 }
	
	 if(percentage==""){
		 document.getElementById("percentageErr").innerHTML="student percentage is mandatory";
		 frm.percentage.focus();
		 return false;
	 }
	 else if(isNaN(percentage)){
		 document.getElementById("percentageErr").innerHTML="student Percentage must be a numeric value";
		 frm.percentage.focus();
		 return false;
	 }
	 else if(percentage<0 || percentage>100){
		 document.getElementById("percentageErr").innerHTML="student Percentage must be in the range of 0 through 100";
		 frm.percentage.focus();
		 return false;
	 }
	 return true;
}//function
