package Demo;

import java.util.Scanner;

public class Input implements Runnable {
	Dialog dialog;

	Input(Dialog dialog) {
		this.dialog = dialog;
	}

	@Override
	public void run() {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String str = scan.nextLine().trim().toLowerCase();
			Scanner scan1 = new Scanner(str);
			String firstWord = scan1.next();
			if (dialog.isWaitingPeople() && firstWord.equals("come")) {
				dialog.interrupt();
			} else if (dialog.isGreeting()) {
				dialog.setPeopleGreeting(str);
				dialog.setGreeting(str);
				dialog.interrupt();
			} else if (firstWord.equals("what") && dialog.isIntroducing()) {
				dialog.setPeopleQuestion(str);
				dialog.setRobotQuestion(str);
				dialog.interrupt();
			} else if (firstWord.equals("where") && dialog.isAskingDirection()) {
				dialog.setPeopleQuestion(str);
				dialog.setRobotQuestion(str);
				dialog.interrupt();
			} else if (dialog.isQuestionConfirm()) {
				dialog.setPeopleQuestionConfirmation(str);
				dialog.interrupt();
			} else if (dialog.isAnswerConfirm()) {
				if (str.equals("yes")) {
					dialog.setPeopleAnswerConfirmation(str);
					dialog.interrupt();
				} else if (str.equals("no")) {
					dialog.setPeopleAnswerConfirmation(str);
					dialog.interrupt();
				} else {
					System.out.println("Sorry. Please input yes or no.");
				}
			} else if (dialog.isContinueAsk()) {
				if (str.equals("yes")) {
					dialog.setPeopleContinueAsk(true);
					dialog.interrupt();
				} else if (str.equals("no")) {
					dialog.setPeopleContinueAsk(false);
					dialog.interrupt();
				} else {
					System.out.println("Sorry. Please input yes or no.");
				}
			}
		}
	}
}
