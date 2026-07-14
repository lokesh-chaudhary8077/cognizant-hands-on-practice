//MODEL
// The Model represents the data layer. It contains only properties, 
// getters, and setters, completely blind to how the UI looks.
class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}

//VIEW
// The View represents the presentation layer. It is only responsible 
// for formatting and displaying data to the console/user screen.
class StudentView {
    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("============= STUDENT RECORD =============");
        System.out.println("ID    : " + studentId);
        System.out.println("Name  : " + studentName);
        System.out.println("Grade : " + studentGrade);
        System.out.println("==========================================");
    }
}

//CONTROLLER
// The Controller binds the Model and the View together. It intercepts 
// requests, updates the model, and instructs the view to render.
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    // Control operations for Student Name
    public void setStudentName(String name) {
        model.setName(name);
    }
    public String getStudentName() {
        return model.getName();
    }

    // Control operations for Student ID
    public void setStudentId(String id) {
        model.setId(id);
    }
    public String getStudentId() {
        return model.getId();
    }

    // Control operations for Student Grade
    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }
    public String getStudentGrade() {
        return model.getGrade();
    }

    // Directs the view to refresh its display using the current model state
    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

//CLIENT
public class MVCPatternExample {
    public static void main(String[] args) {
        // Fetch/Initialize a student record from our simulated backend (Model)
        Student model = new Student("Vivek Kumar", "GLA-2023-08", "A");

        // Create a clean user interface instance (View)
        StudentView view = new StudentView();

        // Initialize the controller to link the data layer and presentation layer
        StudentController controller = new StudentController(model, view);

        System.out.println("Initial data rendering:\n");
        controller.updateView();

        System.out.println("\nUpdating student record through the Controller...\n");
        
        // Update the data using the controller's exposed routes
        controller.setStudentName("Vivek Kumar (Updated)");
        controller.setStudentGrade("A+");

        // Render the view again to display updated states
        controller.updateView();
    }
}