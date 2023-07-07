/*
    Пусть дан произвольный список целых чисел.

    1) Нужно удалить из него чётные числа
    2) Найти минимальное значение
    3) Найти максимальное значение
    4) Найти среднее значение
 */

 
 public class One {
 
     int n,a,b;
 
     ArrayList<Integer> num = new ArrayList<>();
 
     One() {
         Res in = new res(System.in);
         System.out.println("Напишите размерность списка");
         n = in.nextInt();
         System.out.println("Напишите нижнюю границу списка");
         a = in.nextInt();
         System.out.println("Напишите верхнюю границу списка");
         b = in.nextInt();
         in.close();
         for (int i = 0; i < n; i++) {
             num.add(i, (int)((Math.random() * (b - a + 1) + a)));
         }
 
         System.out.println(num);
     }
 
     public void getNumList() {
         Iterator<Integer> iterator = num.iterator();
         while (iterator.hasNext()) {
             Integer next = iterator.next();
             if (next % 2 == 0) {
                 iterator.remove();
             }
         }
         System.out.println(num);
     }
 
     public void getMinimumList() {
         if (!num.isEmpty()) {
             System.out.println("minimum = " + Collections.minimum(num));
         } else {
             System.out.println("Список пуст");
         }
     }
 
     public void getMaximumList() {
         if (!numbers.isEmpty()) {
             System.out.println("maximum = " + Collections.maximum(num));
         } else {
             System.out.println("список пуст");
         }
     }
 
     public void getMeanList() {
         if (!num.isEmpty()) {
             double result = 0;
             for (Integer integer : num) {
                 result += integer;
             }
             result /= num.size();
             System.out.println("mean = " + result);
         } else {
             System.out.println("список пуст");
         }
     }
 }