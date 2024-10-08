# Поиск слов по набору букв или маске

## Описание проекта

Этот проект представляет собой консольное приложение на Kotlin, которое помогает пользователю решать сканворды и кроссворды (поиск по маске), а также находить слова в приложениях вроде "Словли" и "5 букв" (поиск по множеству букв). Пользователь может искать слова, вводя либо набор букв, либо маску с неизвестными буквами, замененными символом "*".

Программа также позволяет исключать слова, содержащие определенные буквы, после выполнения основного поиска.

## Функциональность

### 1. Поиск по набору букв

Пользователь вводит множество букв, и программа находит все слова, которые можно составить из этого набора. Все введённые буквы должны присутствовать в слове.

### 2. Поиск по маске

Пользователь указывает маску, где известные буквы задаются явно, а неизвестные заменяются символом *. Например, запрос а**уз будет искать слова длиной 5 букв, которые начинаются на "а", заканчиваются на "уз" и имеют неизвестные буквы на второй и третьей позициях.

### 3. Исключение букв

После основного поиска пользователь может указать буквы, которые необходимо исключить из результатов. Все слова, содержащие хотя бы одну из указанных букв, будут удалены из результатов.

### 4. Обработка ошибок

При некорректном вводе данных, например, неверной длине маски или нечисловом значении для длины слова, программа попросит попробовать снова.

##  Что дальше?

В дальнейшем на основе этой консольной утилиты я планирую разработать десктопое и мобильное приложения с использованием Jetpack Compose. 
>>>>>>> eda7120 (добавил РИДМИ)
