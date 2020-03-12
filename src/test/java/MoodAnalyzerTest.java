import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest
{
    String result;
    @Test
    public void givenMessage_WhenSadMood_ThenReturnMood() throws MoodAnalysisException
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in sad mood");
        result = moodAnalyzer.analyseMood();
        Assert.assertEquals("SAD",result);
    }

    @Test
    public void givenMessage_WhenHappyMood_ThenReturnMood() throws MoodAnalysisException
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in happy mood");
        result = moodAnalyzer.analyseMood();
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
}

