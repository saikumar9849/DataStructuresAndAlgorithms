package basictree;

import java.util.ArrayList;

public class TreeNode {
	String data;
	ArrayList<TreeNode> children;
	public TreeNode(String data) {
		this.data = data;
		this.children=new ArrayList<>();
	}
	
	public void add(TreeNode data) {
		this.children.add(data);
	}
	
	public void print(int level) {
		System.out.print(" ".repeat(level)+this.data+"\n");
		for(int i=0;i<this.children.size();i++) {
			this.children.get(i).print(level+1);
		}
	}
}
