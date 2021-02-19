package main.java.com.imooc.concurrent.base;

/**
 * ���������Ϸ��̨
 */
public class Stage extends Thread {

	public void run(){
		
		System.out.println("��ӭ�ۿ���������");
		//�ù����ǰ���Ƭ�̣��ȴ���Ϸ����
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println("��Ļ��������");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("��˵�峯ĩ�꣬�����ũ�������ɱ�û���ڵ�...");
		
		ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
		ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
		
		//ʹ��Runnable�ӿڴ����߳�
		Thread  armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty,"���");
		Thread  armyOfRevolt = new Thread(armyTaskOfRevolt,"ũ�������");
		
		//�����̣߳��þ��ӿ�ʼ��ս
		armyOfSuiDynasty.start();
		armyOfRevolt.start();
		
		//��̨�߳����ߣ����ר�Ĺۿ�������ɱ
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("����˫����ս��������·ɱ���˸���ҧ��");
		
		Thread  mrCheng = new KeyPersonThread();
		mrCheng.setName("��ҧ��");
		
		System.out.println("��ҧ���������ǽ���ս����ʹ���հ�����ҵ��");
		
		//ֹͣ������ս
		//ֹͣ�̵߳ķ���
		armyTaskOfSuiDynasty.keepRunning = false;
		armyTaskOfRevolt.keepRunning = false;
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		 * ��ʷ��Ϸ�����ؼ�����
		 */
		mrCheng.start();
		
		//������Ŀ�������̵߳ȴ������������ʷʹ��
		try {
			mrCheng.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("ս�����������񰲾���ҵ��������ʵ���˻������������룬Ϊ���������˹��ף�");
		System.out.println("лл�ۿ��������壬�ټ���");
		
	}
	
	public static void main(String[] args) {
		new Stage().start();

	}

}
