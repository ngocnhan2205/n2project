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
                    controller: DialogExpenseController,
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

            function DialogExpenseController($scope, $mdDialog, ExpenseService, Action, obj, N2_ACTION) {
                $scope.expenseDialog = {};
                $scope.action = null;
                $scope.cancel = function () {
                    $mdDialog.cancel();
                };

                function init() {
                    if (obj) {
                        $scope.expenseDialog = angular.copy(obj);
                    }
                    if (Action == N2_ACTION.EDIT) {
                        $scope.action = N2_ACTION.EDIT;
                    } else {
                        $scope.action = N2_ACTION.NEW;
                    }
                }

                $scope.save = function () {
                    var obj = {
                        expense: $scope.expenseDialog
                    };
                    ExpenseService.saveExpense(obj).then(function (res) {
                        var passObj = {};
                        if (Action == N2_ACTION.EDIT) {
                            passObj.action = N2_ACTION.EDIT;
                        } else {
                            passObj.action = N2_ACTION.NEW;
                        }
                        passObj.data = res.data;
                        $mdDialog.hide(passObj);
                    });
                };
                init();
            }

            $scope.deleteExpense = function (e, id) {
                var con = N2Service.showConfirm('Expense', 'Are you want delete it?', e);
                $mdDialog.show(con).then(function () {
                    ExpenseService.deleteExpense(id).then(function (res) {
                        $n2.removeObjInObjs($scope.expenses, res.data.id);
                    });
                })
            };

            $scope.showOption = function () {
                $mdBottomSheet.show({
                    templateUrl: 'static/js/expense/templates/option-tpl.html',
                    controller: 'OptionController',
                    clickOutsideToClose: true
                }).then(function (setting) {
                    var format = 'MM/YYYY';
                    $scope.dates = buildCalendarNow(setting.date);
                    $scope.setting.date = moment(setting.date).format(format);
                });
            };
        }]);