/**
 * Created by dhnhan on 18/10/2016.
 */
expenseModule.controller('ExpenseController',
    ['$scope', '$mdDialog', 'ExpenseService', '$mdBottomSheet', 'GRAN', 'N2Service', 'N2_ACTION',
        function ($scope, $mdDialog, ExpenseService, $mdBottomSheet, GRAN, N2Service, N2_ACTION) {
            $scope.setting = {};
            $scope.setting.date = moment(new Date()).format('DD/MM/YYYY');
            $scope.expenses = [];
            $scope.m = 1000;
            $scope.changeMonth = new Date();
            $scope.dates = buildCalendarNow(new Date());
            function buildCalendarNow(date) {
                var last = $n2.getLastDate(date);
                var dateLast = $n2.getLastDayOfMonthToday(date);
                var month = dateLast.getMonth() + 1;
                var year = dateLast.getYear();
                var dates = [];
                var obj = null;
                for (var i = 1; i <= last; i++) {
                    var d = new Date(year, month, i);
                    obj = {};
                    obj.date = i;
                    obj.day = $n2.getDayOfWeek(d);
                    obj.dateObj = d;
                    if (i == date.getDate()) {
                        obj.active = true;
                    }
                    dates.push(obj);
                }
                return dates;
            }

            $scope.showDialogExpense = function (ev, action, obj) {
                var d = $mdDialog.show({
                    controller: 'DialogSpendController',
                    templateUrl: 'static/js/expense/templates/expense-dialog.html',
                    parent: angular.element(document.body),
                    targetEvent: ev,
                    clickOutsideToClose: true,
                    fullscreen: true,
                    locals: {
                        Action: action,
                        obj: obj
                    }
                });
                d.then(function (objData) {
                    if (objData.action == N2_ACTION.EDIT) {
                        $n2.changeObjInObjs($scope.expenses, objData.data);
                    } else {
                        $scope.expenses.push(objData.data);
                    }
                });
            };
        }]);