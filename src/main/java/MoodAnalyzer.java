public class MoodAnalyzer
{
    public static void main(String[] args)
    {
        System.out.println("--------MOOD ANALYZER--------");
    }
    public String analyseMood(String message)
    {
        if (message.contains("sad"))
        {
            message = "SAD";
        }
        else
        {
            message = "HAPPY";
        }
        return message;
    }
}
