MAX = 10
nim = [""] * MAX
nama = [""] * MAX
count = 0

def menu():
    print("\n====== MENU ======")
    print("1. Insert at beginning")
    print("2. Insert at given position")
    print("3. Insert at end")
    print("4. Delete from beginning")
    print("5. Delete given position")
    print("6. Delete from end")
    print("7. Delete first occurrence")
    print("8. Show data")
    print("9. Exit")
    return int(input("Pilih: "))

def show_data():
    global count
    if count == 0:
        print("Data kosong.")
        return
    print("\nDATA MAHASISWA")
    for i in range(count):
        print(f"{i+1}. NIM: {nim[i]} | Nama: {nama[i]}")

while True:
    pilih = menu()

    # 1. Insert at beginning
    if pilih == 1:
        if count == MAX:
            print("Array penuh.")
            continue
        n = input("NIM  : ").strip()
        nm = input("Nama : ").strip()
        for i in range(count, 0, -1):
            nim[i] = nim[i-1]
            nama[i] = nama[i-1]
        nim[0] = n
        nama[0] = nm
        count += 1
        print("Data berhasil ditambahkan.")

    # 2. Insert at given position
    elif pilih == 2:
        if count == MAX:
            print("Array penuh.")
            continue
        pos = int(input(f"Masukkan posisi (1-{count+1}): ")) - 1
        if pos < 0 or pos > count:
            print("Posisi tidak valid.")
            continue
        n = input("NIM  : ").strip()
        nm = input("Nama : ").strip()
        for i in range(count, pos, -1):
            nim[i] = nim[i-1]
            nama[i] = nama[i-1]
        nim[pos] = n
        nama[pos] = nm
        count += 1
        print("Data berhasil ditambahkan.")

    # 3. Insert at end
    elif pilih == 3:
        if count == MAX:
            print("Array penuh.")
            continue
        nim[count] = input("NIM  : ").strip()
        nama[count] = input("Nama : ").strip()
        count += 1
        print("Data berhasil ditambahkan.")

    # 4. Delete from beginning
    elif pilih == 4:
        if count == 0:
            print("Data kosong.")
            continue
        for i in range(count - 1):
            nim[i] = nim[i + 1]
            nama[i] = nama[i + 1]
        count -= 1
        print("Data pertama berhasil dihapus.")

    # 5. Delete given position
    elif pilih == 5:
        if count == 0:
            print("Data kosong.")
            continue
        pos = int(input(f"Masukkan posisi (1-{count}): ")) - 1
        if pos < 0 or pos >= count:
            print("Posisi tidak valid.")
            continue
        for i in range(pos, count - 1):
            nim[i] = nim[i + 1]
            nama[i] = nama[i + 1]
        count -= 1
        print("Data berhasil dihapus.")

    # 6. Delete from end
    elif pilih == 6:
        if count == 0:
            print("Data kosong.")
            continue
        count -= 1
        print("Data terakhir berhasil dihapus.")

    # 7. Delete first occurrence
    elif pilih == 7:
        if count == 0:
            print("Data kosong.")
            continue
        cari = input("Masukkan NIM yang dicari: ").strip()
        index = -1
        for i in range(count):
            if nim[i].strip() == cari:
                index = i
                break

        if index == -1:
            print("Data tidak ditemukan.")
        else:
            for i in range(index, count - 1):
                nim[i] = nim[i + 1]
                nama[i] = nama[i + 1]
            count -= 1
            print("Data berhasil dihapus.")

    # 8. Show data
    elif pilih == 8:
        show_data()

    # 9. Exit
    elif pilih == 9:
        print("Program selesai. Terima kasih.")
        break

    else:
        print("Pilihan tidak valid.")
