class SuperClass {
	private int privateData;
	public int publicData = 1;

	public int getPrivateData() { 
		privateData = privateMethod();
		return privateData;
	}
	private int privateMethod() {
		return 10;
	}
}

class SubClass extends SuperClass {
	public int getData() {
		this.publicData  = 100;
		return publicData;
	}
}

class Main {
    public static void main(String[] args) {
        SuperClass sc = new SuperClass();
		int temp = sc.getPrivateData();
		System.out.println(temp);

		SubClass sub = new SubClass();
		temp = sub.publicData; // access the inherited field directly
		System.out.println(temp);
		temp = sub.getData(); // call the public method
		System.out.println(temp);
		temp = sub.getPrivateData(); // call the inherited method
		System.out.println();
    }
}
