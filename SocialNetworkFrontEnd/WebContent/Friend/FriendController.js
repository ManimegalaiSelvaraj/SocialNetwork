myapp.controller("FriendController",function($scope,$http,$location,$rootScope)
{
	$scope.friend={friendId:0,userName:'',friendName:'',status:''};
	$scope.allFriendRequest;

	function fetchAllFriendRequests()
	{
		$http.get('')
		.then(function(response)
		{
			$scope.allFriendRequest=response.data;
			console.log($scope.allFriendRequest);
		});
	}
	fetchAllFriedRequests();
	$scope.reject=function(friendId)
	{
		console.log("Rejection");
		$http.get('')
		.success(function(response)
				{
			console.log('success');
				
	});
	}
	$scope.approve=function(friendId)
	{
		console.log('Approval');
		$http.get('')
		.success(function(response)
				{
			console.log('success');
				});
	}
});
