package prog10_2;

public class Rational {
	private int p;
	private int q;

	public int getP() {
		return p;
	}

	public int getQ() {
		return q;
	}

	Rational(int p, int q) {
		this.p = p;
		if (q< 0) {
			throw new ArithmeticException("Denominator cannot be zero");
		}
		this.q = q;
	}

	public int getLcm(int a, int b) {
		int lcm = a > b ? a : b;
		while (true) {
			if (lcm % a == 0 && lcm % b == 0) {
				break;
			}
			++lcm;
		}
		return lcm;
	}

	// adds the rational rat to this Rational
	public Rational add(Rational rat) {
		int lcm = getLcm(rat.getQ(), this.getQ());
		int ratMul = lcm / rat.getQ();
		int thisMul = lcm / this.getQ();

		int newP = rat.getP() * ratMul + this.getP() * thisMul;

		return new Rational(newP, lcm);

	}

	// multiplies rat by this Rational
	public Rational multiply(Rational rat) {

		return new Rational((this.getP() * rat.getP()), (this.getQ() * rat.getQ()));

	}

	public int compareTo(Rational rat) {

		int ratSum = rat.q * this.p;
		int thisSum = this.q * rat.p;

		if (ratSum < thisSum)
			return -1;
		else if (ratSum > thisSum)
			return 1;
		else
			return 0;

	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rational other = (Rational) obj;
		return this.hashCode() == other.hashCode();
	}

	@Override
	public String toString() {
		if (this.q == 0)
			return "" + this.p;

		return this.p + "/" + this.q;

	}

	public static void main(String[] args) {
		Rational a = new Rational(2, 3);
		Rational b = new Rational(-17, 5);
		Rational c = new Rational(1, 3);

		Rational finalX = (a.multiply(b)).add(c);
		Rational finalY = a.multiply(b.add(c));

		if (finalX.compareTo(finalY) == 1) {
			System.out.printf("(%s * %s) + %s is greater than %s * (%s + %s)", a, b, c, a, b, c);
		} else if (finalX.compareTo(finalY) == -1) {
			System.out.printf("(%s * %s) + %s is less than %s * (%s + %s)", a, b, c, a, b, c);
		} else {
			System.out.printf("(%s * %s) + %s is equal to %s * (%s + %s)", a, b, c, a, b, c);
		}

	}
}