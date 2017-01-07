/**
 * Created by dhnhan on 08/10/2016.
 */
var moduleLib = ['ui.router',
    'ngMaterial',
    'ngAnimate',
    'ngMessages',
    'ngCookies',
    'ncy-angular-breadcrumb',
    'ui.bootstrap'
];
var moduleApp = ['Login', 'HomeModule', 'Dashboard', 'Expense'];
var app = moduleApp.concat(moduleLib);
var appMain = angular.module('N2App', app);

appMain.config(['$mdIconProvider', '$httpProvider', '$mdAriaProvider', '$mdDateLocaleProvider',
    function ($mdIconProvider, $httpProvider, $mdAriaProvider, $mdDateLocaleProvider) {
        $httpProvider.interceptors.push('AuthIn');
        $mdAriaProvider.disableWarnings();
        $mdDateLocaleProvider.formatDate = function (date) {
            return moment(date).format('DD/MM/YYYY');
        };
    }]);

appMain.run(['$rootScope', '$window', '$timeout', 'AuthService',
    function ($rootScope, $window, $timeout, AuthService) {
        $rootScope.$on('n2:error', function (event, rejection) {
            // Ignore `invalid_grant` error - should be catched on `LoginController`.
            if ('invalid_grant' === rejection.data.error) {
                return;
            }
            // Refresh token when a `invalid_token` error occurs.
            if ('invalid_token' === rejection.data.error) {
                return AuthService.refreshToken();
            }
            // Redirect to `/login` with the `error_reason`.
            return $window.location.href = '#/n2/login';
        });

        $rootScope.$on('$stateChangeStart', function (e, data) {
            $rootScope.$broadcast('loading', true);
        });
        $rootScope.$on('$stateChangeSuccess', function (e, data) {
            $timeout(function () {
                $rootScope.$broadcast('loading', false);
                if (data.name === 'home') {
                    $window.location.href = '#/home/dashboard';
                }
                if (data.name === 'n2.login' && AuthService.isAuth()) {
                    $window.location.href = '#/home/dashboard';
                }
            }, 200);

        });
    }]);
appMain.controller('N2Controller', ['$scope', '$rootScope',
    function ($scope, $rootScope) {
        $scope.loading = false;
        $rootScope.$on("loading", function (e, data) {
            $scope.loading = data;
        });
    }]);


