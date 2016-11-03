/**
 * Created by dhnhan on 21/10/2016.
 */
expenseModule.controller('OptionController', ['$scope', '$mdBottomSheet', 'GRAN',
    function ($scope, $mdBottomSheet, GRAN) {
        $scope.setting = {};
        $scope.setting.date = new Date();

        $scope.cancel = function () {
            $mdBottomSheet.cancel();
        };

        $scope.ok = function () {
            $mdBottomSheet.hide($scope.setting);
        }
    }]);