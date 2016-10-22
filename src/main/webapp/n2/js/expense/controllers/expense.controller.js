/**
 * Created by dhnhan on 18/10/2016.
 */
expenseModule.controller('ExpenseController', ['$scope', '$mdDialog', 'ExpenseService', '$mdBottomSheet', 'GRAN',
    function ($scope, $mdDialog, ExpenseService, $mdBottomSheet, GRAN) {
        $scope.setting = {};
        $scope.setting.gran = GRAN[0];
        $scope.setting.date = moment(new Date()).format('DD/MM/YYYY');
        $scope.expenses = [];

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

        function init() {
            ExpenseService.getExpense($scope.setting).then(function(res){
                $scope.expenses = res.data;
            })
        }


        $scope.showOption = function () {
            $scope.alert = '';
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


        function DialogExpenseController($scope, $mdDialog, ExpenseService) {
            $scope.expense = {};
            $scope.cancel = function () {
                $mdDialog.cancel();
            };

            $scope.save = function () {
                var obj = {
                    expense: $scope.expense
                };
                ExpenseService.saveExpense(obj).then(function (data) {
                    console.log(data.data);
                })
            }
        }


        $scope.desserts = {
            "count": 9,
            "data": [
                {
                    "name": "Frozen yogurt",
                    "type": "Ice cream",
                    "calories": {"value": 159.0},
                    "fat": {"value": 6.0},
                    "carbs": {"value": 24.0},
                    "protein": {"value": 4.0},
                    "sodium": {"value": 87.0},
                    "calcium": {"value": 14.0},
                    "iron": {"value": 1.0}
                }, {
                    "name": "Ice cream sandwich",
                    "type": "Ice cream",
                    "calories": {"value": 237.0},
                    "fat": {"value": 9.0},
                    "carbs": {"value": 37.0},
                    "protein": {"value": 4.3},
                    "sodium": {"value": 129.0},
                    "calcium": {"value": 8.0},
                    "iron": {"value": 1.0}
                }, {
                    "name": "Eclair",
                    "type": "Pastry",
                    "calories": {"value": 262.0},
                    "fat": {"value": 16.0},
                    "carbs": {"value": 24.0},
                    "protein": {"value": 6.0},
                    "sodium": {"value": 337.0},
                    "calcium": {"value": 6.0},
                    "iron": {"value": 7.0}
                }, {
                    "name": "Cupcake",
                    "type": "Pastry",
                    "calories": {"value": 305.0},
                    "fat": {"value": 3.7},
                    "carbs": {"value": 67.0},
                    "protein": {"value": 4.3},
                    "sodium": {"value": 413.0},
                    "calcium": {"value": 3.0},
                    "iron": {"value": 8.0}
                }, {
                    "name": "Jelly bean",
                    "type": "Candy",
                    "calories": {"value": 375.0},
                    "fat": {"value": 0.0},
                    "carbs": {"value": 94.0},
                    "protein": {"value": 0.0},
                    "sodium": {"value": 50.0},
                    "calcium": {"value": 0.0},
                    "iron": {"value": 0.0}
                }, {
                    "name": "Lollipop",
                    "type": "Candy",
                    "calories": {"value": 392.0},
                    "fat": {"value": 0.2},
                    "carbs": {"value": 98.0},
                    "protein": {"value": 0.0},
                    "sodium": {"value": 38.0},
                    "calcium": {"value": 0.0},
                    "iron": {"value": 2.0}
                }, {
                    "name": "Honeycomb",
                    "type": "Other",
                    "calories": {"value": 408.0},
                    "fat": {"value": 3.2},
                    "carbs": {"value": 87.0},
                    "protein": {"value": 6.5},
                    "sodium": {"value": 562.0},
                    "calcium": {"value": 0.0},
                    "iron": {"value": 45.0}
                }, {
                    "name": "Donut",
                    "type": "Pastry",
                    "calories": {"value": 452.0},
                    "fat": {"value": 25.0},
                    "carbs": {"value": 51.0},
                    "protein": {"value": 4.9},
                    "sodium": {"value": 326.0},
                    "calcium": {"value": 2.0},
                    "iron": {"value": 22.0}
                }, {
                    "name": "KitKat",
                    "type": "Candy",
                    "calories": {"value": 518.0},
                    "fat": {"value": 26.0},
                    "carbs": {"value": 65.0},
                    "protein": {"value": 7.0},
                    "sodium": {"value": 54.0},
                    "calcium": {"value": 12.0},
                    "iron": {"value": 6.0}
                }
            ]
        };

        init();
    }]);