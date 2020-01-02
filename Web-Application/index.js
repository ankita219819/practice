 function valid(){
      var userExist = false;
      let msg;
      var users = JSON.parse(localStorage.getItem('Users')) || [];
            var loginuserName = document.getElementById("uname").value;
            var userPwd = document.getElementById("pwd").value;
            for (var key in users) {
              console.log(key)
                if (users.hasOwnProperty(key)) {
                  console.log(users[key]);
                    var innerUserObj = users[key];
                    for (var key in innerUserObj) { //key = 0 for email and key = 3 for password
                      console.log(innerUserObj[key][0])
                        if ((key == 2) && (innerUserObj[key]["Username"] == loginuserName)) {
                            localStorage.setItem("logname",loginuserName);
                            key = 3;
                            if ((key == 3) && (innerUserObj[key]["LoginPassword"] == userPwd)) {
                                userExist = true;
                            }
                        }
                    }
                }
              }
              if (userExist == true) {
                alert("Succesful login");
                return true;
              }
                else{
                  alert("Email / Password is Invalid. Please Register to create a account");
                  return false;
                }
    }