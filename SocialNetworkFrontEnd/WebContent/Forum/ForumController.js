myapp.controller("ForumController",function($scope,$http)
{
	$scope.Forum={ForumId:"",UserId:"",forumName:"",forumContent:"",username:"",status:"",createDate:""};
	
	$http.get("http://localhost:8080/SocialNetworkRestApp/getAllForum")
	.then(function(response)
	{
	$scope.forumdata=response.data;
	});
	

	$scope.addForum=function()
	{
		console.log('Entered into InsertForum');
		$http.post('http://localhost:8080/SocialNetworkRestApp/addForum',$scope.Forum)
		.then(function(response)
				{
				console.log('Successful Forum Entered');
				});
	}
});