import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class HandleInputs {
    public static String[] run(String command, String[] commandList, ArrayList<String> todoList, Scanner in){
        String OrganizedList = OrganizeList.run(todoList);

        if (command.equals("help")){
            System.out.println("Valid commands:");
            System.out.println(Arrays.toString(commandList));
        } else if (command.equals("list")) {
            if (todoList.isEmpty()){
                System.out.println("No tasks to view. Use 'add' to add a task to the list.");
            }
            else {
                System.out.println(OrganizedList);
            }
        } else if (command.equals("add")) {
            System.out.println("What would you like to add?");
            System.out.print("> ");
            //Returns the next thing they add (e.g. Wash Car)
            return new String[]{in.nextLine(), "add"};
        } else if (command.equals("remove")) {
            System.out.println(OrganizedList);
            System.out.println("What would you like to remove? (please use the number)");
            System.out.print("> ");
            //Returns the next thing they add (e.g. Wash Car)
            String result = in.nextLine();
            //Checks if what they typed is a number
            try {
                int num = Integer.parseInt(result);
                return new String[]{result, "remove"};
            } catch (NumberFormatException e){
                return new String[]{"error"};
            }
        }
        return new String[]{""};
    }

}
