/**
 * Created by banhu on 1/1/2017.
 */
appMain.directive('n2Enter', function () {
    return function (scope, element, attrs) {
        element.bind("keydown keypress blur", function (event) {
            if (event.which === 13 || event.type == "blur") {
                scope.$apply(function () {
                    scope.$eval(attrs.n2Enter);
                });
                event.preventDefault();
            }
        });
    };
});