import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory
{
    //METHOD TO CHECK PARAMETRIZED CONSTRUCTOR
    public static MoodAnalyzer createMoodAnalyzer(Constructor constructor, Object... message) throws MoodAnalysisException {
        try {
            Object instance = constructor.newInstance(message);
            return (MoodAnalyzer) instance;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (
                InstantiationException e) {
            e.printStackTrace();
        } catch (
                InvocationTargetException e) {
            e.printStackTrace();

        }
        return null;
    }

    //METHOD TO CHECK CLASS NOT FOUND EXCEPTION AND METHOD NOT FOUND EXCEPTION
    public static Constructor<?> getConstructor(String className, Class<?>... param) throws MoodAnalysisException {
        try {
            Class moodAnalyzerClass = Class.forName(className);
            return moodAnalyzerClass.getConstructor(param);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "Please Enter Proper Class Name");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Please Enter Proper Method Name");
        }
    }

    //METHOD TO INVOKE CLASS METHOD
    public static Object invokeMethod(Object result, String analyzeMood) throws MoodAnalysisException {
        try {
            return result.getClass().getMethod(analyzeMood).invoke(result);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "No Such Method");
        }
        return null;
    }
}
