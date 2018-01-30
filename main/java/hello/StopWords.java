package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class StopWords {
    public HashSet<String> stopWords;

    public StopWords() {
        this.stopWords = new HashSet();
        stopWords.add("!!");
        stopWords.add("?!");
        stopWords.add("??");
        stopWords.add("!?");
        stopWords.add("`");
        stopWords.add("``");
        stopWords.add("~");
        stopWords.add("~~");
        stopWords.add("''");
        stopWords.add("-lrb-");
        stopWords.add("-rrb-");
        stopWords.add("-lsb");
        stopWords.add("-rsb-");
        stopWords.add(",");
        stopWords.add(".");
        stopWords.add(":");
        stopWords.add(";");
        stopWords.add("\"");
        stopWords.add("'");
        stopWords.add("?");
        stopWords.add("<");
        stopWords.add(">");
        stopWords.add("{");
        stopWords.add("}");
        stopWords.add("[");
        stopWords.add("]");
        stopWords.add("+");
        stopWords.add("-");
        stopWords.add("(");
        stopWords.add(")");
        stopWords.add("&");
        stopWords.add("%");
        stopWords.add("$");
        stopWords.add("@");
        stopWords.add("!");
        stopWords.add("^");
        stopWords.add("#");
        stopWords.add("*");
        stopWords.add("..");
        stopWords.add("...");
        stopWords.add("'ll");
        stopWords.add("'s");
        stopWords.add("'m");
        stopWords.add("a");
        stopWords.add("about");
        stopWords.add("above");
        stopWords.add("after");
        stopWords.add("again");
        stopWords.add("against");
        stopWords.add("all");
        stopWords.add("am");
        stopWords.add("an");
        stopWords.add("and");
        stopWords.add("any");
        stopWords.add("are");
        stopWords.add("n't");
        stopWords.add("t");
        stopWords.add("aren");
        stopWords.add("as");
        stopWords.add("at");
        stopWords.add("be");
        stopWords.add("because");
        stopWords.add("been");
        stopWords.add("before");
        stopWords.add("being");
        stopWords.add("can");
        stopWords.add("could");
        stopWords.add("the");
        stopWords.add("did");
        stopWords.add("do");
        stopWords.add("don");
        stopWords.add("doesn");
        stopWords.add("couldn");
        stopWords.add("has");
        stopWords.add("hasn");
        stopWords.add("have");
        stopWords.add("haven");
        stopWords.add("d");
        stopWords.add("ll");
        stopWords.add("s");
        stopWords.add("him");
        stopWords.add("how");
        stopWords.add("m");
        stopWords.add("ve");
        stopWords.add("if");
        stopWords.add("i");
        stopWords.add("is");
        stopWords.add("isn");
        stopWords.add("its");
        stopWords.add("it");
        stopWords.add("let");
        stopWords.add("should");
        stopWords.add("shouldn");
        stopWords.add("mustn");
        stopWords.add("shall");
        stopWords.add("shan");
        stopWords.add("re");
        stopWords.add("would");
        stopWords.add("wouldn");
        stopWords.add("wasn");
        stopWords.add("were");
        stopWords.add("weren");
        stopWords.add("who");
        stopWords.add("why");
        stopWords.add("there");
        stopWords.add("gt");
        stopWords.add("lt");
        stopWords.add("le");
        stopWords.add("ge");
        stopWords.add("’");
        stopWords.add("c");
        stopWords.add("b");
        stopWords.add("e");
        stopWords.add("f");
        stopWords.add("g");
        stopWords.add("h");
        stopWords.add("j");
        stopWords.add("k");
        stopWords.add("l");
        stopWords.add("n");
        stopWords.add("o");
        stopWords.add("p");
        stopWords.add("q");
        stopWords.add("r");
        stopWords.add("u");
        stopWords.add("v");
        stopWords.add("w");
        stopWords.add("x");
        stopWords.add("y");
        stopWords.add("z");
        stopWords.add("=");
        stopWords.add("|");
        stopWords.add("my");
        stopWords.add("by");
        stopWords.add("in");
        stopWords.add("to");
        stopWords.add("into");
        stopWords.add("this");
        stopWords.add("you");
        stopWords.add("your");
        stopWords.add("mine");
        stopWords.add("up");
        stopWords.add("out");
        stopWords.add("or");
        stopWords.add("nor");
        stopWords.add("upon");
        stopWords.add("of");
        stopWords.add("no");
        stopWords.add("www");
        stopWords.add("me");
        stopWords.add("not");
        stopWords.add("on");
        stopWords.add("oh");
        /*stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()
        stopWords.add()*/

    }

    public ArrayList<String> removeStopword(String[] stringOfTokens) {

        ArrayList<String> removedStopword = new ArrayList<>();
        for (int i = 0; i < stringOfTokens.length; i++) {
            if (!stopWords.contains(stringOfTokens[i])) {
                removedStopword.add(stringOfTokens[i].replaceAll("[^A-Za-z0-9]", ""));
                removedStopword.remove("");
            }
        }
        return removedStopword;
    }


}
