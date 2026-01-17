import java.util.ArrayList;

public class WishHistory {

    private Info info;
    private ArrayList<WishItem> list;

    public class Info {
        private String uid;
        private String lang;
        private String export_time;
        private long export_timestamp;
        private String export_app;
        private String export_app_version;
        private String uigf_version;

        public String getUid() {
            return uid;
        }
        public String getLang() {
            return lang;
        }
        public String getExport_time() {
            return export_time;
        }
        public long getExport_timestamp() {
            return export_timestamp;
        }
        public String getExport_app() {
            return export_app;
        }
        public String getExport_app_version() {
            return export_app_version;
        }
        public String getUigf_version() {
            return uigf_version;
        }

    }

    public Info getInfo() {
        return info;
    }
    public ArrayList<WishItem> getList() {
        return list;
    }

}
