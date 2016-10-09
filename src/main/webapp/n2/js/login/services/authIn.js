/**
 * Created by dhnhan on 10/10/2016.
 */
loginModule.factory('AuthIn',['$cookieStore','$q', '$rootScope', function($cookieStore, $q, $rootScope){
    return {
        request: function(config){
            config.headers = config.headers || {};
            var objToken = $cookieStore.get('n2Token');
            if (objToken){
                config.headers.Authorization = objToken.token_type + ' ' + objToken.access_token;
            }
            return config;
        },
        responseError: function(rejection){
            $rootScope.$emit("n2:error", rejection);
            return $q.reject(rejection);
        }
    }
}])