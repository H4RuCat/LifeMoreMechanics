package lifemoremechanics.org.example.lifemoremechanics.Condition;

import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.SkillCondition;
import io.lumine.xikage.mythicmobs.skills.conditions.IEntityCondition;
import org.bukkit.Bukkit;

import java.time.LocalDateTime;

public class RealTimeConditions extends SkillCondition implements IEntityCondition {

    protected final int maxYear;
    protected final int maxMonth;
    protected final int maxDay;
    protected final int maxHour;
    protected final int maxMinute;
    protected final int maxSecond;

    protected final int minYear;
    protected final int minMonth;
    protected final int minDay;
    protected final int minHour;
    protected final int minMinute;
    protected final int minSecond;

    public boolean timeCheck(int max, int min, int value) {

        if (value > max) return false;
        return value >= min;

    }

    @Override
    public boolean check(AbstractEntity abstractEntity) {

        LocalDateTime nowTime = LocalDateTime.now();
        int nowYear  = nowTime.getYear();
        int nowMonth = nowTime.getMonth().ordinal() + 1;
        int nowDay = nowTime.getDayOfMonth();
        int nowHour = nowTime.getHour();
        int nowMinute = nowTime.getMinute();
        int nowSecond = nowTime.getSecond();

        Bukkit.broadcastMessage("0 " + nowYear);

        if ( !timeCheck(maxYear, minYear, nowYear) ) return false;
        Bukkit.broadcastMessage("1 " + nowMonth);
        if ( !timeCheck(maxMonth, minMonth, nowMonth) ) return false;
        Bukkit.broadcastMessage("2 " + nowDay);
        if ( !timeCheck(maxDay, minDay, nowDay) ) return false;
        Bukkit.broadcastMessage("3 " + nowHour);
        if ( !timeCheck(maxHour, minHour, nowHour) ) return false;
        Bukkit.broadcastMessage("4 " + nowMinute);
        if ( !timeCheck(maxMinute, minMinute, nowMinute) ) return false;
        Bukkit.broadcastMessage("5 " + timeCheck(maxSecond, minSecond, nowSecond));
        return timeCheck(maxSecond, minSecond, nowSecond);

    }

    public RealTimeConditions(MythicLineConfig config) {
        super(config.getLine());

        this.maxYear = config.getInteger(new String[] {"maxyear", "maxy", "may", "年次"}, Integer.MAX_VALUE);
        this.maxMonth = config.getInteger(new String[] {"maxmonth", "maxm", "mamo", "月次"}, Integer.MAX_VALUE);
        this.maxDay = config.getInteger(new String[] {"maxday", "maxd", "mad", "日次"}, Integer.MAX_VALUE);
        this.maxHour = config.getInteger(new String[] {"maxhour", "maxh", "mah", "時次"}, Integer.MAX_VALUE);
        this.maxMinute = config.getInteger(new String[] {"maxminute", "maxmi", "mami", "分次"}, Integer.MAX_VALUE);
        this.maxSecond = config.getInteger(new String[] {"maxsecond", "maxs", "mas", "秒次"}, Integer.MAX_VALUE);

        this.minYear = config.getInteger(new String[] {"minyear", "miny", "miy", "年前"}, Integer.MIN_VALUE);
        this.minMonth = config.getInteger(new String[] {"minmonth", "minm", "mimo", "月前"}, Integer.MIN_VALUE);
        this.minDay = config.getInteger(new String[] {"minday", "mind", "mid", "日前"}, Integer.MIN_VALUE);
        this.minHour = config.getInteger(new String[] {"minhour", "minh", "mih", "時前"}, Integer.MIN_VALUE);
        this.minMinute = config.getInteger(new String[] {"minminute", "minmi", "mimi", "分前"}, Integer.MIN_VALUE);
        this.minSecond = config.getInteger(new String[] {"minsecond", "mins", "mis", "秒前"}, Integer.MIN_VALUE);

    }
}
