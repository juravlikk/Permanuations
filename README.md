Permanuations
=============

Task 3

Задание
Для старта космического корабля необходимо включить все N тумблеров на приборной панели. При этом каждая последовательность включения тумблеров в принципе может быть использована (некоторые из них приведут к успешному старту корабля, при других корректно настроенная система должна выдать собщение об ошибке). Таким образом, для полного тестирования надо в идеале проверить все N! вариантов (тестов).
Однако, до запуска осталось уже не так много времени, и м ожно провести только K тестов, где K ≪ N!
Какие именно тесты следует провести?

Надо придумать алгоритм, который по заданным числам N и выдает тестовый набор - список из K перестановок множества 1, 2, 3 , . . . , N. Оцениваться результат будет как степень критичности бага, который данный набор тестов может пропустить (более конкретный критерий участнику не сообщается).
Для кандидата на позицию разработчика надо представить описание алгоритма и код на языке java, реализующий этот алгоритм. На вход программе будет подаваться текстовый файл input.txt (находится в каталоге с исполняемым файлом). В первой строчке написано число N, во второй - число K. В результате программа должна сгенерить набор из не более, чем K строк, в каждой из которых записана тестовая последовательность через пробелы (должен быть создан файл output.txt в том же каталоге).