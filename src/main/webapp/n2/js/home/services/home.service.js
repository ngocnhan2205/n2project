/**
 * Created by dhnhan on 13/10/2016.
 */
homeModule
    .factory('HomeService', ['N2Service', function (N2Service) {
        return {
            getMenu: function () {
                var url = '/n2/api/menu';
                return N2Service.requestRest(url, 'GET');
            },
            getUser: function () {
                var url = '/n2/api/user';
                return N2Service.requestRest(url, 'GET');
            }
        }
    }]);