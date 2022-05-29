package com.favtuts.java8;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;


/*
 - https://www.favtuts.com/java-how-to-join-list-string-with-commas/
 - https://www.favtuts.com/java-8-stringjoiner-example/
*/
public class JoinStrings {
    
    public static void main(String[] args) {
        //joinListStringWithStringJoin();
        //joinListStringWithCollectorsJoining();
        //joinListStringWithCustomMethod();
        //joinStringWithStringJoiner();
        //joinStringWithPrefixSuffix();
        joinListObjectWithCollectorsJoining();
    }

    static void joinListObjectWithCollectorsJoining()
    {

        List<Game> list = Arrays.asList(
                new Game("Dragon Blaze", 5),
                new Game("Angry Bird", 5),
                new Game("Candy Crush", 5)
        );

        //{Dragon Blaze, Angry Bird, Candy Crush}
        String result = list.stream().map(x -> x.getName())
			.collect(Collectors.joining(", ", "{", "}"));
        
        System.out.println(result);
        
    }    

    static void joinStringWithPrefixSuffix() {

        StringJoiner sj = new StringJoiner("/", "prefix-", "-suffix");
        sj.add("2016");
        sj.add("02");
        sj.add("26");
        String result = sj.toString(); //prefix-2016/02/26-suffix
        System.out.println(result);

    }

    static void joinStringWithStringJoiner() {

        StringJoiner sj = new StringJoiner(",");
        sj.add("aaa");
        sj.add("bbb");
        sj.add("ccc");
        String result = sj.toString(); //aaa,bbb,ccc
        System.out.println(result);

    }

    static void joinListStringWithCustomMethod() {
        System.out.println(join(",", Arrays.asList("a")));
        System.out.println(join(",", Arrays.asList("a", "b")));
        System.out.println(join(",", Arrays.asList("a", "b", "c")));
        System.out.println(join(",", Arrays.asList("")));
        System.out.println(join(",", null));
    }

    private static String join(String separator, List<String> input) {

        if (input == null || input.size() <= 0) return "";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.size(); i++) {

            sb.append(input.get(i));

            // if not the last item
            if (i != input.size() - 1) {
                sb.append(separator);
            }

        }

        return sb.toString();

    }

    static void joinListStringWithCollectorsJoining() {
        List<String> list = Arrays.asList("a", "b", "c");

        String result = list.stream().collect(Collectors.joining(","));

        System.out.println(result);

        list = Arrays.asList("java", "python", "nodejs", "ruby");
	    //java | python | nodejs | ruby
	    result = list.stream().map(x -> x).collect(Collectors.joining(" | "));
    }

    static void joinListStringWithStringJoin() {
        List<String> list = Arrays.asList("a","b","c");
        String result = String.join(",", list);

        System.out.println(result);

        //2015-10-31
	    result = String.join("-", "2015", "10", "31" );
        System.out.println(result);
    }
}


class Game{
    String name;
    int ranking;

    public Game(String name, int ranking) {
        this.name = name;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}