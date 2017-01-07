/**
 * Created by dhnhan on 18/10/2016.
 */
expenseModule.controller('ExpenseController',
    ['$scope', '$uibModal', 'ExpenseService',
        function ($scope, $uibModal, ExpenseService) {
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

            $scope.showDialogExpense = function (date) {
                var modalIntance = $uibModal.open({
                    animation: true,
                    ariaLabelledBy: 'modal-title',
                    ariaDescribedBy: 'modal-body',
                    templateUrl: 'static/js/expense/templates/expense-dialog.html',
                    controller: 'DialogSpendController',
                    size: 'lg',
                    resolve: {
                        DATE: function () {
                            return date;
                        }
                    }
                });

            }


        }]);