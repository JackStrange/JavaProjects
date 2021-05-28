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

	public static int sum(MathList l){
		if(l == null){
			return 0;
		}else{
			return l.value + sum(l.next);
		}
	}

	public static int len(MathList l){
		if(l == null){
			return 0;
		}else{
			return 1 + len(l.next);
		}
	}

	public static void main(String[] args){
		ArrayList<Integer> startArray = new ArrayList<Integer>();
		for (int i = 0; i<10; i++) {
			startArray.add(i*i + 2*i + 5);
		}
		MathList list = init(startArray);
		System.out.println(toString(list));
		System.out.println("Sum: " + Integer.toString(sum(list)));
		System.out.println("Length: " + Integer.toString(len(list)));
	}
}