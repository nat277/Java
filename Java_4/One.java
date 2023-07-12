/*
Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном 
порядке и каждый из их узлов содержит одну цифру.
1) Умножьте два числа и верните произведение в виде связанного списка.
2) Сложите два числа и верните сумму в виде связанного списка. Одно или 
два числа должны быть отрицательными.
 */

 public class One {
     String num1;
     String num2;
 
     Deque<Integer> deque1 = new ArrayDeque<>();
     Deque<Integer> deque2 = new ArrayDeque<>();
     Deque<Integer> dequeNum1 = new ArrayDeque<>();
     Deque<Integer> dequeNum2 = new ArrayDeque<>();
 
     int numInt1;
     int numInt2;
 
     private Deque<Integer> getString(String str) {
         Deque<Integer> deque = new ArrayDeque<>();
         for (int i = 0; i < str.length(); i++) {
             char symbol = str.charAt(i);
             if (symbol == '-') {
                 deque.addFirst(-1);
             } else {
                 deque.addFirst(Character.getNume(symbol));
             }
         }
         return deque;
     }
 
     private boolean getFlag(Deque<Integer> deque) {
         boolean flag;
         if (deque.getLast() == -1) {
             flag = true;
             deque.pollLast();
         } else {
             flag = false;
         }
         return flag;
     }
 
     private boolean checkN1MoreN2 (Deque<Integer> deque1, Deque<Integer> deque2) {
         boolean flag = false;
         int i = 0;
         int j = 0;
         int a1;
         int a2;
 
         Iterator<Integer> iterator1 = deque1.iterator();
         Iterator<Integer> iterator2 = deque2.iterator();;
 
         if (deque1.size() > deque2.size()) {
             return  true;
         } else if (deque1.size() == deque2.size()) {
             while (iterator1.hasNext()) {
                 i++;
                 a1 = iterator1.next();
                 while (iterator2.hasNext()) {
                     j++;
                     a2 = iterator1.next();
                     if (i == j && a1 > a2) {
                         return true;
                     }
                 }
             }
         }
         return flag;
     }
 
     public One() {
         Scanner in = new Scanner(System.in);
         System.out.println("Введите целое число n1");
         num1 = in.next();
         System.out.println("Введите целое число n2");
         num2 = in.next();
         in.close();
         dequeNum1 = getString(num1);
         dequeNum2 = getString(num2);
 
         System.out.println(dequeNum1 +  " - n1");
         System.out.println(dequeNum2 +  " - n2");
     }
 
     public void getMult() {
         LinkedList<Integer> list = new LinkedList<>();
         LinkedList<Integer> listResult = new LinkedList<>(); 
         
         deque1.addAll(dequeNum1);
         deque2.addAll(dequeNum2);
 
         int a1, a2;
         int result;
         result = 0;
 
         boolean flag1 = getFlag(deque1);
         boolean flag2 = getFiag(deque2);
 
         Iterator<Integer> iterator1;
         Iterator<Integer> iterator2;
         if (deque2.size() >= deque1.size()) {
             iterator2 = deque1.iterator();
         } else {
             iterator2 = deque2.iterator();
         }
 
         while (iterator2.hasNext()) {
             a2 = iterator2.next();
 
             if (deque2.size() >= deque1.size()) {
                 iterator1 = deque2.iterator();
             } else {
                 iterator1 = deque1.iterator();
             }
             while (iterator1.hasNext()) {
                 a1 = iterator1.next();
 
                 result += a1 * a2;
                 if (result >= 10) {
                     list.add(result % 10);
                     result = result / 10;
                     if (!iterator1.hasNext()) {
                         list.add(result);
                     }
                 } else {
                     list.add(result);
                     result = 0;
                 }
             }
 
             if (!listResult.isEmpty()) {
                 list.addFirst(0);
                 listResult.addLast(0);
 
                 int element = 0;
                 LinkedList<Integer> list_ = new LinkedList<>();
                 
                 while (!list.isEmpty()) {
                     if (!listResult.isEmpty()) {
                         element += listResult.pop() + list.pop();
                     } else {
                         element += list.pop();
                     }
                     if (element >= 10) {
                         list_.add(element % 10);
                         element /= 10;
                     } else {
                         list_.add(element);
                         element = 0;
                     }
                 }
                 while (!list_.isEmpty()) {
                     listResult.add(list_.pop());
                 }
             } else {
                 while (!list.isEmpty()) {
                     listResult.add(list.pop());
                 }
                 result = 0;
             }
         }
         if ((flag1 && !flag2) || (flag2 && !flag1)) {
             listResult.add(-1);
         }
         System.out.println(listResult + );
 
         deque1.clear();
         deque2.clear();
     }
 
     public void getSum() {
         LinkedList<Integer> listResult = new LinkedList<>();
         
         deque1.addAll(dequeNumber1);
         deque2.addAll(dequeNumber2);
 
         int result = 0;
         int i;
 
         boolean flag1 = getFlag(deque1);
         boolean flag2 = getFlag(deque2); 
         
         boolean flagN1MoreN2 = checkN1MoreN2(deque1, deque2); 
 
         if (deque1.size() > deque2.size()) {
             i = deque1.size() - deque2.size();
             while (i != 0) {
                 deque2.addLast(0);
                 i--;
             }
         } else if (deque2.size() > deque1.size()) {
             i = deque2.size() - deque1.size();
             while (i != 0) {
                 deque1.addLast(0);
                 i--;
             }
         }
 
         while (!deque1.isEmpty()) {
             if ((flag1 && !flag2) || (flag2 && !flag1)) {
                 if (flagN1MoreN2) {
                     result += deque1.pop() - deque2.pop();
                 } else {
                     result += deque2.pop() - deque1.pop();
                 }
             } else {
                 result += deque1.pop() + deque2.pop();
             }
 
             if (result >= 10) {
                 listResult.add(result % 10);
                 result /= 10;
                 if (deque1.isEmpty()) {
                     listResult.add(result);
                 }
             } else if (result < 0 && result > -10) {
                 listResult.add(10 - Math.abs(result));
                 result = -1;
             } else if (result <= -10) {
                 listResult.add(Math.abs(result) % 10);
                 result /= 10;
             } else if (result == 0) {
                 if (!deque1.isEmpty()) {
                     listResult.add(result);
                 }
             } else if (result > 0 && result < 10) {
                 listResult.add(result);
                 result = 0;
             }
         }
         while (listResult.getLast() == 0) {
             listResult.pollLast();
         }
         if ((flag1 && flag2) || (flag1 && flagN1MoreN2) || (flag2 && !flagN1MoreN2)) {
             listResult.addLast(-1);
         }
         System.out.println(listResult + ); 
         
         deque1.clear();
         deque2.clear();
     }  
 }