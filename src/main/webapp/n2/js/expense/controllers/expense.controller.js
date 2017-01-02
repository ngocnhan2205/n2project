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

            /*function buildCalendarNow(date) {
                var last = $n2.getLastDate(date);
                var dateLast = $n2.getLastDayOfMonthToday(date);
                var month = dateLast.getMonth() + 1;
                var year = dateLast.getFullYear();
                var dates = [];
                var obj = null;
                for (var i = 1; i <= last; i++) {
                    var d = new Date(year, month, i);
                    obj = {};
                    obj.value = 500;
                    obj.date = i;
                    obj.day = $n2.getDayOfWeek(d);
                    obj.dateObj = d;
             obj.fullDate = $n2.formatDateToDay(d);
                    if (i == date.getDate()) {
                        obj.active = true;
                    }
                    dates.push(obj);
                }
                return dates;
             }*/


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