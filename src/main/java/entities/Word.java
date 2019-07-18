package entities;

import java.util.List;

/**
 * Created by anmi0217 on 18/7/2019.
 */
public class Word {

    private String original;

    private List<String> wrongs;

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public List<String> getWrongs() {
        return wrongs;
    }

    public void setWrongs(List<String> wrongs) {
        this.wrongs = wrongs;
    }

    public Word(String original, List<String> wrongs) {
        this.original = original;
        this.wrongs = wrongs;
    }

    @Override
    public String toString() {
        return getOriginal();
    }

    /**
     *
     * "Word{" +
     "original='" + original + '\'' +
     ", wrongs=" + wrongs +
     '} ';
     *
     */
}
