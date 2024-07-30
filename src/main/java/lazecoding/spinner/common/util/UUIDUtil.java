package lazecoding.spinner.common.util;

import java.util.UUID;

/**
 * UUIDUtil
 *
 * @author lazecoding
 */
public class UUIDUtil {

    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
