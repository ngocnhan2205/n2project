/**
 * Created by dhnhan on 09/10/2016.
 */
homeModule
    .controller('HomeController', ['$scope', '$http','AuthService',
        function ($scope, $http, AuthService) {
            $scope.load = function () {
                $http({
                    method: 'GET',
                    url: '/user'
                }).then(function successCallback(response) {
                    console.log(response.data);
                }, function errorCallback(response) {
                    console.log('error');
                });
            }
             $scope.load();
        }]);