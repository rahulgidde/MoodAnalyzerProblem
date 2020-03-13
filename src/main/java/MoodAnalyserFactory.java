import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory
{
    //METHOD TO CHECK DEFAULT CONSTRUCTOR
    public static MoodAnalyzer createMoodAnalyzer() throws MoodAnalysisException
    {
        try
        {
            Class moodAnalyzerClass = Class.forName("MoodAnalyzer");
            Constructor moodAnalyzerClassConstructor = moodAnalyzerClass.getConstructor();
            Object instance = moodAnalyzerClass.newInstance();
            return (MoodAnalyzer) instance;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    //METHOD TO CHECK PARAMETRIZED CONSTRUCTOR
    public static MoodAnalyzer createMoodAnalyzer(String message) throws MoodAnalysisException
    {
        try
        {
            Class moodAnalyzerClass = Class.forName("MoodAnalyzer");
            Constructor moodAnalyzerClassConstructor = moodAnalyzerClass.getDeclaredConstructor(String.class);
            Object instance = moodAnalyzerClassConstructor.newInstance(message);
            return (MoodAnalyzer) instance;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    //METHOD TO CHECK CLASS NOT FOUND EXCEPTION AND METHOD NOT FOUND EXCEPTION
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

    //METHOD TO CHECK CLASS NOT FOUND EXCEPTION AND METHOD NOT FOUND EXCEPTION WITH PARAMETRIZED CONSTRUCTOR
    public static Constructor<?> getConstructor(String className, String message, Class<?>... param) throws  MoodAnalysisException
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
