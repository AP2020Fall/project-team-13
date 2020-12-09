package Plato.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Commands {
    BACK("(?i)back"),
    VIEW_EVENTS("(?i)view\\s+events"),
    VIEW_EVENT("(?i)view\\s+event\\s+(\\d+)"),
    REMOVE_EVENT("(?!)remove\\s+event\\s+(\\d+)"),
    ADD_EVENT("(?!)add\\s+event\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\d+)"),
    EDIT_EVENT("(?!)edit\\s+event\\s+(\\d+)\\s+(\\S+)\\s+(\\S+)"),
    ADD_SUGGESTION("(?!)add\\s+suggestion\\s+(\\S+)\\s+(\\S+)"),
    VIEW_SUGGESTIONS("(?i)view\\s+suggestions"),
    REMOVE_SUGGESTION("(?!)remove\\s+suggestion\\s+(\\d+)"),
    VIEW_USERS("(?i)view\\s+users"),
    VIEW_USER_PROFILE("(?i)view\\s+user\\s+profile\\s+(\\S+)"),
    VIEW_ACCOUNT_MENU("(?i)view\\s+account\\s+menu"),
    ADD_BOT_MESSAGE("(?i)add\\s+message\\s+(\\S+)"),
    HELP("(?i)help"),
    SHOW_POINT("(?i)show\\s+points"),
    VIEW_FAVORITE_GAMES("(?i)view\\s+favorite\\s+games"),
    VIEW_PLATOBOT_MESSAGES("(?i)view\\s+platobot\\s+messages"),
    VIEW_LAST_PLAYED("(?i)view\\s+last\\s+played"),
    VIEW_ADMINS_SUGGESTIONS("(?i)view\\s+admins\\s+suggestions"),
    CHOOSE_SUGGESTED_GAME("(?ichoose\\s+suggested\\s+game\\s+(\\d+)"),
    ADD_FRIEND("(?i)add\\sfriend\\s+(\\S+)"),
    DATER("(?i)(\\d+)\\/\\s+(\\d+)\\s+/\\s+(\\d+)\\s+/\\s+(\\d+)\\s+(\\d+)");

    private Pattern pattern;

    Commands(String regexPattern){
        this.pattern = Pattern.compile(regexPattern);
    }

    public Matcher getMatcher (String input) {
        return pattern.matcher(input);
    }
}
