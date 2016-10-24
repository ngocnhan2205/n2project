/**
 * Created by dhnhan on 09/10/2016.
 */
homeModule
    .controller('HomeController', ['$scope', '$mdSidenav', 'HomeService', '$cookieStore', '$window',
        function ($scope, $mdSidenav, HomeService, $cookieStore, $window) {
            $scope.menus = [];
            $scope.user = {};

            $scope.getMenu = function () {
                HomeService.getMenu().then(function (res) {
                    $scope.menus = res.data;
                })
            };

            $scope.getUser = function () {
                HomeService.getUser().then(function (res) {
                    $scope.user = res.data;
                })
            };

            $scope.logout = function () {
                HomeService.logout().then(function () {
                    $cookieStore.remove('n2Token');
                    $window.location.href = '#/n2/login';
                })
            };

            function init() {
                $scope.getUser();
                $scope.getMenu();
            }

            init();

            $scope.openSideNavPanel = function () {
                $mdSidenav('left').open();
            };
            $scope.closeSideNavPanel = function () {
                $mdSidenav('left').close();
            };

        }]);