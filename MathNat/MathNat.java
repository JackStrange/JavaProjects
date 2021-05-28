public class MathNat{
	public MathNat next;

	public MathNat(MathNat n){
		this.next = n;
	}

	public static MathNat S(MathNat n){
		return new MathNat(n);
	}

	public static MathNat init(int n){
		if(n == 0) return null;
		else return S(init(n-1));
	}

	public static int realVal(MathNat n){
		if(n == null) return 0;
		else return 1 + realVal(n.next);
	}

	public static String toString(MathNat n){
		if(n == null) return "0";
		else return "S" + toString(n.next);
	}

	public static MathNat plus(MathNat n1, MathNat n2){
		if(n2 == null) return n1;
		else return S(plus(n1,n2.next));
	}

	public static void main(String[] args){
		MathNat nat4 = init(4);
		MathNat nat6 = init(6);
		System.out.println("4 = " + toString(nat4) + " = " + Integer.toString(realVal(nat4)));
		System.out.println("6 = " + toString(nat6) + " = " + Integer.toString(realVal(nat6)));
		System.out.println();
		System.out.println("Plus 4 & 6: " + toString(plus(nat4,nat6)) + " = " + Integer.toString(realVal(plus(nat4,nat6))));
	}
}