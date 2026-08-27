import java.util.concurrent.Callable;

public class CallableTask {
    public static void main(String[] args) {
        Callable<Integer> callable=()->{
            int sum=0;
            for (int i=1;i<=100;i++){
                sum+=i;
            }
            return sum;
        };
        try {
            Integer sum=callable.call();
            System.out.println(sum);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
