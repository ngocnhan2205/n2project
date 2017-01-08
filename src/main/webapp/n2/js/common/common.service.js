/**
 * Created by dhnhan on 09/10/2016.
 */
appMain.factory('N2Service', ['$http', '$q', '$mdDialog',
    function ($http, $q, $mdDialog) {
        return {
            /**
             *
             * @param url
             * @param method
             * @param params optional
             * @param data optional
             */
            requestRest: function (url, method, params, data, headers) {
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
            },
            showAlert: function (title, msg, ev) {
                $mdDialog.show(
                    $mdDialog.alert()
                        .parent(angular.element(document.body))
                        .clickOutsideToClose(true)
                        .title(title)
                        .textContent(msg)
                        .ariaLabel('Alert Dialog Demo')
                        .ok('Cancel')
                        .targetEvent(ev)
                );
            },
            showConfirm: function (title, msg, ev, id) {
                var con = $mdDialog.confirm()
                    .title(title)
                    .textContent(msg)
                    .ariaLabel('Confirm')
                    .targetEvent(ev)
                    .ok('Yes')
                    .cancel('No');
                return con;
            }
        }
    }]);
