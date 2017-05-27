package newton.mathmania.models;

public class PointCalculator {

    public int calculatePointsEasy()
    {
        int easySecsLeft = ViewModel.easyMillisLeft/1000;

        int pointsEasy = easySecsLeft;

        return pointsEasy;
    }

    public int calculatePointsHard()
    {
        int hardSecsLeft = ViewModel.hardMillisLeft/1000;

        int pointsHard = 2 * hardSecsLeft;

        return pointsHard;
    }
}