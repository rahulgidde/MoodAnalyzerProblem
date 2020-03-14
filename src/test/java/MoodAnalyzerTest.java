import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class MoodAnalyzerTest
{
    String result;

    @Test
    public void givenMessage_WhenSadMood_ThenReturnMood() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in sad mood");
        try
        {
            result = moodAnalyzer.analyseMood();
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        Assert.assertEquals("SAD", result);
    }

    @Test
    public void givenMessage_WhenHappyMood_ThenReturnMood() throws MoodAnalysisException {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in happy mood");
        try
        {
            result = moodAnalyzer.analyseMood();
        } catch (MoodAnalysisException e)
        {
            e.printStackTrace();
        }
        Assert.assertEquals("HAPPY", result);
    }

    @Test
    public void givenMessage_WhenNullMood_ThenReturnMood() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try
        {
            moodAnalyzer.analyseMood();
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTER_NULL, e.type);
        }
    }

    @Test
    public void givenMessage_WhenEmptyMood_ThenReturnMood() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        try
        {
            moodAnalyzer.analyseMood();
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTER_EMPTY, e.type);
        }
    }

    @Test
    public void givenMoodAnalyzerClassName_WithDefaultConstructor_ShouldReturnObject() {
        try
        {
            MoodAnalyzer moodAnalyzer = new MoodAnalyzer();
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer");
            Object result = MoodAnalyserFactory.createMoodAnalyzer(constructor);
            Assert.assertEquals(moodAnalyzer, result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzer_WhenImproperClassName_ThenReturnException() {
        try
        {
            MoodAnalyserFactory.getConstructor("Myclass",String.class);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenMoodAnalyzer_WhenImproperParameter_ThenReturnException() {
        try
        {
             MoodAnalyserFactory.getConstructor("MoodAnalyzer", Integer.class);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenMoodAnalyzer_WithParametrizedConstructor_ShouldReturnObject() {
        try
        {
            MoodAnalyzer analyzer = new MoodAnalyzer("I am in happy mood");
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer", String.class);
            MoodAnalyzer moodAnalyzer = MoodAnalyserFactory.createMoodAnalyzer(constructor, "I am in happy mood");
            boolean result = moodAnalyzer.equals(analyzer);
            Assert.assertEquals(true, result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzer_WhenImproperClassName_ThenReturnClassNotFound()
    {
        try
        {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnslyzer", String.class);
            Object result = MoodAnalyserFactory.createMoodAnalyzer(constructor, "I am in happy mood");
            MoodAnalyserFactory.invokeMethod(result, "analyzeMod");
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, e.type);
        }
    }

    @Test
    public void givenMoodAnalyzer_WhenImproperParameter_ThenReturnNoSuchMethod()
    {
        try
        {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer",Integer.class);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }

    @Test
    public void givenHappyMood_WhenProper_ThenReturnHappyMood()
    {
        try
        {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer", String.class);
            Object result = MoodAnalyserFactory.createMoodAnalyzer(constructor, "I am in Happy mood");
            Object mood = MoodAnalyserFactory.invokeMethod(result, "analyseMood");
            Assert.assertEquals("HAPPY", mood);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}



