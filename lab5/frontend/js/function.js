function getNewtonFunc(newton_coef) {
    return x => {
        const n = newton_coef.length, h = points[1].x - points[0].x;
        let result = points[0].y;

        for (let i = 0; i < n; i++) {
            let product = 1;
            for (let j = 0; j <= i; j++) {
                product *= (x - points[j].x);
            }
            result += newton_coef[i] * product / (fact(i + 1) * Math.pow(h, i + 1));
        }

        return result;
    }
}

function getLagrangeFunc(lagrange_coef) {
    return x => {
        const n = lagrange_coef.length;
        let result = 0;
        for (let i = 0; i < n; i++) {
            let product = 1;
            for (let j = 0; j < n; j++) {
                if (i !== j) {
                    product *= (x - points[j].x);
                }
            }
            result += lagrange_coef[i] * product;
        }
        return result;
    }
}

function fact(x) {
    if (x === 0) {
        return 1;
    }
    return x * fact(x - 1);
}