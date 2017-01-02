/**
 * Created by banhu on 1/1/2017.
 */
expenseModule.controller('DialogSpendController', ['$scope', '$mdDialog', 'DATE', 'ExpenseService',
    function ($scope, $mdDialog, DATE, ExpenseService) {
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
                ExpenseService.saveExpense($scope.titleExpense, $scope.date).then(function (res) {
                });
            }
        };

    }]);