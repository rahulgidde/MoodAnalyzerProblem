public class MoodAnalyzer
{
    String message;

    //DECLARE CONSTRUCTOR
    public MoodAnalyzer()
    {

    }

    //PARAMETRIZED CONSTRUCTOR
    public MoodAnalyzer(String message)
    {
        this.message = message;
    }

    //METHOD TO ANALYZE MOOD
    public String analyseMood()
    {
        try
        {
            if (message.contains("sad"))
                return "SAD";
            else
                return  "HAPPY";
        }
        catch (NullPointerException e)
        {
          return "HAPPY";
        }
    }

    //MAIN METHOD
    public static void main(String[] args)
    {
        System.out.println("--------MOOD ANALYZER--------");
    }
}
