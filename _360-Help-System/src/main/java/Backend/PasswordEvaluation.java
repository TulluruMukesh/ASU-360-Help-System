package Backend;
import java.util.Random;

public class PasswordEvaluation
{
    Random rand = new Random();


    public int generateOTP()
    {
        return 100000 + rand.nextInt(900000);
    }

    public void resetAccOTP()
    {

    }

    public void newAccOTP()
    {

    }

}
