package com.lance.practise.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream API
 *
 * @author Shenglan Wang
 */
public class StreamExample {
    public static void main(String[] args) {
        IntStream.range(1, 3).forEach(t -> System.out.println(t));
        IntStream.rangeClosed(1, 3).forEach(System.out::println);

        List<String> wordList = Arrays.asList("Hello", "World");
        List<String> output = wordList.stream().map(String::toUpperCase).collect(
                Collectors.toList());
        output.forEach(System.out::println);


        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
        outputStream.forEach(System.out::println);
    }
}
