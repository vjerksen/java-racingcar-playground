package racing;

import java.util.ArrayList;

public class ResultView {

    public void printResultWinner(ArrayList<String> winningCarName) {

        for (int i = 0; i < winningCarName.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(winningCarName.get(i));
        }

        System.out.println("가 최종 우승했습니다.");
    }

    public void printEntryResult() {
        System.out.println("\n실행 결과");
    }

    public void printInterimResult(String carName, int carPosition) {
        System.out.print(carName + " : ");
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
