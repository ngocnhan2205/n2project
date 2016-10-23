/**
 * Created by dhnhan on 23/10/2016.
 */
var $n2 = {};
$n2.removeElementInArray = function (objs, id){
    if (objs.length == 0)
        return;
    for(var i = 0; i < objs.length; i++) {
        if (objs[i].id == id) {
            objs.splice(i, 1);
        }
    }
};
