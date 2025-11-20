package lab12;

class ChatBox {
	String[] questionsArray = {"Ques1", "Ques2", "Ques3", "Ques4", "Ques5"};
	String[] answersArray = {
		    "Ans1", "Ans2", "Ans3", "Ans4", "Ans5",
		    "Ans6", "Ans7", "Ans8", "Ans9", "Ans10",
		    "Ans11", "Ans12", "Ans13", "Ans14", "Ans15", "Ans16"
	};
	boolean isQuestionTurn = true;
	
	public synchronized void printQuestion() {
		for(int i=0; i<=4 ; i++) {
			while(!isQuestionTurn) {
				try {
					wait();
				} catch( Exception e) {
					
				}
			}
			System.out.println(questionsArray[i]);
			isQuestionTurn = false;
			notify();
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public synchronized void printAnswer() {
		int start = 0;
		for(int i=0; i<=4 ; i++) {
			while(isQuestionTurn) {
				try {
					wait();
				} catch(InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			
			int end = start + 3;
			for (int j = start; j < end; j++) {
				System.out.println(answersArray[j]);
				try { Thread.sleep(400); } catch (Exception e) {}
			}
			isQuestionTurn = true;
			notify();
			start += 3;
		}
	}
}

class Question extends Thread {
	ChatBox question;
	
	public Question(ChatBox question) {
		this.question = question;
	}
	
	public void run() {
		question.printQuestion();
	}
}

class Answers extends Thread {
	ChatBox answer;
	
	public Answers(ChatBox answer) {
		this.answer = answer;
	}
	
	public void run() {
		answer.printAnswer();
	}
}

public class Exercise5 {
	public static void main(String arg[]) throws InterruptedException {
		ChatBox chat = new ChatBox();
		Question questions = new Question(chat);
		Answers answers = new Answers(chat);
		questions.start();
		answers.start();
	}
}
