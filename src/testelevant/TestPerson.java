package testelevant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//测试进入电梯
//使用线程池ExecutorService（personInOrOutService）模拟进（出）电梯
//使用CountDownLatch确认所有人都进入电梯后执行关门操作
public class TestPerson {
	private static ExecutorService personInOrOutService = new ThreadPoolExecutor(2, 2, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory());
	private static CountDownLatch countDownLatch = null;
	public static void main(String[] args) {
		Random random = new Random();
		int personCount = random.nextInt(15)+1;
		countDownLatch = new CountDownLatch(personCount);
		List<Person> persons = new ArrayList<>();
		for(int i=0;i<personCount;i++) {
			persons.add(new Person(i,random.nextInt(200)+1));
		}
		for(int i=0;i<persons.size();i++) {
			final int personIndex = i;
			personInOrOutService.submit(()->{
				Person person = persons.get(personIndex);
				System.out.println("person:"+person.getId()+"开始上电梯需要耗时:"+person.getTimeInMilliSeconds()+"毫秒");
				try {
					//模拟上电梯耗时
					Thread.sleep(person.getTimeInMilliSeconds());
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				System.out.println("person:"+person.getId()+"已经进入电梯");
				countDownLatch.countDown();
			});
		}
		try {
			countDownLatch.await();//主线程等待所有人都上了电梯之后才可以关门
			System.out.println("总共"+personCount+"个人都进入电梯了，可以关门了");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
