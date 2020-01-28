package com.thread.learning;

public class ThreadExample {

	public static void main(String[] args) {
		HackerThread htt = new HackerThread(new Locker());
		
		Thread thread1 = new Thread(htt);
		Thread thread2 = new Thread(htt);
		Thread thread3 = new Thread(htt);
		
		thread1.setName("Thread1");
		thread1.setName("Thread2");
		thread1.setName("Thread3");
		
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

	private static class HackerThread implements Runnable {
		private Locker locker;

		HackerThread(Locker locker) {
			this.locker = locker;
		}

		public void run() {
			
			for (int i = 100; i < 1000; i++) {
				boolean result = locker.isPasswordValid(i);
				if (result == true) {
					System.out.println("the password is got break : " + i);
					break;
				}
			}
			
			
		}
	}

}
