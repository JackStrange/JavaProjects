public class MathTree{
	public int value;
	public MathTree left,right;

	public MathTree(int v, MathTree l, MathTree r){
		this.value = v;
		this.left = l;
		this.right = r;
	}

	public static MathTree init(int v, MathTree l, MathTree r){
		return new MathTree(v,l,r);
	}

	public static MathTree init(int v){
		return new MathTree(v,null,null);
	}

	public static MathTree init(){
		return null;
	}

	public static String toString(MathTree t){
		if(t == null){
			return "-";
		}else if(t.left == null && t.right == null){
			return Integer.toString(t.value);
		}else{
			return Integer.toString(t.value) + ":(" + toString(t.left) + ", " + toString(t.right) + ")";
		}
	}

	public static void main(String[] args){
		MathTree tree = init(3,init(6),init(5,init(4),init(8,init(),init(7))));
		System.out.println(toString(tree));
	}
}