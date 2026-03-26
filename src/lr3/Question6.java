package lr3;

import java.util.*;

public class Question6 {
    // Вариант 10: HashSet, LinkedHashMap, ArrayList
    private static final int VARIANT = 10;
    private static final int ELEMENTS = VARIANT * 1_000_000;
    private static final long GET_INDEX_POSITION = VARIANT * 1_000_000_000L;

    public static void main(String[] args) {
        System.out.println("Коллекции: HashSet, LinkedHashMap, ArrayList");
        System.out.println("Количество элементов: " + ELEMENTS);
        System.out.println("Позиция (индекс) для замера get-by-index: " + GET_INDEX_POSITION);
        System.out.println();

        testHashSet();
        testLinkedHashMap();
        testArrayList();
    }

    // ================= HASHSET =================
    private static void testHashSet() {
        System.out.println("=== HashSet ===");
        Set<Integer> set = new HashSet<>(ELEMENTS * 2);
        fillHashSet(set, ELEMENTS);

        long addStart = timeMillis(() -> set.add(-1));
        long addEnd = timeMillis(() -> set.add(-2));
        long addMiddle = timeMillis(() -> set.add(-3)); // позиция в HashSet отсутствует

        long removeStart = timeMillis(() -> removeByIndexFromSet(set, 0));
        long removeMiddle = timeMillis(() -> removeByIndexFromSet(set, set.size() / 2));
        long removeEnd = timeMillis(() -> removeByIndexFromSet(set, Math.max(0, set.size() - 1)));

        long getByIndex = timeMillis(() -> {
            int size = set.size();
            if (size == 0) {
                return;
            }
            int index = normalizeIndex(size, GET_INDEX_POSITION);
            getByIndexFromSet(set, index);
        });

        printTableLine("Добавление в начало", addStart, "эмуляция (без позиции)");
        printTableLine("Добавление в середину", addMiddle, "эмуляция (без позиции)");
        printTableLine("Добавление в конец", addEnd, "эмуляция (без позиции)");
        printTableLine("Удаление в начале", removeStart, "по индексу через итератор");
        printTableLine("Удаление в середине", removeMiddle, "по индексу через итератор");
        printTableLine("Удаление в конце", removeEnd, "по индексу через итератор");
        printTableLine("Получение по индексу", getByIndex, "через последовательный обход");
        System.out.println();
    }

    // ================= LINKEDHASHMAP =================
    private static void testLinkedHashMap() {
        System.out.println("=== LinkedHashMap ===");
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(ELEMENTS * 2);
        fillLinkedHashMap(map, ELEMENTS);

        long addStart = timeMillis(() -> putAtBeginning(map, -1, -1));
        long addMiddle = timeMillis(() -> putAtIndex(map, map.size() / 2, -2, -2));
        long addEnd = timeMillis(() -> map.put(-3, -3));

        long removeStart = timeMillis(() -> removeByIndexFromMap(map, 0));
        long removeMiddle = timeMillis(() -> removeByIndexFromMap(map, map.size() / 2));
        long removeEnd = timeMillis(() -> removeByIndexFromMap(map, Math.max(0, map.size() - 1)));

        long getByIndex = timeMillis(() -> {
            int size = map.size();
            if (size == 0) {
                return;
            }
            int index = normalizeIndex(size, GET_INDEX_POSITION);
            getByIndexFromMap(map, index);
        });

        printTableLine("Добавление в начало", addStart, "пересборка LinkedHashMap");
        printTableLine("Добавление в середину", addMiddle, "пересборка LinkedHashMap");
        printTableLine("Добавление в конец", addEnd, "обычный put");
        printTableLine("Удаление в начале", removeStart, "по индексу в порядке вставки");
        printTableLine("Удаление в середине", removeMiddle, "по индексу в порядке вставки");
        printTableLine("Удаление в конце", removeEnd, "по индексу в порядке вставки");
        printTableLine("Получение по индексу", getByIndex, "через последовательный обход");
        System.out.println();
    }

    // ================= ARRAYLIST =================
    private static void testArrayList() {
        System.out.println("=== ArrayList ===");
        ArrayList<Integer> list = new ArrayList<>(ELEMENTS + 10);
        for (int i = 0; i < ELEMENTS; i++) {
            list.add(i);
        }

        long addStart = timeMillis(() -> list.add(0, -1));
        long addMiddle = timeMillis(() -> list.add(list.size() / 2, -2));
        long addEnd = timeMillis(() -> list.add(-3));

        long removeStart = timeMillis(() -> list.remove(0));
        long removeMiddle = timeMillis(() -> list.remove(list.size() / 2));
        long removeEnd = timeMillis(() -> list.remove(list.size() - 1));

        long getByIndex = timeMillis(() -> {
            int size = list.size();
            int index = normalizeIndex(size, GET_INDEX_POSITION);
            list.get(index);
        });

        printTableLine("Добавление в начало", addStart, "поддерживается");
        printTableLine("Добавление в середину", addMiddle, "поддерживается");
        printTableLine("Добавление в конец", addEnd, "поддерживается");
        printTableLine("Удаление в начале", removeStart, "поддерживается");
        printTableLine("Удаление в середине", removeMiddle, "поддерживается");
        printTableLine("Удаление в конце", removeEnd, "поддерживается");
        printTableLine("Получение по индексу", getByIndex, "прямой доступ O(1)");
        System.out.println();
    }

    private static void fillHashSet(Set<Integer> set, int count) {
        for (int i = 0; i < count; i++) {
            set.add(i);
        }
    }

    private static void fillLinkedHashMap(LinkedHashMap<Integer, Integer> map, int count) {
        for (int i = 0; i < count; i++) {
            map.put(i, i);
        }
    }

    private static Integer getByIndexFromSet(Set<Integer> set, int index) {
        if (index < 0 || index >= set.size()) {
            return null;
        }
        int i = 0;
        for (Integer value : set) {
            if (i == index) {
                return value;
            }
            i++;
        }
        return null;
    }

    private static void removeByIndexFromSet(Set<Integer> set, int index) {
        Integer value = getByIndexFromSet(set, index);
        if (value != null) {
            set.remove(value);
        }
    }

    private static Integer getByIndexFromMap(LinkedHashMap<Integer, Integer> map, int index) {
        if (index < 0 || index >= map.size()) {
            return null;
        }
        int i = 0;
        for (Integer key : map.keySet()) {
            if (i == index) {
                return map.get(key);
            }
            i++;
        }
        return null;
    }

    private static Integer getKeyByIndexFromMap(LinkedHashMap<Integer, Integer> map, int index) {
        if (index < 0 || index >= map.size()) {
            return null;
        }
        int i = 0;
        for (Integer key : map.keySet()) {
            if (i == index) {
                return key;
            }
            i++;
        }
        return null;
    }

    private static void removeByIndexFromMap(LinkedHashMap<Integer, Integer> map, int index) {
        Integer key = getKeyByIndexFromMap(map, index);
        if (key != null) {
            map.remove(key);
        }
    }

    private static void putAtBeginning(LinkedHashMap<Integer, Integer> map, Integer key, Integer value) {
        LinkedHashMap<Integer, Integer> tmp = new LinkedHashMap<>(map.size() + 1);
        tmp.put(key, value);
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            tmp.put(e.getKey(), e.getValue());
        }
        map.clear();
        map.putAll(tmp);
    }

    private static void putAtIndex(LinkedHashMap<Integer, Integer> map, int index, Integer key, Integer value) {
        LinkedHashMap<Integer, Integer> tmp = new LinkedHashMap<>(map.size() + 1);
        int i = 0;
        boolean inserted = false;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (!inserted && i == index) {
                tmp.put(key, value);
                inserted = true;
            }
            tmp.put(e.getKey(), e.getValue());
            i++;
        }
        if (!inserted) {
            tmp.put(key, value);
        }
        map.clear();
        map.putAll(tmp);
    }

    private static long timeMillis(Runnable action) {
        long start = System.currentTimeMillis();
        action.run();
        return System.currentTimeMillis() - start;
    }

    private static int normalizeIndex(int size, long requestedIndex) {
        if (size <= 0) {
            return 0;
        }
        if (requestedIndex < 0) {
            return 0;
        }
        if (requestedIndex >= size) {
            return size - 1;
        }
        return (int) requestedIndex;
    }

    private static void printTableLine(String operation, long ms, String note) {
        System.out.printf("%-24s : %8d мс | %s%n", operation, ms, note);
    }
}