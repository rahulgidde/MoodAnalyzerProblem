public class MoodAnalysisException extends Exception
{
    enum ExceptionType
    {
        ENTER_NULL,ENTER_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD
    }
    ExceptionType type;

    public MoodAnalysisException(ExceptionType type,String message)
    {
        super(message);
        this.type=type;
    }
}
