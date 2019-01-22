<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title>Update Profile</title>
</head>
<body>
<% if(session.getAttribute("check") == null) { %>
	<jsp:forward page="index.jsp"></jsp:forward>
<% } %>
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Profile Update</h5>
            <form class="form-signin" method = "post" action = "UpdateProfile">
              <div class="form-label-group">
              <label for="inputEmail">nickName</label>
                <input type="text" name="nickName" class="form-control" placeholder="Nick Name" required autofocus>
                
              </div>
              <div class="form-label-group">
              <label for="inputUsername">username</label>
                <input type="text" name="userName" class="form-control" placeholder="user Name" required>
                
              </div>
              <div class="form-label-group">
              <label for="inputCity">city</label>
                <input type="text" name="city" class="form-control" placeholder="City" required>
                
              </div>
              
              <div class="form-label-group">
              <label for="inputPassword">password</label>
                <input type="password" name="password" class="form-control" placeholder="Password" required>
                
              </div>
              
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Update</button>
        
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  
</body>
</html>