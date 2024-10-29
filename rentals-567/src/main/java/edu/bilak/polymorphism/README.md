## Рефакторинг

1. Перенесли методи `getRentalCost` і `getFrequentRenterPoints` з класу `Rental` до класу `Movie`.
2. Створили абстрактний клас `Price` для інкапсуляції логіки ціноутворення.
3. Створили класи `RegularPrice`, `NewReleasePrice`, `ChildrenPrice`, які розширюють клас `Price`. Кожен підклас має конкретну реалізацію `getRentalCost` і, де необхідно, перевизначає `getFrequentRenterPoints`.
4. Замінили enum `MovieType` на поле `Price` в класі `Movie` для представлення цінової стратегії.
5. Оновили класи `Movie` і `Rental` для делегування обчислення вартості та бонусних балів об'єкту `Price`.