import java.util.Arrays;

/*
 * Дана json строка { { "фамилия":"Иванов","оценка":"5","предмет":"Математика"},
 * {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
 * {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}} 
 * Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
 * Студент Иванов получил 5 по предмету Математика. 
 * Студент Петрова получил 4 по предмету Информатика. 
 * Студент Краснов получил 5 по предмету Физика. 
 * Используйте StringBuilder для подготовки ответа
Создать метод, который запишет результат работы в файл Обработайте исключения и запишите ошибки в лог файл
 */
public class jsonstr {
    public static void main(String[] args) {
        String json = "{{ \"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}, {\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}, {\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}}";
        System.out.println(json);
        String[] array = Sentence_strings(json_parse_to_array(json));
        //System.out.println(array[0]);
        // Arrays.stream(array).map(Arrays::toString).forEach(System.out::println);
        System.out.println(Arrays.deepToString(json_parse_to_array(json)));
        for (int i = 0; i < array.length; i++)
             System.out.println(array[i]);
    }
    private static String[] Sentence_strings(String[][] arraystr) {
        String[] Sentence_str = new String[arraystr.length];
        StringBuilder Newstr = new StringBuilder();
        for (int i = 0; i < arraystr.length; i++) {
            Newstr.append("Студент ");
            Newstr.append(arraystr[i][0]);
            Newstr.append(" получил  ");
            Newstr.append(arraystr[i][1]);
            Newstr.append(" по предмету ");
            Newstr.append(arraystr[i][2]);
            Sentence_str[i] = Newstr.toString();
            Newstr.delete(0, Newstr.length());
        }
        return Sentence_str;
    }

    private static String[][] json_parse_to_array(String jsnstr) {
        String line = jsnstr.substring(1, jsnstr.length() - 1);
        
        String[] jsnarray = line.split(", ");
      
        String[][] json_array = new String[jsnarray.length][3];
        for (int i = 0; i < jsnarray.length; i++) {
            line = jsnarray[i].substring(1, jsnarray[i].length() - 1);
            for (int j = 0; j < 3; j++) {
                String[] commaJsnarray = line.split(",");
                String[] colonJsnarray = commaJsnarray[j].split(":");
                json_array[i][j] = colonJsnarray[1].substring(1, colonJsnarray[1].length() - 1);

            }
        }
        return json_array;
    }
    
}
