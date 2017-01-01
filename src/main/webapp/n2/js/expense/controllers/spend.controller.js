/**
 * Created by banhu on 1/1/2017.
 */
expenseModule.controller('DialogSpendController', ['$scope', '$mdDialog', 'DATE',
    function ($scope, $mdDialog, DATE) {
        $scope.date = DATE;
        $scope.showAdd = false;
        $scope.titleExpense = null;

        $scope.close = function () {
            $mdDialog.hide();
        };

        $scope.showAddExpense = function () {
            $scope.showAdd = true;
        };

        $scope.saveExpense = function () {
            if ($n2.isEmpty($scope.titleExpense)) {
                $scope.showAdd = false;
            } else {
                alert('sssssss');
            }
        };

    }]);