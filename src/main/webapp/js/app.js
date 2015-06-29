var app = angular.module("geektic", ['ngRoute']);

app.config(['$routeProvider',
    function($routeProvider) {
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
    $http.get('api/interets').success(function(interets) {
        $scope.lesInterets = interets;
    });

});

app.controller('SearchCtrl', function($scope, $http, $routeParams) {
    $http.get('api/geeks').success(function(lesGeek) {
        $scope.lesInterets = interets;
    });

});

app.controller('IndexCtrl', function($scope, $http) {
    $http.get('/api/hello').success(function(helloMessage) {
        $scope.helloMessage = helloMessage;
    });
});



app.controller('GeeksCtrl', function($scope, $http, $routeParams) {
    $http.get('api/geeks/' + $routeParams.id).success(function(leGeek) {
        $scope.leGeek = leGeek;
    });
});
