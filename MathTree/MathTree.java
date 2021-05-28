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

	public static boolean equal(MathTree t1, MathTree t2){
		if(t1 == null || t2 == null){
			return t1 == t2;
		}else{
			return t1.value == t2.value && equal(t1.left,t2.left) && equal(t1.right,t2.right);
		}
	}

	public static boolean sameShape(MathTree t1, MathTree t2){
		if(t1 == null || t2 == null){
			return t1 == t2;
		}else{
			return sameShape(t1.left,t2.left) && sameShape(t1.right,t2.right);
		}
	}

	public static int height(MathTree t){
		if(t == null) return 0;
		else{
			int lh = height(t.left);
			int rh = height(t.right);
			if(lh > rh){
				return 1 + lh;
			}else{
				return 1 + rh;
			}
		}
	}

	public static int nodes(MathTree t){
		if(t == null) return 0;
		else{
			return 1 + nodes(t.left) + nodes(t.right);
		}
	}

	public static int sum(MathTree t){
		if(t == null) return 0;
		else{
			return t.value + sum(t.left) + sum(t.right);
		}
	}

	public static int lvs(MathTree t){
		if(t == null) return 0;
		if(t.left == null && t.right == null) return 1;
		else{
			return lvs(t.left) + lvs(t.right);
		}
	}

	public static void main(String[] args){
		MathTree tree = init(3,init(6),init(5,init(4),init(8,init(),init(7))));
		MathTree treec = init(3,init(6),init(5,init(4),init(8,init(),init(7))));
		MathTree tree2 = init(4,init(6),init(5,init(7),init(8,init(),init(7))));
		MathTree tree3 = init(4,init(6),init(5,init(7),init(8,init(9,init(3),init()),init(7))));
		System.out.println("Testing Trees\n");
		System.out.println("Equal to itself: " + Boolean.toString(equal(tree,tree)));
		System.out.println("Equal to another instance of itself: " + Boolean.toString(equal(tree,treec)));
		System.out.println("Equal to not itself but same shape: " + Boolean.toString(equal(tree,tree2)));
		System.out.println("Equal to not itself and different shape: " + Boolean.toString(equal(tree,tree3)));
		System.out.println();
		System.out.println("Same shape as itself: " + Boolean.toString(sameShape(tree,tree)));
		System.out.println("Same shape as another instance of itself: " + Boolean.toString(sameShape(tree,treec)));
		System.out.println("Same shape as not itself but same shape: " + Boolean.toString(sameShape(tree,tree2)));
		System.out.println("Same shape as not itself and different shape: " + Boolean.toString(sameShape(tree,tree3)));
		System.out.println();
		System.out.println(toString(tree));
		System.out.println();
		System.out.println("Height: " + Integer.toString(height(tree)));
		System.out.println("Nodes: " + Integer.toString(nodes(tree)));
		System.out.println("Sum: " + Integer.toString(sum(tree)));
		System.out.println("Leaves: " + Integer.toString(lvs(tree)));
	}
}