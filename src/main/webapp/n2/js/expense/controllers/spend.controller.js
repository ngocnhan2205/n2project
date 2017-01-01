/**
 * Created by banhu on 1/1/2017.
 */
expenseModule.controller('DialogSpendController', ['$scope', '$mdDialog', 'DATE',
    function ($scope, $mdDialog, DATE) {
        $scope.date = DATE;

        $scope.close = function () {
            $mdDialog.hide();
        }
    }]);