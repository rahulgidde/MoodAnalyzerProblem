import org.junit.Assert;
import org.junit.Test;
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
    public void givenClassName_WhenImproper_ShouldReturnException()
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
    public void givenParameter_WhenWrongParameter_ShouldReturnException()
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
}


