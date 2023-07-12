/*
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре 
будут повторяющиеся имена с разными телефонами, их необходимо считать,
как одного человека с разными телефонами. Вывод должен быть отсортирован 
по убыванию числа телефонов.
 */
public class One {
    HashMap<String, ArrayList<String>> phoneHashMap = new HashMap<>();
    ArrayList<Integer> num = new ArrayList<>();

    String inputString;

    public One() {
        do {
            Scanner in = new Scanner(System.in);
            inputString = in.nextLine();
            if (!inputString.equals("Q")) {
                getBook(inputString);
            } else {
                in.close();
            }
        } while (!inputString.equals("Q"));
        System.out.println(phoneHashMap);
    }

    public void getBook(String input) {
        String[] s = input.split(" ");

        if (phoneHashMap.containsKey(s[0])) {
            phoneHashMap.get(s[0]).add(s[1]);
        } else {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(s[1]);
            phoneHashMap.put(s[0], arrayList);
        }
    }

    public void Book() {
        for (Map.Entry<String, ArrayList<String>> p : phoneHashMap.entrySet()) {
            numPhone.add(p.getValue().size());
        }

        Collections.sort(numPhone);
        Collections.reverse(numPhone);

        int i = 0;
        while (i < numPhone.size()) {
            for (Map.Entry<String, ArrayList<String>> p : phoneHashMap.entrySet()) {
                if (p.getValue().size() == numPhone.get(i)) {
                    System.out.println(p);
                    i++;
                }
                if (i == numPhone.size()) {
                    break;
                }
            }
        }
    }
}