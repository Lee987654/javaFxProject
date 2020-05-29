package collections;

interface Runnable<T> {
	public void run(T t);

	void run(String str);
}

class Car implements Runnable<Integer> {
	@Override
	public void run(String str) {
		System.out.println("�ڵ��� �޸���.");
		
	}

	@Override
	public void run(Integer t) {
		// TODO Auto-generated method stub
		
	}
}

class Bus implements Runnable <Integer> {

	@Override
	public void run() {
		System.out.println("���� �޸���.");
	}

	@Override
	public void run(Integer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run(String str) {
		// TODO Auto-generated method stub
		
	}
	
}
public class ImplementsClass {
	// �޼ҵ� ����.
	
	public static void callRun(Runnable<String> runnable) {
		runnable.run("Hello");
	}
	
	public static void main(String[] args) {
		Runnable<Integer> runnable = new Car();
		runnable.run("Car");
		runnable = new Bus<>();
		runnable.run("Bus");
		runnable = (str) -> System.out.println("�͸� ��ü �޸��ϴ�.");
		runnable.run("Run");
			
		callRun(new Car());
		callRun((str) -> 
		System.out.println("�޼ҵ� �Ű��� �޸��ϴ�."));
	}
}
		
