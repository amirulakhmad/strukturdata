public class DataMahasiswa {

    static final int MAX = 10;
    static String[] nim = new String[MAX];
    static String[] nama = new String[MAX];
    static int count = 0;

    static void menu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Insert at beginning");
        System.out.println("2. Insert at given position");
        System.out.println("3. Insert at end");
        System.out.println("4. Delete from beginning");
        System.out.println("5. Delete given position");
        System.out.println("6. Delete from end");
        System.out.println("7. Delete first occurrence");
        System.out.println("8. Show data");
        System.out.println("9. Exit");
        System.out.print("Pilih: ");
    }

    static void showData() {
        if (count == 0) {
            System.out.println("Data kosong.");
            return;
        }
        System.out.println("\nDATA MAHASISWA");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". NIM: " + nim[i] + " | Nama: " + nama[i]);
        }
    }

    public static void main(String[] args) throws Exception {

        java.io.BufferedReader br =
                new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

        int pilih;

        do {
            menu();
            pilih = Integer.parseInt(br.readLine());

            switch (pilih) {

                case 1: // Insert at beginning
                    if (count == MAX) {
                        System.out.println("Array penuh.");
                        break;
                    }
                    System.out.print("NIM: ");
                    String n = br.readLine();
                    System.out.print("Nama: ");
                    String nm = br.readLine();
                    for (int i = count; i > 0; i--) {
                        nim[i] = nim[i - 1];
                        nama[i] = nama[i - 1];
                    }
                    nim[0] = n;
                    nama[0] = nm;
                    count++;
                    System.out.println("Data berhasil ditambahkan.");
                    break;

                case 2: // Insert at position
                    if (count == MAX) {
                        System.out.println("Array penuh.");
                        break;
                    }
                    System.out.print("Masukkan posisi (1-" + (count + 1) + "): ");
                    int pos = Integer.parseInt(br.readLine()) - 1;
                    if (pos < 0 || pos > count) {
                        System.out.println("Posisi tidak valid.");
                        break;
                    }
                    System.out.print("NIM: ");
                    n = br.readLine();
                    System.out.print("Nama: ");
                    nm = br.readLine();
                    for (int i = count; i > pos; i--) {
                        nim[i] = nim[i - 1];
                        nama[i] = nama[i - 1];
                    }
                    nim[pos] = n;
                    nama[pos] = nm;
                    count++;
                    System.out.println("Data berhasil ditambahkan.");
                    break;

                case 3: // Insert at end
                    if (count == MAX) {
                        System.out.println("Array penuh.");
                        break;
                    }
                    System.out.print("NIM: ");
                    nim[count] = br.readLine();
                    System.out.print("Nama: ");
                    nama[count] = br.readLine();
                    count++;
                    System.out.println("Data berhasil ditambahkan.");
                    break;

                case 4: // Delete beginning
                    if (count == 0) {
                        System.out.println("Data kosong.");
                        break;
                    }
                    for (int i = 0; i < count - 1; i++) {
                        nim[i] = nim[i + 1];
                        nama[i] = nama[i + 1];
                    }
                    count--;
                    System.out.println("Data pertama berhasil dihapus.");
                    break;

                case 5: // Delete position
                    if (count == 0) {
                        System.out.println("Data kosong.");
                        break;
                    }
                    System.out.print("Masukkan posisi (1-" + count + "): ");
                    pos = Integer.parseInt(br.readLine()) - 1;
                    if (pos < 0 || pos >= count) {
                        System.out.println("Posisi tidak valid.");
                        break;
                    }
                    for (int i = pos; i < count - 1; i++) {
                        nim[i] = nim[i + 1];
                        nama[i] = nama[i + 1];
                    }
                    count--;
                    System.out.println("Data berhasil dihapus.");
                    break;

                case 6: // Delete end
                    if (count == 0) {
                        System.out.println("Data kosong.");
                        break;
                    }
                    count--;
                    System.out.println("Data terakhir berhasil dihapus.");
                    break;

                case 7: // Delete first occurrence
                    if (count == 0) {
                        System.out.println("Data kosong.");
                        break;
                    }
                    System.out.print("Masukkan NIM yang dicari: ");
                    String cari = br.readLine();
                    int index = -1;
                    for (int i = 0; i < count; i++) {
                        if (nim[i].equals(cari)) {
                            index = i;
                            break;
                        }
                    }
                    if (index == -1) {
                        System.out.println("Data tidak ditemukan.");
                    } else {
                        for (int i = index; i < count - 1; i++) {
                            nim[i] = nim[i + 1];
                            nama[i] = nama[i + 1];
                        }
                        count--;
                        System.out.println("Data berhasil dihapus.");
                    }
                    break;

                case 8:
                    showData();
                    break;

                case 9:
                    System.out.println("Program selesai. Terima kasih.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilih != 9);
    }
}
