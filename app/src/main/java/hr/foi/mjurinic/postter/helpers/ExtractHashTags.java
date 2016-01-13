package hr.foi.mjurinic.postter.helpers;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mjurinic on 07.01.16..
 */
public final class ExtractHashTags {

    public static final String REGEX = "#(\\w+|\\W+)";

    public static ArrayList<String> getHashTags(String body) {
        Pattern PATTERN = Pattern.compile(REGEX);
        Matcher matcher = PATTERN.matcher(body);
        ArrayList<String> ret = new ArrayList<>();

        while (matcher.find()) {
            ret.add(matcher.group(1));
        }

        return ret;
    }
}
