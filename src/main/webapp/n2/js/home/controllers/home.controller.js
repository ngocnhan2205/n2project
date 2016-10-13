/**
 * Created by dhnhan on 09/10/2016.
 */
homeModule
    .controller('HomeController', ['$scope', '$http', '$mdSidenav',
        function ($scope, $http, $mdSidenav) {
            $scope.index = 0;
            $scope.openSideNavPanel = function() {
                $mdSidenav('left').open();
            };
            $scope.closeSideNavPanel = function() {
                $mdSidenav('left').close();
            };
        }]);