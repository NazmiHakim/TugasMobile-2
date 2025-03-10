import java.util.Scanner

data class Karakter(val id: Int, var nama: String, var strength: Int, var speed: Int)

fun main() {
    val scanner = Scanner(System.`in`)
    val daftarKarakter = mutableListOf<Karakter>()
    var hitungId = 1

    while (true) {
        println("\nMenu CRUD Karakter")
        println("1. Tambah Karakter")
        println("2. List Karakter")
        println("3. Edit Karakter")
        println("4. Hapus Karakter")
        println("5. Tampilkan Detail Karakter")
        println("6. Keluar")
        print("Pilih menu: ")

        when (scanner.nextInt()) {
            1 -> {
                scanner.nextLine()
                print("Masukkan nama karakter: ")
                val nama = scanner.nextLine()
                print("Masukkan strength karakter: ")
                val strength = scanner.nextInt()
                print("Masukkan speed karakter: ")
                val speed = scanner.nextInt()

                daftarKarakter.add(Karakter(hitungId++, nama, strength, speed))
                println("Karakter berhasil ditambahkan!")
            }
            2 -> {
                if (daftarKarakter.isEmpty()) {
                    println("Tidak ada karakter yang tersedia.")
                } else {
                    println("\nDaftar Karakter:")
                    daftarKarakter.forEach { println("${it.id}. ${it.nama} - Strength: ${it.strength}, Speed: ${it.speed}") }
                }
            }
            3 -> {
                print("Masukkan ID karakter yang ingin diedit: ")
                val id = scanner.nextInt()
                scanner.nextLine()

                val karakter = daftarKarakter.find { it.id == id }
                karakter?.let {
                    print("Masukkan nama baru: ")
                    it.nama = scanner.nextLine()
                    print("Masukkan strength baru (angka): ")
                    it.strength = scanner.nextInt()
                    print("Masukkan speed baru (angka): ")
                    it.speed = scanner.nextInt()

                    println("Karakter berhasil diperbarui!")
                } ?: println("Karakter tidak ditemukan.")
            }
            4 -> {
                print("Masukkan ID karakter yang ingin dihapus: ")
                val id = scanner.nextInt()

                if (daftarKarakter.removeIf { it.id == id }) {
                    println("Karakter berhasil dihapus!")
                } else {
                    println("Karakter tidak ditemukan.")
                }
            }
            5 -> {
                print("Masukkan ID karakter yang ingin dilihat: ")
                val id = scanner.nextInt()

                daftarKarakter.find { it.id == id }?.run {
                    println("\nDetail Karakter:")
                    println("ID: $id")
                    println("Nama: $nama")
                    println("Strength: $strength")
                    println("Speed: $speed")
                } ?: println("Karakter tidak ditemukan.")
            }
            6 -> {
                println("Terima kasih! Keluar dari program.")
                return
            }
            else -> println("Pilihan tidak valid, coba lagi.")
        }
    }
}
