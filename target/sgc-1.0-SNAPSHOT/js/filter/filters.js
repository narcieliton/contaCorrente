sgcApp.filter('rangeByMinAndMax', [function() {

    return function(array, min, max ) {

        var result = [];
        for (var i = min; i < max; i++) {
            result.push(array[i]);
        }
        return result;
    };
}]);


sgcApp.filter('getCpfOrCnpj',  ["$filter", function ($filter) {
    return function(cpfCnpj) {
        if (cpfCnpj){
            if(cpfCnpj.length === 11){
                return $filter('brCpf')(cpfCnpj);
            } else {
                return $filter('brCnpj')(cpfCnpj);
            }
        }
    }
}]);


