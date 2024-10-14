## Кроки, зроблені для оптимізації швидкості виконання

1. Замість того, щоб зчитувати одразу весь файл в один рядок, виконується обробка в `Stream` за допомогою `Files.lines()`.
Потоки надають зручний інтерфейс для функціональної обробки даних, включаючи фільтрацію, перетворення та агрегування, що спрощує код та підвищує його продуктивність.
```java
// Оригінальний код
String text = new String(Files.readAllBytes(filePath));

// Змінений код
try (Stream<String> lines = Files.lines(filePath)) {
    mostFrequentWords = TextAnalyzer.getMostFrequentWords(lines, topWordsCount);
}
```
2. Реалізовано паралельну обробку за допомогою `.parallel()` і `Collectors.groupingByConcurrent()`.
```java
Map<String, Long> wordFrequencies = lines
        .parallel()
        .filter(Objects::nonNull)
        ...
        .collect(Collectors.groupingByConcurrent(Function.identity(), Collectors.counting()));
```
3. Видалено методи `getAllWords()` і `getUniqueWords()` і вкладені цикли з ручним підрахунком.
4. Замінено повторювані регекс-операції на попередньо скомпільований шаблон і використано `splitAsStream` для розбиття рядків на слова у потоці.
```java
// Оригінальний код
// getAllWords
text = text.replaceAll(NON_ALPHABETIC_REGEX," ").toLowerCase(Locale.ROOT);
return text.split(SPACE_REGEX);

// getUniqueWords
wordRegex = WORD_BOUNDARY_BEFORE + Pattern.quote(textWord) + WORD_BOUNDARY_AFTER;
if (!uniqueWordsAsString.matches(wordRegex)) {
    uniqueWordsAsString += textWord + " ";
}


// sort
String numericPart = str.replaceAll(NON_NUMERIC_REGEX, "");

// Змінений код
private static final Pattern NON_WORD_REGEX = Pattern.compile("\\W+");

// В стрімі
.flatMap(NON_WORD_REGEX::splitAsStream)
```
5. Замінено складні механізми сортування, що передбачають маніпуляції з рядками, на просте та більш ефективне сортування
частот слів за допомогою `Comparator.comparingInt()`.
```java
// Оригінальний код
Arrays.sort(uniqueWords, Comparator.comparing(str -> {
            String numericPart = str.replaceAll(NON_NUMERIC_REGEX, "");
            return numericPart.isEmpty() ? 0 : Integer.parseInt(numericPart);
            }, Comparator.reverseOrder()));

// Змінений код
 ...
 .sorted(Comparator.comparingInt(Word::getFrequency).reversed())
```
6. Додано клас `Word` для зберігання слова та його частоти для кращої читабельності і модульності коду.
```java
public class Word {
    private final String word;
    private final int frequency;
    // Constructor, getters, and toString()
}
```