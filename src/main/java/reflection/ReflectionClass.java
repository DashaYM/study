package reflection;

@MyAnnotation(value = 12)
public class ReflectionClass {

    private String fieldA = "field1String";

    private String fieldB = "field2String";

    public ReflectionClass(String fieldA, String fieldB) {
        this.fieldA = fieldA;
        this.fieldB = fieldB;
    }

    public String getFieldA() {
        return fieldA;
    }

    public ReflectionClass setFieldA(String fieldA) {
        this.fieldA = fieldA;
        return this;
    }

    public String getFieldB() {
        return fieldB;
    }

    public ReflectionClass setFieldB(String fieldB) {
        this.fieldB = fieldB;
        return this;
    }
}
