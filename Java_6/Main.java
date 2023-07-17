public class Main {
    public static void main(String[] args) {

        One one1 = new One (4,  128, "Windows", 14,5, "black", 37000);
        One one2 = new One (8,  256, "Windows", 14.1, "silver", 40000);
        One one3 = new One(8,  128, "Windows", 14.1, "silver", 19000);
        One one4 = new One (6,  128, "Windows", 15.1, "grey", 50000);
        One one5 = new One (8,  128, "Windows", 14.5, "silver", 18000);
        
        System.out.println();
        System.out.println(one1);
        System.out.println(one2);
        System.out.println(one3);
        System.out.println(one4);
        System.out.println(one5);
        System.out.println();

        HashMap<Integer, String> Filter = new HashMap<>();
        String input;
        System.out.println("Введите цифры, соответствующие необходимым критериям, и их минимальные значения" + "\n"+
                            "('один критерий' пробел 'минимальное значение'):" + "\n" +
                            "1 - ОЗУ" + "\n" +
                            "2 - Объем жесткого диска" + "\n" +
                            "3 - ОС" + "\n" +
                            "4 - Размер экрана" + "\n" +
                            "5 - Цвет" + "\n" +
                            "6 - Цена в рублях" + "\n" +
                            "Q - выход");
        System.out.println();
        do {
            Scanner in = new Scanner(System.in);
            input = in.nextLine();
            if (!input.equals("Q")) {
                String [] s = input.split(" ");
                Filter.put(Integer.parseInt(s[0]), s[1].toLowerCase());
            } else {
                in.close();
            }
        } while (!input.equals("Q"));
    }
}