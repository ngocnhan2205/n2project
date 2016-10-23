/**
 * Created by dhnhan on 21/10/2016.
 */
expenseModule.factory('ExpenseService', ['N2Service', function (N2Service) {
    return {
        url: '/n2/api/expense',
        saveExpense: function (data) {
            return N2Service.requestRest(this.url, 'POST', null, data);
        },
        getExpense: function (setting) {
            var params = {
                gran: setting.gran.value,
                date: setting.date
            }
            return N2Service.requestRest(this.url, 'GET', params);
        },
        deleteExpense: function(id) {
            return N2Service.requestRest(this.url + '/' + id, 'DELETE');
        }
    }
}]);