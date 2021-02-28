   /**
COMP2503
Bryce Baker
    */



import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;


public class A1 
{
   
   private ArrayList<Food> words = new ArrayList<Food>();

   private String[] stopwords = 
   { "a", "about", "all", "am", "an", 
         "and", "any", "are", "as", "at", "be", "been", "but", "by", "can", 
         "cannot", "could", "did", "do", "does", "else", "for", "from", 
         "get", "got", "had", "has", "have", "he", "her", "hers", "him", 
         "his", "how", "i", "if", "in", "into", "is", "it", "its", "like", 
         "more", "me", "my", "no", "now", "not", "of", "on", "one", 
         "or", "our", "out", "said", "say", "says", "she", "so", "some",
         "than", "that", "the", "their", "them", "then", "there", "these", 
         "they", "this", "to", "too", "us", "upon", "was", "we", "were", 
         "what", "with", "when", "where", "which", "while", "who", 
          "whom", "why", 
         "will", "you", "your", "---", "***"
         };


   public static void main( String[ ] args) 
   {    
      A1 a1 = new A1();
      a1.run();
   }

   /**
    * Check if the word given is in the stopword list.
    * @param w a word 
    * @return true if w is a stopword, false otherwise
    */
   private boolean stopword( String w) 
   {
      boolean found = false;
      int i = 0;
      while (i < stopwords.length && !found) 
      {
          
          int r = w.compareTo(stopwords[i]);
          if (r == 0)
          {
              found = true;
             i++;
            }
            else{i++;}
      }
      return found;
   }

   /** 
   List the first n words in the list of words.
   @param n the number of words to list
   */
   private void printWords(int n) 
   {
      int i = 0;
      while ( i < words.size() && i < n) 
      {
          Food tmp = words.get(i);
          String tempName = tmp.getName();
          System.out.println(tempName);
          i++;
      }
   }


   /**  
   Read the input file and process it. 
   Input is on standard input and is read one 
   word at a time -- separated by whitespace. 
 
   All non alphabetic characters are stripped out and 
   words are all converted to lower case. 
  
   Any non-stopword word is stored in the list of words 
   and the number of occurances is tracked.
   */
   private void readFile() 
   {
        words.add(new Food(0, "baking powder"));
        words.add(new Food(0, "baking soda"));
        words.add(new Food(0, "cheese"));
        words.add(new Food(0, "broth"));
        words.add(new Food(0, "tomato paste"));
        words.add(new Food(0, "tomato sauce"));
        words.add(new Food(0, "tomato"));
        words.add(new Food(0, "flour"));
        words.add(new Food(0, "egg"));
        words.add(new Food(0, "garlic"));
        words.add(new Food(0, "rice"));
        words.add(new Food(0, "onion"));
        words.add(new Food(0, "salt"));
        words.add(new Food(0, "pepper"));
        words.add(new Food(0, "vinegar"));
        words.add(new Food(0, "carrot"));
        words.add(new Food(0, "sweet potato"));
             words.add(new Food(0, "potato"));
                  words.add(new Food(0, "cream"));
                   words.add(new Food(0, "milk"));
                    words.add(new Food(0, "bean"));
                     words.add(new Food(0, "green bean"));
                      words.add(new Food(0, "beef"));
                       words.add(new Food(0, "chicken"));
                        words.add(new Food(0, "cumin"));
                         words.add(new Food(0, "oregano"));
                          words.add(new Food(0, "basil"));
                           words.add(new Food(0, "oil"));
                            words.add(new Food(0, "fish"));
      Scanner inp = new Scanner(System.in);
      

      while (inp.hasNext()) 
      {
         String word = inp.next().toLowerCase().trim().replaceAll( "[^a-z]","");
         //Check for plurals and remove them
int lg = word.length();
String pt1 = word.substring((lg - 1), lg);
String pt2 = word.substring((lg - 2), lg);
if(pt2.equals("es"))
{
word = word.substring(1, (lg - 2));   
}
else if(pt1.equals("s"))
{
    word = word.substring(1, (lg - 1));
}
         if ( word.length() > 0) 
         { 
            boolean res = stopword(word);
            if (res == false)
            {
                //Assign values to array
               
                int control = 0;
                int pointer = 0;
                while(control == 0)
                {
                    
                    Food tmp2 = words.get(pointer);
                    String ts = tmp2.getName();
                    String ts2 = ts.toLowerCase().trim().replaceAll( "[^a-z]","");
                    if(tmp2 == null)
                    {
                        words.add(new Food(1, word));
                        control = 1;
                    }
                    else if(word.equals(ts2) && tmp2 != null)
                    {
                        String tmpName = tmp2.getName();
                        int tmpCount = tmp2.getCount();
                        tmpCount++;
                        words.set(pointer, new Food(tmpCount, tmpName));

                        control = 1;
                        }
                    
                    else{pointer++;}
                }
      }
    }
}
   }


   
   //Sort list and print
   public void printResults()
   {
       Collections.sort(words);
         Collections.sort(words, new Food());
         for(Food done: words)
         System.out.println(done.getName() + " " + done.getCount());
       
   }
   

   /** Run the program. Read the file, then print the results. */
   
   public void run() 
   {
      readFile();
      printResults();
   }

}


