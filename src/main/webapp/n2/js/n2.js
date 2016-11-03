/**
 * Created by dhnhan on 23/10/2016.
 */
var $n2 = {};
$n2.removeObjInObjs = function (objs, id) {
    if ($n2.isNullArray(objs))
        return;
    for (var i = 0; i < objs.length; i++) {
        if (objs[i].id == id) {
            objs.splice(i, 1);
        }
    }
};

$n2.changeObjInObjs = function (objs, obj) {
    if ($n2.isNullArray(objs))
        return;
    for (var i = 0; i < objs.length; i++) {
        if (objs[i].id == obj.id) {
            objs[i] = obj;
        }
    }
};

$n2.isNullArray = function (objs) {
    if (objs.length == 0)
        return true;
    else
        return false;
};

$n2.formatDateToDay = function (date, format) {
    var formatDefault = 'DD/MM/YYYY';
    if (format) {
        formatDefault = format;
    }
    var d = new Date();
    if (date) {
        d = date;
    }
    return moment(d).format(formatDefault);
};

$n2.getLastDayOfMonthToday = function (date) {
    var d = new Date();
    d = date ? date : d;
    var lastDate = new Date(d.getFullYear(), d.getMonth() + 1, 0);
    return lastDate;
};

$n2.getDayOfWeek = function (date) {
    var weekday = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
    return weekday[date.getDay()];
};

$n2.getLastDate = function (date) {
    return $n2.getLastDayOfMonthToday(date).getDate();
};

$n2.getDateNow = function (date) {
    var d = date ? date : new Date();
    return d.getDate();
};