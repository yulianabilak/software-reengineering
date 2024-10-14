## Зауваження

1. Прибрати зайві імпорти.
2. Прибрати коментарі, які не стосуються логіки програми.
3. Прибрати метод `cleanText`, який не використовується.
4. Проставити пробіли і порожні рядки відповідно до Java Code Convention для читабельності.
5. Класи, поля, методи, змінні та параметри мають бути названі так, щоб чітко відображати їх призначення і відповідати
   Java Code Convention.
6. Винести шлях до текстового файлу в окрему змінну.
7. Винести число найбільш використовуваних слів (30) в окрему змінну.
8. Використати цикл for-each для читабельності.
9. Використати регулярний вираз для перевірки чи міститься слово в `uniqueWordsAsString` замість `contains`, щоб точно
   перевірити, що присутнє ціле слово, а не частина іншого слова.
10. Прибрати зайвий цикл, який додає до слова частоту його появи в тексті, замість цього зробивши це одразу в першому
    циклі після її підрахунку.
11. Сортувати слова за їх частотою використання одразу в зворотному порядку для читабельності.
12. Використати `System.nanotime()` для вимірювання часу виконання.
13. Створити окремий клас `TextAnalyzer` для роботи з текстом.
14. Розділити логіку очищення тексту, пошуку унікальних слів і підрахунку частот слів на окремі методи для спрощення.
15. Винести регулярні вирази в константи.
16. Додати загальні перевірки вхідних даних на коректність і null-значення.

## Аналіз продуктивності коду з використанням профайлера

Час виконання оригінального коду: 2708 мс  
Час виконання коду після рефакторингу: 6821 мс  
Використання пам'яті оригінального коду: 217.64 MB  
Використання пам'яті коду після рефакторингу: 388.88 MB