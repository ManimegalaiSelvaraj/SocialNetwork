myapp.controller("JobController",function($scope,$http)
{
	$scope.job={jobId:"",jobName:"",jobDate:"",jobQual:"",jobProfile:"",jobDesc:"",jobStatus:"",Salary:""};
	
	$http.get("http://localhost:8080/SocialNetworkRestApp/getAllJob")
	.then(function(response)
	{
	$scope.jobdata=response.data;
	});
	
	$scope.addJob=function()
	{
		console.log('Entered into addjob');
		$http.post('http://localhost:8080/SocialNetworkRestApp/addjob',$scope.job)
		.then(function(response)
				{
				console.log('Successful job Entered');
				});
	}
	
	
	
});

