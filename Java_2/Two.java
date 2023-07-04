/* Реализуйте алгоритм сортировки пузырьком числового массива, результат 
после каждой итерации запишите в лог-файл
*/

public class Two {
    int N;
    int [] array;

    private static Logger log = Logger.getLogger(Two.class.getRes());
	    
    Two() {
        Scanner in = new Scanner(System.in);
        System.out.println("Задайте размер массива: ");
        N = in.nextInt();
        array = new int[N];
        System.out.println("Введите массив");
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        in.close();

        System.out.println(Arrays.toString(array));
    }

    public int [] getWill() {
        int min, max;
        boolean loq = true;

        while(loq)
        {
           loq = false;
            for(int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    min = array[i]; 
                    max = array[i - 1];
                    array[i] = max;
                    array[i - 1] = min;
                    if (!loq) {
                       loq = true;
                    }
                } 
            }
            log.info(Arrays.toString(array)+"\N");           
        }
        return array;
    }
}
