package racing;

import java.util.Scanner;

public class InputView {

    public static Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public String inputUnparsedName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return returnInputValue();
    }

    public int inputPlayCount() {
        System.out.println("시도할 회수는 몇 회 인가요?");
        return Integer.parseInt(returnInputValue());
    }

    public String returnInputValue() {
        return scanner.nextLine();
    }
}
