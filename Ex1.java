// 1) Дана строка sql-запроса "select * from students where ". 
// Сформируйте часть WHERE этого запроса, используя StringBuilder. 
// Данные для фильтрации приведены ниже в виде json-строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации:
//  {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
// Пример вывода: "select * from students WHERE name = Ivanov AND country = Russia.....".

import java.nio.file.Files;
import java.nio.file.Paths;

public class Ex1 {
    public static void main(String[] args) throws Exception{
        
        
        String file = "ex1.json";
        String json = readFileAsString(file);
        StringBuilder sb = new StringBuilder(json);
        sb.replace(0,1,"");
        sb.replace(sb.length()-1, sb.length(),"");
        String out_json = sb.toString();

        // Блок кода открывает json файл и убирает лишнее
        
        out_json = out_json.replace(':','=');
        out_json = out_json.replace('"',' ');
        String array_json [] = out_json.split(","); 
        StringBuilder json_fin = new StringBuilder();
        String sql_task = "select * from students WHERE";
        json_fin.append(sql_task);
        for (int i = 0; i < array_json.length; i++) {
            json_fin.append(array_json[i]);
            if (i != array_json.length - 1){
                json_fin.append("AND");
            }
        }

        // Блок кода парсит строку с json, заменяет все кавычки и запятые, далее преобразует в массив, и итерациями с 
        // заготовкой sql_task, собирает из массива запрос
                
        System.out.println(json_fin);
        }

    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
















}
