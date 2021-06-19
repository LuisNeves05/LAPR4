package eapli.base.ticket.service;

public class SLATable {


        public static void printResult(String[] A) {
            String[] tempA = A[0].split(",");
            int maxLen = tempA.length;
            for(int i = 1;i < A.length;i++) {
                tempA = A[i].split(",");
                if(maxLen < tempA.length)
                    maxLen = tempA.length;
            }
            String[][] valueA = new String[A.length][maxLen];
            for(int i = 0;i < valueA.length;i++)
                for(int j = 0;j < valueA[0].length;j++)
                    valueA[i][j] = "";

            for(int i = 0;i < A.length;i++) {
                tempA = A[i].split(",");
                for(int j = 0;j < tempA.length;j++)
                    valueA[i][j] = tempA[j];
            }
            int[] maxJ = new int[maxLen];
            for(int j = 0;j < maxLen;j++) {
                for(int i = 0;i < A.length;i++) {
                    if(valueA[i][j].length() > maxJ[j])
                        maxJ[j] = valueA[i][j].length();
                }
            }

            StringBuilder opera = new StringBuilder("+");
            for(int j = 0;j < maxJ.length;j++) {
                for(int k = 0;k < maxJ[j];k++)
                    opera.append('-');
                opera.append('+');
            }
            for(int i = 0;i < valueA.length;i++) {
                System.out.println(opera);
                System.out.print("|");
                for(int j = 0;j < valueA[0].length;j++) {
                    int len = maxJ[j] - valueA[i][j].length();
                    String format = "";
                    if(len == 0)
                        format = "" + "%s";
                    else
                        format = "%" + len + "s";
                    System.out.print(valueA[i][j]);
                    System.out.printf(format, "");
                    System.out.print("|");
                }
                System.out.println();
            }
            System.out.println(opera);
            return;
        }

//        public static void main(String[] args) {
//            Main test = new Main();
//            Scanner in = new Scanner(System.in);
//            int n = in.nextInt();
//            in.nextLine();
//            String[] A = new String[n];
//            for(int i = 0;i < n;i++)
//                A[i] = in.nextLine();
//            test.printResult(A);
//        }
    }
