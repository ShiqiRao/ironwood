package tech.dzion.rapier.str;

public class TestString {

    public static void main(String[] args) {
        String str = "AAA";
        changeStr(str);
        System.out.println(str);
    }

    static void changeStr(String string){
        string = string.replaceAll("A","B");
    }

}
