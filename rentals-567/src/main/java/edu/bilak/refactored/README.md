## Рефакторинг

1. Винесли логіку розрахунку вартості оренди (`thisAmount`) в окремий метод `getThisAmount`.
2. Перейменували змінну `Rental each` на `Rental rental` в методі `statement()` і `getThisAmount()`.
3. Перейменували метод `getThisAmount` на `getRentalCost`.
4. Забрали проміжну змінну `thisAmount` в методі `statement`, замість неї безпосередньо викликають `getRentalCost()`.
5. Перенесли `getRentalCost()` до класу `Rental`.
6. Перейменували змінну `thisAmount` на `rentalCost` у `getRentalCost()`.
7. Винесли логіку розрахунку бонусів за часту оренду в окремий метод `getFrequentRenterPoints()`.
8. Перенесли `getFrequentRenterPoints()` до класу `Rental`.
9. Винесли розрахунок `frequentRenterPoints` в окремий метод `getTotalFrequentRenterPoints()`.
10. Замінили цикл в `getFrequentRenterPoints()` на stream.
11. Забрали проміжну змінну `frequentRenterPoints` в методі `statement`, замість неї безпосередньо викликають `getTotalFrequentRenterPoints()`.
12. Розділили обчислення загальної вартості оренди та вартості для окремих оренд на два окремі цикли.
13. Винесли розрахунок загальної вартості оренди в окремий метод `getTotalRentalCost()`.
14. Замінили цикл в `getTotalRentalCost` на stream.
15. Забрали проміжну змінну `totalAmount` в методі statement, замість неї безпосередньо викликають `getTotalRentalCost()`.