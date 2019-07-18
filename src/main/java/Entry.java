import com.google.gson.Gson;
import entities.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by anmi0217 on 18/7/2019.
 */
public class Entry {

    private static final String FILE_PATH = "word";
    private static final String FILE_PATH_WORDS = "words";

    public static void main(String[] args) {


        //1. получаем строку с json по 1 объекту Word

        Gson gson = new Gson();
        String json = gson.toJson(getTestWord());

        // result : {"original":"ПРЕА́МБУЛА","wrongs":["ПРИАМБУЛА","ПРИОМБУЛА","ПРААМБУЛА"]}
        //1.2 забираем объект обратно

        Word word = gson.fromJson(json,Word.class);


        //2. Получаем строку из Набора слов

        List<Word> words = new ArrayList<>();
        words.add(getTestWord());
        words.add(getTestWord());
        words.add(getTestWord());
        json = gson.toJson(words);
        // result : [{"original":"ПРЕА́МБУЛА","wrongs":["ПРИАМБУЛА","ПРИОМБУЛА","ПРААМБУЛА"]},
        // {"original":"ПРЕА́МБУЛА","wrongs":["ПРИАМБУЛА","ПРИОМБУЛА","ПРААМБУЛА"]},
        // {"original":"ПРЕА́МБУЛА","wrongs":["ПРИАМБУЛА","ПРИОМБУЛА","ПРААМБУЛА"]}]

        //2.2 Забираем обратно
        List<Word> wordList = gson.fromJson(json,List.class);

        //3. юзаем утилиту для сохранения в файл
        word = getTestWord();
        word.setOriginal("ПРЕАМБУЛА");
        wordList.add(word);
        //3.1 сохранили
        GsonUtil.save(wordList,FILE_PATH);
        //3.2 загрузили
        wordList = GsonUtil.load(FILE_PATH,List.class);
        //проверили
        System.out.println(wordList);
        // result : [{original=ПРЕА́МБУЛА, wrongs=[ПРИАМБУЛА, ПРИОМБУЛА, ПРААМБУЛА]},
        // {original=ПРЕА́МБУЛА, wrongs=[ПРИАМБУЛА, ПРИОМБУЛА, ПРААМБУЛА]},
        // {original=ПРЕА́МБУЛА, wrongs=[ПРИАМБУЛА, ПРИОМБУЛА, ПРААМБУЛА]},
        // {original=ПРЕАМБУЛА, wrongs=[ПРИАМБУЛА, ПРИОМБУЛА, ПРААМБУЛА]}]

        //4 Добавляем объект в файл
        GsonUtil.append(wordList,FILE_PATH_WORDS);



    }


    private static Word getTestWord() {
        String[] wrongs = new String[]{"ПРИАМБУЛА", "ПРИОМБУЛА", "ПРААМБУЛА"};
        Word word = new Word("ПРЕА́МБУЛА", Arrays.asList(wrongs));
        return word;
    }

}
