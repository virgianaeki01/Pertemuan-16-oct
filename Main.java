import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;



public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("--fetching data Motor");
        m.generateEnkapsulasi("C:/Users/WorkHard/Documents/Java/database/daftarmotor.txt");            
    }

    public void generateEnkapsulasi(String path){
        File file = new File(path);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        List<Enkapsulasi> listEnkapsulasi = new ArrayList<Enkapsulasi>();

            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                dis = new DataInputStream(bis);

                while(dis.available() != 0){
                    String line = dis.readLine();
                    String[] data = line.split(",");

                    Enkapsulasi s = new Enkapsulasi();
                    s.SetNama(data[0]);
                    s.SetPLT(data[1]);
                    s.SetBandepan(data[2]);
                    s.SetBanbelakang(data[3]);
                    s.SetRemdepan(data[4]);
                    s.SetRembelakang(data[5]);
                    s.SetMesin(data[6]);
                    
                    listEnkapsulasi.add(s);
                }

            }catch(Exception e){
                    System.out.println("file"+file.getName()+"Tidak ditemukan");
                    System.out.println("error: "+e.getMessage());
                }

                for(Enkapsulasi s : listEnkapsulasi){   
                    
                    System.out.println("===================");
                    System.out.println("spesifikasi motor :"+s.getNama());
                    System.out.println("Ban depan :"+s.getBandepan());
                    System.out.println("Ban belakang:"+s.getBanbelakang());
                    System.out.println("Rem depan :"+s.getRemdepan());
                    System.out.println("Rem belakang :"+s.getRembelakang());
                    System.out.println("Mesin :"+s.getMesin());

                }            
    }    
}