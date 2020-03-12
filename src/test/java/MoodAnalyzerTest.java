import org.junit.Assert;
import org.junit.Test;

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
    public void givenHappyMessage_WithDefaultConstructor_ShouldReturnHappy()
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

}


