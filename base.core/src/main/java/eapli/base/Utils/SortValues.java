package eapli.base.Utils;

import java.util.*;

public class SortValues {


    public static <K, V> Map<K, V> sortByMaxPeriodTime(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (Comparator<Object>) (o1, o2) -> ((Comparable<V>) ((Map.Entry<K, V>) (o1)).getValue()).compareTo(((Map.Entry<K, V>) (o2)).getValue()));

        Map<K, V> result = new LinkedHashMap<>();
        for (Iterator<Map.Entry<K, V>> it = list.iterator(); it.hasNext();) {
            Map.Entry<K, V> entry = it.next();
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public static <K, V> Object colaboradorComMenosTarefasTempo(Map<K, V> map){
        if(!map.isEmpty()){
            return map.keySet().toArray()[0];
        }

        return null;
    }

}
