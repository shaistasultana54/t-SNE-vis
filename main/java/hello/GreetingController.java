package hello;


import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

import com.jujutsu.tsne.FastTSne;
import com.jujutsu.tsne.TSne;
import opennlp.tools.tokenize.SimpleTokenizer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingController {

    GreetingController() {

    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @CrossOrigin
    @GetMapping("/greeting")
    public String greetingSubmit(@RequestParam("id") String id, @RequestParam("content") String content) {

        System.out.println(id);
        System.out.println(content);
        RestTemplate restTemplate = new RestTemplate();
        String message = content;
        String message1 = "%22";
        String[] splitValues = message.split(" ");
        for (int i = 0; i < splitValues.length - 1; i++) {
            message1 = message1 + splitValues[i] + "%20";
        }
        message1 = message1 + splitValues[splitValues.length - 1] + "%22";

        String urlTemplate = "https://api.pushshift.io/reddit/search?q=" + message1;
        String result = restTemplate.getForObject(urlTemplate, String.class);
        System.out.println(result);
        return "i am shaista";
    }

    @CrossOrigin
    @PostMapping("/querySearch")
    public String querySearching(@RequestBody Greeting[] greeting) {
        System.out.println(greeting[0].getId());
        System.out.println(greeting[0].getContent());
        return greeting[0].getId();
    }

    @CrossOrigin
    @PostMapping("/redditSearch")
    public double[][] redditSearching(@RequestBody RedditData[] redditData) throws IOException {

        //list of comments which is a list of tokens
        ArrayList<ArrayList<String>> tokenizedData = new ArrayList<>();
        ArrayList<String> arrayOfBody = new ArrayList<>();
        for (int i = 0; i < redditData.length; i++) {
            arrayOfBody.add(redditData[i].body.replaceAll("http.*?\\s", "")
                    .toLowerCase().replaceAll("\\d", ""));
            //use of OpenNLP
            SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;

            //Tokenizing the given raw text
            String tokens[] = tokenizer.tokenize(arrayOfBody.get(i));
            StopWords stopWords = new StopWords();
            ArrayList<String> tokensWithRemovedStopWords = stopWords.removeStopword(tokens);
            tokenizedData.add(tokensWithRemovedStopWords);
        }
        //identify the unique words in the comments
        TreeSet<String> uniqueWords = new TreeSet<>();
        for (ArrayList<String> aTokenizedData : tokenizedData) {
            uniqueWords.addAll(aTokenizedData);
        }
        /*creation of 2-d array which can be used for input to TSNE
        tokenizedData.size() gives the number of comments
        */
        double[][] matrixForTsne = new double[tokenizedData.size()][uniqueWords.size()];
        String[] uniqueWordsArray = uniqueWords.toArray(new String[uniqueWords.size()]);
        int count = 0;
        for (int wordCount = 0; wordCount < uniqueWordsArray.length; ++wordCount) {
            for (int comment = 0; comment < tokenizedData.size(); comment++) {
                for (int token = 0; token < tokenizedData.get(comment).size(); token++) {
                    if (uniqueWordsArray[wordCount].equals(tokenizedData.get(comment).get(token))) {
                        count++;
                    }
                }
                matrixForTsne[comment][wordCount] = count;
                count = 0;
            }
        }
        TSne tsne = new FastTSne();
        double perplexity = 6.0;
        int initial_dims = 50;
        int iters = 1000;
        double[][] Y = tsne.tsne(matrixForTsne, 2, initial_dims, perplexity, iters);

        System.out.println("t-sne is completed now!");
        return Y;
    }
}
