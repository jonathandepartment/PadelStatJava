package logic;

import java.io.*;

public class TestDrive implements Serializable {
    private int width;
    private int height;

    public void setWidth(int w){
        width = w;
    }
    public void setHeight(int h){
        height = h;
    }
    public static void main(String[] args) {
        TestDrive testDrive;
        try {
            FileInputStream fileStream = new FileInputStream("foo.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            Object test = os.readObject();
            testDrive = (TestDrive) test;
            os.close();
            //System.out.println("Success! " + testDrive.height);

        } catch (Exception e) { e.printStackTrace(); }


    }

    public void saveFile() {
        TestDrive test = new TestDrive();
        test.setWidth(50);
        test.setHeight(20);

        try {
            FileOutputStream fs = new FileOutputStream("foo.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(test);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
