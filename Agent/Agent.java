package Agent;

public class Agent {

	private String name;
	private String question;
	private String answer;
	private String introduction;
	private String greeting = "hi";
	private String welcome = "welcome";
	private String questionConfirmation;
	private String answerConfirmation;
	private boolean continueAsk;

	public Agent() {
	}

	public Agent(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswer() {
		if (this.question.contains("mike"))
			this.answer = "Go to Left";
		else if (this.question.contains("mary"))
			this.answer = "Go to Right";
		return this.answer;
	}

	public double getConfidence() {
		return Math.random();
	}

	public void setIntroduction(String str) {
		this.introduction = str;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	private String clarification;

	public void setClarification(String str) {
		this.clarification = str;
	}

	public String getClarification() {
		return this.clarification;
	}

	public String getWelcome() {
		return this.welcome;
	}

	public void setWelcome(String str) {
		this.welcome = str;
	}

	public String getGreeting() {
		return this.greeting;
	}

	public void setGreeting(String str) {
		this.greeting = str;
	}

	public void setQuestionConfirmation(String str) {
		this.questionConfirmation = str;
	}

	public String getQuestionConfirmation() {
		return this.questionConfirmation;
	}

	public void setAnswerConfirmation(String str) {
		this.answerConfirmation = str;
	}

	public String getAnswerConfirmation() {
		return this.answerConfirmation;
	}

	public void setContinueAsking(boolean bool) {
		continueAsk = bool;
	}

	public boolean getContinueAsking() {
		return continueAsk;
	}
}
