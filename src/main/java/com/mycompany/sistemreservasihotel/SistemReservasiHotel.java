package com.mycompany.sistemreservasihotel;
import java.util.*;
public class SistemReservasiHotel {
    static int kode;
    static String nama, alamat, ktp, hp;
    static int jawaban, pilih;
    
     public static void main(String[] args) {
        //buat scanner untuk input data
        do {
            menu();
        } while (pilih != 4);//while disini melakukan perulangan sebanyak 3 kali
    }
      public static void menu() {
       Scanner masukan = new Scanner(System.in);
        System.out.println("---------------------------------------------------------");
        System.out.println("                    ....MENU UTAMA....                   ");
        System.out.println("---------------------------------------------------------");
        System.out.println("  1. Data Kamar");
        System.out.println("  2. Data Penyewa");
        System.out.println("  3. Data Transaksi");
        System.out.println("  4. keluar");
        System.out.print(" Masukan pilihan : ");//disini untuk memasukkan pilihan angka diatas
        pilih = masukan.nextInt();
        switch (pilih) {
                case 1:
                    datakamar();
                    break;
                case 2:
                    datapenyewa();
                    break;
                case 3:
                    datatransaksi();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
            }
      }
         public static void datakamar () {
            System.out.println("---------------------------------------------------------");
            System.out.println("                 ....TYPE KAMAR....                      ");
            System.out.println("---------------------------------------------------------");
            System.out.println("NO |    TYPE    |ISI|KETERSEDIAN|          HARGA         ");
            System.out.println("1. |   SINGLE   | T |     Y     | RP. 175.000,- per malam");
            System.out.println("2. |   DOUBLE   | T |     Y     | RP. 225.000,- per malam");
            System.out.println("3. |   SUITE    | T |     Y     | RP. 300.000,- per malam");
            System.out.println("---------------------------------------------------------");
            System.out.println("                 ....DATA KAMAR....                      ");
            System.out.println("Total Semua Kamar   : 50");
            System.out.println("Total Kamar Kosong  : 50");
            System.out.println("Total Kamar Isi     : 0");
            System.out.println("DATA KAMAR KOSONG   : - Single  : 30");
            System.out.println("                      - Double  : 10");
            System.out.println("                      - Suite   : 10");
        }
          private static void datapenyewa() {
            Scanner masukan = new Scanner(System.in);
            System.out.println("                      DATA PENYEWA                       ");
            System.out.println("---------------------------------------------------------");
            System.out.print("Masukkan Nama Anda        : ");
            nama = masukan.next();
            System.out.print("Masukkan Alamat Anda      : ");
            alamat = masukan.next();
            System.out.print("Masukkan NO KTP/SIM Anda  : ");
            ktp = masukan.next();
            System.out.print("Masukkan NO Telepon Anda  : ");
            hp = masukan.next();
            System.out.println(" PILIH KAMAR : ");
            System.out.println(" 1. Single  : Rp. 175.000,- per malam");
            System.out.println(" 2. Double  : Rp. 225.000,- per malam");
            System.out.println(" 3. Suite   : Rp. 300.000,- per malam");
            System.out.print("Pilih kode kamar [1/2/3] : ");
            kode = masukan.nextInt();
        }
          private static void datatransaksi () {

            //buat scanner buat  input data
            Scanner masukan = new Scanner(System.in);
            int single = 175000, db = 225000, st = 300000;
            int total = 0, kembali, sewa;
            System.out.println("---------------------------------------------------------");
            System.out.println("                      DATA TRANSAKSI                     ");
            System.out.println("---------------------------------------------------------");
            System.out.println("  INPUT DATA PENYEWA                                     ");
            System.out.println("Nama                : " + nama);
            System.out.println("Alamat              : " + alamat);
            System.out.println("NO KTP/SIM          : " + ktp);
            System.out.println("NO Telepon          : " + hp);
            System.out.println("");
            System.out.println("# Pembayaran");
            if (kode == 1) { 
                System.out.println("Kamar yang di pesan : Single");
                System.out.println("Harga Sewa          : Rp. " + single + " per malam");
                System.out.print("Lama Sewa           : ");
                sewa = masukan.nextInt();
                total = sewa * single;
            }  
            else if (kode == 2) {
                System.out.println("Kamar yang di pesan : Double");
                System.out.println("Harga Sewa          : Rp. " + db + " per malam");
                System.out.print("Lama Sewa           : ");
                sewa = masukan.nextInt();
                total = sewa * db;
            } else if (kode == 3) {
                System.out.println("Kamar yang di pesan : Suite");
                System.out.println("Harga Sewa          : Rp. " + st + " per malam");
                System.out.print("Lama Sewa           : ");
                sewa = masukan.nextInt();
                total = sewa * st;
            }
            else {
                System.out.println("Kode Yang Di Masukkan Salah");
            }
            System.out.println("Total Bayar         : Rp. " + total);
            System.out.print("Bayar               : Rp. ");
            int bayar = masukan.nextInt();
            kembali = bayar - total;
            System.out.println("Kembalian           : Rp. " + kembali);
            System.out.println("==========================================================");
            System.out.println("                  T E R I M A  K A S I H                  ");
            System.out.println("           S E L A M A T  B E R I S T I R A H A T         ");
            System.out.println("==========================================================");
            System.out.println("Apakah anda ingin pesan kembali atau keluar? [Y/T] : ");
            System.out.println("1 : Untuk pesan kembali?");
            System.out.println("2 : Keluar");
            System.out.print("Pilih : ");
            jawaban = masukan.nextInt();
              switch (jawaban) {
                  case 1:
                      menu();
                      break;
                  case 2:
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                    System.exit(0);
                    break;
                  default:
                      throw new AssertionError();
              }
        }
}



