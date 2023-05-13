package lab.lecture06_container;

import java.util.Hashtable;
import java.util.UUID;

/**
 * Vector与 Hashtable 自带锁
 * 现在基本不用
 */
public class T01_TestHashtable {
	public static Hashtable<UUID,UUID>m = new Hashtable<>();
	public static int count = Constants.COUNT;
	public static UUID[]keys = new UUID[count];
	public static UUID[]values = new UUID[count];
	public static final int THREAD_COUNT = Constants.THREAD_COUNT;
	//准备测试数据
	static {
		for(int i = 0 ; i < count; i++) {
			keys[i] = UUID.randomUUID();
			values[i] = UUID.randomUUID();
		}
	}


	public static class MyThread extends Thread{
		public int start;
		public int gap = count/THREAD_COUNT;  //每个线程装配数
		
		public MyThread(int start) {
			this.start =  start;
		}
		
		@Override
		public void run() {
			for(int i = start; i < start+gap; i++) {
				m.put(keys[i], values[i]);
			}
		}
	}
	
	

	public static void main(String[] args) {
          long start = System.currentTimeMillis();
          Thread[]threads = new Thread[THREAD_COUNT];
          for(int i =0; i < threads.length;i++) {
        	  threads[i] = new MyThread(i*(count/THREAD_COUNT));
          }
          
          for(Thread t:threads) {
        	  t.start();
          }
          
          for(Thread t:threads) {
        	 try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
          }
          
          long end = System.currentTimeMillis();
          System.out.println(end - start);
          System.out.println(m.size());
          
          //-测试用例2------------------------------
          start = System.currentTimeMillis();
          for(int i = 0; i < threads.length; i++) {
        	  threads[i] = new Thread(()->{
        		  for(int j = 0; j < 1000000;j++) {
        			  m.get(keys[10]);
        		  }
        		  
        	  });
          }

          for(Thread t:threads) {
        	  t.start();
          }
          
          for(Thread t:threads) {
        	 try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          }
          
          
          end = System.currentTimeMillis();
          System.out.println(end - start);
          System.out.println(m.size());
          
	}

}
