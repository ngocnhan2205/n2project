/**
 * Created by dhnhan on 08/10/2016.
 */
var appMain = angular.module('N2App', ['ui.router', 'ngMaterial', 'angular-oauth2', 'Login', 'HomeModule']);

appMain.config(['OAuthProvider', function (OAuthProvider) {
    OAuthProvider.configure({
        baseUrl: 'http://localhost:8080',
        clientId: 'my-trusted-client',
        clientSecret: 'secret'
    });
}]);

appMain.run(['$rootScope', '$window', 'OAuth',
    function ($rootScope, $window, OAuth) {
        $rootScope.$on('oauth:error', function(event, rejection) {
            // Ignore `invalid_grant` error - should be catched on `LoginController`.
            if ('invalid_grant' === rejection.data.error) {
                return;
            }
            // Refresh token when a `invalid_token` error occurs.
            if ('invalid_token' === rejection.data.error) {
                return OAuth.getRefreshToken();
            }
            // Redirect to `/login` with the `error_reason`.
            return $window.location.href = '/';
        });
    }]);