import org.junit.Assert;
import org.junit.Test;
import sun.security.ssl.HandshakeInStream;

import java.lang.reflect.Constructor;

public class MoodAnalyzerTest
{
    String result;
    @Test
    public void givenMessage_WhenSadMood_ThenReturnMood()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in sad mood");
        try
        {
            result = moodAnalyzer.analyseMood();
        }
        catch(MoodAnalysisException e)
        {
            e.printStackTrace();
        }
            Assert.assertEquals("SAD", result);
    }

    @Test
    public void givenMessage_WhenHappyMood_ThenReturnMood() throws MoodAnalysisException
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in happy mood");
        try
        {
            result = moodAnalyzer.analyseMood();
        }
        catch(MoodAnalysisException e)
        {
            e.printStackTrace();
        }
            Assert.assertEquals("HAPPY", result);
    }

   @Test
    public void givenMessage_WhenNullMood_ThenReturnMood()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer(null);
        try
        {
            moodAnalyzer.analyseMood();
        }
        catch(MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTER_NULL,e.type);
        }
    }

    @Test
    public void givenMessage_WhenEmptyMood_ThenReturnMood()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("");
        try
        {
            moodAnalyzer.analyseMood();
        }
        catch(MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTER_EMPTY,e.type);
        }
    }

    @Test
    public void givenMoodAnalyzerClassName_WithDefaultConstructor_ShouldReturnObject()
    {
        try
        {
            MoodAnalyzer analyzer = new MoodAnalyzer();
            MoodAnalyzer moodAnalyzer = MoodAnalyserFactory.createMoodAnalyzer();
            boolean result = moodAnalyzer.equals(analyzer);
            Assert.assertEquals(true, result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenMoodAnalyzer_WhenImproperClassName_ThenReturnException()
    {
        try
        {
            Constructor<?> analyzeConstructor = MoodAnalyserFactory.getConstructor("Myclass");
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenMoodAnalyzer_WhenImproperParameter_ThenReturnException()
    {
        try
        {
            Constructor<?> analyzeConstructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer",Integer.class);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD,e.type);
        }
    }

    @Test
    public void givenMoodAnalyzer_WithParametrizedConstructor_ShouldReturnObject()
    {
        try
        {
            MoodAnalyzer analyzer = new MoodAnalyzer("I am in happy mood");
            MoodAnalyzer moodAnalyzer = MoodAnalyserFactory.createMoodAnalyzer("I am in happy mood");
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
            Constructor<?> analyzeConstructor = MoodAnalyserFactory.getConstructor("MoodAnal","I am in Happy Mood");
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }

    @Test
    public void givenMoodAnalyzer_WhenImproperParameter_ThenReturnNoSuchMethod()
    {
        try
        {
            Constructor<?> analyzeConstructor = MoodAnalyserFactory.getConstructor("MoodAnal","I am in Happy Mood",Integer.class);
        }
        catch (MoodAnalysisException e)
        {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_CLASS,e.type);
        }
    }
}



