package intv;

import java.util.ArrayList;
import java.util.List;

public class Hello {

    /**
     * input1 arr[]  {2, 3, 4, 2}
     * input2 = length of sub array 2
     *
     * result (2, 3), (3, 4), (4, 2)
     */

    private boolean isPerfectFactorial(int number){
        // edge cases
        if(number == 1 || number == 0)
            return true;

        int curr = 2;
        boolean ans = true;
        while(number > 1){
            if(number%curr == 0){
                number = number/curr;
                curr += 1;

            }else{
                ans = false;
                break;
            }
        }
        return ans;

    }



    public List<List<Integer>> getAllPerfectFactSubArray(int[] arr, int size){
        List<List<Integer>> ansArr = new ArrayList<>();

        if(size > arr.length)
            return ansArr;

        // traverse over first k element
        int currSum = 0;
        List<Integer> currArr = new ArrayList<>();
        for(int i=0;i<Math.min(arr.length, size);i++){
            currSum += arr[i];
            currArr.add(arr[i]);

        }

        if(isPerfectFactorial(currSum)){
            ansArr.add(currArr);
        }

        // go to the original one starting from index 1
        for(int i=size;i<=arr.length-size;i++){
            currSum -= arr[i-size];
            currArr.remove(0);
            currSum += arr[i];
            currArr.add(arr[i]);

            if(isPerfectFactorial(currSum)){
                ansArr.add(new ArrayList<>(currArr));
            }
        }


        return ansArr;

    }


    /**
     *
     * @param args 72(n)
     *  1 - start for x in  [1 - n]
     *             i = 1
     *             1.1 if 72 is divisible by 1 then
     *                      check 72 in prefect square or not (yes, return i)
     *             1.2 i++
     *               72 = 2*2*2*3*3*3*3*3  (2, 3) (3, 2)
     *
     *              71  = 1*71
     *
     *             1,2,3,4,5,6,7,8,9
     *
     *            56
     *
     *
     *
     *
     *
     *             perfectSquareChecker(72)
     *                  i = 1
     *                  while(i * i <= 72){
     *                          if(i*i == 72)
     *                              return true
     *                          i++;
     *
     *
     *                  }
     *
     *                  return false
     *
     */



    public static void main(String[] args) {
        System.out.println('S'+'H'+'I'+'V'+'A');
    }
}
