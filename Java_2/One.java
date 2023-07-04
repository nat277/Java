/*
1) Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого 
запроса, используя StringBuilder. Данные для фильтрации приведены ниже в виде json-строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
*/
public class One {
    String str = "\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"";

    public  String [][] getRes(String s) { 
        String [][] n = new String[2][4];
        String a = "";
        String b = "";
        int count = 2;

        for (int i = 0; i < s.length(); i++) {
            char samm = s.charAt(i);
            if (samm == '\"') {
                continue;
            } else if (samm == ':' || samm == ',') {
                count++;
                if (samm == ',') {
                   a += ' ' ; 
                }
            }
            else if (samm != ':' && count%2 == 0) {
                a += samm;

            } else if (count%2 != 0) {
                b += samm;
            }
        }
        n[0] = a.split(" ");
        n[1] = b.split(" ");

        return n;
    }

    String [][] res = getRes(str);

    public String getConclusion() {
        StringBuilder will = new StringBuilder();
        
        will.append("Where ");
        for (int i = 0; i < res[0].length; i++) {
            if (res[1][i].compareTo("null") != 0) {
                will.append(res[0][i].concat(" = ")).append(res[1][i].concat(", "));
            } else if (res[1][i].compareTo("null") == 0 && i == res[0].length - 1) {
                will.deleteCharAt(will.toString().length() - 2);
            }
        }
        return will.toString();
    }
}