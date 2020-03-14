import java.util.Objects;

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

    //PARAMETERISED METHOD TO ANALYSE MOOD
    public String analyseMood(String message) throws MoodAnalysisException
    {
        this.message = message;
        return analyseMood();
    }

    //METHOD TO ANALYZE MOOD
    public String analyseMood() throws MoodAnalysisException
    {
        try
        {
            if (message.length() == 0 )
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTER_EMPTY, "Please Enter proper Mood");
            if (message.contains("sad"))
                return "SAD";
            else
                return  "HAPPY";
        }
        catch (NullPointerException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.ENTER_NULL, "Please Enter proper Mood");
        }
    }

    //METHOD TO CHECK TWO OBJECTS ARE EQUAL OR NOT
    @Override
    public boolean equals(Object object)
    {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        MoodAnalyzer that = (MoodAnalyzer) object;
        return Objects.equals(message, that.message);
    }

    //MAIN METHOD
    public static void main(String[] args)
    {
        System.out.println("--------MOOD ANALYZER--------");
    }
}
