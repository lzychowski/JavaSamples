import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ForkJoin extends RecursiveTask<Integer> {

    public static final int T = 1000;

    int [] array;
    int start, end;

    public ForkJoin(int [] array, int start, int end){
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer compute(){

        // if below treshold, perform sequential addition
        if (end - start <= T){

            int sum = 0;

            for (int i = start; i < end; ++i){
                sum += array[i];
            }

            return sum;

        } else {

            int middle = start + (end - start) / 2;

            ForkJoin left = new ForkJoin(array, start, middle);
            ForkJoin right = new ForkJoin(array, middle, end);

            left.fork();
            int rightAns = right.compute();
            int leftAns = left.join();

            return leftAns + rightAns;
        }
    }

    static int sum(int [] array){
        return ForkJoinPool.commonPool().invoke(new ForkJoin(array, 0, array.length));
    }
}
