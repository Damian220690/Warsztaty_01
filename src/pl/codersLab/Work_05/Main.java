package pl.codersLab.Work_05;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {


    private static Map<String, Integer> wordCount = new HashMap<>();
    private static List<String> bannedWords = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Connection connect = Jsoup.connect("http://www.onet.pl/");
        bannedWords.add("Kevin");
        bannedWords.add("piratom");
        bannedWords.add("piratów");
        try {
            Document document = connect.get();
            Elements links = document.select("span.title");
            for (Element elem : links) {
                parseLine(elem.text());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("popularWords2.txt"));

        Set<String> words = wordCount.keySet();

        for(String word : words){
            bufferedWriter.write(word + " : " + wordCount.get(word) + "\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();

    }

    private static void parseLine(String line) {
        for(String word : line.split(" ")){
            countWord(word);
        }
    }

    private static void countWord(String word) {
        if(word.length() > 2 && !bannedWords.contains(word)) {
            if (!wordCount.keySet().contains(word)) {
                wordCount.put(word, 1);
            } else {
                Integer counter = wordCount.get(word);
                counter++;

                wordCount.put(word, counter);
            }
        }
    }

}
