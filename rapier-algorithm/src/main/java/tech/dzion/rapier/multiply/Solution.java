package tech.dzion.rapier.multiply;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().multiply("1", "1"));
    }

    private String multiply(String x, String y) {
        char zero = '0';
        List<Character> ret = new ArrayList<>();
        for (int i = x.length() - 1, posX = 0; i >= 0; i--, posX++) {
            for (int j = y.length() - 1, posY = 0; j >= 0; j--, posY++) {
                int numX = x.charAt(i) - zero;
                int numY = y.charAt(j) - zero;
                int ele = numX * numY;
                int temp = getValue(ret, posX + posY);
                setValue(ret, posX + posY, ele + temp);
            }
        }
        Collections.reverse(ret);
        StringBuffer sb = new StringBuffer();
        for(Character c:ret){
            sb.append(c);
        }
        return sb.toString();
    }

    private void setValue(List<Character> ret, int pos, int value) {
        if (value >= 10) {
            ret.set(pos, Character.forDigit(value - 10, 10));
            int toPromote = getValue(ret, pos + 1);
            setValue(ret, pos + 1, toPromote + 1);
        } else {
            ret.set(pos, Character.forDigit(value, 10));
        }
    }

    private int getValue(List<Character> ret, int pos) {
        return ret.get(pos) != null ? ret.get(pos) - '0' : 0;
    }


}
