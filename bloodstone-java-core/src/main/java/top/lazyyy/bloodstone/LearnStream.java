package top.lazyyy.bloodstone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LearnStream {
    public static void main(String[] args) {
        List<String> a1 = new ArrayList<>();
        a1.add("test1");
        a1.add("test2");
        a1.add("test3");
        List<String> a2 = new ArrayList<>();
        a2.add("test4");
        a2.add("test5");
        a2.add("test6");
        List<List<String>> all = new ArrayList<>();
        all.add(a1);
        all.add(a2);
        List<String> ret = all.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(ret);
    }
}
