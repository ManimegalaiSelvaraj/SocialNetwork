myapp.controller("BlogController",function($scope,$http)
{
	$scope.blog={blogId:"",blogName:"",blogContent:"",createDate:"",likes:"",userid:"",status:""};
	$http.get("http://localhost:8080/SocialNetworkRestApp/getAllBlogs")
	.then(function(response)
	{
	$scope.blogdata=response.data;
	});
	
	$scope.addBlog=function()
	{
		console.log('Entered into InsertBlog');
		$http.post('http://localhost:8080/SocialNetworkRestApp/addBlog',$scope.blog)
		.then(function(response)
				{
				console.log('Successful Blog Entered');
				});
	}
	
	$scope.deleteBlog=function(blogId)
	{
		//console.log(blogId);
		$http.post('http://localhost:8080/SocialNetworkRestApp/deleteBlog/'+blogId)
		.then(function(response)
				{
				console.log('Successful Deleted');
				});
	}
});

