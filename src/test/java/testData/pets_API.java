package testData;

import java.util.List;

public class pets_API {

    public Integer id;
    public Category category;
    public String name;
    public String photoUrls;
    public Tag tags;
    public String status;

    public class Category {

        public Integer id;
        public String name;
        
    }

    public class Tag {

        public Integer id;
        public String name;
        
    }

}
