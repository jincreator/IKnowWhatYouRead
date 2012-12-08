package org.cauoop.filter;

public class ArticleFilter {
	private String category = null;
	private String[] split = null;
	
	public ArticleFilter(String word,String line){
		category = word;
		split = line.replaceAll("(\\*|@|#|\\$|_|&|\\!|\\%|\\.|\\,|\\(.*\\)|\\>|-)", "").replace("�� ", " ").replace("�� ", " ").replace("�� ", " ").replace("�� ", " ").replace("�� ", " ").replace("���� ", " ").replace("�� ", " ").replace("��� ", " ").replace("�� ", " ").replace("�� ", " ").replace("�� ", " ").replace("�ϰ� ", " ").replace("�ϴ� ", " ").replace("���� ", " ").split(" ");
	}
	
	public String getCategory(){
		return category;
	}
	
	public String[] getSplit(){
		return split;
	}
}
