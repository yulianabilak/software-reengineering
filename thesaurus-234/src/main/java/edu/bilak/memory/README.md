## Кроки, зроблені для оптимізації споживання пам'яті

1. Замість того, щоб зчитувати одразу весь файл в один рядок, виконується обробка по одному рядку за допомогою `BufferedReader`.
```java
// Оригінальний код
String text = new String(Files.readAllBytes(filePath));

// Змінений код
try (BufferedReader reader = Files.newBufferedReader(filePath)) {
    String line;
    while ((line = reader.readLine()) != null) {
        TextAnalyzer.processLine(line, wordFrequencies);
    }
}
```
2. Замінено очищення тексту на основі регулярних виразів посимвольною обробкою, оскільки операції з регулярними виразами
потребують багато пам'яті (методи `replaceAll` і `split` створюють багато проміжних об'єктів).
```java
// Оригінальний код з регулярними виразами
private static String[] getAllWords(String text) {
    if (text == null || text.trim().isEmpty()) {
        return new String[0];
    }
    text = text.replaceAll(NON_ALPHABETIC_REGEX," ").toLowerCase(Locale.ROOT);
    return text.split(SPACE_REGEX);
}

// Змінений код
public static void processLine(String line, Map<String, Integer> wordFrequencyMap) {
    StringBuilder wordBuilder = new StringBuilder();

    for (char c : line.toCharArray()) {
        if (Character.isAlphabetic(c)) {
            wordBuilder.append(Character.toLowerCase(c));
        } else {
            // If we encounter a non-alphabetic character and have a word, update the map
            if (!wordBuilder.isEmpty()) {
                String word = wordBuilder.toString();
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
                wordBuilder.setLength(0);  // Reset the builder for the next word
            }
        }
    }

    // Handle the last word if the line ends with a word
    if (!wordBuilder.isEmpty()) {
        String word = wordBuilder.toString();
        wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
    }
}
```
3. Введено `HashMap` для динамічного зберігання унікальних слів та їх частот для ефективного використання пам'яті та
швидкого пошуку. Завдяки цьому було вилучено великі проміжні структури даних (`textWords`, `uniqueWords`, 
`uniqueWordsAsString`) і уникнуто багаторазових проходів по даних.
```java
// Оригінальний код
String[] textWords = getAllWords(text);
String[] uniqueWords = getUniqueWords(textWords);
...
String uniqueWordsAsString = "";
return uniqueWordsAsString.split(" ");

// Змінений код
Map<String, Integer> wordFrequencies = new HashMap<>();

// Оновлення map в processLine
wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
```
4. Додано клас `Word` для зберігання слова та його частоти для кращої читабельності і модульності коду.
```java
public class Word {
    private final String word;
    private final int frequency;
    // Constructor, getters, and toString()
}
```
5. Але найголовніше це було зроблено для спрощення складного сортування слів за їх частотами для отримання кінцевого результату.
Оригінальний код зберігав інформацію про частоту в рядки і використовував складні компаратори, що передбачали багаторазові
маніпуляції з рядками (вилучення числових частин з рядків). Крім того, що такий підхід займає багато пам'яті, досить 
легко помилитися при його реалізації.
```java
// Оригінальний код
Arrays.sort(uniqueWords, Comparator.comparing(str -> {
            String numericPart = str.replaceAll(NON_NUMERIC_REGEX, "");
            return numericPart.isEmpty() ? 0 : Integer.parseInt(numericPart);
            }, Comparator.reverseOrder()));

// Створення списку об'єктів Word
List<Word> words = new ArrayList<>();
for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
    words.add(new Word(entry.getKey(), entry.getValue()));
}

// Спрощене сортування
words.sort((w1, w2) -> Integer.compare(w2.getFrequency(), w1.getFrequency()));
```
6. Використано `StringBuilder` замість звичайного `String` при конкатенації рядків, що мінімізує створення нових тимчасових об'єктів.
```java
// Оригінальний код
uniqueWordsAsString += textWord + " ";

// Змінений код
StringBuilder wordBuilder = new StringBuilder();
wordBuilder.append(Character.toLowerCase(c));
```