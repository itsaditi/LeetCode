public static void main (String[] args) {
		float foo = (float)1000000000/99999999;
		double bar = (double)1000000000/99999999;
		
        System.out.println(foo); // 10.0
        System.out.println(bar); // 10.000000100000001
        System.out.println((int) Math.ceil(foo)); //10
        System.out.println((int) Math.ceil(bar)); //11
	}