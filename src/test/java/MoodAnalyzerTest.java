import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest
{
    //TEST CASE TO CHECK SAD MOOD
    @Test
    public void givenMessage_whenSadMood_thenReturnMood()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in sad mood");
        String result=moodAnalyzer.analyseMood();
        Assert.assertEquals("SAD",result);
    }

    //TEST CASE TO CHECK ANY MOOD
    @Test
    public void givenMessage_whenAnyMood_thenReturnMood()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer("I am in any mood");
        String result=moodAnalyzer.analyseMood();
        Assert.assertEquals("HAPPY",result);
    }

    //TEST CASE TO CHECK NULL MOOD
    @Test
    public void givenMessage_whenNullMood_thenReturnMood()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
        String result=moodAnalyzer.analyseMood();
        Assert.assertEquals("HAPPY",result);
    }
}
