module com.project {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.project to javafx.fxml;
    exports com.project;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires org.assertj.core;

    exports com.project.model.Object;
    
}