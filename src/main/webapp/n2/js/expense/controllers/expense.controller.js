/**
 * Created by dhnhan on 18/10/2016.
 */
expenseModule.controller('ExpenseController',
    ['$scope', '$mdDialog', 'ExpenseService',
        function ($scope, $mdDialog, ExpenseService) {
            $scope.date = $n2.formatDateToDay();
            $scope.dates = [];

            var year = new Date().getFullYear();
            var month = new Date().getMonth();

            function init() {
                ExpenseService.getExpense(year, month).then(function (res) {
                    $scope.dates = res.data;
                });
            };

            init();

            $scope.showDialogExpense = function (ev, date) {
                var d = $mdDialog.show({
                    controller: 'DialogSpendController',
                    templateUrl: 'static/js/expense/templates/expense-dialog.html',
                    parent: angular.element(document.body),
                    targetEvent: ev,
                    clickOutsideToClose: true,
                    fullscreen: true,
                    locals: {
                        DATE: date
                    }
                });
                d.then(function (objData) {

                });
            };
        }]);