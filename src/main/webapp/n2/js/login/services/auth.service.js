/**
 * Created by dhnhan on 09/10/2016.
 */
loginModule.factory('AuthService',['$http', '$q', '$cookieStore',
    function($http, $q, $cookieStore){
        return {
            isAuthencation: false,
            auth: function(user){
                var defer = $q.defer();
                var params = {
                    grant_type: 'password',
                    username: user.username,
                    password: user.password
                };
                var url = '/oauth/token';
                var header = {
                    Accept : 'application/json',
                    Authorization: 'Basic bXktdHJ1c3RlZC1jbGllbnQ6c2VjcmV0'
                };
                $http({
                    method: 'POST',
                    url: url,
                    params: params,
                    headers: header
                }).then(function successCallback(res) {
                    $cookieStore.put('n2Token', res.data);
                    this.isAuthencation = true;
                    defer.resolve(res);
                }, function errorCallback(res){
                    $cookieStore.remove('n2Token');
                    this.isAuthencation = false;
                    defer.reject();
                })
                return defer.promise;
            }
        }
    }]);