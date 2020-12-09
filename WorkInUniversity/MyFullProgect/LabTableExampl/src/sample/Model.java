package sample;
import javafx.beans.property.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
        private StringProperty kind;
        private IntegerProperty age;
        private StringProperty name;

        public Model(String kind, int age, String name) {
            this.name = new SimpleStringProperty(name);
            this.age = new SimpleIntegerProperty(age);
            this.kind = new SimpleStringProperty(kind);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public StringProperty nameProperty() {
            return name;
        }

        public String getKind() {
            return kind.get();
        }

        public void setKind(String kind) {
            this.kind.set(kind);
        }

        public StringProperty KindProperty() {
            return kind;
        }

        public int getAge() {
            return age.get();
        }

        public void setAge(int age) {
            this.age.set(age);
        }

        public IntegerProperty ageProperty() {
            return age;
        }

    }


