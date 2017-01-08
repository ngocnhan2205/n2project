/**
 * Created by banhu on 1/1/2017.
 */
expenseModule.controller('DialogSpendController', ['$scope', 'ExpenseService', 'DATE', '$uibModalInstance', 'N2Service', '$mdDialog',
    function ($scope, ExpenseService, DATE, $uibModalInstance, N2Service, $mdDialog) {
        $scope.date = DATE;
        $scope.showAdd = false;
        $scope.titleExpense = null;
        $scope.expenses = [];


        function preExpense(dates) {
            for (var i in dates) {
                i.isEditName = false;
            }
        }


        function init() {
            ExpenseService.getExpenseOfSpend($scope.date).then(function (res) {
                $scope.expenses = res.data;
                preExpense($scope.expenses);
            });
        }

        init();

        $scope.cancel = function () {
            $uibModalInstance.dismiss('cancel');
        };

        $scope.edit = function (ex) {
            ex.isEditName = true;
        };

        $scope.addExpense = function () {
            $scope.expenses.unshift({isEditName: true});
        };


        $scope.saveExpense = function (ex) {
            if ($n2.isNotEmpty(ex.name)) {
                if (ex.id) {
                    ExpenseService.updateSpendCategory(ex.id, ex.name).then(function (res) {
                        $scope.expenses[0] = res.data;
                    })
                } else {
                    ExpenseService.saveExpense(ex.name, $scope.date).then(function (res) {
                        $scope.expenses[0] = res.data;
                    });
                }
            } else {
                $scope.expenses.shift();
            }
            ex.isEditName = false;
        };

        $scope.deleteSpendCategory = function (id) {
            ExpenseService.deleteSpendCategory(id).then(function () {
            });
        }

    }]);