
package com.mycompany.sistemreservasihotel2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

record ReservationData(String nama, String alamat, String ktp, String hp, int kodeKamar, int lamaSewa) {}

class Room {
    private int roomNumber;
    private String roomType;
    private boolean isOccupied;

    public Room(int roomNumber, String roomType, boolean isOccupied) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isOccupied = isOccupied;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
public class SistemResrvasiHotel2 {
    static LinkedList<Room> roomList = new LinkedList<>();
    static List<ReservationData> reservations = new ArrayList<>();
    static Queue<ReservationData> reservationQueue = new LinkedList<>();
    static int jawaban, pilih;

    public static void main(String[] args) {
        // initialize room list
        for (int i = 1; i <= 50; i++) {
            roomList.add(new Room(i, "Single", false));
        }

        // buat scanner untuk input data
        do {
            menu();
        } while (pilih != 4); // while disini melakukan perulangan sebanyak 3 kali
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
        System.out.print(" Masukan pilihan : "); // disini untuk memasukkan pilihan angka diatas
        pilih = masukan.nextInt();
        switch (pilih) {
            case 1:
                dataKamar();
                break;
            case 2:
                dataPenyewa();
                break;
            case 3:
                dataTransaksi();
                break;
            case 4:
                System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                System.exit(0);
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan pilih menu yang benar.");
        }
    }

    public static void dataKamar() {
        System.out.println("---------------------------------------------------------");
        System.out.println("                 ....TYPE KAMAR....                      ");
        System.out.println("---------------------------------------------------------");
        System.out.println("NO |    TYPE    |ISI|KETERSEDIAN|          HARGA         ");
        System.out.println("---------------------------------------------------------");
        for (Room room : roomList) {
            System.out.println(room.getRoomNumber() + ". | " + room.getRoomType() + " | " +
                    (room.isOccupied() ? "Y" : "T") + " | " + (room.isOccupied() ? "T" : "Y") +
                    " | RP. " + (room.getRoomType().equals("Single") ? "175.000" :
                    (room.getRoomType().equals("Double") ? "225.000" : "300.000")) + ",- per malam");
        }
        System.out.println("---------------------------------------------------------");
        System.out.println("                 ....DATA KAMAR....                      ");
        System.out.println("Total Semua Kamar   : " + roomList.size());
        System.out.println("Total Kamar Kosong  : " + countAvailableRooms());
        System.out.println("Total Kamar Isi     : " + (roomList.size() - countAvailableRooms()));
        System.out.println("DATA KAMAR KOSONG   : - Single  : " + countAvailableRoomsByType("Single"));
        System.out.println("                      - Double  : " + countAvailableRoomsByType("Double"));
        System.out.println("                      - Suite   : " + countAvailableRoomsByType("Suite"));
    }

    private static void dataPenyewa() {
        Scanner masukan = new Scanner(System.in);
        System.out.println("                      DATA PENYEWA                       ");
        System.out.println("---------------------------------------------------------");
        System.out.print("Masukkan Nama Anda        : ");
        String nama = masukan.next();
        System.out.print("Masukkan Alamat Anda      : ");
        String alamat = masukan.next();
        System.out.print("Masukkan NO KTP/SIM Anda  : ");
        String ktp = masukan.next();
        System.out.print("Masukkan NO Telepon Anda  : ");
        String hp = masukan.next();
        System.out.println(" PILIH KAMAR : ");
        System.out.println(" 1. Single  : Rp. 175.000,- per malam");
        System.out.println(" 2. Double  : Rp. 225.000,- per malam");
        System.out.println(" 3. Suite   : Rp. 300.000,- per malam");
        System.out.print("Pilih kode kamar [1/2/3] : ");
        int kodeKamar = masukan.nextInt();
        reservationQueue.offer(new ReservationData(nama, alamat, ktp, hp, kodeKamar, 0));
    }

    private static void dataTransaksi() {
        Scanner masukan = new Scanner(System.in);
        int single = 175000, db = 225000, st = 300000;
        int total = 0, kembali, sewa;
        System.out.println("---------------------------------------------------------");
        System.out.println("                      DATA TRANSAKSI                     ");
        System.out.println("---------------------------------------------------------");
        System.out.println("  INPUT DATA PENYEWA                                     ");
        ReservationData reservationData = reservationQueue.poll();

        System.out.println("Nama                : " + reservationData.nama());
        System.out.println("Alamat              : " + reservationData.alamat());
        System.out.println("NO KTP/SIM          : " + reservationData.ktp());
        System.out.println("NO Telepon          : " + reservationData.hp());
        System.out.println("");
        System.out.println("# Pembayaran");

        int kodeKamar = reservationData.kodeKamar();
        if (kodeKamar == 1) {
            System.out.println("Kamar yang di pesan : Single");
            System.out.println("Harga Sewa          : Rp. " + single + " per malam");
            System.out.print("Lama Sewa           : ");
            sewa = masukan.nextInt();
            reservationData = new ReservationData(reservationData.nama(), reservationData.alamat(),
                    reservationData.ktp(), reservationData.hp(), kodeKamar, sewa);
            total = sewa * single;
        } else if (kodeKamar == 2) {
            System.out.println("Kamar yang di pesan : Double");
            System.out.println("Harga Sewa          : Rp. " + db + " per malam");
            System.out.print("Lama Sewa           : ");
            sewa = masukan.nextInt();
            reservationData = new ReservationData(reservationData.nama(), reservationData.alamat(),
                    reservationData.ktp(), reservationData.hp(), kodeKamar, sewa);
            total = sewa * db;
        } else if (kodeKamar == 3) {
            System.out.println("Kamar yang di pesan : Suite");
            System.out.println("Harga Sewa          : Rp. " + st + " per malam");
            System.out.print("Lama Sewa           : ");
            sewa = masukan.nextInt();
            reservationData = new ReservationData(reservationData.nama(), reservationData.alamat(),
                    reservationData.ktp(), reservationData.hp(), kodeKamar, sewa);
            total = sewa * st;
        } else {
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

    private static int countAvailableRooms() {
        return (int) roomList.stream().filter(room -> !room.isOccupied()).count();
    }

    private static int countAvailableRoomsByType(String roomType) {
        return (int) roomList.stream()
                .filter(room -> !room.isOccupied() && room.getRoomType().equals(roomType))
                .count();
    }
}





