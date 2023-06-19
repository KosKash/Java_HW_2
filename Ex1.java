    
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
        json = json.replace('{',' ');
        json = json.replace('}',' ');
        json = json.replace(':','=');
        json = json.replace('"',' ');
        String array_json [] = json.split(", "); 
        
        // Считывает json, преобразует его в строку, далее убирает кавычки, и сплитует в массив

        
        StringBuilder json_fin = new StringBuilder();
        String sql_task = "select * from students WHERE";
        json_fin.append(sql_task);
        for (int i = 0; i < array_json.length; i++) {
            json_fin.append(array_json[i]);
            if (i != array_json.length - 1){
                json_fin.append("AND");
            }
        }
        // Инит стрбилд, из sql task и массива собирает запрос  

        System.out.println(json_fin);
        }

    public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
}