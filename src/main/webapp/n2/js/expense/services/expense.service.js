/**
 * Created by dhnhan on 21/10/2016.
 */
expenseModule.factory('ExpenseService', ['N2Service', function (N2Service) {
    return {
        saveExpense: function (data) {
            var url = '/n2/api/expense';
            return N2Service.requestRest(url, 'POST', null, data);
        }
    }
}]);