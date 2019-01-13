// James Wilfong
// Dr. Stephan
// CSE 271, Section C
public class VotingMachine {
	
	//instance variables
	private int demVote, repVote, totalVote;

	public int getDemVote() {
		return demVote;
	}//end getDemVote
	
	public void setDemVote(int demVote) {
		this.demVote = demVote;
	}//end setDemVote
	
	public int getRepVote() {
		return repVote;
	}//end getRepVote
	
	public void setRepVote(int repVote) {
		this.repVote = repVote;
	}//end setRepVote
	
	public int getTotalVote() {
		return totalVote;
	}//end getTotalVote
	
	public void setTotalVote(int totalVote) {
		this.totalVote = totalVote;
	}//end setTotalVote
	
	public void clearMachine(){
		this.setDemVote(0);
		this.setRepVote(0);
		this.setTotalVote(0);
	}//end clearMachine
	
	public void voteDem(){
		this.demVote+=1;
	}//end voteDem
	
	public void voteRep(){
		this.repVote+=1;
	}//end voteRep
	
	public String voteTotal(){
		return "Democrat: " + this.demVote + " Republican: " + this.repVote;
	}//end voteTotal
}//end VotingMachine class
