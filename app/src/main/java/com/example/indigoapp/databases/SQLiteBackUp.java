package com.example.indigoapp.databases;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SQLiteBackUp {
    Context context;
    String packageName="com.example.indigoapp";
    String folderName = "IndigoApp";

    public SQLiteBackUp(Context context){
        this.context = context;
    }

    public boolean checkIsEmpty(){
        File folder = new File(Environment.getExternalStorageDirectory() + "/"+folderName+"");
        String[] children = folder.list();
//		System.out.println("FILE COUNT : "+children.length);

        if(children.length>0) {
            emptyFolder();
            return true;
        }else {
            exportDB();
            return false;
        }
    }



    //@SuppressWarnings("resource")
    //public void importDB(String name) {
    //    try {
    //        File sd = Environment.getExternalStorageDirectory();
    //        File data = Environment.getDataDirectory();
    //            if (sd.canWrite()) {
    //            String currentDBPath = "//data//" + packageName+ "//databases//" + DATABASE_NAME+"";
    //            String backupDBPath ="//DB_BACKUP//"+name; // From SD directory.
    //            File backupDB = new File(data, currentDBPath);
    //            File currentDB = new File(sd, backupDBPath);
    //
    //        FileChannel src = new FileInputStream(currentDB).getChannel();
    //        FileChannel dst = new FileOutputStream(backupDB).getChannel();
    //        dst.transferFrom(src, 0, src.size());
    //        src.close();
    //        dst.close();
    //        Toast.makeText(context, "Import Successful!",  Toast.LENGTH_SHORT).show();
    //
    //    }
    //
    //    } catch (Exception e) {
    //		Log.v("Error ", e.toString());
    //	    Toast.makeText(context, "Import Failed!", Toast.LENGTH_SHORT).show();
    //    }
    //}

    @SuppressWarnings("resource")
    public void exportDB() {
        try {

            File folder = new File(Environment.getExternalStorageDirectory() + "/"+folderName+"");
            boolean success = true;
            if (!folder.exists()) {
                success = folder.mkdir();
            }
            if (success) {
                DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd_HH mm ss");
                Date date = new Date();
                System.out.println(dateFormat.format(date));

                File sd = Environment.getExternalStorageDirectory();
                File data = Environment.getDataDirectory();

                if (sd.canWrite()) {
                    String currentDBPath = "//data//" + packageName
                            + "//databases//" + DbHelper.DATABASE_NAME;
                    String backupDBPath = "//"+folderName+"//backupname_"+dateFormat.format(date).toString()+".db"; // From SD directory.
                    File currentDB = new File(data, currentDBPath);
                    File backupDB = new File(sd, backupDBPath);

                    FileChannel src = new FileInputStream(currentDB).getChannel();
                    FileChannel dst = new FileOutputStream(backupDB).getChannel();
                    dst.transferFrom(src, 0, src.size());
                    src.close();
                    dst.close();
                    Toast.makeText(context, "Backup Successful!",Toast.LENGTH_SHORT).show();
                }
            }else {
                // Do something else on failure
                Toast.makeText(context, "Backup Failed!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Log.e("error", e.toString());
            Toast.makeText(context, "Backup Failed!", Toast.LENGTH_SHORT).show();
        }
    }

    public void emptyFolder(){

        File dir = new File(Environment.getExternalStorageDirectory() + "//"+folderName+"");
        if (dir.isDirectory())
        {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++)
            {
                new File(dir, children[i]).delete();
            }
        }
    }

    public boolean checkFolderExists() {

        File f = new File(Environment.getExternalStorageDirectory() + "//"+folderName+"");
        if (f.exists()) {
            return true;
        }
        else
            return false;
    }
}
