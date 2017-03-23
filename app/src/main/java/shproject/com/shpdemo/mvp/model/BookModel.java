package shproject.com.shpdemo.mvp.model;

/**
 * Created by xus on 2017/3/23.
 */

/**
 * mvp模式
 * model类
 * 主要负责对象模型抽象成代码
 * 此处用书籍来说明
 */
public class BookModel {
    private String name;//书本名称
    private String pageSize;//页数
    private String aother;// 作者

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getAother() {
        return aother;
    }

    public void setAother(String aother) {
        this.aother = aother;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "name='" + name + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", aother='" + aother + '\'' +
                '}';
    }
}
