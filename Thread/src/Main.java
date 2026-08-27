//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Runnable runnable=()->{
            for (int i=1;i<6;i++){
                System.out.println(Thread.currentThread().getName()+" : "+i);
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }

            }
        };

        Thread thread=new Thread(runnable,"Worker-1");
        Thread thread1=new Thread(runnable,"Worker-2");
        thread.start();
        thread1.start();
        try{
            thread1.join();
            thread.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }


    }
}