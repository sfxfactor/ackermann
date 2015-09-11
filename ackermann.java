public class ackermann {
    public static void main(String[] args){
        int m;
        int n;

        int[][] acks=new int[99999][99999];
        for (m=0;m<1;m++){
            for (n=0;n<1;n++){
                acks = ack(m,n,acks);
                System.out.println("Ack("+m+","+n+")="+acks[m][n]);
            }
        }
    }

    public static int[][] ack(int m,int n, int[][] anot){

        if (anot[m][n]>0){
            return anot;
        }
        else if (m==0){
            anot[m][n]=n+1;
        }
        else if (n==0){
            anot=ack(m-1,1,anot);
            anot[m][n]=anot[m-1][1];
        }
        else{
            anot=ack(m,n-1,anot);
            anot=ack(m-1,anot[m][n-1],anot);
            anot[m][n]=anot[m-1][anot[m][n-1]];
        }
        return anot;
    }
}

