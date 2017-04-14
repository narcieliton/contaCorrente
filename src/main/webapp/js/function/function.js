// VERIFICA SE A DATA INICIAL E INFERIOR OU IGUAL A DATA FINAL
function isPeriodoValido(dataCertificado, dataHoje) {
    if (validaData(dataCertificado) && validaData(dataHoje)) {
        try {
            dataCertificado = angular.copy(converterStringEmDate(dataCertificado));
            dataHoje = angular.copy(converterStringEmDate(dataHoje));
        } catch (err) {
            dataCertificado = angular.copy(dataCertificado);
            dataHoje = angular.copy(dataHoje);
        }
        return dataHoje.getTime() >= dataCertificado.getTime();
    } else
        return true;
}

//VERIFICA SE A DATA INICIAL E INFERIOR A DATA FINAL
function isPeriodoInferior (dataInicial, dataFinal) {
    var dataInicio;
    var dataFim;
    if (validaData(dataInicial) && validaData(dataFinal)) {
        try {
            dataInicio = angular.copy(converterStringEmDate(dataInicial));
            dataFim = angular.copy(converterStringEmDate(dataFinal));
        } catch (err) {
            dataInicio = angular.copy(dataInicial);
            dataFim = angular.copy(dataFinal);
        }
        return dataFim.getTime() > dataInicio.getTime();
    } else
        return true;
}

// serve para converter strings com o formato > mm/yyyy ou dd/mm/yyyy ou dd-mm-yyyy em date
function converterStringEmDate(str) {
    if (str) {
        if (str instanceof Date) {
            return str;
        } else {
            var day = null;
            var month = null;
            var year = null;

            if (str.length == 7) {
                day = "01";
            }
            var dataArray = str.split('/').reverse();
            if (dataArray.length == 1) {
                dataArray = str.split('-').reverse();
            }
            if (!day) {
                day = dataArray[2];
                month = dataArray[1] - 1;
                year = dataArray[0];
            } else {
                month = dataArray[1] - 1;
                year = dataArray[0];
            }
            return new Date(year, month, day);
        }
    }
}


var validaData = function(data) {
    if (Object.prototype.toString.call(data) !== "[object Date]") {
        if (!data || !data.match(/[0-9]/)
            || !data.match(/[0-9]{2}\/[0-9]{2}\/[0-9]{4}/))
            return false;

        var dataArray = data.split('/');

        var day = dataArray[0], month = dataArray[1], year = dataArray[2];

        if (month < 1 || month > 12) {
            return false;
        }

        if (day < 1 || day > 31) {
            return false;
        }

        if ((month === 4 || month === 6 || month === 9 || month === 11)
            && day === 31) {
            return false;
        }

        if (month == 2) {
            var isleap = false;
            if ((!(year % 4) && year % 100) || !(year % 400)) {
                isleap = true;
            }

            if (isleap && day > 29) {
                return false;
            }
        }

        if (year.length !== 4) {
            return false;
        }

        if (year < 1900 || year > 2099) {
            return false;
        }

        return true;
    }

    return !isNaN(data.getTime());
};

var goFocus = function (target) {
    document.getElementById(target).focus();
};
