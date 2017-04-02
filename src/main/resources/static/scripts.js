var IndexApp = angular.module('IndexApp', []);

IndexApp.controller('DataFromSiteController',
    function ($scope, $http) {
        $scope.addData = function () {
                $http.put('/api/hover-data/save-from-site').
                    success(function(data) {
                        $scope.sitedata=data;
                    });
        }
    }

);

IndexApp.controller('DBDataController',
    function DBDataController($scope, $http){
        $http.get('/api/hover-data').
            success(function(data) {
                $scope.dbdata=data;
            });
    }
);

IndexApp.controller('DBGroupedDataController',
    function DBGroupedDataController($scope, $http){
        $http.get('/api/hover-data/group-by-renderingEngine').
            success(function(data) {
                $scope.dbdata=data;
            });
    }
);