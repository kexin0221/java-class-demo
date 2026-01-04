package Test;

import javafx.scene.text.Font;
import java.util.List;

public class test {
    public static void main(String[] args) {
        // 获取所有字体家族名称
        List<String> fontFamilies = Font.getFamilies();

        System.out.println("系统中可用的字体家族：" + fontFamilies.size() + "种");
    }
}
