<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Вычмат</title>
    <link href="css/styles.css" rel="stylesheet">
</head>

<body>
<div place="header">
    <span>Лабораторная работа №4</span>
    <span>Гиря Максим Р32131</span>
    <span >Вариант: 7</span>
</div>

<div class="container">
    <div >
        <h3>Заданная область</h3>
        <svg width="300" height="300">
            <!--Координатные оси-->
            <line x1="0" x2="300" y1="150" y2="150"></line>
            <line x1="150" x2="150" y1="0" y2="300"></line>
            <!--Стрелочки-->
            <polygon points="150,0 145,15 155,15" stroke="black" style="fill:black"></polygon>
            <polygon points="300,150 285,145 285,155" stroke="black" style="fill:black"></polygon>
            <!--Прямоугольник в первой четверти-->
            <polygon points="150,150 250,150 250,200 150,200"></polygon>
            <!--Четверть круга в третьей четверти-->
            <path d="M150,200 A50,50 90 0,1 100,150 L 150,150 Z"></path>
            <!--Треугольник в четвертой четверти-->
            <polygon points="150,150 100,150 150,100"></polygon>
            <!-- Подписи к осям -->
            <text x="285" y="135">X</text>
            <text x="160" y="15">Y</text>
            <!-- Метки для значений R на оси X -->
            <line x1="50" x2="50" y1="140" y2="160"></line>
            <line x1="100" x2="100" y1="140" y2="160"></line>
            <line x1="200" x2="200" y1="140" y2="160"></line>
            <line x1="250" x2="250" y1="140" y2="160"></line>
            <!-- Метки для значений R на оси Y -->
            <line x1="140" x2="160" y1="50" y2="50"></line>
            <line x1="140" x2="160" y1="100" y2="100"></line>
            <line x1="140" x2="160" y1="200" y2="200"></line>
            <line x1="140" x2="160" y1="250" y2="250"></line>
            <!-- Значения R на оси X -->
            <text x="40" y="130">-R</text>
            <text x="85" y="130">-R/2</text>
            <text x="190" y="130">R/2</text>
            <text x="245" y="130">R</text>
            <!-- Значения R на оси Y -->
            <text x="170" y="52.5">R</text>
            <text x="170" y="102.5">R/2</text>
            <text x="170" y="202.5">-R/2</text>
            <text x="170" y="252.5">-R</text>
        </svg>
    </div>
    <div >
        <form onsubmit="saveData();return false;">
            <label><h3>Значение Х</h3><select class="choose" id="x_val">
                <option>-4</option>
                <option>-3</option>
                <option>-2</option>
                <option>-1</option>
                <option>0</option>
                <option>1</option>
                <option>2</option>
                <option>3</option>
                <option>4</option>
            </select></label><br><br>
            <label><h3>Значение Y</h3><input id="y_val" class="choose" type="number" min="-3" max="3"/></label><br><br>
            <label><h3>Значение R</h3><select id="r_val" class="choose">
                <option>1</option>
                <option>1.5</option>
                <option>2</option>
                <option>2.5</option>
                <option>3</option>
            </select></label><br><br><br>
            <input class="button" type="submit" value="Проверить">
        </form>
    </div>
    <div >
        <table id="result_table">
            <button class="button" type="button" onclick="clean_table()">Очистить таблицу</button>
            <tr class="first-line">
                <th>X</th>
                <th>Y</th>
                <th>R</th>
                <th>Текущее время</th>
                <th>Время выполнения</th>
                <th>Результат</th>
            </tr>
            <tbody id="table_body">

            </tbody>
        </table>
    </div>
</div>
<div place="footer">
    <span><a href="https://github.com/maksgir"><img style="border-radius: 10px" src="img/gitlogo.png"></a></span>
</div>
</body>
</html>
