package CardLayOut;

import java.io.Serializable;

public class MyWord implements Serializable{
	private String word;
	private String mean;
	
	public MyWord() {
		// TODO Auto-generated constructor stub
	}
	public MyWord(String word, String mean) {
		// TODO Auto-generated constructor stub
		this.word = word;
		this.mean = mean;
	}
	
	

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}
  @Override
public String toString() {
	// TODO Auto-generated method stub
	return this.getWord() + " - " +this.getMean();
}


}
