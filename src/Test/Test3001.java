package Test;

// 导入JavaFX相关类
import javafx.application.Application;  // JavaFX应用程序的基类
import javafx.scene.Scene;  // JavaFX场景，包含所有UI元素
import javafx.scene.control.ScrollPane;  // 滚动面板，用于容纳超出显示区域的内容
import javafx.scene.control.TextArea;  // 文本区域，用于显示多行文本
import javafx.stage.Stage;  // JavaFX的顶级容器（窗口）

public class Test3001 extends Application {

	// 重写Application类的start方法，这是JavaFX应用的入口点
	@Override
	public void start(Stage primaryStage) throws Exception {
		TextArea ta = new TextArea();  // 创建文本区域对象，用于显示最终结果
		ta.setWrapText(true);  // 设置文本自动换行
		ScrollPane sp = new ScrollPane(ta);  // 创建滚动面板，并将文本区域放入其中
		StringBuffer sb = new StringBuffer();  // 创建字符串缓冲区，用于多线程环境下安全地拼接字符串
		
		int times1 = 100;  // 定义第一个线程执行的次数（100次）
		char a = 'a';  // 定义第一个线程要添加的字符
		
		// 创建第一个线程，使用Lambda表达式定义线程任务
		Thread thread1 = new Thread(() -> {
			for(int i = 0; i < times1; i++) {
				sb.append(a);  // 向字符串缓冲区添加字符'a'
				try {
					Thread.sleep(5);  // 线程休眠5毫秒，模拟耗时操作
				} catch (InterruptedException e) {  // 捕获中断异常
					e.printStackTrace();  // 打印异常信息
				}
			}
		});
		
		int times2 = 100;  // 定义第二个线程执行的次数（100次）
		char b = 'b';  // 定义第二个线程要添加的字符
		
		// 创建第二个线程，使用Lambda表达式定义线程任务
		Thread thread2 = new Thread(() -> {
			for(int i = 0; i < times2; i++) {
				sb.append(b);  // 向字符串缓冲区添加字符'b'
				try {
					Thread.sleep(5);  // 线程休眠5毫秒
				} catch (InterruptedException e) {  // 捕获中断异常
					e.printStackTrace();  // 打印异常信息
				}
			}
		});
		
		int num = 100;  // 定义第三个线程执行的次数（100次）	
		
		// 创建第三个线程，使用Lambda表达式定义线程任务
		Thread thread3 = new Thread(() -> {
			for(int i = 1; i <= num; i++) {
				sb.append(i);  // 向字符串缓冲区添加当前数字
				try {
					Thread.sleep(5);  // 线程休眠5毫秒
				} catch (InterruptedException e) {  // 捕获中断异常
					e.printStackTrace();  // 打印异常信息
				}
			}
		});

		thread1.start();  // 启动第一个线程
		thread2.start();  // 启动第二个线程
		thread3.start();  // 启动第三个线程
		
		thread1.join();  // 等待第一个线程执行完毕
		thread2.join();  // 等待第二个线程执行完毕
		thread3.join();  // 等待第三个线程执行完毕
		
		ta.setText(sb.toString());  // 将字符串缓冲区的内容转换为字符串并显示在文本区域中
		
		Scene scene = new Scene(sp,450,200);  // 创建场景，设置宽450，高200
		primaryStage.setTitle("ShowImage");  // 设置窗口标题
		primaryStage.setScene(scene);  // 将场景添加到窗口中
		primaryStage.show();  // 显示窗口

	}

	// 程序的主入口方法
	public static void main(String[] args) {
		launch(args);  // 启动JavaFX应用程序，调用start方法
	}

}