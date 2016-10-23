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
}
