package io.kindlemate.info;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Suheng on 5/4/16.
 */
public class Kindle {

    private static String KINDLE_PATH_IN_MACOS = "/Volumes";
    private String kindle_root_path;

    private static Kindle kindle;
    //用于存方Kindle常用文件路径
    static Map<String, String> kindleInfoPath = new HashMap<String, String>();

    static {
        kindleInfoPath.put("system_version", "/system/version.txt");
        kindleInfoPath.put("my_clippings", "/My Clippings.txt");
        kindleInfoPath.put("documents", "/documents");
    }

    private Kindle(String path) {
        kindle_root_path = path;
    }

    public static Kindle getKindleInstance() {
        if (kindle == null) {
            String checkPath = kindleInfoPath.get("system_version");
            kindle = new Kindle(initKindle(checkPath));
        }
        return kindle;
    }

    private static String initKindle(String checkPath) {
        File file = new File(KINDLE_PATH_IN_MACOS);
        String[] filesNames = file.list();

        for (String name : filesNames) {
            file = new File(KINDLE_PATH_IN_MACOS + "/" + name + checkPath);
            if (file.exists()) {
                return KINDLE_PATH_IN_MACOS + "/" + name;
            }
        }

        return "";
    }


    public String getKindleMyClippingPath() {
        if (this.kindle_root_path == null || this.kindle_root_path == "") {
            return "";
        } else {
            return this.kindle_root_path + kindleInfoPath.get("my_clippings");
        }
    }

    public String getKindle_root_path() {
        return kindle_root_path;
    }

    public String getKindleVersionPath() {
        if (this.kindle_root_path == null || this.kindle_root_path == "") {
            return "";
        } else {
            return this.kindle_root_path + kindleInfoPath.get("system_version");
        }
    }

}
