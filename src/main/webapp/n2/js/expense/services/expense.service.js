/**
 * Created by dhnhan on 21/10/2016.
 */
expenseModule.factory('ExpenseService', ['N2Service', 'METHOD', function (N2Service, METHOD) {
    return {
        urlEx: '/n2/api/expense',
        urlSpend: '/n2/api/spend',
        getExpense: function (year, month) {
            var params = {
                year: year,
                month: month
            };
            return N2Service.requestRest(this.urlEx, METHOD.GET, params);
        },
        saveExpense: function (name, date) {
            var params = {
                name: name,
                date: date
            };
            return N2Service.requestRest(this.urlSpend, METHOD.POST, params);
        },
        getExpenseOfSpend: function (date) {
            var params = {
                date: date
            };
            return N2Service.requestRest(this.urlSpend, METHOD.GET, params);
        },
        updateSpendCategory: function (id, name) {
            var params = {
                name: name
            };
            return N2Service.requestRest(this.urlSpend + '/' + id, METHOD.PUT, params);
        },
        deleteSpendCategory: function (id) {
            return N2Service.requestRest(this.urlSpend + '/' + id, METHOD.DELETE);
        }
    }
}]);