/**
 *
 * @author Mark Alexander
 * ID: 20112145
 */
package assignment_2;

public class NewQuiz {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view, model);
        model.addObserver(view);
    }
    
}
