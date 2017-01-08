/**
 * <button class="btn btn-sm btn-danger" ng-confirm-click="Are you sure to delete this record ?" confirmed-click="removeUser($index)">Delete</button>
 * Created by banhu on 1/8/2017.
 */
appMain.directive('ngConfirmClick', [
    function () {
        return {
            link: function (scope, element, attr) {
                var msg = attr.ngConfirmClick || "Are you sure?";
                var clickAction = attr.confirmedClick;
                element.bind('click', function (event) {
                    if (window.confirm(msg)) {
                        scope.$eval(clickAction)
                    }
                });
            }
        };
    }]);