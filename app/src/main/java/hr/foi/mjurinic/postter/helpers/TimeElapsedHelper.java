package hr.foi.mjurinic.postter.helpers;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

/**
 * Created by mjurinic on 13.01.16..
 */
public final class TimeElapsedHelper {

    public static String CalculateTime(DateTime createdAt) {
        Period period = new Period(createdAt, new DateTime());

        PeriodFormatter formatter = new PeriodFormatterBuilder()
                .appendYears().appendSuffix(" years ago ")
                .appendMonths().appendSuffix(" months ago ")
                .appendWeeks().appendSuffix(" weeks ago ")
                .appendDays().appendSuffix(" days ago ")
                .appendHours().appendSuffix(" hours ago ")
                .appendMinutes().appendSuffix(" minutes ago ")
                .appendSeconds().appendSuffix(" seconds ago ")
                .printZeroNever()
                .toFormatter();

        String[] ret = formatter.print(period).split(" ");

        return ret[0] + ' ' + ret[1] + ' ' + ret[2];
    }
}
