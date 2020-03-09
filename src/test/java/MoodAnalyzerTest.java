import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest
{
    String result;
    @Test
    public void givenMessage_WhenSadMood_ThenReturnMood()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in sad mood");
        result = moodAnalyzer.analyseMood();
        Assert.assertEquals("SAD",result);
    }

    @Test
    public void givenMessage_WhenHappyMood_ThenReturnMood()
    {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Happy mood");
        result = moodAnalyzer.analyseMood();
        Assert.assertEquals("HAPPY", result);
    }
}
