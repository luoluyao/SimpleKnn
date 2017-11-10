import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class KnnTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testKnn() throws Exception {
        List<KnnNodes> list = new ArrayList<KnnNodes>();
        String path = "E:\\luoluyao\\java\\knn\\Learned.txt";

        KnnTestInput knnTestInput = new KnnTestInput();
        Knn knn = new Knn(5);

        Node node = new Node(2.0f, 6.0f);
        knnTestInput.readData(list, path, node);
        assertEquals(knn.knn(list, node), "1");

        node = new Node(1.0f, 5.0f);
        knnTestInput = new KnnTestInput();
        knnTestInput.readData(list, path, node);
        assertEquals(knn.knn(list, node), "2");

        node = new Node(5.0f, 2.0f);
        knnTestInput = new KnnTestInput();
        knnTestInput.readData(list, path, node);
        assertEquals(knn.knn(list, node), "3");
    }
}