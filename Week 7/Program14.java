class EvenThread extends Thread {public void run(){for(int i=2;i<=10;i+=2){System.out.println("Thread-A (Even): "+i);try{Thread.sleep(500);}catch(InterruptedException e){Thread.currentThread().interrupt();return;}}}}
class OddThread extends Thread {public void run(){for(int i=1;i<=9;i+=2){System.out.println("Thread-B (Odd): "+i);try{Thread.sleep(500);}catch(InterruptedException e){Thread.currentThread().interrupt();return;}}}}
public class Program14 {public static void main(String[] args){new EvenThread().start();new OddThread().start();}}
