import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        String textFromKhakuna = "привет чужестранец ! мы племя людоедов xакуна . ты " +
                "находишься в попуа новая гвинея , в этой стране " +
                "нормально есть людей , у тебя есть три дня , чтобы понять " +
                "что мы тебе сказали и уйти отсюда или мы тебя сьедим ";

        // способ с помощью Function
        Function<String, List<String>> text = (a) -> Arrays.stream(a.split(" ")).sorted().distinct().collect(Collectors.toList());
        text.apply(textFromKhakuna).forEach(System.out::println);


        // обычным способом через методы ООП
        List<String> splitKhakuna = split(textFromKhakuna);
        List<String> dictionaryGenerate = dictionaryGenerate(splitKhakuna);
        for(int i = 0; i < dictionaryGenerate.size();i++) {
            System.out.println(dictionaryGenerate.get(i));
        }

    }

    public static List<String> split(String text) {
        List<String> list = new ArrayList<>();
        String[] subStr;
        String delimiter = " "; // Разделитель
        subStr = text.split(delimiter);
        for (int i = 0; i < subStr.length; i++) {
            list.add(subStr[i]);
        }
        return list;
    }

    public static List<String> dictionaryGenerate(List<String> splitText) {
        return splitText.stream()
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
