import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoluyao on 2017/11/10.
 */
public class KnnTestInput {
    public static void main(String[] args) {
        List<KnnNodes> list = new ArrayList<KnnNodes>();
        String path = "E:\\luoluyao\\java\\knn\\Learned.txt";
        Node node = new Node(2.0f, 7.0f);
        readData(list, path, node);
        Knn knn = new Knn(5);
        System.out.println(knn.knn(list, node));
    }

    public static void readData(List<KnnNodes> inputData, String path, Node node) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));
            String lines = bufferedReader.readLine();
            int type = 1;
            while (lines != null) {
                String[] oneType = lines.split("\\s+");
                for (int i = 0; i < oneType.length ; i += 2) {
                    float x = Float.parseFloat(oneType[i]);
                    float y = Float.parseFloat(oneType[i + 1]);
                    double dis = Math.sqrt(Math.pow(x - node.getX(), 2) + Math.pow(y - node.getY(), 2));
                    inputData.add(new KnnNodes(x, y, type + "", dis));
                }
                lines = bufferedReader.readLine();
                type++;
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
