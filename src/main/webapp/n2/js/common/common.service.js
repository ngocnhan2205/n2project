/**
 * Created by dhnhan on 09/10/2016.
 */
appMain.factory('N2Service',['$http','$q', function($http, $q){
    return {
        /**
         *
         * @param url
         * @param method
         * @param params optional
         * @param data optional
         */
        requestRest: function(url, method, params, data, headers){
            var defer = $q.defer();
            $http({
                method: method,
                url: url,
                params: params,
                data: data,
                headers: headers
            }).then(function successCallback(res) {
                defer.resolve(res);
            }, function errorCallback() {
                console.log('Request failed!');
                defer.reject();
            });
            return defer.promise;
        }
    }
}]);
