

function registerDetails() { // onclick of register Button
    console.log("hi");
    var validation = validateForm();
    if (validation) {
        var users = JSON.parse(localStorage.getItem('Users')) || [];
        var userData = [{
            Email: document.getElementById("emailAddress").value
        }, {
            Phone: document.getElementById("phoneNumber").value
        }, {
            Username: document.getElementById("userName").value
        }, {
            LoginPassword: document.getElementById("registerPassword").value
        }];
        users.push(userData);
        localStorage.setItem('Users', JSON.stringify(users));
        alert("Registered Succesfully");
    }
}
function validateForm() {
    console.log("hello");
    let msg;
    if (document.getElementById("emailAddress").value == "") {
        return false;
    } else if (document.getElementById("phoneNumber").value == "") {
        return false;
    } else if (document.getElementById("userName").value == "") {
        return false;
    } else if (document.getElementById("registerPassword").value == "") {
        return false;
    }
    if (document.getElementById("registerPassword").value != "") {
        var str = document.getElementById("registerPassword").value;
        if (str.match(/[a-z]/g) && str.match(/[A-Z]/g) && str.match(/[0-9]/g) && str.match(/[^a-zA-Z\d]/g) && str.length >= 6) {

        } else {
           msg=document.getElementById("msg").innerHTML="Password must be 6 to 20 characters <br> which contain at least: <br> one numeric digit <br> one uppercase <br> one lowercase letter";
           document.getElementById("msg").style.color = "#ff0000";
           document.getElementById("msg").style.fontSize = "12px";
           document.getElementById("registerTemplate").pwd.reset();
           return false;
       }
   }
   return true;
}
function reset()
{
    document.getElementById("registerTemplate").reset();
}
function validBirth(){
    var dob=new Date(document.getElementById('dob').value);
    var currentDate=new Date();
    if(currentDate.getFullYear()-dob.getFullYear()<18){
        document.getElementById('dobMsg').innerHTML="age is below 18 years";
    }
    else{
        document.getElementById('dobMsg').innerHTML="";
    }
}
function years(){
   var currentDate=new Date();
   var current=(currentDate.getFullYear()-18);
   console.log(current);
   newYear=currentDate.setFullYear(current);
   console.log(newYear);
   var newD=new Date(newYear);
   console.log(newYear);
   var thisdate=newD.toString();
   var nowDate=convertDate(thisdate);
   //console.log(convertDate(thisdate))
   //new Date(newYear);
   alert(newD)
   document.getElementById('dob').setAttribute("max",nowDate);
   
}

function convertDate(strDate){
    console.log(strDate);
    var date = new Date(strDate),
    mnth = ("0" + (date.getMonth() + 1)).slice(-2),
    day = ("0" + date.getDate()).slice(-2);
  return [date.getFullYear(), mnth, day].join("-");
    //return strDate;
}
