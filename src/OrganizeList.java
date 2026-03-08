import java.util.ArrayList;

public class OrganizeList {
    public static String run(ArrayList<String> todoList){
        StringBuilder organizedList = new StringBuilder();
        for (int i = 0; i < todoList.size(); i++) {
            organizedList.append(i + 1).append(". ").append(todoList.get(i));
            if (i < todoList.size()-1){
                organizedList.append("\n");
            }
        }
        return organizedList.toString();
    }
}
