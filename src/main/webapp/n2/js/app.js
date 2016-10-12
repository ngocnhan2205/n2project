/**
 * Created by dhnhan on 08/10/2016.
 */
var moduleLib = ['ui.router',
                'ngMaterial',
                'ngAnimate',
                'ngMessages',
                'ngProgress',
                'ngCookies'];
var moduleApp = ['Login', 'HomeModule'];
var app = moduleApp.concat(moduleLib);
var appMain = angular.module('N2App', app);

appMain.config(['$mdIconProvider','$httpProvider',
    function ($mdIconProvider, $httpProvider) {
        $httpProvider.interceptors.push('AuthIn');
    }]);

appMain.run(['$rootScope', '$window', 'ngProgressFactory','$timeout','AuthService',
    function ($rootScope, $window, ngProgressFactory, $timeout, AuthService) {
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

        $rootScope.$on('$stateChangeStart', function () {
            $rootScope.progressbar = ngProgressFactory.createInstance();
            $rootScope.progressbar.start();
            $rootScope.progressbar.setColor('red');
        });
        $rootScope.$on('$stateChangeSuccess', function () {
            $timeout(function () {
                $rootScope.progressbar.complete();
            }, 500);
        });
    }]);
appMain.controller('N2Controller', ['$scope','AuthService',
    function($scope, AuthService){

    }]);