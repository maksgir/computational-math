function getFunction(data) {
    switch (data.best) {
        case "linear":
            return x => data.linear[0] * x + data.linear[1];
        case "square":
            return x => data.square[0] + data.square[1] * x + data.square[2] * Math.pow(x, 2);
        case "cubic":
            return x => data.cubic[0] + data.cubic[1] * x + data.cubic[2] * Math.pow(x, 2) + data.cubic[3] * Math.pow(x, 3);
        case "exponential":
            return x => data.exponential[0] * Math.exp(data.exponential[1] * x);
        case "logarithmic":
            return x => data.logarithmic[0] * Math.log(x) + data.logarithmic[1];
        case "power":
            return x => data.power[0] * Math.pow(x, data.power[1])
    }
}

function getFunctionTextRepresentation(data) {
    switch (data.best) {
        case "linear":
            return data.linear[0].toFixed(2) + " + " + data.linear[1].toFixed(2) + " * x";
        case "square":
            return data.square[0].toFixed(2) + " + " + data.square[1].toFixed(2) + " * x + " + data.square[2].toFixed(2) + " * x ^ 2";
        case "cubic":
            return data.cubic[0].toFixed(2) + " + " + data.cubic[1].toFixed(2) + " * x + " + data.cubic[2].toFixed(2) + " * x ^ 2 + " + data.cubic[3].toFixed(2) + " * x ^ 3";
        case "exponential":
            return data.exponential[0].toFixed(2) + " * e ^ (x * " + data.exponential[1].toFixed(2) + ")";
        case "logarithmic":
            return data.logarithmic[0].toFixed(2) + " * ln(x) + " + data.logarithmic[1].toFixed(2);
        case "power":
            return data.power[0].toFixed(2) + " * x ^ " + data.power[1].toFixed(2);
    }
}

function getTypeTextRepresentation(data) {
    switch (data.best) {
        case "linear":
            return "линейная";
        case "square":
            return "квадратичная";
        case "cubic":
            return "кубическая";
        case "exponential":
            return "экспоненциальная";
        case "logarithmic":
            return "логарифмическая";
        case "power":
            return "степенная"
    }
}