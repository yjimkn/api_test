package apitest;

public class pojo {
    public class API{
        private String id;
        private String name;
        private String type;
        private String url;
        private String contentType;

        public API() {
            super();
        }
        public API(String id,String name,String type,String url,String contentType){

        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        @Override
        public String toString() {
            return "API{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", url='" + url + '\'' +
                    ", contentType='" + contentType + '\'' +
                    '}';
        }
    }
}
