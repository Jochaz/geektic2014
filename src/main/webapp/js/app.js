var app = angular.module("geektic", ['ngRoute']);

app.config(['$routeProvider',
    function($routeProvider) {
		//Définition de routeprovider
        $routeProvider.
            when('/', {
                templateUrl: 'welcome.html',
                controller: 'IndexCtrl'
            }).
            when('/search', {
                templateUrl: 'search.html',
                controller: 'SearchCtrl'
            }).
            when('/geeks/:id', {
                templateUrl: 'geeks.html',
                controller: 'GeeksCtrl'
            }).
            otherwise({
                redirectTo: '/'
            });
    }]);

app.controller('SearchCtrl', function($scope, $http) {   
	//Fonction retournant la liste des geeks en fonction de l'interet et du sexe choisi 
    $scope.search = function(item, event){
    	$http.get('api/geeks/', 
    			{params: {"sexe":$scope.sexe, "interet": $scope.interet}}
    			).success(function(lesGeeks) {
    				$scope.lesGeeks = lesGeeks;
    	}).error(function(){
    		console.log("Erreur");
    	});

    }
    
    //Retourne les interets (pour la combobox)
	$http.get('api/interets').success(function(interets) {
        $scope.lesInterets = interets;
        
    });
    
    
});


//USELESS
app.controller('IndexCtrl', function($scope, $http) {
    $http.get('api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});


//Retourne un geek en fonction de son ID
app.controller('GeeksCtrl', function($scope, $http, $routeParams) {
    $http.get('api/geeks/' + $routeParams.id).success(function(leGeek) {
        $scope.leGeek = leGeek;
    });
});
