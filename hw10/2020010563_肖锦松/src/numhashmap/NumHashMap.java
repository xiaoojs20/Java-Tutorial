package numhashmap;

import java.util.*;

import static java.lang.System.in;

public class NumHashMap {
    HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
    String word="";
    char[] chs = new char[50];
    public String decrypt(String str){

        hashMap.put('v','a');
        hashMap.put('e','b');
        hashMap.put('k','c');
        hashMap.put('n','d');
        hashMap.put('o','e');
        hashMap.put('h','f');
        hashMap.put('z','g');
        hashMap.put('f','h');
        hashMap.put('a','i');
        hashMap.put('l','j');
        hashMap.put('j','k');
        hashMap.put('x','l');
        hashMap.put('d','m');
        hashMap.put('m','n');
        hashMap.put('y','o');
        hashMap.put('g','p');
        hashMap.put('b','q');
        hashMap.put('r','r');
        hashMap.put('c','s');
        hashMap.put('s','t');
        hashMap.put('w','u');
        hashMap.put('q','v');
        hashMap.put('u','w');
        hashMap.put('p','x');
        hashMap.put('t','y');
        hashMap.put('i','z');

        hashMap.put('V','A');
        hashMap.put('E','B');
        hashMap.put('K','C');
        hashMap.put('N','D');
        hashMap.put('O','E');
        hashMap.put('H','F');
        hashMap.put('Z','G');
        hashMap.put('F','H');
        hashMap.put('A','I');
        hashMap.put('L','J');
        hashMap.put('J','K');
        hashMap.put('X','L');
        hashMap.put('D','M');
        hashMap.put('M','N');
        hashMap.put('Y','O');
        hashMap.put('G','P');
        hashMap.put('B','Q');
        hashMap.put('R','R');
        hashMap.put('C','S');
        hashMap.put('S','T');
        hashMap.put('W','U');
        hashMap.put('Q','V');
        hashMap.put('U','W');
        hashMap.put('P','X');
        hashMap.put('T','Y');
        hashMap.put('I','Z');

        hashMap.put(' ',' ');

        for(int i = 0; i < str.length(); i++){
//            if(str.charAt(i) )
            char ch = hashMap.get(str.charAt(i));
            String tmp = String.valueOf(ch);
            word += tmp;
        }

        return word;
    }
}
