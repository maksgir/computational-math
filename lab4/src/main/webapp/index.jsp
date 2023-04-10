<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Вычмат</title>
    <link href="css/styles.css" rel="stylesheet">
    <link href="css/switch.css" rel="stylesheet">
    <script src="js/funcs.js" type="text/javascript"></script>
</head>

<body onload="initialize_table()">
<div place="header">
    <span>Лабораторная работа №4</span>
    <span>Максим Гиря Р32131</span>
    <span>Вариант: 7</span>
</div>

<div class="container">
    <div level="first">
        <form>
            <label>
                <h3>Исходные данные</h3>
            </label>

            <input class="input" id="toggle" type="checkbox">

            <label class="label" for="toggle">
                <div class="left">
                    Ввести самому
                </div>

                <div class="switch">
                    <span class="slider round"></span>
                </div>

                <div class="right">
                    Загрузить файл
                </div>
            </label>

            <div id="console-input">
                <table id="" class="table-input">
                    <button class="button" type="button" onclick="clean_table()">Очистить таблицу</button>
                    <tr class="first-line">
                        <th>X</th>
                        <th>Y</th>
                    </tr>
                    <tr>
                        <td><input class="input_row" type="number" id="row-1-x" name="row-1-x"></td>
                        <td><input class="input_row" type="number" id="row-1-y" name="row-1-y"></td>
                    </tr>
                    <tr>
                        <td><input class="input_row" type="number" id="row-2-x" name="row-2-x"></td>
                        <td><input class="input_row" type="number" id="row-2-y" name="row-2-y"></td>
                    </tr>
                    <tr>
                        <td><input class="input_row" type="number" id="row-3-x" name="row-3-x"></td>
                        <td><input class="input_row" type="number" id="row-3-y" name="row-3-y"></td>
                    </tr>
                    <tr>
                        <td><input class="input_row" type="number" id="row-4-x" name="row-4-x"></td>
                        <td><input class="input_row" type="number" id="row-4-y" name="row-4-y"></td>
                    </tr>
                    <tr>
                        <td><input class="input_row" type="number" id="row-5-x" name="row-5-x"></td>
                        <td><input class="input_row" type="number" id="row-5-y" name="row-5-y"></td>
                    </tr>
                    <tr>
                        <td><input class="input_row" type="number" id="row-6-x" name="row-6-x"></td>
                        <td><input class="input_row" type="number" id="row-6-y" name="row-6-y"></td>
                    </tr>
                    <tr>
                        <td><input class="input_row" type="number" id="row-7-x" name="row-7-x"></td>
                        <td><input class="input_row" type="number" id="row-7-y" name="row-7-y"></td>
                    </tr>
                    <tr>
                        <td><input class="input_row" type="number" id="row-8-x" name="row-8-x"></td>
                        <td><input class="input_row" type="number" id="row-8-y" name="row-8-y"></td>
                    </tr>
                    <tr style="display: none">
                        <td><input class="input_row" type="number" id="row-9-x" name="row-9-x"></td>
                        <td><input class="input_row" type="number" id="row-9-y" name="row-9-y"></td>
                    </tr>
                    <tr style="display: none">
                        <td><input class="input_row" type="number" id="row-10-x" name="row-10-x"></td>
                        <td><input class="input_row" type="number" id="row-10-y" name="row-10-y"></td>
                    </tr>
                    <tr style="display: none">
                        <td><input class="input_row" type="number" id="row-11-x" name="row-11-x"></td>
                        <td><input class="input_row" type="number" id="row-11-y" name="row-11-y"></td>
                    </tr>
                    <tr style="display: none">
                        <td><input class="input_row" type="number" id="row-12-x" name="row-12-x"></td>
                        <td><input class="input_row" type="number" id="row-12-y" name="row-12-y"></td>
                    </tr>
                </table>

                <label class="label">
                    <div class="left">
                        Количество строк: <span id="row_num"></span>
                    </div>
                </label>

                <button id="inc_btn" onclick="increment()" type="button" class="row_button">+</button>
                <button id="dec_btn" onclick="decrement()" type="button" class="row_button">-</button>

            </div>
            <br><br>
            <input class="button" type="submit" value="Проверить">
        </form>
    </div>
    <div level="first">
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
    <div level="first">
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
</div>
<div place="footer">
    <span><a href="https://github.com/maksgir"><img style="border-radius: 10px" src="img/gitlogo.png"></a></span>
</div>
</body>
</html>
