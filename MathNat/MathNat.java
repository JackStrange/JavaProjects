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

	public static boolean equal(MathNat n1, MathNat n2){
		if(n2 == null || n1 == null) return n1 == n2;
		else return equal(P(n1),P(n2));
	}

	public static MathNat mod(MathNat n1, MathNat n2){
		if(n1 == null) return null;
		else{
			MathNat nextMod = S(mod(P(n1),n2));
			if(equal(n2,nextMod)) return null;
			else return nextMod;
		}
	}

	public static MathNat div(MathNat n1, MathNat n2){
		if(n1 == null) return null;
		else{
			MathNat nextDiv = div(P(n1),n2);
			if(equal(null,mod(n1,n2))) return S(nextDiv);
			else return nextDiv;
		}
	}

	public static void main(String[] args){
		String num1 = "4";
		String num2 = "13";
		MathNat nat1 = init(4);
		MathNat nat2 = init(13);
		System.out.println(num1 + " = " + toString(nat1) + " = " + Integer.toString(realVal(nat1)));
		System.out.println(num2 + " = " + toString(nat2) + " = " + Integer.toString(realVal(nat2)));
		System.out.println();
		System.out.println(num1 + "==" + num2 + " = " + Boolean.toString(equal(nat1,nat2)));
		System.out.println(num1 + "==" + num1 + " = " + Boolean.toString(equal(nat1,nat1)));
		System.out.println(num1 + "+" + num2 + " = " + toString(plus(nat1,nat2)) + " = " + Integer.toString(realVal(plus(nat1,nat2))));
		System.out.println(num1 + "*" + num2 + " = " + toString(prod(nat1,nat2)) + " = " + Integer.toString(realVal(prod(nat1,nat2))));
		System.out.println(num2 + "-" + num1 + " = " + toString(sub(nat2,nat1)) + " = " + Integer.toString(realVal(sub(nat2,nat1))));
		System.out.println(num1 + "-" + num2 + " = " + toString(sub(nat1,nat2)) + " = " + Integer.toString(realVal(sub(nat1,nat2))));
		System.out.println(num2 + "%" + num1 + " = " + toString(mod(nat2,nat1)) + " = " + Integer.toString(realVal(mod(nat2,nat1))));
		System.out.println(num1 + "%" + num2 + " = " + toString(mod(nat1,nat2)) + " = " + Integer.toString(realVal(mod(nat1,nat2))));
		System.out.println(num2 + "/" + num1 + " = " + toString(div(nat2,nat1)) + " = " + Integer.toString(realVal(div(nat2,nat1))));
		System.out.println(num1 + "/" + num2 + " = " + toString(div(nat1,nat2)) + " = " + Integer.toString(realVal(div(nat1,nat2))));
	}
}