myapp.controller("BlogController",function($scope,$http)
{
	$scope.blog={blogId:23,blogName:"",blogContent:"",createDate:"",likes:3,userid:"",status:"A"};
	$http.get("http://localhost:8082/SocialNetworkRestApp/getAllBlogs")
	.then(function(response)
	{
	$scope.blogdata=response.data;
	});
	
	
});

