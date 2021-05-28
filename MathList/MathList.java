import java.util.ArrayList;

public class MathList{
	public int value;
	public MathList next;

	public MathList(int v, MathList l){
		this.value = v;
		this.next = l;
	}

	public static MathList init(ArrayList<Integer> vs){
		if(vs.isEmpty()){
			return null;
		}else{
			int output = vs.remove(0);
			return new MathList(output,init(vs));
		}
	}

	public static String toString(MathList l){
		if(l == null){
			return "[]";
		}else{
			return Integer.toString(l.value) + ":" + toString(l.next);
		}
	}

	public static void main(String[] args){
		ArrayList<Integer> startArray = new ArrayList<Integer>();
		for (int i = 0; i<10; i++) {
			startArray.add(i*i + 2*i + 5);
		}
		System.out.println(MathList.toString(MathList.init(startArray)));
	}
}