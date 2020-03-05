import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

/**
 * Homework for lesson 3 SBT
 *
 * @author Hin7
 * @version 1.0
 */

public class TextTest {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(Paths.get("testtext.txt"), "UTF-8");
            ArrayList<String> textLines = new ArrayList<String>();
            while (in.hasNextLine())
                textLines.add(in.nextLine());
            //подсчет различных слов в файле
            Map<String, Integer> oftenWords = new HashMap<String, Integer>();
            for (String line : textLines) {
                String[] words = line.split(" ");
                for (String word : words)
                    if (word.length() > 0)
                        oftenWords.merge(word.toLowerCase(), 1, Integer::sum);
            }
            System.out.println("Разных слов в тексе: " + oftenWords.size());
            //сортировка
            String[] sortWords = oftenWords.keySet().toArray(new String[0]);
            Arrays.sort(sortWords, Comparator.comparingInt(String::length).thenComparing(String::toString));
            for (String word : sortWords)
                System.out.println(word + " - " + oftenWords.get(word));
            //текст в обратном порядке
            for (int i = textLines.size(); i > 0; i--)
                System.out.println(textLines.get(i - 1));

            System.out.println();
            Scanner userin = new Scanner(System.in);
            System.out.println("Введите номера строк через пробел для вывода на экран от 0 до " + textLines.size());
            String sUserLines = userin.nextLine();
            Scanner numbers = new Scanner(sUserLines);
            while (numbers.hasNextInt()) {
                System.out.println(textLines.get(numbers.nextInt()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
