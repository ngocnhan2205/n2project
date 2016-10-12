/**
 * Created by dhnhan on 09/10/2016.
 */
loginModule.factory('AuthService', ['$http', '$q', '$cookieStore','$rootScope',
    function ($http, $q, $cookieStore, $rootScope) {
        return {
            auth: function (user) {
                var defer = $q.defer();
                var params = {
                    grant_type: 'password',
                    username: user.username,
                    password: user.password
                };
                var url = '/oauth/token';
                var header = {
                    Accept: 'application/json',
                    Authorization: 'Basic bXktdHJ1c3RlZC1jbGllbnQ6c2VjcmV0'
                };
                $http({
                    method: 'POST',
                    url: url,
                    params: params,
                    headers: header
                }).then(function successCallback(res) {
                    $cookieStore.put('n2Token', res.data);
                    defer.resolve(res);
                }, function errorCallback(res) {
                    $cookieStore.remove('n2Token');
                    defer.reject();
                });
                return defer.promise;
            },
            refreshToken: function () {
                var defer = $q.defer();
                var token = $cookieStore.get('n2Token');
                $cookieStore.remove('n2Token');
                var header = {
                    Accept: 'application/json',
                    Authorization: 'Basic bXktdHJ1c3RlZC1jbGllbnQ6c2VjcmV0'
                };
                $http({
                    method: 'POST',
                    url: '/oauth/token',
                    params: {
                        'grant_type': 'refresh_token',
                        'refresh_token': token.refresh_token
                    },
                    headers: header
                }).then(function successCallback(res) {
                    $cookieStore.remove('n2Token');
                    $cookieStore.put('n2Token', res.data);
                    defer.resolve(res);
                }, function errorCallback() {
                    defer.reject();
                });
                return defer.promise;
            },
            isAuth: function(){
                var token = $cookieStore.get('n2Token');
                if (token)
                    return true;
                else
                    return false;
            },
            logout: function () {

            }
        }
    }]);