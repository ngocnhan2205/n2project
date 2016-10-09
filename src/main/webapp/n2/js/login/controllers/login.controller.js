/**
 * Created by dhnhan on 09/10/2016.
 */
loginModule
    .controller('LoginController', ['$scope', '$mdSidenav', '$state','AuthService',
        function ($scope, $mdSidenav, $state, AuthService) {
            $scope.user = {};
            $scope.login = function () {
                AuthService.auth($scope.user).then(function (res) {
                    if (res.status == 200){
                        $state.go('home');
                    }
                });
            }
        }]);