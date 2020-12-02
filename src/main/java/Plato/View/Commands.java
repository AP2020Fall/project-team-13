package Plato.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Commands {
    BACK("(?i)back");

    private Pattern pattern;

    Commands(String regexPattern){
        this.pattern = Pattern.compile(regexPattern);
    }

    public Matcher getMatcher (String input) {
        return pattern.matcher(input);
    }
}
