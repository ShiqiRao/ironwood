package top.lazyyy.bloodstone;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonRegex {

    public static void main(String[] args) {
        String str = "｛a:1;b:    xxyyzz;c:ab  cde;｝";
        Pattern p = Pattern.compile("(\\w+\\s*\\w*)\\s*:\\s*(\\w+\\s*\\w*(?=;))");
        Matcher m = p.matcher(str);
        Map<String, String> ret = new HashMap<>();
        while (m.find()) {
            ret.put(m.group(0), m.group(1));
        }
        System.out.println(ret);
    }

}
