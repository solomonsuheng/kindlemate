package io.kindlemate;

import io.kindlemate.info.Kindle;

import java.io.FileNotFoundException;

/**
 * Created by Suheng on 5/4/16.
 */
public class KindleMate {

    public static void main(String[] args) throws FileNotFoundException {

        Kindle kindle = Kindle.getKindleInstance();
        if (kindle.getKindle_root_path() == null || kindle.getKindle_root_path() == "") {
        } else {
            listBookMark(kindle);
        }
    }


    public static void listBookMark(Kindle kindle) {
        System.out.println(kindle.getKindleMyClippingPath());
        System.out.println(kindle.getKindleVersionPath());
    }
}
