/**
 * Created by dhnhan on 09/10/2016.
 */
appMain
    .config(['$stateProvider', '$urlRouterProvider',
        function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise("/login");
            $stateProvider
                .state('home', {
                    url: '/home',
                    templateUrl: 'js/home/templates/home.html',
                    controller : 'HomeController'
                })
                .state('login', {
                    url: '/login',
                    templateUrl: 'js/login/templates/login.html',
                    controller: 'LoginController'
                })
        }]);