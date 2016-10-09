/**
 * Created by dhnhan on 09/10/2016.
 */
appMain
    .config(['$stateProvider', '$urlRouterProvider',
        function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise("/n2/overview");
            $stateProvider
                .state('n2',{
                    abstract: true,
                    url: '/n2',
                    templateUrl: 'js/n2.html'
                })
                .state('n2.login',{
                    url: '/login',
                    controller: 'LoginController',
                    templateUrl: 'js/login/templates/login.html'
                })
                .state('n2.overview',{
                    url: '/overview',
                    templateUrl: 'js/templates/overview.html'
                })
                .state('n2.feature',{
                    url: '/feature',
                    templateUrl: 'js/templates/feature.html'
                })
                .state('home',{
                    url: '/home',
                    controller: 'HomeController',
                    templateUrl: 'js/home/templates/home.html'
                })
        }]);