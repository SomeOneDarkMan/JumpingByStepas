package JumpAlgorithm;
import java.util.Arrays;
public class NumberOfWay {




        public static int sum(int steps,int moveSteps,int[] mass){
            if(steps==0|steps==1){
                return steps;
            }
            Arrays.fill(mass,-1);
            mass[0]=0;
            mass[1]=1;
            mass[2]=2;

            try {


                for (int i = 0; i <= moveSteps; i++) {
                    int sum = 0;
                    if (mass[i] != -1) {
                        continue;
                    }
                    for (int b = 1; b < i; b++) {
                        sum = sum + mass[i - b];
                    }
                    sum++;
                    mass[i] = sum;
                }
            }catch (ArrayIndexOutOfBoundsException e){
                return mass[steps-1];
            }
            //-------------------------------------------------------
            for (int i=1;i<=steps;i++){
                int sum=0;
                if(mass[i]!=-1){
                    continue;
                }
                for(int b=1;b<=moveSteps;b++){
                    sum=sum+mass[i-b];
                }

                mass[i]=sum;
            }








            return mass[steps-1]; //если стоим на первой , то просто значение будет на 1 меньше,А мы стоим на первой по условию

        }
        public static void main(String[] args) {
            int steps=7;
            int n=7;
            int [] mass=new int[steps+1];

            System.out.println(sum(steps,n,mass));
        }
    }

