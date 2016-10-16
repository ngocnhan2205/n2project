/**
 * Created by dhnhan on 09/10/2016.
 */
homeModule
    .controller('HomeController', ['$scope', '$mdSidenav','HomeService',
        function ($scope, $mdSidenav, HomeService) {
            $scope.menus = [];

            $scope.getMenu = function(){
                HomeService.getMenu().then(function (res) {
                    console.log(res.data);
                    $scope.menus =res.data;
                })
            };

            $scope.getMenu();


            $scope.openSideNavPanel = function() {
                $mdSidenav('left').open();
            };
            $scope.closeSideNavPanel = function() {
                $mdSidenav('left').close();
            };

        }]);