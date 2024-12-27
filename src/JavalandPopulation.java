class JavalandPopulation{
    public static void main(String[] args) {
        int[] population = new int[1];
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        Out.println("Please enter integer numbers, followed by an 'x':");
        while(In.done()){
            if(population.length==counter){
                int[] temparr = new int[population.length*2];
                for(int i = 0; i < population.length; i++){
                    temparr[i] = population[i];
                }
                // i >= population.length
                population = temparr;
            }
            population[counter] = In.readInt();
            counter++;
        }
        // In.done() == false
        counter--; // to adjust the wrongly added count for x 
        if(counter<2){
            Out.println("Not enough values provided");
            return;
        }
        int[] arr = new int[population.length];
        int maxIdx = 0;
        for (int i = 0; i < population.length; i++) {
            if(i<counter-1){ //counter -1 to not make the differenze from x value (=0) - the last val
                arr[i] = population[i+1]-population[i];
                if(arr[maxIdx]<arr[i]){
                    maxIdx = i;
                }
            }
        }
        // i >= population.length
        int lastDifferenzIndex = counter-2;
        sb.append("Population difference from the first to the second year: "+arr[0]+"\n");
        sb.append("Population difference from second-to-last to last year: "+arr[lastDifferenzIndex]+" at index "+(lastDifferenzIndex)+"\n");
        sb.append("Maximum population difference in a year: "+arr[maxIdx]+" at index "+maxIdx+"\n");
        Out.print(sb.toString());
    }
}