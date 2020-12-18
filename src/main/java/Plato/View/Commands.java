package Plato.View;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Commands {
    BACK("(?i)back"),
    VIEW_EVENTS("(?i)view\\s+events"),
    VIEW_EVENT("(?i)view\\s+event\\s+(\\d+)"),
    REMOVE_EVENT("(?!)remove\\s+event\\s+(\\d+)"),
    ADD_EVENT("(?i)add\\s+event"),
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
    CHOOSE_SUGGESTED_GAME("(?i)choose\\s+suggested\\s+game\\s+(\\d+)"),
    ADD_FRIEND("(?i)add\\s+friend\\s+(\\S+)"),
    DATER("(?i)(\\d+)\\s+(\\d+)\\s+(\\d+)"),
    SHOW_FRIENDS("(?i)show\\s+friends"),
    REMOVE_FRIENDS("(?i)remove\\s+(\\S+)"),
    VIEW_USER_PROFILE_FRIEND_MENU("(?i)view\\s+user\\s+profile\\s+(\\S+)"),
    ADD_USER("(?i)add\\s+(\\S+)"),
    SHOW_FRIEND_REQUESTS("(?i)show\\s+friend\\s+requests"),
    ACCEPT_FRIEND_REQUEST("(?i)accept\\s+(\\S+)"),
    DECLNE_FRIEND_REQUEST("(?i)decline\\s+(\\S+)"),
    REGISTER("(?i)register\\s+(\\S+)\\s+(\\S+)"),
    LOGIN("(?i)login\\s+(\\S+)"),
    CHOOSE_FAVORITE_GAME("(?i)choose\\s+favorite\\s+(\\d+)"),
    JOIN_EVENT("(?i)join\\s+event\\s+(\\d+)"),
    GO_TO_FRIENDS_MENU("(?i)go\\s+to\\s+friends\\s+menu"),
    GO_TO_GAMES_MENU("(?i)go\\s+to\\s+games\\s+menu"),
    CHANGE_GAME_NAME("(?i)change\\s+game\\s+name\\s+(\\d+)\\s+(\\S+)"),
    ADD_NEW_ADMIN("(?i)add\\s+admin\\s+(\\S+)\\s+(\\S+)");

    private Pattern pattern;

    Commands(String regexPattern){
        this.pattern = Pattern.compile(regexPattern);
    }

    public Matcher getMatcher (String input) {
        return pattern.matcher(input);
    }
}
