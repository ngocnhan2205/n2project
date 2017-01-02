/**
 * Created by dhnhan on 21/10/2016.
 */
expenseModule.factory('ExpenseService', ['N2Service', 'METHOD', function (N2Service, METHOD) {
    return {
        url: '/n2/api/expense',
        getExpense: function (year, month) {
            var params = {
                year: year,
                month: month
            };
            return N2Service.requestRest(this.url, METHOD.GET, params);
        }
    }
}]);