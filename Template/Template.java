package Template;

import Agent.Agent;
import Demo.Dialog;

public class Template {

	public static void Greeting(Agent robot, Agent people) {
		try {
			Thread.sleep(5000);
			Welcome(robot);
		} catch (InterruptedException e) {
			Greeting(people);
			Welcome(robot);
		}
	}

	private static void Welcome(Agent a) {
		System.out.println(a.getName() + " : " + a.getWelcome());
	}

	private static void Greeting(Agent a) {
		System.out.println(a.getName() + " : " + a.getGreeting());
	}

	public static boolean Introduction(Agent agentRobot, Agent agentPeople) {
		try {
			System.out.println("Introduction.");
			// System.out.println("I am a direction asking robot");
			agentRobot
					.setIntroduction("This is a direction asking robot. Please ask me directions! :)");
			Thread.sleep(15000);
			return true;
		} catch (InterruptedException e) {
			System.out.print("Introduction interrupted by your question : ");
			System.out.println(agentPeople.getQuestion());
			Dialog.setStartAsking();
			Thread.currentThread().interrupt();
			Template.AskAnswer(agentRobot, agentPeople);
			Dialog.setEndAsking();
			return false;
		}
	}

	public static boolean Reintroduction(Agent agentRobot, Agent agentPeople) {
		try {
			agentRobot.setIntroduction("This is reintroduction.");
			Thread.sleep(15000);
			return true;
		} catch (InterruptedException e) {
			System.out
					.println("Reintroduction interrupted by your question : ");
			System.out.println(agentPeople.getQuestion());
			Dialog.setEndAsking();
			Thread.currentThread().interrupt();
			Template.AskAnswer(agentRobot, agentPeople);
			Dialog.setEndAsking();
			return false;
		}
	}

	public static boolean AskAnswer(Agent agentRobot, Agent agentPeople) {
		try {
			Thread.sleep(15000);
			System.out.println("Sorry I didn't hear you. Can you ask again?");
		} catch (InterruptedException e) {
			System.out
					.println("Your question is  " + agentPeople.getQuestion());
			boolean understandQuestion = false;
			for (int times = 1; times <= 3; times++) {
				double confidence = agentRobot.getConfidence();
				System.out.printf(
						"Robot has %.3f confidence about this question.\n",
						confidence);
				if (confidence > 0.2) {
					understandQuestion = true;
					break;
				} else {
					Template.QuestionConfirm(agentRobot, agentPeople);
					continue;
				}
			}

			if (!understandQuestion) {
				System.out
						.println("Robot : Sorry I cannot understand you. Can you stand closer and ask again?");
				return false;
			}

			agentRobot.setAnswer("...");
			System.out.println("Robot : answer is " + agentRobot.getAnswer());

			Template.AnswerConfirm(agentRobot, agentPeople);

			return true;
		}

		return true;
	}

	public static boolean ContinueAskAnswer(Agent agentRobot, Agent agentPeople) {
		try {
			System.out
					.println("Do you have other direction asking problem? (yes/no)");
			Thread.sleep(5000);
			System.out.println("Sorry I didn't hear you.(Default no)");
			return false;
		} catch (InterruptedException e) {
			boolean continueAsk = agentPeople.getContinueAsking();
			if (continueAsk)
				return true;
			else
				return false;
		}
	}

	public static boolean QuestionConfirm(Agent agentRobot, Agent agentPeople) {
		try {
			Dialog.setStartQuestionConfirm();
			System.out
					.println("Can you help explain more on what your question is?");
			System.out.println("Question confirm. Wait for 15s.");
			Thread.sleep(15000);
			Dialog.setEndQuestionConfirm();
			return false;
		} catch (InterruptedException e) {
			System.out.println("Question confirm "
					+ agentPeople.getQuestionConfirmation());
			Dialog.setEndQuestionConfirm();
			return false;
		}
	}

	public static boolean AnswerConfirm(Agent agentRobot, Agent agentPeople) {
		Dialog.setStartAnswerConfirm();
		try {
			System.out.println("Do you get a satisfied answer? (yes/no)");
			System.out.println("Answer confirm. Wait for 15s.");
			Thread.sleep(15000);
			Dialog.setEndAnswerConfirm();
			System.out.println("Sorry I didn't hear you. (Default yes)");
			return false;
		} catch (InterruptedException e) {
			Dialog.setEndAnswerConfirm();
			return false;
		}
	}

}
