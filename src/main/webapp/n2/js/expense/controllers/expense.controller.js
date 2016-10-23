/**
 * Created by dhnhan on 18/10/2016.
 */
expenseModule.controller('ExpenseController',
    ['$scope', '$mdDialog', 'ExpenseService', '$mdBottomSheet', 'GRAN', 'N2Service', 'N2_ACTION',
        function ($scope, $mdDialog, ExpenseService, $mdBottomSheet, GRAN, N2Service, N2_ACTION) {
        $scope.setting = {};
        $scope.setting.gran = GRAN[0];
        $scope.setting.date = moment(new Date()).format('DD/MM/YYYY');
        $scope.expenses = [];

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

            $scope.deleteExpense = function (e, id) {
                var con = N2Service.showConfirm('Expense', 'Are you want delete it?', e);
                $mdDialog.show(con).then(function () {
                    ExpenseService.deleteExpense(id).then(function (res) {
                        $n2.removeObjInObjs($scope.expenses, res.data.id);
                    });
                })
        };

        function init() {
            ExpenseService.getExpense($scope.setting).then(function(res){
                $scope.expenses = res.data;
            })
        }


        $scope.showOption = function () {
            $mdBottomSheet.show({
                templateUrl: 'static/js/expense/templates/option-tpl.html',
                controller: 'OptionController',
                clickOutsideToClose: true
            }).then(function (setting) {
                var format = 'DD/MM/YYYY';
                if (setting.gran.value == 'month') {
                    format = 'MM/YYYY';
                }
                $scope.setting.gran = setting.gran;
                $scope.setting.date = moment(setting.date).format(format);
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



        init();
    }]);