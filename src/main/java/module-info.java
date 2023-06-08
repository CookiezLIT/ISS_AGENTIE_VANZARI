module com.example.iss_vanzari_versiunea2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;
    requires java.sql;

    opens com.example.iss_vanzari_versiunea2 to javafx.fxml;
    opens com.example.iss_vanzari_versiunea2.model to org.hibernate.orm.core;

    exports com.example.iss_vanzari_versiunea2;
    exports com.example.iss_vanzari_versiunea2.model;
    exports com.example.iss_vanzari_versiunea2.repository;

}