import java.util.Scanner;
import java.util.ArrayList;

void main() {
    Scanner in = new Scanner(System.in);

    ArrayList<String> todoList = new ArrayList<>();


    //Valid commands besides 'stop'
    String[] validCommands = {
            "help",
            "list",
            "add",
            "remove",
            "stop"
    };

    while (true){
        System.out.flush();
        System.out.print("> ");
        String command = in.nextLine().toLowerCase();
        //If command is 'stop' then breaks out of loop
        if (command.equals("stop")){
            System.out.println("Stopping...");
            break;
        }
        boolean isValidCommand = false;
        //Loops through all commands and checks if it's valid
        for (String cmd : validCommands){
            if (command.equals(cmd)) {
                isValidCommand = true;
                break;
            }
        }
        //If it's a valid command, handles this
        if (isValidCommand){
            String[] input = HandleInputs.run(command, validCommands, todoList, in);
            if (!input[0].isEmpty()){ //Makes sure it's not empty
                if (!input[0].equals("error")){
                    //Checks scenarios to see what to do
                    if (input[1].equals("add")){
                        todoList.add(input[0]);
                        System.out.println("Successfully added \"" + input[0] + "\" to the list.");
                    }
                    if (input[1].equals("remove")){
                        int index = Integer.parseInt(input[0]) - 1;
                        String removedItem = todoList.get(index);
                        todoList.remove(index);
                        System.out.println("Successfully removed \"" + removedItem + "\" from the list.");
                    }
                }
                else {
                    System.out.println("An error has occurred. Please check your input.");
                }
            }
        } else {
            System.out.println("Not a valid command. Type 'help' to see commands");
        }
    }

}
