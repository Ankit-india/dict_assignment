import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("list.txt");
        Scanner sc = new Scanner(file);
        Dictionary dictionary = new Dictionary();
        while(sc.hasNextLine()) {
            dictionary.insert(sc.nextLine());
        }

        int wannaSearch = 1;
        sc = new Scanner(System.in);
        while(wannaSearch != 0) {
            System.out.print("Please enter your word here : ");
            String word = sc.next();
            System.out.println(dictionary.search(word));
            System.out.print("Do you want to search again in the dictionary ? \nThen press 1 otherwise press 0 : ");
            wannaSearch = sc.nextInt();
        }
        sc.close();
    }
}