public class SinglePlayerMessages extends PlayerMessages{

    public static String pickDifficulty() {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|  What difficulty would you like to play? (type easy/medium/hard to select)  |");
        System.out.println("-------------------------------------------------------------------------------");

        String difficultyResponse = "";
        while (!difficultyResponse.equalsIgnoreCase("easy") && !difficultyResponse.equalsIgnoreCase("medium") && !difficultyResponse.equalsIgnoreCase("hard")) {
            difficultyResponse = myScanner.nextLine().toLowerCase();
            if (!difficultyResponse.equals("easy") && !difficultyResponse.equals("medium") && !difficultyResponse.equals("hard")) {
                System.out.println("This was not understood, you need to type 'easy', 'medium' or 'hard'. Please try again.");
            }
        }
        return difficultyResponse;
    }

}
