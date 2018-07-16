package com.yl.string.number;

import com.yl.parse.Parser;
import com.yl.string.StringUtil;

import java.util.HashMap;
import java.util.Map;

public class StringNumberParser implements Parser<String, Map<String, String>> {

    @Override
    public Map<String, String> parse(String parsed) {
        char[] chars = StringUtil.stringToChars(parsed);
        double a = 123.E12;
        if(chars == null) {
            return null;
        }
        else {
            return parse(chars);
        }
    }

    private Map<String, String> parse(char[] chars) {
        Map<String, String> result = new HashMap<>();
        return  result;
    }

    private boolean isMultiPoint(char[] chars) {
        for(char c : chars) {
            if(c == '.') {

            }
        }

        return false;
    }

}
