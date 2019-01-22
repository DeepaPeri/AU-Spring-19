
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link href="myStyle.css" rel="stylesheet" media="screen">

<title>Login Form</title>
</head>
<style>

</style>
<body >
<h3 align = "center"> <font face="georgia" size = "22" color="green" >Login here if you already have an account</font></h3>
  <div class="container">	
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
           <h5 class="card-title text-center">Login</h5>
            <form class="form-signin" method = "post" action = "LoginFromHandle">
              <div class="form-label-group">
                <input type="text" name="inputName" class="form-control" placeholder="Email address" required autofocus>
                <label for="inputEmail">User Name</label>
              </div>
              <div class="form-label-group">
                <input type="password" name="inputPassword" class="form-control" placeholder="Password" required>
                <label for="inputPassword">Password</label>
              </div>
              <div>
              	<label style="color: red;"> ${message} </label>
              </div>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">LOGIN</button>
            </form>
            
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <div>
  	<h3 align = "center" ><font face="georgia" size = "22" color="green" >SignUp here if you don't have an account</font></h3>
  </div>
  <div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
           <h5 class="card-title text-center">SignUp</h5>
            <form class="form-signin" method = "get" action = "LoginFromHandle">
              <div class="form-label-group">
                <input type="text" name="inputName" class="form-control" placeholder="Email address" required autofocus>
                <label for="inputEmail">User Name</label>
              </div>
              <div class="form-label-group">
                <input type="password" name="inputPassword" class="form-control" placeholder="Password" required>
                <label for="inputPassword">Password</label>
              </div>
              <div>
              	<label style="color: red;"> ${message} </label>
              </div>
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">SIGN UP</button>
            </form>
            
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>

