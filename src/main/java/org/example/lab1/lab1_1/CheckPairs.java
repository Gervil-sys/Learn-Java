package org.example.lab1.lab1_1;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CheckPairs {
    //Метод
    public static boolean isBalabce(String str){
        //Создания Стэка
        Stack<Character> stack = new Stack<>();
        //Создание Мап и добавление скобок
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
        //Проходим по символу
        for (int i = 0; i < str.length(); i++){
            char current = str.charAt(i);
            //Если символ есть в Мап, то это закрывающийся
            if (pairs.containsKey(current)) {
                if (stack.isEmpty()) { //Стэк пуст
                    return  false;
                }
                //Вверхний элемент стэка
                char top = stack.peek();
                //Проверяем свопадение с открывающей и закрывающей
                if (top == pairs.get(current)) {
                    stack.pop(); //Да
                } else {
                    return false; //Нет
                }
            }
            //Открывающая идет в стэк
            else {
                stack.push(current);
            }
        }
        //Стэк пуст
        return stack.isEmpty();
    }
}
