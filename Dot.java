import java.util.Random;
import java.io.*;
class Dot{

    void boystart() {

        int numOfGuesses = 0;
        SimpleDotCom theDotCom = new SimpleDotCom ();
        theDotCom.setLocationCells();
        GameHelper helper = new GameHelper ();
        boolean isAlive = true;
        while (isAlive == true) {

            String guess = helper.getUserInput("Enter the number");
            System.out.println(guess);
            String result = theDotCom.checkYourSelf(guess);
            numOfGuesses++;
            if (result.equals("Drown")) isAlive = false;
            System.out.println("You needed " + numOfGuesses + "attempts");		//âûâîä ïîïûòîê
        }
    }
}
class GameHelper {

    public String getUserInput (String prompt) {
        String inputLine = null;
        System.out.println(prompt + "  ");

        try {
            BufferedReader is = new BufferedReader (new InputStreamReader (System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        }
        catch (IOException e) {System.out.println("IO Exception : " + e);}
        return inputLine;
    }
}

class SimpleDotCom  {   	// ïðîâåðêà âûñòðåëà
    static int serc(int[] Arr, int Cell){
        int x = 0;
        for(int i:Arr){
            if(i == Cell){
                System.out.println(x);
                return x;
            }
            x++;
        }
        x = -1;
        return x;
    }

    static int randomNum;
    static {
        randomNum = (int) (Math.random ()* 5);
    }
    int regshoot [] = {1,1,1};

    int [] locationCells = {randomNum, randomNum+1, randomNum+2};
    int numOfHits = 0;
    public void setLocationCells () {
        for(int i = 0; i <= locationCells.length  - 1; i++) {
            System.out.print(locationCells[i] + "  ");
        }
        System.out.println();
    }
    public String checkYourSelf (String stringGuess) {

        int guess = Integer.parseInt(stringGuess);
        int regshoot_index = serc(locationCells, guess);

        String result = "Miss"; 				// ÇÀñ÷¸ò âûñòðåëà
        if (regshoot_index != -1){
            for (int cell : locationCells) {
                if ((guess == cell)&&(regshoot[regshoot_index] == 1)) {
                    regshoot[regshoot_index] = 0;
                    result = "Boom";
                    numOfHits++;
                    break;

                }
            }
        }
        if (numOfHits == locationCells.length) {
            result = "Drown";
        }
        System.out.println(result);
        System.out.println(numOfHits);
        return result;
    }
} {
}
