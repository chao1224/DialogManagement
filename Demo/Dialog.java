package Demo;

import Template.Template;
import Agent.Agent;

public class Dialog extends Thread {
	private static boolean waitingPeopleFlag = true;
	private static boolean greetingFlag = false;
	private static boolean introducingFlag = false;
	private static boolean askingDirectionFlag = false;
	private static boolean askingAnswerFlag = false;
	private static boolean questionConfirmFlag = false;
	private static boolean answerConfirmFlag = false;
	private static boolean continueAskFlag = false;
	private Agent agentRobot;
	private Agent agentPeople;

	public void run() {
		setStartWaitingPeople();
		while (true) {
			try {
				System.out
						.println("Robot is waiting for someone. If someone comes, input\"come\".");
				Thread.sleep(10000);
				continue;
			} catch (InterruptedException e) {
				System.out.println("Someone is coming.");
				setEndWaitingPeople();

				agentRobot = new Agent("Robot");
				agentPeople = new Agent("People");

				setStartGreeting();
				System.out
						.println("This is greeting. Waiting people greeting for 5s.");
				Template.Greeting(agentRobot, agentPeople);
				setEndGreeting();
				System.out.println();

				setStartIntroducing();
				System.out
						.println("This is the introduction. Introduction lasts for 15s.");
				System.out.println("Can be interrupted by \"what\" question.");
				boolean flag = Template.Introduction(agentRobot, agentPeople);
				while (!flag) {
					System.out
							.println("This is reintroduction. Reintroduction lasts for 15s.");
					System.out
							.println("Can be interrupted by \"what\" question.");
					flag = Template.Reintroduction(agentRobot, agentPeople);
				}
				setEndIntroducing();
				System.out.println("Finish introduction part.");
				System.out.println();

				while (true) {
					setStartAskingDirection();
					System.out
							.println("Please ask me directions. Waiting for 15s.");
					System.out
							.println("Can be interrupted by \"where\" question.");
					System.out
							.println("\"where is Mike\" and \"where is mary\" has a specific answer");
					for (int times = 1; times <= 3; times++) {
						flag = Template.AskAnswer(agentRobot, agentPeople);
						if (flag) {
							break;
						}
					}
					setEndAskingDirection();
					System.out.println();

					setStartContinueAsk();
					boolean continueAsk = Template.ContinueAskAnswer(
							agentRobot, agentPeople);
					setEndContinueAsk();
					if (!continueAsk)
						break;
				}
				System.out.println();

				System.out.println("Waiting for next one");
				System.out.println();

				setStartWaitingPeople();
			}

		}
	}

	public static void setStartWaitingPeople() {
		waitingPeopleFlag = true;
	}

	public boolean isWaitingPeople() {
		return waitingPeopleFlag;
	}

	public static void setEndWaitingPeople() {
		waitingPeopleFlag = false;
	}

	public void setPeopleQuestion(String str) {
		agentPeople.setQuestion(str);
	}

	public String getPeopleQuestion() {
		return agentPeople.getQuestion();
	}

	public void setRobotQuestion(String str) {
		agentRobot.setQuestion(str);
	}

	public String getRobotQuestion() {
		return agentRobot.getQuestion();
	}

	public static void setStartGreeting() {
		greetingFlag = true;
	}

	public boolean isGreeting() {
		return greetingFlag;
	}

	public static void setEndGreeting() {
		greetingFlag = false;
	}

	public static void setStartIntroducing() {
		introducingFlag = true;
	}

	public boolean isIntroducing() {
		return introducingFlag;
	}

	public static void setEndIntroducing() {
		introducingFlag = false;
	}

	public static void setStartAsking() {
		askingAnswerFlag = true;
	}

	public boolean isAsking() {
		return askingAnswerFlag;
	}

	public static void setEndAsking() {
		askingAnswerFlag = false;
	}

	public static void setStartAskingDirection() {
		askingDirectionFlag = true;
	}

	public boolean isAskingDirection() {
		return askingDirectionFlag;
	}

	public static void setEndAskingDirection() {
		askingDirectionFlag = false;
	}

	public static void setStartQuestionConfirm() {
		questionConfirmFlag = true;
	}

	public boolean isQuestionConfirm() {
		return questionConfirmFlag;
	}

	public static void setEndQuestionConfirm() {
		questionConfirmFlag = false;
	}

	public static void setStartAnswerConfirm() {
		answerConfirmFlag = true;
	}

	public boolean isAnswerConfirm() {
		return answerConfirmFlag;
	}

	public static void setEndAnswerConfirm() {
		answerConfirmFlag = false;
	}

	public static void setStartContinueAsk() {
		continueAskFlag = true;
	}

	public boolean isContinueAsk() {
		return continueAskFlag;
	}

	public static void setEndContinueAsk() {
		continueAskFlag = false;
	}

	public void setGreeting(String str) {
		agentPeople.setGreeting(str);
	}

	public void setPeopleQuestionConfirmation(String str) {
		agentPeople.setQuestionConfirmation(str);
	}

	public void setPeopleAnswerConfirmation(String str) {
		agentPeople.setAnswerConfirmation(str);
	}

	public void setPeopleContinueAsk(boolean flag) {
		agentPeople.setContinueAsking(flag);
	}

	public void setPeopleGreeting(String str) {
		agentPeople.setGreeting(str);
	}
}
