package Sistem_nilai;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.util.List;
import java.util.Scanner;
import model.Mahasiswa;
import Service.Service_jdbc;

/**
 * Created by gio on 4/21/2017.
 */
public class Sistem_nilai {
    public static void main(String[] args) {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setDatabaseName("tb_nilai?serverTimezone=UTC");
        dataSource.setServerName("localhost");

        dataSource.setPortNumber(3306);

        Service_jdbc service = new Service_jdbc();
        service.setDataSource(dataSource);

        Scanner in = new Scanner(System.in);
        System.out.println("Selamat Datang Di Server Akademik");
        Boolean mainmenu = true;
        while (mainmenu) {
            System.out.println("\nMenu Utama");
            System.out.println("\n1. Data Mahasiswa");
            System.out.println("2. Data Mata Kuliah");
            System.out.println("3. Nilai Mahasiswa");
            System.out.print("\nMasukkan Tujuan  : ");
            String pilihanutama = in.nextLine();
            switch(Integer.parseInt(pilihanutama)) {
                case 1:
                    getMenuMahasiswa(service);
                    break;
                case 2:
                    getMenuMatkul();
                    break;
                case 3:
                    getMenuNilai();
                    break;
                default:
                    break;
            }

        }
    }

    public static void getMenuMahasiswa(Service_jdbc service) {
        Boolean mhsmenu = true;
        Scanner in = new Scanner(System.in);
        while (mhsmenu) {
            System.out.println("\nData Mahasiswa");
            System.out.println("\n1. List Mahasiswa");
            System.out.println("2. Tambah Data Mahasiswa");
            System.out.print("\nMasukkan pilihan : ");
            String pilihanmhs = in.nextLine();
            switch (Integer.parseInt(pilihanmhs)) {
                case 1:
                    List<Mahasiswa> mhsR = service.getAllMahasiswa();
                    if (mhsR.isEmpty()) {
                        System.out.println("\nData Tidak ada (Kosong)");
                        break;
                    }
                    System.out.println("NIM \t | Nama \t\t\t | Tanggal Lahir | Alamat \t\t\t | Email");
                    System.out.println("=============================================================================================");
                    for (Mahasiswa mhs : mhsR) {
                        System.out.println(mhs.getNim() + "\t | " + mhs.getNama() + " \t | " + mhs.getTgllahir() + " | "+ mhs.getAlamat() + "\t\t | " + mhs.getEmail());
                    }
                    break;
                case 2:
                    System.out.print("NIM : ");
                    String npm = in.nextLine();
                    System.out.print("Nama : ");
                    String nama = in.nextLine();
                    System.out.print("Tanggal Lahir (YYYY-MM-DD) : ");
                    String tgllahir = in.nextLine();
                    System.out.print("Alamat : ");
                    String alamat = in.nextLine();
                    System.out.print("Email  : ");
                    String nohp = in.nextLine();
                    System.out.print("Simpan? (Y/N) : ");
                    String tambah = in.nextLine();
                    if (tambah.toLowerCase().equals("y")) {
                        Mahasiswa mhs = new Mahasiswa();
                        mhs.setNim(Integer.parseInt(npm));
                        mhs.setNama(nama);
                        mhs.setTgllahir(tgllahir);
                        mhs.setAlamat(alamat);
                        mhs.setEmail(email);
                        service.save(mhs);
                    }
                    break;
                default:
                    break;
            }

        }
    }

    public static void getMenuMatkul() {

    }

    public static void getMenuNilai() {

    }

}
