public class MoodAnalyzer
{
    private String message;

    //DECLARE CONSTRUCTOR
    public MoodAnalyzer()
    {
        message = "";
    }

    //PARAMETRIZED CONSTRUCTOR
    public MoodAnalyzer(String message)
    {
        this.message = message;
    }

    //METHOD TO ANALYZE MOOD
    public String analyseMood()
    {
        if (message.contains("I am in sad mood"))
        {
            message = "SAD";
        }
        else if (message.contains("I am in happy mood"))
        {
            message = "SAD";
        }
        else
        {
            message="HAPPY";
        }
        return message;
    }

    //MAIN METHOD
    public static void main(String[] args)
    {
        System.out.println("--------MOOD ANALYZER--------");
    }
}
