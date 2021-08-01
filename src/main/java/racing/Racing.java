package racing;

import java.util.ArrayList;

public class Racing {

    public static final int MIN_NAME_LEN = 1;
    public static final int MAX_NAME_LEN = 5;
    public static final int MAX_INIT_VALUE = -1;

    public int gameCount;
    public String[] dividedName;

    public ArrayList<Car> carList;
    public static InputView inputView;
    public static ResultView resultView;
    public static RandomMaker randomMaker;

    public Racing() {
        this.gameCount = 0;
        this.carList = new ArrayList<>();
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.randomMaker = new RandomMaker();
    }

    public int getGameCount() {
        return gameCount;
    }

    public void setGameCount(int gameCount) {
        this.gameCount = gameCount;
    }

    public String[] getDividedName() {
        return dividedName;
    }

    public void setDividedName(String[] dividedName) {
        this.dividedName = dividedName;
    }

    public String[] divideNameByComma(String undividedName) {
        return undividedName.split(",");
    }

    public void isNameLengthUnderFive(String dividedName) {
        if (MIN_NAME_LEN > dividedName.length() || dividedName.length() > MAX_NAME_LEN) {
            throw new IllegalArgumentException("name length is over five or under one");
        }
    }

    public void play() {
        this.setDividedName(divideNameByComma(this.inputView.inputUnparsedName()));
        for (int i = 0; i < this.dividedName.length; i++) {
            this.isNameLengthUnderFive(this.dividedName[i]);
            this.carList.add(new Car(this.dividedName[i], 0));
        }
        this.setGameCount(this.inputView.inputPlayCount());

        this.resultView.printEntryResult();

        for (int i = 0; i < this.gameCount; i++) {
            this.checkMoveOrNot();
        }

        this.resultView.printResultWinner(this.checkWhoAreWinners(this.carList));
    }

    private void checkMoveOrNot() {
        for (int i = 0; i < this.carList.size(); i++) {
            if (this.randomMaker.moveOrNot() == true) {
                this.carList.get(i).setCarPosition(this.carList.get(i).getCarPosition() + 1);
            }
            this.resultView.printInterimResult(this.carList.get(i).getCarName(), this.carList.get(i).getCarPosition());
        }
    }

    public ArrayList<String> checkWhoAreWinners(ArrayList<Car> racingArrayList) {
        int winningPoint = this.returnMaxValue(racingArrayList);
        ArrayList<String> winningCarName = new ArrayList<>();

        for (int i = 0; i < racingArrayList.size(); i++) {
            if (racingArrayList.get(i).carPosition == winningPoint) {
                winningCarName.add(racingArrayList.get(i).getCarName());
            }
        }

        return winningCarName;
    }

    public int returnMaxValue(ArrayList<Car> racingArrayList) {
        int returnValue = MAX_INIT_VALUE;
        for (int i = 0; i < racingArrayList.size(); i++) {
            returnValue = Math.max(returnValue, racingArrayList.get(i).carPosition);
        }
        return returnValue;
    }
}
