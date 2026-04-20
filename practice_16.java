import java.util.Scanner;

class Vector {
    private int[] data;
    private int size;
    private int capacity;

    public Vector() {
        capacity = 2;
        size = 0;
        data = new int[capacity];
    }

    private void resize() {
        capacity *= 2;
        int[] newData = new int[capacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    public void pushBack(int value) {
        if (size >= capacity) {
            resize();
        }
        data[size++] = value;
    }

    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            System.out.println("Помилка: неправильний індекс");
            return;
        }

        if (size >= capacity) {
            resize();
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Помилка: неправильний індекс");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Помилка: неправильний індекс");
            return -1;
        }
        return data[index];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void print() {
        if (size == 0) {
            System.out.println("Вектор порожній");
            return;
        }

        System.out.print("Елементи: ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}

public class practice_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector v = new Vector();

        int choice = -1;

        do {
            System.out.println("\n===== МЕНЮ =====");
            System.out.println("1. Додати елемент в кінець");
            System.out.println("2. Додати елемент за індексом");
            System.out.println("3. Видалити елемент за індексом");
            System.out.println("4. Отримати елемент за індексом");
            System.out.println("5. Показати всі елементи");
            System.out.println("6. Кількість елементів");
            System.out.println("7. Розмір буфера");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");

            if (!sc.hasNextInt()) {
                System.out.println("Помилка вводу!");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            int value, index;

            switch (choice) {
                case 1:
                    System.out.print("Введіть значення: ");
                    value = sc.nextInt();
                    v.pushBack(value);
                    break;

                case 2:
                    System.out.print("Введіть індекс: ");
                    index = sc.nextInt();
                    System.out.print("Введіть значення: ");
                    value = sc.nextInt();
                    v.insert(index, value);
                    break;

                case 3:
                    System.out.print("Введіть індекс: ");
                    index = sc.nextInt();
                    v.remove(index);
                    break;

                case 4:
                    System.out.print("Введіть індекс: ");
                    index = sc.nextInt();
                    int result = v.get(index);
                    if (result != -1) {
                        System.out.println("Елемент: " + result);
                    }
                    break;

                case 5:
                    v.print();
                    break;

                case 6:
                    System.out.println("Кількість елементів: " + v.getSize());
                    break;

                case 7:
                    System.out.println("Розмір буфера: " + v.getCapacity());
                    break;

                case 0:
                    System.out.println("Вихід...");
                    break;

                default:
                    System.out.println("Невірний вибір!");
            }

        } while (choice != 0);

        sc.close();
    }
}