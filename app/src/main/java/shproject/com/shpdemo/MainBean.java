package shproject.com.shpdemo;

/**
 * Created by xus on 2017/3/22.
 */

public class MainBean {
    public MainBean(String name, Class aClass) {
        this.name = name;
        this.aClass = aClass;
    }

    private String name;
    private  Class aClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}
