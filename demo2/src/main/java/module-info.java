module com.example.demo2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.apache.logging.log4j;
    requires org.apache.logging.log4j.core;


    opens com.example.demo2 to javafx.fxml;
    exports com.example.demo2;
}