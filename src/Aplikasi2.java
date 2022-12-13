public class Aplikasi2 {
    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    public static void showTodoList() {
        System.out.println("TODOLIST");
        for (int i = 0; i < model.length; i++) {
            String todo = model[i];
            int no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testshowTodoList() {
        model[0] = "aaaaa";
        model[1] = "baaaa";
        model[2] = "caaaa";

        showTodoList();
    }

    public static void addTodoList(String todo) {
        boolean isFull = true;

        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testaddTodoList() {
        for (int i = 0; i < 15; i++) {
            addTodoList("Contoh todo ke-" + i);
        }

        showTodoList();
    }

    public static boolean removeTodoList(Integer number) {
        if ((number-1) > model.length) {
            return false;
        } else if (model[number-1] == null ) {
            return false;
        } else {
            for (int i = (number-1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i+1];
                }
            }
            return true;
        }
    }

    public static void testremoveTodoList() {
        addTodoList("aaaaaa");
        addTodoList("baaaaa");
        addTodoList("caaaaa");
        addTodoList("daaaaa");
        addTodoList("eaaaaa");

        var result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String input) {
        System.out.print(input + " : ");
        var data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var nama = input("Nama");
        System.out.println("Hi " + nama);
    }

    public static void viewShowTodoList() {
        while (true) {
            showTodoList();

            System.out.println("PILIH MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var pilih = input("Pilih");
            if (pilih.equals("1")) {
                viewAddTodoList();
            } else if (pilih.equals("2")) {
                viewRemoveTodoList();
            } else if (pilih.equals("x")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
            System.out.println();
        }
    }

    public static void testviewShowTodoList() {
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        viewShowTodoList();
    }

    public static void viewAddTodoList() {
        System.out.println("ADD TODO");

        var todo = input("Todo (x, jika batal)");
        if (todo.equals("x")) {
            //batal
        } else {
            addTodoList(todo);
        }
    }

    public static void testviewAddTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodoList();

        showTodoList();
    }

    public static void viewRemoveTodoList() {
        System.out.println("REMOVE TODO");

        var number = input("Number (x, jika batal)");
        if (number.equals("x")) {
            //batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus Todo " + number);
            }
        }
    }

    public static void testviewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }
}