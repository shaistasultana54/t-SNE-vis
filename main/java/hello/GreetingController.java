package hello;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingController {

    GreetingController() {

    }

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*@RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }*/
  /*  @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting(0, "hey"));
        return "greeting";
    }*/

    @CrossOrigin
    @GetMapping("/greeting")
    public String greetingSubmit(@RequestParam("id") String id, @RequestParam("content") String content) {

        System.out.println(id);
        System.out.println(content);
        RestTemplate restTemplate = new RestTemplate();
        String message = content;
        String message1 = "%22";
        String[] splitValues = message.split(" ");
        for(int i = 0; i < splitValues.length - 1; i++){
            message1 = message1 + splitValues[i] + "%20";
        }
        message1 = message1 + splitValues[splitValues.length - 1] + "%22";

        String urlTemplate = "https://api.pushshift.io/reddit/search?q="+message1;
        String result = restTemplate.getForObject(urlTemplate, String.class);
        System.out.println(result);
        return "i am shaista";
    }

    @CrossOrigin
    @PostMapping("/querySearch")
    public String querySearching(@RequestBody Greeting[] greeting){
        System.out.println(greeting[0].getId());
        System.out.println(greeting[0].getContent());
        return greeting[0].getId();
    }

    @CrossOrigin
    @PostMapping("/redditSearch")
    public String redditSearching(@RequestBody RedditData[] redditData) throws IOException {
        ArrayList<ArrayList<String>> tokenizedData = new ArrayList<>();
        ArrayList<String> arrayOfBody = new ArrayList<String>();
        for(int i = 0; i < redditData.length; i++){
            arrayOfBody.add(redditData[i].body.replaceAll("http.*?\\s", "").toLowerCase().replaceAll("\\d",""));
           /* //Loading the Tokenizer model
            InputStream inputStream = new FileInputStream("E:/tokenizing/en-token.bin");
            TokenizerModel tokenModel = new TokenizerModel(inputStream);

            //Instantiating the TokenizerME class
            TokenizerME tokenizer = new TokenizerME(tokenModel);*/

            SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;

            //Tokenizing the given raw text
            String tokens[] = tokenizer.tokenize(arrayOfBody.get(i));
            StopWords stopWords = new StopWords();
            ArrayList<String> tokensWithRemovedStopWords = stopWords.removeStopword(tokens);
            tokenizedData.add(tokensWithRemovedStopWords);
            for (int k = 0; k < tokensWithRemovedStopWords.size(); k++) {

                System.out.println(tokensWithRemovedStopWords.get(k));
            }
        }


        return "shaista";
    }
}
