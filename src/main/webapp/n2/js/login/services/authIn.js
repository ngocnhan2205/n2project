/**
 * Created by dhnhan on 10/10/2016.
 */
loginModule.factory('AuthIn', ['$cookieStore', '$q', '$rootScope', function ($cookieStore, $q, $rootScope) {
    return {
        request: function (config) {
            config.headers = config.headers || {};
            var objToken = $cookieStore.get('n2Token');
            if (objToken) {
                config.headers.Authorization = objToken.token_type + ' ' + objToken.access_token;
            }
            return config;
        },
        responseError: function (rejection) {
            if (rejection.status == 401) {
                $rootScope.$emit("n2:error", rejection);
                $cookieStore.remove('n2Token');
                return $q.reject(rejection);
            } else {
                console.log('Failed status code : ' + rejection.status);
            }
        }
    }
}])