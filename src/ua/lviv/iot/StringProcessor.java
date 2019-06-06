package ua.lviv.iot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessor {
    private String line;
    private List<String> list;

    public StringProcessor(){}

    public StringProcessor(String line, List<String> list) {
        this.line = line;
        this.list = list;
    }

    public String getLine() {
        return line;
    }

    public List<String> getList() {
        return list;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String readInputText() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Enter String");
//        return br.readLine();
        System.out.println("Enter your string");
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
        return line;
    }

    public final List<String> findMatch() {
        list = new LinkedList<String>();
        Pattern wordsWithMission = Pattern.compile("(\\w+\\,.city.\\w+\\,.(\\w+.){1,}Street\\,.work.time\\:.\\d{1,2}\\:\\d{1,2}.\\-.\\d{1,2}\\:\\d{1,2})");
        Matcher matcher = wordsWithMission.matcher(this.getLine());
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    public final void showResults() {
        System.out.println("\nYours matches:\n");

        if (list.isEmpty()) {
            System.out.println("There is no matches found :c ");
        } else {
            System.out.println("Result: " + list);
        }
    }
}
