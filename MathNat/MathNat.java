public class MathNat{
	public MathNat next;

	public MathNat(MathNat n){
		this.next = n;
	}

	public static MathNat S(MathNat n){
		return new MathNat(n);
	}

	public static MathNat P(MathNat n){
		if(n == null) return null;
		else return n.next;
	}

	public static MathNat init(int n){
		if(n == 0) return null;
		else return S(init(n-1));
	}

	public static int realVal(MathNat n){
		if(n == null) return 0;
		else return 1 + realVal(P(n));
	}

	public static String toString(MathNat n){
		if(n == null) return "0";
		else return "S" + toString(P(n));
	}

	public static MathNat plus(MathNat n1, MathNat n2){
		if(n2 == null) return n1;
		else return S(plus(n1,P(n2)));
	}

	public static MathNat prod(MathNat n1, MathNat n2){
		if(n2 == null) return null;
		else return plus(prod(n1,P(n2)),n1);
	}

	public static MathNat sub(MathNat n1, MathNat n2){
		if(n2 == null) return n1;
		else return P(sub(n1,P(n2)));
	}

	public static void main(String[] args){
		MathNat nat4 = init(4);
		MathNat nat6 = init(6);
		System.out.println("4 = " + toString(nat4) + " = " + Integer.toString(realVal(nat4)));
		System.out.println("6 = " + toString(nat6) + " = " + Integer.toString(realVal(nat6)));
		System.out.println();
		System.out.println("4+6 = " + toString(plus(nat4,nat6)) + " = " + Integer.toString(realVal(plus(nat4,nat6))));
		System.out.println("4*6 = " + toString(prod(nat4,nat6)) + " = " + Integer.toString(realVal(prod(nat4,nat6))));
		System.out.println("6-4 = " + toString(sub(nat6,nat4)) + " = " + Integer.toString(realVal(sub(nat6,nat4))));
		System.out.println("4-6 = " + toString(sub(nat4,nat6)) + " = " + Integer.toString(realVal(sub(nat4,nat6))));
	}
}