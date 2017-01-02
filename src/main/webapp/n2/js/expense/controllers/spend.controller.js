/**
 * Created by banhu on 1/1/2017.
 */
expenseModule.controller('DialogSpendController', ['$scope', '$mdDialog', 'DATE', 'ExpenseService',
    function ($scope, $mdDialog, DATE, ExpenseService) {
        $scope.date = DATE;
        $scope.showAdd = false;
        $scope.titleExpense = null;
        $scope.expenses = [];

        $scope.close = function () {
            $mdDialog.hide();
        };

        $scope.showAddExpense = function () {
            $scope.showAdd = true;
        };

        function init() {
            ExpenseService.getExpenseOfSpend($scope.date).then(function (res) {
                $scope.expenses = res.data;
                console.log($scope.expenses);
            })
        };

        init();

        $scope.saveExpense = function () {
            if ($n2.isEmpty($scope.titleExpense)) {
                $scope.showAdd = false;
            } else {
                ExpenseService.saveExpense($scope.titleExpense, $scope.date).then(function (res) {
                    $scope.expenses.push(res.data);
                    console.log($scope.expenses);
                    $scope.showAdd = false;
                });
            }
        };

    }]);