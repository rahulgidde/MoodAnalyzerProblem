public class MoodAnalysisException extends Exception
{
    enum ExceptionType
    {
        ENTER_NULL,ENTER_EMPTY
    }
    ExceptionType type;

    public MoodAnalysisException(ExceptionType type,String message)
    {
        super(message);
        this.type=type;
    }
}
