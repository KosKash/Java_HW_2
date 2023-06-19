import java.io.FileWriter;

public class Ex2 {
    public static void main(String[] args) {
        int [] arr = new int [] {5, 4, 6, 1, 3, 2, 7, 9, 8};

        try{

        FileWriter file = new FileWriter("log.txt", true);
        
        file.write("Init \n");   
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    for (int k = 0; k < arr.length; k++) {
                        file.write(arr[k]+ " ");
                    }
                    file.write("\n");
                }

            }
        }
        file.write("Done\n");
        file.close();
        
    }
           
    catch (Exception e) {
        System.out.println("Error");
    }
    }
}
