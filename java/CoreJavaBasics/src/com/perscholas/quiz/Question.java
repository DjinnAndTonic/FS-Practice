package com.perscholas.quiz;

public class Question {
	private String question;
	private String[] choices;
	private char correctAnswer;
	
	public Question() {
		setQuestion("");
		setChoices(new String[4]);
		correctAnswer = ' ';
	}
	
	public Question(String q, String[] a) {
		setQuestion(q);
		setChoices(a);
		
		for(String s : a) {
			if(s.charAt(0) == '*') {
				setCorrectAnswer(s.charAt(1));
				break;
			}
		}
	}

	public char getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(char correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getChoices() {
		String answers = "";
		for(String s : choices) {
			if(s.charAt(0) == '*')
				answers += s.substring(1) + "\n";
			else
				answers += s + "\n";
		}
		return answers;
	}
	
	public void setChoices(String[] choices) {
		this.choices = choices;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String toString() {
		return question + "\n" +
				choices[0] + "\n" +
				choices[1] + "\n" +
				choices[2] + "\n" +
				choices[3] + "\n";
				
	}
}
