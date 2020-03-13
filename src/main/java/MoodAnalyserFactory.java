import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory
{
    public static MoodAnalyzer createMoodAnalyzer() throws MoodAnalysisException
    {
        try
        {
            Class moodAnalyzerClass = Class.forName("MoodAnalyzer");
            Constructor constructor = moodAnalyzerClass.getConstructor();
            Object instance = constructor.newInstance();
            return (MoodAnalyzer) instance;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor<?> getConstructor(String className,Class<?>...param) throws  MoodAnalysisException
    {
        try
        {
            Class moodAnalyzerClass = Class.forName(className);
            return moodAnalyzerClass.getConstructor(param);
        }
        catch (ClassNotFoundException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,"Please Enter Proper Class Name");
        }
        catch (NoSuchMethodException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,"Please Enter Proper Method Name");
        }
    }
}
