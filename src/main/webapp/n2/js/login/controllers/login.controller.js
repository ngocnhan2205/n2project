/**
 * Created by dhnhan on 09/10/2016.
 */
loginModule
    .controller('LoginController', ['$scope', '$mdSidenav', '$state', 'AuthService',
        function ($scope, $mdSidenav, $state, AuthService) {
            $scope.user = {};
            $scope.login = function (e) {
                AuthService.auth($scope.user, e).then(function (res) {
                    if (res.status == 200) {
                        $state.go('home.dashboard');
                    }
                });
            }
        }]);