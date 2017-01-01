/**
 * Created by banhu on 1/1/2017.
 */
appMain.directive('focusOnShow', function ($timeout) {
    return {
        restrict: 'A',
        link: function ($scope, $element, $attr) {
            if ($attr.ngShow) {
                $scope.$watch($attr.ngShow, function (newValue) {
                    if (newValue) {
                        $timeout(function () {
                            $element[0].querySelector('.lbExpense').focus();
                        }, 0);
                    }
                })
            }

        }
    };
});
