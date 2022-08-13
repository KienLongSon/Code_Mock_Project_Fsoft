package util;

import java.sql.Timestamp;

public class Utils {
    public static Timestamp getNowTimestamp() {
        long now = System.currentTimeMillis();
        return new Timestamp(now);
    }
}
