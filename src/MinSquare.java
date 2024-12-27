class MinSquare{
    public static void main(String[] args) {
        In.open("../data/numbers.txt");
        int nLines = In.readInt();
        int nColums = In.readInt();
        int[][] numbers = new int[nLines][nColums];

        for (int line = 0; line < nLines; line++) {
            for (int col = 0; col < nColums; col++) {
                numbers[line][col] = In.readInt();
            }
            // col >= nColums
        }
        // line >= nLines
        In.close();
        int lowestSum = numbers[0][0]+numbers[0][1]+numbers[1][0]+numbers[1][1];
        int[] lowestIdx = new int[]{0,0};
        for (int line = 0; line < nLines; line++) {
            for (int col = 0; col < nColums; col++) {
                if(col+1 < nColums && line+1 < nLines){
                    int tempsum = numbers[line][col]+numbers[line][col+1]+numbers[line+1][col]+numbers[line+1][col+1];
                    if(tempsum<lowestSum){
                        lowestSum = tempsum;
                        lowestIdx[0] = line;
                        lowestIdx[1] = col;
                    }
                }
            }
            // col >= nColums
        }
        // line >= nLines
        StringBuilder sb = new StringBuilder();
        sb.append("Minimum sum "+lowestSum+" found at "+"["+lowestIdx[0]+","+lowestIdx[1]+"]:\n");
        for (int line = 0; line < lowestIdx.length; line++) {
            for (int col = 0; col < lowestIdx.length; col++) {
                sb.append(numbers[lowestIdx[0]+line][lowestIdx[1]+col] + " ");
            }
            // col >= lowestIdx.length
            sb.append("\n");
        }
        // line >= lowestIdx.length
        Out.print(sb.toString());
    }
}