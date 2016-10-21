/**
 * Created by dhnhan on 21/10/2016.
 */
expenseModule.controller('OptionController', ['$scope','$mdBottomSheet',
    function ($scope, $mdBottomSheet) {
        $scope.cancel = function(){
            $mdBottomSheet.cancel();
        }
    }]);