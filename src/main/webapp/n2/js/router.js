/**
 * Created by dhnhan on 09/10/2016.
 */
appMain
    .config(['$stateProvider', '$urlRouterProvider',
        function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise("/n2/login");
            $stateProvider
                .state('n2', {
                    abstract: true,
                    url: '/n2',
                    templateUrl: 'static/js/n2.html'
                })
                .state('n2.login', {
                    url: '/login',
                    controller: 'LoginController',
                    templateUrl: 'static/js/login/templates/login.html'
                })
                .state('n2.overview', {
                    url: '/overview',
                    templateUrl: 'static/js/templates/overview.html'
                })
                .state('n2.feature', {
                    url: '/feature',
                    templateUrl: 'static/js/templates/feature.html'
                })
                .state('home', {
                    url: '/home',
                    controller: 'HomeController',
                    templateUrl: 'static/js/home/templates/home.html',
                    ncyBreadcrumb: {
                        label: 'Home'
                    }
                })
                .state('home.dashboard', {
                    url: '/dashboard',
                    controller: 'DashboardController',
                    templateUrl: 'static/js/dashboard/templates/dashboard.html',
                    ncyBreadcrumb: {
                        label: 'Dashboard'
                    }
                })
                .state('home.expense', {
                    url: '/expense',
                    controller: 'ExpenseController',
                    templateUrl: 'static/js/expense/templates/expense.html',
                    ncyBreadcrumb: {
                        label: 'Expense'
                    }
                })
        }]);