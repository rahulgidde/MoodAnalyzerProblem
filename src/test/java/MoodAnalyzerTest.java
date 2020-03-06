import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest
{
    //TEST CASE TO CHECK MOOD IS SAD
    @Test
    public void givenMessage_whenSab_thenReturnMood()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
        String result=moodAnalyzer.analyseMood("sad");
        Assert.assertEquals("SAD",result);
    }

    //TEST CASE TO CHECK MOOD IS HAPPY
    @Test
    public void givenMessage_whenAnyMood_thenReturnMood()
    {
        MoodAnalyzer moodAnalyzer=new MoodAnalyzer();
        String result=moodAnalyzer.analyseMood("I am in any mood");
        Assert.assertEquals("HAPPY",result);
    }
}
