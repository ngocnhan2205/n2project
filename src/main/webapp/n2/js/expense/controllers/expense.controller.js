/**
 * Created by dhnhan on 18/10/2016.
 */
expenseModule.controller('ExpenseController', ['$scope', '$mdDialog', 'ExpenseService',
    function ($scope, $mdDialog, ExpenseService) {
        $scope.showDialogExpense = function (ev) {
            $mdDialog.show({
                controller: DialogExpenseController,
                templateUrl: 'static/js/expense/templates/expense-dialog.html',
                parent: angular.element(document.body),
                targetEvent: ev,
                clickOutsideToClose: true,
                fullscreen: true
            })
                .then(function (data) {

                }, function () {

                });
        };

        function DialogExpenseController($scope, $mdDialog, ExpenseService) {
            $scope.expense = {};
            $scope.cancel = function () {
                $mdDialog.cancel();
            }

            $scope.save = function () {
                var obj = {
                    expense: $scope.expense
                };
                ExpenseService.saveExpense(obj).then(function (data) {
                    console.log(data.data);
                })
            }
        }
    }]);