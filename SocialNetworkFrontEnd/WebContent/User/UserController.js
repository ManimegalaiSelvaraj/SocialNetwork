myapp.controller("UserController",function($scope,$http,$location,$window,$rootScope)
{
	$scope.userDetail={userName:"",password:"",emailId:"",isOnline:"",role:"",userId:""};

	$scope.addUser=function()
	{
		
		//console.log('Entered into InsertBlog');
		$http.post('http://localhost:8080/SocialNetworkRestApp/addUser',$scope.userDetail)
		.then(function(response)
				{
				console.log('Successful User Entered');
				});
	}
	//console.log("hello from Controller");
	//$window.localStorage.setItem("userDetail",JSON.stringify($scope.userDetail));
	
	//$scope.currentuser=ddd;
	//var currentuser= JSON.parse($window.localStorage.getItem('userDetail'));
	//console.log(currentuser.role);
	//console.log(currentuser.status);
	
	

	$scope.login=function()
	{		$http.post('http://localhost:8080/SocialNetworkRestApp/login',$scope.userDetail)
		.then(function(response)
		{
			
			$scope.userDetail=response.data;
			$window.localStorage.setItem("userDetail",JSON.stringify($scope.userDetail));
			var currentuser= JSON.parse($window.localStorage.getItem('userDetail'));
			//console.log(currentuser.role);
			//console.log(currentuser.status);

			$window.location.href='/SocialNetworkFrontEnd/User/UserHome.html';
			

		});
	}
	$scope.logout=function(){
		var currentuser= JSON.parse($window.localStorage.getItem('userDetail'));
		console.log(currentuser.role);
		console.log(currentuser.status);
		console.log("inside logout"+$scope.currentuser.userName);
				$http.get('http://localhost:8080/SocialNetworkRestApp/logoutuser/'+$scope.currentuser.userName)
				.then(function(response)
						{
					    var key = "userDetail";
						console.log('Successfully loggedout');
						console.log("ddddddddd",JSON.parse($window.localStorage.getItem(key)));
						$window.localStorage.removeItem(key)
						console.log("ddddddddd",JSON.parse($window.localStorage.getItem(key)));
						 //$cookieStore.remove('userdetail');
						 //var cook=$cookieStore.get('userdetail');
						 //$scope.currentuser=cook;
						$window.location.href='/SocialNetworkFrontEnd/';
						});
			}
	});
