public class AplikasiTodoList {

    // Model / representasi data-nya
    public static String[] model = new String[10];
    // Scanner
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    // main function
    public static void main(String[] args) {

        testViewShowTodoList();
    }

    // Menampilkan Todo List
    public static void showTodoList() {

        System.out.println("TODOLIST");
        for (int i = 0; i < model.length; i++) {
            String todo = model[i];
            int no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo );
            }
        }
    }

    public static void testShowTodoList() {

        model[0] = "Belajar Java Dasar";
        model[1] = "Belajar Studi Kasus Java Dasar: Todo List";
        showTodoList();
    }

    // Menambah Todo ke List
    public static void addTodoList(String todo) {

        // cek apakah model penuh?
        boolean isFull = true;
        // cek apakah isi dari array model ada yang kosong?
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                // model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        // jika penuh, kita resize ukuran array 2x lipat
        if (isFull) {
            // buat temp array
            var temp = model;
            // resize array model
            model = new String[model.length * 2];

            // masukin lagi isi array temp ke array model
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // tambahkan ke posisi yang data array nya null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }

    }

    public static void testAddTodoList() {
        for (int i = 0; i < 15; i++) {
            addTodoList("Contoh todo ke. " + i);
        }
        showTodoList();
    }

    // Menghapus Todo dari List
    public static boolean removeTodoList(Integer number) {

        // jika memasukkan angka yang lbh besar dari panjang array
        if ((number-1) >= model.length)
        {
            return false;
        }
        // jika memasukkan angka sesuai kapasitas array, tapi isi-nya memang null
        else if (model[number-1] == null)
        {
            return false;
        }
        // array ke index yang diinginkan di hapus / di null kan
        else
        {
            // ngulang data dari number yg dicari sbg index, yang mau dihapus
            for (int i = (number - 1); i < model.length; i++){
                // jika data ada di ujung array di null kan langunsg
                if (i == (model.length - 1))
                {
                    model[i] = null;

                }
                // data array dimajukan satu persatu
                else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        var result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);
    }

    // Menampilkan View Todo List
    public static void viewShowTodoList() {

        while(true) {
            showTodoList();

            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
            System.out.println();
        }
    }

    public static void testViewShowTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");
        viewShowTodoList();
    }

    // Menampilkan view menambah todo list
    public static void viewAddTodoList() {
        System.out.println("MENAMBAH TODOLIST");

        var todo = input("TODO (x Jika Batal)");

        if (todo.equals("x")) {
            // batal
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodoList();

        showTodoList();
    }

    // Menampilkan view menghapus todo list
    public static void viewRemoveTodoList() {
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Nomor TODO yg ingin dihapus (x Jika Batal)");

        if (number.equals("x")) {
            // batal
        }else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todolist: " + number);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}
