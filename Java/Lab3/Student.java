// James Wilfong
// Dr. Stephan
// CSE 271, Section C

public class Student {
	
	//instance variables
	private String name;
	private int totalQuizScore;
	private int quizTotal;

	public Student(String name){
		this.setName(name);	
	}//end Student constructor
	
	public void addQuiz(int score){
		if(score>=0 && score<=100){
			this.totalQuizScore += score;
			this.quizTotal += 1;
		}//end if statement
	}//end addQuiz
	
	public String getName() {
		return name;
	}//end getName
	
	public void setName(String name) {
		this.name = name;
	}//end setName
	
	public int getTotalScore() {
		return totalQuizScore;
	}//end getTotalScore
	
	public void setTotalQuizScore(int totalQuizScore) {
		this.totalQuizScore = totalQuizScore;
	}//end setTotalQuizScore
	
	public int getAverageScore(){
		return this.totalQuizScore/this.quizTotal;
	}//end getAverageScore
}//end Student class
