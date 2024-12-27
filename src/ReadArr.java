import java.util.Arrays;

public class ReadArr{

    public static void main(String[] args){

        int[] arr = new int[1];
        int counter = 0;
        StringBuilder sb = new StringBuilder();

        Out.println("Please enter integer numbers, followed by an 'x':");
        while(In.done()){
            arr[counter] = In.readInt();
            counter++;
            if(arr.length==counter){
                int[] temparr = new int[arr.length*2];
                for(int i = 0; i < arr.length; i++){
                    temparr[i] = arr[i];
                }
                // i >= arr.length
                arr = temparr;
            }
        }
        // In.done() == false
        counter--; //adjust the counter to remove the wrongly added count for x because of !In.done()
        sb.append("Array length: "+arr.length+"\n");
        sb.append("Read numbers: "+counter+"\n");
        sb.append("Array content (using Arrays.toString(): "+Arrays.toString(arr)+"\n");
        sb.append("Array content (using loop): ");
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            if(i<counter)
                sb.append(arr[i]+", ");
        }
        // i >= arr.length
        
        sb.delete(sb.length()-2, sb.length());
        sb.append("]");

        Out.print(sb.toString());
    }
}