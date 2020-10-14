// Marc Cohen's

public class QueueTest
{
	public static void main(String[] args)
	{
		QueueTest tester = new QueueTest();

		IQueue<Integer> queue = new QueueLL<Integer>();
		tester.test(queue);
	}

	public void test(IQueue<Integer> queue)
	{
		System.out.println("Start tests...");

		// test push, pop, push, pop...
		System.out.println("push, pop, push, pop..."); //peter add
		check(queue.toString().equals("top->"));
		check(queue.isEmpty());
		check(queue.getSize() == 0);

		System.out.println(queue);

		queue.enqueue(10);
		//check(queue.top() == 10);
		check(queue.toString().equals("top->10"));
		check(!queue.isEmpty());
		check(queue.getSize() == 1);

		System.out.println(queue);

		int i = queue.dequeue();
		check(i == 10);
		check(queue.toString().equals("top->"));
		check(queue.isEmpty());
		check(queue.getSize() == 0);

		System.out.println(queue);

		queue.enqueue(10);
		//check(queue.top() == 10);
		check(queue.toString().equals("top->10"));
		check(!queue.isEmpty());
		check(queue.getSize() == 1);

		System.out.println(queue);

		i = queue.dequeue();
		check(i == 10);
		check(queue.toString().equals("top->"));
		check(queue.isEmpty());
		check(queue.getSize() == 0);

		System.out.println(queue);

		// test push, push, push, pop, pop, pop...
		System.out.println("push, push, push, pop, pop, pop..."); //peter add
		check(queue.toString().equals("top->"));
		check(queue.isEmpty());
		check(queue.getSize() == 0);

		System.out.println(queue);

		queue.enqueue(10);
		//check(queue.top() == 10);
		check(queue.toString().equals("top->10"));
		check(!queue.isEmpty());
		check(queue.getSize() == 1);

		System.out.println(queue);

		queue.enqueue(20);
		//check(queue.top() == 20);
		check(queue.toString().equals("top->20->10"));
		check(!queue.isEmpty());
		check(queue.getSize() == 2);

		System.out.println(queue);

		queue.enqueue(30);
		//check(queue.top() == 30);
		check(queue.toString().equals("top->30->20->10"));
		check(!queue.isEmpty());
		check(queue.getSize() == 3);

		System.out.println(queue);

		i = queue.dequeue();
		check(i == 30);
		check(queue.toString().equals("top->20->10"));
		check(!queue.isEmpty());
		check(queue.getSize() == 2);

		System.out.println(queue);

		i = queue.dequeue();
		check(i == 20);
		check(queue.toString().equals("top->10"));
		check(!queue.isEmpty());
		check(queue.getSize() == 1);

		System.out.println(queue);

		i = queue.dequeue();
		check(i == 10);
		check(queue.toString().equals("top->"));
		check(queue.isEmpty());
		check(queue.getSize() == 0);

		System.out.println(queue);

		// check for pop or top on emtpy stack...
		boolean ok = false;
		/*try
		{
			queue.enqueue();
		}
		catch (IllegalStateException e)
		{
			ok = true;
		}
		check(ok);*/

		try
		{
			queue.isEmpty();
		}
		catch (IllegalStateException e)
		{
			ok = true;
		}
		check(ok);

		System.out.println("Success!");
	}

	private static void check(boolean b)
	{
		if (!b)
			throw new AssertionError("Test Failed!");
	}

}
