//[Soal] Buatlah sebuah kelas utama (‘Main’) 
//yang memiliki berbagai method untuk menampilkan 
//daftar menu makanan dan minuman, menerima dan mengolah pesanan,
//menghitung total biaya pesanan, dan mencetak struk pesanan untuk tampilkan ke layar
//Import java scanner karena program memerlukan input dari pelanggan
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Inisiasi Menu Makanan dan Minuman
        Menu menuMakanan1 = new Menu("Nasi Goreng", 25000, "Makanan");
        Menu menuMakanan2 = new Menu("Nasi Bakar", 30000, "Makanan");
        Menu menuMakanan3 = new Menu("Nasi Lemak", 20000, "Makanan");
        Menu menuMakanan4 = new Menu("Nasi Padang", 35000, "Makanan");

        Menu menuMinuman1 = new Menu("Es Teh Manis", 8000, "Minuman");
        Menu menuMinuman2 = new Menu("Jus Jeruk", 10000, "Minuman");
        Menu menuMinuman3 = new Menu("Air Mineral", 12000, "Minuman");
        Menu menuMinuman4 = new Menu("Kopi Es", 15000, "Minuman");

        // Menyimpan Menu makanan dan Minuman Dalam Array yang berbeda
        Menu[] menuMakanan = {menuMakanan1, menuMakanan2, menuMakanan3, menuMakanan4};
        Menu[] menuMinuman = {menuMinuman1, menuMinuman2, menuMinuman3, menuMinuman4};

        //Method untuk Menampilkan Menu Makanan dan Minuman Berdasarkan Kategorinya
        //Disini, untuk menedapatkan nama, harga dan kategorinya maka kita
        //Pergunakan method getter yang berada pada class menu
        // Daftar menu yang akan ditampilkan kepada pelanggan
        System.out.print("Selamat Datang di Restoran Uzumaki\n");
        System.out.print("----------------------------------\n");
        System.out.print("Menu Khas Konoha yang Tersedia\n");
        System.out.print("----------------------------------\n");
        System.out.print(menuMakanan[0].getCategory());
        System.out.print("\n");
        System.out.print("1." + menuMakanan[0].getName() + "     " + menuMakanan[0].getPrice() + "  IDR");
        System.out.print("\n");
        System.out.print("2." + menuMakanan[1].getName() + "      " + menuMakanan[1].getPrice() + "  IDR");
        System.out.print("\n");
        System.out.print("3." + menuMakanan[2].getName() + "      " + menuMakanan[2].getPrice() + "  IDR");
        System.out.print("\n");
        System.out.print("4." + menuMakanan[3].getName() + "     " + menuMakanan[3].getPrice() + "  IDR");
        System.out.print("\n");
        System.out.print("----------------------------------\n");
        System.out.print(menuMinuman[0].getCategory());
        System.out.print("\n");
        System.out.print("5." + menuMinuman[0].getName() + "     " + menuMinuman[0].getPrice() + "  IDR");
        System.out.print("\n");
        System.out.print("6." + menuMinuman[1].getName() + "       " + menuMinuman[1].getPrice() + "  IDR");
        System.out.print("\n");
        System.out.print("7." + menuMinuman[2].getName() + "     " + menuMinuman[2].getPrice() + "  IDR");
        System.out.print("\n");
        System.out.print("8." + menuMinuman[3].getName() + "         " + menuMinuman[3].getPrice() + "  IDR");
        System.out.print("\n");

        //Kemudian Inisiasi Variable Penting yang akan Digunkana
        //Pada Metode Pengelolaan dan Penerimaan Pesanan Pelanggan
        Scanner scanner = new Scanner(System.in);
        int maxPesanan = 4;
        String[] pesanan = new String[maxPesanan];
        int[] jumlahPesanan = new int[maxPesanan];
        double totalBiaya = 0;
        double biayaSetelahPajakLayanan = 0;
        double biayaPajak = 0;
        double biayaPelayanan = 0;
        double biayaDiskon = 0;
        double biayaSetelahDiskon = 0;

        // Metode Untuk Mengelola Pesanan
        int jumlahPesananSekarang = 0;//Awal Pesanan adalah 0, akan terus bertambah
        //apabila pelanggan tidak input 0/selesai/jumlah pesanan melebihi batas maksimal
        int pesananKe =1;
        while (pesananKe <= maxPesanan) {
            System.out.print("\nSilahkah Masukkan Menu Pesanan Anda :\n");
            System.out.print("( Tekan 0 untuk Selesai)\n");
            System.out.print("Menu :   ");
            int nomorMenu = scanner.nextInt();

            if (nomorMenu == 0) {//Disini Program akan Terus meminta pelanggan
                //Memasukkan menu yang mereka pesan, Namun jika input 0 maka program akan berakhir 
                //dan lompat ke perintah selanjutnya.
                break; // Pelanggan selesai memesan
            }

            if (nomorMenu < 1 || nomorMenu > menuMakanan.length + menuMinuman.length) {
                System.out.println("Menu Invalid. Silakan Coba Lagi.");
                continue;//Continue disini berfungsi agar jika input melebihi panjang
                //Array makanan dan minuman, maka akan print out "menu tidak valid" kemudian
                //Melanjutkan eksekusi perintah memasukkan pesanan.
            }

            System.out.println("Masukkan QTY :   ");
            int jumlah = scanner.nextInt();

            if (jumlah <= 0) {
                System.out.println("Masukkan QTY yang Valid");
                continue;//Program akan terus mengeksekusi input qty kecuali nomor yang dimasukkan
                //kurang atau sama dengan 0
            }

            int indexMenu = nomorMenu - 1;
            if (indexMenu < menuMakanan.length) {

                pesanan[jumlahPesananSekarang] = menuMakanan[indexMenu].getName();
                jumlahPesanan[jumlahPesananSekarang] = jumlah;
                double hargaItem = menuMakanan[indexMenu].getPrice();
                double subTotal = hargaItem * jumlah;
                totalBiaya += subTotal;
            } else {
                indexMenu -= menuMakanan.length;

                pesanan[jumlahPesananSekarang] = menuMinuman[indexMenu].getName();
                jumlahPesanan[jumlahPesananSekarang] = jumlah;
                double hargaItem = menuMakanan[indexMenu].getPrice();
                double subTotal = hargaItem * jumlah;
                totalBiaya += subTotal;

            }

            jumlahPesananSekarang++;
            //Menghitung Pajak,Layanan dan Biaya Setelah Pajak + Layanan
            biayaPajak = 0.10 * totalBiaya;
            biayaPelayanan = 20000;
            biayaSetelahPajakLayanan = totalBiaya + biayaPajak + biayaPelayanan;

            if (jumlahPesananSekarang >= maxPesanan) {
                System.out.println("Gomenasai. Maksimal Pesanan 4 menu.");
                break;

            }
        }

        // Metode untuk Menampilkan Struk
        System.out.print("\n---------- Struk Pesanan----------\n");
        System.out.println("----------RESTORAN UZUMAKI--------\n");
        //Pesanan yang diinput akan dimasukkan dalam sebuah array[] pesanan
        //oleh sebab itu, untuk menampilkan nama pesanan dan jumlahnya
        //kita tinggal tuliskan array kemudian indeksnya.
        System.out.print(pesanan[0] + " " + "=" + "   " + jumlahPesanan[0] + "\n");
        System.out.print(pesanan[1] + " " + "=" + "   " + jumlahPesanan[1] + "\n");
        System.out.print(pesanan[2] + " " + "=" + "   " + jumlahPesanan[2] + "\n");
        System.out.print(pesanan[3] + " " + "=" + "   " + jumlahPesanan[3] + "\n");
        System.out.print("----------------------------------\n");
        System.out.print("Subtotal: " + "               " + +totalBiaya + " IDR" + "\n");
        System.out.print("\t Biaya Pajak: " + "    " + biayaPajak + " IDR" + "\n");
        System.out.print("\t Biaya Layanan: " + " " + biayaPelayanan + "   IDR" + "\n");
        System.out.println("----------------------------------\n");

        System.out.println("Total    :               " + biayaSetelahPajakLayanan + " IDR");

        if (biayaSetelahPajakLayanan > 100000) {
            biayaDiskon = 0.10 * biayaSetelahPajakLayanan;
            biayaSetelahDiskon = biayaSetelahPajakLayanan - biayaDiskon;
            totalBiaya = (int) biayaSetelahDiskon;
            System.out.print("Diskon   :                " + biayaDiskon + " IDR" + "\n");
            System.out.println("----------------------------------\n");
            System.out.print("GrandTotal:              " + biayaSetelahDiskon + " IDR" + "\n");

        } else {
            System.out.print("Diskon 10% Khusus Pembelian di Atas 100.000");
        }
        if (totalBiaya > 50000) {
            System.out.print("\nSelamat!\n");
            System.out.print("Mendapatkan Promo Beli 1 Minuman Gratis 1\n");
            System.out.print("Silahkan Tukar Promo di Kasir");

        }
    }
}
