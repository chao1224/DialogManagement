package Demo;

public class Main {

	public static void main(String[] args) {
		Dialog dialogThread = new Dialog();

		Input input = new Input(dialogThread);
		Thread inputThread = new Thread(input);

		dialogThread.start();
		inputThread.start();
	}
}
