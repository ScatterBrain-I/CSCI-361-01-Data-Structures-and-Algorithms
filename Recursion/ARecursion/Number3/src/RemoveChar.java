public class RemoveChar{

  public static String removeChar(String sentence, char character){
    if (sentence.indexOf(character) == -1){
      return sentence;
    }
    else{
      sentence = sentence.substring(0, sentence.indexOf(character)) +
        sentence.substring(sentence.indexOf(character) + 1);
      return removeChar(sentence, character);
    }
  }
}
