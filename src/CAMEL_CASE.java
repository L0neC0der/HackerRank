import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CAMEL_CASE {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String regEx = "[A-Z]+";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(s);
        int count = 0;
        while (matcher.find()) {
          count+=matcher.group(0).length();
        }
        System.out.println(++count);
    }
}
